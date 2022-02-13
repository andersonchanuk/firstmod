package com.anderson.andersonsmod.enchantment;

import com.anderson.andersonsmod.AndersonsMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
public static final DeferredRegister<Enchantment> ENCHANTMENTS
        = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, AndersonsMod.MOD_ID);

public static void register(IEventBus eventBus){
    ENCHANTMENTS.register(eventBus);
  }
public static RegistryObject<Enchantment> LAST_STAND =
        ENCHANTMENTS.register("last_stand",
                () ->new LastStandEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON,
                        EquipmentSlot.MAINHAND));
public static RegistryObject<Enchantment> EXECUTE =
            ENCHANTMENTS.register("execute",
                    () ->new ExecuteEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.create("aggressive",(item)->(item instanceof SwordItem||
                            item instanceof BowItem || item instanceof CrossbowItem||item instanceof TridentItem)),
                            EquipmentSlot.MAINHAND));




}
