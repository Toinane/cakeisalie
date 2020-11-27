package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MuffinsBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public MuffinsBlock(int totalBites) {
        super(totalBites);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D),
                Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D), Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D),
                Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D), Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D),
                Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D), Block.createCuboidShape(2D, 0D, 2D, 14D, 3D, 14D) };
    }
}