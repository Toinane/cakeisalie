package toinane.cakeisalie.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class ModStatusEffect extends StatusEffect {

    private boolean instant;
    private boolean isRegistered = false;

    public ModStatusEffect(StatusEffectType type, int color, boolean isInstant) {
        super(type, color);
        this.instant = isInstant;
    }

    @Override
    public boolean isInstant() {
        return this.instant;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    }

    public ModStatusEffect onRegister() {
        isRegistered = true;
        return this;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

}
