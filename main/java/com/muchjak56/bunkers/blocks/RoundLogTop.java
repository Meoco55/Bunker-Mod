package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RoundLogTop extends TorchType
{

	public RoundLogTop(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.WOOD);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("axe", 0);
		setLightOpacity(0);		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		return generateFlatAABB(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), state.getValue(FACING));
    }
	@Override
	 protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
		return true;
    }
	@Override
	protected boolean onNeighborChangeInternal(World worldIn, BlockPos pos, IBlockState state)
    {
		return true;
    }

}