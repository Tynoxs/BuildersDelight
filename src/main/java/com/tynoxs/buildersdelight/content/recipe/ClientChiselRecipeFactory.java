package com.tynoxs.buildersdelight.content.recipe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.*;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Unit;
import org.slf4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ClientChiselRecipeFactory {

    private static final CompletableFuture<Unit> RESOURCE_RELOAD_INITIAL_TASK = CompletableFuture.completedFuture(Unit.INSTANCE);
    private static final Logger LOGGER = LogUtils.getLogger();

    private Minecraft minecraft;
    private ChiselRecipeFactory recipeFactory;
    private Gson gson;

    public ClientChiselRecipeFactory(ChiselRecipeFactory recipeFactory) {
        this.recipeFactory = recipeFactory;
        this.minecraft = Minecraft.getInstance();
        this.gson = new GsonBuilder().setPrettyPrinting().setPrettyPrinting().create();
    }

    public void loadClientRecipes(){
        ReloadableResourceManager resourceManager = new ReloadableResourceManager(PackType.SERVER_DATA);
        List<PackResources> list = minecraft.getResourcePackRepository().openAllSelected();
        ReloadInstance reloadInstance = resourceManager.createReload(Util.backgroundExecutor(),minecraft, RESOURCE_RELOAD_INITIAL_TASK,  list);
        while(!reloadInstance.isDone()){

        }

        recipeFactory.clear();

        for(var location : resourceManager.listResources("chisel", (p_10774_) -> {
            return p_10774_.getPath().endsWith(".json");
        }).entrySet()) {
            try {
                Optional<Resource> resource = resourceManager.getResource(location.getKey());

                try {
                    InputStream inputstream = resource.get().open();

                    try {
                        Reader reader = new BufferedReader(new InputStreamReader(inputstream, StandardCharsets.UTF_8));

                        try {
                            JsonElement jsonelement = GsonHelper.fromJson(this.gson, reader, JsonElement.class);
                            try {
                                ChiselRecipe recipe = recipeFactory.fromJson(location.getKey(), GsonHelper.convertToJsonObject(jsonelement, "top element"));
                                if (recipe == null) {
                                    LOGGER.info("Skipping loading recipe {} as it's serializer returned null", location);
                                    continue;
                                }
                                recipeFactory.getChiselRecipes().add(recipe);
                            } catch (IllegalArgumentException | JsonParseException jsonparseexception) {
                                LOGGER.error("Parsing error loading recipe {}", location, jsonparseexception);
                            }                        } catch (Throwable throwable3) {
                            try {
                                reader.close();
                            } catch (Throwable throwable2) {
                                throwable3.addSuppressed(throwable2);
                            }

                            throw throwable3;
                        }
                        reader.close();
                    } catch (Throwable throwable4) {
                        if (inputstream != null) {
                            try {
                                inputstream.close();
                            } catch (Throwable throwable1) {
                                throwable4.addSuppressed(throwable1);
                            }
                        }

                        throw throwable4;
                    }

                    if (inputstream != null) {
                        inputstream.close();
                    }
                } catch (Throwable throwable5) {
                    throw throwable5;
                }
            } catch (IllegalArgumentException | IOException | JsonParseException jsonparseexception) {
                LOGGER.error("Couldn't parse data file {}", location, jsonparseexception);
            }
        }
    }
}
