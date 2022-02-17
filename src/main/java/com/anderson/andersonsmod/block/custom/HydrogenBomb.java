package com.anderson.andersonsmod.block.custom;

import com.anderson.andersonsmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class HydrogenBomb extends NuclearBomb{
    public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;
    public HydrogenBomb(Properties p_57422_) {
        super(p_57422_);
    }


    @Override
    public void onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable Direction face, @Nullable LivingEntity igniter) {
        world.playSound(null,pos, ModSounds.NUCLEAR_BOMB_EXPLOSION.get(), SoundSource.BLOCKS,1f,1f);
        world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 100,true, Explosion.BlockInteraction.DESTROY);

    }

    @Override
    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide) {
            pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 100,true, Explosion.BlockInteraction.DESTROY);

        }
    }
}
