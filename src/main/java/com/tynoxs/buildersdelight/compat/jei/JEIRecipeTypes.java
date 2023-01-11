package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipe;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.Recipe;


public class JEIRecipeTypes
{
    public static final RecipeType<ChiselRecipe> CHISEL = create(BDRecipeTypes.CHISEL);

    private static <T extends Recipe<?>>
    RecipeType<T> create(BDRecipeTypes.TypeWithClass<T> type)
    {
        return new RecipeType<>(type.type().getId(), type.recipeClass());
    }
}
