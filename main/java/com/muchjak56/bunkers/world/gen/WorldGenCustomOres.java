package com.muchjak56.bunkers.world.gen;

import java.util.Random;


import com.muchjak56.bunkers.init.ModBlocks;
import com.muchjak56.bunkers.util.handlers.EnumHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator hardened_impurities,ultimum_ore,crono_crystal_formation,infernium_ore,unstable_matter,
						hardened_impurities2,ultimum_ore2,crono_crystal_formation2,unstable_matter2;
	
	
	public WorldGenCustomOres() 
	{
		
		hardened_impurities = new WorldGenMinable(ModBlocks.HARDENED_IMPURITIES_BLOCK.getDefaultState(), 11, BlockMatcher.forBlock(Blocks.STONE));
		ultimum_ore = new WorldGenMinable(ModBlocks.ULTIMUM_ORE_BLOCK.getDefaultState(), 3, BlockMatcher.forBlock(ModBlocks.HARDENED_IMPURITIES_BLOCK));
		crono_crystal_formation = new WorldGenMinable(ModBlocks.CRONO_CRYSTAL_FORMATION.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		infernium_ore = new WorldGenMinable(ModBlocks.INFERNIUM_ORE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.NETHERRACK));		
		unstable_matter = new WorldGenMinable(ModBlocks.UNSTABLE_MATTER.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		
		hardened_impurities2 = new WorldGenMinable(ModBlocks.HARDENED_IMPURITIES_BLOCK.getDefaultState(), 15, BlockMatcher.forBlock(Blocks.STONE));
		ultimum_ore2 = new WorldGenMinable(ModBlocks.ULTIMUM_ORE_BLOCK.getDefaultState(), 3, BlockMatcher.forBlock(ModBlocks.HARDENED_IMPURITIES_BLOCK));
		crono_crystal_formation2 = new WorldGenMinable(ModBlocks.CRONO_CRYSTAL_FORMATION.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));		
		unstable_matter2 = new WorldGenMinable(ModBlocks.UNSTABLE_MATTER.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE));
		
		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		
		
		//runGenerator("ore", world, random, chunkX, chunkZ, "Chance must be >=1", "Min Height", "Max Height");
		
		
		
		switch(world.provider.getDimension())
		{
		case -1:
			
			runGenerator(infernium_ore, world, random, chunkX, chunkZ, 50, 5, 100);
			
			
			break;
			
		case 0:
			
			runGenerator(hardened_impurities, world, random, chunkX, chunkZ, 10, 5, 10);
			runGenerator(ultimum_ore, world, random, chunkX, chunkZ, 50, 5, 10);
			runGenerator(crono_crystal_formation, world, random, chunkX, chunkZ, 5, 5, 25);
			runGenerator(unstable_matter, world, random, chunkX, chunkZ, 1, 10, 25);
			
			
			
			break;
			
		case 1:
			
			
			
			
			break;
			
			
			
		case 2:
			
			runGenerator(hardened_impurities2, world, random, chunkX, chunkZ, 50, 5, 120);
			runGenerator(ultimum_ore2, world, random, chunkX, chunkZ, 100, 5, 120);
			runGenerator(crono_crystal_formation2, world, random, chunkX, chunkZ, 15, 5, 120);
			runGenerator(unstable_matter2, world, random, chunkX, chunkZ, 10, 5, 120);
			
			
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
}