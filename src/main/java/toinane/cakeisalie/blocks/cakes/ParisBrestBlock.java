package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ParisBrestBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public ParisBrestBlock(int totalBites) {
        super(totalBites);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(0D, 0D, 0D, 16D, 5D, 16D),
                Block.createCuboidShape(5D, 0D, 0D, 16D, 5D, 16D), Block.createCuboidShape(9D, 0D, 0D, 16D, 5D, 16D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
    }
}