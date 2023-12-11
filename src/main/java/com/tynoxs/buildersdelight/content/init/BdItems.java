package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.item.*;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.Map;

public class BdItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BuildersDelight.MODID);

    /**
     * Contains the list of item instances.
     */
    private static final ConcurrentHashMap<String, RegistryObject<Item>> itemMap = new ConcurrentHashMap<>();

    public static final RegistryObject<Item> IRON_CHISEL = registerItem("iron_chisel", () -> new BdIronChisel(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ACACIA_FURNITURE_KIT = registerItem("acacia_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> BIRCH_FURNITURE_KIT = registerItem("birch_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> CRIMSON_FURNITURE_KIT = registerItem("crimson_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> DARK_OAK_FURNITURE_KIT = registerItem("dark_oak_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> JUNGLE_FURNITURE_KIT = registerItem("jungle_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> OAK_FURNITURE_KIT = registerItem("oak_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SPRUCE_FURNITURE_KIT = registerItem("spruce_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> WARPED_FURNITURE_KIT = registerItem("warped_furniture_kit", () -> new BdFurnitureKit(new Item.Properties().stacksTo(64)));

    private static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        RegistryObject<Item> newItem = ITEMS.register(name, item);
        itemMap.put(name, newItem);

        return newItem;
    }

    private static RegistryObject<Item> register(String name, Item item)
    {
        return ITEMS.register(name, () -> item);
    }

    public static Map<String, RegistryObject<Item>> getItemMap()
    {
        return itemMap;
    }
}
