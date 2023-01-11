package com.tynoxs.buildersdelight.content.block.connected.model;

import com.tynoxs.buildersdelight.content.block.connected.IConnectedTextureBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.data.ModelProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class BDProperties
{
    public static final ModelProperty<Map<Direction,SideData>> SIDES = new ModelProperty<>();
    public static final ModelProperty<Map<Direction,Boolean>> UP = new ModelProperty<>();
    public static final ModelProperty<Map<Direction,Boolean>> DOWN = new ModelProperty<>();
    public static final ModelProperty<Boolean> UPPOST = new ModelProperty<>();
    public static final ModelProperty<Boolean> DOWNPOST = new ModelProperty<>();
}
