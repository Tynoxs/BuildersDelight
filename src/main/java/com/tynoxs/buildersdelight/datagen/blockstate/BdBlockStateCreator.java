package com.tynoxs.buildersdelight.datagen.blockstate;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.block.custom.BlockInteractive;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class BdBlockStateCreator extends BlockStateProvider {

    public BdBlockStateCreator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BuildersDelight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private @NotNull String name(Block block) {
        return key(block).getPath();
    }

    public void lampBlock(RedstoneLampBlock block, ResourceLocation textureLampOff, ResourceLocation textureLampOn) {
        ModelFile lampOff = models().cubeAll(name(block), textureLampOff);
        ModelFile lampOn = models().cubeAll(name(block) + "_lit", ResourceLocation.tryParse(textureLampOn + "_lit"));
        lampBlock(block, lampOff, lampOn);
    }

    public void lampBlock(RedstoneLampBlock block, ModelFile modelLampOff, ModelFile modelLampOn) {
        getVariantBuilder(block)
                .partialState().with(RedstoneLampBlock.LIT, true).addModels(new ConfiguredModel(modelLampOn))
                .partialState().with(RedstoneLampBlock.LIT, false).addModels(new ConfiguredModel(modelLampOff));
    }

    public void interactiveBlock(BlockInteractive block, ResourceLocation textureOff, ResourceLocation textureOn) {
        ModelFile blockOff = models().cubeAll(name(block), textureOff);
        ModelFile blockOn = models().cubeAll(name(block) + "_on", ResourceLocation.tryParse(textureOn + "_on"));
        interactiveBlock(block, blockOff, blockOn);
    }

    public void interactiveBlock(BlockInteractive block, ModelFile modelBlockOff, ModelFile modelBlockOn) {
        getVariantBuilder(block)
                .partialState().with(BlockInteractive.STATE, BlockInteractive.BlockInteractiveState.ON).addModels(new ConfiguredModel(modelBlockOn))
                .partialState().with(BlockInteractive.STATE, BlockInteractive.BlockInteractiveState.OFF).addModels(new ConfiguredModel(modelBlockOff));
    }

    public void topSideBlock(Block block, ResourceLocation side, ResourceLocation top) {
        horizontalBlock(block, models().cubeTop(name(block), side, ResourceLocation.tryParse(top + "_top")));
    }

    public void bdPaneBlock(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge) {
        bdPaneBlockInternal(block, key(block).toString(), pane, ResourceLocation.tryParse(edge + "_top"));
    }

    private void bdPaneBlockInternal(IronBarsBlock block, String baseName, ResourceLocation pane, ResourceLocation edge) {
        ModelFile post = models().panePost(baseName + "_post", pane, edge);
        ModelFile side = models().paneSide(baseName + "_side", pane, edge);
        ModelFile sideAlt = models().paneSideAlt(baseName + "_side_alt", pane, edge);
        ModelFile noSide = models().paneNoSide(baseName + "_noside", pane);
        ModelFile noSideAlt = models().paneNoSideAlt(baseName + "_noside_alt", pane);
        paneBlock(block, post, side, sideAlt, noSide, noSideAlt);
    }
}
