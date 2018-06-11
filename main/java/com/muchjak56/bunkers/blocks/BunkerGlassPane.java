package com.muchjak56.bunkers.blocks;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.blocks.blocktype.PaneType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BunkerGlassPane extends PaneType
{

	public BunkerGlassPane(String name, Material materialIn, boolean canDrop) {
		super(name, materialIn, canDrop);
		setSoundType(SoundType.GLASS);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setLightOpacity(0);
		setCreativeTab(Bunkers.bunkerblockstab);
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
	protected boolean canSilkHarvest()
    {
        return true;
    }

}
