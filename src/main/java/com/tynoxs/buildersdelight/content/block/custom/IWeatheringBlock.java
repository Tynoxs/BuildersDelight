package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface IWeatheringBlock extends WeatheringCopper
{
    static Optional<BlockState> getWaxed(BlockState state) {
        WeatheringUtils.buildWaxBlockMap();
        return Optional.ofNullable(WeatheringUtils.WAX_ON_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<BlockState> getUnwaxed(BlockState state) {
        WeatheringUtils.buildWaxBlockMap();
        return Optional.ofNullable(WeatheringUtils.WAX_OFF_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    @Override
    default @NotNull Optional<BlockState> getNext(BlockState state) {
        return getNext(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<Block> getNext(Block block) {
        WeatheringUtils.buildBlockMap();
        return Optional.ofNullable(WeatheringUtils.NEXT_BY_BLOCK.get().get(block));
    }

    static Optional<Block> getPrevious(Block block) {
        WeatheringUtils.buildBlockMap();
        return Optional.ofNullable(WeatheringUtils.PREVIOUS_BY_BLOCK.get().get(block));
    }

    static Optional<BlockState> getPrevious(BlockState state) {
        return getPrevious(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    default ItemInteractionResult applyWax(ItemStack itemstack, BlockState state, Level level,
            BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (itemstack.getItem() instanceof HoneycombItem) {
            return IWeatheringBlock.getWaxed(state).map((waxedBlockState) -> {
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, itemstack);
                }
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                level.setBlock(pos, waxedBlockState, Block.UPDATE_ALL_IMMEDIATE);
                level.levelEvent(player, 3003, pos, 0);

                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }).orElse(ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION);
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
