package com.muchjak56.bunkers.blocks.blocktype;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.blocks.BlockBase;

import net.minecraft.block.material.Material;

public class ColorBlockBase extends BlockBase
{

	public ColorBlockBase(String name, Material material) {
		super(name, material);
		setHardness(3.0F);
		setResistance(15.0F);
		setCreativeTab(Bunkers.bunkerdecortab);
	}

}
