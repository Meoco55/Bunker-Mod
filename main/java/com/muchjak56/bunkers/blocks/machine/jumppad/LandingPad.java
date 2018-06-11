package com.muchjak56.bunkers.blocks.machine.jumppad;

import java.util.Random;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LandingPad extends TorchType
{
	public LandingPad(String name, Material material) 
	{
	super(name, material);

	setSoundType(SoundType.CLOTH);
	setHardness(2.0F);
	setResistance(10.0F);
	setHarvestLevel("pickaxe", 0);
	//setLightLevel(0.0F);
	//setLightOpacity(0);
	//setBlockUnbreakable();
	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
}
@Override
public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
{
  return generateFlatAABB(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.2D, 1.0D), state.getValue(FACING));
}
 @Override
 public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
{
entityIn.fallDistance *= 0.1F;    
}
}
