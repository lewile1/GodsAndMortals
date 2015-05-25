package com.redcrisisgaming.godsandmortals.item;

import com.redcrisisgaming.godsandmortals.reference.Materials;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;


public class ItemAresSword extends ItemGAM{
	
	public ItemAresSword() {
		super("itemSword", Materials.BRIMSTONE);
		this.setUnlocalizedName("aresSword");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase targ1, EntityLivingBase targ2){
		item.damageItem(2, targ2);
		targ1.setFire(100);
		targ1.motionY = 2;
		return true;
	}
	
	
}
