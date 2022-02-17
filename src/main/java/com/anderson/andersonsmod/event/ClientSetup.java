package com.anderson.andersonsmod.event;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.entity.ModEntityTypes;
import com.anderson.andersonsmod.entity.model.FrostModel;
import com.anderson.andersonsmod.entity.render.FrostRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AndersonsMod.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void onRegisterLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
    event.registerLayerDefinition(FrostModel.FROST_LAYER,FrostModel::createBodyLayer);
}
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityTypes.FROST.get(), FrostRenderer::new);
    }




}
