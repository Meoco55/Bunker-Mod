package com.muchjak56.bunkers.blocks.machine.nanowall;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NanoWallOn extends NanoWall
{
	final static PropertyInteger PARENT = PropertyInteger.create("parent", 0, 2);
	final static PropertyInteger POWER = PropertyInteger.create("power", 0, 3);
	
	public NanoWallOn(String name, boolean isOn, Material material) {
		super(name, true, material);
		setSoundType(SoundType.METAL);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);	
		setCreativeTab(null);
		
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
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	 @Override
	    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	    {
	    	
	    	entityIn.motionX = 0.0D;
	    	entityIn.motionY = 0.0D;
	    	entityIn.motionZ = 0.0D;
	    }
	 /*
	 public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos p_189540_5_)
	    {
	        if (!worldIn.isRemote)
	        {
	        if (this.POWER.equals(1)) {
	        changeNeighbors(worldIn, this.getDefaultState(), pos, 2);
	        }
	        }
	    }
	 private void changeNeighbors(World worldIn, IBlockState state, BlockPos pos, int prop) {
		 		 
		for(int x = -1; x>1; x ++) {
			for(int y = -1; y>1; y ++) {
				for(int z = -1; z>1; z ++) {
				if(worldIn.getBlockState(pos.add(x,y,z)) == ModBlocks.NANO_WALL.getDefaultState() && !worldIn.isRemote && worldIn.getBlockState(pos.add(x,y,z)).getValue(POWER) != 1) {
					worldIn.setBlockState(pos.add(x,y,z), state.withProperty(POWER, prop));
				}
				}}}
	
		 worldIn.setBlockState(pos.add(-1, 0, 0), state.withProperty(POWER, prop));
		 worldIn.setBlockState(pos.add(1, 0, 0), state.withProperty(POWER, prop));
		 worldIn.setBlockState(pos.add(0, -1, 0), state.withProperty(POWER, prop));
		 worldIn.setBlockState(pos.add(0, 1, 0), state.withProperty(POWER, prop));
		 worldIn.setBlockState(pos.add(0, 0, -1), state.withProperty(POWER, prop));
		 worldIn.setBlockState(pos.add(0, 0, 1), state.withProperty(POWER, prop));
	 }
	 */
}
