package com.tynoxs.buildersdelight.content.recipe;

import com.google.gson.*;
import com.mojang.logging.LogUtils;
import com.tynoxs.buildersdelight.BuildersDelight;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChiselRecipeFactory extends SimpleJsonResourceReloadListener {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private List<ChiselRecipe> chiselRecipes = new ArrayList<>();

    public ChiselRecipeFactory() {
        super(GSON, "chisel");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> pObject, ResourceManager pResourceManager, ProfilerFiller pProfiler) {
        for(Map.Entry<ResourceLocation, JsonElement> entry : pObject.entrySet()) {
            ResourceLocation resourcelocation = entry.getKey();
            try {
                ChiselRecipe recipe = fromJson(resourcelocation, GsonHelper.convertToJsonObject(entry.getValue(), "top element"));
                if (recipe == null) {
                    LOGGER.info("Skipping loading recipe {} as it's serializer returned null", resourcelocation);
                    continue;
                }
                chiselRecipes.add(recipe);
            } catch (IllegalArgumentException | JsonParseException jsonparseexception) {
                LOGGER.error("Parsing error loading recipe {}", resourcelocation, jsonparseexception);
            }
        }
    }

    public List<ChiselRecipe> getChiselRecipes() {
        return chiselRecipes;
    }

    public List<ItemStack> getVariants(ItemStack base){
        for(ChiselRecipe recipe : getChiselRecipes()){
            if(recipe.contains(base)){
                return recipe.getVariants();
            }
        }
        return new ArrayList<>();
    }

    public boolean hasVariants(ItemStack base){
        return getVariants(base) != null;
    }

    public void clear() {
        this.chiselRecipes.clear();
    }

    public static ChiselRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
        List<Item> variantsItems = parseVariantsArray(pRecipeId, GsonHelper.getAsJsonArray(pJson, "variants"));
        if(variantsItems == null){
            return null;
        }

        return ChiselRecipe.newRecipe(variantsItems);
    }

    private static List<Item> parseVariantsArray(ResourceLocation pRecipeId, JsonArray variantsArray){
        List<Item> outputItems = new ArrayList<>();
        for (Iterator<JsonElement> it = variantsArray.iterator(); it.hasNext(); ) {
            ResourceLocation variantEntry = ResourceLocation.tryParse(it.next().getAsString());
            if (!Registry.ITEM.containsKey(variantEntry)) {
                LOGGER.info("Skipping loading recipe {} cause one of it's variant (" + variantEntry+") doesn't exist", pRecipeId);
                return null;
            }

            outputItems.add(Registry.ITEM.get(variantEntry));
        }
        return outputItems;
    }

    public static ChiselRecipeFactory get(){
        return BuildersDelight.get().getRecipeFactory();
    }


}