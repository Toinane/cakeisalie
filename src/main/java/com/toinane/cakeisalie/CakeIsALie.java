//   Ce mod est créé par Toinane. Merci de ne pas copier tout mon travail =)   [Français]
//   Made by Toinane. Thank you not to copy all my work (:                     [English]
//
//   #############    ##########    ###    ###    ##        #####       ###    ##   ##########
//   #############    ##########    ###    ####   ##      #########     ####   ##   ###
//        ###         ##      ##           #####  ##     ###     ###    #####  ##   ######
//        ###         ##      ##    ###    ### ## ##    #############   ### ## ##   ###
//        ###         ##########    ###    ###  ####    ###       ###   ###  ####   ###
//        ###         ##########    ###    ###   ###    ###       ###   ###   ###   ##########
//

package com.toinane.cakeisalie;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;



@Mod(modid = CakeIsALie.MODID, name = CakeIsALie.MODNAME, version = CakeIsALie.VERSION)
public class CakeIsALie
{
    public static final String MODID = "cakeisalie";
    public static final String MODNAME = "CakeIsALie";
    public static final String VERSION = "5.1.1";
    public static final int NBRCAKE = 26;
 
    @Mod.Instance(CakeIsALie.MODID)
    public static CakeIsALie instance;
    
    @SidedProxy(clientSide = "com.toinane.cakeisalie.ClientProxy", serverSide = "com.toinane.cakeisalie.ServerProxy")
	public static ServerProxy proxy;
    
    public static CakeTab cakeTab = new CakeTab("cakeTab");
	
