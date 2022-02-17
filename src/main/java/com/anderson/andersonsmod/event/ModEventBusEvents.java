package com.anderson.andersonsmod.event;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.event.loot.SoulFragmentFromSoulSandAdditionModifier;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = AndersonsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new SoulFragmentFromSoulSandAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(AndersonsMod.MOD_ID,"soul_fragment_from_soul_sand"))

        );
    }
}
