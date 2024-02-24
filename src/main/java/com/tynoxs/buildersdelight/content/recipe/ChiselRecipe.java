package com.tynoxs.buildersdelight.content.recipe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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

    public ItemStack getBaseItem() {
        return this.getVariants().get(0);
    }
}
