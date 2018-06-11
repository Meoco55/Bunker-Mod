package com.muchjak56.bunkers.Items.tools;

import javax.annotation.Nullable;

import com.muchjak56.bunkers.init.ModItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UltimumBow extends ToolBow
{

	public UltimumBow(String name, ToolMaterial material) {
		super(name, material);
		this.setMaxDamage(777);
	
		
		
		
		
		
	this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
    {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
            if (entityIn == null)
            {
                return 0.0F;
            }
            else
            {
                return entityIn.getActiveItemStack().getItem() != ModItems.ULTIMUM_BOW ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
            }
        }
    });
    this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
    {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
            return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
        }
    });
    
    
	}
	
	
	
	/**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }
}
