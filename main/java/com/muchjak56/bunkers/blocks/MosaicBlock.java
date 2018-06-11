package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.Bunkers;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MosaicBlock extends BlockBase
{

	public MosaicBlock(String name, Material material) {
		super(name, material);
		
		

		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		
		setLightOpacity(0);
		setCreativeTab(Bunkers.bunkerdecortab);
	}

}
