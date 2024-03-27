package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;

import com.tynoxs.buildersdelight.content.block.custom.*;
import com.tynoxs.buildersdelight.content.block.custom.BlockChair;
import com.tynoxs.buildersdelight.content.block.custom.BlockSmallTable;
import com.tynoxs.buildersdelight.content.block.custom.BlockStool;
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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BdDecoration {
    public static final DeferredRegister<Block> DECORATION = DeferredRegister.create(ForgeRegistries.BLOCKS, BuildersDelight.MODID);

    private static final Map<String, RegistryObject<Item>> decorationItemMap = new LinkedHashMap<>();

    public static final RegistryObject<Block> LANTERN_1 = registerBlock("lantern_1", () -> new BlockPaperLamp(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_2 = registerBlock("lantern_2", () -> new BlockLantern(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 10).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_3 = registerBlock("lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> EXPOSED_LANTERN_3 = registerBlock("exposed_lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> WEATHERED_LANTERN_3 = registerBlock("weathered_lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> OXIDIZED_LANTERN_3 = registerBlock("oxidized_lantern_3", () -> new BlockWeatheringLantern(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> WAXED_LANTERN_3 = registerBlock("waxed_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> WAXED_EXPOSED_LANTERN_3 = registerBlock("waxed_exposed_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> WAXED_WEATHERED_LANTERN_3 = registerBlock("waxed_weathered_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> WAXED_OXIDIZED_LANTERN_3 = registerBlock("waxed_oxidized_lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER).mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_4 = registerBlock("lantern_4", () -> new BlockLantern(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_5 = registerBlock("lantern_5", () -> new BlockBrazier(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_6 = registerBlock("lantern_6", () -> new BlockCandle(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(3.5F).noOcclusion().lightLevel((state) -> state.getValue(BlockTikiTorch.LIT) ? 10 : 0).sound(SoundType.LANTERN), ParticleTypes.FLAME), "");
    public static final RegistryObject<Block> LANTERN_7 = registerBlock("lantern_7", () -> new BlockLantern(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_8 = registerBlock("lantern_8", () -> new BlockTikiTorch(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.8F).noOcclusion().lightLevel((state) -> state.getValue(BlockTikiTorch.LIT) ? 10 : 0).sound(SoundType.WOOD), ParticleTypes.FLAME), "");
    public static final RegistryObject<Block> CHAIN_1 = registerBlock("chain_1", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> CHAIN_2 = registerBlock("chain_2", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)), "");
    public static final RegistryObject<Block> CHAIN_3 = registerBlock("chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> EXPOSED_CHAIN_3 = registerBlock("exposed_chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> WEATHERED_CHAIN_3 = registerBlock("weathered_chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> OXIDIZED_CHAIN_3 = registerBlock("oxidized_chain_3", () -> new BlockWeatheringChain(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> WAXED_CHAIN_3 = registerBlock("waxed_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> WAXED_EXPOSED_CHAIN_3 = registerBlock("waxed_exposed_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> WAXED_WEATHERED_CHAIN_3 = registerBlock("waxed_weathered_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> WAXED_OXIDIZED_CHAIN_3 = registerBlock("waxed_oxidized_chain_3", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> CHAIN_4 = registerBlock("chain_4", () -> new BlockLargeChain(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> CHAIN_5 = registerBlock("chain_5", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> ACACIA_CHAIR_1 = registerBlock("acacia_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)), "");
    public static final RegistryObject<Block> ACACIA_CHAIR_2 = registerBlock("acacia_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)), "");
    public static final RegistryObject<Block> ACACIA_TABLE_1 = registerBlock("acacia_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)), "");
    public static final RegistryObject<Block> ACACIA_TABLE_2 = registerBlock("acacia_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)), "");
    public static final RegistryObject<Block> BIRCH_CHAIR_1 = registerBlock("birch_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)), "");
    public static final RegistryObject<Block> BIRCH_CHAIR_2 = registerBlock("birch_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)), "");
    public static final RegistryObject<Block> BIRCH_TABLE_1 = registerBlock("birch_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)), "");
    public static final RegistryObject<Block> BIRCH_TABLE_2 = registerBlock("birch_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)), "");
    public static final RegistryObject<Block> BAMBOO_CHAIR_1 = registerBlock("bamboo_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)), "");
    public static final RegistryObject<Block> BAMBOO_CHAIR_2 = registerBlock("bamboo_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)), "");
    public static final RegistryObject<Block> BAMBOO_TABLE_1 = registerBlock("bamboo_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)), "");
    public static final RegistryObject<Block> BAMBOO_TABLE_2 = registerBlock("bamboo_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_CHAIR_1 = registerBlock("crimson_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_CHAIR_2 = registerBlock("crimson_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_TABLE_1 = registerBlock("crimson_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_TABLE_2 = registerBlock("crimson_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CHERRY_CHAIR_1 = registerBlock("cherry_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)), "");
    public static final RegistryObject<Block> CHERRY_CHAIR_2 = registerBlock("cherry_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)), "");
    public static final RegistryObject<Block> CHERRY_TABLE_1 = registerBlock("cherry_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)), "");
    public static final RegistryObject<Block> CHERRY_TABLE_2 = registerBlock("cherry_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_CHAIR_1 = registerBlock("dark_oak_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_CHAIR_2 = registerBlock("dark_oak_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_TABLE_1 = registerBlock("dark_oak_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_TABLE_2 = registerBlock("dark_oak_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_CHAIR_1 = registerBlock("jungle_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_CHAIR_2 = registerBlock("jungle_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_TABLE_1 = registerBlock("jungle_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_TABLE_2 = registerBlock("jungle_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> MANGROVE_CHAIR_1 = registerBlock("mangrove_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)), "");
    public static final RegistryObject<Block> MANGROVE_CHAIR_2 = registerBlock("mangrove_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)), "");
    public static final RegistryObject<Block> MANGROVE_TABLE_1 = registerBlock("mangrove_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)), "");
    public static final RegistryObject<Block> MANGROVE_TABLE_2 = registerBlock("mangrove_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)), "");
    public static final RegistryObject<Block> OAK_CHAIR_1 = registerBlock("oak_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), "");
    public static final RegistryObject<Block> OAK_CHAIR_2 = registerBlock("oak_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), "");
    public static final RegistryObject<Block> OAK_TABLE_1 = registerBlock("oak_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), "");
    public static final RegistryObject<Block> OAK_TABLE_2 = registerBlock("oak_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), "");
    public static final RegistryObject<Block> SPRUCE_CHAIR_1 = registerBlock("spruce_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)), "");
    public static final RegistryObject<Block> SPRUCE_CHAIR_2 = registerBlock("spruce_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)), "");
    public static final RegistryObject<Block> SPRUCE_TABLE_1 = registerBlock("spruce_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)), "");
    public static final RegistryObject<Block> SPRUCE_TABLE_2 = registerBlock("spruce_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)), "");
    public static final RegistryObject<Block> WARPED_CHAIR_1 = registerBlock("warped_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), "");
    public static final RegistryObject<Block> WARPED_CHAIR_2 = registerBlock("warped_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), "");
    public static final RegistryObject<Block> WARPED_TABLE_1 = registerBlock("warped_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), "");
    public static final RegistryObject<Block> WARPED_TABLE_2 = registerBlock("warped_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), "");

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = DECORATION.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        RegistryObject<Item> item = BdItems.ITEMS.register(name, () ->
                new BlockItem(block.get(),
                        new Item.Properties())
                {
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag)
                    {
                        pTooltip.add(Component.translatable("tooltip.block." + name).withStyle(ChatFormatting.GRAY));
                    }
                });
        decorationItemMap.put(name, item);
    }

    public static void register(IEventBus eventBus) {
        DECORATION.register(eventBus);
    }

    public static Map<String, RegistryObject<Item>> getDecorationItemMap() {
        return decorationItemMap;
    }
}
