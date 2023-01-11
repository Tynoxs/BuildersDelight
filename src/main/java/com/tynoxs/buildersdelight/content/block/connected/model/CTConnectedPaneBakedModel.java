package com.tynoxs.buildersdelight.content.block.connected.model;

import com.tynoxs.buildersdelight.content.block.connected.IConnectedTextureBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.data.ModelProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class CTConnectedPaneBakedModel extends CTPaneBakedModel {

    public CTConnectedPaneBakedModel(IConnectedTextureBlock block){
        super(block);
    }

    @Nonnull
    @Override
    public ModelData getModelData(@Nonnull BlockAndTintGetter world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull ModelData tileData){
        Map<Direction,SideData> sides = new HashMap<>();
        Map<Direction,Boolean> upMap = new HashMap<>(), downMap = new HashMap<>();
        boolean upPost = false, downPost = false;

        for(Direction direction : Direction.Plane.HORIZONTAL){
            sides.put(direction, new SideData(direction, world, pos, state.getBlock()));
            BlockState upState = world.getBlockState(pos.above());
            boolean up = upState.getBlock() == state.getBlock() && upState.getValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction));
            upMap.put(direction, up);
            upPost = upState.getBlock() == state.getBlock();
            BlockState downState = world.getBlockState(pos.below());
            boolean down = downState.getBlock() == state.getBlock() && downState.getValue(PipeBlock.PROPERTY_BY_DIRECTION.get(direction));
            downMap.put(direction, down);
            downPost = downState.getBlock() == state.getBlock();
        }

        ModelData modelData = ModelData.builder()
            .with(BDProperties.SIDES, sides)
            .with(BDProperties.UP, upMap)
            .with(BDProperties.DOWN, downMap)
            .with(BDProperties.UPPOST, upPost)
            .with(BDProperties.DOWNPOST, downPost)
            .build();

        return modelData;
    }

    @Override
    protected boolean isEnabledUp(Direction part, ModelData extraData){
        return (extraData.has(BDProperties.UPPOST) || extraData.has(BDProperties.UP)) && (part == null ? extraData.get(BDProperties.UPPOST) : extraData.get(BDProperties.UP).get(part));
    }

    @Override
    protected boolean isEnabledDown(Direction part, ModelData extraData){
        return (extraData.has(BDProperties.DOWNPOST) || extraData.has(BDProperties.DOWN)) && (part == null ? extraData.get(BDProperties.DOWNPOST) : extraData.get(BDProperties.DOWN).get(part));
    }

    @Override
    protected float[] getBorderUV(){
        return this.getUV(0, 7);
    }

    @Override
    protected float[] getUV(Direction side, ModelData modelData){
        if(side == Direction.UP || side == Direction.DOWN)
            return this.getBorderUV();

        if(!modelData.has(BDProperties.SIDES))
            return getUV(0, 0);

        SideData blocks = modelData.get(BDProperties.SIDES).get(side);
        float[] uv;

        if(!blocks.left && !blocks.up && !blocks.right && !blocks.down) // all directions
            uv = this.getUV(0, 0);
        else{ // one direction
            if(blocks.left && !blocks.up && !blocks.right && !blocks.down)
                uv = this.getUV(3, 0);
            else if(!blocks.left && blocks.up && !blocks.right && !blocks.down)
                uv = this.getUV(0, 3);
            else if(!blocks.left && !blocks.up && blocks.right && !blocks.down)
                uv = this.getUV(1, 0);
            else if(!blocks.left && !blocks.up && !blocks.right && blocks.down)
                uv = this.getUV(0, 1);
            else{ // two directions
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
                }else{ // three directions
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
                    }else{ // four directions
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
        return new float[]{x * 2, y * 2, (x + 1) * 2, (y + 1) * 2};
    }
}
