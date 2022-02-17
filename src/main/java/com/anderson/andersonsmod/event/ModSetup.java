package com.anderson.andersonsmod.event;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.entity.ModEntityTypes;
import com.anderson.andersonsmod.entity.custom.FrostEntity;
import com.anderson.andersonsmod.entity.model.FrostModel;
import com.anderson.andersonsmod.entity.render.FrostRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = AndersonsMod.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event){
    event.put(ModEntityTypes.FROST.get(), FrostEntity.createAttributes().build());

    }
    @SubscribeEvent
    public static  void commonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(()-> SpawnPlacements.register(ModEntityTypes.FROST.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE,FrostEntity::canSpawn));
    }




}
