package com.anderson.andersonsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Properties;

public class Black_Opal_Ore extends Block {
    public Black_Opal_Ore(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level pLevel, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if(!pLevel.isClientSide()) {
            if(player instanceof LivingEntity) {
                player.addEffect(new MobEffectInstance(MobEffects.WITHER, 200,1));
            }
        }
        return super.onDestroyedByPlayer(state, pLevel, pos, player, willHarvest, fluid);
    }


}


