package com.anderson.andersonsmod.entity.render;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.entity.custom.FrostEntity;
import com.anderson.andersonsmod.entity.model.FrostModel;
import net.minecraft.client.model.BlazeModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.BlazeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Blaze;
import org.checkerframework.checker.nullness.qual.NonNull;

public class FrostRenderer extends BlazeRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(AndersonsMod.MOD_ID,"textures/entity/frost.png");
    public FrostRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
    @NonNull
    @Override
    public ResourceLocation getTextureLocation(Blaze pEntity) {
        return TEXTURE;
    }
}
