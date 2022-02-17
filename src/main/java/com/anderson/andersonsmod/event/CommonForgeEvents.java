package com.anderson.andersonsmod.event;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.entity.ModEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AndersonsMod.MOD_ID,bus= Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event) {
        if ((event.getName().equals(new ResourceLocation("minecraft:snowy_taiga")))||(event.getName().equals(new ResourceLocation("minecraft:snowy_plains")))||
                (event.getName().equals(new ResourceLocation("minecraft:snowy_beach")))||(event.getName().equals(new ResourceLocation("minecraft:snowy_slopes")))||
        (event.getName().equals(new ResourceLocation("minecraft:ice_spikes")))||(event.getName().equals(new ResourceLocation("minecraft:frozen_ocean")))||(event.getName().equals(new ResourceLocation("minecraft:frozen_river")))||
                (event.getName().equals(new ResourceLocation("minecraft:frozen_peaks")))||(event.getName().equals(new ResourceLocation("minecraft:deep_frozen_ocean")))){


            event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityTypes.FROST.get(), 15, 1, 1));

        }
    }
}
