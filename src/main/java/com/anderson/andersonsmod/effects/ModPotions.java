package com.anderson.andersonsmod.effects;

import com.anderson.andersonsmod.AndersonsMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, AndersonsMod.MOD_ID);

    public static  RegistryObject<Potion>FREEZE_POTION  = POTIONS.register("freeze_potion",
            () ->new Potion(new MobEffectInstance(ModEffects.FREEZE.get(),2000,0)));
    public static  RegistryObject<Potion>PARALYSIS_POTION  = POTIONS.register("paralysis_potion",
            () ->new Potion(new MobEffectInstance(ModEffects.PARALYSIS.get(),2000,0)));
    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
