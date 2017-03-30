package com.toinane.cakeisalie;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class EventHandlerCake {

	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event){
		System.out.println(event.crafting);
		 if(event.crafting.getItem() == CakeIsALie.icake1){
			 event.player.addStat(CakeIsALie.firstCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake2){
			 event.player.addStat(CakeIsALie.appleCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake3){
			 event.player.addStat(CakeIsALie.appleGoldCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake4){
			 event.player.addStat(CakeIsALie.trappedCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake5){
			 event.player.addStat(CakeIsALie.poisonousCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake13){
			 event.player.addStat(CakeIsALie.pumpkinCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake14){
			 event.player.addStat(CakeIsALie.spicedCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake16){
			 event.player.addStat(CakeIsALie.starsCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake19){
			 event.player.addStat(CakeIsALie.anniversaryCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake17){
			 event.player.addStat(CakeIsALie.watermelonCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake8){
			 event.player.addStat(CakeIsALie.redstoneCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake6){
			 event.player.addStat(CakeIsALie.lavaCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake18){
			 event.player.addStat(CakeIsALie.nordicCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake23){
			 event.player.addStat(CakeIsALie.chocolateRoll, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.icake15){
			 event.player.addStat(CakeIsALie.sandyCake, 1);
		 }
	 }


	
}
