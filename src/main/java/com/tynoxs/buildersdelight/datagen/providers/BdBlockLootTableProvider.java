package com.tynoxs.buildersdelight.datagen.providers;

import com.google.common.collect.ImmutableList;
import com.tynoxs.buildersdelight.datagen.loot.BdBlockLootTables;
import com.tynoxs.buildersdelight.datagen.loot.BdDecorationLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BdBlockLootTableProvider extends LootTableProvider {
    private final List<SubProviderEntry> block_loot_tables = ImmutableList.of(new LootTableProvider.SubProviderEntry(BdBlockLootTables::new, LootContextParamSets.BLOCK));
    private final List<SubProviderEntry> decoration_loot_tables = ImmutableList.of(new LootTableProvider.SubProviderEntry(BdDecorationLootTables::new, LootContextParamSets.BLOCK));

    public BdBlockLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of());
    }

    @Override
    public List<SubProviderEntry> getTables() {
        List<SubProviderEntry> allLootTables = new ArrayList<>();
        allLootTables.addAll(block_loot_tables);
        allLootTables.addAll(decoration_loot_tables);
        return allLootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> p_218436_3_.validate(validationtracker));
    }



}
