package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdBlocks;
import com.tynoxs.buildersdelight.content.init.BdDecoration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BdBlockTagProvider extends BlockTagsProvider {
    public BdBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BuildersDelight.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        Map<String, List<Consumer<RegistryObject<Item>>>> tagMappings = createTagMappings();
        Map<String, RegistryObject<Item>> allBlockItems = getAllBlockItems();

        this.tag(BdTags.Blocks.GLASS)
                .addTags(Tags.Blocks.GLASS)
                .addTags(Tags.Blocks.GLASS_COLORLESS);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BdDecoration.EXPOSED_LANTERN_3.get(),
                    BdDecoration.WEATHERED_LANTERN_3.get(),
                    BdDecoration.OXIDIZED_LANTERN_3.get(),
                    BdDecoration.WAXED_LANTERN_3.get(),
                    BdDecoration.WAXED_EXPOSED_LANTERN_3.get(),
                    BdDecoration.WAXED_WEATHERED_LANTERN_3.get(),
                    BdDecoration.WAXED_OXIDIZED_LANTERN_3.get(),

                    BdDecoration.EXPOSED_CHAIN_3.get(),
                    BdDecoration.WEATHERED_CHAIN_3.get(),
                    BdDecoration.OXIDIZED_CHAIN_3.get(),
                    BdDecoration.WAXED_CHAIN_3.get(),
                    BdDecoration.WAXED_EXPOSED_CHAIN_3.get(),
                    BdDecoration.WAXED_WEATHERED_CHAIN_3.get(),
                    BdDecoration.WAXED_OXIDIZED_CHAIN_3.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BdDecoration.LANTERN_8.get()
                );

        BdBlockCount.BLOCK_COUNTS.forEach((blockType, maxBlockNumber) -> {
            for (int i = 1; i <= maxBlockNumber; i++) {
                String registryName = blockType.toLowerCase() + "_" + i;
                RegistryObject<Item> itemRegistryObject = allBlockItems.get(registryName);

                if (itemRegistryObject != null) {
                    tagMappings.getOrDefault(blockType, Collections.emptyList())
                            .forEach(consumer -> consumer.accept(itemRegistryObject));
                }
            }
        });
    }

    private Map<String, RegistryObject<Item>> getAllBlockItems() {
        Map<String, RegistryObject<Item>> allBlockItems = new HashMap<>();
        allBlockItems.putAll(BdBlocks.getBlockItemMap());
        allBlockItems.putAll(BdDecoration.getDecorationItemMap());

        return allBlockItems;
    }

    private Map<String, List<Consumer<RegistryObject<Item>>>> createTagMappings() {
        Map<String, List<Consumer<RegistryObject<Item>>>> tagMappings = new HashMap<>();

        tagMappings.put("ACACIA_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("ACACIA_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("BAMBOO_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("BAMBOO_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("BIRCH_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("BIRCH_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("CHERRY_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("CHERRY_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("CRIMSON_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("CRIMSON_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("DARK_OAK_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("DARK_OAK_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("JUNGLE_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("JUNGLE_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("MANGROVE_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("MANGROVE_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("OAK_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("OAK_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("SPRUCE_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("SPRUCE_TABLE", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("WARPED_CHAIR", Collections.singletonList(this::tagMineableWithAxe));
        tagMappings.put("WARPED_TABLE", Collections.singletonList(this::tagMineableWithAxe));

        tagMappings.put("ACACIA_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("BAMBOO_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("BIRCH_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("CHERRY_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("CRIMSON_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("DARK_OAK_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("JUNGLE_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("MANGROVE_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("OAK_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("SPRUCE_FRAME", Collections.singletonList(this::tagMineableWithHoe));
        tagMappings.put("WARPED_FRAME", Collections.singletonList(this::tagMineableWithHoe));

        tagMappings.put("ACACIA_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("BAMBOO_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("BIRCH_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("CHERRY_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("CRIMSON_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("DARK_OAK_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("JUNGLE_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("MANGROVE_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("OAK_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("SPRUCE_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));
        tagMappings.put("WARPED_PLANKS", Arrays.asList(this::tagPlanks, this::tagMineableWithAxe));

        tagMappings.put("ACACIA_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("BAMBOO_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("BIRCH_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("CHERRY_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("CRIMSON_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("DARK_OAK_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("JUNGLE_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("MANGROVE_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("OAK_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("SPRUCE_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));
        tagMappings.put("WARPED_STAIRS", Arrays.asList(this::tagWoodenStairs, this::tagMineableWithAxe));

        tagMappings.put("ACACIA_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("BAMBOO_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("BIRCH_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("CHERRY_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("CRIMSON_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("DARK_OAK_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("JUNGLE_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("MANGROVE_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("OAK_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("SPRUCE_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));
        tagMappings.put("WARPED_SLAB", Arrays.asList(this::tagWoodenSlabs, this::tagMineableWithAxe));

        tagMappings.put("AMETHYST_BLOCK", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("AMETHYST_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("AMETHYST_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("ANDESITE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("ANDESITE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("ANDESITE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DIORITE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DIORITE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DIORITE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("COBBLESTONE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("COBBLESTONE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("COBBLESTONE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("GRANITE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("GRANITE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("GRANITE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("CALCITE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("CALCITE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("CALCITE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DEEPSLATE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DEEPSLATE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DEEPSLATE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DRIPSTONE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DRIPSTONE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("DRIPSTONE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("PRISMARINE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("PRISMARINE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("PRISMARINE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("SANDSTONE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("SANDSTONE_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("SANDSTONE_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("TUFF", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("TUFF_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("TUFF_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("BRICKS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("BRICK_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("BRICK_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("STONE_BRICKS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("STONE_BRICK_SLAB", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("STONE_BRICK_STAIRS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("BLACKSTONE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("NETHER_BRICKS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("GILDED_BLACKSTONE", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("GILDED_NETHER_BRICKS", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("INDUSTRIAL", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("INDUSTRIAL_FLAT", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("LABORATORY", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("WARNING_STRIPES", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("CHAIN", Collections.singletonList(this::tagMineableWithPickaxe));
        tagMappings.put("LANTERN", Collections.singletonList(this::tagMineableWithPickaxe));

        return tagMappings;
    }

    private void tagMineableWithAxe(RegistryObject<Item> itemRegistryObject) {
        BlockItem blockItem = (BlockItem) itemRegistryObject.get();
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(blockItem.getBlock());
    }

    private void tagMineableWithPickaxe(RegistryObject<Item> itemRegistryObject) {
        BlockItem blockItem = (BlockItem) itemRegistryObject.get();
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockItem.getBlock());
    }

    private void tagMineableWithHoe(RegistryObject<Item> itemRegistryObject) {
        BlockItem blockItem = (BlockItem) itemRegistryObject.get();
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(blockItem.getBlock());
    }

    private void tagPlanks(RegistryObject<Item> itemRegistryObject) {
        BlockItem blockItem = (BlockItem) itemRegistryObject.get();
        this.tag(BlockTags.PLANKS).add(blockItem.getBlock());
    }

    private void tagWoodenStairs(RegistryObject<Item> itemRegistryObject) {
        BlockItem blockItem = (BlockItem) itemRegistryObject.get();
        this.tag(BlockTags.WOODEN_STAIRS).add(blockItem.getBlock());
    }

    private void tagWoodenSlabs(RegistryObject<Item> itemRegistryObject) {
        BlockItem blockItem = (BlockItem) itemRegistryObject.get();
        this.tag(BlockTags.WOODEN_SLABS).add(blockItem.getBlock());
    }
}
