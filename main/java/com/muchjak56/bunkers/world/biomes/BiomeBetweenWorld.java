package com.muchjak56.bunkers.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeBetweenWorld extends Biome 
{
	public BiomeBetweenWorld() 
	{
		super(new BiomeProperties("BetweenWorld").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));
	}
}
