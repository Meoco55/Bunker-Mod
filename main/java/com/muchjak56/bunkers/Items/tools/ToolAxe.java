package com.muchjak56.bunkers.Items.tools;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel
{

	public ToolAxe(String name, ToolMaterial material) 
	{
		super(material, 8.0F, 3.2F);
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