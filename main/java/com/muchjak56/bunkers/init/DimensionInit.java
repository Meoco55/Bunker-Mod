package com.muchjak56.bunkers.init;

import com.muchjak56.bunkers.world.dimension.betweenworld.DimensionBetweenWorld;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;


public class DimensionInit
{
	public static final DimensionType BETWEEN_WORLD = DimensionType.register("BetweenWorld", "_between_world", 2, DimensionBetweenWorld.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(2, BETWEEN_WORLD);
	}
}