package com.muchjak56.bunkers.blocks;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.blocks.blocktype.WallType;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class EnergyFence extends WallType
{

	public EnergyFence(String name, Material material, Block modelBlock) {
		super(name, material, modelBlock);
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(Bunkers.bunkerdecortab);
		setLightOpacity(0);
	}
	public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(entityIn instanceof Entity && !(entityIn instanceof EntityPlayer)) 
    	{
			entityIn.attackEntityFrom(DamageSource.GENERIC, 4.0F);
			entityIn.motionX *= 0.00001D;
			entityIn.motionY *= 0.00001D;
			entityIn.motionZ *= 0.00001D;
    	}
    }
}
