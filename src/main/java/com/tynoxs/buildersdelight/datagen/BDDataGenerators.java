package com.tynoxs.buildersdelight.datagen;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.datagen.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BuildersDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BDDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new BdBlockLootTableProvider(output));
        generator.addProvider(true, new BdDecorationLootTableProvider(output));
        generator.addProvider(true, new BdBlockStateProvider(output, BuildersDelight.MODID, existingFileHelper));
        generator.addProvider(true, new BdItemModelProvider(output, existingFileHelper));
        generator.addProvider(true, new BdBlockTagProvider(output, provider, existingFileHelper));
    }
}
