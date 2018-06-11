package com.muchjak56.bunkers.util.handlers;

import com.muchjak56.bunkers.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler 
{
	public static SoundEvent BLOCKS_JUMPPAD_AMBIENT, BLOCKS_JUMPPAD_WOOSH, BLOCKS_FORCEFIELD_HUM, BLOCKS_CRONO_AMBIENT;
	
	public static void registerSounds()
	{
		BLOCKS_JUMPPAD_AMBIENT = registerSound("blocks.jumppad.ambient");
		BLOCKS_JUMPPAD_WOOSH = registerSound("blocks.jumppad.woosh");
		BLOCKS_FORCEFIELD_HUM = registerSound("blocks.forcefield.hum");
		BLOCKS_CRONO_AMBIENT = registerSound("blocks.crono.ambient");
	}
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
