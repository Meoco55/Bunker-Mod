package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.Bunkers;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class CatWalk extends BlockBase 
{
	 
	public CatWalk(String name, Material material) {
		super(name, material);
		
		setLightOpacity(1);
		setSoundType(SoundType.METAL);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	}
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    

    protected boolean canSilkHarvest()
    {
        return true;
    }
    

}
