package com.anderson.andersonsmod.effects;



import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

//freezes entity in place//
public class FreezeEffect extends MobEffect {

    public FreezeEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(MobEffectCategory.HARMFUL, 3124687);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            Double x = pLivingEntity.getX();
            Double y = pLivingEntity.getY();
            Double z = pLivingEntity.getZ();
            pLivingEntity.teleportTo(x, y, z);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}