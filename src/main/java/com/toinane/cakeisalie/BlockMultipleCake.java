package com.toinane.cakeisalie;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;


public class BlockMultipleCake extends Block {

	/** Item for dropping. */
	private int gateau;
	public IIcon side;
	public IIcon bothside;
	public IIcon inside;
	public IIcon top;
	public IIcon bottom;

	
	/**
	 * Calls parent constructor and passes material.
	 * 
	 * @param gateau -> i
	 */
	public BlockMultipleCake(int i){
		super(Material.cake);
		this.setTickRandomly(true);
		gateau = i;
	}
	

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z){
	    int meta = blockAccess.getBlockMetadata(x, y, z);
	    float f = 0.0625F;
	    float f1 = (float)(1 + meta * 2) / 16F;
	    float f2 = 0.5F;
		if (gateau == 7 || gateau == 22){
			setBlockBounds(f1, 0.0F, f, 1.0F - f, 0.3F, 1.0F - f);
		}
		else if (gateau == 9 || gateau == 10){
			setBlockBounds(f1, 0.0F, f, 1.0F - f, 0.2F, 1.0F - f);
		}
		else if(gateau == 15){
			setBlockBounds(f1 + 0.3F, 0.0F, f + 0.3F, 0.7F - f, 0.1F, 0.6F + f);
		}
		else if(gateau == 18){
			setBlockBounds(f1, 0.0F, f + 0.2F, 1.0F - f, f2, 1.0F - f - 0.2F);
		}
		else if(gateau == 23){
			setBlockBounds(f1, 0.0F, f + 0.2F, 1.0F - f, 0.43F, 1.0F - f - 0.2F);
		}
		else if(gateau == 24){
			setBlockBounds(f1, 0.0F, f, 1.0F - f, 0.56F, 1.0F - f);
		}
		else{
			setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
		}
	}
	
	
	public void setBlockBoundsForItemRender(){
	    float f = 0.0625F;
	    float f1 = 0.5F;
		if (gateau == 7 || gateau == 22){
			setBlockBounds(f, 0.0F, f, 1.0F - f, 0.3F, 1.0F - f);
		}
		else if  (gateau == 9 || gateau == 10){
			setBlockBounds(f, 0.0F, f, 1.0F - f, 0.2F, 1.0F - f);
		}
		else if(gateau == 15){
			setBlockBounds(f + 0.3F, 0.0F, f + 0.3F, 0.7F - f, 0.1F, 0.6F + f);
		}
		else if(gateau == 18){
			setBlockBounds(f, 0.0F, f + 0.2F, 1.0F - f, f1, 1.0F - f - 0.2F);
		}
		else if(gateau == 23){
			setBlockBounds(f, 0.0F, f + 0.2F, 1.0F - f, 0.43F, 1.0F - f - 0.2F);
		}
		else if(gateau == 24){
			setBlockBounds(f, 0.0F, f, 1.0F - f, 0.56F, 1.0F - f);
		}
		else{
			setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
		}
	}
	
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
	    int i = par1World.getBlockMetadata(par2, par3, par4);
	    float f = 0.0625F;
	    float f1 = (float)(1 + i * 2) / 16F;
	    float f2 = 0.5F;
	    if (gateau == 7 || gateau == 22){
			return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, ((float)par3 + 0.3F) - f, (float)(par4 + 1) - f);
		}
	    else if (gateau == 9 || gateau == 10){
			return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, ((float)par3 + 0.2F), (float)(par4 + 1) - f);
		}
	    else if(gateau == 15){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + 0.36F, par3, (float)par4 + 0.36F, (float)(par2 + 1) - 0.36F, ((float)par3 + 0.1F) - 0.33F, (float)(par4 + 1) - f);
	    }
	    else if(gateau == 18){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + 0.26F, (float)(par2 + 1) - f, ((float)par3 + f2), (float)(par4 + 1) - 0.26F);
	    }
	    else if(gateau == 23){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + 0.26F, (float)(par2 + 1) - f, ((float)par3 + 0.43F), (float)(par4 + 1) - 0.26F);
	    }
	    else if(gateau == 24){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, ((float)par3 + 0.56F), (float)(par4 + 1) - f);
	    }
		else{
			return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, ((float)par3 + f2), (float)(par4 + 1) - f);
		}
	}
	
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4){
	    int i = par1World.getBlockMetadata(par2, par3, par4);
	    float f = 0.0625F;
	    float f1 = (float)(1 + i * 2) / 16F;
	    float f2 = 0.5F;
	    if (gateau == 7 || gateau == 22){
			return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, (float)par3 + 0.3F, (float)(par4 + 1) - f);
		}
	    else if (gateau == 9 || gateau == 10){
			return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, ((float)par3 + 0.2F), (float)(par4 + 1) - f);
		}
	    else if(gateau == 15){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + 0.36F, par3, (float)par4 + 0.36F, (float)(par2 + 1) - 0.36F, (float)par3 + 0.1F, (float)(par4 + 1) - 0.33F);
	    }
	    else if(gateau == 18){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + 0.26F, (float)(par2 + 1) - f, ((float)par3 + f2), (float)(par4 + 1) - 0.26F);
	    }
	    else if(gateau == 23){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + 0.26F, (float)(par2 + 1) - f, ((float)par3 + 0.43F), (float)(par4 + 1) - 0.26F);
	    }
	    else if(gateau == 24){
	    	return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, ((float)par3 + 0.56F), (float)(par4 + 1) - f);
	    }
		else{
			return AxisAlignedBB.getBoundingBox((float)par2 + f1, par3, (float)par4 + f, (float)(par2 + 1) - f, (float)par3 + f2, (float)(par4 + 1) - f);
		}
	}
	
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int euuh, float nope, float okey, float okok){
	    this.eating(world, x, y, z, player);
	    return true;
	}
	
	
	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		
	}
	
	
	private void eating(World world, int x, int y, int z, EntityPlayer player)
	{
		if(gateau == 4){
    		if(!world.isRemote){
    			world.createExplosion(player, x, y, z, 4F, true);
    			player.attackEntityFrom(DamageSource.setExplosionSource(null), Float.MAX_VALUE);
    			player.addStat(CakeIsALie.deathCake, 1);
    		}
    	}
		else if(player.canEat(false)){
	    	if(gateau == 1 || gateau == 2 || gateau == 3){
	    		if(gateau == 3){
	    			player.heal(5F);
	    			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
	    		}
	    		player.heal(1F);
	    		player.getFoodStats().addStats(1, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){ world.setBlockToAir(x, y, z); }
		        else{ world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 5){
	    		player.addPotionEffect(new PotionEffect(Potion.poison.id, 300, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){ world.setBlockToAir(x, y, z); }
		        else{ world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 6){
	    		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1800, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 3;
		
		        if (cake >= 6){ world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 7 || gateau == 9){
	    		player.getFoodStats().addStats(6, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 2;
		
		        if (cake >= 6){ world.setBlockToAir(x, y, z); }
		        else{ world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 8){
	    		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){ world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 10){
	    		player.getFoodStats().addStats(1, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 3;
		
		        if (cake >= 6){ world.setBlockToAir(x, y, z); }
		        else{ world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 12){
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 2){ world.setBlockToAir(x, y, z); }
		        else{ world.setBlockMetadataWithNotify(x, y, z, cake, 3); }
		        
		        
		        if (!world.isRemote){
		        	if (player != null && player instanceof EntityPlayerMP){
		                EntityPlayerMP entityplayermp = (EntityPlayerMP)player;
	
		                if (entityplayermp.playerNetServerHandler.func_147362_b().isChannelOpen() && entityplayermp.worldObj == world){
		                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, x + Math.random()*(300-20), y + Math.random()*(15-5), z + Math.random()*(300-20), 5.0F);
		                    if (!MinecraftForge.EVENT_BUS.post(event)){ 
			                    if (player.isRiding()){
			                        player.mountEntity((Entity)null);
			                    }
			                    player.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
			                    //world.setBlockToAir((int)player.posX, (int)player.posY, (int)player.posZ);
			                    //world.setBlockToAir((int)player.posX, (int)player.posY+1, (int)player.posZ);
			                    player.fallDistance = 0.0F;
		                    }
		                }
		            }
		        }
	    	}
	    	else if(gateau == 13){
	    		player.addPotionEffect(new PotionEffect(Potion.heal.id, 50, 4));
	    		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 14){
	    		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 400, 4));
	    		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 15){
	    		player.jump();
	    		player.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy.id, 200, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 1){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 16){
	    		player.addExperience(50);
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 17){
	    		player.dropItem(Items.melon_seeds, 1);
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 18){
	    		player.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic.id, 800, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 2;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 19){
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){ 
		        	player.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep.id, 600, 4));
		        	world.setBlockToAir(x, y, z); 
		        }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 21){
	    		player.getFoodStats().addStats(8, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else if(gateau == 24){
	    		player.getFoodStats().addStats(4, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    	else{
	    		player.getFoodStats().addStats(2, 0.1F);
		        int cake = world.getBlockMetadata(x, y, z) + 1;
		
		        if (cake >= 6){  world.setBlockToAir(x, y, z); }
		        else{  world.setBlockMetadataWithNotify(x, y, z, cake, 2); }
	    	}
	    }
	}
	
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass(){
		if(gateau == 25){ return 1; }
		else{ return 0; }
    }
	
	
	/**
	 * Gets the block's texture. Args: side, meta
	 */
	public IIcon getIcon(int sideType, int meta){
		if(gateau == 23){
			 return sideType == 1 ? this.top : (sideType == 2 ? this.bothside : (sideType == 3 ? this.bothside : (sideType == 0 ? this.bottom : (meta > 0 && sideType == 4 ? this.inside : this.side))));
		}
		else{
			 return sideType == 1 ? this.top : (sideType == 0 ? this.bottom : (meta > 0 && sideType == 4 ? this.inside : this.side));
		}
	}
	
	
	public void registerBlockIcons(IIconRegister icon){
		if(gateau == 1){
			side = icon.registerIcon(CakeIsALie.MODID+":chocolate_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":chocolate_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":chocolate_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":chocolate_cake_bottom");
		}else if(gateau == 2){
			side = icon.registerIcon(CakeIsALie.MODID+":apple_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":apple_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":apple_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":apple_cake_bottom");
		}else if(gateau == 3){
			side = icon.registerIcon(CakeIsALie.MODID+":gold_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":gold_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":gold_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":gold_cake_bottom");
		}else if(gateau == 6){
			side = icon.registerIcon(CakeIsALie.MODID+":lava_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":lava_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":lava_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":lava_cake_bottom");
		}else if(gateau == 7){
			side = icon.registerIcon(CakeIsALie.MODID+":basque_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":basque_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":basque_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":basque_cake_bottom");
		}else if(gateau == 8){
			side = icon.registerIcon(CakeIsALie.MODID+":redstone_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":redstone_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":redstone_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":redstone_cake_bottom");
		}else if(gateau == 9){
			side = icon.registerIcon(CakeIsALie.MODID+":brownie_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":brownie_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":brownie_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":brownie_bottom");
		}else if(gateau == 10){
			side = icon.registerIcon(CakeIsALie.MODID+":chocolate_mousse_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":chocolate_mousse_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":chocolate_mousse_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":chocolate_mousse_bottom");
		}else if(gateau == 11){
			side = icon.registerIcon(CakeIsALie.MODID+":cookies_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":cookies_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":cookies_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":cookies_cake_bottom");
		}else if(gateau == 12){
			side = icon.registerIcon(CakeIsALie.MODID+":ender_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":ender_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":ender_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":ender_cake_bottom");
		}else if(gateau == 13){
			side = icon.registerIcon(CakeIsALie.MODID+":pumpkin_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":pumpkin_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":pumpkin_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":pumpkin_cake_bottom");
		}else if(gateau == 14){
			side = icon.registerIcon(CakeIsALie.MODID+":spiced_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":spiced_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":spiced_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":spiced_cake_bottom");
		}else if(gateau == 15){
			side = icon.registerIcon(CakeIsALie.MODID+":sandy_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":sandy_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":sandy_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":sandy_cake_bottom");
		}else if(gateau == 16){
			side = icon.registerIcon(CakeIsALie.MODID+":stars_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":stars_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":stars_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":stars_cake_bottom");
		}else if(gateau == 17){
			side = icon.registerIcon(CakeIsALie.MODID+":water-melon_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":water-melon_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":water-melon_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":water-melon_cake_bottom");
		}else if(gateau == 18){
			side = icon.registerIcon(CakeIsALie.MODID+":nordic_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":nordic_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":nordic_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":nordic_cake_bottom");
		}else if(gateau == 19){
			side = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_bottom");
		}else if(gateau == 21){
			side = icon.registerIcon(CakeIsALie.MODID+":meat_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":meat_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":meat_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":meat_cake_bottom");
		}else if(gateau == 22){
			side = icon.registerIcon(CakeIsALie.MODID+":cheese_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":cheese_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":cheese_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":cheese_cake_bottom");
		}else if(gateau == 23){
			side = icon.registerIcon(CakeIsALie.MODID+":chocolate_roll_side");
			bothside = icon.registerIcon(CakeIsALie.MODID+":chocolate_roll_bothside");
			inside = icon.registerIcon(CakeIsALie.MODID+":chocolate_roll_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":chocolate_roll_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":chocolate_roll_bottom");
		}else if(gateau == 24){
			side = icon.registerIcon(CakeIsALie.MODID+":carrot_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":carrot_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":carrot_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":carrot_cake_bottom");
		}else if(gateau == 25){
			side = icon.registerIcon(CakeIsALie.MODID+":slime_cake_side");
			inside = icon.registerIcon(CakeIsALie.MODID+":slime_cake_inside");
			top = icon.registerIcon(CakeIsALie.MODID+":slime_cake_top");
			bottom = icon.registerIcon(CakeIsALie.MODID+":slime_cake_bottom");
		}else{
			side = icon.registerIcon("cake_side");
			inside = icon.registerIcon("cake_inner");
			top = icon.registerIcon("cake_top");
			bottom = icon.registerIcon("cake_bottom");
		}
	}
	
	
	public boolean renderAsNormalBlock(){
	    return false;
	}
	
	
	public boolean isOpaqueCube(){
	    return false;
	}
	
	
	public int quantityDropped(Random rand){
	    return 0;
	}
	
	
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
	    return null;
	}
	
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z){
		if(gateau == 1){
			return CakeIsALie.icake1;
		}else if(gateau == 2){
			return CakeIsALie.icake2;
		}else if(gateau == 3){
			return CakeIsALie.icake3;
		}else if(gateau == 4){
			return CakeIsALie.icake4;
		}else if(gateau == 5){
			return CakeIsALie.icake5;
		}else if(gateau == 6){
			return CakeIsALie.icake6;
		}else if(gateau == 7){
			return CakeIsALie.icake7;
		}else if(gateau == 8){
			return CakeIsALie.icake8;
		}else if(gateau == 9){
			return CakeIsALie.icake9;
		}else if(gateau == 10){
			return CakeIsALie.icake10;
		}else if(gateau == 11){
			return CakeIsALie.icake11;
		}else if(gateau == 12){
			return CakeIsALie.icake12;
		}else if(gateau == 13){
			return CakeIsALie.icake13;
		}else if(gateau == 14){
			return CakeIsALie.icake14;
		}else if(gateau == 15){
			return CakeIsALie.icake15;
		}else if(gateau == 16){
			return CakeIsALie.icake16;
		}else if(gateau == 17){
			return CakeIsALie.icake17;
		}else if(gateau == 18){
			return CakeIsALie.icake18;
		}else if(gateau == 19){
			return CakeIsALie.icake19;
		}else if(gateau == 21){
			return CakeIsALie.icake21;
		}else if(gateau == 22){
			return CakeIsALie.icake22;
		}else if(gateau == 23){
			return CakeIsALie.icake23;
		}else if(gateau == 24){
			return CakeIsALie.icake24;
		}else if(gateau == 25){
			return CakeIsALie.icake25;
		}else{
			return Items.cake;
		}

    }


}