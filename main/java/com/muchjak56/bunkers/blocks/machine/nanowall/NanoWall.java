package com.muchjak56.bunkers.blocks.machine.nanowall;

import java.util.Random;

import com.muchjak56.bunkers.blocks.BlockBase;
import com.muchjak56.bunkers.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NanoWall extends BlockBase 
{
	private final boolean isOn;
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 3);
	
    public NanoWall(String name, boolean isOn, Material material)
    {
        super(name, Material.IRON);
        this.isOn = isOn;
        setSoundType(SoundType.METAL);
		setHardness(3.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);					
			

        if (isOn)
        {
            this.setLightLevel(0.0F);
        }
    }
    
    
    
    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.NANO_WALL.getDefaultState(), 2);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.NANO_WALL_ON.getDefaultState(), 2);
            }
            
           
        }
        
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos p_189540_5_)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.NANO_WALL_ON.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, ModBlocks.NANO_WALL.getDefaultState(), 2);
            }
        }
    }
    
    

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.NANO_WALL);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.NANO_WALL);
    }

    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(ModBlocks.NANO_WALL);
    }
}
