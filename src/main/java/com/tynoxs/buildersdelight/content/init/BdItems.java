package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.item.*;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.Map;

public class BdItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BuildersDelight.MODID);

    private static final Map<String, Supplier<Item>> itemMap = new LinkedHashMap<>();

    public static final Supplier<Item> IRON_CHISEL = registerItem("iron_chisel", () -> new BdIronChisel(new Item.Properties().stacksTo(1)), null);
    public static final Supplier<Item> ACACIA_FURNITURE_KIT = registerItem("acacia_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> BIRCH_FURNITURE_KIT = registerItem("birch_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> BAMBOO_FURNITURE_KIT = registerItem("bamboo_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> CHERRY_FURNITURE_KIT = registerItem("cherry_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> CRIMSON_FURNITURE_KIT = registerItem("crimson_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> DARK_OAK_FURNITURE_KIT = registerItem("dark_oak_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> JUNGLE_FURNITURE_KIT = registerItem("jungle_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> MANGROVE_FURNITURE_KIT = registerItem("mangrove_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> OAK_FURNITURE_KIT = registerItem("oak_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> SPRUCE_FURNITURE_KIT = registerItem("spruce_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final Supplier<Item> WARPED_FURNITURE_KIT = registerItem("warped_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);

    private static Supplier<Item> registerItem(String name, Supplier<Item> item, String tooltipKey) {
        Supplier<Item> newItem = ITEMS.register(name, item);
        itemMap.put(name, newItem);

        if (tooltipKey == null) {
            tooltipKey = name;
        }

        registerItemTooltip(newItem, tooltipKey);

        return newItem;
    }

    private static void registerItemTooltip(Supplier<Item> item, String tooltipKey) {
        //For items tooltip need TooltipHandler event
        // ITEMS.register(tooltipKey + "_tooltip", () -> new Item(new Item.Properties()) {
        //     @Override
        //     public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        //         tooltip.add(Component.translatable("tooltip.item." + tooltipKey).withStyle(ChatFormatting.GRAY));
        //     }
        // });
    }

    public static Map<String, Supplier<Item>> getItemMap() {
        return itemMap;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
