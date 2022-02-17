package com.anderson.andersonsmod.effects;

import com.anderson.andersonsmod.AndersonsMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AndersonsMod.MOD_ID);

    public static  RegistryObject<MobEffect>FREEZE  = MOB_EFFECTS.register("freeze",
                    () ->new FreezeEffect(MobEffectCategory.HARMFUL,3124687));
    public static  RegistryObject<MobEffect>PARALYSIS  = MOB_EFFECTS.register("paralysis",
            () ->new ParalysisEffect(MobEffectCategory.HARMFUL,16776960));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }


}

