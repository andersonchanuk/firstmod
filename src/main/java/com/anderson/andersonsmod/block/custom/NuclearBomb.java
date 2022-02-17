package com.anderson.andersonsmod.block.custom;

import com.anderson.andersonsmod.block.ModBlocks;
import com.anderson.andersonsmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.ticks.ScheduledTick;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class NuclearBomb extends TntBlock {
   public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;

   public NuclearBomb(Properties p_57422_) {
      super(p_57422_);
      this.registerDefaultState(this.defaultBlockState().setValue(UNSTABLE, Boolean.valueOf(false)));
   }



   @Override
   public void onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
      world.playSound(null,pos,ModSounds.NUCLEAR_BOMB_EXPLOSION.get(), SoundSource.BLOCKS,1f,1f);
      world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 100, Explosion.BlockInteraction.DESTROY);

   }



   @Override
   public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
      if (!pLevel.isClientSide) {
         pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 100, Explosion.BlockInteraction.DESTROY);

      }
   }
}


