package com.muchjak56.bunkers.Items.tools;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.Bunkers;
import com.muchjak56.bunkers.init.ModItems;
import com.muchjak56.bunkers.util.IHasModel;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToolBow extends ItemBow implements IHasModel
{
	public ToolBow(String name, ToolMaterial material) 
	{
		super();
		setUnlocalizedName(name);
		setRegistryName(name);		
		setCreativeTab(Bunkers.bunkeritemstab);		
		ModItems.ITEMS.add(this);					
	}
			
	@Override
	public void registerModels() 
	{
		Bunkers.proxy.registerItemRenderer(this,0,"inventory");
	}		
}