package com.tynoxs.buildersdelight.content.block.connected.model;

import org.joml.Vector3f;
import com.tynoxs.buildersdelight.content.block.connected.IConnectedTextureBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.IDynamicBakedModel;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.geometry.IGeometryBakingContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CTBakedModel implements IDynamicBakedModel {

    private static final FaceBakery BAKERY = new FaceBakery();

    private final IGeometryBakingContext context;
    private final ResourceLocation modelLocation;

    public CTBakedModel(IGeometryBakingContext context, ResourceLocation modelLocation) {
        this.context = context;
        this.modelLocation = modelLocation;
    }

    @Override
    public boolean useAmbientOcclusion(){
        return false;
    }

    @Override
    public boolean isGui3d(){
        return false;
    }

    @Override
    public boolean usesBlockLight(){
        return true;
    }

    @Override
    public boolean isCustomRenderer(){
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon(){
        return this.getTexture(false);
    }

    @Override
    public ItemOverrides getOverrides(){
        return ItemOverrides.EMPTY;
    }

    @Override
    public ItemTransforms getTransforms(){
        return context.getTransforms();
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull RandomSource rand, @Nonnull ModelData extraData, RenderType renderType){
        if(side == null)
            return Collections.emptyList();

        return Collections.singletonList(this.createQuad(state, side, extraData));
    }

    protected TextureAtlasSprite getTexture(boolean asItem){
        if (asItem) {
            // From inventory or as item, different texture path.
            return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(
                ResourceLocation.fromNamespaceAndPath(modelLocation.getNamespace(), "block/connected/" + modelLocation.getPath())
            );
        }

        return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(
            ResourceLocation.fromNamespaceAndPath(modelLocation.getNamespace(), modelLocation.getPath().replaceFirst("block/", "block/connected/"))
        );
    }

    protected BakedQuad createQuad(@Nullable BlockState state, Direction side, ModelData modelData){
        BlockElementFace face = new BlockElementFace(side.getOpposite(), 0, "", new BlockFaceUV(this.getUV(side, modelData), 0));
        return BAKERY.bakeQuad(new Vector3f(0, 0, 0), new Vector3f(16, 16, 16), face, getTexture(state == null), side, BlockModelRotation.X0_Y0, null, true);
    }

    protected float[] getUV(Direction side, ModelData modelData){
        return new float[]{0, 0, 16, 16};
    }
}
