package toinane.cakeisalie.blocks.cakes;

import java.util.Random;
import java.util.stream.Stream;

import toinane.cakeisalie.registry.ModParticleRegistry;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class EnderCakeBlock extends CakeBlock {

   protected static final VoxelShape[] BITES_TO_SHAPE;

   Random random = new Random();

   public EnderCakeBlock(int totalBites) {
      super(totalBites);
   }

   @Override
   protected ActionResult setEffectForCake(World world, BlockPos pos, BlockState state, PlayerEntity player) {
      player.getHungerManager().add(2, 0.1F);
      this.teleport(player);

      return ActionResult.SUCCESS;
   }

   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return BITES_TO_SHAPE[(Integer) state.get(BITES)];
   }

   private double randomCoordinate(double rangeMin, double rangeMax) {
      double result = rangeMin + (rangeMax - rangeMin) * this.random.nextDouble();
      if (this.random.nextBoolean())
         result = result - (result * 2);

      return result;
   }

   private Vec3d getNewLocationToTeleportFromCoordinates(Vec3d currentPos) {
      int x = (int) (currentPos.getX() + randomCoordinate(50D, 150D));
      int y = (int) (currentPos.getY() + randomCoordinate(0D, 15D));
      int z = (int) (currentPos.getZ() + randomCoordinate(50D, 150D));

      if (y < 4)
         y = 4;
      if (y > 190)
         y = 190;

      return new Vec3d(x, y, z);
   }

   private Vec3d getLocationToTeleport(World world, Vec3d currentPos, boolean checkTopDirection,
         boolean newLocationRequired) {
      int heightMaxLimit = 190;
      int heightMinLimit = 4;

      BlockState blockHead = world.getBlockState(new BlockPos(currentPos.x, currentPos.y + 1, currentPos.z));
      BlockState blockFoot = world.getBlockState(new BlockPos(currentPos));
      BlockState blockGround = world.getBlockState(new BlockPos(currentPos.x, currentPos.y - 1, currentPos.z));

      if ((blockHead.isAir() && blockFoot.isAir() && (!blockGround.isAir() && !blockGround.isOf(Blocks.LAVA)))
            || (blockHead.isOf(Blocks.WATER) && blockFoot.isOf(Blocks.WATER))) {

         return currentPos;
      } else {
         Vec3d nextPos = currentPos;

         if (currentPos.y == heightMaxLimit || currentPos.y == heightMinLimit) {
            if (newLocationRequired) {
               currentPos = this.getNewLocationToTeleportFromCoordinates(currentPos);
            }
            checkTopDirection = !checkTopDirection;
            newLocationRequired = !newLocationRequired;
         }

         if (checkTopDirection) {
            nextPos = new Vec3d(currentPos.x, currentPos.y + 1, currentPos.z);
         } else {
            nextPos = new Vec3d(currentPos.x, currentPos.y - 1, currentPos.z);
         }

         return this.getLocationToTeleport(world, nextPos, checkTopDirection, newLocationRequired);
      }
   }

   private void showTeleportParticles(World world, BlockPos pos, boolean isTeleported) {
      Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(world, pos);
      PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
      passedData.writeBoolean(isTeleported);
      passedData.writeBlockPos(pos);

      watchingPlayers.forEach(watchingPlayer -> ServerSidePacketRegistry.INSTANCE.sendToPlayer(watchingPlayer,
            ModParticleRegistry.ENDER_CAKE_PARTICLE_ID, passedData));
   }

   private boolean teleport(PlayerEntity player) {
      if (player.world.isClient())
         return false;

      Vec3d newPosition = this.getNewLocationToTeleportFromCoordinates(player.getPos());
      Vec3d positionToTeleport = this.getLocationToTeleport(player.world, newPosition, this.random.nextBoolean(),
            false);

      if (player instanceof ServerPlayerEntity) {
         ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) player;
         if (serverPlayerEntity.networkHandler.getConnection().isOpen() && serverPlayerEntity.world == player.world
               && !serverPlayerEntity.isSleeping()) {
            if (this.random.nextFloat() < 0.05F && player.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
               EndermiteEntity endermiteEntity = (EndermiteEntity) EntityType.ENDERMITE.create(player.world);
               endermiteEntity.setPlayerSpawned(true);
               endermiteEntity.refreshPositionAndAngles(positionToTeleport.x, positionToTeleport.y,
                     positionToTeleport.z, player.yaw, player.pitch);
               player.world.spawnEntity(endermiteEntity);
            }
         }
      }

      if (player.hasVehicle()) {
         player.stopRiding();
      }

      player.world.playSound(player, player.getPos().x, player.getPos().y, player.getPos().z,
            SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.AMBIENT, 1F, 1F);
      this.showTeleportParticles(player.world, player.getBlockPos(), false);
      player.requestTeleport(positionToTeleport.x, positionToTeleport.y, positionToTeleport.z);
      player.world.playSound(null, positionToTeleport.x, positionToTeleport.y, positionToTeleport.z,
            SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.AMBIENT, 1F, 1F);
      this.showTeleportParticles(player.world, new BlockPos(positionToTeleport), true);

      return true;
   }

   static {
      BITES_TO_SHAPE = new VoxelShape[] { Block.createCuboidShape(1D, 0D, 1D, 15D, 8D, 15D),
            Block.createCuboidShape(7D, 0D, 1D, 15D, 8D, 15D), Block.createCuboidShape(13D, 0D, 1D, 15D, 8D, 15D),
            Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D),
            Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D), Block.createCuboidShape(0D, 0D, 0D, 0D, 0D, 0D) };
   }
}