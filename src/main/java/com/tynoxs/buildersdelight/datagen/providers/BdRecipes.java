package com.tynoxs.buildersdelight.datagen.providers;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class BdRecipes extends RecipeProvider implements IConditionBuilder {
    String[] woodTypes = {"acacia", "bamboo", "birch", "cherry", "crimson", "dark_oak", "jungle", "mangrove", "oak", "spruce", "warped"};
    String[] rockTypes = {"andesite", "granite", "diorite", "cobblestone", "stone_bricks"};

    public BdRecipes(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        registerFrameAndGlassRecipes(pWriter);
        registerStairsAndSlabRecipes(pWriter);
    }

    private void registerFrameAndGlassRecipes(Consumer<FinishedRecipe> pWriter) {
        Set<String> generatedIds = new HashSet<>();

        for (String woodType : woodTypes) {
            for (int number = 1; number <= 8; number++) {
                for (int plankNumber = 1; plankNumber <= 7; plankNumber++) {
                    String frameName = woodType + "_frame_" + number;

                    String recipeId = String.valueOf(getRecipeId(frameName));
                    if (generatedIds.contains(recipeId)) {
                        continue;
                    }

                    generateFrameRecipe(pWriter, woodType, number, plankNumber);
                    generateGlassRecipe(pWriter, woodType, number, plankNumber);
                    generatedIds.add(recipeId);
                }
            }
        }
    }

    private void registerStairsAndSlabRecipes(Consumer<FinishedRecipe> pWriter) {
        Set<String> generatedIds = new HashSet<>();

        for (String woodType : woodTypes) {
            for (int plankNumber = 1; plankNumber <= 7; plankNumber++) {
                String plankName = woodType + "_planks_" + plankNumber;

                String recipeId = String.valueOf(getRecipeId(plankName));
                if (generatedIds.contains(recipeId)) {
                    continue;
                }

                generateStairsRecipe(pWriter, woodType, plankNumber);
                generateSlabRecipe(pWriter, woodType, plankNumber);
                generatedIds.add(recipeId);
            }
        }
    }

    private void generateFrameRecipe(Consumer<FinishedRecipe> pWriter, String woodType, int number, int plankNumber) {
        String frameName = woodType + "_frame_" + number;
        String plankName = woodType + "_planks_" + plankNumber;

        TagKey<Item> woodPlanksTag = getWoodPlanksTag(woodType);

        BdBlocks.BLOCKS.getEntries().forEach(entry -> {
            Block block = entry.get();

            if (block.asItem().toString().equals(plankName)) {
                Item frameItem = BdBlocks.getBlockItemMap().get(frameName).get();

                if (block != Blocks.AIR && frameItem != Items.AIR) {
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, frameItem)
                            .pattern("202")
                            .pattern("010")
                            .pattern("202")
                            .define('0', woodPlanksTag)
                            .define('1', ItemTags.WOOL)
                            .define('2', Tags.Items.RODS_WOODEN)
                            .unlockedBy("has_wool", inventoryTrigger(ItemPredicate.Builder.item()
                                    .of(ItemTags.WOOL).build()))
                            .save(pWriter, getRecipeId(frameName));
                }
            }
        });
    }

    private void generateStairsRecipe(Consumer<FinishedRecipe> pWriter, String woodType, int plankNumber) {
        String plankName = woodType + "_planks_" + plankNumber;
        String stairsName = woodType + "_stairs_" + plankNumber;

        BdBlocks.BLOCKS.getEntries().forEach(entry -> {
            Block block = entry.get();

            if (block.asItem().toString().equals(plankName)) {
                Item stairsItem = BdBlocks.getBlockItemMap().get(stairsName).get();
                Item planksItem = BdBlocks.getBlockItemMap().get(plankName).get();

                if (block != Blocks.AIR && stairsItem != Items.AIR) {
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stairsItem, 4)
                            .pattern("  0")
                            .pattern(" 00")
                            .pattern("000")
                            .define('0', planksItem)
                            .unlockedBy("has_planks", inventoryTrigger(ItemPredicate.Builder.item()
                                    .of(BdTags.Items.tag(woodType + "_planks")).build()))
                            .save(pWriter, getRecipeId(stairsName));
                }
            }
        });
    }

    private void generateSlabRecipe(Consumer<FinishedRecipe> pWriter, String woodType, int plankNumber) {
        String plankName = woodType + "_planks_" + plankNumber;
        String slabName = woodType + "_slab_" + plankNumber;

        BdBlocks.BLOCKS.getEntries().forEach(entry -> {
            Block block = entry.get();

            if (block.asItem().toString().equals(plankName)) {
                Item slabItem = BdBlocks.getBlockItemMap().get(slabName).get();
                Item planksItem = BdBlocks.getBlockItemMap().get(plankName).get();

                if (block != Blocks.AIR && slabItem != Items.AIR) {
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, slabItem, 6)
                            .pattern("000")
                            .define('0', planksItem)
                            .unlockedBy("has_planks", inventoryTrigger(ItemPredicate.Builder.item()
                                    .of(BdTags.Items.tag(woodType + "_planks")).build()))
                            .save(pWriter, getRecipeId(slabName));
                }
            }
        });
    }

    private void generateGlassRecipe(Consumer<FinishedRecipe> pWriter, String woodType, int number, int plankNumber) {
        String plankName = woodType + "_planks_" + plankNumber;
        String glassName = woodType + "_glass_" + number;
        String glassPaneName = woodType + "_glass_pane_" + number;

        TagKey<Item> woodPlanksTag = getWoodPlanksTag(woodType);

        BdBlocks.BLOCKS.getEntries().forEach(entry -> {
            Block block = entry.get();

            Item glassItem = BdBlocks.getBlockItemMap().get(glassName).get();

            if (block.asItem().toString().equals(plankName)) {
                if (block != Blocks.AIR && glassItem != Items.AIR) {
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, glassItem, 8)
                            .pattern("000")
                            .pattern("010")
                            .pattern("000")
                            .define('0', BdTags.Items.tag("glass"))
                            .define('1', woodPlanksTag)
                            .unlockedBy("has_glass", has(Tags.Items.GLASS))
                            .unlockedBy("has_glass_colorless", has(Tags.Items.GLASS_COLORLESS))
                            .save(pWriter, getRecipeId(glassName));
                }
            }

            if (block.asItem().toString().equals(plankName)) {
                Item glassPaneItem = BdBlocks.getBlockItemMap().get(glassPaneName).get();

                if (block != Blocks.AIR && glassItem != Items.AIR) {
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, glassPaneItem, 8)
                            .pattern("000")
                            .pattern("000")
                            .define('0', glassItem)
                            .unlockedBy("has_woodtype_glass", has(glassItem))
                            .save(pWriter, getRecipeId(glassPaneName));
                }
            }
        });
    }

    private TagKey<Item> getWoodPlanksTag(String woodType) {
        return switch (woodType) {
            case "acacia" -> BdTags.Items.tag("acacia_planks");
            case "bamboo" -> BdTags.Items.tag("bamboo_planks");
            case "birch" -> BdTags.Items.tag("birch_planks");
            case "cherry" -> BdTags.Items.tag("cherry_planks");
            case "crimson" -> BdTags.Items.tag("crimson_planks");
            case "dark_oak" -> BdTags.Items.tag("dark_oak_planks");
            case "jungle" -> BdTags.Items.tag("jungle_planks");
            case "mangrove" -> BdTags.Items.tag("mangrove_planks");
            case "oak" -> BdTags.Items.tag("oak_planks");
            case "spruce" -> BdTags.Items.tag("spruce_planks");
            case "warped" -> BdTags.Items.tag("warped_planks");
            default -> null;
        };
    }

    private ResourceLocation getRecipeId(String name) {
        return new ResourceLocation(BuildersDelight.MODID, name);
    }
}