package com.muchjak56.bunkers.Items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Hammer extends ItemBase 
{

	public Hammer(String name) {
		super(name);
		
		
		setMaxDamage(100);
		maxStackSize = 1;
		setContainerItem(this);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 50;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
		return 2.0F;
	}

}
