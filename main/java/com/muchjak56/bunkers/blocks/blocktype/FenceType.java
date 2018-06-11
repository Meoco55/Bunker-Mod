package com.muchjak56.bunkers.blocks.blocktype;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FenceType extends BlockFence implements IHasModel
{

	public FenceType(String name, Material materialIn, MapColor mapColorIn) {
		super( materialIn, mapColorIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkerblockstab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Bunkers.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		
		return this.getStateFromMeta(meta);
	}


}
