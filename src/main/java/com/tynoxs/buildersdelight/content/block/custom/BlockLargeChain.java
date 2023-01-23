package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockLargeChain extends ChainBlock {
    protected static final VoxelShape UP_DOWN = Shapes.or(
            Block.box(5, 12, 7, 11, 14, 9),
            Block.box(7, 4, 5, 9, 6, 11),
            Block.box(7, 10, 5, 9, 12, 11),
            Block.box(7, 0, 9, 9, 4, 11),
            Block.box(7, 0, 5, 9, 4, 7),
            Block.box(7, 12, 9, 9, 16, 11),
            Block.box(7, 12, 5, 9, 16, 7),
            Block.box(5, 4, 7, 7, 12, 9),
            Block.box(9, 4, 7, 11, 12, 9),
            Block.box(5, 2, 7, 11, 4, 9));
    protected static final VoxelShape NORTH_SOUTH = Shapes.or(
            Block.box(5, 7, 12, 11, 9, 14),
            Block.box(7, 5, 4, 9, 11, 6),
            Block.box(7, 5, 10, 9, 11, 12),
            Block.box(7, 5, 0, 9, 7, 4),
            Block.box(7, 9, 0, 9, 11, 4),
            Block.box(7, 5, 12, 9, 7, 16),
            Block.box(7, 9, 12, 9, 11, 16),
            Block.box(5, 7, 4, 7, 9, 12),
            Block.box(9, 7, 4, 11, 9, 12),
            Block.box(5, 7, 2, 11, 9, 4));
    protected static final VoxelShape EAST_WEST = Shapes.or(
            Block.box(12, 7, 5, 14, 9, 11),
            Block.box(4, 5, 7, 6, 11, 9),
            Block.box(10, 5, 7, 12, 11, 9),
            Block.box(0, 5, 7, 4, 7, 9),
            Block.box(0, 9, 7, 4, 11, 9),
            Block.box(12, 5, 7, 16, 7, 9),
            Block.box(12, 9, 7, 16, 11, 9),
            Block.box(4, 7, 9, 12, 9, 11),
            Block.box(4, 7, 5, 12, 9, 7),
            Block.box(2, 7, 5, 4, 9, 11));

    public BlockLargeChain(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE).setValue(AXIS, Direction.Axis.Y));
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext ctx) {
        switch((Direction.Axis)blockState.getValue(AXIS)) {
            case X:
            default:
                return EAST_WEST;
            case Z:
                return NORTH_SOUTH;
            case Y:
                return UP_DOWN;
        }
    }
}
