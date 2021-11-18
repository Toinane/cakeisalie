package toinane.cakeisalie.effects;

import java.util.Random;
import java.util.stream.Stream;
import java.util.Iterator;

import toinane.cakeisalie.registry.ModBlockRegistry;
import toinane.cakeisalie.registry.ModParticleRegistry;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LavaWalkerStatusEffect extends ModStatusEffect {

    Random random = new Random();

    public LavaWalkerStatusEffect(StatusEffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        BlockPos blockPos = entity.getBlockPos();
        World world = entity.world;

        if (world.isClient)
            return;

        if (this.random.nextDouble() <= 0.2D)
            this.showFrostParticles(world, entity.getPos());

        BlockState blockState = ModBlockRegistry.frosted_lava.getDefaultState();
        float f = (float) Math.min(16, 2 + amplifier);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Iterator<BlockPos> iBlockPos = BlockPos
                .iterate(blockPos.add((double) (-f), -1.0D, (double) (-f)), blockPos.add((double) f, -1.0D, (double) f))
                .iterator();

        while (iBlockPos.hasNext()) {
            BlockPos blockPos2 = (BlockPos) iBlockPos.next();
            if (blockPos2.isWithinDistance(entity.getPos(), (double) f)) {
                mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
                BlockState blockState2 = world.getBlockState(mutable);
                if (blockState2.isAir()) {
                    BlockState blockState3 = world.getBlockState(blockPos2);
                    if (blockState3.getMaterial() == Material.LAVA && (Integer) blockState3.get(FluidBlock.LEVEL) == 0
                            && blockState.canPlaceAt(world, blockPos2)
                            && world.canPlace(blockState, blockPos2, ShapeContext.absent())) {
                        world.setBlockState(blockPos2, blockState);
                        world.getBlockTickScheduler().schedule(blockPos2, ModBlockRegistry.frosted_lava,
                                MathHelper.nextInt(entity.getRandom(), 60, 120));
                    }
                }
            }
        }
    }

    private void showFrostParticles(World world, Vec3d pos) {
        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(world, new BlockPos(pos));
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());

        passedData.writeDouble(pos.x);
        passedData.writeDouble(pos.y);
        passedData.writeDouble(pos.z);

        watchingPlayers.forEach(watchingPlayer -> ServerSidePacketRegistry.INSTANCE.sendToPlayer(watchingPlayer,
                ModParticleRegistry.FROST_LAVA_EFFECT_PARTICLE_ID, passedData));
    }

}
