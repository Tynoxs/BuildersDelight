package com.tynoxs.buildersdelight.event;

import com.tynoxs.buildersdelight.BuildersDelight;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = BuildersDelight.MODID)
public class TooltipHandler {
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();

        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        if (id == null || !id.getNamespace().equals(BuildersDelight.MODID)) return;

        if (item instanceof BlockItem) return;

        event.getToolTip().add(
            Component.translatable("tooltip.item." + id.getPath())
                   .withStyle(ChatFormatting.GRAY)
        );
    }
}
