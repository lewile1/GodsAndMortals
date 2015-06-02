package com.redcrisisgaming.godsandmortals.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

import com.redcrisisgaming.godsandmortals.items.ItemAresSword;
import com.redcrisisgaming.godsandmortals.items.ItemChisel;
import com.redcrisisgaming.godsandmortals.items.ItemDustGodEssence;
import com.redcrisisgaming.godsandmortals.items.ItemFavoredStick;
import com.redcrisisgaming.godsandmortals.items.ItemGAM;
import com.redcrisisgaming.godsandmortals.items.ItemGodiumIngot;
import com.redcrisisgaming.godsandmortals.items.armor.ItemArmorGAM;
import com.redcrisisgaming.godsandmortals.items.armor.ItemGodiumHelm;
import com.redcrisisgaming.godsandmortals.reference.Materials;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static final ItemGAM chisel = new ItemChisel();
	public static final ItemGAM dustGodEssence = new ItemDustGodEssence();
	public static final ItemGAM favoredStick = new ItemFavoredStick();
	public static final ItemGAM ingotGodium = new ItemGodiumIngot();
	public static final ItemGAM aresSword = new ItemAresSword();
	public static final ItemArmorGAM godiumHelm = new ItemGodiumHelm();
	
	public static void init(){
		GameRegistry.registerItem(chisel, "chisel");
		GameRegistry.registerItem(dustGodEssence, "dustGodEssence");
		GameRegistry.registerItem(favoredStick, "favoredStick");
		GameRegistry.registerItem(aresSword, "aresSword");
		GameRegistry.registerItem(ingotGodium, "ingotGodium");
		
		GameRegistry.registerItem(godiumHelm, "godiumHelm");
	}
}
