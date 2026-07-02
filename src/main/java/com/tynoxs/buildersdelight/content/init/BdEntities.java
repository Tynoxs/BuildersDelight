package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.entity.EntitySit;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BdEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BuildersDelight.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySit>> SIT = register("sit", 
    EntityType.Builder.<EntitySit>of((type, world) -> new EntitySit(world), MobCategory.MISC)
            .sized(0.0F, 0.0F)
            //.setCustomClientFactory((spawnEntity, world) -> new EntitySit(world))
        );

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.Builder<T> builder)
    {
        return ENTITIES.register(name, () -> builder.build(name));
    }

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
