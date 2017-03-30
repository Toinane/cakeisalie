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
import net.minecraft.world.World;

public class ItemCakePotion extends Item {
	
	private int potion;
	
	public ItemCakePotion(int i) {
		potion = i;
	}


	public boolean hasEffect(ItemStack par1ItemStack){
        return true;
    }
	
	
	public ItemStack onEaten(ItemStack item, World world, EntityPlayer player){
        if (!player.capabilities.isCreativeMode){
            --item.stackSize;
        }

        if (!world.isRemote){
        	if(potion == 1){
        		if(!player.capabilities.isCreativeMode){
        			player.getFoodStats().addStats(-10, 0.1F);
        		}
        	}
        	else if(potion == 2){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy.id, 400, 4));
        	}
        	else if(potion == 3){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic.id, 1600, 4));
        	}
        	else if(potion == 4){
        		player.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep.id, 500, 4));
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
        return EnumAction.drink;
    }
    

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        player.setItemInUse(item, this.getMaxItemUseDuration(item));
		return item;
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int ok, int wtf, int nawak, int okok, float why, float ahah, float nul){
        return false;
    }
    
}
