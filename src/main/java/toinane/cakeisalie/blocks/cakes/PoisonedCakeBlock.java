package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PoisonedCakeBlock extends CakeBlock {

    public PoisonedCakeBlock(int totalBites) {
        super(totalBites);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 0));
        player.getHungerManager().add(2, 0.1F);

        return ActionResult.SUCCESS;
    }
}