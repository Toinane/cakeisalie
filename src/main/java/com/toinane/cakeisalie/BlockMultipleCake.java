package com.toinane.cakeisalie;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
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
		super(Material.CAKE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(BITES, Integer.valueOf(0)));
		this.setTickRandomly(true);
		this.setSoundType(SoundType.CLOTH);
		cake = name;
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        float f = 0.0625F;
        float f1 = (float)(1 + ((Integer)state.getValue(BITES)).intValue() * 2) / 16.0F;
        float f2 = 0.5F;
        if(cake == "basque_cake" || cake == "cheese_cake" || cake == "spiced_cake"){
        	return new AxisAlignedBB(0.0625D, 0D, 0.0625D, 0.9375D, 0.3125D, 0.9375D);
		}
        else if(cake == "brownie" || cake == "chocolate_mousse"){
        	return new AxisAlignedBB[] {
        			new AxisAlignedBB(0.0625D, 0D, 0.0625D, 0.9375D, 0.25D, 0.9375D),
        			new AxisAlignedBB(0.3125D, 0D, 0.0625D, 0.9375D, 0.25D, 0.9375D),
        			new AxisAlignedBB(0.6875D, 0D, 0.0625D, 0.9375D, 0.25D, 0.9375D)}
        		[((Integer)state.getValue(BITES)).intValue()];
		}
        else if(cake == "sandy_cake"){
        	return new AxisAlignedBB(0.3125D, 0D, 0.3125D, 0.6875D, 0.0625D, 0.6875D);
	    }
        else if(cake == "nordic_cake"){
        	return new AxisAlignedBB[] {
        			new AxisAlignedBB(0.0625D, 0D, 0.3125D, 0.9375D, 0.25D, 0.6875D),
        			new AxisAlignedBB(0.3125D, 0D, 0.3125D, 0.9375D, 0.25D, 0.6875D),
        			new AxisAlignedBB(0.6875D, 0D, 0.3125D, 0.9375D, 0.25D, 0.6875D)}
        		[((Integer)state.getValue(BITES)).intValue()];
	    }
        else if(cake == "chocolate_roll"){
        	return new AxisAlignedBB[] {
        			new AxisAlignedBB(0.0625D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D),
        			new AxisAlignedBB(0.1875D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D),
        			new AxisAlignedBB(0.3125D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D),
        			new AxisAlignedBB(0.4375D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D),
        			new AxisAlignedBB(0.5625D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D),
        			new AxisAlignedBB(0.6875D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D),
        			new AxisAlignedBB(0.8125D, 0D, 0.25D, 0.9375D, 0.4375D, 0.75D)}
        		[((Integer)state.getValue(BITES)).intValue()];
	    }
        else if(cake == "carrot_cake"){
        	return new AxisAlignedBB[] {
        			new AxisAlignedBB(0.0625D, 0D, 0.0625D, 0.9375D, 0.5625D, 0.9375D),
        			new AxisAlignedBB(0.3125D, 0D, 0.0625D, 0.9375D, 0.5625D, 0.9375D),
        			new AxisAlignedBB(0.5625D, 0D, 0.0625D, 0.9375D, 0.5625D, 0.9375D),
        			new AxisAlignedBB(0.8125D, 0D, 0.0625D, 0.9375D, 0.5625D, 0.9375D)}
        		[((Integer)state.getValue(BITES)).intValue()];
	    }
        else if(cake == "paris_brest"){
        	return new AxisAlignedBB[] {
        			new AxisAlignedBB(0.0625D, 0D, 0D, 1D, 0.3125D, 1D),
        			new AxisAlignedBB(0.3125D, 0D, 0D, 1D, 0.3125D, 1D),
        			new AxisAlignedBB(0.5625D, 0D, 0D, 1D, 0.3125D, 1D)}
        	[((Integer)state.getValue(BITES)).intValue()];
		}
        else if(cake == "muffins"){
			return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.1875D, 0.9375D);
		}
        else if(cake == "hamburger"){
        	return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.375D, 0.75D);
		}
		else{
			return new AxisAlignedBB[] {
					new AxisAlignedBB(0.0625D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D), 
					new AxisAlignedBB(0.1875D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D),
					new AxisAlignedBB(0.3125D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D), 
					new AxisAlignedBB(0.4375D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D), 
					new AxisAlignedBB(0.5625D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D), 
					new AxisAlignedBB(0.6875D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D), 
					new AxisAlignedBB(0.8125D, 0D, 0.0625D, 0.9375D, 0.5D, 0.9375D)}
			[((Integer)state.getValue(BITES)).intValue()];
		}
    }
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return state.getCollisionBoundingBox(worldIn, pos);
    }
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	 /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        this.eatCake(worldIn, pos, state, playerIn);
      //System.out.println("info Cake "+cake+" - Bite : "+((Integer)state.getValue(BITES)).intValue());
        return true;
    }

	private void eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player){
		if(player.canEat(false)){
			if(cake == "trapped_cake"){
	    		if(!worldIn.isRemote){
	    			worldIn.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 4F, true);
	    			player.attackEntityFrom(DamageSource.causeExplosionDamage(player), Float.MAX_VALUE);
	    			player.addStat(CakeIsALie.deathCake, 1);
	    		}
	    	}
			else if(cake == "chocolate_cake" || cake == "apple_cake" || cake == "gold_cake"){
	    		if(cake == "gold_cake"){
	    			player.heal(5F);
	    			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 4));
	    		}
	    		player.heal(2F);
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 2;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "poisoned_cake"){
	    		player.addPotionEffect(new PotionEffect(MobEffects.POISON, 300, 0));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "lava_cake"){
	    		player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1800, 4));
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
	    		player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 350, 4));
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
	
		                if (entityplayermp.worldObj == worldIn){
		                	double posx[] = {(double) (Math.random()*(300-30)), (double) 0 - (Math.random()*(300-30))};
		                	double posz[] = {(double) (Math.random()*(300-30)), (double) 0 - (Math.random()*(300-30))};
		                	
		                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, pos.getX() + posx[(int)(Math.random()*(1-0+1))+0], pos.getY() + Math.random()*(15-5), pos.getZ() + posz[(int)(Math.random()*(1-0+1))+0], 5.0F);
		                    if (!MinecraftForge.EVENT_BUS.post(event)){ 
			                    if (player.isRiding()){
			                    	player.dismountRidingEntity();
			                    }
			                    player.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
			                    worldIn.setBlockToAir(player.getPosition());
			                    worldIn.setBlockToAir(new BlockPos(player.posX, player.posY+1, player.posZ));
			                    player.fallDistance = 0.0F;
		                    }
		                }
		            }
		        }
		    }
		    else if(cake == "pumpkin_cake"){
	    		player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 50, 4));
	    		player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "spiced_cake"){
	    		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 400, 4));
	    		player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 4));
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "sandy_cake"){
	    		player.jump();
	    		player.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy, 200, 4));
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
		    		player.dropItem(Items.MELON_SEEDS, 1);
		    	}
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "nordic_cake"){
	    		player.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic, 800, 4));
	    		player.getFoodStats().addStats(1, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 2;
		
		        if (i >= 6){  worldIn.setBlockToAir(pos); }
		        else{  worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 2); }
		    }
		    else if(cake == "anniversary_cake"){
	    		player.getFoodStats().addStats(2, 0.1F);
	    		int i = ((Integer)state.getValue(BITES)).intValue() + 1;
		
		        if (i >= 6){ 
		        	player.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep, 600, 4));
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
		    	if (i >= 2){ worldIn.setBlockToAir(pos); }
		        else{ worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i+1)), 2); }
		    }
		    else if(cake == "slime_cake"){
		    	player.getFoodStats().addStats(2, 0.1F);
		    	int i = ((Integer)state.getValue(BITES)).intValue() + 3;
		    	player.addPotionEffect(new PotionEffect(CakeIsALie.potionSlime, 600, 4));
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
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
    }

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
        }
    }

    private boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
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

    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
		if(cake == "chocolate_cake"){ return new ItemStack(CakeIsALie.item_chocolate_cake);
		}else if(cake == "apple_cake"){ return new ItemStack(CakeIsALie.item_apple_cake);
		}else if(cake == "gold_cake"){ return new ItemStack(CakeIsALie.item_gold_cake);
		}else if(cake == "trapped_cake"){ return new ItemStack(CakeIsALie.item_trapped_cake);
		}else if(cake == "poisoned_cake"){ return new ItemStack(CakeIsALie.item_poisoned_cake);
		}else if(cake == "lava_cake"){ return new ItemStack(CakeIsALie.item_lava_cake);
		}else if(cake == "basque_cake"){ return new ItemStack(CakeIsALie.item_basque_cake);
		}else if(cake == "redstone_cake"){ return new ItemStack(CakeIsALie.item_redstone_cake);
		}else if(cake == "brownie"){ return new ItemStack(CakeIsALie.item_brownie);
		}else if(cake == "chocolate_mousse"){ return new ItemStack(CakeIsALie.item_chocolate_mousse);
		}else if(cake == "cookies_cake"){ return new ItemStack(CakeIsALie.item_cookies_cake);
		}else if(cake == "ender_cake"){ return new ItemStack(CakeIsALie.item_ender_cake);
		}else if(cake == "pumpkin_cake"){ return new ItemStack(CakeIsALie.item_pumpkin_cake);
		}else if(cake == "spiced_cake"){ return new ItemStack(CakeIsALie.item_spiced_cake);
		}else if(cake == "sandy_cake"){ return new ItemStack(CakeIsALie.item_sandy_cake);
		}else if(cake == "stars_cake"){ return new ItemStack(CakeIsALie.item_stars_cake);
		}else if(cake == "watermelon_cake"){ return new ItemStack(CakeIsALie.item_watermelon_cake);
		}else if(cake == "nordic_cake"){ return new ItemStack(CakeIsALie.item_nordic_cake);
		}else if(cake == "anniversary_cake"){ return new ItemStack(CakeIsALie.item_anniversary_cake);
		}else if(cake == "paris_brest"){ return new ItemStack(CakeIsALie.item_paris_brest);
		}else if(cake == "hamburger"){ return new ItemStack(CakeIsALie.item_hamburger);
		}else if(cake == "cheese_cake"){ return new ItemStack(CakeIsALie.item_cheese_cake);
		}else if(cake == "chocolate_roll"){ return new ItemStack(CakeIsALie.item_chocolate_roll);
		}else if(cake == "carrot_cake"){ return new ItemStack(CakeIsALie.item_carrot_cake);
		}else if(cake == "slime_cake"){ return new ItemStack(CakeIsALie.item_slime_cake);
		}else if(cake == "muffins"){ return new ItemStack(CakeIsALie.item_muffins);
		}else{
			return new ItemStack(Items.CAKE);
		}
		//return Item.getItemFromBlock(this.blockState.getBlock());
    }
	
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
    	if(cake == "slime_cake"){ return BlockRenderLayer.TRANSLUCENT; }
    	else{ return BlockRenderLayer.CUTOUT; }
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(BITES)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BITES});
    }

    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return (7 - ((Integer)blockState.getValue(BITES)).intValue()) * 2;
    }

    public boolean hasComparatorInputOverride(IBlockState state)
    {
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
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	if(cake == "slime_cake"){
	        if (Math.abs(entityIn.motionY) < 0.1D && !entityIn.isSneaking())
	        {
	            double d0 = 0.4D + Math.abs(entityIn.motionY) * 0.2D;
	            entityIn.motionX *= d0;
	            entityIn.motionZ *= d0;
	        }
	
	        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
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