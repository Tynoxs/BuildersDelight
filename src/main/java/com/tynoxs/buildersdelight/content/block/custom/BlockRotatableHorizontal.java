package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;

public class BlockRotatableHorizontal extends BlockRotatable {

    public BlockRotatableHorizontal(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeCtx) {
        return this.defaultBlockState().setValue(FACING, placeCtx.getNearestLookingDirection());
    }
}
