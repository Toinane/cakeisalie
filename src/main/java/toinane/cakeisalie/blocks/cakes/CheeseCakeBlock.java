package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CheeseCakeBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public CheeseCakeBlock(int totalBites) {
        super(totalBites);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 5D, 15D),
                Block.createCuboidShape(3D, 0D, 1D, 15D, 5D, 15D), Block.createCuboidShape(5D, 0D, 1D, 15D, 5D, 15D),
                Block.createCuboidShape(7D, 0D, 1D, 15D, 5D, 15D), Block.createCuboidShape(9D, 0D, 1D, 15D, 5D, 15D),
                Block.createCuboidShape(11D, 0D, 1D, 15D, 5D, 15D),
                Block.createCuboidShape(13D, 0D, 1D, 15D, 5D, 15D) };
    }
}