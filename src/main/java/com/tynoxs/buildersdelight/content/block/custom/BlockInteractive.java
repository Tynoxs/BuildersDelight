package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Locale;

public class BlockInteractive extends Block {
    public static final EnumProperty<BlockInteractiveState> STATE = EnumProperty.create("state", BlockInteractiveState.class);

    public BlockInteractive(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STATE, BlockInteractiveState.OFF));
    }

    public enum BlockInteractiveState implements StringRepresentable {
        OFF,
        ON;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase(Locale.ROOT);
        }
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
        builder.add(STATE);
    }
}


