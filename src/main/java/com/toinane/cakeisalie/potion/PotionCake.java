package com.toinane.cakeisalie.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;


public class PotionCake extends Potion{
	
	
	public PotionCake(ResourceLocation location, boolean badEffect, int potionColor) {
        super(badEffect, potionColor);
    }

	/**
     * Returns true if the potion has an instant effect instead of a continuous one (eg Harming)
     */
    public boolean isInstant(){
        return true;
    }
    
    public Potion setIconIndex(int par1, int par2){
      super.setIconIndex(par1, par2);
      return this;
    }
    
    /**
     * checks if Potion effect is ready to be applied this tick.
     */
    public boolean isReady(int duration, int amplifier)
    {
        return duration >= 1;
    }

    @Override
    public int getStatusIconIndex(){
	    ResourceLocation r = new ResourceLocation("cakeisalie","textures/gui/effects.png");
	
	    ITextureObject texture = Minecraft.getMinecraft().renderEngine.getTexture(r);
	    Minecraft.getMinecraft().renderEngine.bindTexture(r);
	
	    return super.getStatusIconIndex();
    }
    
    
}