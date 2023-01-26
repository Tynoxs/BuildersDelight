package com.tynoxs.buildersdelight.content.block.connected.model;

import net.minecraft.core.Direction;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.data.ModelProperty;

import java.util.Map;

public class BDProperties
{
    public static final ModelProperty<Map<Direction,SideData>> SIDES = new ModelProperty<>();
    public static final ModelProperty<Map<Direction,Boolean>> UP = new ModelProperty<>();
    public static final ModelProperty<Map<Direction,Boolean>> DOWN = new ModelProperty<>();
    public static final ModelProperty<Boolean> UPPOST = new ModelProperty<>();
    public static final ModelProperty<Boolean> DOWNPOST = new ModelProperty<>();
}
