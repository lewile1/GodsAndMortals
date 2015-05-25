package com.redcrisisgaming.godsandmortals.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.redcrisisgaming.godsandmortals.reference.Reference;
import com.redcrisisgaming.godsandmortals.util.LogHelper;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	public static Configuration configuration;
	
	public static boolean godsAvail;
	public static boolean deitiesAvail;
	
	public static boolean zeusAvail;
	public static boolean poseidonAvail;
	public static boolean hadesAvail;
	public static boolean ariesAvail;
	public static boolean hermesAvail;
	public static boolean demeterAvail;
	public static boolean aphroditeAvail;
	public static boolean athenaAvail;
	public static boolean dionysisAvail;
	public static boolean hephestusAvail;
	public static boolean heraAvail;
	
	public static boolean thanatosAvail;
	public static boolean gaiaAvail;
	public static boolean uranusAvail;
	public static boolean erebusAvail;
	public static boolean cronosAvail;
	public static boolean chaosAvail;
	public static boolean aetherAvail;
	
	public static boolean tartarusLoad;
	
	public static void init(File configFile){
		// Create configuration object from given file
		if (configuration == null){
			configuration = new Configuration(configFile);
		}
		
		
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
				// Resync Configs
		}
	}
	
	public void loadConfiguration(){
		try{
			// Load the Config file
			configuration.load();
			
			// Read Props from config
			godsAvail = configuration.getBoolean("GODS", Configuration.CATEGORY_GENERAL, true, "Gods available");
			
			zeusAvail = configuration.getBoolean("Zeus Available", "Gods", true, "Zeus Available");
			poseidonAvail = configuration.getBoolean("Poseidon Available", "Gods", true, "Poseidon Available");
			hadesAvail = configuration.getBoolean("Hades Available", "Gods", true, "Hades Available");
			ariesAvail = configuration.getBoolean("Aries Available", "Gods", true, "Aries Available");
			hermesAvail = configuration.getBoolean("Hermes Available", "Gods", true, "Hermes Available");
			demeterAvail = configuration.getBoolean("Demeter Available", "Gods", true, "Demeter Available");
			aphroditeAvail = configuration.getBoolean("Aphrodite Available", "Gods", true, "Aphrodite Available");
			athenaAvail = configuration.getBoolean("Athena Available", "Gods", true, "Athena Available");
			dionysisAvail = configuration.getBoolean("Dionysis Available", "Gods", true, "Dionysis Available");
			hephestusAvail = configuration.getBoolean("Hephestus Available", "Gods", true, "Hephestus Available");
			heraAvail = configuration.getBoolean("Hera Available", "Gods", true, "Hera Available");
						
			deitiesAvail = configuration.getBoolean("DEITIES", Configuration.CATEGORY_GENERAL, true, "Deities available");
			
			thanatosAvail = configuration.getBoolean("Thanatos Available", "Deities", true, "Thanatos Available");
			gaiaAvail = configuration.getBoolean("Gaia Available", "Deities", true, "Gaia Available");
			uranusAvail = configuration.getBoolean("Uranus Available", "Deities", true, "Uranus Available");
			erebusAvail = configuration.getBoolean("Erebus Available", "Deities", true, "Erebus Available");
			cronosAvail = configuration.getBoolean("Cronos Available", "Deities", true, "Cronos Available");
			chaosAvail = configuration.getBoolean("Chaos Available", "Deities", true, "Chaos Available");
			aetherAvail = configuration.getBoolean("Aether Available", "Deities", true, "Aether Available");
			
			tartarusLoad = configuration.getBoolean("Tartarus", Configuration.CATEGORY_GENERAL, true, "Tartarus Load Available");
			
		} catch(Exception e){
			// Log exception
		} 
		
		if (configuration.hasChanged()){
			configuration.save();
		}
		LogHelper.info("Config file loaded....");
	}
}
