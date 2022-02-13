package com.anderson.andersonsmod.enchantment;

import com.anderson.andersonsmod.sound.ModSounds;
import com.sun.jna.platform.win32.OaIdl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;


public class ExecuteEnchantment extends Enchantment {
    protected ExecuteEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 0;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            if (pTarget instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) pTarget;
                if (livingentity.getHealth() <= livingentity.getMaxHealth()/5) {
                    livingentity.setHealth(0);
                    if (pAttacker instanceof Player) {
                        Player player = (Player) pAttacker;
                        player.getLevel().playSound(player,pTarget,ModSounds.EXECUTE_MOB.get(),SoundSource.PLAYERS,1f,1f);
                        System.out.println("yay");
                    }
                }

            }
        }
            super.doPostAttack(pAttacker, pTarget, pLevel);

    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
