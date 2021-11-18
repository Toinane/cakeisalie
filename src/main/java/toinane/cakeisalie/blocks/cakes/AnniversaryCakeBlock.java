package toinane.cakeisalie.blocks.cakes;

import java.util.Random;

import toinane.cakeisalie.registry.ModEffectRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class AnniversaryCakeBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public AnniversaryCakeBlock(int totalBites, FabricBlockSettings settings) {
        super(totalBites, settings);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getHungerManager().add(2, 0.1F);
        player.addStatusEffect(new StatusEffectInstance(ModEffectRegistry.destruction, 400, 0));

        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(WATERLOGGED))
            return;

        double x = (double) pos.getX() + 0.19D;
        double x2 = (double) pos.getX() + .8D;
        double y = (double) pos.getY() + 0.88D;
        double z = (double) pos.getZ() + 0.19D;
        double z2 = (double) pos.getZ() + 0.8D;

        if (random.nextDouble() < 0.1D) {
            world.playSound(x, y, z, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        }

        if ((Integer) state.get(BITES) < 1) {
            world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.SMOKE, x2, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.FLAME, x2, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.SMOKE, x, y, z2, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.FLAME, x, y, z2, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.SMOKE, x2, y, z2, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.FLAME, x2, y, z2, 0.0D, 0.0D, 0.0D);
        } else if ((Integer) state.get(BITES) < 3) {
            world.addParticle(ParticleTypes.SMOKE, x2, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.FLAME, x2, y, z, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.SMOKE, x2, y, z2, 0.0D, 0.0D, 0.0D);
            world.addParticle(ParticleTypes.FLAME, x2, y, z2, 0.0D, 0.0D, 0.0D);
        }
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(5D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(9D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(13D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
    }
}