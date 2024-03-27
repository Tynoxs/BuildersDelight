package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdBlocks;
import com.tynoxs.buildersdelight.content.init.BdItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class BdAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BdBlocks.SPRUCE_PLANKS_7.get()),
                        Component.translatable("advancements.buildersdelight.title"), Component.translatable("advancements.buildersdelight.description"),
                        new ResourceLocation(BuildersDelight.MODID, "textures/block/dark_oak_planks_6.png"), FrameType.TASK,
                        false, false, false))
                .addCriterion("has_iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(saver, new ResourceLocation(BuildersDelight.MODID, "root"), existingFileHelper);


        Advancement ironChisel = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BdItems.IRON_CHISEL.get()),
                        Component.translatable("advancements.iron_chisel.title"), Component.translatable("advancements.iron_chisel.description"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_iron_chisel", InventoryChangeTrigger.TriggerInstance.hasItems(BdItems.IRON_CHISEL.get()))
                .save(saver, new ResourceLocation(BuildersDelight.MODID, "iron_chisel"), existingFileHelper);

        Advancement furnitureKit = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BdItems.SPRUCE_FURNITURE_KIT.get()),
                        Component.translatable("advancements.furniture_kit.title"), Component.translatable("advancements.furniture_kit.description"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_furniture_kit", InventoryChangeTrigger.TriggerInstance.hasItems(BdItems.SPRUCE_FURNITURE_KIT.get()))
                .save(saver, new ResourceLocation(BuildersDelight.MODID, "furniture_kit"), existingFileHelper);
    }
}
