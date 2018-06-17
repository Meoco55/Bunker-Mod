package com.muchjak56.bunkers.blocks;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Skewers extends TorchType
{

	public Skewers(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);		
		setLightOpacity(1);
	}
	@Override
	 protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
	    {
		 return false;
	    }
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
    	return generateTorchAABB(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),new AxisAlignedBB(0.0, 0.0, 0.5, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D), state.getValue(FACING));
    }
	public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	 @Nullable
	    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return NULL_AABB;
	    }
	

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	
    	entityIn.attackEntityFrom(DamageSource.GENERIC, 2.0F);
    }
}
