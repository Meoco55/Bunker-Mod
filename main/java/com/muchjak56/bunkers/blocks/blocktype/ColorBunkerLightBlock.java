package com.muchjak56.bunkers.blocks.blocktype;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.blocks.BlockBase;
import com.muchjak56.bunkers.blocks.BunkerLightBlock;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ColorBunkerLightBlock extends BunkerLightBlock
{
	//sets face toward player
		public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public ColorBunkerLightBlock(String name, Material material) {
		super(name, material);				
		setSoundType(SoundType.GLASS);
		setHardness(2.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 0);
		setLightLevel(1.0F);
		setLightOpacity(0);
		setCreativeTab(Bunkers.bunkerdecortab);
		//setBlockUnbreakable();
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}		
}
