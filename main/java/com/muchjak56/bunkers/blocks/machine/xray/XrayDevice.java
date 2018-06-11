package com.muchjak56.bunkers.blocks.machine.xray;

import java.util.Random;

import com.muchjak56.bunkers.blocks.BlockBase;
import com.muchjak56.bunkers.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class XrayDevice extends BlockBase
{
	//sets face toward player
			public static final PropertyDirection FACING = BlockHorizontal.FACING;
			
			 public XrayDevice(String name, Material material)
			    {
			        super(name, Material.IRON);
			        setSoundType(SoundType.METAL);
					setHardness(3.0F);
					setResistance(15.0F);
					setHarvestLevel("pickaxe", 2);					
					setLightOpacity(0);					
		
			this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		}
		public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT;
	    }

		public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
		{
			if (!worldIn.isRemote) 
	        {
	            if (worldIn.isBlockPowered(pos))
	            {
	                worldIn.setBlockState(pos, ModBlocks.XRAY_DEVICE_ON.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
	            }
	            else {
	            	worldIn.setBlockState(pos, ModBlocks.XRAY_DEVICE.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
	            }
	        }
		}
		
		public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos npos)
	    {
	        if (!worldIn.isRemote)
	        {
	           if (worldIn.isBlockPowered(pos))
	            {
	                worldIn.setBlockState(pos, ModBlocks.XRAY_DEVICE_ON.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
	            }
	           else {
	        	   worldIn.setBlockState(pos, ModBlocks.XRAY_DEVICE.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
	           }
	        }
	    }
	    public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getItemFromBlock(ModBlocks.XRAY_DEVICE);
	    }

	    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return new ItemStack(ModBlocks.XRAY_DEVICE);
	    }

	    protected ItemStack getSilkTouchDrop(IBlockState state)
	    {
	        return new ItemStack(ModBlocks.XRAY_DEVICE);
	    }
		@Override
		public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
		{
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
		}
		
		@Override
		public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
		{
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
		}
		
		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) 
		{
			return EnumBlockRenderType.MODEL;
		}
		
		@Override
		public IBlockState withRotation(IBlockState state, Rotation rot)
		{
			return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
		}
		
		@Override
		public IBlockState withMirror(IBlockState state, Mirror mirrorIn) 
		{
			return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
		}
		
		@Override
		protected BlockStateContainer createBlockState() 
		{
			return new BlockStateContainer(this, new IProperty[] {FACING});
		}
		
		@Override
		public IBlockState getStateFromMeta(int meta) 
		{
			EnumFacing facing = EnumFacing.getFront(meta);
			if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
			return this.getDefaultState().withProperty(FACING, facing);
		}
		
		@Override
		public int getMetaFromState(IBlockState state) 
		{
			return ((EnumFacing)state.getValue(FACING)).getIndex();
		}	
		

	}