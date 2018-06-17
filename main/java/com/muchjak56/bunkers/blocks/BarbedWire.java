package com.muchjak56.bunkers.blocks;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.blocks.blocktype.PillarType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BarbedWire extends PillarType
{
	
	
	
	public BarbedWire(String name, Material material) {
		super(name, material);
		
		
		
		setSoundType(SoundType.METAL);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setLightOpacity(1);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
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
    
    
    /**
     * Called When an Entity Collided with the Block
     */
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	entityIn.attackEntityFrom(DamageSource.GENERIC, 4.0F);
    	entityIn.motionX *= 0.00001D;
    	entityIn.motionY *= 0.00001D;
    	entityIn.motionZ *= 0.00001D;
    }
    
    
	
	
	
	
}
