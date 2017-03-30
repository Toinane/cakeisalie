package com.toinane.cakeisalie;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AchievementEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.entity.monster.EntityCreeper;

public class CakeHooks {

	Random generator = new Random();

	private int iceTotal = 0;

	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event){
		if(event.entity instanceof EntityCreeper && event.source.getDamageType() == "explosion.player"){
			if(event.source.getSourceOfDamage() instanceof EntityPlayer){
				((EntityPlayer) event.source.getSourceOfDamage()).addStat(CakeIsALie.explodeCreep, 1);
			}
		}
	}



	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
	     //entityLiving in fact refers to EntityLivingBase so to understand everything about this part go to EntityLivingBase instead
	     if (event.entityLiving.isPotionActive(CakeIsALie.potionSandy.id)){
	    	 double velX;
    		 double velZ;

    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 1.0D) - 1.0D; }
    		 else{ velX = (generator.nextDouble() * 1.0D); }
    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 1.0D) - 1.0D; }
    		 else{ velZ = (generator.nextDouble() * 1.0D); }

	    	 event.entity.worldObj.spawnParticle("mobSpell", event.entityLiving.posX + velX, event.entityLiving.posY + Math.random()*(0.0D - 1.0D), event.entityLiving.posZ + velZ, 0.0D, 0.2D, 0.0D);
	         if (event.entityLiving.worldObj.rand.nextInt(20) <= 1){
	        	 event.entityLiving.dropItem(Item.getItemFromBlock(Blocks.sand), 1);
	        	((EntityPlayer) event.entityLiving).addStat(CakeIsALie.suffocation, 1);
	         }
	     }
	     else if(event.entityLiving.isPotionActive(CakeIsALie.potionNordic.id)){

    		 int posX = (int) event.entityLiving.posX;
    		 int posY = (int) event.entityLiving.posY - 1;
    		 int posZ = (int) event.entityLiving.posZ;

    		 if(posX < 0){ posX--; }
    		 if(posZ < 0){ posZ--; }

    		 double velX;
    		 double velZ;

    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.1D) - 0.1D; }
    		 else{ velX = (generator.nextDouble() * 0.1D); }
    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.1D) - 0.1D; }
    		 else{ velZ = (generator.nextDouble() * 0.1D); }

    		 event.entity.worldObj.spawnParticle("snowshovel", event.entityLiving.posX , event.entityLiving.posY - Math.random()*(1.6D - 0.0D), event.entityLiving.posZ, velX, 0.2D, velZ);

    		 Block block = event.entityLiving.worldObj.getBlock(posX, posY, posZ);
    		 Block block2 = event.entityLiving.worldObj.getBlock(posX+1, posY, posZ);
    		 Block block3 = event.entityLiving.worldObj.getBlock(posX, posY, posZ+1);
    		 Block block4 = event.entityLiving.worldObj.getBlock(posX-1, posY, posZ);
    		 Block block5 = event.entityLiving.worldObj.getBlock(posX, posY, posZ-1);
    		 if(block == Blocks.water){
    			 event.entityLiving.worldObj.setBlock(posX, posY, posZ, Blocks.ice);
    			 iceTotal++;
    		 }
    		 if(block2 == Blocks.water){
    			 event.entityLiving.worldObj.setBlock(posX+1, posY, posZ, Blocks.ice);
    		 }
    		 if(block3 == Blocks.water){
    			 event.entityLiving.worldObj.setBlock(posX, posY, posZ+1, Blocks.ice);
    		 }
    		 if(block4 == Blocks.water){
    			 event.entityLiving.worldObj.setBlock(posX-1, posY, posZ, Blocks.ice);
    		 }
    		 if(block5 == Blocks.water){
    			 event.entityLiving.worldObj.setBlock(posX, posY, posZ-1, Blocks.ice);
    		 }
    		 if(iceTotal == 100){
    			 ((EntityPlayer) event.entityLiving).addStat(CakeIsALie.waterIced, 1);
    			 iceTotal = 0;
    		 }
	     }
	     else if(event.entityLiving.isPotionActive(CakeIsALie.potionCreep.id)){
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() == 50){
	    		 event.entityLiving.playSound("creeper.primed", 1.0F, 1F);
	    	 }
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() >= 70 && event.entityLiving.worldObj.rand.nextInt(20) <= 5){
	    		 double velX;
	    		 double velZ;

	    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velX = (generator.nextDouble() * 0.25D); }
	    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velZ = (generator.nextDouble() * 0.25D); }

	    		 event.entity.worldObj.spawnParticle("cloud", event.entityLiving.posX , event.entityLiving.posY - Math.random()*(1.6D - 0.0D), event.entityLiving.posZ, velX, 0.2D, velZ);

	    	 }
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() <= 70){
	    		 double velX;
	    		 double velZ;

	    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velX = (generator.nextDouble() * 0.25D); }
	    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velZ = (generator.nextDouble() * 0.25D); }

	    		 event.entity.worldObj.spawnParticle("explode", event.entityLiving.posX , event.entityLiving.posY - Math.random()*(1.6D - 0.0D), event.entityLiving.posZ, velX, 0.2D, velZ);
	    	 }
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() <= 2){
	    		 if(!event.entityLiving.worldObj.isRemote){
	    			 event.entityLiving.worldObj.createExplosion(event.entityLiving,  event.entityLiving.posX,  event.entityLiving.posY,  event.entityLiving.posZ, 5.5F, true);
	    			 event.entityLiving.attackEntityFrom(DamageSource.setExplosionSource(null), Float.MAX_VALUE);
	     		}
	    	 }
	     }
	}




}
