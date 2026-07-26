package com.tynoxs.buildersdelight.content.block.connected.model;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.geometry.IGeometryBakingContext;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class CTConnectedBakedModel extends CTBakedModel {

    public CTConnectedBakedModel(IGeometryBakingContext context, ResourceLocation modelLocation) {
        super(context, modelLocation);
    }

    @Nonnull
    @Override
    public ModelData getModelData(@Nonnull BlockAndTintGetter world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull ModelData tileData){
        Map<Direction,SideData> sides = new HashMap<>();

        for(Direction direction : Direction.values()) {
            sides.put(direction, new SideData(direction, world, pos, state.getBlock()));
        }

        return ModelData.builder()
                .with(BDProperties.SIDES, sides)
                .build();
    }

    @Override
    protected float[] getUV(Direction side, ModelData modelData){
        if(!modelData.has(BDProperties.SIDES))
            return getUV(0, 0);

        SideData blocks = modelData.get(BDProperties.SIDES).get(side);
        if (blocks == null) return getUV(0, 0);

        float[] uv;

        if(!blocks.left && !blocks.up && !blocks.right && !blocks.down)
            uv = this.getUV(0, 0);
        else{
            if(blocks.left && !blocks.up && !blocks.right && !blocks.down)
                uv = this.getUV(3, 0);
            else if(!blocks.left && blocks.up && !blocks.right && !blocks.down)
                uv = this.getUV(0, 3);
            else if(!blocks.left && !blocks.up && blocks.right && !blocks.down)
                uv = this.getUV(1, 0);
            else if(!blocks.left && !blocks.up && !blocks.right && blocks.down)
                uv = this.getUV(0, 1);
            else{
                if(blocks.left && !blocks.up && blocks.right && !blocks.down)
                    uv = this.getUV(2, 0);
                else if(!blocks.left && blocks.up && !blocks.right && blocks.down)
                    uv = this.getUV(0, 2);
                else if(blocks.left && blocks.up && !blocks.right && !blocks.down){
                    if(blocks.up_left)
                        uv = this.getUV(3, 3);
                    else
                        uv = this.getUV(5, 1);
                }else if(!blocks.left && blocks.up && blocks.right && !blocks.down){
                    if(blocks.up_right)
                        uv = this.getUV(1, 3);
                    else
                        uv = this.getUV(4, 1);
                }else if(!blocks.left && !blocks.up && blocks.right && blocks.down){
                    if(blocks.down_right)
                        uv = this.getUV(1, 1);
                    else
                        uv = this.getUV(4, 0);
                }else if(blocks.left && !blocks.up && !blocks.right && blocks.down){
                    if(blocks.down_left)
                        uv = this.getUV(3, 1);
                    else
                        uv = this.getUV(5, 0);
                }else{
                    if(!blocks.left){
                        if(blocks.up_right && blocks.down_right)
                            uv = this.getUV(1, 2);
                        else if(blocks.up_right)
                            uv = this.getUV(4, 2);
                        else if(blocks.down_right)
                            uv = this.getUV(6, 2);
                        else
                            uv = this.getUV(6, 0);
                    }else if(!blocks.up){
                        if(blocks.down_left && blocks.down_right)
                            uv = this.getUV(2, 1);
                        else if(blocks.down_left)
                            uv = this.getUV(7, 2);
                        else if(blocks.down_right)
                            uv = this.getUV(5, 2);
                        else
                            uv = this.getUV(7, 0);
                    }else if(!blocks.right){
                        if(blocks.up_left && blocks.down_left)
                            uv = this.getUV(3, 2);
                        else if(blocks.up_left)
                            uv = this.getUV(7, 3);
                        else if(blocks.down_left)
                            uv = this.getUV(5, 3);
                        else
                            uv = this.getUV(7, 1);
                    }else if(!blocks.down){
                        if(blocks.up_left && blocks.up_right)
                            uv = this.getUV(2, 3);
                        else if(blocks.up_left)
                            uv = this.getUV(4, 3);
                        else if(blocks.up_right)
                            uv = this.getUV(6, 3);
                        else
                            uv = this.getUV(6, 1);
                    }else{
                        if(blocks.up_left && blocks.up_right && blocks.down_left && blocks.down_right)
                            uv = this.getUV(2, 2);
                        else{
                            if(!blocks.up_left && blocks.up_right && blocks.down_left && blocks.down_right)
                                uv = this.getUV(7, 7);
                            else if(blocks.up_left && !blocks.up_right && blocks.down_left && blocks.down_right)
                                uv = this.getUV(6, 7);
                            else if(blocks.up_left && blocks.up_right && !blocks.down_left && blocks.down_right)
                                uv = this.getUV(7, 6);
                            else if(blocks.up_left && blocks.up_right && blocks.down_left && !blocks.down_right)
                                uv = this.getUV(6, 6);
                            else{
                                if(!blocks.up_left && blocks.up_right && !blocks.down_right && blocks.down_left)
                                    uv = this.getUV(0, 4);
                                else if(blocks.up_left && !blocks.up_right && blocks.down_right && !blocks.down_left)
                                    uv = this.getUV(0, 5);
                                else if(!blocks.up_left && !blocks.up_right && blocks.down_right && blocks.down_left)
                                    uv = this.getUV(3, 6);
                                else if(blocks.up_left && !blocks.up_right && !blocks.down_right && blocks.down_left)
                                    uv = this.getUV(3, 7);
                                else if(blocks.up_left && blocks.up_right && !blocks.down_right && !blocks.down_left)
                                    uv = this.getUV(2, 7);
                                else if(!blocks.up_left && blocks.up_right && blocks.down_right && !blocks.down_left)
                                    uv = this.getUV(2, 6);
                                else{
                                    if(blocks.up_left)
                                        uv = this.getUV(5, 7);
                                    else if(blocks.up_right)
                                        uv = this.getUV(4, 7);
                                    else if(blocks.down_right)
                                        uv = this.getUV(4, 6);
                                    else if(blocks.down_left)
                                        uv = this.getUV(5, 6);
                                    else
                                        uv = this.getUV(0, 6);
                                }
                            }
                        }
                    }
                }
            }
        }

        return uv;
    }

    private float[] getUV(int x, int y){
        return new float[]{x * 2.0f, y * 2.0f, (x + 1) * 2.0f, (y + 1) * 2.0f};
    }
}