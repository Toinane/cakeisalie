package toinane.cakeisalie.blocks.cakes;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CakeBlock extends Block implements Waterloggable {

    public static final IntProperty BITES;
    protected static final VoxelShape[] BITES_TO_SHAPE;
    public static final BooleanProperty WATERLOGGED;

    protected int maxBites;
    private boolean isRegistered = false;

    public CakeBlock(int totalBites, FabricBlockSettings settings) {
        super(settings);

        setDefaultState(getStateManager().getDefaultState().with(BITES, 0).with(WATERLOGGED, false));
        this.maxBites = totalBites;
    }

    public CakeBlock(int totalBites) {
        super(FabricBlockSettings.of(Material.CAKE).strength(0.5F, 0.5F).sounds(BlockSoundGroup.WOOL).nonOpaque());

        setDefaultState(getStateManager().getDefaultState().with(BITES, 0).with(WATERLOGGED, false));
        this.maxBites = totalBites;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        if (world.isClient) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (this.tryEat(world, pos, state, player) == ActionResult.SUCCESS) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return this.tryEat(world, pos, state, player);
    }

    private ActionResult tryEat(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false))
            return ActionResult.PASS;
        player.incrementStat(Stats.EAT_CAKE_SLICE);

        this.setEffectForCake(world, pos, state, player);

        int i = (Integer) state.get(BITES);
        if (i < this.maxBites - 1)
            world.setBlockState(pos, (BlockState) state.with(BITES, i + 1), 3);
        else
            world.removeBlock(pos, false);

        return ActionResult.SUCCESS;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState,
            World world, BlockPos pos, BlockPos neighborPos) {
        if (facing == Direction.DOWN && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if ((Boolean) state.get(WATERLOGGED)) {
                world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }

            return super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getMaterial().isSolid();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES, WATERLOGGED);
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (7 - (Integer) state.get(BITES)) * 2;
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldAccess worldAccess = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        boolean bl = worldAccess.getFluidState(blockPos).getFluid() == Fluids.WATER;
        return this.getDefaultState().with(WATERLOGGED, bl);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean) state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getHungerManager().add(2, 0.1F);

        return ActionResult.SUCCESS;
    }

    public CakeBlock onRegister() {
        isRegistered = true;
        return this;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public BlockState getState() {
        return this.getDefaultState();
    }

    static {
        BITES = Properties.BITES;
        WATERLOGGED = Properties.WATERLOGGED;
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(3D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(5D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(7D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(9D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(11D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(13D, 0D, 1D, 15D, 8D, 15D) };
    }
}
