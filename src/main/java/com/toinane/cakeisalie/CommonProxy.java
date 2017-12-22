package com.toinane.cakeisalie;

import com.toinane.cakeisalie.block.BlockCakes;
import com.toinane.cakeisalie.item.ItemPotionCakes;
import com.toinane.cakeisalie.item.ItemBlockCakes;
import com.toinane.cakeisalie.potion.PotionCake;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy {
	
	public static CakeTab cake_tab = new CakeTab("cake_tab");
	
	public static Block block_chocolate_cake 		= new BlockCakes("chocolate_cake", 3)	.setRegistryName("block_chocolate_cake")		.setUnlocalizedName("chocolate_cake")	.setHardness(0.5F);
	public static Block block_apple_cake 			= new BlockCakes("apple_cake", 3)		.setRegistryName("block_apple_cake")			.setUnlocalizedName("apple_cake")		.setHardness(0.5F);
	public static Block block_gold_cake 			= new BlockCakes("gold_cake", 3)		.setRegistryName("block_gold_cake")				.setUnlocalizedName("gold_cake")			.setHardness(0.5F);
	public static Block block_trapped_cake 			= new BlockCakes("trapped_cake", 1)		.setRegistryName("block_trapped_cake")			.setUnlocalizedName("trapped_cake")			.setHardness(0.5F);
	public static Block block_poisoned_cake 		= new BlockCakes("poisoned_cake", 7)	.setRegistryName("block_poisoned_cake")			.setUnlocalizedName("poisoned_cake")		.setHardness(0.5F);
	public static Block block_lava_cake 			= new BlockCakes("lava_cake", 2)		.setRegistryName("block_lava_cake")				.setUnlocalizedName("lava_cake")			.setHardness(0.5F);
	public static Block block_basque_cake 			= new BlockCakes("basque_cake", 3)		.setRegistryName("block_basque_cake")			.setUnlocalizedName("basque_cake")			.setHardness(0.5F);
	public static Block block_redstone_cake 		= new BlockCakes("redstone_cake", 4)	.setRegistryName("block_redstone_cake")			.setUnlocalizedName("redstone_cake")		.setHardness(0.5F);
	public static Block block_brownie 				= new BlockCakes("brownie", 3)			.setRegistryName("block_brownie")				.setUnlocalizedName("brownie")				.setHardness(0.5F);
	public static Block block_chocolate_mousse 		= new BlockCakes("chocolate_mousse", 2)	.setRegistryName("block_chocolate_mousse")		.setUnlocalizedName("chocolate_mousse")		.setHardness(0.5F);
	public static Block block_cookies_cake 			= new BlockCakes("cookies_cake", 7)		.setRegistryName("block_cookies_cake")			.setUnlocalizedName("cookies_cake")			.setHardness(0.5F);
	public static Block block_ender_cake 			= new BlockCakes("ender_cake", 3)		.setRegistryName("block_ender_cake")			.setUnlocalizedName("ender_cake")			.setHardness(0.5F);
	public static Block block_pumpkin_cake 			= new BlockCakes("pumpkin_cake", 4)		.setRegistryName("block_pumpkin_cake")			.setUnlocalizedName("pumpkin_cake")			.setHardness(0.5F);
	public static Block block_spiced_cake 			= new BlockCakes("spiced_cake", 4)		.setRegistryName("block_spiced_cake")			.setUnlocalizedName("spiced_cake")			.setHardness(0.5F);
	public static Block block_sandy_cake 			= new BlockCakes("sandy_cake", 1)		.setRegistryName("block_sandy_cake")			.setUnlocalizedName("sandy_cake")			.setHardness(0.5F);
	public static Block block_stars_cake 			= new BlockCakes("stars_cake", 4)		.setRegistryName("block_stars_cake")			.setUnlocalizedName("stars_cake")			.setHardness(0.5F);
	public static Block block_watermelon_cake 		= new BlockCakes("watermelon_cake", 4)	.setRegistryName("block_watermelon_cake")		.setUnlocalizedName("watermelon_cake")		.setHardness(0.5F);
	public static Block block_nordic_cake 			= new BlockCakes("nordic_cake", 3)		.setRegistryName("block_nordic_cake")			.setUnlocalizedName("nordic_cake")			.setHardness(0.5F);
	public static Block block_anniversary_cake 		= new BlockCakes("anniversary_cake", 4)	.setRegistryName("block_anniversary_cake")		.setUnlocalizedName("anniversary_cake")		.setHardness(0.5F).setLightLevel(0.8F);
	public static Block block_paris_brest 			= new BlockCakes("paris_brest", 3)		.setRegistryName("block_paris_brest")			.setUnlocalizedName("paris_brest")			.setHardness(0.5F);
	public static Block block_hamburger 			= new BlockCakes("hamburger", 1)		.setRegistryName("block_hamburger")				.setUnlocalizedName("hamburger")			.setHardness(0.5F);
	public static Block block_cheese_cake 			= new BlockCakes("cheese_cake", 7)		.setRegistryName("block_cheese_cake")			.setUnlocalizedName("cheese_cake")			.setHardness(0.5F);
	public static Block block_chocolate_roll 		= new BlockCakes("chocolate_roll", 7)	.setRegistryName("block_chocolate_roll")		.setUnlocalizedName("chocolate_roll")		.setHardness(0.5F);
	public static Block block_carrot_cake 			= new BlockCakes("carrot_cake", 4)		.setRegistryName("block_carrot_cake")			.setUnlocalizedName("carrot_cake")			.setHardness(0.5F);
	public static Block block_slime_cake 			= new BlockCakes("slime_cake", 2)		.setRegistryName("block_slime_cake")			.setUnlocalizedName("slime_cake")			.setHardness(0.5F);
	public static Block block_muffins 				= new BlockCakes("muffins", 3)			.setRegistryName("block_muffins")				.setUnlocalizedName("muffins")				.setHardness(0.5F);

	public static Item chocolate_cake 		= new ItemBlockCakes(block_chocolate_cake)		.setMaxStackSize(1)		.setRegistryName("chocolate_cake")		.setUnlocalizedName("chocolate_cake");
	public static Item apple_cake 			= new ItemBlockCakes(block_apple_cake)			.setMaxStackSize(1)		.setRegistryName("apple_cake")			.setUnlocalizedName("apple_cake");
	public static Item gold_cake 			= new ItemBlockCakes(block_gold_cake)			.setMaxStackSize(1)		.setRegistryName("gold_cake")			.setUnlocalizedName("gold_cake");
	public static Item trapped_cake 		= new ItemBlockCakes(block_trapped_cake)		.setMaxStackSize(1)		.setRegistryName("trapped_cake")		.setUnlocalizedName("trapped_cake");
	public static Item poisoned_cake 		= new ItemBlockCakes(block_poisoned_cake)		.setMaxStackSize(1)		.setRegistryName("poisoned_cake")		.setUnlocalizedName("poisoned_cake");
	public static Item lava_cake 			= new ItemBlockCakes(block_lava_cake)			.setMaxStackSize(1)		.setRegistryName("lava_cake")			.setUnlocalizedName("lava_cake");
	public static Item basque_cake 			= new ItemBlockCakes(block_basque_cake)			.setMaxStackSize(1)		.setRegistryName("basque_cake")			.setUnlocalizedName("basque_cake");
	public static Item redstone_cake 		= new ItemBlockCakes(block_redstone_cake)		.setMaxStackSize(1)		.setRegistryName("redstone_cake")		.setUnlocalizedName("redstone_cake");
	public static Item brownie 				= new ItemBlockCakes(block_brownie)				.setMaxStackSize(1)		.setRegistryName("brownie")				.setUnlocalizedName("brownie");
	public static Item chocolate_mousse 	= new ItemBlockCakes(block_chocolate_mousse)	.setMaxStackSize(1)		.setRegistryName("chocolate_mousse")	.setUnlocalizedName("chocolate_mousse");
	public static Item cookies_cake 		= new ItemBlockCakes(block_cookies_cake)		.setMaxStackSize(1)		.setRegistryName("cookies_cake")		.setUnlocalizedName("cookies_cake");
	public static Item ender_cake 			= new ItemBlockCakes(block_ender_cake)			.setMaxStackSize(1)		.setRegistryName("ender_cake")			.setUnlocalizedName("ender_cake");
	public static Item pumpkin_cake 		= new ItemBlockCakes(block_pumpkin_cake)		.setMaxStackSize(1)		.setRegistryName("pumpkin_cake")		.setUnlocalizedName("pumpkin_cake");
	public static Item spiced_cake 			= new ItemBlockCakes(block_spiced_cake)			.setMaxStackSize(1)		.setRegistryName("spiced_cake")			.setUnlocalizedName("spiced_cake");
	public static Item sandy_cake 			= new ItemBlockCakes(block_sandy_cake)			.setMaxStackSize(1)		.setRegistryName("sandy_cake")			.setUnlocalizedName("sandy_cake");
	public static Item stars_cake 			= new ItemBlockCakes(block_stars_cake)			.setMaxStackSize(1)		.setRegistryName("stars_cake")			.setUnlocalizedName("stars_cake");
	public static Item watermelon_cake 		= new ItemBlockCakes(block_watermelon_cake)		.setMaxStackSize(1)		.setRegistryName("watermelon_cake")		.setUnlocalizedName("water-melon_cake");
	public static Item nordic_cake 			= new ItemBlockCakes(block_nordic_cake)			.setMaxStackSize(1)		.setRegistryName("nordic_cake")			.setUnlocalizedName("nordic_cake");
	public static Item anniversary_cake 	= new ItemBlockCakes(block_anniversary_cake)	.setMaxStackSize(1)		.setRegistryName("anniversary_cake")	.setUnlocalizedName("anniversary_cake");
	public static Item paris_brest 			= new ItemBlockCakes(block_paris_brest)			.setMaxStackSize(1)		.setRegistryName("paris_brest")			.setUnlocalizedName("paris_brest"); 
	public static Item hamburger 			= new ItemBlockCakes(block_hamburger)			.setMaxStackSize(1)		.setRegistryName("hamburger")			.setUnlocalizedName("hamburger");
	public static Item cheese_cake 			= new ItemBlockCakes(block_cheese_cake)			.setMaxStackSize(1)		.setRegistryName("cheese_cake")			.setUnlocalizedName("cheese_cake");
	public static Item chocolate_roll 		= new ItemBlockCakes(block_chocolate_roll)		.setMaxStackSize(1)		.setRegistryName("chocolate_roll")		.setUnlocalizedName("chocolate_roll");
	public static Item carrot_cake 			= new ItemBlockCakes(block_carrot_cake)			.setMaxStackSize(1)		.setRegistryName("carrot_cake")			.setUnlocalizedName("carrot_cake");
	public static Item slime_cake 			= new ItemBlockCakes(block_slime_cake)			.setMaxStackSize(1)		.setRegistryName("slime_cake")			.setUnlocalizedName("slime_cake");
	public static Item muffins 				= new ItemBlockCakes(block_muffins)				.setMaxStackSize(1)		.setRegistryName("muffins")				.setUnlocalizedName("muffins");
	
	public static Item potion_hunger 	= new ItemPotionCakes("hunger", false)	.setMaxStackSize(16)	.setRegistryName("potion_hunger")	.setUnlocalizedName("hunger_potion");
	public static Item potion_sandy 	= new ItemPotionCakes("sandy", false)	.setMaxStackSize(16)	.setRegistryName("potion_sandy")	.setUnlocalizedName("sandy_potion");
	public static Item potion_nordic 	= new ItemPotionCakes("nordic", false)	.setMaxStackSize(16)	.setRegistryName("potion_nordic")	.setUnlocalizedName("nordic_potion");
	public static Item potion_creep 	= new ItemPotionCakes("creep", false)	.setMaxStackSize(16)	.setRegistryName("potion_creep")	.setUnlocalizedName("creep_potion");
	public static Item potion_slime 	= new ItemPotionCakes("slime", false)	.setMaxStackSize(16)	.setRegistryName("potion_slime")	.setUnlocalizedName("slime_potion");
	public static Item splash_hunger 	= new ItemPotionCakes("hunger", true)	.setMaxStackSize(16)	.setRegistryName("splash_hunger")	.setUnlocalizedName("hunger_splash_potion");
	public static Item splash_sandy 	= new ItemPotionCakes("sandy", true)	.setMaxStackSize(16)	.setRegistryName("splash_sandy")	.setUnlocalizedName("sandy_splash_potion");
	public static Item splash_nordic 	= new ItemPotionCakes("nordic", true)	.setMaxStackSize(16)	.setRegistryName("splash_nordic")	.setUnlocalizedName("nordic_splash_potion");
	public static Item splash_creep 	= new ItemPotionCakes("creep", true)	.setMaxStackSize(16)	.setRegistryName("splash_creep")	.setUnlocalizedName("creep_splash_potion");
	public static Item splash_slime 	= new ItemPotionCakes("slime", true)	.setMaxStackSize(16)	.setRegistryName("splash_slime")	.setUnlocalizedName("slime_splash_potion");
	
	public static Potion potionSandy 	= new PotionCake(new ResourceLocation("sandy_potion")	, false, 0).setIconIndex(0, 0)	.setPotionName("potion.Sandy_potion");
	public static Potion potionNordic 	= new PotionCake(new ResourceLocation("nordic_potion")	, false, 0).setIconIndex(1, 0)	.setPotionName("potion.Nordic_potion");
	public static Potion potionCreep 	= new PotionCake(new ResourceLocation("creep_potion")	, false, 0).setIconIndex(2, 0)	.setPotionName("potion.Creep_potion");
	public static Potion potionSlime 	= new PotionCake(new ResourceLocation("slime_potion")	, false, 0).setIconIndex(3, 0)	.setPotionName("potion.Slime_potion");

	private static Block[] blocks = {
			block_chocolate_cake,
			block_apple_cake,
			block_gold_cake,
			block_trapped_cake,
			block_poisoned_cake,
			block_lava_cake,
			block_basque_cake,
			block_redstone_cake,
			block_brownie,
			block_chocolate_mousse,
			block_cookies_cake,
			block_ender_cake,
			block_pumpkin_cake,
			block_spiced_cake,
			block_sandy_cake,
			block_stars_cake,
			block_watermelon_cake,
			block_nordic_cake,
			block_anniversary_cake,
			block_paris_brest,
			block_hamburger,
			block_cheese_cake,
			block_chocolate_roll,
        	block_carrot_cake,
        	block_slime_cake,
        	block_muffins
        };
        
        private static Item[] items = {
    		chocolate_cake,
    		apple_cake,
    		gold_cake,
    		trapped_cake,
    		poisoned_cake,
    		lava_cake,
    		basque_cake,
    		redstone_cake,
    		brownie,
    		chocolate_mousse,
    		cookies_cake,
    		ender_cake,
    		pumpkin_cake,
    		spiced_cake,
    		sandy_cake,
    		stars_cake,
    		watermelon_cake,
    		nordic_cake,
    		anniversary_cake,
    		paris_brest,
    		hamburger,
    		cheese_cake,
    		chocolate_roll,
    		carrot_cake,
    		slime_cake,
    		muffins,
    		potion_hunger,
    		potion_sandy,
    		potion_nordic,
    		potion_creep,
    		potion_slime,
    		splash_hunger,
    		splash_sandy,
    		splash_nordic,
    		splash_creep,
    		splash_slime
        };
	
	/**
	 * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
	 */
	public void preInit() {
	}
	
	@Mod.EventBusSubscriber(modid = CakeIsALie.MODID)
    public static class Registration
    {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            for (Block block : blocks)
                event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            for (Item item : items)
            	event.getRegistry().register(item);
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {

            B3DLoader.INSTANCE.addDomain(CakeIsALie.MODID.toLowerCase());
            OBJLoader.INSTANCE.addDomain(CakeIsALie.MODID.toLowerCase());
            for (Block block : blocks)
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
            for (Item item : items)
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

	public void init() {
		BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(Items.CLAY_BALL, 1)	, new ItemStack(potion_hunger, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(sandy_cake, 1)		, new ItemStack(potion_sandy, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(anniversary_cake, 1), new ItemStack(potion_creep, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(nordic_cake, 1)		, new ItemStack(potion_nordic, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(slime_cake, 1)		, new ItemStack(potion_slime, 1));
//    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_hunger, 1)		, new ItemStack(Items.gunpowder, 1)	, new ItemStack(splash_hunger, 1));
//    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_sandy, 1)		, new ItemStack(Items.gunpowder, 1)	, new ItemStack(splash_sandy, 1));
//    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_creep, 1)		, new ItemStack(Items.gunpowder, 1)	, new ItemStack(splash_creep, 1));
//    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_nordic, 1)		, new ItemStack(Items.gunpowder, 1)	, new ItemStack(splash_nordic, 1));
//    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_slime, 1)		, new ItemStack(Items.gunpowder, 1)	, new ItemStack(splash_slime, 1));
	}

	public void postInit() {
	}

	abstract public boolean playerIsInCreativeMode(EntityPlayer player);
	abstract public boolean isDedicatedServer();
}