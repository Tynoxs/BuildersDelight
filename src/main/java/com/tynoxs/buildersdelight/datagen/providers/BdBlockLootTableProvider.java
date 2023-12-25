package com.tynoxs.buildersdelight.datagen.providers;

import com.google.common.collect.ImmutableList;
import com.tynoxs.buildersdelight.datagen.loot.BdBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BdBlockLootTableProvider extends LootTableProvider {
    private final List<SubProviderEntry>
            block_loot_tables = ImmutableList.of(new LootTableProvider.SubProviderEntry(BdBlockLootTables::new, LootContextParamSets.BLOCK));

    public BdBlockLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of());
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return block_loot_tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> p_218436_3_.validate(validationtracker));
    }

}
