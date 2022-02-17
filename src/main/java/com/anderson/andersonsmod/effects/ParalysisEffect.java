package com.anderson.andersonsmod.effects;

import com.anderson.andersonsmod.item.ModItems;
import com.anderson.andersonsmod.item.custom.MagicalRingItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;

public class ParalysisEffect extends MobEffect {
    protected ParalysisEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(MobEffectCategory.HARMFUL, 16776960);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

       if (!pLivingEntity.level.isClientSide()) {

                pLivingEntity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(),8,1));


       }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        {
            int k = 25 >> pAmplifier;
            if (k > 0) {
                return pDuration % k == 0;
            } else {
                return true;
            }

        }
    }
}









