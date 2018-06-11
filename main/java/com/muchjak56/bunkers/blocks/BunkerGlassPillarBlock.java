package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.blocks.blocktype.PillarType;
import com.muchjak56.bunkers.util.IHasModel;


import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

public class BunkerGlassPillarBlock extends PillarType {

	public BunkerGlassPillarBlock(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(0.0F);
		setLightOpacity(0);
		//setBlockUnbreakable();
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
	}

}
