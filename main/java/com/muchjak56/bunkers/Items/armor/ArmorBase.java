package com.muchjak56.bunkers.Items.armor;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ArmorBase extends ItemArmor implements IHasModel
{
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkeritemstab);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(this, 0, "inventory");
	}
}