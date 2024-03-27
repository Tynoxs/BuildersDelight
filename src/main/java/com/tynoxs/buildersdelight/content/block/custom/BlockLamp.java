package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockLamp extends RedstoneLampBlock {

    public BlockLamp(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(LIT, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!world.isClientSide) {
            boolean isLit = state.getValue(LIT);
            boolean hasSignal = world.hasNeighborSignal(pos);

            if (isLit != hasSignal) {
                if (hasSignal) {
                    world.setBlock(pos, state.setValue(LIT, true), 2);
                } else {
                    world.scheduleTick(pos, this, 4);
                }
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT) && !world.hasNeighborSignal(pos)) {

            world.setBlock(pos, state.setValue(LIT, false), 2);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide && player.getAbilities().mayBuild) {
            boolean isLit = state.getValue(LIT);

            world.setBlock(pos, state.setValue(LIT, !isLit), 2);

            if (!isLit) {
                world.setBlock(pos, state.setValue(LIT, true), 2);
            }
        }

        return InteractionResult.sidedSuccess(world.isClientSide);
    }
}
