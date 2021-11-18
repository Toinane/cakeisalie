package toinane.cakeisalie;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import toinane.cakeisalie.registry.ModBlockRegistry;
import toinane.cakeisalie.registry.ModCakeRegistry;
import toinane.cakeisalie.registry.ModEffectRegistry;
import toinane.cakeisalie.utils.ModConfig;

public class CakeIsALie implements ModInitializer {

        public static final String MOD_ID = "cakeisalie";
        public static final String MOD_NAME = "CakeIsALie";

        public static final ItemGroup CAKEISALIE_GROUP = FabricItemGroupBuilder
                        .build(new Identifier(CakeIsALie.MOD_ID, "creative_tab"), () -> new ItemStack(Items.CAKE));

        @Override
        public void onInitialize() {
                ModConfig.init();
                ModBlockRegistry.registerAll();
                ModCakeRegistry.registerAll();
                ModEffectRegistry.registerAll();
        }

}