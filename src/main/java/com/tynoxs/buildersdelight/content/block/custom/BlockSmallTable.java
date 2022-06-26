package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockSmallTable extends Block {
    protected static final VoxelShape SHAPE = Shapes.or(
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(1, 0, 12, 4, 12, 15),
            Block.box(12, 0, 1, 15, 12, 4),
            Block.box(1, 0, 1, 4, 12, 4),
            Block.box(0, 12, 0, 16, 16, 16)
    );

    public BlockSmallTable(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public RenderShape getRenderShape(BlockState state) {
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
}