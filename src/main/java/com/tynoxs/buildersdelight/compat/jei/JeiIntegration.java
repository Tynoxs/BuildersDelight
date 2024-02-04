package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JeiIntegration implements IModPlugin {

    public static final RecipeType<ChiselRecipe> CHISEL_RECIPE_TYPE = RecipeType.create(BuildersDelight.MODID, "chisel", ChiselRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BuildersDelight.MODID, "chisel_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IModPlugin.super.registerCategories(registration);
        registration.addRecipeCategories(new ChiselRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        IModPlugin.super.registerRecipes(registration);
        registration.addRecipes(CHISEL_RECIPE_TYPE, BuildersDelight.get().getRecipeFactory().getChiselRecipes());

    }
}
