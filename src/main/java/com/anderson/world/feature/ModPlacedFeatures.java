package com.anderson.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final PlacedFeature PLATINUM_ORE_PLACED = PlacementUtils.register("platinum_ore_placed",
            ModConfiguredFeature.PLATINUM_ORE.placed(ModOrePlacement.commonOrePlacement(13, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(120)))));
    public static final PlacedFeature BLACK_OPAL_ORE_PLACED = PlacementUtils.register("black_opal_ore_placed",
            ModConfiguredFeature.BLACK_OPAL_ORE.placed(ModOrePlacement.commonOrePlacement(150, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480)))));
}
