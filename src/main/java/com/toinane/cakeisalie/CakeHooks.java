package com.toinane.cakeisalie;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.AchievementEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
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
	public void onEntityJump(LivingJumpEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(player.isPotionActive(CakeIsALie.potionSlime.id)){
				player.motionY = 0.8F;
			}
		}
	}
	
	
	/*@SubscribeEvent
	public void onEntityAttack(LivingAttackEvent event)
	{
		if(event.source.getSourceOfDamage() != null){
			if(event.source.getSourceOfDamage() instanceof EntityLivingBase){
				
				EntityLivingBase entity = (EntityLivingBase)event.source.getSourceOfDamage();
				
				if(entity.isPotionActive(CakeIsALie.potionSandy.id)){
					entity.dropItem(Items.cake, 1);
				}
			}
		}
	}*/
	
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event){
		//System.out.println(event.crafting);
		 if(event.crafting.getItem() == CakeIsALie.item_chocolate_cake){
			 event.player.addStat(CakeIsALie.firstCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_apple_cake){
			 event.player.addStat(CakeIsALie.appleCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_gold_cake){
			 event.player.addStat(CakeIsALie.appleGoldCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_trapped_cake){
			 event.player.addStat(CakeIsALie.trappedCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_poisoned_cake){
			 event.player.addStat(CakeIsALie.poisonousCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_pumpkin_cake){
			 event.player.addStat(CakeIsALie.pumpkinCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_spiced_cake){
			 event.player.addStat(CakeIsALie.spicedCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_stars_cake){
			 event.player.addStat(CakeIsALie.starsCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_anniversary_cake){
			 event.player.addStat(CakeIsALie.anniversaryCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_watermelon_cake){
			 event.player.addStat(CakeIsALie.watermelonCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_redstone_cake){
			 event.player.addStat(CakeIsALie.redstoneCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_lava_cake){
			 event.player.addStat(CakeIsALie.lavaCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_nordic_cake){
			 event.player.addStat(CakeIsALie.nordicCake, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_chocolate_roll){
			 event.player.addStat(CakeIsALie.chocolateRoll, 1);
		 }
		 else if(event.crafting.getItem() == CakeIsALie.item_sandy_cake){
			 event.player.addStat(CakeIsALie.sandyCake, 1);
		 }
	 }
	

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		 World world = event.entity.getEntityWorld();

	     if (event.entityLiving.isPotionActive(CakeIsALie.potionSandy.id)){
	    	 double velX;
    		 double velZ;
    		 
    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 1.0D) - 1.0D; }
    		 else{ velX = (generator.nextDouble() * 1.0D); }
    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 1.0D) - 1.0D; }
    		 else{ velZ = (generator.nextDouble() * 1.0D); }
    		 
	    	 event.entityLiving.worldObj.spawnParticle(EnumParticleTypes.SPELL_MOB, event.entityLiving.posX + velX, event.entityLiving.posY + Math.random()*(0.0D - 1.0D), event.entityLiving.posZ + velZ, 0.0D, 0.2D, 0.0D);
	         if (world.rand.nextInt(20) <= 1){
	        	 if(!world.isRemote){ // server side only
	        		 //event.entityLiving.dropItem(Item.getItemFromBlock(Blocks.sand), 1);
	        		 event.entityLiving.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.sand), 1), 1.1f);
	        	 }
	        	 if(event.entityLiving instanceof EntityPlayer){
	        		 ((EntityPlayer) event.entityLiving).addStat(CakeIsALie.suffocation, 1);
	        	 }
	         }
	     }
	     
	     
	     
	     if(event.entityLiving.isPotionActive(CakeIsALie.potionNordic.id)){
	    	 
    		 int posX = (int) event.entityLiving.posX;
    		 int posY = (int) event.entityLiving.posY - 1;
    		 int posZ = (int) event.entityLiving.posZ;
    		 
    		 if(posX < 0){ posX--; }
    		 if(posZ < 0){ posZ--; }
    		 
    		 double velX;
    		 double velZ;
    		 double velY;
    		 
    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.1D) - 0.1D; }
    		 else{ velX = (generator.nextDouble() * 0.1D); }
    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.1D) - 0.1D; }
    		 else{ velZ = (generator.nextDouble() * 0.1D); }
    		 if(generator.nextInt(10) <= 5){  velY = (generator.nextDouble() * 0.5D) - 0.1D; }
    		 else{ velY = (generator.nextDouble() * 0.1D); }
    		 
    		 int rand = (int) (Math.random()*(3 - 0));
    		 if(rand == 0 && world.isRemote){
    			 world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, event.entityLiving.posX , event.entityLiving.posY + Math.random()*(2.0D - 0.0D), event.entityLiving.posZ, velX, 0.2D, velZ); 
    		 }
    		 	 
    		 BlockPos pos1 = new BlockPos(posX, posY, posZ);
    		 BlockPos pos2 = new BlockPos(posX+1, posY, posZ);
    		 BlockPos pos3 = new BlockPos(posX, posY, posZ+1);
    		 BlockPos pos4 = new BlockPos(posX-1, posY, posZ);
    		 BlockPos pos5 = new BlockPos(posX, posY, posZ-1);
    		 
    		 Block block = world.getBlockState(pos1).getBlock();
    		 Block block2 = world.getBlockState(pos2).getBlock();
    		 Block block3 = world.getBlockState(pos3).getBlock();
    		 Block block4 = world.getBlockState(pos4).getBlock();
    		 Block block5 = world.getBlockState(pos5).getBlock();
    		 
    		 if(block == Blocks.water){
    			 event.entityLiving.worldObj.setBlockState(pos1, Blocks.ice.getDefaultState()); 
    			 iceTotal++;
    		 }
    		 if(block2 == Blocks.water){
    			 event.entityLiving.worldObj.setBlockState(pos2, Blocks.ice.getDefaultState()); 
    		 }
    		 if(block3 == Blocks.water){
    			 event.entityLiving.worldObj.setBlockState(pos3, Blocks.ice.getDefaultState()); 
    		 }
    		 if(block4 == Blocks.water){
    			 event.entityLiving.worldObj.setBlockState(pos4, Blocks.ice.getDefaultState());  
    		 }
    		 if(block5 == Blocks.water){
    			 event.entityLiving.worldObj.setBlockState(pos5, Blocks.ice.getDefaultState()); 
    		 }
    		 if(iceTotal == 100){
    			 if(event.entityLiving instanceof EntityPlayer){
    				 ((EntityPlayer) event.entityLiving).addStat(CakeIsALie.waterIced, 1);
	        	 }
    			 iceTotal = 0;
    		 }
	     }
	     
	     
	     
	     if(event.entityLiving.isPotionActive(CakeIsALie.potionCreep.id)){
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() == 50){
	    		 event.entityLiving.playSound("creeper.primed", 1.0F, 1F);
	    	 }
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() >= 70 && world.rand.nextInt(20) <= 5){
	    		 double velX;
	    		 double velZ;
	    		 
	    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velX = (generator.nextDouble() * 0.25D); }
	    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velZ = (generator.nextDouble() * 0.25D); }
	    		 
	    		 if(world.isRemote){
	    			 world.spawnParticle(EnumParticleTypes.CLOUD, event.entityLiving.posX , event.entityLiving.posY - Math.random()*(1.6D - 0.0D), event.entityLiving.posZ, velX, 0.2D, velZ);
	    		 }
	    	 }
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() <= 70){
	    		 double velX;
	    		 double velZ;
	    		 
	    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velX = (generator.nextDouble() * 0.25D); }
	    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velZ = (generator.nextDouble() * 0.25D); }
	    		 
	    		 if(world.isRemote){
	    			 world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, event.entityLiving.posX , event.entityLiving.posY - Math.random()*(1.6D - 0.0D), event.entityLiving.posZ, velX, 0.2D, velZ);
	    	 
	    		 }
	    	 }
	    	 if(event.entityLiving.getActivePotionEffect(CakeIsALie.potionCreep).getDuration() <= 2){
	    		 if(!world.isRemote){
	    			 world.createExplosion(event.entityLiving,  event.entityLiving.posX,  event.entityLiving.posY,  event.entityLiving.posZ, 5.5F, true);
	    			 event.entityLiving.attackEntityFrom(DamageSource.setExplosionSource(null), Float.MAX_VALUE);
	     		}
	    	 }
	     }
	     
	     
	     
	     if(event.entityLiving.isPotionActive(CakeIsALie.potionSlime.id)){

 			BlockPos topPlayer = new BlockPos(event.entityLiving.posX, event.entityLiving.posY+2, event.entityLiving.posZ);
			if(!world.getBlockState(topPlayer).getBlock().equals(Blocks.air) && !event.entityLiving.isSneaking()){
				event.entityLiving.motionY = 0.0D;
				event.entityLiving.posY = event.entityLiving.lastTickPosY;
			}
 			
			if(event.entityLiving.isCollidedVertically && event.entityLiving.onGround){

				double velX;
	    		double velZ;
	    		 
	    		if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velX = (generator.nextDouble() * 0.25D); }
	    		if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velZ = (generator.nextDouble() * 0.25D); }
				
	    		if(world.isRemote){
	    			world.spawnParticle(EnumParticleTypes.SLIME, event.entityLiving.posX, event.entityLiving.posY+0.4F, event.entityLiving.posZ, velX, 0.2D, velZ);
	    		}
	    		if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velX = (generator.nextDouble() * 0.25D); }
	    		if(world.isRemote){
	    			world.spawnParticle(EnumParticleTypes.SLIME, event.entityLiving.posX, event.entityLiving.posY+0.4F, event.entityLiving.posZ, velX, 0.2D, velZ);
	    		}
	    		if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velZ = (generator.nextDouble() * 0.25D); }
	    		if(world.isRemote){
	    			world.spawnParticle(EnumParticleTypes.SLIME, event.entityLiving.posX, event.entityLiving.posY+0.4F, event.entityLiving.posZ, velX, 0.2D, velZ);
	    		}
	    		
	    		event.entityLiving.playSound("mob.slime.big", 1.0f, 1.0f);
	    		event.entityLiving.motionY = 0.5F;

			}
	 	}
	}

}
