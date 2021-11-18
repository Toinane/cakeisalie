package toinane.cakeisalie.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class SuffocationStatusEffect extends ModStatusEffect {
    public SuffocationStatusEffect(StatusEffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 30 == 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.world.isClient)
            return;

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            player.getHungerManager().addExhaustion(-5f);
            player.stopUsingItem();
            player.dropItem(Items.SAND, 1);
            player.damage(DamageSource.STARVE, 0.1F);
        } else {
            entity.damage(DamageSource.STARVE, 0.1F);
            entity.dropItem(Items.SAND, 1);
        }
    }
}