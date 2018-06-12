package com.muchjak56.bunkers.blocks;

import java.util.Random;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SolarLight extends TorchType

{
	public SolarLight(String name, Material material) {
		super(name, material);		 
		setSoundType(SoundType.GLASS);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 0);		
		setLightOpacity(0);
		setLightLevel(1.0F);
	}
	@Override	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
      return generateTorchAABB(new AxisAlignedBB(0.4D, 0.0D, 0.4D, 0.6D, 1.0D, 0.6D), new AxisAlignedBB(0.4D, 0.0D, 1.0D, 0.6D, 1.0D, 0.6D), null, state.getValue(FACING));
    }	
	@Override
<<<<<<< HEAD
	public boolean canPlaceUpsideDown() {
		return false;
	}
=======
	 public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	    {
		 return;
	    }    
>>>>>>> muchjak56
}
