package com.anderson.andersonsmod.effects;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.enchantment.LastStandEnchantment;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AndersonsMod.MOD_ID);

    public static  RegistryObject<MobEffect>FREEZE  = MOB_EFFECTS.register("freeze",
                    () ->new FreezeEffect(MobEffectCategory.HARMFUL,3124687));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }


}

