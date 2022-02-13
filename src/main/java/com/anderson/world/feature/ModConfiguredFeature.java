package com.anderson.world.feature;

import com.anderson.andersonsmod.block.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ModConfiguredFeature {
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_PLATINUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.Platinum_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.Platinum_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_BLACK_OPAL_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.Black_Opal_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.Black_Opal_ORE.get().defaultBlockState()));



    public static final ConfiguredFeature<?, ?> PLATINUM_ORE = FeatureUtils.register("platinum_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_PLATINUM_ORES, 9)));
    public static final ConfiguredFeature<?, ?> BLACK_OPAL_ORE = FeatureUtils.register("black_opal_ore",
            Feature.ORE.configured(new OreConfiguration(OVERWORLD_BLACK_OPAL_ORES, 2)));
}
