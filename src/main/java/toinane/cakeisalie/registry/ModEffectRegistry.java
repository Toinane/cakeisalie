package toinane.cakeisalie.registry;

import java.lang.reflect.Field;

import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import toinane.cakeisalie.CakeIsALie;
import toinane.cakeisalie.effects.DestructionStatusEffect;
import toinane.cakeisalie.effects.FrostWalkerStatusEffect;
import toinane.cakeisalie.effects.LavaWalkerStatusEffect;
import toinane.cakeisalie.effects.ModStatusEffect;
import toinane.cakeisalie.effects.SlimeBounceStatusEffect;
import toinane.cakeisalie.effects.SuffocationStatusEffect;
import toinane.cakeisalie.utils.Log;

public class ModEffectRegistry {

    public static ModStatusEffect destruction = new DestructionStatusEffect(StatusEffectType.HARMFUL, 0, false);
    public static ModStatusEffect frost_walker = new FrostWalkerStatusEffect(StatusEffectType.BENEFICIAL, 0, false);
    public static ModStatusEffect lava_walker = new LavaWalkerStatusEffect(StatusEffectType.BENEFICIAL, 0, false);
    public static ModStatusEffect slime_bounce = new SlimeBounceStatusEffect(StatusEffectType.BENEFICIAL, 0, false);
    public static ModStatusEffect suffocation = new SuffocationStatusEffect(StatusEffectType.HARMFUL, 0xFFBD55, false);

    public static void registerAll() {
        try {
            for (Field field : ModEffectRegistry.class.getDeclaredFields()) {
                if (!ModStatusEffect.class.isAssignableFrom(field.getType()))
                    return;

                Identifier id = new Identifier(CakeIsALie.MOD_ID, field.getName());
                Registry.register(Registry.STATUS_EFFECT, id, ((ModStatusEffect) field.get(null)).onRegister());
                Log.d("Registered effect: " + id);
            }
        } catch (Exception e) {
            Log.printAndPropagate(e);
        }
    }
}
