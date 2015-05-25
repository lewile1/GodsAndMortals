package com.redcrisisgaming.godsandmortals;

import com.redcrisisgaming.godsandmortals.handler.ConfigurationHandler;
import com.redcrisisgaming.godsandmortals.init.ModBlocks;
import com.redcrisisgaming.godsandmortals.init.ModItems;
import com.redcrisisgaming.godsandmortals.init.ModWorldGen;
import com.redcrisisgaming.godsandmortals.init.Recipes;
import com.redcrisisgaming.godsandmortals.proxy.IProxy;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class GodsAndMortals {
	@Mod.Instance(Reference.MOD_ID)
	public static GodsAndMortals instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Mod config loading
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		//Blocks and items
		ModItems.init();
		ModBlocks.init();
		
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		
		Recipes.init();
		ModWorldGen.init();
		//reg tile entities
		//reg guis
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		//wrapup after other mods do inits
	}
}