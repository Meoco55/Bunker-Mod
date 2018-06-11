package com.muchjak56.bunkers.blocks.blocktype;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class StairType extends BlockStairs implements IHasModel
{
	
	public StairType(String name, Material material, IBlockState modelState) {
		super(modelState);	
		this.useNeighborBrightness = true;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkerblockstab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	@Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
