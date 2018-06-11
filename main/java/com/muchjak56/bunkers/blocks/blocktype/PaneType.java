package com.muchjak56.bunkers.blocks.blocktype;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PaneType extends BlockPane implements IHasModel
{
	
	private final boolean canDrop;
	
	public PaneType(String name, Material materialIn, boolean canDrop) {
		super(materialIn, canDrop);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkerblockstab);
		setLightOpacity(1);
		setHardness(3.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		this.canDrop = canDrop;
										
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
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
