package com.tynoxs.buildersdelight.content.recipe;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.compat.jei.IChiselRecipe;
import com.tynoxs.buildersdelight.compat.jei.JeiIntegration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ChiselRecipe implements IChiselRecipe {


    private List<ItemStack> variants;

    public ChiselRecipe() {
        this.variants = new ArrayList<>();
    }

    public List<ItemStack> getVariants() {
        return variants;
    }

    public ChiselRecipe addVariant(Item... outputItem){
        for(Item item : outputItem){
            variants.add(new ItemStack(item.asItem()));
        }
        return this;
    }

    public ChiselRecipe addVariant(Block... outputItem){
        for(Block block : outputItem){
            variants.add(new ItemStack(block.asItem()));
        }
        return this;
    }

    public boolean contains(ItemStack base) {
        for(ItemStack variant : this.variants){
            if(variant.getItem() == base.getItem()){
                return true;
            }
        }
        return false;
    }

    public static ChiselRecipe newRecipe(List<Item> variantsItems) {
        return new ChiselRecipe().addVariant(variantsItems.toArray(new Item[variantsItems.size()]));
    }


    @Override
    public ItemStack getBaseItem() {
        return this.getVariants().get(0);
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess registries) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registries) {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(BuildersDelight.MODID, BuiltInRegistries.ITEM.getKey(getBaseItem().getItem()).getPath());
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return JeiIntegration.TYPE;
    }


}
