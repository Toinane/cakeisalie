package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ChocolateRollBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public ChocolateRollBlock(int totalBites) {
        super(totalBites);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getHungerManager().add(2, 0.1F);

        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 4D, 15D, 7D, 12D),
                Block.createCuboidShape(3D, 0D, 4D, 15D, 7D, 12D), Block.createCuboidShape(5D, 0D, 4D, 15D, 7D, 12D),
                Block.createCuboidShape(7D, 0D, 4D, 15D, 7D, 12D), Block.createCuboidShape(9D, 0D, 4D, 15D, 7D, 12D),
                Block.createCuboidShape(11D, 0D, 4D, 15D, 7D, 12D),
                Block.createCuboidShape(13D, 0D, 4D, 15D, 7D, 12D) };
    }
}