package com.muchjak56.bunkers.util.handlers;

import com.muchjak56.bunkers.blocks.machine.hyposmelter.ContainerHypoSmelter;
import com.muchjak56.bunkers.blocks.machine.hyposmelter.GuiHypoSmelter;
import com.muchjak56.bunkers.blocks.machine.hyposmelter.TileEntityHypoSmelter;
import com.muchjak56.bunkers.blocks.machine.ultimumcharger.ContainerUltimumCharger;
import com.muchjak56.bunkers.blocks.machine.ultimumcharger.GuiUltimumCharger;
import com.muchjak56.bunkers.blocks.machine.ultimumcharger.TileEntityUltimumCharger;
import com.muchjak56.bunkers.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == Reference.GUI_HYPO_SMELTER) return new ContainerHypoSmelter(player.inventory, (TileEntityHypoSmelter)world.getTileEntity(new BlockPos(x,y,z)));		
		if(ID == Reference.GUI_ULTIMUM_CHARGER) return new ContainerUltimumCharger(player.inventory, (TileEntityUltimumCharger)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_HYPO_SMELTER) return new GuiHypoSmelter(player.inventory, (TileEntityHypoSmelter)world.getTileEntity(new BlockPos(x,y,z)));		
		if(ID == Reference.GUI_ULTIMUM_CHARGER) return new GuiUltimumCharger(player.inventory, (TileEntityUltimumCharger)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
		
		
	}
	

}