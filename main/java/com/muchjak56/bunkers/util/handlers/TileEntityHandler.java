package com.muchjak56.bunkers.util.handlers;

import com.muchjak56.bunkers.blocks.machine.hyposmelter.TileEntityHypoSmelter;
import com.muchjak56.bunkers.blocks.machine.ultimumcharger.TileEntityUltimumCharger;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityHypoSmelter.class, "hypo_smelter");
		GameRegistry.registerTileEntity(TileEntityUltimumCharger.class, "ultimum_charger");
	}
}
