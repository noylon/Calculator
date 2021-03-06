package sonar.calculator.mod.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import sonar.calculator.mod.common.tileentity.misc.TileEntityReinforcedChest;
import sonar.core.api.inventories.StoredItemStack;
import sonar.core.inventory.ContainerLargeInventory;
import sonar.core.inventory.slots.SlotLarge;

public class ContainerReinforcedChest extends ContainerLargeInventory {
	private TileEntityReinforcedChest entity;

	public ContainerReinforcedChest(EntityPlayer player, TileEntityReinforcedChest entity) {
		super(entity);
		this.entity = entity;
		entity.openInventory(player);
		int i = -18;
		int j;
		int k;

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new SlotLarge(entity.getTileInv(), k + j * 9, 8 + k * 18, 24 + j * 18));
			}
		}

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 102 + j * 18 + i));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 160 + i));
		}
	}

	public boolean canInteractWith(EntityPlayer player) {
		return this.entity.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotID) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			if (slot instanceof SlotLarge) {
				StoredItemStack stored = entity.getTileInv().buildItemStack(entity.getTileInv().slots[slotID]);
				itemstack1 = stored.copy().setStackSize(Math.min(stored.stored, stored.getItemStack().getMaxStackSize())).getFullStack();
			}
			itemstack = itemstack1.copy();
			if (slotID < 27) {
				if (!this.mergeItemStack(itemstack1, 3 * 9, this.inventorySlots.size(), true)) {
					return null;
				}
				StoredItemStack stored = entity.getTileInv().buildItemStack(entity.getTileInv().slots[slotID]);
				stored.stored -= itemstack.stackSize - itemstack1.stackSize;
				if (stored.stored == 0) {
					entity.getTileInv().slots[slotID] = null;
				}
				entity.getTileInv().slots[slotID] = entity.getTileInv().buildArrayList(stored);
				return null;
			} else if (!this.mergeSpecial(itemstack1, 0, 3 * 9, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		this.entity.closeInventory(player);
	}
}