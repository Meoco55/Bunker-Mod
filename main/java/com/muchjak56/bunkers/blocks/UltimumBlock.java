package com.muchjak56.bunkers.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class UltimumBlock extends BlockBase
{

	public UltimumBlock(String name, Material material) {
		super(name, material);
		
		

		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(0.0F);
		setLightOpacity(0);
		//setBlockUnbreakable();
	}
	
	

}