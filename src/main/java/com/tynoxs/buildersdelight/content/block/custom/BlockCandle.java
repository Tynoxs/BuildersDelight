package com.tynoxs.buildersdelight.content.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BlockCandle extends BlockLantern {
    protected final ParticleOptions flameParticle;
    protected static final VoxelShape HANGING = Block.box(0, 0, 0, 16, 16, 16);
    protected static final VoxelShape STANDING = Block.box(5, 0, 5, 11, 15, 11);
    protected static final VoxelShape MOUNTED_NORTH = Block.box(4, 1, 6, 12, 15, 16);
    protected static final VoxelShape MOUNTED_SOUTH = Block.box(4, 1, 0, 12, 15, 10);
    protected static final VoxelShape MOUNTED_WEST = Block.box(6, 1, 4, 16, 15, 12);
    protected static final VoxelShape MOUNTED_EAST = Block.box(0, 1, 4, 10, 15, 12);

    public BlockCandle(BlockBehaviour.Properties properties, ParticleOptions particle) {
        super(properties);
        this.flameParticle = particle;
    }

    public @NotNull VoxelShape getShape(BlockState blockState, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction direction = blockState.getValue(FACING);
        switch(blockState.getValue(FACE)) {
            case FLOOR:
                return STANDING;
            case WALL:
                return switch (direction) {
                    case EAST -> MOUNTED_EAST;
                    case WEST -> MOUNTED_WEST;
                    case SOUTH -> MOUNTED_SOUTH;
                    default -> MOUNTED_NORTH;
                };
            case CEILING:
            default: return HANGING;
        }
    }

    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        double d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11;
        Direction dir1 = stateIn.getValue(FACING);

        switch (stateIn.getValue(FACE)) {
            default -> {
                d0 = pos.getX() + 0.5D;
                d1 = pos.getY() + 1.01D;
                d2 = pos.getZ() + 0.5D;
                worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
                worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0, 0, 0);
            }
            case WALL -> {
                double xo1 = -dir1.getStepX() * 0.11;
                double zo2 = -dir1.getStepZ() * 0.11;
                d0 = pos.getX() + 0.5D + xo1;
                d1 = pos.getY() + 0.92D;
                d2 = pos.getZ() + 0.5D + zo2;
                worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
                worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0, 0, 0);
            }
            case CEILING -> {

                d0 = pos.getX() + 0.5D;
                d1 = pos.getY() + 0.75D;
                d2 = pos.getZ() + 0.15D;
                d3 = pos.getX() + 0.15D;
                d4 = pos.getY() + 0.75D;
                d5 = pos.getZ() + 0.5D;
                d6 = pos.getX() + 0.85D;
                d7 = pos.getY() + 0.75D;
                d8 = pos.getZ() + 0.5D;
                d9 = pos.getX() + 0.5D;
                d10 = pos.getY() + 0.75D;
                d11 = pos.getZ() + 0.85D;

                worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0, 0, 0);
                worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0, 0, 0);

                worldIn.addParticle(ParticleTypes.SMOKE, d3, d4, d5, 0, 0, 0);
                worldIn.addParticle(ParticleTypes.FLAME, d3, d4, d5, 0, 0, 0);

                worldIn.addParticle(ParticleTypes.SMOKE, d6, d7, d8, 0, 0, 0);
                worldIn.addParticle(ParticleTypes.FLAME, d6, d7, d8, 0, 0, 0);

                worldIn.addParticle(ParticleTypes.SMOKE, d9, d10, d11, 0, 0, 0);
                worldIn.addParticle(ParticleTypes.FLAME, d9, d10, d11, 0, 0, 0);

            }
        }

    }
}
