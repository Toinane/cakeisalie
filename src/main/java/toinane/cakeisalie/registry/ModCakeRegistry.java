package toinane.cakeisalie.registry;

import java.lang.reflect.Field;
import java.util.function.ToIntFunction;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import toinane.cakeisalie.CakeIsALie;
import toinane.cakeisalie.blocks.cakes.AnniversaryCakeBlock;
import toinane.cakeisalie.blocks.cakes.AppleCakeBlock;
import toinane.cakeisalie.blocks.cakes.BasqueCakeBlock;
import toinane.cakeisalie.blocks.cakes.BrownieBlock;
import toinane.cakeisalie.blocks.cakes.CakeBlock;
import toinane.cakeisalie.blocks.cakes.CarrotCakeBlock;
import toinane.cakeisalie.blocks.cakes.CheeseCakeBlock;
import toinane.cakeisalie.blocks.cakes.ChocolateCakeBlock;
import toinane.cakeisalie.blocks.cakes.ChocolateMousseBlock;
import toinane.cakeisalie.blocks.cakes.ChocolateRollBlock;
import toinane.cakeisalie.blocks.cakes.CookiesCakeBlock;
import toinane.cakeisalie.blocks.cakes.EnderCakeBlock;
import toinane.cakeisalie.blocks.cakes.GoldCakeBlock;
import toinane.cakeisalie.blocks.cakes.HamburgerBlock;
import toinane.cakeisalie.blocks.cakes.KhobzetBiscuitBlock;
import toinane.cakeisalie.blocks.cakes.LavaCakeBlock;
import toinane.cakeisalie.blocks.cakes.MuffinsBlock;
import toinane.cakeisalie.blocks.cakes.NordicCakeBlock;
import toinane.cakeisalie.blocks.cakes.ParisBrestBlock;
import toinane.cakeisalie.blocks.cakes.PoisonedCakeBlock;
import toinane.cakeisalie.blocks.cakes.PumpkinCakeBlock;
import toinane.cakeisalie.blocks.cakes.RedstoneCakeBlock;
import toinane.cakeisalie.blocks.cakes.SandyCakeBlock;
import toinane.cakeisalie.blocks.cakes.SlimeCakeBlock;
import toinane.cakeisalie.blocks.cakes.SpicedCakeBlock;
import toinane.cakeisalie.blocks.cakes.StarsCakeBlock;
import toinane.cakeisalie.blocks.cakes.TrappedCakeBlock;
import toinane.cakeisalie.blocks.cakes.WatermelonCakeBlock;
import toinane.cakeisalie.utils.ConfigInstance;
import toinane.cakeisalie.utils.Log;
import toinane.cakeisalie.utils.ModConfig;

public class ModCakeRegistry {

    public static CakeBlock anniversary_cake = new AnniversaryCakeBlock(4,
            FabricBlockSettings.of(Material.CAKE).strength(0.5F, 0.5F).sounds(BlockSoundGroup.WOOL).nonOpaque()
                    .luminance(createLightLevelFromBlockState(10)));
    public static CakeBlock apple_cake = new AppleCakeBlock(3);
    public static CakeBlock basque_cake = new BasqueCakeBlock(3);
    public static CakeBlock brownie = new BrownieBlock(3);
    public static CakeBlock carrot_cake = new CarrotCakeBlock(4);
    public static CakeBlock cheese_cake = new CheeseCakeBlock(7);
    public static CakeBlock chocolate_cake = new ChocolateCakeBlock(3);
    public static CakeBlock chocolate_mousse = new ChocolateMousseBlock(2);
    public static CakeBlock chocolate_roll = new ChocolateRollBlock(7);
    public static CakeBlock cookies_cake = new CookiesCakeBlock(7);
    public static CakeBlock ender_cake = new EnderCakeBlock(3);
    public static CakeBlock gold_cake = new GoldCakeBlock(3);
    public static CakeBlock hamburger = new HamburgerBlock(1);
    public static CakeBlock khobzet_biscuit = new KhobzetBiscuitBlock(3);
    public static CakeBlock lava_cake = new LavaCakeBlock(2, FabricBlockSettings.of(Material.CAKE).strength(0.5F, 0.5F)
            .sounds(BlockSoundGroup.WOOL).nonOpaque().luminance(createLightLevelFromBlockState(10)));
    public static CakeBlock muffins = new MuffinsBlock(3);
    public static CakeBlock nordic_cake = new NordicCakeBlock(3);
    public static CakeBlock paris_brest = new ParisBrestBlock(3);
    public static CakeBlock poisoned_cake = new PoisonedCakeBlock(7);
    public static CakeBlock pumpkin_cake = new PumpkinCakeBlock(4);
    public static CakeBlock redstone_cake = new RedstoneCakeBlock(4);
    public static CakeBlock sandy_cake = new SandyCakeBlock(1);
    public static CakeBlock slime_cake = new SlimeCakeBlock(2, FabricBlockSettings.of(Material.CAKE)
            .strength(0.5F, 0.5F).sounds(BlockSoundGroup.SLIME).nonOpaque().slipperiness(0.8F));
    public static CakeBlock spiced_cake = new SpicedCakeBlock(4);
    public static CakeBlock stars_cake = new StarsCakeBlock(4);
    public static CakeBlock trapped_cake = new TrappedCakeBlock(1);
    public static CakeBlock watermelon_cake = new WatermelonCakeBlock(4);

    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
        return (blockState) -> {
            return (Boolean) blockState.get(Properties.WATERLOGGED) ? 0 : litLevel;
        };
    }

    public static void registerAll() {
        try {
            for (Field field : ModCakeRegistry.class.getDeclaredFields()) {
                if (!CakeBlock.class.isAssignableFrom(field.getType()))
                    return;

                boolean active = (boolean) ConfigInstance.Cakes.class.getField(field.getName())
                        .get(ModConfig.INSTANCE.cakes);
                Identifier id = new Identifier(CakeIsALie.MOD_ID, field.getName());

                if (!active)
                    return;

                Registry.register(Registry.BLOCK, id, ((CakeBlock) field.get(null)).onRegister());
                Registry.register(Registry.ITEM, id, new BlockItem(((CakeBlock) field.get(null)).onRegister(),
                        new Item.Settings().maxCount(1).group(CakeIsALie.CAKEISALIE_GROUP)));

                Log.d("Registered cake: " + id);
            }

            BlockRenderLayerMap.INSTANCE.putBlock(slime_cake, RenderLayer.getTranslucent());
        } catch (Exception e) {
            Log.printAndPropagate(e);
        }
    }
}
