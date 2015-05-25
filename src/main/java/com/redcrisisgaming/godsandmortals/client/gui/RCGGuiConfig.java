package com.redcrisisgaming.godsandmortals.client.gui;

import com.redcrisisgaming.godsandmortals.handler.ConfigurationHandler;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;


public class RCGGuiConfig extends GuiConfig {
	public RCGGuiConfig(GuiScreen guiScreen){
		super(guiScreen, 
				new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MOD_ID,
				false,
				false,
				GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
		
		
	}
}
