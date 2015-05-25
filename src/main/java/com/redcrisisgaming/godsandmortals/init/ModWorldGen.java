package com.redcrisisgaming.godsandmortals.init;

import com.redcrisisgaming.godsandmortals.generator.GeneratorGAM;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModWorldGen {
	public static void init(){
		GameRegistry.registerWorldGenerator(new GeneratorGAM(), 1);
	}
}
