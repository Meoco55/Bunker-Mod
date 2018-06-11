package com.muchjak56.bunkers.blocks.blocktype;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class WallType extends BlockWall implements IHasModel
{

	public WallType(String name, Material material, Block modelBlock) {
		super(modelBlock);
		setUnlocalizedName(name);
		setRegistryName(name);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	@Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	@Override
	 public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
   {
		items.add(new ItemStack(this, 1));
   }

}
