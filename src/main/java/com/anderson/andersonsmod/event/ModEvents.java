package com.anderson.andersonsmod.event;

import com.anderson.andersonsmod.AndersonsMod;
import com.anderson.andersonsmod.effects.ModEffects;
import com.anderson.andersonsmod.entity.custom.FrostEntity;
import com.anderson.andersonsmod.item.ModItems;
import com.anderson.andersonsmod.item.custom.EnchantedRingItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.RegistryHandler;

@Mod.EventBusSubscriber(modid = AndersonsMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void bloodthirst(LivingDeathEvent event) {
        if (!event.getEntity().level.isClientSide()) {
            if (event.getSource().getEntity() instanceof Player) {
                Player player = (Player) event.getSource().getEntity();
                ItemStack hand = player.getOffhandItem();
                if (hand.getItem() instanceof EnchantedRingItem)
                {player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 2);
                    System.out.println("Yi ge don");
                }else
                    System.out.println("Ya xian");

            }
        }
    }
    @SubscribeEvent
    public static void leadimmunity(LivingHurtEvent event) {
        if (!event.getEntity().level.isClientSide()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if ((event.getSource().isExplosion()) && player.getArmorSlots() == Items.LEATHER_CHESTPLATE) {
                    event.setCanceled(true);
                }
            }
        }
    }
    @SubscribeEvent
    public static void snowballfreeze(LivingAttackEvent event) {
        if (!event.getEntity().level.isClientSide()) {
            if (event.getEntity() instanceof LivingEntity){
                LivingEntity livingentity = (LivingEntity) event.getEntity();
                if (event.getSource().getDirectEntity() instanceof Snowball) {
                livingentity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(), 50,1));
                }
            }
        }
    }
    @SubscribeEvent
    public static void blazesnowball(LivingAttackEvent event) {
        if (!event.getEntity().level.isClientSide()) {
            if (event.getEntity() instanceof LivingEntity){
               LivingEntity livingentity = (LivingEntity) event.getEntity();
                if( (event.getSource().getDirectEntity() instanceof Snowball)&& (event.getSource().getEntity() instanceof FrostEntity)) {
                    livingentity.setHealth(livingentity.getHealth()-3);
                    livingentity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(), 100,1));
                }
            }
        }
    }


}
