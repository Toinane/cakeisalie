package com.toinane.cakeisalie;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class CakeTab extends CreativeTabs {

	public CakeTab(String label) {
	  super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
	  return new ItemStack(CommonProxy.anniversary_cake);
	}
}