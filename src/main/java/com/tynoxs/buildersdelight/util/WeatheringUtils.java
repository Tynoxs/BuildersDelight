package com.tynoxs.buildersdelight.util;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.BiMap;
import com.tynoxs.buildersdelight.content.init.BdDecoration;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class WeatheringUtils {

    public static Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK;
    public static Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK;
    public static Supplier<BiMap<Block, Block>> WAX_ON_BY_BLOCK;
    public static Supplier<BiMap<Block, Block>> WAX_OFF_BY_BLOCK;

    public static void buildBlockMap() {
        if (NEXT_BY_BLOCK == null) {
            NEXT_BY_BLOCK = Suppliers.memoize(() ->
                    ImmutableBiMap.<Block, Block>builder().put(
                                    BdDecoration.LANTERN_3.get(),
                                    BdDecoration.EXPOSED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.EXPOSED_LANTERN_3.get(),
                                    BdDecoration.WEATHERED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.WEATHERED_LANTERN_3.get(),
                                    BdDecoration.OXIDIZED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.CHAIN_3.get(),
                                    BdDecoration.EXPOSED_CHAIN_3.get()
                            ).put(
                                    BdDecoration.EXPOSED_CHAIN_3.get(),
                                    BdDecoration.WEATHERED_CHAIN_3.get()
                            ).put(
                                    BdDecoration.WEATHERED_CHAIN_3.get(),
                                    BdDecoration.OXIDIZED_CHAIN_3.get()
                            )
                            .build()
            );
            PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> NEXT_BY_BLOCK.get().inverse());
        }
    }

    public static void buildWaxBlockMap() {
        if (WAX_ON_BY_BLOCK == null) {
            WAX_ON_BY_BLOCK = Suppliers.memoize(() ->
                    ImmutableBiMap.<Block, Block>builder().put(
                                    BdDecoration.LANTERN_3.get(),
                                    BdDecoration.WAXED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.EXPOSED_LANTERN_3.get(),
                                    BdDecoration.WAXED_EXPOSED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.WEATHERED_LANTERN_3.get(),
                                    BdDecoration.WAXED_WEATHERED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.OXIDIZED_LANTERN_3.get(),
                                    BdDecoration.WAXED_OXIDIZED_LANTERN_3.get()
                            ).put(
                                    BdDecoration.CHAIN_3.get(),
                                    BdDecoration.WAXED_CHAIN_3.get()
                            ).put(
                                    BdDecoration.EXPOSED_CHAIN_3.get(),
                                    BdDecoration.WAXED_EXPOSED_CHAIN_3.get()
                            ).put(
                                    BdDecoration.WEATHERED_CHAIN_3.get(),
                                    BdDecoration.WAXED_WEATHERED_CHAIN_3.get()
                            ).put(
                                    BdDecoration.OXIDIZED_CHAIN_3.get(),
                                    BdDecoration.WAXED_OXIDIZED_CHAIN_3.get()
                            )
                            .build()
            );
            WAX_OFF_BY_BLOCK = Suppliers.memoize(() -> WAX_ON_BY_BLOCK.get().inverse());
        }
    }
}
