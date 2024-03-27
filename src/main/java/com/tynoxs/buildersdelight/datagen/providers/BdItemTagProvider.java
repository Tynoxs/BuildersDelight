package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.common.Tags.Items;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BdItemTagProvider extends ItemTagsProvider {

    public BdItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                             CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, BuildersDelight.MODID, existingFileHelper);
    }

    private int getMaxBlockNumber(String blockType) {
        return BdBlockCount.BLOCK_COUNTS.getOrDefault(blockType, 0);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        addItemByName();
    }

    private void addItemByName() {
        for (String blockType : BdBlockCount.BLOCK_COUNTS.keySet()) {
            int maxBlockNumber = getMaxBlockNumber(blockType);

            for (int i = 1; i <= maxBlockNumber; i++) {
                String registryName = blockType.toLowerCase() + "_" + i;
                RegistryObject<Item> itemRegistryObject = BdBlocks.getBlockItemMap().get(registryName);

                if (itemRegistryObject != null) {
                    addTagsForBlockType(blockType, itemRegistryObject.get());
                }
            }
        }
    }

    private void addTagsForBlockType(String blockType, Item item) {
        Map<String, Consumer<Item>> tagMappings = createTagMappings();
        tagMappings.getOrDefault(blockType, (unused) -> {}).accept(item);
    }

    private Map<String, Consumer<Item>> createTagMappings() {
        Map<String, Consumer<Item>> tagMappings = new HashMap<>();

        tagMappings.put("COBBLESTONE", this::tagCobblestone);
        tagMappings.put("GLASS", this::tagGlass);
        tagMappings.put("GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("ANDESITE", this::tagStone);
        tagMappings.put("DIORITE", this::tagStone);
        tagMappings.put("GRANITE", this::tagStone);

        tagMappings.put("ACACIA_PLANKS", this::tagPlanks);
        tagMappings.put("BAMBOO_PLANKS", this::tagPlanks);
        tagMappings.put("BIRCH_PLANKS", this::tagPlanks);
        tagMappings.put("CHERRY_PLANKS", this::tagPlanks);
        tagMappings.put("CRIMSON_PLANKS", this::tagPlanks);
        tagMappings.put("DARK_OAK_PLANKS", this::tagPlanks);
        tagMappings.put("JUNGLE_PLANKS", this::tagPlanks);
        tagMappings.put("MANGROVE_PLANKS", this::tagPlanks);
        tagMappings.put("OAK_PLANKS", this::tagPlanks);
        tagMappings.put("SPRUCE_PLANKS", this::tagPlanks);
        tagMappings.put("WARPED_PLANKS", this::tagPlanks);

        tagMappings.put("ACACIA_STAIRS", this::tagWoodenStairs);
        tagMappings.put("BAMBOO_STAIRS", this::tagWoodenStairs);
        tagMappings.put("BIRCH_STAIRS", this::tagWoodenStairs);
        tagMappings.put("CHERRY_STAIRS", this::tagWoodenStairs);
        tagMappings.put("CRIMSON_STAIRS", this::tagWoodenStairs);
        tagMappings.put("DARK_OAK_STAIRS", this::tagWoodenStairs);
        tagMappings.put("JUNGLE_STAIRS", this::tagWoodenStairs);
        tagMappings.put("MANGROVE_STAIRS", this::tagWoodenStairs);
        tagMappings.put("OAK_STAIRS", this::tagWoodenStairs);
        tagMappings.put("SPRUCE_STAIRS", this::tagWoodenStairs);
        tagMappings.put("WARPED_STAIRS", this::tagWoodenStairs);

        tagMappings.put("ACACIA_SLAB", this::tagWoodenSlabs);
        tagMappings.put("BAMBOO_SLAB", this::tagWoodenSlabs);
        tagMappings.put("BIRCH_SLAB", this::tagWoodenSlabs);
        tagMappings.put("CHERRY_SLAB", this::tagWoodenSlabs);
        tagMappings.put("CRIMSON_SLAB", this::tagWoodenSlabs);
        tagMappings.put("DARK_OAK_SLAB", this::tagWoodenSlabs);
        tagMappings.put("JUNGLE_SLAB", this::tagWoodenSlabs);
        tagMappings.put("MANGROVE_SLAB", this::tagWoodenSlabs);
        tagMappings.put("OAK_SLAB", this::tagWoodenSlabs);
        tagMappings.put("SPRUCE_SLAB", this::tagWoodenSlabs);
        tagMappings.put("WARPED_SLAB", this::tagWoodenSlabs);

        tagMappings.put("ACACIA_GLASS", this::tagGlass);
        tagMappings.put("BAMBOO_GLASS", this::tagGlass);
        tagMappings.put("BIRCH_GLASS", this::tagGlass);
        tagMappings.put("CHERRY_GLASS", this::tagGlass);
        tagMappings.put("CRIMSON_GLASS", this::tagGlass);
        tagMappings.put("DARK_OAK_GLASS", this::tagGlass);
        tagMappings.put("JUNGLE_GLASS", this::tagGlass);
        tagMappings.put("MANGROVE_GLASS", this::tagGlass);
        tagMappings.put("OAK_GLASS", this::tagGlass);
        tagMappings.put("SPRUCE_GLASS", this::tagGlass);
        tagMappings.put("WARPED_GLASS", this::tagGlass);

        tagMappings.put("ACACIA_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("BAMBOO_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("BIRCH_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("CHERRY_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("CRIMSON_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("DARK_OAK_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("JUNGLE_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("MANGROVE_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("OAK_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("SPRUCE_GLASS_PANE", this::tagGlassPanes);
        tagMappings.put("WARPED_GLASS_PANE", this::tagGlassPanes);

        tagMappings.put("SANDSTONE", this::addSandstoneTags);

        return tagMappings;
    }

    private void tagCobblestone(Item item) {
        this.tag(Items.COBBLESTONE).add(item);
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(item);
    }

    private void tagGlass(Item item) {
        this.tag(Items.GLASS).add(item);
        this.tag(Items.GLASS_COLORLESS).add(item);
    }

    private void tagGlassPanes(Item item) {
        this.tag(Items.GLASS_PANES).add(item);
        this.tag(Items.GLASS_PANES_COLORLESS).add(item);
    }

    private void tagStone(Item item) {
        this.tag(Items.STONE).add(item);
    }

    private void tagPlanks(Item item) {
        this.tag(ItemTags.PLANKS).add(item);
    }

    private void tagWoodenStairs(Item item) {
        this.tag(ItemTags.WOODEN_STAIRS).add(item);
    }

    private void tagWoodenSlabs(Item item) {
        this.tag(ItemTags.WOODEN_SLABS).add(item);
    }

    private void addSandstoneTags(Item item) {
        this.tag(Items.SANDSTONE).add(item);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
