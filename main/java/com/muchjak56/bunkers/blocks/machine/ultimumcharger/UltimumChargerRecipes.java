package com.muchjak56.bunkers.blocks.machine.ultimumcharger;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class UltimumChargerRecipes 
{	
	private static final UltimumChargerRecipes INSTANCE = new UltimumChargerRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static UltimumChargerRecipes getInstance()
	{
		return INSTANCE;
	}
	
	
	/*this is where new recipes go,  input items MUST!!! be from the same mod.
	* the setup is as follows
	* add(smelted item) add (smelted item) return or get (output item)
	*/
	private UltimumChargerRecipes() 
	{
		addUltimumRecipe(new ItemStack(ModItems.CUT_STONE), new ItemStack(ModItems.MORTAR), new ItemStack(ModBlocks.MOSAIC_BLOCK), 5.0F);
		addUltimumRecipe(new ItemStack(ModItems.CRONO_ULTIMUM_PICKAXE), new ItemStack(ModItems.INFERNIUM_ULTIMUM_PICKAXE), new ItemStack(ModItems.CRONO_INFERNIUM_ULTIMUM_PICKAXE), 5.0F);
		addUltimumRecipe(new ItemStack(ModItems.CRONO_ULTIMUM_SWORD), new ItemStack(ModItems.INFERNIUM_ULTIMUM_SWORD), new ItemStack(ModItems.CRONO_INFERNIUM_ULTIMUM_SWORD), 5.0F);
		
	}

	//this inputs recipe
	public void addUltimumRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getUltimumResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	//this gets output or results
	public ItemStack getUltimumResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	//this is a true false to check the items used
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getSinteringExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}