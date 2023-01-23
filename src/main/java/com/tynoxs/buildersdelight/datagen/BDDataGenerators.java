package com.tynoxs.buildersdelight.datagen;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.datagen.providers.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BuildersDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BDDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new BdBlockLootTableProvider(generator));
        generator.addProvider(true, new BdDecorationLootTableProvider(generator));
        generator.addProvider(true, new BdBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(true, new BdItemModelProvider(generator, existingFileHelper));
        generator.addProvider(true, new BdBlockTagProvider(generator, existingFileHelper));
    }
}
