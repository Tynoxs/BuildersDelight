package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

public interface IChiselRecipe extends Recipe<Container> {
    ResourceLocation TYPE_ID = new ResourceLocation(BuildersDelight.MODID, "chisel");

    public ItemStack getBaseItem();

}