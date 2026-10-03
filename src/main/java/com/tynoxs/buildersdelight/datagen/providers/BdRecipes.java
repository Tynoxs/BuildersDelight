package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class BdRecipes extends RecipeProvider implements IConditionBuilder {
    String[] woodTypes = {"acacia", "bamboo", "birch", "cherry", "crimson", "dark_oak", "jungle", "mangrove", "oak", "spruce", "warped"};
    String[] rockTypes = {"andesite", "granite", "diorite", "cobblestone", "stone_bricks"};

    public BdRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> feature) {
        super(pOutput, feature);
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
        registerFrameAndGlassRecipes(pWriter);
        registerStairsAndSlabRecipes(pWriter);
    }

    private void registerFrameAndGlassRecipes(RecipeOutput pWriter) {
        for (String woodType : woodTypes) {
            for (int number = 1; number <= 8; number++) {
                generateFrameRecipe(pWriter, woodType, number);
                generateGlassRecipe(pWriter, woodType, number);
            }
        }
    }

    private void registerStairsAndSlabRecipes(RecipeOutput pWriter) {
        for (String woodType : woodTypes) {
            for (int plankNumber = 1; plankNumber <= 7; plankNumber++) {
                generateStairsRecipe(pWriter, woodType, plankNumber);
                generateSlabRecipe(pWriter, woodType, plankNumber);
            }
        }
    }

    private void generateFrameRecipe(RecipeOutput pWriter, String woodType, int number) {
        String frameName = woodType + "_frame_" + number;

        Supplier<Item> frameItemSupplier = BdBlocks.getBlockItemMap().get(frameName);
        if (frameItemSupplier == null) return;
        Item frameItem = frameItemSupplier.get();

        if (frameItem != null) {
            java.util.List<Item> plankItems = new java.util.ArrayList<>();
            Item vanillaPlank = getVanillaPlank(woodType);
            if (vanillaPlank != null) {
                plankItems.add(vanillaPlank);
            }
            for (int i = 1; i <= 7; i++) {
                String plankName = woodType + "_planks_" + i;
                Supplier<Item> plankSupplier = BdBlocks.getBlockItemMap().get(plankName);
                if (plankSupplier != null) {
                    Item plankItem = plankSupplier.get();
                    if (plankItem != null) {
                        plankItems.add(plankItem);
                    }
                }
            }

            if (!plankItems.isEmpty()) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frameItem)
                        .pattern("202")
                        .pattern("010")
                        .pattern("202")
                        .define('0', Ingredient.of(plankItems.toArray(new Item[0]))) // Accept any plank variant
                        .define('1', ItemTags.WOOL)
                        .define('2', Tags.Items.RODS_WOODEN)
                        .unlockedBy("has_wool", inventoryTrigger(ItemPredicate.Builder.item()
                                .of(ItemTags.WOOL).build()))
                        .save(pWriter, getRecipeId(frameName));
            }
        }
    }

    private void generateStairsRecipe(RecipeOutput pWriter, String woodType, int plankNumber) {
        String plankName = woodType + "_planks_" + plankNumber;
        String stairsName = woodType + "_stairs_" + plankNumber;

        Supplier<Item> stairsItemSupplier = BdBlocks.getBlockItemMap().get(stairsName);
        Supplier<Item> planksItemSupplier = BdBlocks.getBlockItemMap().get(plankName);
        if (stairsItemSupplier == null || planksItemSupplier == null) return;
        Item stairsItem = stairsItemSupplier.get();
        Item planksItem = planksItemSupplier.get();

        if (stairsItem != null && planksItem != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stairsItem, 4)
                    .pattern("  0")
                    .pattern(" 00")
                    .pattern("000")
                    .define('0', planksItem)
                    .unlockedBy("has_planks", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(planksItem).build()))
                    .save(pWriter, getRecipeId(stairsName));
        }
    }

    private void generateSlabRecipe(RecipeOutput pWriter, String woodType, int plankNumber) {
        String plankName = woodType + "_planks_" + plankNumber;
        String slabName = woodType + "_slab_" + plankNumber;

        Supplier<Item> slabItemSupplier = BdBlocks.getBlockItemMap().get(slabName);
        Supplier<Item> planksItemSupplier = BdBlocks.getBlockItemMap().get(plankName);
        if (slabItemSupplier == null || planksItemSupplier == null) return;
        Item slabItem = slabItemSupplier.get();
        Item planksItem = planksItemSupplier.get();

        if (slabItem != null && planksItem != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, slabItem, 6)
                    .pattern("000")
                    .define('0', planksItem)
                    .unlockedBy("has_planks", inventoryTrigger(ItemPredicate.Builder.item()
                            .of(planksItem).build()))
                    .save(pWriter, getRecipeId(slabName));
        }
    }

    private void generateGlassRecipe(RecipeOutput pWriter, String woodType, int number) {
        String glassName = woodType + "_glass_" + number;
        String glassPaneName = woodType + "_glass_pane_" + number;

        Supplier<Item> glassItemSupplier = BdBlocks.getBlockItemMap().get(glassName);
        Supplier<Item> glassPaneItemSupplier = BdBlocks.getBlockItemMap().get(glassPaneName);
        Item glassItem = glassItemSupplier != null ? glassItemSupplier.get() : null;
        Item glassPaneItem = glassPaneItemSupplier != null ? glassPaneItemSupplier.get() : null;

        // Collect all plank variants for this wood type
        java.util.List<Item> plankItems = new java.util.ArrayList<>();
        Item vanillaPlank = getVanillaPlank(woodType);
        if (vanillaPlank != null) {
            plankItems.add(vanillaPlank);
        }
        for (int i = 1; i <= 7; i++) {
            String plankName = woodType + "_planks_" + i;
            Supplier<Item> plankSupplier = BdBlocks.getBlockItemMap().get(plankName);
            if (plankSupplier != null) {
                Item item = plankSupplier.get();
                if (item != null) {
                    plankItems.add(item);
                }
            }
        }

        if (glassItem != null && !plankItems.isEmpty()) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, glassItem, 8)
                    .pattern("000")
                    .pattern("010")
                    .pattern("000")
                    .define('0', Tags.Items.GLASS_BLOCKS)
                    .define('1', Ingredient.of(plankItems.toArray(new Item[0]))) // Accept any plank variant
                    .unlockedBy("has_glass", has(Tags.Items.GLASS_BLOCKS))
                    .unlockedBy("has_glass_colorless", has(Tags.Items.GLASS_BLOCKS_COLORLESS))
                    .save(pWriter, getRecipeId(glassName));
        }

        // Collect all glass variants for this wood type
        java.util.List<Item> glassItems = new java.util.ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            String glassVariantName = woodType + "_glass_" + i;
            Supplier<Item> glassVariantSupplier = BdBlocks.getBlockItemMap().get(glassVariantName);
            if (glassVariantSupplier != null) {
                Item item = glassVariantSupplier.get();
                if (item != null) {
                    glassItems.add(item);
                }
            }
        }

        if (glassPaneItem != null && !glassItems.isEmpty()) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, glassPaneItem, 8)
                    .pattern("000")
                    .pattern("000")
                    .define('0', Ingredient.of(glassItems.toArray(new Item[0]))) // Accept any glass variant
                    .unlockedBy("has_woodtype_glass", has(glassItems.get(0)))
                    .save(pWriter, getRecipeId(glassPaneName));
        }
    }

    private Item getVanillaPlank(String woodType) {
        return switch (woodType) {
            case "acacia" -> Items.ACACIA_PLANKS;
            case "bamboo" -> Items.BAMBOO_PLANKS;
            case "birch" -> Items.BIRCH_PLANKS;
            case "cherry" -> Items.CHERRY_PLANKS;
            case "crimson" -> Items.CRIMSON_PLANKS;
            case "dark_oak" -> Items.DARK_OAK_PLANKS;
            case "jungle" -> Items.JUNGLE_PLANKS;
            case "mangrove" -> Items.MANGROVE_PLANKS;
            case "oak" -> Items.OAK_PLANKS;
            case "spruce" -> Items.SPRUCE_PLANKS;
            case "warped" -> Items.WARPED_PLANKS;
            default -> null;
        };
    }

    private ResourceLocation getRecipeId(String name) {
        return ResourceLocation.fromNamespaceAndPath(BuildersDelight.MODID, name);
    }
}