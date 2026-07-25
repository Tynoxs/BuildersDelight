package com.tynoxs.buildersdelight.content.block.custom.lantern;

import com.tynoxs.buildersdelight.content.block.custom.IWeatheringBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockWeatheringLantern extends BlockLantern implements IWeatheringBlock {
    private final WeatherState weatherState;

    public BlockWeatheringLantern(WeatherState weatherState, BlockBehaviour.Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        changeOverTime(state, level, pos, random);
    }

    @Override
    protected void tick(BlockState p_222945_, ServerLevel p_222946_, BlockPos p_222947_, RandomSource p_222948_) {
        super.tick(p_222945_, p_222946_, p_222947_, p_222948_);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return IWeatheringBlock.getNext(state.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level,
            BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemInteractionResult res = applyWax(itemStack, state, level, pos, player, hand, hitResult);
        return res.equals(ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) ? super.useItemOn(itemStack, state, level, pos, player, hand, hitResult) : res;
    }
}