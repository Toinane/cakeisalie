package com.toinane.cakeisalie;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemCakePotion extends Item {
	
	private String potion;
	private boolean isSplash;

	public ItemCakePotion(String name, boolean splash) {
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		potion = name;
		isSplash = splash;
	}


	public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }
	
	
	public ItemStack onItemUseFinish(ItemStack item, World world, EntityPlayer player){
        if (!player.capabilities.isCreativeMode){
            --item.stackSize;
        }

        if (!world.isRemote){
        	if(potion == "hunger"){
        		if(!player.capabilities.isCreativeMode){
        			if(player.getFoodStats().getFoodLevel() -10 > 0){
        				player.getFoodStats().addStats(-10, 0.1F);
        			}
        			else{
        				player.getFoodStats().setFoodLevel(0);
        			}
        		}
        	}
        	else if(potion == "sandy"){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy.id, 400, 4));
        	}
        	else if(potion == "nordic"){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic.id, 1600, 4));
        	}
        	else if(potion == "creep"){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep.id, 500, 4));
        	}
        	else if(potion == "slime"){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionSlime.id, 450, 4));
        	}
        	
        }

        if (!player.capabilities.isCreativeMode) {
            if (item.stackSize <= 0){
                return new ItemStack(Items.glass_bottle);
            }
            player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }
        return item;
    }


    public int getMaxItemUseDuration(ItemStack item){
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack item){
        return EnumAction.DRINK;
    }
    

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
    	if(isSplash)
        {
            if (!player.capabilities.isCreativeMode)
            {
                --item.stackSize;
            }

            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(new EntityCakePotion(world, player, item));
            }

            return item;
        }
        else
        {
            player.setItemInUse(item, this.getMaxItemUseDuration(item));
            return item;
        }
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int ok, int wtf, int nawak, int okok, float why, float ahah, float nul){
        return false;
    }
    
}
