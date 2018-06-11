package com.muchjak56.bunkers.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class UltimumOre extends BlockBase
{

	public UltimumOre(String name, Material material) {
		super(name, material);
		
		

		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setResistance(40.0F);
		setHarvestLevel("pickaxe", 3);
		//setLightLevel(1.0F);
		setLightOpacity(0);
		//setBlockUnbreakable();
	}

}