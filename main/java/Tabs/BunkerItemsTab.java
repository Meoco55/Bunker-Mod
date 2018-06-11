package Tabs;

import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BunkerItemsTab extends CreativeTabs 
{
	public BunkerItemsTab(String label) 
	{
	super("bunkeritemstab");
	}


public ItemStack getTabIconItem() 
	{
	return new ItemStack(ModItems.HAMMER);
	}
}
