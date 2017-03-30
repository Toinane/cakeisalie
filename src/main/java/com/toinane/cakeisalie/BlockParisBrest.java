package com.toinane.cakeisalie;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockParisBrest extends BlockContainer{

	private int partParis;
	public IIcon side;
	public IIcon inside;
	public IIcon top;
	public IIcon bottom;
	

	
    public BlockParisBrest(int id){
            super(Material.cake);
            partParis = id;
            if(partParis == 1){
            	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
            }
            else if(partParis == 2){
            	this.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 0.3F, 1.0F);
            }
            else if(partParis == 3){
            	this.setBlockBounds(0.0F, 0.0F, 0.6F, 1.0F, 0.3F, 1.0F);
            }
    }
    
   
    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
   
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
   
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		if(partParis == 1){
			 return new TileEntityParisBrest();
        }
        else if(partParis == 2){
        	 return new TileEntityParisBrest2();
        }
        else{
        	 return new TileEntityParisBrest3();
        }
		
	}
	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int euuh, float nope, float okey, float okok){
	    this.eating(world, x, y, z, player);
	    return true;
	}
	
	
	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		 System.out.println(partParis);
	}
	
	
	private void eating(World world, int x, int y, int z, EntityPlayer player){
		if(player.canEat(false)){
			player.getFoodStats().addStats(2, 0.1F);
	        int cake = world.getBlockMetadata(x, y, z) + 1;
	 
	        if(partParis >= 3){
	        	world.setBlockToAir(x, y, z);
	        }
	        else if(partParis == 2){
	        	world.setBlock(x, y, z, CakeIsALie.cake20s);
	        }
	        else{
	        	world.setBlock(x, y, z, CakeIsALie.cake20w);
	        }
		}
	}
	
	
	
	
	public IIcon getIcon(int sideType, int meta){
		 return sideType == 1 ? this.top : (sideType == 0 ? this.bottom : (meta > 0 && sideType == 4 ? this.inside : this.side));
	}
	
	
	public void registerBlockIcons(IIconRegister icon){
		side = icon.registerIcon(CakeIsALie.MODID+":parisbrest_side");
		inside = icon.registerIcon(CakeIsALie.MODID+":parisbrest_side");
		top = icon.registerIcon(CakeIsALie.MODID+":parisbrest_side");
		bottom = icon.registerIcon(CakeIsALie.MODID+":parisbrest_side");
	}
	
	
	public int quantityDropped(Random rand){
	    return 0;
	}
	
	
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
	    return null;
	}
	
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z){
			return CakeIsALie.icake20;
	}
	
	
}