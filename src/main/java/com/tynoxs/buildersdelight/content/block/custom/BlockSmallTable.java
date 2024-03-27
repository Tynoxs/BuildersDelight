package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Locale;

public class BlockSmallTable extends Block {
    private static final EnumProperty<TableTexture> VARIANT = EnumProperty.create("variant", TableTexture.class);
    protected static final VoxelShape SHAPE = Shapes.or(
            Block.box(12, 0, 12, 15, 12, 15),
            Block.box(1, 0, 12, 4, 12, 15),
            Block.box(12, 0, 1, 15, 12, 4),
            Block.box(1, 0, 1, 4, 12, 4),
            Block.box(0, 12, 0, 16, 16, 16)
    );

    public enum TableTexture implements StringRepresentable {
        VARIANT_1,
        VARIANT_2;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player.getAbilities().mayBuild) {
            TableTexture newTexture = (state.getValue(VARIANT) == TableTexture.VARIANT_1) ? TableTexture.VARIANT_2 : TableTexture.VARIANT_1;
            level.setBlock(pos, state.setValue(VARIANT, newTexture), 3);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }

    public BlockSmallTable(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(VARIANT, TableTexture.VARIANT_1));
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

