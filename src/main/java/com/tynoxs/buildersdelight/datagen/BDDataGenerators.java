package com.tynoxs.buildersdelight.datagen;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.datagen.lang.EnglishLangGen;
import com.tynoxs.buildersdelight.datagen.lang.GermanLangGen;
import com.tynoxs.buildersdelight.datagen.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeAdvancementProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BuildersDelight.MODID)
public class BDDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BdRecipes(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), BdBlockLootTableProvider.create(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new BdBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        generator.addProvider(event.includeServer(), new BdItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new BdBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new BdItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeClient(), new NeoForgeAdvancementProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new EnglishLangGen(packOutput, "en_us"));
        generator.addProvider(event.includeClient(), new GermanLangGen(packOutput, "de_de"));
    }
}
