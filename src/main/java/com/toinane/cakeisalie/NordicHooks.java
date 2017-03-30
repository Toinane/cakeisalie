package com.toinane.cakeisalie;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class NordicHooks {

	
	@SubscribeEvent
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
	}
	
}
