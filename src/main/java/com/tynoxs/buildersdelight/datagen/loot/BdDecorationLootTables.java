package com.tynoxs.buildersdelight.datagen.loot;

import com.tynoxs.buildersdelight.content.init.BdDecoration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BdDecorationLootTables extends BlockLoot {

    @Override
    protected void addTables() {
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

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BdDecoration.DECORATION.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
