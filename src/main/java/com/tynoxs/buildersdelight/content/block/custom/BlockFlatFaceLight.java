package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BlockFlatFaceLight extends BlockFlatFace {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public BlockFlatFaceLight(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACE, AttachFace.FLOOR).setValue(LIT, Boolean.FALSE).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidstate = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;

        for(Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, blockPlaceContext.getHorizontalDirection()).setValue(LIT, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos())).setValue(WATERLOGGED, Boolean.valueOf(flag));
            } else {
                blockstate = this.defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite()).setValue(LIT, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos())).setValue(WATERLOGGED, Boolean.valueOf(flag));
            }

            if (blockstate.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) {
                return blockstate;
            }
        }
        return null;
    }

    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos1, boolean b) {
        if (!level.isClientSide) {
            boolean flag = blockState.getValue(LIT);
            boolean hasSignal = level.hasNeighborSignal(blockPos);

            if (flag != hasSignal) {
                if (hasSignal) {
                    level.setBlock(blockPos, blockState.setValue(LIT, true), 2);
                } else {
                    level.scheduleTick(blockPos, this, 4);
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player.getAbilities().mayBuild) {
            boolean isLit = state.getValue(LIT);

            level.setBlock(pos, state.setValue(LIT, !isLit), 2);

            if (!isLit) {
                level.setBlock(pos, state.setValue(LIT, true), 2);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public void tick(BlockState blockState, ServerLevel world, BlockPos blockPos, RandomSource random) {
        if (blockState.getValue(LIT) && !world.hasNeighborSignal(blockPos)) {
            world.setBlock(blockPos, blockState.cycle(LIT), 2);
        }
    }

    public @NotNull VoxelShape getShape(BlockState p_51104_, @NotNull BlockGetter p_51105_, @NotNull BlockPos p_51106_, @NotNull CollisionContext p_51107_) {
        Direction direction = p_51104_.getValue(FACING);
        switch(p_51104_.getValue(FACE)) {
            case FLOOR:
                if (direction.getAxis() == Direction.Axis.X) {
                    return FLOOR_AABB_X;
                }
                return FLOOR_AABB_Z;
            case WALL:
                return switch (direction) {
                    case EAST -> EAST_AABB;
                    case WEST -> WEST_AABB;
                    case SOUTH -> SOUTH_AABB;
                    default -> NORTH_AABB;
                };
            case CEILING:
            default:
                if (direction.getAxis() == Direction.Axis.X) {
                    return CEILING_AABB_X;
                } else {
                    return CEILING_AABB_Z;
                }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING, FACE, LIT, WATERLOGGED);
    }
}