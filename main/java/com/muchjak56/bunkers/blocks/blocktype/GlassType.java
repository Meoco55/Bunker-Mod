package com.muchjak56.bunkers.blocks.blocktype;

import java.util.Random;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

public class GlassType extends BlockBreakable implements IHasModel
{
    public GlassType(String name, Material materialIn, boolean ignoreSimilarity)
    {
        super(materialIn, ignoreSimilarity);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Bunkers.bunkerblockstab);
		setLightOpacity(1);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    protected boolean canSilkHarvest()
    {
        return true;
    }
    @Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
