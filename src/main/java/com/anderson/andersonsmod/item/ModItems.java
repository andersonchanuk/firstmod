package com.anderson.andersonsmod.item;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.item.custom.EnchantedRingItem;
import com.anderson.andersonsmod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AndersonsMod.MOD_ID);

    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword",
            ()->new SwordItem(ModTiers.PLATINUM,3,-2.4f, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe",
            ()->new PickaxeItem(ModTiers.PLATINUM,1,-2.8f, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel",
            ()->new ShovelItem(ModTiers.PLATINUM,1.5f,-3f, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe",
            ()->new HoeItem(ModTiers.PLATINUM,-3,0f, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe",
            ()->new AxeItem(ModTiers.PLATINUM,5,-3f, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_HELMET = ITEMS.register("platinum_helmet",
            ()->new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate",
            ()->new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_LEGGINGS= ITEMS.register("platinum_leggings",
            ()->new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_BOOTS = ITEMS.register("platinum_boots",
            ()->new ArmorItem(ModArmorMaterials.PLATINUM, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> PLATINUM_HORSE_ARMOR = ITEMS.register("platinum_horse_armor",
            ()->new HorseArmorItem(9, "platinum",
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));
    public static final RegistryObject<Item> LOST_IN_THE_NIGHT_RECORD = ITEMS.register("lost_in_the_night_music_disc",
            ()->new RecordItem(4, ModSounds.LOST_IN_THE_NIGHT,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> XUE_HUA_PIAO_PIAO_RECORD = ITEMS.register("xue_hua_piao_piao_music_disc",
            ()->new RecordItem(4, ModSounds.XUE_HUA_PIAO_PIAO,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> GOLD_RING = ITEMS.register("gold_ring",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> THE_ONE_RING = ITEMS.register("the_one_ring",
            ()->new EnchantedRingItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}