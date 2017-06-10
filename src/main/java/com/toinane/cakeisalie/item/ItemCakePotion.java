package com.toinane.cakeisalie.item;

import java.util.Iterator;
import java.util.List;

import com.toinane.cakeisalie.CakeIsALie;
import com.toinane.cakeisalie.CommonProxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCakePotion extends Item {
	
	private String potion;
	private boolean isSplash;

	public ItemCakePotion(String name, boolean splash) {
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		potion = name;
		isSplash = splash;
		this.setCreativeTab(CommonProxy.cake_tab);
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
        		player.addPotionEffect(new PotionEffect(CommonProxy.potionSandy, 400, 4));
        	}
        	else if(potion == "nordic"){
        		player.addPotionEffect(new PotionEffect(CommonProxy.potionNordic, 1600, 4));
        	}
        	else if(potion == "creep"){
        		player.addPotionEffect(new PotionEffect(CommonProxy.potionCreep, 500, 4));
        	}
        	else if(potion == "slime"){
        		player.addPotionEffect(new PotionEffect(CommonProxy.potionSlime, 450, 4));
        	}
        	
        }

        if (!player.capabilities.isCreativeMode) {
            if (item.stackSize <= 0){
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
        }
        return item;
    }


    public int getMaxItemUseDuration(ItemStack item){
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack item){
        return EnumAction.DRINK;
    }
    

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int ok, int wtf, int nawak, int okok, float why, float ahah, float nul){
        return false;
    }
    
}