	public static Block chocolate_cake = new BlockMultipleCake("chocolate_cake").setUnlocalizedName("Chocolate_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block apple_cake = new BlockMultipleCake("apple_cake").setUnlocalizedName("Apple_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block gold_cake = new BlockMultipleCake("gold_cake").setUnlocalizedName("Gold_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block trapped_cake = new BlockMultipleCake("trapped_cake").setUnlocalizedName("Trapped_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block poisoned_cake = new BlockMultipleCake("poisoned_cake").setUnlocalizedName("Poisoned_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block lava_cake = new BlockMultipleCake("lava_cake").setUnlocalizedName("Lava_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block basque_cake = new BlockMultipleCake("basque_cake").setUnlocalizedName("Basque_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block redstone_cake = new BlockMultipleCake("redstone_cake").setUnlocalizedName("Redstone_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block brownie = new BlockMultipleCake("brownie").setUnlocalizedName("Brownie").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block chocolate_mousse = new BlockMultipleCake("chocolate_mousse").setUnlocalizedName("Chocolate_mousse").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cookies_cake = new BlockMultipleCake("cookies_cake").setUnlocalizedName("Cookies_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block ender_cake = new BlockMultipleCake("ender_cake").setUnlocalizedName("Ender_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block pumpkin_cake = new BlockMultipleCake("pumpkin_cake").setUnlocalizedName("Pumpkin_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block spiced_cake = new BlockMultipleCake("spiced_cake").setUnlocalizedName("Spiced_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block sandy_cake = new BlockMultipleCake("sandy_cake").setUnlocalizedName("Sandy_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block stars_cake = new BlockMultipleCake("stars_cake").setUnlocalizedName("Stars_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block watermelon_cake = new BlockMultipleCake("watermelon_cake").setUnlocalizedName("Water-melon_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block nordic_cake = new BlockMultipleCake("nordic_cake").setUnlocalizedName("Nordic_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block anniversary_cake = new BlockMultipleCake("anniversary_cake").setUnlocalizedName("Anniversary_cake").setLightLevel(0.8F).setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block paris_brest = new BlockMultipleCake("paris_brest").setUnlocalizedName("Paris_brest").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block hamburger = new BlockMultipleCake("hamburger").setUnlocalizedName("Hamburger").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cheese_cake = new BlockMultipleCake("cheese_cake").setUnlocalizedName("Cheese_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block chocolate_roll = new BlockMultipleCake("chocolate_roll").setUnlocalizedName("Chocolate_roll").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block carrot_cake = new BlockMultipleCake("carrot_cake").setUnlocalizedName("Carrot_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block slime_cake = new BlockMultipleCake("slime_cake").setUnlocalizedName("Slime_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block muffins = new BlockMultipleCake("muffins").setUnlocalizedName("Muffins").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	
	public static Item item_chocolate_cake = new ItemMultipleCake(chocolate_cake).setUnlocalizedName("Chocolate_cake").setCreativeTab(cakeTab);
	public static Item item_apple_cake = new ItemMultipleCake(apple_cake).setUnlocalizedName("Apple_cake").setCreativeTab(cakeTab);
	public static Item item_gold_cake = new ItemMultipleCake(gold_cake).setUnlocalizedName("Gold_cake").setCreativeTab(cakeTab);
	public static Item item_trapped_cake = new ItemMultipleCake(trapped_cake).setUnlocalizedName("Trapped_cake").setCreativeTab(cakeTab);
	public static Item item_poisoned_cake = new ItemMultipleCake(poisoned_cake).setUnlocalizedName("Poisoned_cake").setCreativeTab(cakeTab);
	public static Item item_lava_cake = new ItemMultipleCake(lava_cake).setUnlocalizedName("Lava_cake").setCreativeTab(cakeTab);
	public static Item item_basque_cake = new ItemMultipleCake(basque_cake).setUnlocalizedName("Basque_cake").setCreativeTab(cakeTab);
	public static Item item_redstone_cake = new ItemMultipleCake(redstone_cake).setUnlocalizedName("Redstone_cake").setCreativeTab(cakeTab);
	public static Item item_brownie = new ItemMultipleCake(brownie).setUnlocalizedName("Brownie").setCreativeTab(cakeTab);
	public static Item item_chocolate_mousse = new ItemMultipleCake(chocolate_mousse).setUnlocalizedName("Chocolate_mousse").setCreativeTab(cakeTab);
	public static Item item_cookies_cake = new ItemMultipleCake(cookies_cake).setUnlocalizedName("Cookies_cake").setCreativeTab(cakeTab);
	public static Item item_ender_cake = new ItemMultipleCake(ender_cake).setUnlocalizedName("Ender_cake").setCreativeTab(cakeTab);
	public static Item item_pumpkin_cake = new ItemMultipleCake(pumpkin_cake).setUnlocalizedName("Pumpkin_cake").setCreativeTab(cakeTab);
	public static Item item_spiced_cake = new ItemMultipleCake(spiced_cake).setUnlocalizedName("Spiced_cake").setCreativeTab(cakeTab);
	public static Item item_sandy_cake = new ItemMultipleCake(sandy_cake).setUnlocalizedName("Sandy_cake").setCreativeTab(cakeTab);
	public static Item item_stars_cake = new ItemMultipleCake(stars_cake).setUnlocalizedName("Stars_cake").setCreativeTab(cakeTab);
	public static Item item_watermelon_cake = new ItemMultipleCake(watermelon_cake).setUnlocalizedName("Water-melon_cake").setCreativeTab(cakeTab);
	public static Item item_nordic_cake = new ItemMultipleCake(nordic_cake).setUnlocalizedName("Nordic_cake").setCreativeTab(cakeTab);
	public static Item item_anniversary_cake = new ItemMultipleCake(anniversary_cake).setUnlocalizedName("Anniversary_cake").setCreativeTab(cakeTab);
	public static Item item_paris_brest = new ItemMultipleCake(paris_brest).setUnlocalizedName("Paris_brest").setCreativeTab(cakeTab); 
	public static Item item_hamburger = new ItemMultipleCake(hamburger).setUnlocalizedName("Hamburger").setCreativeTab(cakeTab);
	public static Item item_cheese_cake = new ItemMultipleCake(cheese_cake).setUnlocalizedName("Cheese_cake").setCreativeTab(cakeTab);
	public static Item item_chocolate_roll = new ItemMultipleCake(chocolate_roll).setUnlocalizedName("Chocolate_roll").setCreativeTab(cakeTab);
	public static Item item_carrot_cake = new ItemMultipleCake(carrot_cake).setUnlocalizedName("Carrot_cake").setCreativeTab(cakeTab);
	public static Item item_slime_cake = new ItemMultipleCake(slime_cake).setUnlocalizedName("Slime_cake").setCreativeTab(cakeTab);
	public static Item item_muffins = new ItemMultipleCake(muffins).setUnlocalizedName("Muffins").setCreativeTab(cakeTab);
	
	
	public static Item potion_hunger = new ItemCakePotion("hunger", false).setUnlocalizedName("Hunger_potion").setCreativeTab(cakeTab);
	public static Item potion_sandy = new ItemCakePotion("sandy", false).setUnlocalizedName("Sandy_potion").setCreativeTab(cakeTab);
	public static Item potion_nordic = new ItemCakePotion("nordic", false).setUnlocalizedName("Nordic_potion").setCreativeTab(cakeTab);
	public static Item potion_creep = new ItemCakePotion("creep", false).setUnlocalizedName("Creep_potion").setCreativeTab(cakeTab);
	public static Item potion_slime = new ItemCakePotion("slime", false).setUnlocalizedName("Slime_potion").setCreativeTab(cakeTab);
	public static Item splash_hunger = new ItemCakePotion("hunger", true).setUnlocalizedName("Hunger_splash_potion");
	public static Item splash_sandy = new ItemCakePotion("sandy", true).setUnlocalizedName("Sandy_splash_potion");
	public static Item splash_nordic = new ItemCakePotion("nordic", true).setUnlocalizedName("Nordic_splash_potion");
	public static Item splash_creep = new ItemCakePotion("creep", true).setUnlocalizedName("Creep_splash_potion");
	public static Item splash_slime = new ItemCakePotion("slime", true).setUnlocalizedName("Slime_splash_potion");
	
	public static Potion potionSandy;
	public static Potion potionNordic;
	public static Potion potionCreep;
	public static Potion potionSlime;
	
	public static Achievement firstCake = (Achievement) new Achievement("cakeisalie.achievement.firstCake", "First", 0, 0, CakeIsALie.item_chocolate_cake, (Achievement)null).registerStat();
	public static Achievement poisonousCake = (Achievement) new Achievement("cakeisalie.achievement.poisonousCake", "Poisonous", 0, 2, CakeIsALie.item_poisoned_cake, firstCake).registerStat();
	public static Achievement trappedCake = (Achievement) new Achievement("cakeisalie.achievement.trappedCake", "Trapped", -2, 2, CakeIsALie.item_trapped_cake, poisonousCake).registerStat();
	public static Achievement deathCake = (Achievement) new Achievement("cakeisalie.achievement.deathCake", "Death", -4, 2, new ItemStack(Items.skull, 1, 3), trappedCake).setSpecial().registerStat();
	public static Achievement anniversaryCake = (Achievement) new Achievement("cakeisalie.achievement.anniversaryCake", "Anniv", -2, 4, CakeIsALie.item_anniversary_cake, trappedCake).registerStat();
	public static Achievement explodeCreep = (Achievement) new Achievement("cakeisalie.achievement.explodeCreep", "Creep", 0, 4, Item.getItemFromBlock(Blocks.tnt), anniversaryCake).setSpecial().registerStat();
	public static Achievement appleCake = (Achievement) new Achievement("cakeisalie.achievement.appleCake", "Apple", 0, -2, CakeIsALie.item_apple_cake, firstCake).registerStat();
	public static Achievement watermelonCake = (Achievement) new Achievement("cakeisalie.achievement.watermelonCake", "Watermelon", -2, -4, CakeIsALie.item_watermelon_cake, appleCake).registerStat();
	public static Achievement appleGoldCake = (Achievement) new Achievement("cakeisalie.achievement.appleGoldCake", "AppleGold", -2, -2, CakeIsALie.item_gold_cake, appleCake).registerStat();
	public static Achievement pumpkinCake = (Achievement) new Achievement("cakeisalie.achievement.pumpkinCake", "Pumpkin", -3, 0, CakeIsALie.item_pumpkin_cake, appleGoldCake).registerStat();
	public static Achievement spicedCake = (Achievement) new Achievement("cakeisalie.achievement.spicedCake", "Spiced", -6, 0, CakeIsALie.item_spiced_cake, pumpkinCake).registerStat();
	public static Achievement starsCake = (Achievement) new Achievement("cakeisalie.achievement.starsCake", "Stars", -5, -3, CakeIsALie.item_stars_cake, pumpkinCake).registerStat();
	public static Achievement redstoneCake = (Achievement) new Achievement("cakeisalie.achievement.redstoneCake", "Redstone", 2, -1, CakeIsALie.item_redstone_cake, firstCake).registerStat();
	public static Achievement lavaCake = (Achievement) new Achievement("cakeisalie.achievement.lavaCake", "Lava", 2, -3, CakeIsALie.item_lava_cake, redstoneCake).registerStat();
	public static Achievement nordicCake = (Achievement) new Achievement("cakeisalie.achievement.nordicCake", "Nordic", 4, -2, CakeIsALie.item_nordic_cake, redstoneCake).registerStat();
	public static Achievement waterIced = (Achievement) new Achievement("cakeisalie.achievement.waterIced", "WaterIced", 5, -4, Item.getItemFromBlock(Blocks.ice), nordicCake).setSpecial().registerStat();
	public static Achievement chocolateRoll = (Achievement) new Achievement("cakeisalie.achievement.chocolateRoll", "Roll", 2, 1, CakeIsALie.item_chocolate_roll, firstCake).registerStat();
	public static Achievement sandyCake = (Achievement) new Achievement("cakeisalie.achievement.sandyCake", "Sandy", 4, 2, CakeIsALie.item_sandy_cake, chocolateRoll).registerStat();
	public static Achievement suffocation = (Achievement) new Achievement("cakeisalie.achievement.suffocation", "Suffocation", 6, 0, Item.getItemFromBlock(Blocks.sand), sandyCake).setSpecial().registerStat();
	
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	
    	// pour les effets de potion
    	Potion[] potionTypes = null;
    	for (Field f : Potion.class.getDeclaredFields()){
    		f.setAccessible(true);
    		try{
    			if(f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")){
			    	Field modfield = Field.class.getDeclaredField("modifiers");
			    	modfield.setAccessible(true);
			    	modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

			    	potionTypes = (Potion[])f.get(null);
			    	final Potion[] newPotionTypes = new Potion[256];
			    	System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
			    	f.set(null, newPotionTypes);
    			}
    		}
    		catch (Exception r){
    			System.err.println("Severe error, please report this to the mod author: Toinane");
    			System.err.println(r);
    		}
    	}
    	
    	
		potionSandy = new PotionCake(new ResourceLocation("sandy_potion"), false, 0).setIconIndex(0, 0).setPotionName("potion.Sandy_potion");
    	potionNordic = new PotionCake(new ResourceLocation("nordic_potion"), false, 0).setIconIndex(1, 0).setPotionName("potion.Nordic_potion");
    	potionCreep = new PotionCake(new ResourceLocation("creep_potion"), false, 0).setIconIndex(2, 0).setPotionName("potion.Creep_potion");
    	potionSlime = new PotionCake(new ResourceLocation("slime_potion"), false, 0).setIconIndex(3, 0).setPotionName("potion.Slime_potion");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    	
    	
    	AchievementPage.registerAchievementPage(new AchievementPage("CakeIsALie", new Achievement[]{
    			firstCake, poisonousCake, trappedCake, deathCake, anniversaryCake, explodeCreep, appleCake, appleGoldCake, pumpkinCake, spicedCake, starsCake,
    			watermelonCake, redstoneCake, lavaCake, nordicCake, waterIced, chocolateRoll, sandyCake, suffocation
    	}));
    	
    	//proxy.registerRenderThings(); plus besoin .?
    	
    	GameRegistry.registerBlock(chocolate_cake, "chocolate_cake");
    	GameRegistry.registerBlock(apple_cake, "apple_cake");
    	GameRegistry.registerBlock(gold_cake, "gold_cake");
    	GameRegistry.registerBlock(trapped_cake, "trapped_cake");
    	GameRegistry.registerBlock(poisoned_cake, "poisoned_cake");
    	GameRegistry.registerBlock(lava_cake, "lava_cake");
    	GameRegistry.registerBlock(basque_cake, "basque_cake");
    	GameRegistry.registerBlock(redstone_cake, "redstone_cake");
    	GameRegistry.registerBlock(brownie, "brownie");
    	GameRegistry.registerBlock(chocolate_mousse, "chocolate_mousse");
    	GameRegistry.registerBlock(cookies_cake, "cookies_cake");
    	GameRegistry.registerBlock(ender_cake, "ender_cake");
    	GameRegistry.registerBlock(pumpkin_cake, "pumpkin_cake");
    	GameRegistry.registerBlock(spiced_cake, "spiced_cake");
    	GameRegistry.registerBlock(sandy_cake, "sandy_cake");
    	GameRegistry.registerBlock(stars_cake, "stars_cake");
    	GameRegistry.registerBlock(watermelon_cake, "watermelon_cake");
    	GameRegistry.registerBlock(nordic_cake, "nordic_cake");
    	GameRegistry.registerBlock(anniversary_cake, "anniversary_cake");
    	GameRegistry.registerBlock(paris_brest, "paris_brest");
    	GameRegistry.registerBlock(hamburger, "hamburger");
    	GameRegistry.registerBlock(cheese_cake, "cheese_cake");
    	GameRegistry.registerBlock(chocolate_roll, "chocolate_roll");
    	GameRegistry.registerBlock(carrot_cake, "carrot_cake");
    	GameRegistry.registerBlock(slime_cake, "slime_cake");
    	GameRegistry.registerBlock(muffins, "muffins");
    	
    	GameRegistry.registerItem(item_chocolate_cake, "item_chocolate_cake");
    	GameRegistry.registerItem(item_apple_cake, "item_apple_cake");
    	GameRegistry.registerItem(item_gold_cake, "item_gold_cake");
    	GameRegistry.registerItem(item_trapped_cake, "item_trapped_cake");
    	GameRegistry.registerItem(item_poisoned_cake, "item_poisoned_cake");
    	GameRegistry.registerItem(item_lava_cake, "item_lava_cake");
    	GameRegistry.registerItem(item_basque_cake, "item_basque_cake");
    	GameRegistry.registerItem(item_redstone_cake, "item_redstone_cake");
    	GameRegistry.registerItem(item_brownie, "item_brownie");
    	GameRegistry.registerItem(item_chocolate_mousse, "item_chocolate_mousse");
    	GameRegistry.registerItem(item_cookies_cake, "item_cookies_cake");
    	GameRegistry.registerItem(item_ender_cake, "item_ender_cake");
    	GameRegistry.registerItem(item_pumpkin_cake, "item_pumpkin_cake");
    	GameRegistry.registerItem(item_spiced_cake, "item_spiced_cake");
    	GameRegistry.registerItem(item_sandy_cake, "item_sandy_cake");
    	GameRegistry.registerItem(item_stars_cake, "item_stars_cake");
    	GameRegistry.registerItem(item_watermelon_cake, "item_watermelon_cake");
    	GameRegistry.registerItem(item_nordic_cake, "item_nordic_cake");
    	GameRegistry.registerItem(item_anniversary_cake, "item_anniversary_cake");
    	GameRegistry.registerItem(item_paris_brest, "item_paris_brest");
    	GameRegistry.registerItem(item_hamburger, "item_hamburger");
    	GameRegistry.registerItem(item_cheese_cake, "item_cheese_cake");
    	GameRegistry.registerItem(item_chocolate_roll, "item_chocolate_roll");
    	GameRegistry.registerItem(item_carrot_cake, "item_carrot_cake");
    	GameRegistry.registerItem(item_slime_cake, "item_slime_cake");
    	GameRegistry.registerItem(item_muffins, "item_muffins");
    	
    	
    	GameRegistry.registerItem(potion_hunger, "potion_hunger");
    	GameRegistry.registerItem(potion_sandy, "potion_sandy");
    	GameRegistry.registerItem(potion_nordic, "potion_nordic");
    	GameRegistry.registerItem(potion_creep, "potion_creep");
    	GameRegistry.registerItem(potion_slime, "potion_slime");
    	GameRegistry.registerItem(splash_hunger, "splash_hunger");
    	GameRegistry.registerItem(splash_sandy, "splash_sandy");
    	GameRegistry.registerItem(splash_nordic, "splash_nordic");
    	GameRegistry.registerItem(splash_creep, "splash_creep");
    	GameRegistry.registerItem(splash_slime, "splash_slime");
    	
    	
    	
    	if(event.getSide() == Side.CLIENT){
   	     RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
   	     
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(chocolate_cake), 0, new ModelResourceLocation(MODID+":chocolate_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(apple_cake), 0, new ModelResourceLocation(MODID+":apple_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(gold_cake), 0, new ModelResourceLocation(MODID+":gold_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(trapped_cake), 0, new ModelResourceLocation(MODID+":trapped_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(poisoned_cake), 0, new ModelResourceLocation(MODID+":poisoned_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(lava_cake), 0, new ModelResourceLocation(MODID+":lava_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(basque_cake), 0, new ModelResourceLocation(MODID+":basque_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(redstone_cake), 0, new ModelResourceLocation(MODID+":redstone_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(brownie), 0, new ModelResourceLocation(MODID+":brownie", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(chocolate_mousse), 0, new ModelResourceLocation(MODID+":chocolate_mousse", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(cookies_cake), 0, new ModelResourceLocation(MODID+":cookies_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(ender_cake), 0, new ModelResourceLocation(MODID+":ender_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(pumpkin_cake), 0, new ModelResourceLocation(MODID+":pumpkin_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(spiced_cake), 0, new ModelResourceLocation(MODID+":spiced_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(sandy_cake), 0, new ModelResourceLocation(MODID+":sandy_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(stars_cake), 0, new ModelResourceLocation(MODID+":stars_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(watermelon_cake), 0, new ModelResourceLocation(MODID+":watermelon_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(nordic_cake), 0, new ModelResourceLocation(MODID+":nordic_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(anniversary_cake), 0, new ModelResourceLocation(MODID+":anniversary_cake", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(paris_brest), 0, new ModelResourceLocation(MODID+":paris_brest", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(hamburger), 0, new ModelResourceLocation(MODID+":hamburger", "inventory"));
   		 renderItem.getItemModelMesher().register(Item.getItemFromBlock(cheese_cake), 0, new ModelResourceLocation(MODID+":cheese_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(chocolate_roll), 0, new ModelResourceLocation(MODID+":chocolate_roll", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(carrot_cake), 0, new ModelResourceLocation(MODID+":carrot_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(slime_cake), 0, new ModelResourceLocation(MODID+":slime_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(Item.getItemFromBlock(muffins), 0, new ModelResourceLocation(MODID+":muffins", "inventory"));

  
   	     renderItem.getItemModelMesher().register(item_chocolate_cake, 0, new ModelResourceLocation(MODID+":item_chocolate_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_apple_cake, 0, new ModelResourceLocation(MODID+":item_apple_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_gold_cake, 0, new ModelResourceLocation(MODID+":item_gold_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_trapped_cake, 0, new ModelResourceLocation("cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_poisoned_cake, 0, new ModelResourceLocation("cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_lava_cake, 0, new ModelResourceLocation(MODID+":item_lava_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_basque_cake, 0, new ModelResourceLocation(MODID+":item_basque_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_redstone_cake, 0, new ModelResourceLocation(MODID+":item_redstone_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_brownie, 0, new ModelResourceLocation(MODID+":item_brownie", "inventory"));
   	     renderItem.getItemModelMesher().register(item_chocolate_mousse, 0, new ModelResourceLocation(MODID+":item_chocolate_mousse", "inventory"));
   	     renderItem.getItemModelMesher().register(item_cookies_cake, 0, new ModelResourceLocation(MODID+":item_cookies_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_ender_cake, 0, new ModelResourceLocation(MODID+":item_ender_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_pumpkin_cake, 0, new ModelResourceLocation(MODID+":item_pumpkin_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_spiced_cake, 0, new ModelResourceLocation(MODID+":item_spiced_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_sandy_cake, 0, new ModelResourceLocation(MODID+":item_sandy_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_stars_cake, 0, new ModelResourceLocation(MODID+":item_stars_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_watermelon_cake, 0, new ModelResourceLocation(MODID+":item_watermelon_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_nordic_cake, 0, new ModelResourceLocation(MODID+":item_nordic_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_anniversary_cake, 0, new ModelResourceLocation(MODID+":item_anniversary_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_paris_brest, 0, new ModelResourceLocation(MODID+":item_paris_brest", "inventory"));
   	     renderItem.getItemModelMesher().register(item_hamburger, 0, new ModelResourceLocation(MODID+":item_hamburger", "inventory"));
   	     renderItem.getItemModelMesher().register(item_cheese_cake, 0, new ModelResourceLocation(MODID+":item_cheese_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_chocolate_roll, 0, new ModelResourceLocation(MODID+":item_chocolate_roll", "inventory"));
   	     renderItem.getItemModelMesher().register(item_carrot_cake, 0, new ModelResourceLocation(MODID+":item_carrot_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_slime_cake, 0, new ModelResourceLocation(MODID+":item_slime_cake", "inventory"));
   	     renderItem.getItemModelMesher().register(item_muffins, 0, new ModelResourceLocation(MODID+":item_muffins", "inventory"));
   	     
   	     renderItem.getItemModelMesher().register(potion_hunger, 0, new ModelResourceLocation(MODID+":potion_hunger", "inventory"));
   	     renderItem.getItemModelMesher().register(potion_sandy, 0, new ModelResourceLocation(MODID+":potion_sandy", "inventory"));
   	     renderItem.getItemModelMesher().register(potion_nordic, 0, new ModelResourceLocation(MODID+":potion_nordic", "inventory"));
   	     renderItem.getItemModelMesher().register(potion_creep, 0, new ModelResourceLocation(MODID+":potion_creep", "inventory"));
   	     renderItem.getItemModelMesher().register(potion_slime, 0, new ModelResourceLocation(MODID+":potion_slime", "inventory"));
   	     renderItem.getItemModelMesher().register(splash_hunger, 0, new ModelResourceLocation(MODID+":splash_hunger", "inventory"));
   	     renderItem.getItemModelMesher().register(splash_sandy, 0, new ModelResourceLocation(MODID+":splash_sandy", "inventory"));
   	     renderItem.getItemModelMesher().register(splash_nordic, 0, new ModelResourceLocation(MODID+":splash_nordic", "inventory"));
   	     renderItem.getItemModelMesher().register(splash_creep, 0, new ModelResourceLocation(MODID+":splash_creep", "inventory"));
   	     renderItem.getItemModelMesher().register(splash_slime, 0, new ModelResourceLocation(MODID+":splash_slime", "inventory"));
   	}
    	
    	
    	
    	
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1), new ItemStack(Items.clay_ball, 1), new ItemStack(potion_hunger, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1), new ItemStack(item_sandy_cake, 1), new ItemStack(potion_sandy, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1), new ItemStack(item_anniversary_cake, 1), new ItemStack(potion_creep, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1), new ItemStack(item_nordic_cake, 1), new ItemStack(potion_nordic, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1), new ItemStack(item_slime_cake, 1), new ItemStack(potion_slime, 1));
    	/*BrewingRecipeRegistry.addRecipe(new ItemStack(potion_hunger, 1), new ItemStack(Items.gunpowder, 1), new ItemStack(splash_hunger, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_sandy, 1), new ItemStack(Items.gunpowder, 1), new ItemStack(splash_sandy, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_creep, 1), new ItemStack(Items.gunpowder, 1), new ItemStack(splash_creep, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_nordic, 1), new ItemStack(Items.gunpowder, 1), new ItemStack(splash_nordic, 1));
    	BrewingRecipeRegistry.addRecipe(new ItemStack(potion_slime, 1), new ItemStack(Items.gunpowder, 1), new ItemStack(splash_slime, 1));*/

    	
    	GameRegistry.addRecipe(new ItemStack(item_chocolate_cake, 1), new Object[] 
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), new ItemStack(Items.dye, 1, 3), Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_apple_cake, 1), new Object[] 
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.apple, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_gold_cake, 1), new Object[] 
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.golden_apple, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_trapped_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.gunpowder, Character.valueOf('O'), Blocks.tnt, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_poisoned_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.sugar, Character.valueOf('O'), Items.spider_eye, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_lava_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.lava_bucket, Character.valueOf('A'), Items.blaze_powder, Character.valueOf('O'), Items.magma_cream, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_basque_cake, 1), new Object[] 
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.egg, Character.valueOf('A'), Items.sugar, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_redstone_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.redstone, Character.valueOf('O'), Items.egg, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_brownie, 1), new Object[] 
    	{"XXX", "AYA", "OOO", Character.valueOf('X'), new ItemStack(Items.dye, 1, 3), Character.valueOf('A'), Items.sugar, Character.valueOf('Y'), Items.egg, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_chocolate_mousse, 1), new Object[]
    	{"XXX", "AAA", Character.valueOf('X'), new ItemStack(Items.dye, 1, 3), Character.valueOf('A'), Items.egg});
    	GameRegistry.addRecipe(new ItemStack(item_cookies_cake, 1), new Object[] 
    	{"XXX", "XYX", "OOO", Character.valueOf('X'), Items.cookie, Character.valueOf('Y'), Items.egg, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_ender_cake, 1), new Object[] 
    	{"XXX", "AYA", "OOO", Character.valueOf('X'), Items.ender_pearl, Character.valueOf('A'), Items.sugar, Character.valueOf('Y'), Items.egg, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_pumpkin_cake, 1), new Object[] 
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Blocks.pumpkin, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_spiced_cake, 1), new Object[] 
    	{"XXX", "AYA", "OOO", Character.valueOf('X'), Items.sugar, Character.valueOf('A'), Items.fermented_spider_eye, Character.valueOf('Y'), Items.blaze_powder, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_sandy_cake, 1), new Object[] 
    	{"XX", "XA", Character.valueOf('X'), Blocks.sandstone, Character.valueOf('A'), Items.egg});
    	GameRegistry.addRecipe(new ItemStack(item_stars_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.nether_star, Character.valueOf('O'), Items.egg, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_watermelon_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.melon, Character.valueOf('O'), Items.egg, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_nordic_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.snowball, Character.valueOf('A'), Blocks.packed_ice, Character.valueOf('O'), Items.fish, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_anniversary_cake, 1), new Object[] 
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.sugar, Character.valueOf('O'), new ItemStack(Items.skull, 1, 4), Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_paris_brest, 1), new Object[] 
    	{"XXX", "AAA", "XXX", Character.valueOf('X'), Items.wheat, Character.valueOf('A'), Items.egg});
    	GameRegistry.addRecipe(new ItemStack(item_hamburger, 3), new Object[] 
    	{"YYY", "XXX", "YYY", Character.valueOf('X'), Items.beef, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_hamburger, 1), new Object[] 
    	{"Y ", "XY", Character.valueOf('X'), Items.beef, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_hamburger, 1), new Object[] 
    	{"Y ", "YX", Character.valueOf('X'), Items.beef, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_cheese_cake, 1), new Object[] 
    	{"XXX", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_chocolate_roll, 1), new Object[] 
    	{"XXX", "XAX", "XXX", Character.valueOf('X'), new ItemStack(Items.dye, 1, 3), Character.valueOf('A'), Items.milk_bucket});
    	GameRegistry.addRecipe(new ItemStack(item_carrot_cake, 1), new Object[] 
    	{"XXX", "AAA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.carrot, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_slime_cake, 1), new Object[] 
    	{"XXX", "X X", "YYY", Character.valueOf('X'), Items.slime_ball, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(item_muffins, 1), new Object[]
    	{"A ", "XX", Character.valueOf('A'), Items.egg, Character.valueOf('X'), Items.wheat});
    	//GameRegistry.addRecipe(new ItemStack(potion_hunger, 1), new Object[]
    	//{"X", "Y", Character.valueOf('X'), Items.clay_ball, Character.valueOf('Y'), new ItemStack(Items.potionitem, 1, 0)});
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
 
    	MinecraftForge.EVENT_BUS.register(new CakeHooks());

  
    	/*
    	NOTE: Registering to the correct BUS
    	You have followed all the steps and your event handling methods just do not seem to be working, what could possibly be going on? 
    	Well, each event is posted to a different event bus, and if your event handler is registered to the incorrect bus, then your method will never get called. 
    	The vast majority of events are posted to the MinecraftForge.EVENT_BUS, but there are several other event buses:
    	
    	1. MinecraftForge.EVENT_BUS: Most events get posted to this bus.
    	
    	2. MinecraftForge.TERRAIN_GEN_BUS: Most world generation events happen here, such as Populate, Decorate, etc., with the strange exception that Pre and Post events are on the regular EVENT_BUS
    	
    	3. MinecraftForge.ORE_GEN_BUS: Ore generation, obviously
    	
    	4. FML Events: these become very important in 1.7.2, as this is where TickEvents and KeyInputEvents are posted, with TickHandler and KeyHandler no longer existing.
    	*/
    }
    
}