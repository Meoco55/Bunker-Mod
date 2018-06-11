package com.muchjak56.bunkers.Items.tools;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{

	public ToolPickaxe(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkeritemstab);
		
		ModItems.ITEMS.add(this);
	}
	
	
	@Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(this,0,"inventory");
	}

}
