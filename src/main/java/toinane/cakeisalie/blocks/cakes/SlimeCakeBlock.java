package toinane.cakeisalie.blocks.cakes;

import toinane.cakeisalie.registry.ModEffectRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SlimeCakeBlock extends CakeBlock {

    protected static final VoxelShape[] BITES_TO_SHAPE;

    public SlimeCakeBlock(int totalBites, FabricBlockSettings settings) {
        super(totalBites, settings);
    }

    @Override
    protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getHungerManager().add(2, 0.1F);
        player.addStatusEffect(new StatusEffectInstance(ModEffectRegistry.slime_bounce, 400, 0));

        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer) state.get(BITES)];
    }

    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) ? true : super.isSideInvisible(state, stateFrom, direction);
    }

    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, pos, entity, distance);
        } else {
            entity.handleFallDamage(distance, 0.0F);
        }

    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.method_21847(entity);
        }
    }

    private void method_21847(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0D) {
            double d = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }

    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        double d = Math.abs(entity.getVelocity().y);
        if (d < 0.1D && !entity.bypassesSteppingEffects()) {
            double e = 0.4D + d * 0.2D;
            entity.setVelocity(entity.getVelocity().multiply(e, 1.0D, e));
        }

        super.onSteppedOn(world, pos, entity);
    }

    static {
        BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(7D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(9D, 0D, 1D, 15D, 8D, 15D),
                Block.createCuboidShape(13D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
                Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
    }
}