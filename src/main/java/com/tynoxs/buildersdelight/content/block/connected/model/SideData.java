package com.tynoxs.buildersdelight.content.block.connected.model;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;


class SideData {
    private BlockGetter world;
    private Block block;

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean up_left;
    public boolean up_right;
    public boolean down;
    public boolean down_left;
    public boolean down_right;

    public SideData(Direction side, BlockGetter world, BlockPos pos, Block block){
        this.world = world;
        this.block = block;

        Direction left;
        Direction right;
        Direction up;
        Direction down;
        if(side.getAxis() == Direction.Axis.Y){
            left = Direction.WEST;
            right = Direction.EAST;
            up = side == Direction.UP ? Direction.NORTH : Direction.SOUTH;
            down = side == Direction.UP ? Direction.SOUTH : Direction.NORTH;
        }else{
            left = side.getClockWise();
            right = side.getCounterClockWise();
            up = Direction.UP;
            down = Direction.DOWN;
        }

        this.left = this.isSameBlock(pos.relative(left));
        this.right = this.isSameBlock(pos.relative(right));
        this.up = this.isSameBlock(pos.relative(up));
        this.up_left = this.isSameBlock(pos.relative(up).relative(left));
        this.up_right = this.isSameBlock(pos.relative(up).relative(right));
        this.down = this.isSameBlock(pos.relative(down));
        this.down_left = this.isSameBlock(pos.relative(down).relative(left));
        this.down_right = this.isSameBlock(pos.relative(down).relative(right));
    }

    private boolean isSameBlock(BlockPos pos){
        return this.world.getBlockState(pos).getBlock() == this.block;
    }
}
