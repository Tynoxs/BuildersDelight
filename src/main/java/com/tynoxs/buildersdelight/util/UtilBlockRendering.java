package com.tynoxs.buildersdelight.util;

import com.tynoxs.buildersdelight.content.init.BdBlocks;
import com.tynoxs.buildersdelight.content.init.BdDecoration;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UtilBlockRendering {

    @OnlyIn(Dist.CLIENT)
    public static void register() {
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.ACACIA_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.BIRCH_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.BAMBOO_TABLE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.BAMBOO_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.CHERRY_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.CRIMSON_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.DARK_OAK_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.JUNGLE_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.MANGROVE_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.OAK_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.SPRUCE_TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.WARPED_TABLE_2.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BdDecoration.LANTERN_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.LANTERN_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.LANTERN_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.LANTERN_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.LANTERN_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.LANTERN_6.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BdDecoration.CHAIN_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.CHAIN_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.CHAIN_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdDecoration.CHAIN_4.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.ACACIA_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BIRCH_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.BAMBOO_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CHERRY_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.CRIMSON_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.DARK_OAK_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_1.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_2.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_1.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_2.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.GLASS_PANE_7.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.INDUSTRIAL_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.INDUSTRIAL_FLAT_6.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.JUNGLE_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.MANGROVE_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.OAK_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.SPRUCE_GLASS_PANE_8.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_8.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_5.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_6.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BdBlocks.WARPED_GLASS_PANE_8.get(), RenderType.translucent());
    }

}