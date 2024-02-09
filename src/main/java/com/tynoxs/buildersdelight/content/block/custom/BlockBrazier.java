package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BlockBrazier extends BlockLantern {

    public BlockBrazier(Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        double d0, d1, d2;
        Direction dir1 = stateIn.getValue(FACING);

        switch (stateIn.getValue(FACE)) {
            default -> {
                d0 = pos.getX() + 0.5D;
                d1 = pos.getY() + 0.4D;
                d2 = pos.getZ() + 0.5D;
            }
            case WALL -> {
                double xo1 = -dir1.getStepX() * 0.11;
                double zo2 = -dir1.getStepZ() * 0.11;
                d0 = pos.getX() + 0.5D + xo1;
                d1 = pos.getY() + 0.8;
                d2 = pos.getZ() + 0.5D + zo2;
            }
            case CEILING -> {
                d0 = pos.getX() + 0.5D;
                d1 = pos.getY() + 0.5D;
                d2 = pos.getZ() + 0.5D;
            }
        }
        worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
    }
}