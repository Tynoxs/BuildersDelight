package com.tynoxs.buildersdelight.content.block.custom;

import com.tynoxs.buildersdelight.content.entity.EntitySit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static com.tynoxs.buildersdelight.content.block.custom.BlockRotatable.FACING;

public class BlockChair extends BlockStool {
    protected static final VoxelShape FACING_NORTH = Shapes.or(Block.box(2, 8, 3, 14, 11, 15), Block.box(2, 0, 1, 4, 8, 3), Block.box(12, 0, 1, 14, 8, 3), Block.box(2, 8, 1, 14, 11, 3), Block.box(2, 11, 1, 14, 26, 3), Block.box(2, 0, 13, 4, 8, 15), Block.box(12, 0, 13, 14, 8, 15), Block.box(2.5, 4, 3, 2.5, 6, 13), Block.box(13.5, 4, 3, 13.5, 6, 13), Block.box(4, 4, 14.5, 12, 6, 14.5), Block.box(4, 4, 1.5, 12, 6, 1.5));
    protected static final VoxelShape FACING_SOUTH = Shapes.or(Block.box(2, 8, 1, 14, 11, 13), Block.box(2, 0, 13, 4, 8, 15), Block.box(12, 0, 13, 14, 8, 15), Block.box(2, 8, 13, 14, 11, 15), Block.box(2, 11, 13, 14, 26, 15), Block.box(2, 0, 1, 4, 8, 3), Block.box(12, 0, 1, 14, 8, 3), Block.box(2.5, 4, 3, 2.5, 6, 13), Block.box(13.5, 4, 3, 13.5, 6, 13), Block.box(4, 4, 1.5, 12, 6, 1.5), Block.box(4, 4, 14.5, 12, 6, 14.5));
    protected static final VoxelShape FACING_WEST = Shapes.or(Block.box(3, 8, 2, 15, 11, 14), Block.box(1, 0, 2, 3, 8, 4), Block.box(1, 0, 12, 3, 8, 14), Block.box(1, 8, 2, 3, 11, 14), Block.box(1, 11, 2, 3, 26, 14), Block.box(13, 0, 2, 15, 8, 4), Block.box(13, 0, 12, 15, 8, 14), Block.box(3, 4, 2.5, 13, 6, 2.5), Block.box(3, 4, 13.5, 13, 6, 13.5), Block.box(14.5, 4, 4, 14.5, 6, 12), Block.box(1.5, 4, 4, 1.5, 6, 12));
    protected static final VoxelShape FACING_EAST = Shapes.or(Block.box(1, 8, 2, 13, 11, 14), Block.box(13, 0, 2, 15, 8, 4), Block.box(13, 0, 12, 15, 8, 14), Block.box(13, 8, 2, 15, 11, 14), Block.box(13, 11, 2, 15, 26, 14), Block.box(1, 0, 2, 3, 8, 4), Block.box(1, 0, 12, 3, 8, 14), Block.box(3, 4, 2.5, 13, 6, 2.5), Block.box(3, 4, 13.5, 13, 6, 13.5), Block.box(1.5, 4, 4, 1.5, 6, 12), Block.box(14.5, 4, 4, 14.5, 6, 12));

    public BlockChair(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext ctx) {
        Direction direction = blockState.getValue(FACING);
        return switch (direction) {
            case EAST -> FACING_EAST;
            case WEST -> FACING_WEST;
            case SOUTH -> FACING_SOUTH;
            default -> FACING_NORTH;
        };
    }

    public VoxelShape getOcclusionShape(BlockState p_54584_, BlockGetter p_54585_, BlockPos p_54586_) {
        return FACING_NORTH;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext ctx) {
        Direction direction = blockState.getValue(FACING);
        return switch (direction) {
            case EAST -> FACING_EAST;
            case WEST -> FACING_WEST;
            case SOUTH -> FACING_SOUTH;
            default -> FACING_NORTH;
        };
    }

    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return true;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        for(Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection());
            } else {
                blockstate = this.defaultBlockState().setValue(FACING, direction.getOpposite());
            }
            if (blockstate.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) {
                return blockstate;
            }
        }
        return null;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        return EntitySit.create(level, pos, 0.4, player);
    }
}
