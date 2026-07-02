package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.datagen.loot.BdBlockLootTables;
import com.tynoxs.buildersdelight.datagen.loot.BdDecorationLootTables;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BdBlockLootTableProvider {
    public static LootTableProvider create(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        return new LootTableProvider(packOutput, Set.of(),
                List.of(
                        new SubProviderEntry(BdBlockLootTables::new, LootContextParamSets.BLOCK),
                        new SubProviderEntry(BdDecorationLootTables::new, LootContextParamSets.BLOCK))
                    , lookupProvider);
    }
}