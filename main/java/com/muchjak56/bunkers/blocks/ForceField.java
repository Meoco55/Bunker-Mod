package com.muchjak56.bunkers.blocks;




import javax.annotation.Nullable;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;
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

public class ForceField extends TorchType
{
	
	
	
	public ForceField(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.GLASS);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(0.0F);
		//setLightOpacity(0);
		//setBlockUnbreakable();
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		return generateFlatAABB(new AxisAlignedBB(0.0D, 0.9D, 0.0D, 1.0D, 1.0D, 1.0D), state.getValue(FACING));
    }
	
	
	
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	 {
		 
		 if(entityIn instanceof Entity && !(entityIn instanceof EntityPlayer)) 
		 {
			 switch (((EnumFacing)state.getValue(FACING)).getIndex())
			 {
			 	case 1: entityIn.motionZ = -0.3D; 
			 		break; 

			 	case 2: entityIn.motionZ = 0.3D; 
			 		break; 

			 	case 3: entityIn.motionX = -0.3D; 
			 		break;

			 	case 4: entityIn.motionX = 0.3D; 
			 		break;
			 	case 5: entityIn.motionY = 0.3D; 
			 		break;
			 	case 6: entityIn.motionY = -0.3D; 
		 		break;
			 }
		 }
		return;
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