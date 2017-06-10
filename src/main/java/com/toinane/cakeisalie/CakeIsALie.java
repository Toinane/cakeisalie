//   Ce mod est créé par Toinane. Merci de ne pas copier tout mon travail :)   [Français]
//   Made by Toinane. Thank you not to copy all my work :)                     [English]
//
//   #############    ##########    ###    ###    ##        #####       ###    ##   ##########
//   #############    ##########    ###    ####   ##      #########     ####   ##   ###
//        ###         ##      ##           #####  ##     ###     ###    #####  ##   ######
//        ###         ##      ##    ###    ### ## ##    #############   ### ## ##   ###
//        ###         ##########    ###    ###  ####    ###       ###   ###  ####   ###
//        ###         ##########    ###    ###   ###    ###       ###   ###   ###   ##########
//

package com.toinane.cakeisalie;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.toinane.cakeisalie.hook.CakeHooks;

import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = CakeIsALie.MODID, name = CakeIsALie.MODNAME, version = CakeIsALie.VERSION)
public class CakeIsALie{
	
    public static final String MODID = "cakeisalie";
    public static final String MODNAME = "CakeIsALie";
    public static final String VERSION = "5.1.1";
    public static final int NBRCAKE = 26;
 
    @Mod.Instance(CakeIsALie.MODID)
    public static CakeIsALie instance;
    
    @SidedProxy(clientSide = "com.toinane.cakeisalie.ClientProxy", serverSide = "com.toinane.cakeisalie.ServerProxy")
    public static CommonProxy proxy;
    
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
		
		proxy.preInit();
    	
    	Potion[] potionTypes = null;
    	for (Field f : Potion.class.getDeclaredFields()){
    		f.setAccessible(true);
    		try{
    			if(f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")){
			    	Field modfield = Field.class.getDeclaredField("modifiers");
			    	modfield.setAccessible(true);
			    	modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

			    	potionTypes = (Potion[])f.get(null);
			    	final Potion[] newPotionTypes = new Potion[256];
			    	System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
			    	f.set(null, newPotionTypes);
    			}
    		}
    		catch (Exception r){
    			System.err.println("Severe error, please report this to the mod author: Toinane");
    			System.err.println(r);
    		}
    	}
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init();
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit();
    }
    
    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new CakeHooks());
    	/*
    	1. MinecraftForge.EVENT_BUS: Most events get posted to this bus.
    	2. MinecraftForge.TERRAIN_GEN_BUS: Most world generation events happen here, such as Populate, Decorate, etc., with the strange exception that Pre and Post events are on the regular EVENT_BUS
    	3. MinecraftForge.ORE_GEN_BUS: Ore generation, obviously
    	*/
    }
}