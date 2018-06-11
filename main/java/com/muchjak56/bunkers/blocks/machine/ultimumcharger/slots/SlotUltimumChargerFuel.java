package com.muchjak56.bunkers.blocks.machine.ultimumcharger.slots;



import com.muchjak56.bunkers.blocks.machine.ultimumcharger.TileEntityUltimumCharger;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotUltimumChargerFuel extends Slot 
{
	public SlotUltimumChargerFuel(IInventory inventory, int Index, int x, int y)
	{
		super(inventory, Index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return TileEntityUltimumCharger.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack)
	{
		return super.getItemStackLimit(stack);
	}
}
