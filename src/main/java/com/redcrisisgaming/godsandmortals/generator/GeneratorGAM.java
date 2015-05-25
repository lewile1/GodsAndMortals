// TODO: Update this Class to accept inheritance for multiple 
// oregen items.  Right now, this class only generates
// godEssence as it stands.

package com.redcrisisgaming.godsandmortals.generator;

import java.util.Random;

import com.redcrisisgaming.godsandmortals.init.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GeneratorGAM implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateNether(World world, Random random, int i, int j){
		
	}

	private void generateSurface(World world, Random random, int i, int j){
		for(int k = 0; k < 5; k++){
			int oreBlockXCoord = i + random.nextInt(16);
			int oreBlockYCoord = random.nextInt(12) + 12;
			int oreBlockZCoord = j + random.nextInt(16);
			
			(new WorldGenMinable(ModBlocks.oreGodEssence, 3)).generate(world, random, oreBlockXCoord, oreBlockYCoord, oreBlockZCoord);
		}
	}
	
	private void generateEnd(World world, Random random, int i, int j){
		
	}
}
