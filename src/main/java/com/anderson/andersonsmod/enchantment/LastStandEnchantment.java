package com.anderson.andersonsmod.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LastStandEnchantment extends Enchantment{
    protected LastStandEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);

    }
    public int getMinCost(int pEnchantmentLevel) {
        return 0;
    }

    @Override
    public void doPostHurt(LivingEntity pUser, Entity pAttacker, int pLevel) {
     if (!pUser.level.isClientSide()) {
         if ((pUser.getHealth() <= 8.0)&& pLevel ==1) {
             pUser.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));

         }
         if ((pUser.getHealth() <= 8.0)&& pLevel ==2) {
             pUser.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2));

         }
     }
        super.doPostHurt(pUser, pAttacker, pLevel);


    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
