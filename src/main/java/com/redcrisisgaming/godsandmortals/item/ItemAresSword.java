package com.redcrisisgaming.godsandmortals.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;


public class ItemAresSword extends ItemSword{

	protected static ToolMaterial BRIMSTONE = EnumHelper.addToolMaterial("Brimstone", 3, 1561, 8.0F, 15.0F, 22 );
	
	public ItemAresSword(ToolMaterial p_i45356_1_) {
		super(BRIMSTONE);
		this.setUnlocalizedName("aresSword");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase targ1, EntityLivingBase targ2){
		item.damageItem(2, targ2);
		targ1.setFire(100);
		return true;
	}
	
	
}
