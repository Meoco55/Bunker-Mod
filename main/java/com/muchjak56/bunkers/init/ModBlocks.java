package com.muchjak56.bunkers.init;

import java.util.ArrayList;
import java.util.List;

import com.muchjak56.bunkers.blocks.BarbedWire;
import com.muchjak56.bunkers.blocks.BlockBase;
import com.muchjak56.bunkers.blocks.BunkerGlassPane;
import com.muchjak56.bunkers.blocks.BunkerGlassPillarBlock;
import com.muchjak56.bunkers.blocks.BunkerLightBlock;

import com.muchjak56.bunkers.blocks.BunkerWall;
import com.muchjak56.bunkers.blocks.CatWalk;
import com.muchjak56.bunkers.blocks.CronoCrystalFormation;

import com.muchjak56.bunkers.blocks.ForceField;
import com.muchjak56.bunkers.blocks.InferniumOre;
import com.muchjak56.bunkers.blocks.MosaicBlock;
import com.muchjak56.bunkers.blocks.RoundLog;
import com.muchjak56.bunkers.blocks.RoundLogTop;
import com.muchjak56.bunkers.blocks.SolarLight;
import com.muchjak56.bunkers.blocks.UltimumBlock;
import com.muchjak56.bunkers.blocks.UltimumOre;
import com.muchjak56.bunkers.blocks.UltimumTorch;
import com.muchjak56.bunkers.blocks.UnstableMatter;
import com.muchjak56.bunkers.blocks.blocktype.ColorBlockBase;
import com.muchjak56.bunkers.blocks.blocktype.ColorBunkerLightBlock;
import com.muchjak56.bunkers.blocks.blocktype.ColorGlassType;
import com.muchjak56.bunkers.blocks.blocktype.DoorType;
import com.muchjak56.bunkers.blocks.blocktype.FenceType;
import com.muchjak56.bunkers.blocks.blocktype.GlassType;
import com.muchjak56.bunkers.blocks.blocktype.LadderType;
import com.muchjak56.bunkers.blocks.blocktype.PaneType;
import com.muchjak56.bunkers.blocks.blocktype.PillarType;
import com.muchjak56.bunkers.blocks.blocktype.StairType;
import com.muchjak56.bunkers.blocks.blocktype.TorchType;
import com.muchjak56.bunkers.blocks.blocktype.WallType;
import com.muchjak56.bunkers.blocks.machine.hyposmelter.BlockHypoSmelter;

import com.muchjak56.bunkers.blocks.machine.jumppad.JumpPad;
import com.muchjak56.bunkers.blocks.machine.jumppad.JumpPadAngle;
import com.muchjak56.bunkers.blocks.machine.jumppad.JumpPadAngleT2;
import com.muchjak56.bunkers.blocks.machine.jumppad.JumpPadAngleT3;
import com.muchjak56.bunkers.blocks.machine.jumppad.JumpPadT2;
import com.muchjak56.bunkers.blocks.machine.jumppad.JumpPadT3;
import com.muchjak56.bunkers.blocks.machine.jumppad.LandingPad;
import com.muchjak56.bunkers.blocks.machine.nanowall.NanoWall;
import com.muchjak56.bunkers.blocks.machine.nanowall.NanoWallBase;
import com.muchjak56.bunkers.blocks.machine.nanowall.NanoWallCrown;
import com.muchjak56.bunkers.blocks.machine.nanowall.NanoWallOn;
import com.muchjak56.bunkers.blocks.machine.ultimumcharger.BlockUltimumCharger;
import com.muchjak56.bunkers.blocks.machine.xray.XrayDevice;
import com.muchjak56.bunkers.blocks.machine.xray.XrayOn;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.client.model.MapModelState;

