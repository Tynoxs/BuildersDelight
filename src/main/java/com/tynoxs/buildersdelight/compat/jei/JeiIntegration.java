package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdItems;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JeiIntegration implements IModPlugin {

    public static final RecipeType<ChiselRecipe> CHISEL_RECIPE_TYPE = RecipeType.create(BuildersDelight.MODID, "chisel", ChiselRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BuildersDelight.MODID, "chisel_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ChiselRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(CHISEL_RECIPE_TYPE, BuildersDelight.get().getRecipeFactory().getChiselRecipes());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration){
        registration.addRecipeCatalyst(new ItemStack(BdItems.IRON_CHISEL.get()), CHISEL_RECIPE_TYPE);
    }
}
