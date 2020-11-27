package toinane.cakeisalie.effects;

import java.util.Random;
import java.util.stream.Stream;

import toinane.cakeisalie.registry.ModParticleRegistry;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SlimeBounceStatusEffect extends ModStatusEffect {

    boolean isJumping = false;
    Random random = new Random();

    public SlimeBounceStatusEffect(StatusEffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if (entity.world.isClient)
                this.setBoucingPlayer((PlayerEntity) entity);
        } else {
            this.setBoucingEntity(entity);
        }

        if (entity.world.isClient)
            return;
        if (this.random.nextDouble() <= 0.3D)
            this.showBouncingParticles(entity.world, entity.getPos());
    }

    private void setBoucingEntity(LivingEntity entity) {
        if (entity.isSneaking())
            return;

        if (entity.isOnGround()) {
            Vec3d vec3d = entity.getVelocity();
            if (vec3d.y < 0.0D) {
                entity.setVelocity(vec3d.x, 0.5D, vec3d.z);
            }
        }
    }

    private void setBoucingPlayer(PlayerEntity player) {
        if (player.isSneaking())
            return;

        Vec3d vel = player.getVelocity();

        if (!player.isOnGround() && !this.isJumping) { // need to be on client side
            this.isJumping = true;
            if (vel.y > 0.8D) // limit the height velocity from slimeblock
                return;
            player.setVelocity(vel.x, vel.y * 2D, vel.z);
            player.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
        } else if (!player.isOnGround() && player.verticalCollision && this.isJumping) { // stick on upper block
            player.setVelocity(vel.x, vel.y * -1D, vel.z);
        } else if (player.isOnGround() && this.isJumping) { // reset jumping
            this.isJumping = false;
        }
    }

    private void showBouncingParticles(World world, Vec3d pos) {
        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(world, new BlockPos(pos));
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
        passedData.writeDouble(pos.x);
        passedData.writeDouble(pos.y);
        passedData.writeDouble(pos.z);

        watchingPlayers.forEach(watchingPlayer -> ServerSidePacketRegistry.INSTANCE.sendToPlayer(watchingPlayer,
                ModParticleRegistry.SLIME_EFFECT_PARTICLE_ID, passedData));
    }
}