public class ModBlocks 
{
	
	
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//add new block to this list, then create blockstate.json, block.json, and item.json. add item to lang.
	public static final Block MOSAIC_BLOCK = new MosaicBlock("mosaic_block", Material.ROCK);
	public static final Block RMOSAIC_BLOCK_RED = new MosaicBlock("mosaic_block_red", Material.ROCK);
	public static final Block MOSAIC_BLOCK_ORANGE = new MosaicBlock("mosaic_block_orange", Material.ROCK);
	public static final Block MOSAIC_BLOCK_YELLOW = new MosaicBlock("mosaic_block_yellow", Material.ROCK);
	public static final Block MOSAIC_BLOCK_LIME = new MosaicBlock("mosaic_block_lime", Material.ROCK);
	public static final Block MOSAIC_BLOCK_GREEN = new MosaicBlock("mosaic_block_green", Material.ROCK);
	public static final Block MOSAIC_BLOCK_BLUE = new MosaicBlock("mosaic_block_blue", Material.ROCK);
	public static final Block MOSAIC_BLOCK_CYAN = new MosaicBlock("mosaic_block_cyan", Material.ROCK);
	public static final Block BLUE_MOSAIC_BLOCK_LBLUE = new MosaicBlock("mosaic_block_lblue", Material.ROCK);
	public static final Block MOSAIC_BLOCK_PURPLE = new MosaicBlock("mosaic_block_purple", Material.ROCK);
	public static final Block MOSAIC_BLOCK_MAGENTA = new MosaicBlock("mosaic_block_magenta", Material.ROCK);
	public static final Block MOSAIC_BLOCK_PINK = new MosaicBlock("mosaic_block_pink", Material.ROCK);
	public static final Block MOSAIC_BLOCK_BROWN = new MosaicBlock("mosaic_block_brown", Material.ROCK);
	public static final Block GRAY_MOSAIC_BLOCK_LGRAY = new MosaicBlock("mosaic_block_lgray", Material.ROCK);
	public static final Block MOSAIC_BLOCK_GRAY = new MosaicBlock("mosaic_block_gray", Material.ROCK);
	public static final Block MOSAIC_BLOCK_BLACK = new MosaicBlock("mosaic_block_black", Material.ROCK);
	public static final Block MOSAIC_BLOCK_WHITE = new MosaicBlock("mosaic_block_white", Material.ROCK);
	
	
	
