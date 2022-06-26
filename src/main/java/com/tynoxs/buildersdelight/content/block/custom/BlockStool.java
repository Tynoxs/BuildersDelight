package com.tynoxs.buildersdelight.content.block.custom;

import com.tynoxs.buildersdelight.content.entity.EntitySit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BlockStool extends Block  {
    protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 11, 14);

    public BlockStool(Properties properties) {
        super(properties);
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter getter, BlockPos blockPos, CollisionContext ctx) {
        return SHAPE;
    }

    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter getter, BlockPos blockPos) {
        return SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter getter, BlockPos blockPos, CollisionContext ctx) {
        return SHAPE;
    }

    @Override
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result)
    {
        return EntitySit.create(level, blockPos, 0.4, player);
    }
}
