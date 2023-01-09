package com.tynoxs.buildersdelight.util;

import com.tynoxs.buildersdelight.content.block.connected.IConnectedTextureBlock;
import com.tynoxs.buildersdelight.content.block.connected.model.CTConnectedBakedModel;
import com.tynoxs.buildersdelight.content.block.connected.model.CTConnectedPaneBakedModel;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent.BakingCompleted;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy {

    @SubscribeEvent
    public static void onBake(BakingCompleted e){
        List<Block> connectedTextureBlocks = ForgeRegistries.BLOCKS.getValues().stream().filter(IConnectedTextureBlock.class::isInstance).toList();
        for(Block block : connectedTextureBlocks){
            BakedModel model = ((IConnectedTextureBlock)block).isPane() ? new CTConnectedPaneBakedModel((IConnectedTextureBlock)block) : new CTConnectedBakedModel((IConnectedTextureBlock)block);
            e.getModels().put(new ModelResourceLocation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)), "inventory"), model);
            block.getStateDefinition().getPossibleStates().forEach(state -> {
                String variant = state.toString();
                variant = variant.indexOf('[') > 0 ? variant.substring(variant.indexOf('[') + 1, variant.length() - 1) : "";
                e.getModels().put(new ModelResourceLocation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)), variant), model);
            });
        }
    }

    @SubscribeEvent
    public static void onStitch(TextureStitchEvent.Pre e){
        if(e.getAtlas().location().toString().equals("minecraft:textures/atlas/blocks.png")){
            List<IConnectedTextureBlock> connectedTextureBlocks = ForgeRegistries.BLOCKS.getValues().stream().filter(IConnectedTextureBlock.class::isInstance).map(IConnectedTextureBlock.class::cast).toList();
            for(IConnectedTextureBlock block : connectedTextureBlocks){
                e.addSprite(block.getTexture());
            }
        }
    }
}
