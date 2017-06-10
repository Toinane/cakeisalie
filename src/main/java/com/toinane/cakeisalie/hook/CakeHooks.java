package com.toinane.cakeisalie.hook;

import java.util.Random;

import com.toinane.cakeisalie.CakeIsALie;
import com.toinane.cakeisalie.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
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
		if(event.getEntity() instanceof EntityCreeper && event.getSource().getDamageType() == "explosion.player"){
			if(event.getSource().getSourceOfDamage() instanceof EntityPlayer){
				((EntityPlayer) event.getSource().getSourceOfDamage()).addStat(CommonProxy.explodeCreep, 1);
			}
			
		}
	}
	
	@SubscribeEvent
	public void onEntityJump(LivingJumpEvent event){
		if(event.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if(player.isPotionActive(CommonProxy.potionSlime)){
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
		 if(event.crafting.getItem() == CommonProxy.item_chocolate_cake){
			 event.player.addStat(CommonProxy.firstCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_apple_cake){
			 event.player.addStat(CommonProxy.appleCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_gold_cake){
			 event.player.addStat(CommonProxy.appleGoldCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_trapped_cake){
			 event.player.addStat(CommonProxy.trappedCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_poisoned_cake){
			 event.player.addStat(CommonProxy.poisonousCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_pumpkin_cake){
			 event.player.addStat(CommonProxy.pumpkinCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_spiced_cake){
			 event.player.addStat(CommonProxy.spicedCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_stars_cake){
			 event.player.addStat(CommonProxy.starsCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_anniversary_cake){
			 event.player.addStat(CommonProxy.anniversaryCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_watermelon_cake){
			 event.player.addStat(CommonProxy.watermelonCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_redstone_cake){
			 event.player.addStat(CommonProxy.redstoneCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_lava_cake){
			 event.player.addStat(CommonProxy.lavaCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_nordic_cake){
			 event.player.addStat(CommonProxy.nordicCake, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_chocolate_roll){
			 event.player.addStat(CommonProxy.chocolateRoll, 1);
		 }
		 else if(event.crafting.getItem() == CommonProxy.item_sandy_cake){
			 event.player.addStat(CommonProxy.sandyCake, 1);
		 }
	 }
	

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		 World world = event.getEntity().getEntityWorld();

	     if (event.getEntityLiving().isPotionActive(CommonProxy.potionSandy)){
	    	 double velX;
    		 double velZ;
    		 
    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 1.0D) - 1.0D; }
    		 else{ velX = (generator.nextDouble() * 1.0D); }
    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 1.0D) - 1.0D; }
    		 else{ velZ = (generator.nextDouble() * 1.0D); }
    		 
	    	 event.getEntityLiving().worldObj.spawnParticle(EnumParticleTypes.SPELL_MOB, event.getEntityLiving().posX + velX, event.getEntityLiving().posY + Math.random()*(0.0D - 1.0D), event.getEntityLiving().posZ + velZ, 0.0D, 0.2D, 0.0D);
	         if (world.rand.nextInt(20) <= 1){
	        	 if(!world.isRemote){ // server side only
	        		 //event.entityLiving.dropItem(Item.getItemFromBlock(Blocks.sand), 1);
	        		 event.getEntityLiving().entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.SAND), 1), 1.1f);
	        	 }
	        	 if(event.getEntityLiving() instanceof EntityPlayer){
	        		 ((EntityPlayer) event.getEntityLiving()).addStat(CommonProxy.suffocation, 1);
	        	 }
	         }
	     }
	     
	     
	     
	     if(event.getEntityLiving().isPotionActive(CommonProxy.potionNordic)){
	    	 
    		 int posX = (int) event.getEntityLiving().posX;
    		 int posY = (int) event.getEntityLiving().posY - 1;
    		 int posZ = (int) event.getEntityLiving().posZ;
    		 
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
    			 world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, event.getEntityLiving().posX , event.getEntityLiving().posY + Math.random()*(2.0D - 0.0D), event.getEntityLiving().posZ, velX, 0.2D, velZ); 
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
    		 
    		 if(block == Blocks.WATER){
    			 event.getEntityLiving().worldObj.setBlockState(pos1, Blocks.ICE.getDefaultState()); 
    			 iceTotal++;
    		 }
    		 if(block2 == Blocks.WATER){
    			 event.getEntityLiving().worldObj.setBlockState(pos2, Blocks.ICE.getDefaultState()); 
    		 }
    		 if(block3 == Blocks.WATER){
    			 event.getEntityLiving().worldObj.setBlockState(pos3, Blocks.ICE.getDefaultState()); 
    		 }
    		 if(block4 == Blocks.WATER){
    			 event.getEntityLiving().worldObj.setBlockState(pos4, Blocks.ICE.getDefaultState());  
    		 }
    		 if(block5 == Blocks.WATER){
    			 event.getEntityLiving().worldObj.setBlockState(pos5, Blocks.ICE.getDefaultState()); 
    		 }
    		 if(iceTotal == 100){
    			 if(event.getEntityLiving() instanceof EntityPlayer){
    				 ((EntityPlayer) event.getEntityLiving()).addStat(CommonProxy.waterIced, 1);
	        	 }
    			 iceTotal = 0;
    		 }
	     }
	     
	     
	     
	     if(event.getEntityLiving().isPotionActive(CommonProxy.potionCreep)){
	    	 if(event.getEntityLiving().getActivePotionEffect(CommonProxy.potionCreep).getDuration() == 50){
	    		 event.getEntityLiving().playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 1F);
	    	 }
	    	 if(event.getEntityLiving().getActivePotionEffect(CommonProxy.potionCreep).getDuration() >= 70 && world.rand.nextInt(20) <= 5){
	    		 double velX;
	    		 double velZ;
	    		 
	    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velX = (generator.nextDouble() * 0.25D); }
	    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velZ = (generator.nextDouble() * 0.25D); }
	    		 
	    		 if(world.isRemote){
	    			 world.spawnParticle(EnumParticleTypes.CLOUD, event.getEntityLiving().posX , event.getEntityLiving().posY - Math.random()*(1.6D - 0.0D), event.getEntityLiving().posZ, velX, 0.2D, velZ);
	    		 }
	    	 }
	    	 if(event.getEntityLiving().getActivePotionEffect(CommonProxy.potionCreep).getDuration() <= 70){
	    		 double velX;
	    		 double velZ;
	    		 
	    		 if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velX = (generator.nextDouble() * 0.25D); }
	    		 if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		 else{ velZ = (generator.nextDouble() * 0.25D); }
	    		 
	    		 if(world.isRemote){
	    			 world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, event.getEntityLiving().posX , event.getEntityLiving().posY - Math.random()*(1.6D - 0.0D), event.getEntityLiving().posZ, velX, 0.2D, velZ);
	    	 
	    		 }
	    	 }
	    	 if(event.getEntityLiving().getActivePotionEffect(CommonProxy.potionCreep).getDuration() <= 2){
	    		 if(!world.isRemote){
	    			 world.createExplosion(event.getEntityLiving(),  event.getEntityLiving().posX,  event.getEntityLiving().posY,  event.getEntityLiving().posZ, 5.5F, true);
	    			 event.getEntityLiving().attackEntityFrom(DamageSource.causeExplosionDamage(event.getEntityLiving()), Float.MAX_VALUE);
	     		}
	    	 }
	     }
	     
	     
	     
	     if(event.getEntityLiving().isPotionActive(CommonProxy.potionSlime)){

 			BlockPos topPlayer = new BlockPos(event.getEntityLiving().posX, event.getEntityLiving().posY+2, event.getEntityLiving().posZ);
			if(!world.getBlockState(topPlayer).getBlock().equals(Blocks.AIR) && !event.getEntityLiving().isSneaking()){
				event.getEntityLiving().motionY = 0.0D;
				event.getEntityLiving().posY = event.getEntityLiving().lastTickPosY;
			}
 			
			if(event.getEntityLiving().isCollidedVertically && event.getEntityLiving().onGround){

				double velX;
	    		double velZ;
	    		 
	    		if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velX = (generator.nextDouble() * 0.25D); }
	    		if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velZ = (generator.nextDouble() * 0.25D); }
				
	    		if(world.isRemote){
	    			world.spawnParticle(EnumParticleTypes.SLIME, event.getEntityLiving().posX, event.getEntityLiving().posY+0.4F, event.getEntityLiving().posZ, velX, 0.2D, velZ);
	    		}
	    		if(generator.nextInt(10) <= 5){ velX = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velX = (generator.nextDouble() * 0.25D); }
	    		if(world.isRemote){
	    			world.spawnParticle(EnumParticleTypes.SLIME, event.getEntityLiving().posX, event.getEntityLiving().posY+0.4F, event.getEntityLiving().posZ, velX, 0.2D, velZ);
	    		}
	    		if(generator.nextInt(10) <= 5){  velZ = (generator.nextDouble() * 0.25D) - 0.25D; }
	    		else{ velZ = (generator.nextDouble() * 0.25D); }
	    		if(world.isRemote){
	    			world.spawnParticle(EnumParticleTypes.SLIME, event.getEntityLiving().posX, event.getEntityLiving().posY+0.4F, event.getEntityLiving().posZ, velX, 0.2D, velZ);
	    		}
	    		
	    		event.getEntityLiving().playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
	    		event.getEntityLiving().motionY = 0.5F;

			}
	 	}
	}

}
