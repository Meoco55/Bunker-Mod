package com.muchjak56.bunkers.world.dimension.betweenworld;

import com.muchjak56.bunkers.init.BiomeInit;
import com.muchjak56.bunkers.init.DimensionInit;

import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionBetweenWorld extends WorldProvider
{
	public DimensionBetweenWorld()
	{
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.BETWEEN_WORLD_DIMENSION);
	}
	
	@Override
	public DimensionType getDimensionType() 
	{
		return DimensionInit.BETWEEN_WORLD;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() 
	{
		return new ChunkGeneratorBetweenWorld(world, false, world.getSeed());
	}
	
	@Override
	public boolean canRespawnHere() 
	{
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() 
	{
		return false;
	}
}
