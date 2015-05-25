package com.redcrisisgaming.godsandmortals.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

import com.redcrisisgaming.godsandmortals.item.ItemChisel;
import com.redcrisisgaming.godsandmortals.item.ItemDustGodEssence;
import com.redcrisisgaming.godsandmortals.item.ItemFavoredStick;
import com.redcrisisgaming.godsandmortals.item.ItemGAM;
import com.redcrisisgaming.godsandmortals.item.ItemLewsSword;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static final ItemGAM chisel = new ItemChisel();
	public static final ItemGAM dustGodEssence = new ItemDustGodEssence();
	public static final ItemGAM favoredStick = new ItemFavoredStick();
	public static final ItemSword lewsSword = new ItemLewsSword(ToolMaterial.EMERALD);
	
	public static void init(){
		GameRegistry.registerItem(chisel, "chisel");
		GameRegistry.registerItem(dustGodEssence, "dustGodEssence");
		GameRegistry.registerItem(favoredStick, "favoredStick");
		GameRegistry.registerItem(lewsSword, "lewsSword");
	}
}
