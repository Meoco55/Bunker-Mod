package com.muchjak56.bunkers.blocks;

import java.util.Random;

import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.handlers.SoundsHandler;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CronoCrystalFormation extends BlockBase
{

	public CronoCrystalFormation(String name, Material material) {
		super(name, material);
		
		

		setSoundType(SoundType.GLASS);
		setHardness(3.0F);
		setResistance(40.0F);
		setHarvestLevel("pickaxe", 4);
		setLightLevel(1.0F);
		setLightOpacity(1);
		//setBlockUnbreakable();
		
	}
	public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.1D, 0.1D, 0.1D, 0.9D, 0.9D, 0.9D);
	}
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	     return ModItems.CRONO_CRYSTAL;
	    }
	       

    protected boolean canSilkHarvest()
    {
        return true;
    }
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {            
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
            double d2 = (double)pos.getZ() + 0.5D;
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;

            if (rand.nextDouble() < 0.1D)
            {
                worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundsHandler.BLOCKS_CRONO_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
    }
                
}