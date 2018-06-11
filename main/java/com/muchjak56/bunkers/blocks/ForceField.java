package com.muchjak56.bunkers.blocks;




import javax.annotation.Nullable;

import com.muchjak56.bunkers.util.handlers.SoundsHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ForceField extends BlockBase
{
	
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
		protected static final AxisAlignedBB TORCH_NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.9D, 1.0D, 1.0D, 1.0D);
		protected static final AxisAlignedBB TORCH_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1D);
		protected static final AxisAlignedBB TORCH_WEST_AABB = new AxisAlignedBB(1.0D, 0.0D, 0.0D, 0.9D, 1.0D, 1.0D);
		protected static final AxisAlignedBB TORCH_EAST_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D);
		
	
		
	
	
	public ForceField(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.GLASS);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(0.0F);
		//setLightOpacity(0);
		//setBlockUnbreakable();
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                return TORCH_EAST_AABB;

            case WEST:
                return TORCH_WEST_AABB;

            case SOUTH:
                return TORCH_SOUTH_AABB;

            case NORTH:
                return TORCH_NORTH_AABB;

            default:
                return null;
        }
        
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!worldIn.isRemote) 
        {
           IBlockState north = worldIn.getBlockState(pos.north());
           IBlockState south = worldIn.getBlockState(pos.south());
           IBlockState west = worldIn.getBlockState(pos.west());
           IBlockState east = worldIn.getBlockState(pos.east());
           EnumFacing face = (EnumFacing)state.getValue(FACING);
           
           if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
           else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
           else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
           else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
           worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
       }
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
	
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	protected SoundEvent getSound()
    {
        return SoundsHandler.BLOCKS_FORCEFIELD_HUM;
    }
	
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	 {
		 
		 if(entityIn instanceof Entity && !(entityIn instanceof EntityPlayer)) 
		 {
			 switch (((EnumFacing)state.getValue(FACING)).getIndex())
			 {
			 	case 2: entityIn.motionZ = -0.3D; 
			 		break; 

			 	case 3: entityIn.motionZ = 0.3D; 
			 		break; 

			 	case 4: entityIn.motionX = -0.3D; 
			 		break;

			 	case 5: entityIn.motionX = 0.3D; 
			 		break;
			 	default: entityIn.motionY = 0.3D; 
			 		break;
			 }
		 }
		return;
	 }
}