package com.muchjak56.bunkers.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AntiUltimumOre extends BlockBase
{

	public AntiUltimumOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(60.0F);
		setHarvestLevel("pickaxe", 7);
		setLightOpacity(0);
	}

}