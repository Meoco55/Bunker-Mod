package com.muchjak56.bunkers.blocks.machine.jumppad;


import java.util.Random;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;
import com.muchjak56.bunkers.util.handlers.SoundsHandler;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JumpPad extends TorchType
{	
	public JumpPad(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.GLASS);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
      return generateFlatAABB(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.2D, 1.0D),state.getValue(FACING));
    }
	protected SoundEvent getSound()
    {
        return SoundsHandler.BLOCKS_JUMPPAD_WOOSH;
    }
	public double setStrength() {
		return 1.0D;
	}
	@Override
	 public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	 {
		 worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundsHandler.BLOCKS_JUMPPAD_WOOSH, SoundCategory.BLOCKS, 1.0F, 1.0F, true);
		 switch ((EnumFacing)state.getValue(FACING))
		 {
           case NORTH: entityIn.motionZ = setStrength() * -1; entityIn.fallDistance *= 0.1F;
           break; 
           case SOUTH: entityIn.motionZ = setStrength(); entityIn.fallDistance *= 0.1F;
           break; 
           case WEST: entityIn.motionX = setStrength() * -1; entityIn.fallDistance *= 0.1F;
           break;
           case EAST: entityIn.motionX = setStrength(); entityIn.fallDistance *= 0.1F;
           break;
           case DOWN: entityIn.motionY = setStrength() * -1; entityIn.fallDistance *= 0.1F;
           break;
           default: entityIn.motionY = setStrength(); entityIn.fallDistance *= 0.1F;
           break;
       }
		 return;
   }
	
	
    
		 
}