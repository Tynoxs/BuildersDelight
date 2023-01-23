package com.tynoxs.buildersdelight.datagen.loot;

import com.tynoxs.buildersdelight.content.init.BdDecoration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BdDecorationLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(BdDecoration.ACACIA_CHAIR_1.get());
        this.dropSelf(BdDecoration.ACACIA_CHAIR_2.get());
        this.dropSelf(BdDecoration.ACACIA_TABLE_1.get());
        this.dropSelf(BdDecoration.ACACIA_TABLE_2.get());

        this.dropSelf(BdDecoration.BIRCH_CHAIR_1.get());
        this.dropSelf(BdDecoration.BIRCH_CHAIR_2.get());
        this.dropSelf(BdDecoration.BIRCH_TABLE_1.get());
        this.dropSelf(BdDecoration.BIRCH_TABLE_2.get());

        this.dropSelf(BdDecoration.CRIMSON_CHAIR_1.get());
        this.dropSelf(BdDecoration.CRIMSON_CHAIR_2.get());
        this.dropSelf(BdDecoration.CRIMSON_TABLE_1.get());
        this.dropSelf(BdDecoration.CRIMSON_TABLE_2.get());

        this.dropSelf(BdDecoration.DARK_OAK_CHAIR_1.get());
        this.dropSelf(BdDecoration.DARK_OAK_CHAIR_2.get());
        this.dropSelf(BdDecoration.DARK_OAK_TABLE_1.get());
        this.dropSelf(BdDecoration.DARK_OAK_TABLE_2.get());

        this.dropSelf(BdDecoration.JUNGLE_CHAIR_1.get());
        this.dropSelf(BdDecoration.JUNGLE_CHAIR_2.get());
        this.dropSelf(BdDecoration.JUNGLE_TABLE_1.get());
        this.dropSelf(BdDecoration.JUNGLE_TABLE_2.get());

        this.dropSelf(BdDecoration.OAK_CHAIR_1.get());
        this.dropSelf(BdDecoration.OAK_CHAIR_2.get());
        this.dropSelf(BdDecoration.OAK_TABLE_1.get());
        this.dropSelf(BdDecoration.OAK_TABLE_2.get());

        this.dropSelf(BdDecoration.SPRUCE_CHAIR_1.get());
        this.dropSelf(BdDecoration.SPRUCE_CHAIR_2.get());
        this.dropSelf(BdDecoration.SPRUCE_TABLE_1.get());
        this.dropSelf(BdDecoration.SPRUCE_TABLE_2.get());

        this.dropSelf(BdDecoration.WARPED_CHAIR_1.get());
        this.dropSelf(BdDecoration.WARPED_CHAIR_2.get());
        this.dropSelf(BdDecoration.WARPED_TABLE_1.get());
        this.dropSelf(BdDecoration.WARPED_TABLE_2.get());

        this.dropSelf(BdDecoration.CHAIN_1.get());
        this.dropSelf(BdDecoration.CHAIN_2.get());
        this.dropSelf(BdDecoration.CHAIN_3.get());
        this.dropSelf(BdDecoration.CHAIN_4.get());
        this.dropSelf(BdDecoration.CHAIN_5.get());

        this.dropSelf(BdDecoration.LANTERN_1.get());
        this.dropSelf(BdDecoration.LANTERN_2.get());
        this.dropSelf(BdDecoration.LANTERN_3.get());
        this.dropSelf(BdDecoration.LANTERN_4.get());
        this.dropSelf(BdDecoration.LANTERN_5.get());
        this.dropSelf(BdDecoration.LANTERN_6.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BdDecoration.DECORATION.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
