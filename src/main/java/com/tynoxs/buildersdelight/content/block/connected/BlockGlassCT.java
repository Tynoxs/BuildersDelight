package com.tynoxs.buildersdelight.content.block.connected;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class BlockGlassCT extends AbstractGlassBlock implements IConnectedTextureBlock {

    private final ResourceLocation texture;

    public BlockGlassCT(BlockBehaviour.Properties properties, String texture){
        super(properties);
        this.texture = new ResourceLocation("buildersdelight", texture);
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter world, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType){
        return false;
    }

    @Override
    public ResourceLocation getTexture(){
        return this.texture;
    }
}
