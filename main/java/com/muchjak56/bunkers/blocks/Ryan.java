package com.muchjak56.bunkers.blocks;

import java.util.Random;

import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class Ryan extends BlockBase
{

	public Ryan(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setResistance(40.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(1.0F);
		setLightOpacity(1);
		
	}
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	     return ModItems.AE;
	    }

}
