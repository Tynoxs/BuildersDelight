package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;

import com.tynoxs.buildersdelight.content.block.custom.*;
import com.tynoxs.buildersdelight.content.block.custom.lantern.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BdDecoration {
    public static final DeferredRegister.Blocks DECORATION = DeferredRegister.createBlocks(BuildersDelight.MODID);

    private static final Map<String, Supplier<Item>> decorationItemMap = new LinkedHashMap<>();

    public static final DeferredBlock<Block> LANTERN_1 = registerBlock("lantern_1", () -> new BlockPaperLamp(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> LANTERN_2 = registerBlock("lantern_2", () -> new BlockLantern(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 10).noOcclusion()), null);
    public static final DeferredBlock<Block> LANTERN_3 = registerBlock("lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> EXPOSED_LANTERN_3 = registerBlock("exposed_lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> WEATHERED_LANTERN_3 = registerBlock("weathered_lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> OXIDIZED_LANTERN_3 = registerBlock("oxidized_lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> WAXED_LANTERN_3 = registerBlock("waxed_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> WAXED_EXPOSED_LANTERN_3 = registerBlock("waxed_exposed_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> WAXED_WEATHERED_LANTERN_3 = registerBlock("waxed_weathered_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> WAXED_OXIDIZED_LANTERN_3 = registerBlock("waxed_oxidized_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> LANTERN_4 = registerBlock("lantern_4", () -> new BlockLantern(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> LANTERN_5 = registerBlock("lantern_5", () -> new BlockBrazier(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> LANTERN_6 = registerBlock("lantern_6", () -> new BlockCandle(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(3.5F).noOcclusion().lightLevel((state) -> state.getValue(BlockTikiTorch.LIT) ? 10 : 0).sound(SoundType.LANTERN), ParticleTypes.FLAME), null);
    public static final DeferredBlock<Block> LANTERN_7 = registerBlock("lantern_7", () -> new BlockLantern(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), null);
    public static final DeferredBlock<Block> LANTERN_8 = registerBlock("lantern_8", () -> new BlockTikiTorch(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.8F).noOcclusion().lightLevel((state) -> state.getValue(BlockTikiTorch.LIT) ? 10 : 0).sound(SoundType.WOOD), ParticleTypes.FLAME), null);
    public static final DeferredBlock<Block> CHAIN_1 = registerBlock("chain_1", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> CHAIN_2 = registerBlock("chain_2", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)), null);
    public static final DeferredBlock<Block> CHAIN_3 = registerBlock("chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> EXPOSED_CHAIN_3 = registerBlock("exposed_chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> WEATHERED_CHAIN_3 = registerBlock("weathered_chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> OXIDIZED_CHAIN_3 = registerBlock("oxidized_chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> WAXED_CHAIN_3 = registerBlock("waxed_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> WAXED_EXPOSED_CHAIN_3 = registerBlock("waxed_exposed_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> WAXED_WEATHERED_CHAIN_3 = registerBlock("waxed_weathered_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> WAXED_OXIDIZED_CHAIN_3 = registerBlock("waxed_oxidized_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> CHAIN_4 = registerBlock("chain_4", () -> new BlockLargeChain(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> CHAIN_5 = registerBlock("chain_5", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)), null);
    public static final DeferredBlock<Block> ACACIA_CHAIR_1 = registerBlock("acacia_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)), null);
    public static final DeferredBlock<Block> ACACIA_CHAIR_2 = registerBlock("acacia_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)), null);
    public static final DeferredBlock<Block> ACACIA_TABLE_1 = registerBlock("acacia_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)), null);
    public static final DeferredBlock<Block> ACACIA_TABLE_2 = registerBlock("acacia_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)), null);
    public static final DeferredBlock<Block> BIRCH_CHAIR_1 = registerBlock("birch_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)), null);
    public static final DeferredBlock<Block> BIRCH_CHAIR_2 = registerBlock("birch_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)), null);
    public static final DeferredBlock<Block> BIRCH_TABLE_1 = registerBlock("birch_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)), null);
    public static final DeferredBlock<Block> BIRCH_TABLE_2 = registerBlock("birch_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)), null);
    public static final DeferredBlock<Block> BAMBOO_CHAIR_1 = registerBlock("bamboo_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)), null);
    public static final DeferredBlock<Block> BAMBOO_CHAIR_2 = registerBlock("bamboo_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)), null);
    public static final DeferredBlock<Block> BAMBOO_TABLE_1 = registerBlock("bamboo_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)), null);
    public static final DeferredBlock<Block> BAMBOO_TABLE_2 = registerBlock("bamboo_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)), null);
    public static final DeferredBlock<Block> CRIMSON_CHAIR_1 = registerBlock("crimson_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)), null);
    public static final DeferredBlock<Block> CRIMSON_CHAIR_2 = registerBlock("crimson_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)), null);
    public static final DeferredBlock<Block> CRIMSON_TABLE_1 = registerBlock("crimson_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)), null);
    public static final DeferredBlock<Block> CRIMSON_TABLE_2 = registerBlock("crimson_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)), null);
    public static final DeferredBlock<Block> CHERRY_CHAIR_1 = registerBlock("cherry_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)), null);
    public static final DeferredBlock<Block> CHERRY_CHAIR_2 = registerBlock("cherry_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)), null);
    public static final DeferredBlock<Block> CHERRY_TABLE_1 = registerBlock("cherry_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)), null);
    public static final DeferredBlock<Block> CHERRY_TABLE_2 = registerBlock("cherry_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)), null);
    public static final DeferredBlock<Block> DARK_OAK_CHAIR_1 = registerBlock("dark_oak_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)), null);
    public static final DeferredBlock<Block> DARK_OAK_CHAIR_2 = registerBlock("dark_oak_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)), null);
    public static final DeferredBlock<Block> DARK_OAK_TABLE_1 = registerBlock("dark_oak_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)), null);
    public static final DeferredBlock<Block> DARK_OAK_TABLE_2 = registerBlock("dark_oak_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)), null);
    public static final DeferredBlock<Block> JUNGLE_CHAIR_1 = registerBlock("jungle_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)), null);
    public static final DeferredBlock<Block> JUNGLE_CHAIR_2 = registerBlock("jungle_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)), null);
    public static final DeferredBlock<Block> JUNGLE_TABLE_1 = registerBlock("jungle_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)), null);
    public static final DeferredBlock<Block> JUNGLE_TABLE_2 = registerBlock("jungle_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)), null);
    public static final DeferredBlock<Block> MANGROVE_CHAIR_1 = registerBlock("mangrove_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)), null);
    public static final DeferredBlock<Block> MANGROVE_CHAIR_2 = registerBlock("mangrove_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)), null);
    public static final DeferredBlock<Block> MANGROVE_TABLE_1 = registerBlock("mangrove_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)), null);
    public static final DeferredBlock<Block> MANGROVE_TABLE_2 = registerBlock("mangrove_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)), null);
    public static final DeferredBlock<Block> OAK_CHAIR_1 = registerBlock("oak_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)), null);
    public static final DeferredBlock<Block> OAK_CHAIR_2 = registerBlock("oak_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)), null);
    public static final DeferredBlock<Block> OAK_TABLE_1 = registerBlock("oak_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)), null);
    public static final DeferredBlock<Block> OAK_TABLE_2 = registerBlock("oak_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)), null);
    public static final DeferredBlock<Block> SPRUCE_CHAIR_1 = registerBlock("spruce_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)), null);
    public static final DeferredBlock<Block> SPRUCE_CHAIR_2 = registerBlock("spruce_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)), null);
    public static final DeferredBlock<Block> SPRUCE_TABLE_1 = registerBlock("spruce_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)), null);
    public static final DeferredBlock<Block> SPRUCE_TABLE_2 = registerBlock("spruce_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)), null);
    public static final DeferredBlock<Block> WARPED_CHAIR_1 = registerBlock("warped_chair_1", () -> new BlockChair(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)), null);
    public static final DeferredBlock<Block> WARPED_CHAIR_2 = registerBlock("warped_chair_2", () -> new BlockStool(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)), null);
    public static final DeferredBlock<Block> WARPED_TABLE_1 = registerBlock("warped_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)), null);
    public static final DeferredBlock<Block> WARPED_TABLE_2 = registerBlock("warped_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)), null);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        DeferredBlock<T> toReturn = DECORATION.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, String tooltipKey) {
        Supplier<Item> item = BdItems.ITEMS.register(name, () ->
                new BlockItem(block.get(),
                        new Item.Properties())
                {
                    @Override
                    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag)
                    {
                        tooltip.add(Component.translatable("tooltip.block." + name).withStyle(ChatFormatting.GRAY));
                    }
                });
        decorationItemMap.put(name, item);
    }

    public static void register(IEventBus eventBus) {
        DECORATION.register(eventBus);
    }

    public static Map<String, Supplier<Item>> getDecorationItemMap() {
        return decorationItemMap;
    }
}
