package com.muchjak56.bunkers.blocks.blocktype;

import com.google.common.base.Predicate;
import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TorchType extends Block implements IHasModel
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(@Nullable EnumFacing face)
        {
            return face != null;
        }
    });
    public TorchType(String name, Material material)
    {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkerblockstab);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	public boolean canPlaceUpsideDown() {
		return true;
	}
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    private boolean canPlaceOn(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);
        return state.getBlock().canPlaceTorchOnTop(state, worldIn, pos);
    }
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : FACING.getAllowedValues())
        {
            if (this.canPlaceAt(worldIn, pos, enumfacing))
            {
            	if(enumfacing == EnumFacing.DOWN && !canPlaceUpsideDown()) {
            		return false;
            	}
            	
                return true;
            }
        }
        return false;
    }
    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing)
    {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        IBlockState iblockstate = worldIn.getBlockState(blockpos);
        Block block = iblockstate.getBlock();
        BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, facing);

        if (this.canPlaceOn(worldIn, blockpos))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (this.canPlaceAt(worldIn, pos, facing))
        {
            return this.getDefaultState().withProperty(FACING, facing);
        }
        else
        {
            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (this.canPlaceAt(worldIn, pos, enumfacing))
                {
                    return this.getDefaultState().withProperty(FACING, enumfacing);
                }
            }
            return this.getDefaultState();
        }
    }
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.checkForDrop(worldIn, pos, state);
    }
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        this.onNeighborChangeInternal(worldIn, pos, state);
    }
    protected boolean onNeighborChangeInternal(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.checkForDrop(worldIn, pos, state))
        {
            return true;
        }
        else
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            EnumFacing.Axis enumfacing$axis = enumfacing.getAxis();
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            BlockPos blockpos = pos.offset(enumfacing1);
            boolean flag = false;

            if (enumfacing$axis.isHorizontal() && worldIn.getBlockState(blockpos).getBlockFaceShape(worldIn, blockpos, enumfacing) != BlockFaceShape.SOLID)
            {
                flag = true;
            }
            else if (enumfacing$axis.isVertical() && !this.canPlaceOn(worldIn, blockpos))
            {
                flag = true;
            }

            if (flag)
            {
                this.dropBlockAsItem(worldIn, pos, state, 0);
                worldIn.setBlockToAir(pos);
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this && this.canPlaceAt(worldIn, pos, (EnumFacing)state.getValue(FACING)))
        {
            return true;
        }
        else
        {
            if (worldIn.getBlockState(pos).getBlock() == this)
            {
                this.dropBlockAsItem(worldIn, pos, state, 0);
                worldIn.setBlockToAir(pos);
            }
            return false;
        }
    }
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();
        switch (meta)
        {
            case 1:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
                break;
            case 3:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
                break;
            case 5:
            	iblockstate = iblockstate.withProperty(FACING, EnumFacing.DOWN);
            	break;
            default:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
        }
        return iblockstate;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                i = i | 1;
                break;
            case WEST:
                i = i | 2;
                break;
            case SOUTH:
                i = i | 3;
                break;
            case NORTH:
                i = i | 4;
                break;
            case DOWN:
            	i = i | 5;
            	break;
            case UP:
            default:
                i = i | 6;
        }
        return i;
    }
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	@Override
	public void registerModels() {
		Bunkers.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
      return NULL_AABB;
    }
	public static AxisAlignedBB generateFlatAABB(AxisAlignedBB defAABB, EnumFacing face) {
		double x1 = defAABB.minX;
		double y1 = defAABB.minY;
		double z1 = defAABB.minZ;
		double x2 = defAABB.maxX;
		double y2 = defAABB.maxY;
		double z2 = defAABB.maxZ;
		switch(face) {
		case EAST:
		return new AxisAlignedBB(x1, (1-z1), y1, y2, (1-x2), z2);
		case SOUTH:
		return new AxisAlignedBB(x1,(1-z1),y1,x2,(1-z2),y2);
		case WEST:
		return new AxisAlignedBB((1-y1), x1, z1, (1-y2), x2, z2);
		case NORTH:
		return new AxisAlignedBB(x1,z1,(1-y1),x2,z2,(1-y2));
		case DOWN:
		return new AxisAlignedBB(x1,(1-y1),(1-z1),x2,(1-y2),(1-z2));
		default:
		return defAABB;
		}
		}
	
	public static AxisAlignedBB generateTorchAABB(AxisAlignedBB Up, AxisAlignedBB North, AxisAlignedBB Down, EnumFacing face) {
		double nx1 = North.minX;
		double ny1 = North.minY;
		double nz1 = North.minZ;
		double nx2 = North.maxX;
		double ny2 = North.maxY;
		double nz2 = North.maxZ;
		double ux1 = Up.minX;
		double uy1 = Up.minY;
		double uz1 = Up.minZ;
		double ux2 = Up.maxX;
		double uy2 = Up.maxY;
		double uz2 = Up.maxZ;
		switch(face) {
		case NORTH:
		return North;
		case SOUTH:
		return new AxisAlignedBB(nx1,ny1,(1-nz1),nx2,ny2,(1-nz2));
		case EAST:
		return new AxisAlignedBB((1-nz1),ny1,nx1,(1-nz2),ny2,nx2);
		case WEST:
		return new AxisAlignedBB(nz1,ny1,(1-nx1),nz2,ny2,(1-nx2));
		case DOWN:
		if(Down == null) {
		return new AxisAlignedBB((1-ux1),(1-uy1),(1-uz1),(1-ux2),(1-uy2),(1-uz2));
		}
		return Down;
		default:
		return Up;
		}
	}	
}