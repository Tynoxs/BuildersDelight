package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.compat.jei.BDRecipeCategory;
import com.tynoxs.buildersdelight.compat.jei.JeiIntegration;
import com.tynoxs.buildersdelight.content.init.BdItems;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;


public class ChiselRecipeCategory extends BDRecipeCategory<ChiselRecipe>
{
    public ChiselRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper, JeiIntegration.CHISEL_RECIPE_TYPE, "container.iron_chisel");
        ResourceLocation location = new ResourceLocation("buildersdelight:textures/gui/chisel_gui_jei.png");
        setBackground(guiHelper.createDrawable(location, 0, 0, 176, 85));
        setIcon(guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BdItems.IRON_CHISEL.get())));
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ChiselRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 13, 8)
                .addItemStacks(recipe.getVariants());

        int index =0;
        for(int i = 0; i < 4; ++i) {
            for (int j = 0; j < 7; ++j) {
                if(index < recipe.getVariants().size()) {
                    ItemStack stack = recipe.getVariants().get(index);
                    builder.addSlot(RecipeIngredientRole.OUTPUT, 40 + j * 18, 8 + i * 18)
                            .addItemStacks(Arrays.asList(stack));
                    index += 1;
                }
            }
        }
    }
}
