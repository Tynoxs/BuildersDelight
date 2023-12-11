package com.tynoxs.buildersdelight.datagen.loot;

import com.tynoxs.buildersdelight.content.init.BdDecoration;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class BdDecorationLootTables extends BlockLootSubProvider {
    public List<Block> list = new ArrayList<>();

    public BdDecorationLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), new HashMap<>());
    }

    @Override
    protected void generate() {
        registerDropSelf(BdDecoration.ACACIA_CHAIR_1.get());
        registerDropSelf(BdDecoration.ACACIA_CHAIR_2.get());
        registerDropSelf(BdDecoration.ACACIA_TABLE_1.get());
        registerDropSelf(BdDecoration.ACACIA_TABLE_2.get());

        registerDropSelf(BdDecoration.BIRCH_CHAIR_1.get());
        registerDropSelf(BdDecoration.BIRCH_CHAIR_2.get());
        registerDropSelf(BdDecoration.BIRCH_TABLE_1.get());
        registerDropSelf(BdDecoration.BIRCH_TABLE_2.get());

        registerDropSelf(BdDecoration.CRIMSON_CHAIR_1.get());
        registerDropSelf(BdDecoration.CRIMSON_CHAIR_2.get());
        registerDropSelf(BdDecoration.CRIMSON_TABLE_1.get());
        registerDropSelf(BdDecoration.CRIMSON_TABLE_2.get());

        registerDropSelf(BdDecoration.DARK_OAK_CHAIR_1.get());
        registerDropSelf(BdDecoration.DARK_OAK_CHAIR_2.get());
        registerDropSelf(BdDecoration.DARK_OAK_TABLE_1.get());
        registerDropSelf(BdDecoration.DARK_OAK_TABLE_2.get());

        registerDropSelf(BdDecoration.JUNGLE_CHAIR_1.get());
        registerDropSelf(BdDecoration.JUNGLE_CHAIR_2.get());
        registerDropSelf(BdDecoration.JUNGLE_TABLE_1.get());
        registerDropSelf(BdDecoration.JUNGLE_TABLE_2.get());

        registerDropSelf(BdDecoration.OAK_CHAIR_1.get());
        registerDropSelf(BdDecoration.OAK_CHAIR_2.get());
        registerDropSelf(BdDecoration.OAK_TABLE_1.get());
        registerDropSelf(BdDecoration.OAK_TABLE_2.get());

        registerDropSelf(BdDecoration.SPRUCE_CHAIR_1.get());
        registerDropSelf(BdDecoration.SPRUCE_CHAIR_2.get());
        registerDropSelf(BdDecoration.SPRUCE_TABLE_1.get());
        registerDropSelf(BdDecoration.SPRUCE_TABLE_2.get());

        registerDropSelf(BdDecoration.WARPED_CHAIR_1.get());
        registerDropSelf(BdDecoration.WARPED_CHAIR_2.get());
        registerDropSelf(BdDecoration.WARPED_TABLE_1.get());
        registerDropSelf(BdDecoration.WARPED_TABLE_2.get());

        registerDropSelf(BdDecoration.CHAIN_1.get());
        registerDropSelf(BdDecoration.CHAIN_2.get());
        registerDropSelf(BdDecoration.CHAIN_3.get());
        registerDropSelf(BdDecoration.CHAIN_4.get());
        registerDropSelf(BdDecoration.CHAIN_5.get());

        registerDropSelf(BdDecoration.LANTERN_1.get());
        registerDropSelf(BdDecoration.LANTERN_2.get());
        registerDropSelf(BdDecoration.LANTERN_3.get());
        registerDropSelf(BdDecoration.LANTERN_4.get());
        registerDropSelf(BdDecoration.LANTERN_5.get());
        registerDropSelf(BdDecoration.LANTERN_6.get());
    }

    public void registerDropSelf(Block block) {
        list.add(block);
        dropSelf(block);
    }

    // Override and ignore the missing loot table error
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> p_249322_) {
        this.generate();
        Set<ResourceLocation> set = new HashSet<>();

        for (Block block : list) {
            if (block.isEnabled(this.enabledFeatures)) {
                ResourceLocation resourcelocation = block.getLootTable();
                if (resourcelocation != BuiltInLootTables.EMPTY && set.add(resourcelocation)) {
                    LootTable.Builder loottable$builder = this.map.remove(resourcelocation);
                    if (loottable$builder == null) {
                        continue;
                    }

                    p_249322_.accept(resourcelocation, loottable$builder);
                }
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BdDecoration.DECORATION.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
