package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BlockPaperLamp extends BlockLantern {
    protected static final VoxelShape HANGING = Block.box(0, 0, 0, 16, 16, 16);
    protected static final VoxelShape STANDING = Block.box(2, 0, 2, 14, 13, 14);
    protected static final VoxelShape MOUNTED_NORTH = Block.box(3, 0, 3, 13, 16, 16);
    protected static final VoxelShape MOUNTED_SOUTH = Block.box(3, 0, 0, 13, 16, 13);
    protected static final VoxelShape MOUNTED_WEST = Block.box(3, 0, 3, 16, 16, 13);
    protected static final VoxelShape MOUNTED_EAST = Block.box(0, 0, 3, 13, 16, 13);

    public BlockPaperLamp(Properties properties) {
        super(properties);
    }

    public @NotNull VoxelShape getShape(BlockState blockState, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = blockState.getValue(FACING);
        switch(blockState.getValue(FACE)) {
            case CEILING:
                return HANGING;
            case FLOOR:
            default: return STANDING;
            case WALL:
                return switch (direction) {
                    case EAST -> MOUNTED_EAST;
                    case WEST -> MOUNTED_WEST;
                    case SOUTH -> MOUNTED_SOUTH;
                    default -> MOUNTED_NORTH;
                };
        }
    }
}