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

public class BlockAnniversary extends BlockContainer {

	public IIcon side;
	public IIcon inside;
	public IIcon top;
	public IIcon bottom;
	
	
    public BlockAnniversary() {
            super(Material.cake);
            this.setTickRandomly(true);
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F - 0.0625F, 0.5F, 1.0F - 0.0625F);
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
		 return new TileEntityAnniversary();
	}
	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int euuh, float nope, float okey, float okok){
	    this.eating(world, x, y, z, player);
	    return true;
	}
	
	
	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
	   
	}
	
	
	private void eating(World world, int x, int y, int z, EntityPlayer player){
		if(player.canEat(false)){
			player.getFoodStats().addStats(2, 0.1F);
	        int cake = world.getBlockMetadata(x, y, z) + 1;
	 
	        world.setBlock(x, y, z, CakeIsALie.cake19w);
	        world.setBlockMetadataWithNotify(x, y, z, cake, 2);
		}
	}
	
	
   
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random rand){

        double x1 = (double)((float)p_149734_2_ + 0.8F);
        double x2 = (double)((float)p_149734_2_ + 0.2F);
        double z = (double)((float)p_149734_3_ + 0.88F);
        double y1 = (double)((float)p_149734_4_ + 0.8F);
        double y2 = (double)((float)p_149734_4_ + 0.2F);

        world.spawnParticle("smoke", x1, z, y1, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("flame", x1, z, y1, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("smoke", x2, z, y1, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("flame", x2, z, y1, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("smoke", x1, z, y2, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("flame", x1, z, y2, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("smoke", x2, z, y2, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("flame", x2, z, y2, 0.0D, 0.0D, 0.0D);
        
    }
	
	
	public IIcon getIcon(int sideType, int meta){
		 return sideType == 1 ? this.top : (sideType == 0 ? this.bottom : (meta > 0 && sideType == 4 ? this.inside : this.side));
	}
	
	
	public void registerBlockIcons(IIconRegister icon){
		side = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_side");
		inside = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_inside");
		top = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_top");
		bottom = icon.registerIcon(CakeIsALie.MODID+":anniversary_cake_bottom");
	}
	
	
	public int quantityDropped(Random rand){
	    return 0;
	}
	
	
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
	    return null;
	}
	
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z){
			return CakeIsALie.icake19;
	}
	
	
}