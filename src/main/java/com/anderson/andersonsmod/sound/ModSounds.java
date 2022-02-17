package com.anderson.andersonsmod.sound;

import com.anderson.andersonsmod.AndersonsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AndersonsMod.MOD_ID);

    public static RegistryObject<SoundEvent> EXECUTE_MOB
            = registerSoundEvents("execute_mob");
    public static RegistryObject<SoundEvent> LOST_IN_THE_NIGHT
            = registerSoundEvents("lost_in_the_night");
    public static RegistryObject<SoundEvent> XUE_HUA_PIAO_PIAO
            = registerSoundEvents("xue_hua_piao_piao");
    public static RegistryObject<SoundEvent> NUCLEAR_BOMB_EXPLOSION
            = registerSoundEvents("nuclear_bomb_explosion");



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(AndersonsMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}