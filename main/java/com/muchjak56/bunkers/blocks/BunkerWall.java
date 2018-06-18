package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.blocks.blocktype.WallType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BunkerWall extends WallType
{

	public BunkerWall(String name, Material material, Block modelBlock) {
		super(name, material, modelBlock);
		setSoundType(SoundType.STONE);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(Bunkers.bunkerblockstab);
		setLightOpacity(0);
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
}
