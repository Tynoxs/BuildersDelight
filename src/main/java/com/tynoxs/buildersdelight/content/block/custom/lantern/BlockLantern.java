package com.tynoxs.buildersdelight.content.block.custom.lantern;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BlockLantern extends FaceAttachedHorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape HANGING = Block.box(3, 2, 3, 13, 16, 13);
    protected static final VoxelShape STANDING = Block.box(3, 0, 3, 13, 10, 13);
    protected static final VoxelShape MOUNTED_NORTH = Block.box(3, 0, 3, 13, 16, 16);
    protected static final VoxelShape MOUNTED_SOUTH = Block.box(3, 0, 0, 13, 16, 13);
    protected static final VoxelShape MOUNTED_WEST = Block.box(3, 0, 3, 16, 16, 13);
    protected static final VoxelShape MOUNTED_EAST = Block.box(0, 0, 3, 13, 16, 13);

    public BlockLantern(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACE, AttachFace.FLOOR).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        Direction direction = getConnectedDirection(state).getOpposite();
        return Block.canSupportCenter(reader, pos.relative(direction), direction.getOpposite());
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;

        for(Direction direction : ctx.getNearestLookingDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, ctx.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(flag));
            } else {
                blockstate = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, Boolean.valueOf(flag));
            }

            if (blockstate.canSurvive(ctx.getLevel(), ctx.getClickedPos())) {
                return blockstate;
            }
        }
        return null;
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public @NotNull VoxelShape getShape(BlockState blockState, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = blockState.getValue(FACING);
        switch(blockState.getValue(FACE)) {
            case FLOOR:
                default: return STANDING;
            case WALL:
                return switch (direction) {
                    case EAST -> MOUNTED_EAST;
                    case WEST -> MOUNTED_WEST;
                    case SOUTH -> MOUNTED_SOUTH;
                    default -> MOUNTED_NORTH;
                };
            case CEILING:
                return HANGING;
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING, FACE, WATERLOGGED);
    }
}