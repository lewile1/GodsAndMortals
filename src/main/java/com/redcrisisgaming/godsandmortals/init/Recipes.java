package com.redcrisisgaming.godsandmortals.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init(){
		// Shaped Recipes
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.statueBlock), "DSD", "SDS", "DSD", 'S', new ItemStack(ModItems.dustGodEssence), 'D', new ItemStack(Blocks.cobblestone));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.chisel), "   ", " I ", "  S", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(ModItems.favoredStick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.favoredStick), "   ", "SDS", "SDS", 'S', new ItemStack(ModItems.dustGodEssence), 'D', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotGodium), "DDD", "DID", "DDD", 'D', new ItemStack(ModItems.dustGodEssence), 'I', new ItemStack(Items.iron_ingot));
		
		
		// Smelting Recipes
		GameRegistry.addSmelting(ModBlocks.bumstoneBlock,  new ItemStack(ModItems.brickBrimstone, 1, 11), 0.5F);
	}
}
