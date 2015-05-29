package com.redcrisisgaming.godsandmortals.reference;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
	public static ToolMaterial BRIMSTONE = EnumHelper.addToolMaterial("Brimstone", 3, 3000, 8.0F, 15.0F, 22 );
	public static ToolMaterial GODIUM = EnumHelper.addToolMaterial("Godium", 3, 2500, 8.0F, 22.0F, 22);
	public static ToolMaterial ZEUSIUM = EnumHelper.addToolMaterial("Zeusium", 3, 2300, 8.0F, 22.0F, 22);
	
	
	// addArmorMaterial("Name", damageReduction[int Array], enchantability)
	// http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-7/custom-armor/
	
	public static ArmorMaterial BRIMSTONE_ARMOR = EnumHelper.addArmorMaterial("Brimstone", 33, new int[]{3, 8, 6, 3}, 25);
	
	
}
