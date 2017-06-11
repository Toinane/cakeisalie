package com.toinane.cakeisalie;

import com.toinane.cakeisalie.block.BlockMultipleCake;
import com.toinane.cakeisalie.item.ItemCakePotion;
import com.toinane.cakeisalie.item.ItemMultipleCake;
import com.toinane.cakeisalie.potion.PotionCake;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy {
	
	public static CakeTab cake_tab = new CakeTab("cake_tab");
	
	public static Block chocolate_cake 		= new BlockMultipleCake("chocolate_cake", 3)	.setRegistryName("chocolate_cake")		.setUnlocalizedName("chocolate_cake")	.setHardness(0.5F);
	public static Block apple_cake 			= new BlockMultipleCake("apple_cake", 3)		.setRegistryName("apple_cake")			.setUnlocalizedName("apple_cake")		.setHardness(0.5F);
	public static Block gold_cake 			= new BlockMultipleCake("gold_cake", 3)			.setRegistryName("gold_cake")			.setUnlocalizedName("gold_cake")		.setHardness(0.5F);
	public static Block trapped_cake 		= new BlockMultipleCake("trapped_cake", 1)		.setRegistryName("trapped_cake")		.setUnlocalizedName("trapped_cake")		.setHardness(0.5F);
	public static Block poisoned_cake 		= new BlockMultipleCake("poisoned_cake", 6)		.setRegistryName("poisoned_cake")		.setUnlocalizedName("poisoned_cake")	.setHardness(0.5F);
	public static Block lava_cake 			= new BlockMultipleCake("lava_cake", 2)			.setRegistryName("lava_cake")			.setUnlocalizedName("lava_cake")		.setHardness(0.5F);
	public static Block basque_cake 		= new BlockMultipleCake("basque_cake", 3)		.setRegistryName("basque_cake")			.setUnlocalizedName("basque_cake")		.setHardness(0.5F);
	public static Block redstone_cake 		= new BlockMultipleCake("redstone_cake", 4)		.setRegistryName("redstone_cake")		.setUnlocalizedName("redstone_cake")	.setHardness(0.5F);
	public static Block brownie 			= new BlockMultipleCake("brownie", 3)			.setRegistryName("brownie")				.setUnlocalizedName("brownie")			.setHardness(0.5F);
	public static Block chocolate_mousse 	= new BlockMultipleCake("chocolate_mousse", 2)	.setRegistryName("chocolate_mousse")	.setUnlocalizedName("chocolate_mousse")	.setHardness(0.5F);
	public static Block cookies_cake 		= new BlockMultipleCake("cookies_cake", 6)		.setRegistryName("cookies_cake")		.setUnlocalizedName("cookies_cake")		.setHardness(0.5F);
	public static Block ender_cake 			= new BlockMultipleCake("ender_cake", 3)		.setRegistryName("ender_cake")			.setUnlocalizedName("ender_cake")		.setHardness(0.5F);
	public static Block pumpkin_cake 		= new BlockMultipleCake("pumpkin_cake", 4)		.setRegistryName("pumpkin_cake")		.setUnlocalizedName("pumpkin_cake")		.setHardness(0.5F);
	public static Block spiced_cake 		= new BlockMultipleCake("spiced_cake", 4)		.setRegistryName("spiced_cake")			.setUnlocalizedName("spiced_cake")		.setHardness(0.5F);
	public static Block sandy_cake 			= new BlockMultipleCake("sandy_cake", 1)		.setRegistryName("sandy_cake")			.setUnlocalizedName("sandy_cake")		.setHardness(0.5F);
	public static Block stars_cake 			= new BlockMultipleCake("stars_cake", 4)		.setRegistryName("stars_cake")			.setUnlocalizedName("stars_cake")		.setHardness(0.5F);
	public static Block watermelon_cake 	= new BlockMultipleCake("watermelon_cake", 4)	.setRegistryName("watermelon_cake")		.setUnlocalizedName("watermelon_cake")	.setHardness(0.5F);
	public static Block nordic_cake 		= new BlockMultipleCake("nordic_cake", 3)		.setRegistryName("nordic_cake")			.setUnlocalizedName("nordic_cake")		.setHardness(0.5F);
	public static Block anniversary_cake 	= new BlockMultipleCake("anniversary_cake", 4)	.setRegistryName("anniversary_cake")	.setUnlocalizedName("anniversary_cake")	.setHardness(0.5F).setLightLevel(0.8F);
	public static Block paris_brest 		= new BlockMultipleCake("paris_brest", 3)		.setRegistryName("paris_brest")			.setUnlocalizedName("paris_brest")		.setHardness(0.5F);
	public static Block hamburger 			= new BlockMultipleCake("hamburger", 1)			.setRegistryName("hamburger")			.setUnlocalizedName("hamburger")		.setHardness(0.5F);
	public static Block cheese_cake 		= new BlockMultipleCake("cheese_cake", 6)		.setRegistryName("cheese_cake")			.setUnlocalizedName("cheese_cake")		.setHardness(0.5F);
	public static Block chocolate_roll 		= new BlockMultipleCake("chocolate_roll", 6)	.setRegistryName("chocolate_roll")		.setUnlocalizedName("chocolate_roll")	.setHardness(0.5F);
	public static Block carrot_cake 		= new BlockMultipleCake("carrot_cake", 4)		.setRegistryName("carrot_cake")			.setUnlocalizedName("carrot_cake")		.setHardness(0.5F);
	public static Block slime_cake 			= new BlockMultipleCake("slime_cake", 2)		.setRegistryName("slime_cake")			.setUnlocalizedName("slime_cake")		.setHardness(0.5F);
	public static Block muffins 			= new BlockMultipleCake("muffins", 1)			.setRegistryName("muffins")				.setUnlocalizedName("muffins")			.setHardness(0.5F);

	public static Item item_chocolate_cake 		= new ItemMultipleCake(chocolate_cake)		.setRegistryName("item_chocolate_cake")		.setUnlocalizedName("chocolate_cake");
	public static Item item_apple_cake 			= new ItemMultipleCake(apple_cake)			.setRegistryName("item_apple_cake")			.setUnlocalizedName("apple_cake");
	public static Item item_gold_cake 			= new ItemMultipleCake(gold_cake)			.setRegistryName("item_gold_cake")			.setUnlocalizedName("gold_cake");
	public static Item item_trapped_cake 		= new ItemMultipleCake(trapped_cake)		.setRegistryName("item_trapped_cake")		.setUnlocalizedName("trapped_cake");
	public static Item item_poisoned_cake 		= new ItemMultipleCake(poisoned_cake)		.setRegistryName("item_poisoned_cake")		.setUnlocalizedName("poisoned_cake");
	public static Item item_lava_cake 			= new ItemMultipleCake(lava_cake)			.setRegistryName("item_lava_cake")			.setUnlocalizedName("lava_cake");
	public static Item item_basque_cake 		= new ItemMultipleCake(basque_cake)			.setRegistryName("item_basque_cake")		.setUnlocalizedName("basque_cake");
	public static Item item_redstone_cake 		= new ItemMultipleCake(redstone_cake)		.setRegistryName("item_redstone_cake")		.setUnlocalizedName("redstone_cake");
	public static Item item_brownie 			= new ItemMultipleCake(brownie)				.setRegistryName("item_brownie")			.setUnlocalizedName("brownie");
	public static Item item_chocolate_mousse 	= new ItemMultipleCake(chocolate_mousse)	.setRegistryName("item_chocolate_mousse")	.setUnlocalizedName("chocolate_mousse");
	public static Item item_cookies_cake 		= new ItemMultipleCake(cookies_cake)		.setRegistryName("item_cookies_cake")		.setUnlocalizedName("cookies_cake");
	public static Item item_ender_cake 			= new ItemMultipleCake(ender_cake)			.setRegistryName("item_ender_cake")			.setUnlocalizedName("ender_cake");
	public static Item item_pumpkin_cake 		= new ItemMultipleCake(pumpkin_cake)		.setRegistryName("item_pumpkin_cake")		.setUnlocalizedName("pumpkin_cake");
	public static Item item_spiced_cake 		= new ItemMultipleCake(spiced_cake)			.setRegistryName("item_spiced_cake")		.setUnlocalizedName("spiced_cake");
	public static Item item_sandy_cake 			= new ItemMultipleCake(sandy_cake)			.setRegistryName("item_sandy_cake")			.setUnlocalizedName("sandy_cake");
	public static Item item_stars_cake 			= new ItemMultipleCake(stars_cake)			.setRegistryName("item_stars_cake")			.setUnlocalizedName("stars_cake");
	public static Item item_watermelon_cake 	= new ItemMultipleCake(watermelon_cake)		.setRegistryName("item_watermelon_cake")	.setUnlocalizedName("water-melon_cake");
	public static Item item_nordic_cake 		= new ItemMultipleCake(nordic_cake)			.setRegistryName("item_nordic_cake")		.setUnlocalizedName("nordic_cake");
	public static Item item_anniversary_cake 	= new ItemMultipleCake(anniversary_cake)	.setRegistryName("item_anniversary_cake")	.setUnlocalizedName("anniversary_cake");
	public static Item item_paris_brest 		= new ItemMultipleCake(paris_brest)			.setRegistryName("item_paris_brest")		.setUnlocalizedName("paris_brest"); 
	public static Item item_hamburger 			= new ItemMultipleCake(hamburger)			.setRegistryName("item_hamburger")			.setUnlocalizedName("hamburger");
	public static Item item_cheese_cake 		= new ItemMultipleCake(cheese_cake)			.setRegistryName("item_cheese_cake")		.setUnlocalizedName("cheese_cake");
	public static Item item_chocolate_roll 		= new ItemMultipleCake(chocolate_roll)		.setRegistryName("item_chocolate_roll")		.setUnlocalizedName("chocolate_roll");
	public static Item item_carrot_cake 		= new ItemMultipleCake(carrot_cake)			.setRegistryName("item_carrot_cake")		.setUnlocalizedName("carrot_cake");
	public static Item item_slime_cake 			= new ItemMultipleCake(slime_cake)			.setRegistryName("item_slime_cake")			.setUnlocalizedName("slime_cake");
	public static Item item_muffins 			= new ItemMultipleCake(muffins)				.setRegistryName("item_muffins")			.setUnlocalizedName("muffins");
	
	public static Item potion_hunger 	= new ItemCakePotion("hunger", false)	.setRegistryName("potion_hunger")	.setUnlocalizedName("hunger_potion");
	public static Item potion_sandy 	= new ItemCakePotion("sandy", false)	.setRegistryName("potion_sandy")	.setUnlocalizedName("sandy_potion");
	public static Item potion_nordic 	= new ItemCakePotion("nordic", false)	.setRegistryName("potion_nordic")	.setUnlocalizedName("nordic_potion");
	public static Item potion_creep 	= new ItemCakePotion("creep", false)	.setRegistryName("potion_creep")	.setUnlocalizedName("creep_potion");
	public static Item potion_slime 	= new ItemCakePotion("slime", false)	.setRegistryName("potion_slime")	.setUnlocalizedName("slime_potion");
	public static Item splash_hunger 	= new ItemCakePotion("hunger", true)	.setRegistryName("splash_hunger")	.setUnlocalizedName("hunger_splash_potion");
	public static Item splash_sandy 	= new ItemCakePotion("sandy", true)		.setRegistryName("splash_sandy")	.setUnlocalizedName("sandy_splash_potion");
	public static Item splash_nordic 	= new ItemCakePotion("nordic", true)	.setRegistryName("splash_nordic")	.setUnlocalizedName("nordic_splash_potion");
	public static Item splash_creep 	= new ItemCakePotion("creep", true)		.setRegistryName("splash_creep")	.setUnlocalizedName("creep_splash_potion");
	public static Item splash_slime 	= new ItemCakePotion("slime", true)		.setRegistryName("splash_slime")	.setUnlocalizedName("slime_splash_potion");
	
	public static Potion potionSandy 	= new PotionCake(new ResourceLocation("sandy_potion")	, false, 0).setIconIndex(0, 0)	.setPotionName("potion.Sandy_potion");
	public static Potion potionNordic 	= new PotionCake(new ResourceLocation("nordic_potion")	, false, 0).setIconIndex(1, 0)	.setPotionName("potion.Nordic_potion");
	public static Potion potionCreep 	= new PotionCake(new ResourceLocation("creep_potion")	, false, 0).setIconIndex(2, 0)	.setPotionName("potion.Creep_potion");
	public static Potion potionSlime 	= new PotionCake(new ResourceLocation("slime_potion")	, false, 0).setIconIndex(3, 0)	.setPotionName("potion.Slime_potion");
	
	public static Achievement firstCake 		= new Achievement("cakeisalie.achievement.firstCake"		, "First"		, 0, 0		, item_chocolate_cake, null).registerStat();
	public static Achievement poisonousCake 	= new Achievement("cakeisalie.achievement.poisonousCake"	, "Poisonous"	, 0, 2		, item_poisoned_cake, firstCake).registerStat();
	public static Achievement trappedCake 		= new Achievement("cakeisalie.achievement.trappedCake"		, "Trapped"		, -2, 2		, item_trapped_cake, poisonousCake).registerStat();
	public static Achievement deathCake 		= new Achievement("cakeisalie.achievement.deathCake"		, "Death"		, -4, 2		, new ItemStack(Items.SKULL, 1, 3), trappedCake).setSpecial().registerStat();
	public static Achievement anniversaryCake 	= new Achievement("cakeisalie.achievement.anniversaryCake"	, "Anniv"		, -2, 4		, item_anniversary_cake, trappedCake).registerStat();
	public static Achievement explodeCreep 		= new Achievement("cakeisalie.achievement.explodeCreep"		, "Creep"		, 0, 4		, Item.getItemFromBlock(Blocks.TNT), anniversaryCake).setSpecial().registerStat();
	public static Achievement appleCake 		= new Achievement("cakeisalie.achievement.appleCake"		, "Apple"		, 0, -2		, item_apple_cake, firstCake).registerStat();
	public static Achievement watermelonCake 	= new Achievement("cakeisalie.achievement.watermelonCake"	, "Watermelon"	, -2, -4	, item_watermelon_cake, appleCake).registerStat();
	public static Achievement appleGoldCake 	= new Achievement("cakeisalie.achievement.appleGoldCake"	, "AppleGold"	, -2, -2	, item_gold_cake, appleCake).registerStat();
	public static Achievement pumpkinCake 		= new Achievement("cakeisalie.achievement.pumpkinCake"		, "Pumpkin"		, -3, 0		, item_pumpkin_cake, appleGoldCake).registerStat();
	public static Achievement spicedCake 		= new Achievement("cakeisalie.achievement.spicedCake"		, "Spiced"		, -6, 0		, item_spiced_cake, pumpkinCake).registerStat();
	public static Achievement starsCake 		= new Achievement("cakeisalie.achievement.starsCake"		, "Stars"		, -5, -3	, item_stars_cake, pumpkinCake).registerStat();
	public static Achievement redstoneCake 		= new Achievement("cakeisalie.achievement.redstoneCake"		, "Redstone"	, 2, -1		, item_redstone_cake, firstCake).registerStat();
	public static Achievement lavaCake 			= new Achievement("cakeisalie.achievement.lavaCake"			, "Lava"		, 2, -3		, item_lava_cake, redstoneCake).registerStat();
	public static Achievement nordicCake 		= new Achievement("cakeisalie.achievement.nordicCake"		, "Nordic"		, 4, -2		, item_nordic_cake, redstoneCake).registerStat();
	public static Achievement waterIced 		= new Achievement("cakeisalie.achievement.waterIced"		, "WaterIced"	, 5, -4		, Item.getItemFromBlock(Blocks.ICE), nordicCake).setSpecial().registerStat();
	public static Achievement chocolateRoll 	= new Achievement("cakeisalie.achievement.chocolateRoll"	, "Roll"		, 2, 1		, item_chocolate_roll, firstCake).registerStat();
	public static Achievement sandyCake 		= new Achievement("cakeisalie.achievement.sandyCake"		, "Sandy"		, 4, 2		, item_sandy_cake, chocolateRoll).registerStat();
	public static Achievement suffocation 		= new Achievement("cakeisalie.achievement.suffocation"		, "Suffocation"	, 6, 0		, Item.getItemFromBlock(Blocks.SAND), sandyCake).setSpecial().registerStat();
	
	/**
	 * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
	 */
	public void preInit(){
		
		GameRegistry.register(chocolate_cake);
		GameRegistry.register(apple_cake);
		GameRegistry.register(gold_cake);
		GameRegistry.register(trapped_cake);
		GameRegistry.register(poisoned_cake);
		GameRegistry.register(lava_cake);
		GameRegistry.register(basque_cake);
		GameRegistry.register(redstone_cake);
		GameRegistry.register(brownie);
		GameRegistry.register(chocolate_mousse);
		GameRegistry.register(cookies_cake);
		GameRegistry.register(ender_cake);
		GameRegistry.register(pumpkin_cake);
		GameRegistry.register(spiced_cake);
		GameRegistry.register(sandy_cake);
		GameRegistry.register(stars_cake);
		GameRegistry.register(watermelon_cake);
		GameRegistry.register(nordic_cake);
		GameRegistry.register(anniversary_cake);
		GameRegistry.register(paris_brest);
		GameRegistry.register(hamburger);
		GameRegistry.register(cheese_cake);
		GameRegistry.register(chocolate_roll);
		GameRegistry.register(carrot_cake);
		GameRegistry.register(slime_cake);
		GameRegistry.register(muffins);
		
		GameRegistry.register(item_chocolate_cake);
    	GameRegistry.register(item_apple_cake);
    	GameRegistry.register(item_gold_cake);
    	GameRegistry.register(item_trapped_cake);
    	GameRegistry.register(item_poisoned_cake);
    	GameRegistry.register(item_lava_cake);
    	GameRegistry.register(item_basque_cake);
    	GameRegistry.register(item_redstone_cake);
    	GameRegistry.register(item_brownie);
    	GameRegistry.register(item_chocolate_mousse);
    	GameRegistry.register(item_cookies_cake);
    	GameRegistry.register(item_ender_cake);
    	GameRegistry.register(item_pumpkin_cake);
    	GameRegistry.register(item_spiced_cake);
    	GameRegistry.register(item_sandy_cake);
    	GameRegistry.register(item_stars_cake);
    	GameRegistry.register(item_watermelon_cake);
    	GameRegistry.register(item_nordic_cake);
    	GameRegistry.register(item_anniversary_cake);
    	GameRegistry.register(item_paris_brest);
    	GameRegistry.register(item_hamburger);
    	GameRegistry.register(item_cheese_cake);
    	GameRegistry.register(item_chocolate_roll);
    	GameRegistry.register(item_carrot_cake);
    	GameRegistry.register(item_slime_cake);
    	GameRegistry.register(item_muffins);
    	
    	GameRegistry.register(potion_hunger);
    	GameRegistry.register(potion_sandy);
    	GameRegistry.register(potion_nordic);
    	GameRegistry.register(potion_creep);
    	GameRegistry.register(potion_slime);
    	GameRegistry.register(splash_hunger);
    	GameRegistry.register(splash_sandy);
    	GameRegistry.register(splash_nordic);
    	GameRegistry.register(splash_creep);
    	GameRegistry.register(splash_slime);
		
	}

	public void init(){
		
		AchievementPage.registerAchievementPage(new AchievementPage("CakeIsALie", new Achievement[]{
    			firstCake, poisonousCake, trappedCake, deathCake, anniversaryCake, explodeCreep, appleCake, appleGoldCake, pumpkinCake, spicedCake, starsCake,
    			watermelonCake, redstoneCake, lavaCake, nordicCake, waterIced, chocolateRoll, sandyCake, suffocation
    	}));
		
		BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(Items.CLAY_BALL, 1)			, new ItemStack(potion_hunger, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(item_sandy_cake, 1)			, new ItemStack(potion_sandy, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(item_anniversary_cake, 1)	, new ItemStack(potion_creep, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(item_nordic_cake, 1)		, new ItemStack(potion_nordic, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.POTIONITEM, 1)	, new ItemStack(item_slime_cake, 1)			, new ItemStack(potion_slime, 1));
    	/*BrewingRecipeRegistry.addRecipe(new ItemStack(potion_hunger, 1)	, new ItemStack(Items.gunpowder, 1)			, new ItemStack(splash_hunger, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_sandy, 1)		, new ItemStack(Items.gunpowder, 1)			, new ItemStack(splash_sandy, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_creep, 1)		, new ItemStack(Items.gunpowder, 1)			, new ItemStack(splash_creep, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_nordic, 1)		, new ItemStack(Items.gunpowder, 1)			, new ItemStack(splash_nordic, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_slime, 1)		, new ItemStack(Items.gunpowder, 1)			, new ItemStack(splash_slime, 1));*/

    	
    	GameRegistry.addRecipe(new ItemStack(item_chocolate_cake, 1), new Object[] {
    			"XXX", "AAA", "OOO", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), new ItemStack(Items.DYE, 1, 3), 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_apple_cake, 1), new Object[] {
    			"XXX", "AAA", "OOO", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.APPLE, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_gold_cake, 1), new Object[] {
    			"XXX", "AAA", "OOO", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.GOLDEN_APPLE, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_trapped_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.GUNPOWDER, 
    			Character.valueOf('O'), Blocks.TNT, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_poisoned_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.SUGAR, 
    			Character.valueOf('O'), Items.SPIDER_EYE, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_lava_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.LAVA_BUCKET, 
    			Character.valueOf('A'), Items.BLAZE_POWDER, 
    			Character.valueOf('O'), Items.MAGMA_CREAM, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_basque_cake, 1), new Object[] {
    			"XXX", "AAA", "OOO", 
    			Character.valueOf('X'), Items.EGG, 
    			Character.valueOf('A'), Items.SUGAR, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_redstone_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.REDSTONE, 
    			Character.valueOf('O'), Items.EGG, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_brownie, 1), new Object[] {
    			"XXX", "AYA", "OOO", 
    			Character.valueOf('X'), new ItemStack(Items.DYE, 1, 3), 
    			Character.valueOf('A'), Items.SUGAR, 
    			Character.valueOf('Y'), Items.EGG, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_chocolate_mousse, 1), new Object[] {
    			"XXX", "AAA", 
    			Character.valueOf('X'), new ItemStack(Items.DYE, 1, 3), 
    			Character.valueOf('A'), Items.EGG
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_cookies_cake, 1), new Object[] {
    			"XXX", "XYX", "OOO", 
    			Character.valueOf('X'), Items.COOKIE,
    			Character.valueOf('Y'), Items.EGG, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_ender_cake, 1), new Object[] {
    			"XXX", "AYA", "OOO", 
    			Character.valueOf('X'), Items.ENDER_PEARL,
    			Character.valueOf('A'), Items.SUGAR, 
    			Character.valueOf('Y'), Items.EGG, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_pumpkin_cake, 1), new Object[] {
    			"XXX", "AAA", "OOO", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Blocks.PUMPKIN, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_spiced_cake, 1), new Object[] {
    			"XXX", "AYA", "OOO", 
    			Character.valueOf('X'), Items.SUGAR, 
    			Character.valueOf('A'), Items.FERMENTED_SPIDER_EYE, 
    			Character.valueOf('Y'), Items.BLAZE_POWDER, 
    			Character.valueOf('O'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_sandy_cake, 1), new Object[] {
    			"XX", "XA", 
    			Character.valueOf('X'), Blocks.SANDSTONE, 
    			Character.valueOf('A'), Items.EGG
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_stars_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.NETHER_STAR, 
    			Character.valueOf('O'), Items.EGG, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_watermelon_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.MELON, 
    			Character.valueOf('O'), Items.EGG, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_nordic_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.SNOWBALL, 
    			Character.valueOf('A'), Blocks.PACKED_ICE, 
    			Character.valueOf('O'), Items.FISH, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_anniversary_cake, 1), new Object[] {
    			"XXX", "AOA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.SUGAR, 
    			Character.valueOf('O'), new ItemStack(Items.SKULL, 1, 4), 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_paris_brest, 1), new Object[] {
    			"XXX", "AAA", "XXX", 
    			Character.valueOf('X'), Items.WHEAT, 
    			Character.valueOf('A'), Items.EGG
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_hamburger, 3), new Object[] {
    			"YYY", "XXX", "YYY", 
    			Character.valueOf('X'), Items.BEEF, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_hamburger, 1), new Object[] {
    			"Y ", "XY", 
    			Character.valueOf('X'), Items.BEEF, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_hamburger, 1), new Object[] {
    			"Y ", "YX", 
    			Character.valueOf('X'), Items.BEEF, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_cheese_cake, 1), new Object[] {
    			"XXX", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_chocolate_roll, 1), new Object[] {
    			"XXX", "XAX", "XXX", 
    			Character.valueOf('X'), new ItemStack(Items.DYE, 1, 3), 
    			Character.valueOf('A'), Items.MILK_BUCKET
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_carrot_cake, 1), new Object[] {
    			"XXX", "AAA", "YYY", 
    			Character.valueOf('X'), Items.MILK_BUCKET, 
    			Character.valueOf('A'), Items.CARROT, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_slime_cake, 1), new Object[] {
    			"XXX", "X X", "YYY", 
    			Character.valueOf('X'), Items.SLIME_BALL, 
    			Character.valueOf('Y'), Items.WHEAT
    			});
    	
    	GameRegistry.addRecipe(new ItemStack(item_muffins, 1), new Object[]{
    			"A ", "XX", 
    			Character.valueOf('A'), Items.EGG, 
    			Character.valueOf('X'), Items.WHEAT
    			});
    	
	}

	public void postInit(){

	}

	abstract public boolean playerIsInCreativeMode(EntityPlayer player);
	abstract public boolean isDedicatedServer();
}