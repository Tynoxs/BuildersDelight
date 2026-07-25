package com.tynoxs.buildersdelight.content.entity;

import com.tynoxs.buildersdelight.content.init.BdEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityAttachment;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.NetworkInitialization;

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
        if(!this.level().isClientSide)
        {
            if(this.getPassengers().isEmpty() || this.level().isEmptyBlock(this.source))
            {
                this.remove(RemovalReason.DISCARDED);
                this.level().updateNeighbourForOutputSignal(blockPosition(), this.level().getBlockState(blockPosition()).getBlock());
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_333664_) {}

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {}

    @Override
    public Vec3 getVehicleAttachmentPoint(Entity p_316322_) {
        return this.getAttachments().get(EntityAttachment.PASSENGER, 0, 0.0F);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {}

    @Override
    protected boolean canRide(Entity entity)
    {
        return true;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity p_352110_)
    {
        return super.getAddEntityPacket(p_352110_);
        //return NetworkHooks.getEntitySpawningPacket(this);
    }

    public static ItemInteractionResult create(Level level, BlockPos pos, double yOffset, Player player)
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
        return ItemInteractionResult.SUCCESS;
    }
}
