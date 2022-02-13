package com.anderson.andersonsmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier PLATINUM= new ForgeTier(2, 233, 10.0F, 3.0F, 20, BlockTags.NEEDS_IRON_TOOL,
            ()-> Ingredient.of(ModItems.PLATINUM_INGOT.get()));

}
