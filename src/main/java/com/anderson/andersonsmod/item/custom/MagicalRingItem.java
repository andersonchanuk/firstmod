package com.anderson.andersonsmod.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;
import java.util.function.Consumer;

public class MagicalRingItem extends EnchantedRingItem {
    public MagicalRingItem(Properties pProperties) {
        super(pProperties.defaultDurability(500).setNoRepair());

    }


    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }


    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }



    @Override
   public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pEntity.level.isClientSide()) {
            if (pEntity instanceof Player) {
                LivingEntity player = (Player) pEntity;
                if (player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof MagicalRingItem) {

                    if (!pStack.hasTag()) {
                        pStack.setTag(new CompoundTag());
                        System.out.println("nay");
                    }
                    if (pStack.getTag().contains("TickCounter")) {
                        System.out.println("yay");
                        int tickCounter = pStack.getTag().getInt("TickCounter");
                        if (tickCounter <= 0) {
                            pStack.hurtAndBreak(1, player,LivingEntity::animateHurt);
                            pStack.getTag().putInt("TickCounter", 100);
                        } else {
                            pStack.getTag().putInt("TickCounter", --tickCounter);

                        }

                    }
                        else{
                            pStack.getTag().putInt("TickCounter", 100);
                        System.out.println(pStack.getTag().getInt("TickCounter"));
                    }
                }
            }


        }
            super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
    }
}
