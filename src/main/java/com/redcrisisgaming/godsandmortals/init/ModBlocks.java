package com.redcrisisgaming.godsandmortals.init;

import com.redcrisisgaming.godsandmortals.blocks.BlockGAM;
import com.redcrisisgaming.godsandmortals.blocks.BlockGodEssence;
import com.redcrisisgaming.godsandmortals.blocks.BlockStatueBlock;
import com.redcrisisgaming.godsandmortals.blocks.BlockbumstoneBlock;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	public static final BlockGAM oreGodEssence = new BlockGodEssence();
	public static final BlockGAM statueBlock = new BlockStatueBlock();
	public static final BlockGAM bumstoneBlock = new BlockbumstoneBlock();
	
	public static void init(){
		GameRegistry.registerBlock(oreGodEssence, "oreGodEssence");
		GameRegistry.registerBlock(statueBlock, "statueBlock");
		GameRegistry.registerBlock(bumstoneBlock, "brimstoneBlock");
		
	}
}
