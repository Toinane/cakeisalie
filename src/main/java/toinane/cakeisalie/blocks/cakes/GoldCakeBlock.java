package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GoldCakeBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public GoldCakeBlock(int totalBites) {
        super(totalBites);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.heal(5F);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 4));

        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(7D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(13D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
    }
}