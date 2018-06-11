package Tabs;

import com.muchjak56.bunkers.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BunkerDecorTab extends CreativeTabs 
{

	public BunkerDecorTab(String label) 
		{
		super("bunkerdecortab");
		}

	
	public ItemStack getTabIconItem() 
		{
		return new ItemStack(Item.getItemFromBlock(ModBlocks.MOSAIC_BLOCK));
		}
	
}