	public static final Block RYAN = new BlockBase("ryan", Material.ROCK);
	
	
	public static final Block BUNKER_WALL_BLOCK = new BlockBase("bunker_wall_block", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_RED = new ColorBlockBase("bunker_wall_block_red", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_ORANGE = new ColorBlockBase("bunker_wall_block_orange", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_YELLOW = new ColorBlockBase("bunker_wall_block_yellow", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_LIME = new ColorBlockBase("bunker_wall_block_lime", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_GREEN = new ColorBlockBase("bunker_wall_block_green", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_CYAN = new ColorBlockBase("bunker_wall_block_cyan", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_LBLUE = new ColorBlockBase("bunker_wall_block_lblue", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_BLUE = new ColorBlockBase("bunker_wall_block_blue", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_PURPLE = new ColorBlockBase("bunker_wall_block_purple", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_MAGENTA = new ColorBlockBase("bunker_wall_block_magenta", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_PINK = new ColorBlockBase("bunker_wall_block_pink", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_BROWN = new ColorBlockBase("bunker_wall_block_brown", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_LGRAY = new ColorBlockBase("bunker_wall_block_lgray", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_BLACK = new ColorBlockBase("bunker_wall_block_black", Material.IRON);
	public static final Block BUNKER_WALL_BLOCK_WHITE = new ColorBlockBase("bunker_wall_block_white", Material.IRON);
	
							
	public static final Block BUNKER_TRIM_BASE_BLOCK = new BlockBase("bunker_trim_base_block", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_RED = new ColorBlockBase("bunker_trim_base_block_red", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_ORANGE = new ColorBlockBase("bunker_trim_base_block_orange", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_YELLOW = new ColorBlockBase("bunker_trim_base_block_yellow", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_LIME = new ColorBlockBase("bunker_trim_base_block_lime", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_GREEN = new ColorBlockBase("bunker_trim_base_block_green", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_CYAN = new ColorBlockBase("bunker_trim_base_block_cyan", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_LBLUE = new ColorBlockBase("bunker_trim_base_block_lblue", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_BLUE = new ColorBlockBase("bunker_trim_base_block_blue", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_PURPLE = new ColorBlockBase("bunker_trim_base_block_purple", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_MAGENTA = new ColorBlockBase("bunker_trim_base_block_magenta", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_PINK = new ColorBlockBase("bunker_trim_base_block_pink", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_BROWN = new ColorBlockBase("bunker_trim_base_block_brown", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_LGRAY = new ColorBlockBase("bunker_trim_base_block_lgray", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_BLACK = new ColorBlockBase("bunker_trim_base_block_black", Material.IRON);
	public static final Block BUNKER_TRIM_BASE_BLOCK_WHITE = new ColorBlockBase("bunker_trim_base_block_white", Material.IRON);
	
	
	public static final Block BUNKER_TRIM_CROWN_BLOCK = new BlockBase("bunker_trim_crown_block", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_RED = new ColorBlockBase("bunker_trim_crown_block_red", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_ORANGE = new ColorBlockBase("bunker_trim_crown_block_orange", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_YELLOW = new ColorBlockBase("bunker_trim_crown_block_yellow", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_LIME = new ColorBlockBase("bunker_trim_crown_block_lime", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_GREEN = new ColorBlockBase("bunker_trim_crown_block_green", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_CYAN = new ColorBlockBase("bunker_trim_crown_block_cyan", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_LBLUE = new ColorBlockBase("bunker_trim_crown_block_lblue", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_BLUE = new ColorBlockBase("bunker_trim_crown_block_blue", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_PURPLE = new ColorBlockBase("bunker_trim_crown_block_purple", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_MAGENTA = new ColorBlockBase("bunker_trim_crown_block_magenta", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_PINK = new ColorBlockBase("bunker_trim_crown_block_pink", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_BROWN = new ColorBlockBase("bunker_trim_crown_block_brown", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_LGRAY = new ColorBlockBase("bunker_trim_crown_block_lgray", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_BLACK = new ColorBlockBase("bunker_trim_crown_block_black", Material.IRON);
	public static final Block BUNKER_TRIM_CROWN_BLOCK_WHITE = new ColorBlockBase("bunker_trim_crown_block_white", Material.IRON);
	
	
	public static final Block BUNKER_GRATE_FLOOR_BLOCK = new BlockBase("bunker_grate_floor_block", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_RED = new ColorBlockBase("bunker_grate_floor_block_red", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_ORANGE = new ColorBlockBase("bunker_grate_floor_block_orange", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_YELLOW = new ColorBlockBase("bunker_grate_floor_block_yellow", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_LIME = new ColorBlockBase("bunker_grate_floor_block_lime", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_GREEN = new ColorBlockBase("bunker_grate_floor_block_green", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_CYAN = new ColorBlockBase("bunker_grate_floor_block_cyan", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_LBLUE = new ColorBlockBase("bunker_grate_floor_block_lblue", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_BLUE = new ColorBlockBase("bunker_grate_floor_block_blue", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_PURPLE = new ColorBlockBase("bunker_grate_floor_block_purple", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_MAGENTA = new ColorBlockBase("bunker_grate_floor_block_magenta", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_PINK = new ColorBlockBase("bunker_grate_floor_block_pink", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_BROWN = new ColorBlockBase("bunker_grate_floor_block_brown", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_LGRAY = new ColorBlockBase("bunker_grate_floor_block_lgray", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_BLACK = new ColorBlockBase("bunker_grate_floor_block_black", Material.IRON);
	public static final Block BUNKER_GRATE_FLOOR_BLOCK_WHITE = new ColorBlockBase("bunker_grate_floor_block_white", Material.IRON);
	
	
	
	
	
	
	//Pillars
	public static final Block BUNKER_GLASS_PILLAR_BLOCK = new BunkerGlassPillarBlock("bunker_glass_pillar_block", Material.IRON);
	public static final Block ROUND_LOG = new RoundLog("round_log", Material.WOOD);
	public static final Block ROUND_LOG_TOP = new RoundLogTop("round_log_top", Material.WOOD);
	
	public static final Block CAT_WALK_BLOCK = new CatWalk("cat_walk_block", Material.IRON);
	public static final Block ULTIMUM_BLOCK = new UltimumBlock("ultimum_block", Material.IRON);
	
	
	//Ores
	public static final Block ULTIMUM_ORE_BLOCK = new UltimumOre("ultimum_ore_block", Material.ROCK);
	public static final Block HARDENED_IMPURITIES_BLOCK = new UltimumOre("hardened_impurities_block", Material.ROCK);
	public static final Block CRONO_CRYSTAL_FORMATION = new CronoCrystalFormation("crono_crystal_formation", Material.ROCK);
	public static final Block INFERNIUM_ORE = new InferniumOre("infernium_ore", Material.ROCK);		
	public static final Block UNSTABLE_MATTER = new UnstableMatter("unstable_matter", Material.ROCK);		
			
	//Ladders
	public static final Block STEEL_LADDER = new LadderType("steel_ladder", Material.IRON);
	public static final Block BUNKER_LADDER = new LadderType("bunker_ladder", Material.IRON);
	
	//Fence
	public static final Block BUNKER_FENCE = new FenceType("bunker_fence", Material.IRON, MapColor.IRON);
	public static final Block BUNKER_WALL = new BunkerWall("bunker_wall", Material.IRON, BUNKER_WALL_BLOCK);
	
	
	
	//Doors
	public static final Block BUNKER_DOOR = new DoorType("bunker_door", Material.WOOD);
	
	//Slabs
	
	
	//Stairs
	public static final Block BUNKER_STAIRS = new StairType("bunker_stairs", Material.IRON, BUNKER_WALL_BLOCK.getDefaultState());
	public static final Block BUNKER_GRATE_STAIRS = new StairType("bunker_grate_stairs", Material.IRON, BUNKER_TRIM_BASE_BLOCK.getDefaultState());
	
	
	
	
	//Light Blocks
	public static final Block BUNKER_LIGHT_VERT_BLOCK = new BunkerLightBlock("bunker_light_vert_block", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_RED = new ColorBunkerLightBlock("bunker_light_vert_block_red", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_ORANGE = new ColorBunkerLightBlock("bunker_light_vert_block_orange", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_YELLOW = new ColorBunkerLightBlock("bunker_light_vert_block_yellow", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_LIME = new ColorBunkerLightBlock("bunker_light_vert_block_lime", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_GREEN = new ColorBunkerLightBlock("bunker_light_vert_block_green", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_LBLUE = new ColorBunkerLightBlock("bunker_light_vert_block_lblue", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_BLUE = new ColorBunkerLightBlock("bunker_light_vert_block_blue", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_CYAN = new ColorBunkerLightBlock("bunker_light_vert_block_cyan", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_PURPLE = new ColorBunkerLightBlock("bunker_light_vert_block_purple", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_MAGENTA = new ColorBunkerLightBlock("bunker_light_vert_block_magenta", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_PINK = new ColorBunkerLightBlock("bunker_light_vert_block_pink", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_LGRAY = new ColorBunkerLightBlock("bunker_light_vert_block_lgray", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_BROWN = new ColorBunkerLightBlock("bunker_light_vert_block_brown", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_BLACK = new ColorBunkerLightBlock("bunker_light_vert_block_black", Material.GLASS);
	public static final Block BUNKER_LIGHT_VERT_BLOCK_WHITE = new ColorBunkerLightBlock("bunker_light_vert_block_white", Material.GLASS);
	
	
	
	public static final Block BUNKER_LIGHT_HORZ_BLOCK = new BunkerLightBlock("bunker_light_horz_block", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_RED = new ColorBunkerLightBlock("bunker_light_horz_block_red", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_ORANGE = new ColorBunkerLightBlock("bunker_light_horz_block_orange", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_YELLOW = new ColorBunkerLightBlock("bunker_light_horz_block_yellow", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_LIME = new ColorBunkerLightBlock("bunker_light_horz_block_lime", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_GREEN = new ColorBunkerLightBlock("bunker_light_horz_block_green", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_LBLUE = new ColorBunkerLightBlock("bunker_light_horz_block_lblue", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_BLUE = new ColorBunkerLightBlock("bunker_light_horz_block_blue", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_CYAN = new ColorBunkerLightBlock("bunker_light_horz_block_cyan", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_PURPLE = new ColorBunkerLightBlock("bunker_light_horz_block_purple", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_MAGENTA = new ColorBunkerLightBlock("bunker_light_horz_block_magenta", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_PINK = new ColorBunkerLightBlock("bunker_light_horz_block_pink", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_LGRAY = new ColorBunkerLightBlock("bunker_light_horz_block_lgray", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_BROWN = new ColorBunkerLightBlock("bunker_light_horz_block_brown", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_BLACK = new ColorBunkerLightBlock("bunker_light_horz_block_black", Material.GLASS);
	public static final Block BUNKER_LIGHT_HORZ_BLOCK_WHITE = new ColorBunkerLightBlock("bunker_light_horz_block_white", Material.GLASS);
	
	
	public static final Block SOLAR_LIGHT = new SolarLight("solar_light", Material.IRON);
	
	
	
	
	//Glass Blocks
	public static final Block BUNKER_GLASS_PORT_BLOCK = new GlassType("bunker_glass_port_block", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_RED = new ColorGlassType("bunker_glass_port_block_red", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_ORANGE = new ColorGlassType("bunker_glass_port_block_orange", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_YELLOW = new ColorGlassType("bunker_glass_port_block_yellow", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_LIME = new ColorGlassType("bunker_glass_port_block_lime", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_GREEN = new ColorGlassType("bunker_glass_port_block_green", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_CYAN = new ColorGlassType("bunker_glass_port_block_cyan", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_LBLUE = new ColorGlassType("bunker_glass_port_block_lblue", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_BLUE = new ColorGlassType("bunker_glass_port_block_blue", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_PURPLE = new ColorGlassType("bunker_glass_port_block_purple", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_MAGENTA = new ColorGlassType("bunker_glass_port_block_magenta", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_PINK = new ColorGlassType("bunker_glass_port_block_pink", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_BROWN = new ColorGlassType("bunker_glass_port_block_brown", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_LGRAY = new ColorGlassType("bunker_glass_port_block_lgray", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_BLACK = new ColorGlassType("bunker_glass_port_block_black", Material.GLASS,true);
	public static final Block BUNKER_GLASS_PORT_BLOCK_WHITE = new ColorGlassType("bunker_glass_port_block_white", Material.GLASS,true);
	
	
	
	
	public static final Block BUNKER_GLASS_BLOCK = new GlassType("bunker_glass_block", Material.GLASS, true);
	
	
	
	
	public static final Block BUNKER_STEEL_SHUTTER = new PaneType("bunker_steel_shutter", Material.IRON, true);
	public static final Block BUNKER_GLASS_PANE = new BunkerGlassPane("bunker_glass_pane", Material.IRON, true);
	
	
	
	
	//Machine Blocks
	public static final Block HYPO_SMELTER = new BlockHypoSmelter("hypo_smelter");
	public static final Block ULTIMUM_CHARGER = new BlockUltimumCharger("ultimum_charger");
	
	public static final Block XRAY_DEVICE = new XrayDevice("xray_device", Material.IRON);
	public static final Block XRAY_DEVICE_ON = new XrayOn("xray_device_on", true, Material.IRON);
	
	public static final Block NANO_WALL = new NanoWall("nano_wall", false, Material.IRON);
	public static final Block NANO_WALL_BASE = new NanoWallBase("nano_wall_base", false, Material.IRON);
	public static final Block NANO_WALL_CROWN = new NanoWallCrown("nano_wall_crown", false, Material.IRON);
	public static final Block NANO_WALL_ON = new NanoWallOn("nano_wall_on", false, Material.IRON);
	
	public static final Block BARBED_WIRE = new BarbedWire("barbed_wire", Material.IRON);
	
	public static final Block JUMP_PAD = new JumpPad("jump_pad", Material.IRON);
	public static final Block JUMP_PAD_T2 = new JumpPadT2("jump_pad_t2", Material.IRON);
	public static final Block JUMP_PAD_T3 = new JumpPadT3("jump_pad_t3", Material.IRON);
	
	public static final Block JUMP_PAD_ANGLE = new JumpPadAngle("jump_pad_angle", Material.IRON);	
	public static final Block JUMP_PAD_ANGLE_T2 = new JumpPadAngleT2("jump_pad_angle_t2", Material.IRON);
	public static final Block JUMP_PAD_ANGLE_T3 = new JumpPadAngleT3("jump_pad_angle_t3", Material.IRON);
	
	public static final Block LANDING_PAD = new LandingPad("landing_pad", Material.CARPET);
	public static final Block ULTIMUM_TORCH = new UltimumTorch("ultimum_torch", Material.IRON);
	public static final Block FORCE_FIELD = new ForceField("force_field", Material.GLASS);


}