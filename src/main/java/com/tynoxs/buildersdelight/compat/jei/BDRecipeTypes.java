package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BDRecipeTypes
{
    private static final DeferredRegister<RecipeType<?>> REGISTER = DeferredRegister.create(
        Registry.RECIPE_TYPE_REGISTRY, BuildersDelight.MODID
    );
    public static final TypeWithClass<ChiselRecipe> CHISEL = register("chisel", ChiselRecipe.class);

    private static <T extends Recipe<?>>
    TypeWithClass<T> register(String name, Class<T> type)
    {
        RegistryObject<RecipeType<T>> regObj = REGISTER.register(name, () -> new RecipeType<>()
        {
        });

        return new TypeWithClass<>(regObj, type);
    }

    public static void init()
    {
        REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public record TypeWithClass<T extends Recipe<?>>(
            RegistryObject<RecipeType<T>> type, Class<T> recipeClass
    ) implements Supplier<RecipeType<T>>
    {
        public RecipeType<T> get()
        {
            return type.get();
        }
    }
}
