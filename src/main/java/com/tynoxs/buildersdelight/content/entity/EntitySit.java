package com.tynoxs.buildersdelight.content.entity;

import com.tynoxs.buildersdelight.content.init.BdEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EntitySit extends Entity {

    private BlockPos source;

    public EntitySit(Level level)
    {
        super(BdEntities.SIT.get(), level);
        this.noPhysics = true;
    }

    private EntitySit(Level level, BlockPos source, double yOffset)
    {
        this(level);
        this.source = source;
        this.setPos(source.getX() + 0.5, source.getY() + yOffset, source.getZ() + 0.5);
    }

    @Override
    public void tick()
    {
        super.tick();
        if(this.source == null)
        {
            this.source = this.blockPosition();
        }
        if(!this.level.isClientSide)
        {
            if(this.getPassengers().isEmpty() || this.level.isEmptyBlock(this.source))
            {
                this.remove(RemovalReason.DISCARDED);
                this.level.updateNeighbourForOutputSignal(blockPosition(), this.level.getBlockState(blockPosition()).getBlock());
            }
        }
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {}

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {}

    @Override
    public double getPassengersRidingOffset()
    {
        return 0.0;
    }

    @Override
    protected boolean canRide(Entity entity)
    {
        return true;
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public static InteractionResult create(Level level, BlockPos pos, double yOffset, Player player)
    {
        if(!level.isClientSide())
        {
            List<EntitySit> seats = level.getEntitiesOfClass(EntitySit.class, new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0));
            if(seats.isEmpty())
            {
                EntitySit seat = new EntitySit(level, pos, yOffset);
                level.addFreshEntity(seat);
                player.startRiding(seat, false);

            }
        }
        return InteractionResult.SUCCESS;
    }
}