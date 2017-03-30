//   Ce mod est cr�� par Toinane. Merci de ne pas copier tout mon travail =)   [Fran�ais]
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = CakeIsALie.MODID, name = CakeIsALie.MODNAME, version = CakeIsALie.VERSION)
public class CakeIsALie
{
    public static final String MODID = "CakeIsALie";
    public static final String MODNAME = "CakeIsALie";
    public static final String VERSION = "4.05";

    @Mod.Instance(CakeIsALie.MODID)
    public static CakeIsALie instance;

    @SidedProxy(clientSide = "com.toinane.cakeisalie.ClientProxy", serverSide = "com.toinane.cakeisalie.ServerProxy")
	public static ServerProxy proxy;

    public static CakeTab cakeTab = new CakeTab("cakeTab");

	public static Block cake1 = new BlockMultipleCake(1).setBlockName("Chocolate_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake2 = new BlockMultipleCake(2).setBlockName("Apple_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake3 = new BlockMultipleCake(3).setBlockName("Gold_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake4 = new BlockMultipleCake(4).setBlockName("Trapped_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake5 = new BlockMultipleCake(5).setBlockName("Poisoned_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake6 = new BlockMultipleCake(6).setBlockName("Lava_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake7 = new BlockMultipleCake(7).setBlockName("Basque_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake8 = new BlockMultipleCake(8).setBlockName("Redstone_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake9 = new BlockMultipleCake(9).setBlockName("Brownie").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake10 = new BlockMultipleCake(10).setBlockName("Chocolate_mousse").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake11 = new BlockMultipleCake(11).setBlockName("Cookies_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake12 = new BlockMultipleCake(12).setBlockName("Ender_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake13 = new BlockMultipleCake(13).setBlockName("Pumpkin_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake14 = new BlockMultipleCake(14).setBlockName("Spiced_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake15 = new BlockMultipleCake(15).setBlockName("Sandy_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake16 = new BlockMultipleCake(16).setBlockName("Stars_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake17 = new BlockMultipleCake(17).setBlockName("Water-melon_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake18 = new BlockMultipleCake(18).setBlockName("Nordic_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake19 = new BlockAnniversary().setBlockName("Anniversary_cake").setLightLevel(0.8F).setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake19w = new BlockMultipleCake(19).setBlockName("Anniversary_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake20 = new BlockParisBrest(1).setBlockName("Paris_brest").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake20w = new BlockParisBrest(2).setBlockName("Paris_brest").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake20s = new BlockParisBrest(3).setBlockName("Paris_brest").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake21 = new BlockMultipleCake(21).setBlockName("Meat_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake22 = new BlockMultipleCake(22).setBlockName("Cheese_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake23 = new BlockMultipleCake(23).setBlockName("Chocolate_roll").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake24 = new BlockMultipleCake(24).setBlockName("Carrot_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);
	public static Block cake25 = new BlockMultipleCake(25).setBlockName("Slime_cake").setStepSound(Block.soundTypeCloth).setHardness(0.5F);

	public static Item icake1 = new ItemReed(cake1).setUnlocalizedName("Chocolate_cake").setTextureName(MODID+":chocolate_cake").setCreativeTab(cakeTab);
	public static Item icake2 = new ItemReed(cake2).setUnlocalizedName("Apple_cake").setTextureName(MODID+":apple_cake").setCreativeTab(cakeTab);
	public static Item icake3 = new ItemReed(cake3).setUnlocalizedName("Gold_cake").setTextureName(MODID+":gold_cake").setCreativeTab(cakeTab);
	public static Item icake4 = new ItemReed(cake4).setUnlocalizedName("Trapped_cake").setTextureName(MODID+":normal_cake").setCreativeTab(cakeTab);
	public static Item icake5 = new ItemReed(cake5).setUnlocalizedName("Poisoned_cake").setTextureName(MODID+":normal_cake").setCreativeTab(cakeTab);
	public static Item icake6 = new ItemReed(cake6).setUnlocalizedName("Lava_cake").setTextureName(MODID+":lava_cake").setCreativeTab(cakeTab);
	public static Item icake7 = new ItemReed(cake7).setUnlocalizedName("Basque_cake").setTextureName(MODID+":basque_cake").setCreativeTab(cakeTab);
	public static Item icake8 = new ItemReed(cake8).setUnlocalizedName("Redstone_cake").setTextureName(MODID+":redstone_cake").setCreativeTab(cakeTab);
	public static Item icake9 = new ItemReed(cake9).setUnlocalizedName("Brownie").setTextureName(MODID+":brownie").setCreativeTab(cakeTab);
	public static Item icake10 = new ItemReed(cake10).setUnlocalizedName("Chocolate_mousse").setTextureName(MODID+":chocolate_mousse").setCreativeTab(cakeTab);
	public static Item icake11 = new ItemReed(cake11).setUnlocalizedName("Cookies_cake").setTextureName(MODID+":cookies_cake").setCreativeTab(cakeTab);
	public static Item icake12 = new ItemReed(cake12).setUnlocalizedName("Ender_cake").setTextureName(MODID+":ender_cake").setCreativeTab(cakeTab);
	public static Item icake13 = new ItemReed(cake13).setUnlocalizedName("Pumpkin_cake").setTextureName(MODID+":pumpkin_cake").setCreativeTab(cakeTab);
	public static Item icake14 = new ItemReed(cake14).setUnlocalizedName("Spiced_cake").setTextureName(MODID+":spiced_cake").setCreativeTab(cakeTab);
	public static Item icake15 = new ItemReed(cake15).setUnlocalizedName("Sandy_cake").setTextureName(MODID+":sandy_cake").setCreativeTab(cakeTab);
	public static Item icake16 = new ItemReed(cake16).setUnlocalizedName("Stars_cake").setTextureName(MODID+":stars_cake").setCreativeTab(cakeTab);
	public static Item icake17 = new ItemReed(cake17).setUnlocalizedName("Water-melon_cake").setTextureName(MODID+":water-melon_cake").setCreativeTab(cakeTab);
	public static Item icake18 = new ItemReed(cake18).setUnlocalizedName("Nordic_cake").setTextureName(MODID+":nordic_cake").setCreativeTab(cakeTab);
	public static Item icake19 = new ItemReed(cake19).setUnlocalizedName("Anniversary_cake").setTextureName(MODID+":anniversary_cake").setCreativeTab(cakeTab);
	public static Item icake20 = new ItemReed(cake20).setUnlocalizedName("Paris_brest").setTextureName(MODID+":paris_brest").setCreativeTab(cakeTab);
	public static Item icake21 = new ItemReed(cake21).setUnlocalizedName("Meat_cake").setTextureName(MODID+":meat_cake").setCreativeTab(cakeTab);
	public static Item icake22 = new ItemReed(cake22).setUnlocalizedName("Cheese_cake").setTextureName(MODID+":cheese_cake").setCreativeTab(cakeTab);
	public static Item icake23 = new ItemReed(cake23).setUnlocalizedName("Chocolate_roll").setTextureName(MODID+":chocolate_roll").setCreativeTab(cakeTab);
	public static Item icake24 = new ItemReed(cake24).setUnlocalizedName("Carrot_cake").setTextureName(MODID+":carrot_cake").setCreativeTab(cakeTab);
	public static Item icake25 = new ItemReed(cake25).setUnlocalizedName("Slime_cake").setTextureName(MODID+":slime_cake").setCreativeTab(cakeTab);
	public static Item hunger = new ItemCakePotion(1).setUnlocalizedName("Hunger_potion").setTextureName(MODID+":hunger").setCreativeTab(cakeTab);
	public static Item sandy = new ItemCakePotion(2).setUnlocalizedName("Sandy_potion").setTextureName(MODID+":sandy").setCreativeTab(cakeTab);
	public static Item nordic = new ItemCakePotion(3).setUnlocalizedName("Nordic_potion").setTextureName(MODID+":nordic").setCreativeTab(cakeTab);
	public static Item creep = new ItemCakePotion(4).setUnlocalizedName("Creep_potion").setTextureName(MODID+":creep").setCreativeTab(cakeTab);

	public static Potion potionSandy;
	public static Potion potionNordic;
	public static Potion potionCreep;

	public static Achievement firstCake = new Achievement("cakeisalie.achievement.firstCake", "First", 0, 0, CakeIsALie.icake1, (Achievement)null).registerStat();
	public static Achievement poisonousCake = new Achievement("cakeisalie.achievement.poisonousCake", "Poisonous", 0, 2, CakeIsALie.icake5, firstCake).registerStat();
	public static Achievement trappedCake = new Achievement("cakeisalie.achievement.trappedCake", "Trapped", -2, 2, CakeIsALie.icake5, poisonousCake).registerStat();
	public static Achievement deathCake = new Achievement("cakeisalie.achievement.deathCake", "Death", -4, 2, new ItemStack(Items.skull, 1, 3), trappedCake).setSpecial().registerStat();
	public static Achievement anniversaryCake = new Achievement("cakeisalie.achievement.anniversaryCake", "Anniv", -2, 4, CakeIsALie.icake19, trappedCake).registerStat();
	public static Achievement explodeCreep = new Achievement("cakeisalie.achievement.explodeCreep", "Creep", 0, 4, Item.getItemFromBlock(Blocks.tnt), anniversaryCake).setSpecial().registerStat();
	public static Achievement appleCake = new Achievement("cakeisalie.achievement.appleCake", "Apple", 0, -2, CakeIsALie.icake2, firstCake).registerStat();
	public static Achievement watermelonCake = new Achievement("cakeisalie.achievement.watermelonCake", "Watermelon", -2, -4, CakeIsALie.icake17, appleCake).registerStat();
	public static Achievement appleGoldCake = new Achievement("cakeisalie.achievement.appleGoldCake", "AppleGold", -2, -2, CakeIsALie.icake3, appleCake).registerStat();
	public static Achievement pumpkinCake = new Achievement("cakeisalie.achievement.pumpkinCake", "Pumpkin", -3, 0, CakeIsALie.icake13, appleGoldCake).registerStat();
	public static Achievement spicedCake = new Achievement("cakeisalie.achievement.spicedCake", "Spiced", -6, 0, CakeIsALie.icake14, pumpkinCake).registerStat();
	public static Achievement starsCake = new Achievement("cakeisalie.achievement.starsCake", "Stars", -5, -3, CakeIsALie.icake16, pumpkinCake).registerStat();
	public static Achievement redstoneCake = new Achievement("cakeisalie.achievement.redstoneCake", "Redstone", 2, -1, CakeIsALie.icake8, firstCake).registerStat();
	public static Achievement lavaCake = new Achievement("cakeisalie.achievement.lavaCake", "Lava", 2, -3, CakeIsALie.icake6, redstoneCake).registerStat();
	public static Achievement nordicCake = new Achievement("cakeisalie.achievement.nordicCake", "Nordic", 4, -2, CakeIsALie.icake18, redstoneCake).registerStat();
	public static Achievement waterIced = new Achievement("cakeisalie.achievement.waterIced", "WaterIced", 5, -4, Item.getItemFromBlock(Blocks.ice), nordicCake).setSpecial().registerStat();
	public static Achievement chocolateRoll = new Achievement("cakeisalie.achievement.chocolateRoll", "Roll", 2, 1, CakeIsALie.icake23, firstCake).registerStat();
	public static Achievement sandyCake = new Achievement("cakeisalie.achievement.sandyCake", "Sandy", 4, 2, CakeIsALie.icake15, chocolateRoll).registerStat();
	public static Achievement suffocation = new Achievement("cakeisalie.achievement.suffocation", "Suffocation", 6, 0, Item.getItemFromBlock(Blocks.sand), sandyCake).setSpecial().registerStat();



	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){

    	System.out.println("CakeIsALie.preInit()"); //output to console.

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
    			System.err.println("Severe error, please report this to the mod author:");
    			System.err.println(r);
    		}
    	}


    	potionSandy = new PotionCake(72, false, 0).setIconIndex(0, 0).setPotionName("potion.Sandy_potion");
    	potionNordic = new PotionCake(73, false, 0).setIconIndex(1, 0).setPotionName("potion.Nordic_potion");
    	potionCreep = new PotionCake(74, false, 0).setIconIndex(2, 0).setPotionName("potion.Creep_potion");


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){

    	System.out.println("CakeIsALie.init()"); //output to console.

    	AchievementPage.registerAchievementPage(new AchievementPage("CakeIsALie", new Achievement[]{
    			firstCake, poisonousCake, trappedCake, deathCake, anniversaryCake, explodeCreep, appleCake, appleGoldCake, pumpkinCake, spicedCake, starsCake,
    			watermelonCake, redstoneCake, lavaCake, nordicCake, waterIced, chocolateRoll, sandyCake, suffocation
    	}));

    	proxy.registerRenderThings();



    	GameRegistry.registerBlock(cake1, "cake1");
    	GameRegistry.registerBlock(cake2, "cake2");
    	GameRegistry.registerBlock(cake3, "cake3");
    	GameRegistry.registerBlock(cake4, "cake4");
    	GameRegistry.registerBlock(cake5, "cake5");
    	GameRegistry.registerBlock(cake6, "cake6");
    	GameRegistry.registerBlock(cake7, "cake7");
    	GameRegistry.registerBlock(cake8, "cake8");
    	GameRegistry.registerBlock(cake9, "cake9");
    	GameRegistry.registerBlock(cake10, "cake10");
    	GameRegistry.registerBlock(cake11, "cake11");
    	GameRegistry.registerBlock(cake12, "cake12");
    	GameRegistry.registerBlock(cake13, "cake13");
    	GameRegistry.registerBlock(cake14, "cake14");
    	GameRegistry.registerBlock(cake15, "cake15");
    	GameRegistry.registerBlock(cake16, "cake16");
    	GameRegistry.registerBlock(cake17, "cake17");
    	GameRegistry.registerBlock(cake18, "cake18");
    	GameRegistry.registerBlock(cake19, "cake19");
    	GameRegistry.registerBlock(cake19w, "cake19w");
    	GameRegistry.registerBlock(cake20, "cake20");
    	GameRegistry.registerBlock(cake20w, "cake20w");
    	GameRegistry.registerBlock(cake20s, "cake20s");
    	GameRegistry.registerBlock(cake21, "cake21");
    	GameRegistry.registerBlock(cake22, "cake22");
    	GameRegistry.registerBlock(cake23, "cake23");
    	GameRegistry.registerBlock(cake24, "cake24");
    	GameRegistry.registerBlock(cake25, "cake25");

    	GameRegistry.registerItem(icake1, "icake1");
    	GameRegistry.registerItem(icake2, "icake2");
    	GameRegistry.registerItem(icake3, "icake3");
    	GameRegistry.registerItem(icake4, "icake4");
    	GameRegistry.registerItem(icake5, "icake5");
    	GameRegistry.registerItem(icake6, "icake6");
    	GameRegistry.registerItem(icake7, "icake7");
    	GameRegistry.registerItem(icake8, "icake8");
    	GameRegistry.registerItem(icake9, "icake9");
    	GameRegistry.registerItem(icake10, "icake10");
    	GameRegistry.registerItem(icake11, "icake11");
    	GameRegistry.registerItem(icake12, "icake12");
    	GameRegistry.registerItem(icake13, "icake13");
    	GameRegistry.registerItem(icake14, "icake14");
    	GameRegistry.registerItem(icake15, "icake15");
    	GameRegistry.registerItem(icake16, "icake16");
    	GameRegistry.registerItem(icake17, "icake17");
    	GameRegistry.registerItem(icake18, "icake18");
    	GameRegistry.registerItem(icake19, "icake19");
    	GameRegistry.registerItem(icake20, "icake20");
    	GameRegistry.registerItem(icake21, "icake21");
    	GameRegistry.registerItem(icake22, "icake22");
    	GameRegistry.registerItem(icake23, "icake23");
    	GameRegistry.registerItem(icake24, "icake24");
    	GameRegistry.registerItem(icake25, "icake25");
    	GameRegistry.registerItem(hunger, "hunger");
    	GameRegistry.registerItem(sandy, "sandy");
    	GameRegistry.registerItem(nordic, "nordic");
    	GameRegistry.registerItem(creep, "creep");


    	GameRegistry.registerTileEntity(com.toinane.cakeisalie.TileEntityAnniversary.class, "tileAnniversary");
    	GameRegistry.registerTileEntity(com.toinane.cakeisalie.TileEntityParisBrest.class, "tileParisBrest");
    	GameRegistry.registerTileEntity(com.toinane.cakeisalie.TileEntityParisBrest2.class, "tileParisBrest2");
    	GameRegistry.registerTileEntity(com.toinane.cakeisalie.TileEntityParisBrest3.class, "tileParisBrest3");


    	GameRegistry.addRecipe(new ItemStack(icake1, 1), new Object[]
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), new ItemStack(Items.dye, 1, 3), Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake2, 1), new Object[]
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.apple, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake3, 1), new Object[]
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.golden_apple, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake4, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.gunpowder, Character.valueOf('O'), Blocks.tnt, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake5, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.sugar, Character.valueOf('O'), Items.spider_eye, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake6, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.lava_bucket, Character.valueOf('A'), Items.blaze_powder, Character.valueOf('O'), Items.magma_cream, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake7, 1), new Object[]
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.egg, Character.valueOf('A'), Items.sugar, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake8, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.redstone, Character.valueOf('O'), Items.egg, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake9, 1), new Object[]
    	{"XXX", "AYA", "OOO", Character.valueOf('X'), new ItemStack(Items.dye, 1, 3), Character.valueOf('A'), Items.sugar, Character.valueOf('Y'), Items.egg, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake10, 1), new Object[]
    	{"XXX", "AAA", Character.valueOf('X'), new ItemStack(Items.dye, 1, 3), Character.valueOf('A'), Items.egg});
    	GameRegistry.addRecipe(new ItemStack(icake11, 1), new Object[]
    	{"XXX", "XYX", "OOO", Character.valueOf('X'), Items.cookie, Character.valueOf('Y'), Items.egg, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake12, 1), new Object[]
    	{"XXX", "AYA", "OOO", Character.valueOf('X'), Items.ender_pearl, Character.valueOf('A'), Items.sugar, Character.valueOf('Y'), Items.egg, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake13, 1), new Object[]
    	{"XXX", "AAA", "OOO", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Blocks.pumpkin, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake14, 1), new Object[]
    	{"XXX", "AYA", "OOO", Character.valueOf('X'), Items.sugar, Character.valueOf('A'), Items.fermented_spider_eye, Character.valueOf('Y'), Items.blaze_powder, Character.valueOf('O'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake15, 1), new Object[]
    	{"XXX", "AAA", "XXX", Character.valueOf('X'), Blocks.sandstone, Character.valueOf('A'), Items.egg});
    	GameRegistry.addRecipe(new ItemStack(icake16, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.nether_star, Character.valueOf('O'), Items.egg, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake17, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.melon, Character.valueOf('O'), Items.egg, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake18, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.snowball, Character.valueOf('A'), Blocks.packed_ice, Character.valueOf('O'), Items.fish, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake19, 1), new Object[]
    	{"XXX", "AOA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.sugar, Character.valueOf('O'), new ItemStack(Items.skull, 1, 4), Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake20, 1), new Object[]
    	{"XXX", "AAA", "XXX", Character.valueOf('X'), Items.wheat, Character.valueOf('A'), Items.egg});
    	GameRegistry.addRecipe(new ItemStack(icake21, 1), new Object[]
    	{"XXX", "XOX", "YYY", Character.valueOf('X'), Items.beef, Character.valueOf('O'), Items.cooked_beef, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake22, 1), new Object[]
    	{"XXX", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake23, 1), new Object[]
    	{"XXX", "XAX", "XXX", Character.valueOf('X'), new ItemStack(Items.dye, 1, 3), Character.valueOf('A'), Items.milk_bucket});
    	GameRegistry.addRecipe(new ItemStack(icake24, 1), new Object[]
    	{"XXX", "AAA", "YYY", Character.valueOf('X'), Items.milk_bucket, Character.valueOf('A'), Items.carrot, Character.valueOf('Y'), Items.wheat});
    	GameRegistry.addRecipe(new ItemStack(icake25, 1), new Object[]
    	{"XXX", "X X", "YYY", Character.valueOf('X'), Items.slime_ball, Character.valueOf('Y'), Items.wheat});

    	GameRegistry.addRecipe(new ItemStack(hunger, 1), new Object[]
    	{"X", "Y", Character.valueOf('X'), Items.clay_ball, Character.valueOf('Y'), new ItemStack(Items.potionitem, 1, 0)});

    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	// IMPORTANT: Be sure to register your handler on the correct bus!!! (see below)

    	// the majority of events use the MinecraftForge event bus:
    	MinecraftForge.EVENT_BUS.register(new CakeHooks());

    	// but some are on the FML bus:
    	FMLCommonHandler.instance().bus().register(new EventHandlerCake());

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
