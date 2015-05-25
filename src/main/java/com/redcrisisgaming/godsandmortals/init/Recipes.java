package com.redcrisisgaming.godsandmortals.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init(){
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.statueBlock), "DSD", "SDS", "DSD", 'S', new ItemStack(ModItems.dustGodEssence), 'D', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.chisel), "   ", " I ", "  S", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(ModItems.favoredStick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.favoredStick), "   ", "SDS", "SDS", 'S', new ItemStack(ModItems.dustGodEssence), 'D', new ItemStack(Items.stick)); 
	}
}
