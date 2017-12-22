package com.toinane.cakeisalie.item;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.toinane.cakeisalie.CakeIsALie;
import com.toinane.cakeisalie.CommonProxy;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPotionCakes extends Item {
	
	private String potion;
	private boolean isSplash;

	public ItemPotionCakes(String name, boolean splash) {
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		potion = name;
		isSplash = splash;
		this.setCreativeTab(CommonProxy.cake_tab);
	}

	public ItemStack onItemUseFinish(ItemStack item, World world, EntityPlayer player){
        if (!player.capabilities.isCreativeMode){
            item.shrink(1);
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
            if (item.getCount() <= 0){
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
        }
        return item;
    }
	
	@SideOnly(Side.CLIENT)
    public ItemStack getDefaultInstance()
    {
        return PotionUtils.addPotionToItemStack(super.getDefaultInstance(), PotionTypes.WATER);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;

        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
        {
            stack.shrink(1);
        }

        if (entityplayer instanceof EntityPlayerMP)
        {
            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
        }

        if (!worldIn.isRemote)
        {
        	if(potion == "hunger"){
        		if(!entityplayer.capabilities.isCreativeMode){
        			if(entityplayer.getFoodStats().getFoodLevel() -10 > 0){
        				entityplayer.getFoodStats().addStats(-10, 0.1F);
        			}
        			else{
        				entityplayer.getFoodStats().setFoodLevel(0);
        			}
        		}
        	}
        	else if(potion == "sandy"){
        		entityplayer.addPotionEffect(new PotionEffect(CommonProxy.potionSandy, 400, 4));
        	}
        	else if(potion == "nordic"){
        		entityplayer.addPotionEffect(new PotionEffect(CommonProxy.potionNordic, 1600, 4));
        	}
        	else if(potion == "creep"){
        		entityplayer.addPotionEffect(new PotionEffect(CommonProxy.potionCreep, 500, 4));
        	}
        	else if(potion == "slime"){
        		entityplayer.addPotionEffect(new PotionEffect(CommonProxy.potionSlime, 450, 4));
        	}
        }

        if (entityplayer != null)
        {
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }

        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
        {
            if (stack.isEmpty())
            {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (entityplayer != null)
            {
                entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        return stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        PotionUtils.addPotionTooltip(stack, tooltip, 1.0F);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
//        if (this.isInCreativeTab(tab))
//        {
//            for (PotionType potiontype : PotionType.REGISTRY)
//            {
//                if (potiontype != PotionTypes.EMPTY)
//                {
//                    items.add(PotionUtils.addPotionToItemStack(new ItemStack(this), potiontype));
//                }
//            }
//        }
    }

    /**
     * Returns true if this item has an enchantment glint. By default, this returns
     * <code>stack.isItemEnchanted()</code>, but other items can override it (for instance, written books always return
     * true).
     *  
     * Note that if you override this method, you generally want to also call the super version (on {@link Item}) to get
     * the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
     */
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return super.hasEffect(stack) || !PotionUtils.getEffectsFromStack(stack).isEmpty();
    }

}
