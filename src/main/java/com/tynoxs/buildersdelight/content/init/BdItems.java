package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.item.*;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.Map;

public class BdItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BuildersDelight.MODID);

    private static final Map<String, RegistryObject<Item>> itemMap = new LinkedHashMap<>();

    public static final RegistryObject<Item> IRON_CHISEL = registerItem("iron_chisel", () -> new BdIronChisel(new Item.Properties().stacksTo(1)), null);
    public static final RegistryObject<Item> ACACIA_FURNITURE_KIT = registerItem("acacia_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> BIRCH_FURNITURE_KIT = registerItem("birch_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> BAMBOO_FURNITURE_KIT = registerItem("bamboo_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> CHERRY_FURNITURE_KIT = registerItem("cherry_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> CRIMSON_FURNITURE_KIT = registerItem("crimson_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> DARK_OAK_FURNITURE_KIT = registerItem("dark_oak_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> JUNGLE_FURNITURE_KIT = registerItem("jungle_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> MANGROVE_FURNITURE_KIT = registerItem("mangrove_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> OAK_FURNITURE_KIT = registerItem("oak_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> SPRUCE_FURNITURE_KIT = registerItem("spruce_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);
    public static final RegistryObject<Item> WARPED_FURNITURE_KIT = registerItem("warped_furniture_kit", () -> new Item(new Item.Properties().stacksTo(64)), null);

    private static RegistryObject<Item> registerItem(String name, Supplier<Item> item, String tooltipKey) {
        RegistryObject<Item> newItem = ITEMS.register(name, item);
        itemMap.put(name, newItem);

        registerItemTooltip(newItem, tooltipKey);

        return newItem;
    }

    private static void registerItemTooltip(RegistryObject<Item> item, String tooltipKey) {
        item.ifPresent(i -> {
            ITEMS.register(tooltipKey + "_tooltip", () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
                    tooltip.add(Component.translatable("tooltip.item." + tooltipKey).withStyle(ChatFormatting.GRAY));
                }
            });
        });
    }

    public static Map<String, RegistryObject<Item>> getItemMap() {
        return itemMap;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
