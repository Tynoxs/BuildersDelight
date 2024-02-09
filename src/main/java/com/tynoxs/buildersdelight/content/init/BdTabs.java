package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BdTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuildersDelight.MODID);
    public static final RegistryObject<CreativeModeTab> TabBlocks = TABS.register("blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tab_blocks"))
            .icon(() -> new ItemStack(BdBlocks.SPRUCE_PLANKS_7.get()))
            .displayItems((params, output) -> {
                for (RegistryObject<Item> item : BdBlocks.getBlockItemMap().values()) {
                    output.accept(item.get().getDefaultInstance());
                }

            }).withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .build());

    public static final RegistryObject<CreativeModeTab> TabDecoration = TABS.register("decoration", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tab_decoration"))
            .icon(() -> new ItemStack(BdDecoration.SPRUCE_TABLE_1.get()))
            .displayItems((params, output) -> {
                for (RegistryObject<Item> item : BdDecoration.getDecorationItemMap().values()) {
                    output.accept(item.get().getDefaultInstance());
                }
            }).withTabsBefore(TabBlocks.getKey())
            .build());

    public static final RegistryObject<CreativeModeTab> TabMaterials = TABS.register("materials", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tab_materials"))
            .icon(() -> new ItemStack(BdItems.SPRUCE_FURNITURE_KIT.get()))
            .displayItems((params, output) -> {
                for (RegistryObject<Item> item : BdItems.getItemMap().values()) {
                    output.accept(item.get().getDefaultInstance());
                }
            }).withTabsBefore(TabDecoration.getKey())
            .build());
}
