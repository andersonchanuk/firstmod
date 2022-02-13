package com.anderson.andersonsmod.effects;



import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class FreezeEffect extends MobEffect {

    public FreezeEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(MobEffectCategory.HARMFUL, 3124687);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            pLivingEntity.teleportTo(pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ());
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}