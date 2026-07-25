package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.function.Supplier;

public class BdTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuildersDelight.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TabBlocks = registerTab("blocks", "itemGroup.tab_blocks", BdBlocks.getBlockItemMap(), () -> new ItemStack(BdBlocks.SPRUCE_PLANKS_7.get()));
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TabDecoration = registerTab("decoration", "itemGroup.tab_decoration", BdDecoration.getDecorationItemMap(), () -> new ItemStack(BdDecoration.SPRUCE_TABLE_1.get()));
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TabMaterials = registerTab("materials", "itemGroup.tab_materials", BdItems.getItemMap(), () -> new ItemStack(BdItems.SPRUCE_FURNITURE_KIT.get()));

    private static DeferredHolder<CreativeModeTab, CreativeModeTab> registerTab(String name, String titleKey, Map<String, Supplier<Item>> itemMap, Supplier<ItemStack> iconSupplier) {
        return TABS.register(name, () -> CreativeModeTab.builder()
                .title(Component.translatable(titleKey))
                .icon(iconSupplier)
                .displayItems((params, output) -> {
                    for (Supplier<Item> item : itemMap.values()) {
                        output.accept(item.get().getDefaultInstance());
                    }
                }).withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                .build());
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
