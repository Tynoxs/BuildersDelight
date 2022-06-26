package com.tynoxs.buildersdelight.content.gui.menus;

import com.google.common.collect.Lists;
import com.tynoxs.buildersdelight.content.init.BdContainers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import java.util.List;

@Mod.EventBusSubscriber
public class ContainerChisel extends AbstractContainerMenu {
    private final ContainerLevelAccess access;
    private FriendlyByteBuf friendlyByteBuf;
    public final Level level;
    final Slot inputSlot;
    final Slot resultSlot;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private List<StonecutterRecipe> recipes = Lists.newArrayList();
    private ItemStack input = ItemStack.EMPTY;
    long lastSoundTime;
    Runnable slotUpdateListener = () -> {
    };
    //Input slot = 1 Slot
    public final Container container = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            ContainerChisel.this.slotsChanged(this);
            ContainerChisel.this.slotUpdateListener.run();
        }
    };
    //Data slot, the slots you can select from = 28 Slots
    public final Container select = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            ContainerChisel.this.slotsChanged(this);
            ContainerChisel.this.slotUpdateListener.run();
        }
    };

    final ResultContainer resultContainer = new ResultContainer();

    public ContainerChisel(int id, Inventory inv, FriendlyByteBuf friendlyByteBuf) {
        this(id, inv, ContainerLevelAccess.NULL, friendlyByteBuf);
    }

    //This GUI gets opened by right-clicking the BdItems.iron_chisel
    public ContainerChisel(int id, Inventory inv, final ContainerLevelAccess access, FriendlyByteBuf friendlyByteBuf) {
        super(BdContainers.CHISEL_CONTAINER.get(), id);
        this.level = inv.player.level;
        this.access = access;
        this.friendlyByteBuf = friendlyByteBuf;
        //Input Slot, input cobblestone
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 28, 18));
        //Output Slot, output the block selected from one of the data slots
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 28, 45) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level, player, stack.getCount());
                ContainerChisel.this.resultContainer.awardUsedRecipes(player);
                ItemStack itemstack = ContainerChisel.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    ContainerChisel.this.setupResultSlot();
                }

                access.execute((p_40364_, p_40365_) -> {
                    long l = p_40364_.getGameTime();
                    if (ContainerChisel.this.lastSoundTime != l) {
                        p_40364_.playSound((Player) null, p_40365_, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        ContainerChisel.this.lastSoundTime = l;
                    }
                });
                super.onTake(player, stack);
            }
        });
        //player inventory
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 9; ++j)
                this.addSlot(new Slot(inv, j + (i + 1) * 9, 20 + j * 18, 114 + i * 18));
        //slots to select chiseled block from / data slots
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 7; ++j)
                this.addSlot(new Slot(select, 5,55 + j * 18,  18 + i * 18) {
                    public boolean mayPlace(ItemStack stack) {
                        return false;
                    }
                });
        //player hotbar
        for (int k = 0; k < 9; ++k)
            this.addSlot(new Slot(inv, k, 20 + k * 18, 172));

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    //This needs to be it's own Recipe Type, not StonecutterRecipe
    public List<StonecutterRecipe> getRecipes() {
        return this.recipes;
    }

    /**
     *
     * Also the recipe json should be something like this
     * input Blocks.OAK_PLANKS
     * output DataSlot 1 -> Blocks.OAK_PLANKS
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_1
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_2
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_3
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_4
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_5
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_6
     * output DataSlot 2 -> BdBlocks.OAK_PLANKS_7
     *
     */

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    public boolean stillValid(Player player) {
        return stillValid(this.access, player, Blocks.STONECUTTER);
    }

    public boolean clickMenuButton(Player player, int p_40310_) {
        if (this.isValidRecipeIndex(p_40310_)) {
            this.selectedRecipeIndex.set(p_40310_);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int p_40335_) {
        return p_40335_ >= 0 && p_40335_ < this.recipes.size();
    }

    public void slotsChanged(Container container) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(container, itemstack);
        }

    }

    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(RecipeType.STONECUTTING, container, this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            StonecutterRecipe stonecutterrecipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(stonecutterrecipe);
            this.resultSlot.set(stonecutterrecipe.assemble(this.container));
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public void registerUpdateListener(Runnable p_40324_) {
        this.slotUpdateListener = p_40324_;
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
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
            } else if (this.level.getRecipeManager().getRecipeFor(RecipeType.STONECUTTING, new SimpleContainer(itemstack1), this.level).isPresent()) {
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
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(player, this.container);
        });
    }
}