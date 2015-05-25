package com.redcrisisgaming.godsandmortals.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;


public class ItemAresSword extends ItemSword{

	protected static ToolMaterial BRIMSTONE = EnumHelper.addToolMaterial("Brimstone", 3, 1561, 8.0F, 15.0F, 22 );
	
	public ItemAresSword(ToolMaterial p_i45356_1_) {
		super(BRIMSTONE);
		// TODO Auto-generated constructor stub
	}
	
	
}
