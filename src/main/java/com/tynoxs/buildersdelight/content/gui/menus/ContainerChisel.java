package com.tynoxs.buildersdelight.content.gui.menus;

import com.tynoxs.buildersdelight.content.init.BdContainers;
import com.tynoxs.buildersdelight.content.init.BdSounds;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipeFactory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ContainerChisel extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private final Slot inputSlot;
    private final Slot resultSlot;

    private Container chisel;

    private ChiselRecipeFactory recipeFactory = ChiselRecipeFactory.get();
    private boolean toggle;

    public ContainerChisel(int id, Inventory inv, FriendlyByteBuf friendlyByteBuf) {
        this(id, inv, ContainerLevelAccess.NULL, new SimpleContainer(30));

    }
    private List<Slot> variantsSlots = new ArrayList<>();

    private Inventory pPlayerInventory;

    //This GUI gets opened by right-clicking the BdItems.iron_chisel
    public ContainerChisel(int id, Inventory pPlayerInventory, final ContainerLevelAccess access, SimpleContainer pContainer) {
        super(BdContainers.CHISEL_CONTAINER.get(), id);
        this.chisel = pContainer;
        this.pPlayerInventory = pPlayerInventory;
        pContainer.startOpen(pPlayerInventory.player);
        this.access = access;

        //Variants slots
        int index =0;
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 7; ++j) {
                Slot slot = new Slot(pContainer, index, 55 + j * 18, 18 + i * 18){
                    @Override
                    public boolean mayPlace(ItemStack pStack) {
                        return false;
                    }

                    @Override
                    public boolean mayPickup(Player pPlayer) {
                        if(!ContainerChisel.this.resultSlot.hasItem()){
                            ContainerChisel.this.craftVariant(this.getItem());

                            //play sound after chiseling
                            Level world = pPlayer.level;
                            if (!world.isClientSide) {
                                world.playSound(null, pPlayer, BdSounds.CHISELING_SOUND.get(), SoundSource.PLAYERS, 1f, 1f);
                            }
                        }
                        return false;
                    }
                };
                variantsSlots.add(slot);
                this.addSlot(slot);
                index+=1;
            }
        }


        this.inputSlot = this.addSlot(new Slot(pContainer, index, 28, 18){
            @Override
            public boolean mayPlace(ItemStack pStack) {
                return true;
            }

            @Override
            public void setChanged() {
                super.setChanged();
                ItemStack itemstack = ContainerChisel.this.inputSlot.getItem();
                updateVariants(itemstack);
            }
        });

        this.resultSlot = this.addSlot(new Slot(pContainer, index+1, 28, 45) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });

        //Player inv slots
        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(pPlayerInventory, i1 + k * 9 + 9, 20 + i1 * 18, 114 + k * 18));
            }
        }

        //Hotbar slots
        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(pPlayerInventory, l, 20 + l * 18, 172));
        }
    }

    private void updateVariants(ItemStack input) {
        if(input == ItemStack.EMPTY){
            for(int i = 0; i < 28; i++){
                slots.get(i).set(input);

            }
        }
        List<ItemStack> recipe = recipeFactory.getVariants(input);

        int slotIndex =0;
        for(ItemStack variant :recipe){
            slots.get(slotIndex).set(variant);
            slotIndex+=1;
        }
        this.broadcastChanges();
    }

    public void craftVariant(ItemStack variantItem){
        int count = ContainerChisel.this.inputSlot.getItem().getCount();
        ItemStack newStack = new ItemStack(variantItem.getItem(), count);

        if(toggle) {
            for (ItemStack stack : this.pPlayerInventory.items) {
                if (stack != ItemStack.EMPTY && stack.getItem() == this.inputSlot.getItem().getItem()) {
                    int slot = pPlayerInventory.findSlotMatchingUnusedItem(stack);
                    int stackCount = stack.getCount();
                    ItemStack newInvStack = new ItemStack(variantItem.getItem(), stackCount);
                    pPlayerInventory.setItem(slot, newInvStack);
                }
            }
        }
        ContainerChisel.this.resultSlot.set(newStack);
        ContainerChisel.this.inputSlot.set(ItemStack.EMPTY);
        ContainerChisel.this.updateVariants(ItemStack.EMPTY);
        ContainerChisel.this.broadcastChanges();
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot != resultSlot && super.canTakeItemForPickAll(stack, slot);
    }

    public ItemStack quickMoveStack(Player player, int p_40329_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_40329_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (p_40329_ == 1) {
                item.onCraftedBy(itemstack1, player.level, player);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_40329_ == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (recipeFactory.hasVariants(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_40329_ >= 2 && p_40329_ < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_40329_ >= 29 && p_40329_ < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }


    public void removed(Player player) {
        super.removed(player);
        if(this.resultSlot.hasItem()){
            if (player instanceof ServerPlayer) {
                player.getInventory().placeItemBackInInventory(this.chisel.removeItemNoUpdate(resultSlot.index));
            }
        }

        if(this.inputSlot.hasItem()){
            if (player instanceof ServerPlayer) {
                player.getInventory().placeItemBackInInventory(this.chisel.removeItemNoUpdate(inputSlot.index));
            }
        }

    }

    @Override
    public boolean clickMenuButton(Player pPlayer, int pId) {
        if(pId == 0){
            toggle = false;
        }else if(pId == 1){
            toggle = true;
        }
        return super.clickMenuButton(pPlayer, pId);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }


}