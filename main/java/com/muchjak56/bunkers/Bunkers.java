package com.muchjak56.bunkers;

import com.muchjak56.bunkers.proxy.CommonProxy;
import com.muchjak56.bunkers.util.Reference;
import com.muchjak56.bunkers.util.handlers.GuiHandler;
import com.muchjak56.bunkers.util.handlers.RegistryHandler;

import Tabs.BunkerItemsTab;
import Tabs.BunkerBlocksTab;
import Tabs.BunkerDecorTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)

public class Bunkers {

	@Instance
	public static Bunkers instance;
	
	public static final CreativeTabs bunkerblockstab = new BunkerBlocksTab("bunkerblockstab");
	public static final CreativeTabs bunkeritemstab = new BunkerItemsTab("bunkeritemstab");
	public static final CreativeTabs bunkerdecortab = new BunkerDecorTab("bunkerdecortab");
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {RegistryHandler.preInitRegistries();}
	@EventHandler
	public static void init(FMLInitializationEvent event) {RegistryHandler.initRegistries();}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {RegistryHandler.postInitRegistries();}
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {RegistryHandler.serverRegistries(event);}}

