package com.muchjak56.bunkers.blocks;

import java.util.Random;

import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InferniumOre extends BlockBase
{

	public InferniumOre(String name, Material material) {
		super(name, material);
		
		

		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 5);		
		setLightOpacity(0);
		
	}
	 @Override
	 public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	    {
	        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
	        {
	            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
	        }

	        super.onEntityWalk(worldIn, pos, entityIn);
	    }
	 @Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	     return ModItems.INFERNIUM_SHARD;
	    }

}