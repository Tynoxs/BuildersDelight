package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.Locale;

public class BlockFlatInteractive extends BlockFlatFace {
    public static final EnumProperty<BlockInteractiveState> STATE = EnumProperty.create("state", BlockInteractiveState.class);

    public BlockFlatInteractive(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STATE, BlockInteractiveState.OFF).setValue(FACE, AttachFace.FLOOR).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public enum BlockInteractiveState implements StringRepresentable {
        OFF,
        ON;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidstate = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;

        for(Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            BlockState blockstate;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockstate = this.defaultBlockState().setValue(STATE, BlockInteractiveState.OFF).setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, blockPlaceContext.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(flag));
            } else {
                blockstate = this.defaultBlockState().setValue(STATE, BlockInteractiveState.OFF).setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, Boolean.valueOf(flag));
            }

            if (blockstate.canSurvive(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) {
                return blockstate;
            }
        }
        return null;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player.getAbilities().mayBuild) {
            BlockInteractiveState newState = (state.getValue(STATE) == BlockInteractiveState.OFF) ? BlockInteractiveState.ON : BlockInteractiveState.OFF;
            level.setBlock(pos, state.setValue(STATE, newState), 3);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STATE, FACING, FACE, WATERLOGGED);
    }
}


