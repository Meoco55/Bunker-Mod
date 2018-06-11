package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.blocks.blocktype.TorchType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class UltimumTorch extends TorchType {

	public UltimumTorch(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(1.0F);
		setLightOpacity(0);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	}
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
      return generateTorchAABB(new AxisAlignedBB(0.4,0,0.4,0.6,0.6,0.6),new AxisAlignedBB(0.35,0.2,0.7,0.65,0.8,1), null, state.getValue(FACING));
    }
}
