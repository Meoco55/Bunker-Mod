package com.muchjak56.bunkers.blocks.machine.hyposmelter.slots;

import com.muchjak56.bunkers.blocks.machine.hyposmelter.TileEntityHypoSmelter;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotHypoSmelterFuel extends Slot 
{
	public SlotHypoSmelterFuel(IInventory inventory, int Index, int x, int y)
	{
		super(inventory, Index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return TileEntityHypoSmelter.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack)
	{
		return super.getItemStackLimit(stack);
	}
}
