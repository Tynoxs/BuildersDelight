package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.block.custom.*;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class BdDecoration {
    public static final DeferredRegister<Block> DECORATION = DeferredRegister.create(ForgeRegistries.BLOCKS, BuildersDelight.MODID);

    public static final RegistryObject<Block> LANTERN_1 = registerBlock("lantern_1", () -> new BlockPaperLamp(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_2 = registerBlock("lantern_2", () -> new BlockLantern(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 10).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_3 = registerBlock("lantern_3", () -> new BlockLantern(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_4 = registerBlock("lantern_4", () -> new BlockLantern(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_5 = registerBlock("lantern_5", () -> new BlockBrazier(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 15).noOcclusion()), "");
    public static final RegistryObject<Block> LANTERN_6 = registerBlock("lantern_6", () -> new BlockCandle(BlockBehaviour.Properties.of(Material.DECORATION).strength(3.5F).noOcclusion().lightLevel((p_50886_) -> 10).sound(SoundType.LANTERN), ParticleTypes.FLAME), "");
    public static final RegistryObject<Block> CHAIN_1 = registerBlock("chain_1", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
    public static final RegistryObject<Block> CHAIN_2 = registerBlock("chain_2", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)), "");
    public static final RegistryObject<Block> CHAIN_3 = registerBlock("chain_3", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), "");
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
    public static final RegistryObject<Block> CRIMSON_CHAIR_1 = registerBlock("crimson_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_CHAIR_2 = registerBlock("crimson_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_TABLE_1 = registerBlock("crimson_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> CRIMSON_TABLE_2 = registerBlock("crimson_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_CHAIR_1 = registerBlock("dark_oak_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_CHAIR_2 = registerBlock("dark_oak_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_TABLE_1 = registerBlock("dark_oak_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> DARK_OAK_TABLE_2 = registerBlock("dark_oak_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_CHAIR_1 = registerBlock("jungle_chair_1", () -> new BlockChair(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_CHAIR_2 = registerBlock("jungle_chair_2", () -> new BlockStool(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_TABLE_1 = registerBlock("jungle_table_1", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
    public static final RegistryObject<Block> JUNGLE_TABLE_2 = registerBlock("jungle_table_2", () -> new BlockSmallTable(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), "");
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

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = DECORATION.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        BdItems.ITEMS.register(name, () ->
                new BlockItem(block.get(),
                        new Item.Properties().tab(BdTabs.TabDecoration))
                {
                    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag)
                    {
                        pTooltip.add(Component.translatable("tooltip.block." + name).withStyle(ChatFormatting.GRAY));
                    }
                });
    }

    public static void register(IEventBus eventBus) {
        DECORATION.register(eventBus);
    }
}

