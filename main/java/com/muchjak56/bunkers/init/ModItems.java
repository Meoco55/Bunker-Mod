package com.muchjak56.bunkers.init;

import java.util.ArrayList;
import java.util.List;

import com.muchjak56.bunkers.Items.Chisel;
import com.muchjak56.bunkers.Items.Hammer;
import com.muchjak56.bunkers.Items.ItemBase;
import com.muchjak56.bunkers.Items.armor.ArmorBase;
import com.muchjak56.bunkers.Items.tools.ToolAxe;

import com.muchjak56.bunkers.Items.tools.ToolHoe;
import com.muchjak56.bunkers.Items.tools.ToolPickaxe;
import com.muchjak56.bunkers.Items.tools.ToolSpade;
import com.muchjak56.bunkers.Items.tools.ToolSword;
import com.muchjak56.bunkers.Items.tools.UltimumBow;
import com.muchjak56.bunkers.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//materials
	public static final ToolMaterial TOOL_ULTIMUM = EnumHelper.addToolMaterial("tool_ultimum", 4, 1600, 9.0F, 7.0F, 10);
	public static final ToolMaterial TOOL_CRONO_ULTIMUM = EnumHelper.addToolMaterial("tool_crono_ultimum", 5, 1600, 11.0F, 9.0F, 10);
	public static final ToolMaterial TOOL_INFERNIUM_ULTIMUM = EnumHelper.addToolMaterial("tool_infernium_ultimum", 6, 1600, 12.0F, 10.0F, 10);
	public static final ToolMaterial TOOL_CRONO_INFERNIUM_ULTIMUM = EnumHelper.addToolMaterial("tool_crono_infernium_ultimum", 7, 1600, 14.0F, 14.0F, 10);
	public static final ArmorMaterial ARMOR_ULTIMUM = EnumHelper.addArmorMaterial("armor_ultimum", Reference.MOD_ID + ":ultimum_exo", 77, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	
	//add new items to this list, then create item.json, add item to lang.
	public static final Item CUT_STONE = new ItemBase("cut_stone");
	public static final Item CHISEL = new Chisel("chisel");
	public static final Item HAMMER = new Hammer("hammer");
	public static final Item MORTAR = new ItemBase("mortar");
	public static final Item CRUCIBLE = new ItemBase("crucible");
	public static final Item ULTIMUM_NUGGET = new ItemBase("ultimum_nugget");
	public static final Item ANTI_ULTIMUM_NUGGET = new ItemBase("anti_ultimum_nugget");
	public static final Item ULTIMUM_INGOT = new ItemBase("ultimum_ingot");
	public static final Item ANTI_ULTIMUM_INGOT = new ItemBase("anti_ultimum_ingot");
	public static final Item HARDENED_ROD = new ItemBase("hardened_rod");
	public static final Item CRONO_CRYSTAL = new ItemBase("crono_crystal");
	public static final Item INFERNIUM_SHARD = new ItemBase("infernium_shard");
	public static final Item INFERNIUM_CORE = new ItemBase("infernium_core");
	public static final Item UNKNOWN_MATTER = new ItemBase("unknown_matter");
	public static final Item AE = new ItemBase("ae");
	
	//Tools
	public static final ItemSword ULTIMUM_SWORD = new ToolSword("ultimum_sword", TOOL_ULTIMUM);
	public static final ItemSword CRONO_ULTIMUM_SWORD = new ToolSword("crono_ultimum_sword", TOOL_CRONO_ULTIMUM);
	public static final ItemSword INFERNIUM_ULTIMUM_SWORD = new ToolSword("infernium_ultimum_sword", TOOL_INFERNIUM_ULTIMUM);
	public static final ItemSword CRONO_INFERNIUM_ULTIMUM_SWORD = new ToolSword("crono_infernium_ultimum_sword", TOOL_CRONO_INFERNIUM_ULTIMUM);
	
	public static final ItemBow ULTIMUM_BOW = new UltimumBow("ultimum_bow", TOOL_ULTIMUM);
	
	public static final ItemHoe ULTIMUM_HOE = new ToolHoe("ultimum_hoe", TOOL_ULTIMUM);
	public static final ItemSpade ULTIMUM_SPADE = new ToolSpade("ultimum_spade", TOOL_ULTIMUM);
	public static final ItemAxe ULTIMUM_AXE = new ToolAxe("ultimum_axe", TOOL_ULTIMUM);
	
	public static final ItemPickaxe ULTIMUM_PICKAXE = new ToolPickaxe("ultimum_pickaxe", TOOL_ULTIMUM);
	public static final ItemPickaxe CRONO_ULTIMUM_PICKAXE = new ToolPickaxe("crono_ultimum_pickaxe", TOOL_CRONO_ULTIMUM);
	public static final ItemPickaxe INFERNIUM_ULTIMUM_PICKAXE = new ToolPickaxe("infernium_ultimum_pickaxe", TOOL_INFERNIUM_ULTIMUM);
	public static final ItemPickaxe CRONO_INFERNIUM_ULTIMUM_PICKAXE = new ToolPickaxe("crono_infernium_ultimum_pickaxe", TOOL_CRONO_INFERNIUM_ULTIMUM);
	
	
	
	//Armor
	public static final Item ULTIMUM_EXO_HELMET = new ArmorBase("ultimum_exo_helmet", ARMOR_ULTIMUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item ULTIMUM_EXO_CHESTPLATE = new ArmorBase("ultimum_exo_chestplate", ARMOR_ULTIMUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item ULTIMUM_EXO_LEGGINGS = new ArmorBase("ultimum_exo_leggings", ARMOR_ULTIMUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item ULTIMUM_EXO_BOOTS = new ArmorBase("ultimum_exo_boots", ARMOR_ULTIMUM, 1, EntityEquipmentSlot.FEET);
}
