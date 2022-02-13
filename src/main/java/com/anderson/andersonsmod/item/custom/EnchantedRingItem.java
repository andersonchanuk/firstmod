package com.anderson.andersonsmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedGoldenAppleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EnchantedRingItem extends Item {
    public EnchantedRingItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (!pEntity.level.isClientSide()) {
            if (pEntity instanceof Player){
                LivingEntity player = (Player) pEntity;
                if (player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof EnchantedRingItem){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 10, 1));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 1));
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 10, 0));
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, 1));
                    player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 10, 5));

                }
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }



    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}

