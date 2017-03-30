package com.toinane.cakeisalie;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class CakeTab extends CreativeTabs {


	//===========================================================================
	/**
	 * Calls parent constructor and passes label.
	 * 
	 * @param label  Name used in lang file.
	 */
	public CakeTab(String label) {
	  
	  super(label);
	}
	//===========================================================================
	/**
	 * Returns item used for icon.
	 * 
	 * @return Icon item.
	 */
	@Override
	public Item getTabIconItem() {
	  
	  return CakeIsALie.icake19;
	}
	//===========================================================================
}//END class
	//===========================================================================