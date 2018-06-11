package com.muchjak56.bunkers.blocks.machine.xray;

import java.util.Random;

import com.muchjak56.bunkers.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class XrayOn extends XrayDevice
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public XrayOn(String name, boolean isOn, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);					
		setLightOpacity(0);
		setLightLevel(1.0F);
		setCreativeTab(null);
	}

    
}
