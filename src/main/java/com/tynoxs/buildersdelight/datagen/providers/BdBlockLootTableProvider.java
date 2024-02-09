package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.datagen.loot.BdBlockLootTables;
import com.tynoxs.buildersdelight.datagen.loot.BdDecorationLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class BdBlockLootTableProvider {
    public static LootTableProvider create(PackOutput packOutput) {
        return new LootTableProvider(packOutput, Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(BdBlockLootTables::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(BdDecorationLootTables::new, LootContextParamSets.BLOCK)));
    }
}