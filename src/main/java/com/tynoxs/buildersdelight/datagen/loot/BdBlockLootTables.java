package com.tynoxs.buildersdelight.datagen.loot;

import com.tynoxs.buildersdelight.content.init.BdBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class BdBlockLootTables extends BlockLootSubProvider {

    public BdBlockLootTables(HolderLookup.Provider registries) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        for (DeferredHolder<Block, ? extends Block> blockObj : BdBlocks.BLOCKS.getEntries()) {
            Block block = blockObj.get();
            String path = blockObj.getId().getPath().toLowerCase();

            if (path.contains("glass") || path.contains("pane")) {
                registerDropWhenSilkTouch(block);
            }
            else if (block instanceof SlabBlock) {
                registerSlabItemTable(block);
            }
            else {
                registerDropSelf(block);
            }
        }
    }

    public void registerDropSelf(Block block) {
        dropSelf(block);
    }

    public void registerDropWhenSilkTouch(Block block) {
        this.add(block, this.createSilkTouchOnlyTable(block));
    }

    protected void registerSlabItemTable(Block block) {
        this.add(block, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(applyExplosionDecay(block, LootItem.lootTableItem(block).apply(
                                SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
                        )))
        ));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BdBlocks.BLOCKS.getEntries()
                .stream()
                .map(holder -> (Block) holder.get())
                ::iterator;
    }
}