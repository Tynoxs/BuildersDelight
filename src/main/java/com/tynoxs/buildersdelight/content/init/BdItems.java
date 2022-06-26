package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.item.*;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BdItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BuildersDelight.MODID);

    public static final RegistryObject<Item> IRON_CHISEL = ITEMS.register("iron_chisel", () -> new BdIronChisel(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(1)));
    public static final RegistryObject<Item> ACACIA_PLANK = ITEMS.register("acacia_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> ACACIA_FURNITURE_KIT = ITEMS.register("acacia_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> BIRCH_PLANK = ITEMS.register("birch_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> BIRCH_FURNITURE_KIT = ITEMS.register("birch_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> CRIMSON_PLANK = ITEMS.register("crimson_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> CRIMSON_FURNITURE_KIT = ITEMS.register("crimson_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> DARK_OAK_PLANK = ITEMS.register("dark_oak_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> DARK_OAK_FURNITURE_KIT = ITEMS.register("dark_oak_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> JUNGLE_PLANK = ITEMS.register("jungle_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> JUNGLE_FURNITURE_KIT = ITEMS.register("jungle_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> OAK_PLANK = ITEMS.register("oak_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> OAK_FURNITURE_KIT = ITEMS.register("oak_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> SPRUCE_PLANK = ITEMS.register("spruce_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> SPRUCE_FURNITURE_KIT = ITEMS.register("spruce_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> WARPED_PLANK = ITEMS.register("warped_plank", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));
    public static final RegistryObject<Item> WARPED_FURNITURE_KIT = ITEMS.register("warped_furniture_kit", () -> new BdItem(new Item.Properties().tab(BdTabs.TabMaterials).stacksTo(64)));

    private static RegistryObject<Item> register(String name, Item item)
    {
        return ITEMS.register(name, () -> item);
    }
}