package com.tynoxs.buildersdelight.content.block.custom;

import com.tynoxs.buildersdelight.content.block.custom.lantern.IWeatheringBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockWeatheringChain extends ChainBlock implements IWeatheringBlock {
    private final WeatherState weatherState;

    public BlockWeatheringChain(WeatherState weatherState, BlockBehaviour.Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.onRandomTick(state, level, pos, random);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return IWeatheringBlock.getNext(state.getBlock()).isPresent();
    }

    public WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        InteractionResult res = applyWax(state, level, pos, player, hand);
        return res.equals(InteractionResult.PASS) ? super.use(state, level, pos, player, hand, hitResult) : res;
    }
}
