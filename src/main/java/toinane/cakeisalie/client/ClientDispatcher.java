package toinane.cakeisalie.client;

import java.util.Random;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import toinane.cakeisalie.registry.ModParticleRegistry;

public class ClientDispatcher implements ClientModInitializer {

        Random random = new Random();

        @Override
        public void onInitializeClient() {

                ClientSidePacketRegistry.INSTANCE.register(ModParticleRegistry.ENDER_CAKE_PARTICLE_ID,
                                (packetContext, attachedData) -> {
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        ParticleEffect type = attachedData.readBoolean() ? ParticleTypes.PORTAL
                                                        : ParticleTypes.REVERSE_PORTAL;
                                        BlockPos pos = attachedData.readBlockPos();

                                        for (int i = 0; i < 32; ++i) {
                                                client.particleManager.addParticle(type, pos.getX(),
                                                                pos.getY() + this.random.nextDouble() * 2.0D,
                                                                pos.getZ(), this.random.nextGaussian() * 0.5D, 0.0D,
                                                                this.random.nextGaussian() * 0.5D);
                                        }
                                });

                ClientSidePacketRegistry.INSTANCE.register(ModParticleRegistry.LAVA_CAKE_PARTICLE_ID,
                                (packetContext, attachedData) -> {
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        BlockPos pos = attachedData.readBlockPos();

                                        client.world.playSound(pos.getX(), pos.getY(), pos.getZ(),
                                                        SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1F, 1F,
                                                        false);
                                        for (int i = 0; i < 7; ++i) {
                                                client.particleManager.addParticle(ParticleTypes.LARGE_SMOKE,
                                                                pos.getX() + this.random.nextDouble() * 1.0D,
                                                                pos.getY() + 0.8D + this.random.nextDouble() * 0.4D,
                                                                pos.getZ() + this.random.nextDouble() * 1.0D, 0D, 0D,
                                                                0D);
                                        }
                                });

                ClientSidePacketRegistry.INSTANCE.register(ModParticleRegistry.SLIME_EFFECT_PARTICLE_ID,
                                (packetContext, attachedData) -> {
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        Double posX = attachedData.readDouble();
                                        Double posY = attachedData.readDouble();
                                        Double posZ = attachedData.readDouble();

                                        client.particleManager.addParticle(ParticleTypes.ITEM_SLIME, posX,
                                                        posY + this.random.nextDouble() * 2D, posZ,
                                                        this.random.nextGaussian(), 0.0D, this.random.nextGaussian());

                                });

                ClientSidePacketRegistry.INSTANCE.register(ModParticleRegistry.DESTRUCTION_EFFECT_PARTICLE_ID,
                                (packetContext, attachedData) -> {
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        Double posX = attachedData.readDouble();
                                        Double posY = attachedData.readDouble();
                                        Double posZ = attachedData.readDouble();
                                        int phase = attachedData.readInt();

                                        if (phase == 1) {
                                                client.particleManager.addParticle(ParticleTypes.SPIT, posX,
                                                                posY + this.random.nextDouble() * 2D, posZ,
                                                                this.random.nextGaussian() * 0.1D, 0.2D,
                                                                this.random.nextGaussian() * 0.1D);
                                                client.particleManager.addParticle(ParticleTypes.CLOUD, posX,
                                                                posY + this.random.nextDouble() * 2D, posZ,
                                                                this.random.nextGaussian() * 0.1D, 0.2D,
                                                                this.random.nextGaussian() * 0.1D);
                                        }
                                        if (phase == 2) {
                                                client.world.playSound(new BlockPos(posX, posY, posZ),
                                                                SoundEvents.ENTITY_CREEPER_PRIMED,
                                                                SoundCategory.PLAYERS, 2F, 1F, false);
                                        }
                                        if (phase == 3) {
                                                for (int i = 0; i < 10; i++) {
                                                        client.particleManager.addParticle(ParticleTypes.FLASH, posX,
                                                                        posY + 1D, posZ, 0D, 0.0D, 0D);
                                                }
                                                client.particleManager.addParticle(ParticleTypes.EXPLOSION_EMITTER,
                                                                posX, posY + 1D, posZ, 0D, 0.0D, 0D);
                                        }

                                        client.particleManager.addParticle(ParticleTypes.INSTANT_EFFECT, posX,
                                                        posY + this.random.nextDouble() * 2D, posZ,
                                                        this.random.nextGaussian() * 0.3D, 0.2D,
                                                        this.random.nextGaussian() * 0.3D);
                                        client.particleManager.addParticle(ParticleTypes.POOF, posX,
                                                        posY + this.random.nextDouble() * 2D, posZ,
                                                        this.random.nextGaussian() * 0.1D, 0.2D,
                                                        this.random.nextGaussian() * 0.1D);

                                });

                ClientSidePacketRegistry.INSTANCE.register(ModParticleRegistry.FROST_EFFECT_PARTICLE_ID,
                                (packetContext, attachedData) -> {
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        Double posX = attachedData.readDouble();
                                        Double posY = attachedData.readDouble();
                                        Double posZ = attachedData.readDouble();

                                        client.particleManager.addParticle(ParticleTypes.SPIT, posX,
                                                        posY + this.random.nextDouble() * 0.2D, posZ, 0D, 0D, 0D);

                                });

                ClientSidePacketRegistry.INSTANCE.register(ModParticleRegistry.FROST_LAVA_EFFECT_PARTICLE_ID,
                                (packetContext, attachedData) -> {
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        Double posX = attachedData.readDouble();
                                        Double posY = attachedData.readDouble();
                                        Double posZ = attachedData.readDouble();

                                        client.particleManager.addParticle(ParticleTypes.LAVA, posX,
                                                        posY + this.random.nextDouble() * 0.2D, posZ, 0D, 0D, 0D);

                                });
        }
}
