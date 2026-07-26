package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BdItemTagProvider extends ItemTagsProvider {

    public BdItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                             CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, BuildersDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        var glassBlocksItemTag = this.tag(Tags.Items.GLASS_BLOCKS);
        var glassBlocksCheapTag = this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "glass_blocks/cheap")));
        var glassBlocksColorlessTag = this.tag(Tags.Items.GLASS_BLOCKS_COLORLESS);

        var glassPanesItemTag = this.tag(Tags.Items.GLASS_PANES);
        var glassPanesColorlessTag = this.tag(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "glass_panes/colorless")));

        for (Map.Entry<String, Supplier<Item>> entry : BdBlocks.getBlockItemMap().entrySet()) {
            String registryName = entry.getKey().toLowerCase();
            Item item = entry.getValue().get();

            if (registryName.contains("glass") && !registryName.contains("pane")) {
                glassBlocksItemTag.add(item);

                if (!isStainedGlass(registryName)) {
                    glassBlocksCheapTag.add(item);
                    glassBlocksColorlessTag.add(item);
                }
            } else if (registryName.contains("pane")) {
                glassPanesItemTag.add(item);

                if (!isStainedGlass(registryName)) {
                    glassPanesColorlessTag.add(item);
                }
            }
        }

        addItemByName();
    }

    private boolean isStainedGlass(String name) {
        return name.contains("white") || name.contains("orange") || name.contains("magenta") ||
                name.contains("light_blue") || name.contains("yellow") || name.contains("lime") ||
                name.contains("pink") || name.contains("gray") || name.contains("light_gray") ||
                name.contains("cyan") || name.contains("purple") || name.contains("blue") ||
                name.contains("brown") || name.contains("green") || name.contains("red") ||
                name.contains("black");
    }

    private void addItemByName() {
        Map<String, List<Item>> blocksByType = new HashMap<>();
        for (Map.Entry<String, Supplier<Item>> entry : BdBlocks.getBlockItemMap().entrySet()) {
            String registryName = entry.getKey();
            int lastUnderscore = registryName.lastIndexOf('_');
            if (lastUnderscore > 0) {
                String typePrefix = registryName.substring(0, lastUnderscore);
                String suffix = registryName.substring(lastUnderscore + 1);
                if (suffix.matches("\\d+")) {
                    blocksByType.computeIfAbsent(typePrefix.toUpperCase(), k -> new ArrayList<>()).add(entry.getValue().get());
                }
            }
        }

        Map<String, Consumer<Item>> tagMappings = createTagMappings();
        for (Map.Entry<String, List<Item>> entry : blocksByType.entrySet()) {
            String blockType = entry.getKey();
            List<Item> items = entry.getValue();
            Consumer<Item> consumer = tagMappings.get(blockType);
            if (consumer != null) {
                items.forEach(consumer);
            }
        }
    }

    private Map<String, Consumer<Item>> createTagMappings() {
        Map<String, Consumer<Item>> tagMappings = new HashMap<>();

        tagMappings.put("COBBLESTONE", this::tagCobblestone);
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

        tagMappings.put("SANDSTONE", this::addSandstoneTags);

        return tagMappings;
    }

    private void tagCobblestone(Item item) {
        this.tag(Tags.Items.COBBLESTONES).add(item);
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(item);
    }

    private void tagStone(Item item) {
        this.tag(Tags.Items.STONES).add(item);
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
        this.tag(Tags.Items.SANDSTONE_BLOCKS).add(item);
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}