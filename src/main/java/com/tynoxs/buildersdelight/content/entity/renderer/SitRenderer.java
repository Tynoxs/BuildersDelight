package com.tynoxs.buildersdelight.content.entity.renderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.tynoxs.buildersdelight.content.entity.EntitySit;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class SitRenderer extends EntityRenderer<EntitySit>
{
    public SitRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySit sitEntity)
    {
        return null;
    }

    @Override
    protected void renderNameTag(EntitySit entity, Component component, PoseStack stack, MultiBufferSource source, int light) {}
}