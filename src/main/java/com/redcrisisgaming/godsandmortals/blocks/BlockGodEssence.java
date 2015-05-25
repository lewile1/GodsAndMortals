package com.redcrisisgaming.godsandmortals.blocks;

import java.util.Random;

import net.minecraft.item.Item;

import com.redcrisisgaming.godsandmortals.init.ModItems;

public class BlockGodEssence extends BlockGAM{
	public BlockGodEssence(){
		super();
		this.setBlockName("oreGodEssence");
	}
	
	// Using the methods from the Minecraft Redstone ore block
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
		return ModItems.dustGodEssence;
	}
	
	// Using the methods from the Minecraft Redstone ore block
	@Override
	public int quantityDropped(Random p_149745_1_)
    {
		// Always returns 3 dust
        return 3;
    }
}
