package toinane.cakeisalie.blocks.cakes;

import java.util.stream.Stream;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import toinane.cakeisalie.registry.ModCakeRegistry;
import toinane.cakeisalie.registry.ModEffectRegistry;
import toinane.cakeisalie.registry.ModParticleRegistry;

public class LavaCakeBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public LavaCakeBlock(int totalBites, FabricBlockSettings settings) {
        super(totalBites, settings);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1800, 4));
        player.addStatusEffect(new StatusEffectInstance(ModEffectRegistry.lava_walker, 1800, 0));
        player.getHungerManager().add(2, 0.1F);

        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    protected static boolean isInWater(BlockState state, BlockView world, BlockPos pos) {
        if ((Boolean) state.get(WATERLOGGED)) {
            return true;
        } else {
            Direction[] var3 = Direction.values();
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                Direction direction = var3[var5];
                if (world.getFluidState(pos.offset(direction)).isIn(FluidTags.WATER)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (shouldHarden(world, pos, state))
            this.transformToRedstoneCake(state, world, pos);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState,
            WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return hardensOnAnySide(world, pos) ? this.getHardenCake(state, world, pos)
                : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    private static boolean shouldHarden(BlockView world, BlockPos pos, BlockState state) {
        return hardensIn(state) || hardensOnAnySide(world, pos);
    }

    private static boolean hardensOnAnySide(BlockView world, BlockPos pos) {
        boolean bl = false;
        BlockPos.Mutable mutable = pos.mutableCopy();
        Direction[] var4 = Direction.values();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Direction direction = var4[var6];
            BlockState blockState = world.getBlockState(mutable);
            if (direction != Direction.DOWN || hardensIn(blockState)) {
                mutable.set(pos, direction);
                blockState = world.getBlockState(mutable);
                if (hardensIn(blockState) && !blockState.isSideSolidFullSquare(world, pos, direction.getOpposite())) {
                    bl = true;
                    break;
                }
            }
        }

        return bl;
    }

    private static boolean hardensIn(BlockState state) {
        return state.getFluidState().isIn(FluidTags.WATER);
    }

    public BlockState getHardenCake(BlockState state, WorldAccess world, BlockPos pos) {
        this.showTransformParticles(world, pos);
        return ModCakeRegistry.redstone_cake.getDefaultState();
    }

    private void showTransformParticles(WorldAccess world, BlockPos pos) {
        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching((World) world, pos);
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
        passedData.writeBlockPos(pos);

        watchingPlayers.forEach(watchingPlayer -> ServerSidePacketRegistry.INSTANCE.sendToPlayer(watchingPlayer,
                ModParticleRegistry.LAVA_CAKE_PARTICLE_ID, passedData));
    }

    public void transformToRedstoneCake(BlockState state, WorldAccess world, BlockPos pos) {
        if (world.isClient())
            return;

        BlockState redstoneCakeState = ModCakeRegistry.redstone_cake.getDefaultState();
        if (world.canPlace(redstoneCakeState, pos, ShapeContext.absent())) {
            world.setBlockState(pos, redstoneCakeState, 1);
            this.showTransformParticles(world, pos);
        }
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(9D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
    }
}