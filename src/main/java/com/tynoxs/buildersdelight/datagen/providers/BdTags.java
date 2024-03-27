package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class BdTags {
    public static class Items {

        static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(BuildersDelight.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> ACACIA_PLANKS = tag("acacia_planks");
        public static final TagKey<Block> BAMBOO_PLANKS = tag("bamboo_planks");
        public static final TagKey<Block> BIRCH_PLANKS = tag("birch_planks");
        public static final TagKey<Block> CHERRY_PLANKS = tag("cherry_planks");
        public static final TagKey<Block> CRIMSON_PLANKS = tag("crimson_planks");
        public static final TagKey<Block> DARK_OAK_PLANKS = tag("dark_oak_planks");
        public static final TagKey<Block> JUNGLE_PLANKS = tag("jungle_planks");
        public static final TagKey<Block> MANGROVE_PLANKS = tag("mangrove_planks");
        public static final TagKey<Block> OAK_PLANKS = tag("oak_planks");
        public static final TagKey<Block> SPRUCE_PLANKS = tag("spruce_planks");
        public static final TagKey<Block> WARPED_PLANKS = tag("warped_planks");

        public static final TagKey<Block> GLASS = tag("glass");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(BuildersDelight.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
