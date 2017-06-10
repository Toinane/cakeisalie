package com.toinane.cakeisalie;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	public void preInit() {
		super.preInit();
	    
  	    ModelLoader.setCustomModelResourceLocation(item_chocolate_cake		, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_chocolate_cake"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_apple_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_apple_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_gold_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_gold_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_trapped_cake		, 0, new ModelResourceLocation("cake", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_poisoned_cake		, 0, new ModelResourceLocation("cake", "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_lava_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_lava_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_basque_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_basque_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_redstone_cake		, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_redstone_cake"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_brownie				, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_brownie"				, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_chocolate_mousse	, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_chocolate_mousse"	, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_cookies_cake		, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_cookies_cake"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_ender_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_ender_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_pumpkin_cake		, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_pumpkin_cake"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_spiced_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_spiced_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_sandy_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_sandy_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_stars_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_stars_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_watermelon_cake		, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_watermelon_cake"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_nordic_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_nordic_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_anniversary_cake	, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_anniversary_cake"	, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_paris_brest			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_paris_brest"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_hamburger			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_hamburger"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_cheese_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_cheese_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_chocolate_roll		, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_chocolate_roll"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_carrot_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_carrot_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_slime_cake			, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_slime_cake"			, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(item_muffins				, 0, new ModelResourceLocation(CakeIsALie.MODID+":item_muffins"				, "inventory"));
	    
	    ModelLoader.setCustomModelResourceLocation(potion_hunger	, 0, new ModelResourceLocation(CakeIsALie.MODID+":potion_hunger"	, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(potion_sandy		, 0, new ModelResourceLocation(CakeIsALie.MODID+":potion_sandy"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(potion_nordic	, 0, new ModelResourceLocation(CakeIsALie.MODID+":potion_nordic"	, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(potion_creep		, 0, new ModelResourceLocation(CakeIsALie.MODID+":potion_creep"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(potion_slime		, 0, new ModelResourceLocation(CakeIsALie.MODID+":potion_slime"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(splash_hunger	, 0, new ModelResourceLocation(CakeIsALie.MODID+":splash_hunger"	, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(splash_sandy		, 0, new ModelResourceLocation(CakeIsALie.MODID+":splash_sandy"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(splash_nordic	, 0, new ModelResourceLocation(CakeIsALie.MODID+":splash_nordic"	, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(splash_creep		, 0, new ModelResourceLocation(CakeIsALie.MODID+":splash_creep"		, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(splash_slime		, 0, new ModelResourceLocation(CakeIsALie.MODID+":splash_slime"		, "inventory"));
	
	}

	public void init() {
		super.init();

		
	}

	public void postInit() {
		super.postInit();
	}

	@Override
	public boolean playerIsInCreativeMode(EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
			return entityPlayerMP.interactionManager.isCreative();
		} else if (player instanceof EntityPlayerSP) {
			return Minecraft.getMinecraft().playerController.isInCreativeMode();
		}
		return false;
	}

	@Override
	public boolean isDedicatedServer() {return false;}
}