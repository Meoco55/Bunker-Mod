package Tabs;

import com.muchjak56.bunkers.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class BunkerBlocksTab extends CreativeTabs 
{

	public BunkerBlocksTab(String label) 
		{
		super("bunkerblockstab");
		}

	
	public ItemStack getTabIconItem() 
		{
		return new ItemStack(Item.getItemFromBlock(ModBlocks.BUNKER_TRIM_CROWN_BLOCK));
		}
	
}