package com.muchjak56.bunkers.blocks.blocktype;

import java.util.Random;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DoorType extends BlockDoor implements IHasModel
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyEnum<BlockDoor.EnumHingePosition> HINGE = PropertyEnum.<BlockDoor.EnumHingePosition>create("hinge", BlockDoor.EnumHingePosition.class);
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    
	public DoorType(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(3.0F);
		setResistance(15.0F);
		setCreativeTab(Bunkers.bunkerblockstab);			
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));
		
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	 public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	    {
	        return isOpen(combineMetadata(worldIn, pos));
	    }

	    public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

	    private int getCloseSound()
	    {
	        return this.blockMaterial == Material.IRON ? 1011 : 1012;
	    }

	    private int getOpenSound()
	    {
	        return this.blockMaterial == Material.IRON ? 1005 : 1006;
	    }

	    /**
	     * Get the MapColor for this Block and the given BlockState
	     */
	    public MapColor getMapColor(IBlockState state, IBlockAccess p_180659_2_, BlockPos p_180659_3_)
	    {
	        if (state.getBlock() == ModBlocks.BUNKER_DOOR)
	        {
	            return MapColor.WOOD;
	        }
	        else
	        {
	            return state.getBlock() == Blocks.DARK_OAK_DOOR ? BlockPlanks.EnumType.DARK_OAK.getMapColor() : super.getMapColor(state, p_180659_2_, p_180659_3_);
	        }
	    }

	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY)
	    {
	        if (this.blockMaterial == Material.IRON)
	        {
	            return false;
	        }
	        else
	        {
	            BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
	            IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

	            if (iblockstate.getBlock() != this)
	            {
	                return false;
	            }
	            else
	            {
	                state = iblockstate.cycleProperty(OPEN);
	                worldIn.setBlockState(blockpos, state, 10);
	                worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
	                worldIn.playEvent(playerIn, ((Boolean)state.getValue(OPEN)).booleanValue() ? this.getOpenSound() : this.getCloseSound(), pos, 0);
	                return true;
	            }
	        }
	    }

	    public void toggleDoor(World worldIn, BlockPos pos, boolean open)
	    {
	        IBlockState iblockstate = worldIn.getBlockState(pos);

	        if (iblockstate.getBlock() == this)
	        {
	            BlockPos blockpos = iblockstate.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
	            IBlockState iblockstate1 = pos == blockpos ? iblockstate : worldIn.getBlockState(blockpos);

	            if (iblockstate1.getBlock() == this && ((Boolean)iblockstate1.getValue(OPEN)).booleanValue() != open)
	            {
	                worldIn.setBlockState(blockpos, iblockstate1.withProperty(OPEN, Boolean.valueOf(open)), 10);
	                worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
	                worldIn.playEvent((EntityPlayer)null, open ? this.getOpenSound() : this.getCloseSound(), pos, 0);
	            }
	        }
	    }

	    /**
	     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
	     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
	     * block, etc.
	     */
	    

	    

	    public EnumPushReaction getMobilityFlag(IBlockState state)
	    {
	        return EnumPushReaction.DESTROY;
	    }

	    public static int combineMetadata(IBlockAccess worldIn, BlockPos pos)
	    {
	        IBlockState iblockstate = worldIn.getBlockState(pos);
	        int i = iblockstate.getBlock().getMetaFromState(iblockstate);
	        boolean flag = isTop(i);
	        IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
	        int j = iblockstate1.getBlock().getMetaFromState(iblockstate1);
	        int k = flag ? j : i;
	        IBlockState iblockstate2 = worldIn.getBlockState(pos.up());
	        int l = iblockstate2.getBlock().getMetaFromState(iblockstate2);
	        int i1 = flag ? i : l;
	        boolean flag1 = (i1 & 1) != 0;
	        boolean flag2 = (i1 & 2) != 0;
	        return removeHalfBit(k) | (flag ? 8 : 0) | (flag1 ? 16 : 0) | (flag2 ? 32 : 0);
	    }

	    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return new ItemStack(this.getItem());
	    }

	    private Item getItem()
	    {
	        if (this == Blocks.IRON_DOOR)
	        {
	            return Items.IRON_DOOR;
	        }
	        else if (this == Blocks.SPRUCE_DOOR)
	        {
	            return Items.SPRUCE_DOOR;
	        }
	        else if (this == Blocks.BIRCH_DOOR)
	        {
	            return Items.BIRCH_DOOR;
	        }
	        else if (this == Blocks.JUNGLE_DOOR)
	        {
	            return Items.JUNGLE_DOOR;
	        }
	        else if (this == Blocks.ACACIA_DOOR)
	        {
	            return Items.ACACIA_DOOR;
	        }
	        else
	        {
	            return this == Blocks.DARK_OAK_DOOR ? Items.DARK_OAK_DOOR : Items.OAK_DOOR;
	        }
	    }

	    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	    {
	        BlockPos blockpos = pos.down();
	        BlockPos blockpos1 = pos.up();

	        if (player.capabilities.isCreativeMode && state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER && worldIn.getBlockState(blockpos).getBlock() == this)
	        {
	            worldIn.setBlockToAir(blockpos);
	        }

	        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER && worldIn.getBlockState(blockpos1).getBlock() == this)
	        {
	            if (player.capabilities.isCreativeMode)
	            {
	                worldIn.setBlockToAir(pos);
	            }

	            worldIn.setBlockToAir(blockpos1);
	        }
	    }

	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT;
	    }

	    /**
	     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
	     * metadata, such as fence connections.
	     */
	    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {
	        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER)
	        {
	            IBlockState iblockstate = worldIn.getBlockState(pos.up());

	            if (iblockstate.getBlock() == this)
	            {
	                state = state.withProperty(HINGE, iblockstate.getValue(HINGE)).withProperty(POWERED, iblockstate.getValue(POWERED));
	            }
	        }
	        else
	        {
	            IBlockState iblockstate1 = worldIn.getBlockState(pos.down());

	            if (iblockstate1.getBlock() == this)
	            {
	                state = state.withProperty(FACING, iblockstate1.getValue(FACING)).withProperty(OPEN, iblockstate1.getValue(OPEN));
	            }
	        }

	        return state;
	    }

	    

	    /**
	     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	     * blockstate.
	     */
	    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	    {
	        return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING))).cycleProperty(HINGE);
	    }

	    /**
	     * Convert the given metadata into a BlockState for this Block
	     */
	    public IBlockState getStateFromMeta(int meta)
	    {
	        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockDoor.EnumDoorHalf.UPPER).withProperty(HINGE, (meta & 1) > 0 ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState().withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER).withProperty(FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW()).withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;

	        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER)
	        {
	            i = i | 8;

	            if (state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT)
	            {
	                i |= 1;
	            }

	            if (((Boolean)state.getValue(POWERED)).booleanValue())
	            {
	                i |= 2;
	            }
	        }
	        else
	        {
	            i = i | ((EnumFacing)state.getValue(FACING)).rotateY().getHorizontalIndex();

	            if (((Boolean)state.getValue(OPEN)).booleanValue())
	            {
	                i |= 4;
	            }
	        }

	        return i;
	    }

	    protected static int removeHalfBit(int meta)
	    {
	        return meta & 7;
	    }

	    public static boolean isOpen(IBlockAccess worldIn, BlockPos pos)
	    {
	        return isOpen(combineMetadata(worldIn, pos));
	    }

	    public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos)
	    {
	        return getFacing(combineMetadata(worldIn, pos));
	    }

	    public static EnumFacing getFacing(int combinedMeta)
	    {
	        return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
	    }

	    protected static boolean isOpen(int combinedMeta)
	    {
	        return (combinedMeta & 4) != 0;
	    }

	    protected static boolean isTop(int meta)
	    {
	        return (meta & 8) != 0;
	    }

	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {HALF, FACING, OPEN, HINGE, POWERED});
	    }

	    public BlockFaceShape func_193383_a(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
	    {
	        return BlockFaceShape.UNDEFINED;
	    }

	    public static enum EnumDoorHalf implements IStringSerializable
	    {
	        UPPER,
	        LOWER;

	        public String toString()
	        {
	            return this.getName();
	        }

	        public String getName()
	        {
	            return this == UPPER ? "upper" : "lower";
	        }
	    }

	    public static enum EnumHingePosition implements IStringSerializable
	    {
	        LEFT,
	        RIGHT;

	        public String toString()
	        {
	            return this.getName();
	        }

	        public String getName()
	        {
	            return this == LEFT ? "left" : "right";
	        }
	    }

	    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
				int meta, EntityLivingBase placer) {
			
			return this.getStateFromMeta(meta);
		}
	 
	 
	 

	   
	@Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}	
	
}
