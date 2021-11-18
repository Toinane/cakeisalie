package toinane.cakeisalie.effects;

import java.util.Random;
import java.util.stream.Stream;

import toinane.cakeisalie.registry.ModParticleRegistry;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class DestructionStatusEffect extends ModStatusEffect {

    Random random = new Random();

    public DestructionStatusEffect(StatusEffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.world;

        if (world.isClient) {

            return;
        }

        if (entity.getStatusEffect(this).getDuration() > 100 && this.random.nextDouble() <= 0.3D) {
            this.showParticles(world, entity.getPos(), 0);
        }

        if (entity.getStatusEffect(this).getDuration() <= 100 && entity.getStatusEffect(this).getDuration() > 20) {
            this.showParticles(world, entity.getPos(), 1);
        }

        if (entity.getStatusEffect(this).getDuration() == 50) {
            this.showParticles(world, entity.getPos(), 2);
        }

        if (entity.getStatusEffect(this).getDuration() == 20) {
            this.showParticles(world, entity.getPos(), 3);
            world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5.5F,
                    world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY
                            : Explosion.DestructionType.NONE);
            entity.damage(DamageSource.explosion(entity), Float.MAX_VALUE);
        }
    }

    private void showParticles(World world, Vec3d pos, int phase) {
        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(world, new BlockPos(pos));
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());

        passedData.writeDouble(pos.x);
        passedData.writeDouble(pos.y);
        passedData.writeDouble(pos.z);
        passedData.writeInt(phase);

        watchingPlayers.forEach(watchingPlayer -> ServerSidePacketRegistry.INSTANCE.sendToPlayer(watchingPlayer,
                ModParticleRegistry.DESTRUCTION_EFFECT_PARTICLE_ID, passedData));
    }

}
