package com.tynoxs.buildersdelight.content.block.connected;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.IronBarsBlock;

public class BlockPaneCT extends IronBarsBlock implements IConnectedTextureBlock {

    private final ResourceLocation texture;

    public BlockPaneCT(Properties properties, String texture){
        super(properties);
        this.texture = new ResourceLocation("buildersdelight", texture);
    }

    @Override
    public ResourceLocation getTexture(){
        return this.texture;
    }

    @Override
    public boolean isPane(){
        return true;
    }
}