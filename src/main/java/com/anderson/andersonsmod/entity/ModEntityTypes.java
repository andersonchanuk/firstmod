package com.anderson.andersonsmod.entity;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.block.custom.HydrogenBomb;
import com.anderson.andersonsmod.entity.custom.FrostEntity;
import com.anderson.andersonsmod.item.ModCreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FrostedIceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, AndersonsMod.MOD_ID);
    public static final RegistryObject<EntityType<FrostEntity>> FROST = ENTITIES.register("frost",
            () ->EntityType.Builder.of(FrostEntity::new, MobCategory.MONSTER).sized(0.6f,1.8f).build(new ResourceLocation(AndersonsMod.MOD_ID,"frost").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

}



