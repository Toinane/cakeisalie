package com.toinane.cakeisalie;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCakePotion extends EntityThrowable
{
    /** The damage value of the thrown potion that this EntityPotion represents. */
    private ItemStack potionDamage;

    public EntityCakePotion(World worldIn)
    {
        super(worldIn);
    }

    public EntityCakePotion(World worldIn, EntityLivingBase throwerIn, int meta)
    {
        this(worldIn, throwerIn, new ItemStack(Items.potionitem, 1, meta));
    }

    public EntityCakePotion(World worldIn, EntityLivingBase throwerIn, ItemStack potionDamageIn)
    {
        super(worldIn, throwerIn);
        this.potionDamage = potionDamageIn;
    }

    @SideOnly(Side.CLIENT)
    public EntityCakePotion(World worldIn, double x, double y, double z, int p_i1791_8_)
    {
        this(worldIn, x, y, z, new ItemStack(Items.potionitem, 1, p_i1791_8_));
    }

    public EntityCakePotion(World worldIn, double x, double y, double z, ItemStack potionDamageIn)
    {
        super(worldIn, x, y, z);
        this.potionDamage = potionDamageIn;
    }

    
    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity()
    {
        return 0.05F;
    }

    protected float getVelocity()
    {
        return 0.5F;
    }

    protected float getInaccuracy()
    {
        return -20.0F;
    }


    
    protected void onImpact(MovingObjectPosition movingObject)
    {
        if (!this.worldObj.isRemote)
        {
            int list = Items.potionitem.getDamage(new ItemStack(Items.potionitem, 1, 0));

            if (list != 0)
            {
                AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D);
                List<EntityLivingBase> list1 = this.worldObj.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

                if (!list1.isEmpty())
                {
                    for (EntityLivingBase entitylivingbase : list1)
                    {
                        double d0 = this.getDistanceSqToEntity(entitylivingbase);

                        if (d0 < 16.0D)
                        {
                            double d1 = 1.0D - Math.sqrt(d0) / 4.0D;

                            if (entitylivingbase == movingObject.entityHit)
                            {
                                d1 = 1.0D;
                            }
                            int j = (int)(d1 * (double)450 + 0.5D);

                            if (j > 20)
                            {
    	                        if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_hunger))){
    	                        	if(entitylivingbase instanceof EntityPlayer){
    	                        		EntityPlayer player = (EntityPlayer) entitylivingbase;
    	                        		if(!player.capabilities.isCreativeMode){
    	                        			player.getFoodStats().addStats(-10, 0.1F);
    	                        		}
    	                        	}
    	
    	                    	}
    	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_sandy))){
    	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy.id, 400, 4));
    	                    	}
    	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_nordic))){
    	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic.id, 1600, 4));
    	                    	}
    	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_creep))){
    	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep.id, 500, 4));
    	                    	}
    	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_slime))){
    	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionSlime.id, 450, 4));
    	                    	}
                            }
                        }
                    }
                }
            }

            this.worldObj.playAuxSFX(2002, new BlockPos(this), list);
            this.setDead();
        }
    }
    
    
    


    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpactfe(MovingObjectPosition movingObject)
    {
        if (!this.worldObj.isRemote)
        {

        	
            AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D);
            List<EntityLivingBase> list1 = this.worldObj.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

            if (!list1.isEmpty())
            {
                for (EntityLivingBase entitylivingbase : list1)
                {
                    double d0 = this.getDistanceSqToEntity(entitylivingbase);

                    if (d0 < 16.0D)
                    {
                        double d1 = 1.0D - Math.sqrt(d0) / 4.0D;

                        if (entitylivingbase == movingObject.entityHit)
                        {
                            d1 = 1.0D;
                        }
                        int j = (int)(d1 * (double)450 + 0.5D);

                        if (j > 20)
                        {
	                        if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_hunger))){
	                        	if(entitylivingbase instanceof EntityPlayer){
	                        		EntityPlayer player = (EntityPlayer) entitylivingbase;
	                        		if(!player.capabilities.isCreativeMode){
	                        			player.getFoodStats().addStats(-10, 0.1F);
	                        		}
	                        	}
	
	                    	}
	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_sandy))){
	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionSandy.id, 400, 4));
	                    	}
	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_nordic))){
	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionNordic.id, 1600, 4));
	                    	}
	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_creep))){
	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionCreep.id, 500, 4));
	                    	}
	                    	else if(potionDamage.getIsItemStackEqual(new ItemStack(CakeIsALie.splash_slime))){
	                    		entitylivingbase.addPotionEffect(new PotionEffect(CakeIsALie.potionSlime.id, 450, 4));
	                    	}
                        }
                    }
                }
            }
        }

        this.worldObj.playAuxSFX(2002, new BlockPos(this), Items.potionitem.getDamage(new ItemStack(Items.potionitem, 1, 0)));
        this.setDead();
    }


}
