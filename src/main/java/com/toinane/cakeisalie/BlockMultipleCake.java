package com.toinane.cakeisalie;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityFirework;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;


public class BlockMultipleCake extends Block {

	/** Item for dropping. */
	private String cake;
	public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 6);

	
	/**
	 * Calls parent constructor and passes material.
	 * 
	 * @param cake -> i
	 */
	public BlockMultipleCake(String name){
		super(Material.cake);
		this.setDefaultState(this.blockState.getBaseState().withProperty(BITES, Integer.valueOf(0)));
		this.setTickRandomly(true);
		cake = name;
	}
	
	
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos){

		float f = 0.0625F;
        float f1 = (float)(1 + ((Integer)worldIn.getBlockState(pos).getValue(BITES)).intValue() * 2) / 16.0F;
        float f2 = 0.5F;
		
        if(cake == "basque_cake" || cake == "cheese_cake" || cake == "spiced_cake"){
			setBlockBounds(f1, 0.0F, f, 1.0F - f, (5 * f), 1.0F - f);
		}
        else if(cake == "brownie" || cake == "chocolate_mousse"){
			setBlockBounds(f1, 0.0F, f, 1.0F - f, (4 * f), 1.0F - f);
		}
        else if(cake == "sandy_cake"){
			setBlockBounds((5 * f), 0.0F, (5 * f), 1F - (5 * f), f, 1F - (5 * f));
		}
        else if(cake == "nordic_cake"){
			setBlockBounds(f1, 0F, (f * 5), 1F - f, (f * 3), 1F - (5 * f));
		}
        else if(cake == "chocolate_roll"){
			setBlockBounds(f1, 0.0F, (4 * f), 1.0F - f, (7 * f), 1.0F - (4 * f));
		}
        else if(cake == "carrot_cake"){
			setBlockBounds(f1, 0.0F, f, 1.0F - f, 0.56F, 1.0F - f);
		}
        else if(cake == "paris_brest" && ((Integer)worldIn.getBlockState(pos).getValue(BITES)).intValue() == 0){
        	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, (5 * f), 1.0F);
		}
        else if(cake == "paris_brest" && ((Integer)worldIn.getBlockState(pos).getValue(BITES)).intValue() == 3){
        	setBlockBounds(0.3F, 0.0F, 0.0F, 1.0F, (5 * f), 1.0F);
		}
        else if(cake == "paris_brest" && ((Integer)worldIn.getBlockState(pos).getValue(BITES)).intValue() == 6){
        	setBlockBounds(0.55F, 0.0F, 0.0F, 1.0F, (5 * f), 1.0F);
		}
        else if(cake == "muffins"){
        	setBlockBounds(f, 0.0F, f, 1.0F - f, (3 * f), 1.0F - f);
		}
        else if(cake == "hamburger"){
			setBlockBounds((4 * f), 0.0F, (4 * f), 1F - (4 * f), (6 * f), 1F - (4 * f));
		}
		else{
			setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
		}
	}
	
	
	public void setBlockBoundsForItemRender(){
	    float f = 0.0625F;
	    float f1 = 0.5F;
		if(cake == "basque_cake" || cake == "cheese_cake" || cake == "spiced_cake"){
			setBlockBounds(f, 0.0F, f, 1.0F - f, (5 * f), 1.0F - f);
		}
		else if(cake == "brownie" || cake == "chocolate_mousse"){
			setBlockBounds(f, 0.0F, f, 1.0F - f, (4 * f), 1.0F - f);
		}
		else if(cake == "sandy_cake"){
			setBlockBounds((5 * f), 0.0F, (5 * f), 1F - (5 * f), f, 1F - (5 * f));
		}
		else if(cake == "nordic_cake"){
			setBlockBounds(f, 0F, (f * 5), 1F - f, (f * 3), 1F - (5 * f));
		}
		else if(cake == "chocolate_roll"){
			setBlockBounds(f, 0.0F, (4 * f), 1.0F - f, (7 * f), 1.0F - (4 * f));
		}
		else if(cake == "carrot_cake"){
			setBlockBounds(f, 0.0F, f, 1.0F - f, 0.56F, 1.0F - f);
		}
		else if(cake == "paris_brest"){
			setBlockBounds(f, 0.0F, f, 1.0F - f, (5 * f), 1.0F - f);
		}
		else if(cake == "muffins"){
        	setBlockBounds(f, 0.0F, f, 1.0F - f, (3 * f), 1.0F - f);
		}
		else if(cake == "hamburger"){
			setBlockBounds((4 * f), 0.0F, (4 * f), 1F - (4 * f), (6 * f), 1F - (4 * f));
		}
		else{
			setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
		}
	}
	
	
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state){
        float f = 0.0625F;
        float f1 = (float)(1 + ((Integer)state.getValue(BITES)).intValue() * 2) / 16.0F;
        float f2 = 0.5F;
        if(cake == "basque_cake" || cake == "cheese_cake" || cake == "spiced_cake"){
			return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + (5 * f)), (double)((float)(pos.getZ() + 1) - f));
		}
        else if(cake == "brownie" || cake == "chocolate_mousse"){
			return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + (4 * f)), (double)((float)(pos.getZ() + 1) - f));
		}
        else if(cake == "sandy_cake"){
	    	return new AxisAlignedBB((double)((float)pos.getX() + (5 * f)), (double)pos.getY(), (double)((float)pos.getZ() + (5 * f)), (double)((float)(pos.getX() + 1) - (5 * f)), (double)((float)pos.getY() + f), (double)((float)(pos.getZ() + 1) - (5 * f)));
	    }
        else if(cake == "nordic_cake"){
        	return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + (5 * f)), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + (3 * f)), (double)((float)(pos.getZ() + 1) - (5 * f)));
	    }
        else if(cake == "chocolate_roll"){
	    	return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + (4 * f)), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + (7 * f)), (double)((float)(pos.getZ() + 1) - (4 * f)));
	    }
        else if(cake == "carrot_cake"){
	    	return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + 0.56F), (double)((float)(pos.getZ() + 1) - f));
	    }
        else if(cake == "paris_brest" && ((Integer)state.getValue(BITES)).intValue() == 0){
			return new AxisAlignedBB((double)(float)pos.getX(), (double)pos.getY(), (double)(float)pos.getZ(), (double)(float)pos.getX() + 1F, (double)(float)pos.getY() + (5 * f), (double)(float)pos.getZ() + 1F);
		}
        else if(cake == "paris_brest" && ((Integer)state.getValue(BITES)).intValue() == 3){
        	return new AxisAlignedBB((double)(float)pos.getX() + 0.3F, (double)pos.getY(), (double)(float)pos.getZ(), (double)(float)pos.getX() + 1F, (double)(float)pos.getY() + (5 * f), (double)(float)pos.getZ() + 1F);
		}
        else if(cake == "paris_brest" && ((Integer)state.getValue(BITES)).intValue() == 6){
        	return new AxisAlignedBB((double)(float)pos.getX() + 0.55F, (double)pos.getY(), (double)(float)pos.getZ(), (double)(float)pos.getX() + 1F, (double)(float)pos.getY() + (5 * f), (double)(float)pos.getZ() + 1F);
		}
        else if(cake == "muffins"){
			return new AxisAlignedBB((double)((float)pos.getX() + f), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + (3 * f)), (double)((float)(pos.getZ() + 1) - f));
		}
        else if(cake == "hamburger"){
        	return new AxisAlignedBB((double)((float)pos.getX() + (4 * f)), (double)pos.getY(), (double)((float)pos.getZ() + (4 * f)), (double)((float)(pos.getX() + 1) - (4 * f)), (double)((float)pos.getY() + (6 * f)), (double)((float)(pos.getZ() + 1) - (4 * f)));
		}
		else{
			return new AxisAlignedBB((double)((float)pos.getX() + f1), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)pos.getY() + f2), (double)((float)(pos.getZ() + 1) - f));
		}
        
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos){
        return this.getCollisionBoundingBox(worldIn, pos, worldIn.getBlockState(pos));
    }
	
	
	/**
	 * Called upon block activation (right click on the block.)
	 */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
        this.eatCake(worldIn, pos, state, playerIn);
    	//System.out.println("info Cake "+cake+" - Bite : "+((Integer)state.getValue(BITES)).intValue());
        return true;
    }
	
	
	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		
	}
	
	
	private void eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player){
		if(player.canEat(false)){
			if(cake == "trapped_cake"){
	    		if(!worldIn.isRemote){
	    			worldIn.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 4F, true);
	    			player.attackEntityFrom(DamageSource.setExplosionSource(null), Float.MAX_VALUE);
	    			player.addStat(CakeIsALie.deathCake, 1);
	    		}
	    	}
			else if(cake == "chocolate_cake" || cake == "apple_cake" || cake == "gold_cake"){
	    		if(cake == "gold_cake"){
	    			player.heal(5F);
	    			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
	    		}
	    		player.heal(2F);
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 2;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "poisoned_cake"){
	    		player.addPotionEffect(new PotionEffect(Potion.poison.id, 300, 0));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "lava_cake"){
	    		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1800, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 3;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "basque_cake" || cake == "brownie"){
	    		player.getFoodStats().addStats(3, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 2;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "redstone_cake"){
	    		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 350, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "chocolate_mousse"){
	    		player.getFoodStats().addStats(1, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 3;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "ender_cake"){
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue();
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 3)), 3); }
		        
		        
		        if (!worldIn.isRemote){
		        	if (player != null && player instanceof EntityPlayerMP){
		                EntityPlayerMP entityplayermp = (EntityPlayerMP)player;
	
		                if (entityplayermp.playerNetServerHandler.getNetworkManager().isChannelOpen() && entityplayermp.worldObj == worldIn){
		                	
		                	double posx[] = {(double) (Math.random()*(300-30)), (double) 0 - (Math.random()*(300-30))};
		                	double posz[] = {(double) (Math.random()*(300-30)), (double) 0 - (Math.random()*(300-30))};
		                	
		                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, pos.getX() + posx[(int)(Math.random()*(1-0+1))+0], pos.getY() + Math.random()*(15-5), pos.getZ() + posz[(int)(Math.random()*(1-0+1))+0], 5.0F);
		                    if (!MinecraftForge.EVENT_BUS.post(event)){ 
			                    if (player.isRiding()){
			                        player.mountEntity((Entity)null);
			                    }
			                    player.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
			                    worldIn.setBlockToAir(player.getPosition());
			                    worldIn.setBlockToAir(new BlockPos(player.posX, player.posY+1, player.posZ));
			                    player.fallDistance = 0.0F;
		                    }
		                }
		            }
		        }
		    }
		    else if(cake == "pumpkin_cake"){
	    		player.addPotionEffect(new PotionEffect(Potion.heal.id, 50, 4));
	    		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "spiced_cake"){
	    		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 400, 4));
	    		player.addPotionEffect(new PotionEffect(Potion.hunger.id, 600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "sandy_cake"){
	    		player.jump();
	    		player.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy.id, 200, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 1){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "stars_cake"){
	    		if(!worldIn.isRemote){
	    			player.addExperience(150);
	    		}
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "watermelon_cake"){
		    	if(!worldIn.isRemote){
		    		player.dropItem(Items.melon_seeds, 1);
		    	}
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "nordic_cake"){
	    		player.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic.id, 800, 4));
	    		player.getFoodStats().addStats(1, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 2;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "anniversary_cake"){
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){ 
		        	player.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep.id, 600, 4));
		        	worldIn.setBlockToAir(pos); 
		        }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "hamburger"){
	    		player.getFoodStats().addStats(6, 0.1F);
		
		        worldIn.setBlockToAir(pos);
		    }
		    else if(cake == "carrot_cake"){
	    		player.getFoodStats().addStats(4, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "muffins"){
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 2;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "paris_brest"){
		    	player.getFoodStats().addStats(2, 0.1F);
		    	int i = ((Integer)state.getValue(BITES)).intValue();
		    	if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 3)), 2); }
		    }
		    else if(cake == "slime_cake"){
		    	player.getFoodStats().addStats(2, 0.1F);
		    	int i = ((Integer)state.getValue(BITES)).intValue() + 3;
		    	player.addPotionEffect(new PotionEffect(CakeIsALie.potionSlime.id, 600, 4));
		    	if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ 
		        	worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i)), 2); 
		        }
		    }
		    else{
	    		player.getFoodStats().addStats(2, 0.1F);
	            int i = ((Integer)state.getValue(BITES)).intValue();

	            if (i < 6){
	                worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2);
	            }
	            else{worldIn.setBlockToAir(pos);}
		    }
	    }
		
	}
	

	public boolean isFullCube()
    {
        return false;
    }
	
	
	public boolean renderAsNormalBlock(){
	    return false;
	}
	
	
	public boolean isOpaqueCube(){
	    return false;
	}
	
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
        }
    }

    private boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getBlock().getMaterial().isSolid();
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(BITES, Integer.valueOf(meta));
    }
	

	
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos){
		if(cake == "chocolate_cake"){ return CakeIsALie.item_chocolate_cake;
		}else if(cake == "apple_cake"){ return CakeIsALie.item_apple_cake;
		}else if(cake == "gold_cake"){ return CakeIsALie.item_gold_cake;
		}else if(cake == "trapped_cake"){ return CakeIsALie.item_trapped_cake;
		}else if(cake == "poisoned_cake"){ return CakeIsALie.item_poisoned_cake;
		}else if(cake == "lava_cake"){ return CakeIsALie.item_lava_cake;
		}else if(cake == "basque_cake"){ return CakeIsALie.item_basque_cake;
		}else if(cake == "redstone_cake"){ return CakeIsALie.item_redstone_cake;
		}else if(cake == "brownie"){ return CakeIsALie.item_brownie;
		}else if(cake == "chocolate_mousse"){ return CakeIsALie.item_chocolate_mousse;
		}else if(cake == "cookies_cake"){ return CakeIsALie.item_cookies_cake;
		}else if(cake == "ender_cake"){ return CakeIsALie.item_ender_cake;
		}else if(cake == "pumpkin_cake"){ return CakeIsALie.item_pumpkin_cake;
		}else if(cake == "spiced_cake"){ return CakeIsALie.item_spiced_cake;
		}else if(cake == "sandy_cake"){ return CakeIsALie.item_sandy_cake;
		}else if(cake == "stars_cake"){ return CakeIsALie.item_stars_cake;
		}else if(cake == "watermelon_cake"){ return CakeIsALie.item_watermelon_cake;
		}else if(cake == "nordic_cake"){ return CakeIsALie.item_nordic_cake;
		}else if(cake == "anniversary_cake"){ return CakeIsALie.item_anniversary_cake;
		}else if(cake == "paris_brest"){ return CakeIsALie.item_paris_brest;
		}else if(cake == "hamburger"){ return CakeIsALie.item_hamburger;
		}else if(cake == "cheese_cake"){ return CakeIsALie.item_cheese_cake;
		}else if(cake == "chocolate_roll"){ return CakeIsALie.item_chocolate_roll;
		}else if(cake == "carrot_cake"){ return CakeIsALie.item_carrot_cake;
		}else if(cake == "slime_cake"){ return CakeIsALie.item_slime_cake;
		}else if(cake == "muffins"){ return CakeIsALie.item_muffins;
		}else{
			return Items.cake;
		}
		//return Item.getItemFromBlock(this.blockState.getBlock());
    }
	
	 /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state){
        return ((Integer)state.getValue(BITES)).intValue();
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer(){
    	if(cake == "slime_cake"){
    		return EnumWorldBlockLayer.TRANSLUCENT;
    	}
    	else{
    		return EnumWorldBlockLayer.CUTOUT;
    	}
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {BITES});
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos){
        return (7 - ((Integer)worldIn.getBlockState(pos).getValue(BITES)).intValue()) * 2;
    }

    public boolean hasComparatorInputOverride(){
        return true;
    }
    
    
    // CODE FOR ANNIVERSARY CAKE !!!!
    /////////////////////////////////
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
    	if(cake == "anniversary_cake"){
	        double x = (double)pos.getX() + 0.19D;
	        double x2 = (double)pos.getX() + .8D;
	        double y = (double)pos.getY() + 0.88D;
	        double z = (double)pos.getZ() + 0.19D;
	        double z2 = (double)pos.getZ() + 0.8D;
	
	        if(((Integer)state.getValue(BITES)).intValue() < 2){
	        	world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x2, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.FLAME, x2, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z2, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.FLAME, x, y, z2, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x2, y, z2, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.FLAME, x2, y, z2, 0.0D, 0.0D, 0.0D, new int[0]);
	        }
	        else if(((Integer)state.getValue(BITES)).intValue() < 5){
	        	world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x2, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.FLAME, x2, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x2, y, z2, 0.0D, 0.0D, 0.0D, new int[0]);
		        world.spawnParticle(EnumParticleTypes.FLAME, x2, y, z2, 0.0D, 0.0D, 0.0D, new int[0]);
	        }
	        
    	}
    	
    }
    // END ANNIVERSARY CAKE !!!!
    /////////////////////////////
    
    // CODE FOR REDSTONE CAKE !!!!
    /////////////////////////////
    public boolean canProvidePower(){
    	if(cake == "redstone_cake"){ return true; }else{ return false; }
    }

    public int getWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side){
    	if(cake == "redstone_cake"){ return 15; }else{ return 0; }
    }
    // END REDSTONE CAKE !!!!
    /////////////////////////////
    
    // CODE FOR SLIMY CAKE !!!!
    /////////////////////////////
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
    {
    	if(cake == "slime_cake"){
	        if (Math.abs(entityIn.motionY) < 0.1D && !entityIn.isSneaking())
	        {
	            double d0 = 0.4D + Math.abs(entityIn.motionY) * 0.2D;
	            entityIn.motionX *= d0;
	            entityIn.motionZ *= d0;
	        }
	
	        super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
    	}
    }
    
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
    	if(cake == "slime_cake"){
	        if (entityIn.isSneaking())
	        {
	            super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
	        }
	        else
	        {
	            entityIn.fall(fallDistance, 0.0F);
	        }
    	}
    }
    
    public void onLanded(World worldIn, Entity entityIn)
    {
    	if(cake == "slime_cake"){
	        if (entityIn.isSneaking())
	        {
	            super.onLanded(worldIn, entityIn);
	        }
	        else if (entityIn.motionY < 0.0D)
	        {
	            entityIn.motionY = -entityIn.motionY; //* number = wouuhouuuuuh!!!
	        }
    	}
    }
    // END SLIMY CAKE !!!!
    /////////////////////////////


}