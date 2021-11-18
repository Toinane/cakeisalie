package toinane.cakeisalie.blocks.cakes;

import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion.DestructionType;

public class TrappedCakeBlock extends CakeBlock {

    public TrappedCakeBlock(int totalBites) {
        super(totalBites);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getHungerManager().add(2, 0.1F);

        if (!world.isClient()) {
            DestructionType destructionType = world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)
                    ? DestructionType.DESTROY
                    : DestructionType.NONE;
            world.createExplosion(player, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), 4F,
                    destructionType);
            player.damage(DamageSource.explosion(player), Float.MAX_VALUE);
        }

        return ActionResult.SUCCESS;
    }
}