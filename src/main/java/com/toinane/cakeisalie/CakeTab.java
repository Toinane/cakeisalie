package com.toinane.cakeisalie;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class CakeTab extends CreativeTabs {

	public CakeTab(String label) {
	  super(label);
	}

	@Override
	public Item getTabIconItem() {
	  return CommonProxy.item_anniversary_cake;
	}
}