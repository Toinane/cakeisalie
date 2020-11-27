package toinane.cakeisalie.blocks.cakes;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class KhobzetBiscuitBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    Random random = new Random();

    public KhobzetBiscuitBlock(int totalBites) {
        super(totalBites);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getHungerManager().add(1, 0.1F);
        player.setAir(player.getMaxAir());

        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(WATERLOGGED))
            return;

        world.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, pos.getX() + this.random.nextDouble() * 1D, pos.getY() + 0.3D,
                pos.getZ() + this.random.nextDouble() * 1D, 0.0D, 0.0D, 0.0D);
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 4D, 15D),
                Block.createCuboidShape(7D, 0D, 1D, 15D, 4D, 15D), Block.createCuboidShape(13D, 0D, 1D, 15D, 4D, 15D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
    }

}
