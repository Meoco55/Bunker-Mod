package com.muchjak56.bunkers.blocks;

import java.util.Random;

import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class UnstableMatter extends BlockBase
{
	
	public UnstableMatter(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setResistance(40.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(0.0F);
		setLightOpacity(0);
		
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	     return ModItems.UNKNOWN_MATTER;
	    }
	
	
	
}
	
