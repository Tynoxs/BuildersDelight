package com.tynoxs.buildersdelight.datagen.providers;
import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.init.BdItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BdItemModelProvider extends ItemModelProvider {
    public BdItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BuildersDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(BdItems.ACACIA_PLANK.get());
        simpleItem(BdItems.ACACIA_FURNITURE_KIT.get());
        simpleItem(BdItems.BIRCH_PLANK.get());
        simpleItem(BdItems.BIRCH_FURNITURE_KIT.get());
        simpleItem(BdItems.CRIMSON_PLANK.get());
        simpleItem(BdItems.CRIMSON_FURNITURE_KIT.get());
        simpleItem(BdItems.DARK_OAK_PLANK.get());
        simpleItem(BdItems.DARK_OAK_FURNITURE_KIT.get());
        simpleItem(BdItems.JUNGLE_PLANK.get());
        simpleItem(BdItems.JUNGLE_FURNITURE_KIT.get());
        simpleItem(BdItems.OAK_PLANK.get());
        simpleItem(BdItems.OAK_FURNITURE_KIT.get());
        simpleItem(BdItems.SPRUCE_PLANK.get());
        simpleItem(BdItems.SPRUCE_FURNITURE_KIT.get());
        simpleItem(BdItems.WARPED_PLANK.get());
        simpleItem(BdItems.WARPED_FURNITURE_KIT.get());

        handheldItem(BdItems.IRON_CHISEL.get());
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.toString(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BuildersDelight.MODID, "item/" + item));
    }

    private ItemModelBuilder handheldItem(Item item) {
        return withExistingParent(item.toString(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BuildersDelight.MODID, "item/" + item));
    }
}
