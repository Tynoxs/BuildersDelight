package com.tynoxs.buildersdelight.content.block.custom.lantern;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BlockTikiTorch extends LanternLightable {
    protected static final VoxelShape STANDING = Shapes.or(Block.box(5, 0, 5, 11, 21, 11));

    public BlockTikiTorch(Properties properties, ParticleOptions particle) {
        super(properties);
        this.flameParticle = particle;
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, LIT);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState blockState, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return STANDING;
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        if (stateIn.getValue(LIT) && !stateIn.getValue(WATERLOGGED)) {
            double d0, d1, d2;

            d0 = pos.getX() + 0.5D;
            d1 = pos.getY() + 1.49D;
            d2 = pos.getZ() + 0.5D;
            worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
            worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0, 0, 0);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = super.getStateForPlacement(context);
        return blockstate.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState blockStateBelow = world.getBlockState(belowPos);
        return blockStateBelow.isSolid();
    }
}
