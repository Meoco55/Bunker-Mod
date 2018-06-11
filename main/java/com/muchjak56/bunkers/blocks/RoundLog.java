package com.muchjak56.bunkers.blocks;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.Items.tools.ToolAxe;
import com.muchjak56.bunkers.blocks.blocktype.PillarType;
import com.muchjak56.bunkers.blocks.blocktype.TorchType;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RoundLog extends PillarType {

	public RoundLog(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.WOOD);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("axe", 0);
		//setLightLevel(0.0F);
		setLightOpacity(0);
		//setBlockUnbreakable();
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }
	@Override
	 public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}