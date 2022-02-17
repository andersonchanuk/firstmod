package com.anderson.andersonsmod.entity.model;

import com.anderson.andersonsmod.AndersonsMod;
import net.minecraft.client.model.BlazeModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

import java.util.stream.Stream;

public class FrostModel extends BlazeModel {
    public static final String BODY = "body";
    public static ModelLayerLocation FROST_LAYER = new ModelLayerLocation(new ResourceLocation(AndersonsMod.MOD_ID,"frost"),BODY);


    public FrostModel(ModelPart pRoot) {
        super(pRoot);
    }
    public static AttributeSupplier.Builder setCustomAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH,20.0).add(Attributes.MOVEMENT_SPEED,0.23F).add(Attributes.FOLLOW_RANGE, 48.0D).add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

}
