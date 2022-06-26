package com.tynoxs.buildersdelight.content.block.connected;

import net.minecraft.resources.ResourceLocation;

public interface IConnectedTextureBlock {


    ResourceLocation getTexture();

    default boolean isPane(){
        return false;
    }
}
