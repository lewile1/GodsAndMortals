package com.redcrisisgaming.godsandmortals.item;

import com.redcrisisgaming.godsandmortals.reference.Materials;
import com.redcrisisgaming.godsandmortals.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;


public class ItemAresSword extends ItemGAM{
	
	public ItemAresSword() {
		super("itemSword", Materials.BRIMSTONE);
		this.setUnlocalizedName("aresSword");
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Function updates itemstack's damage when attacking
	 * blocks of web. Useful to target certain blocks
	 * 
	 * previous iteration of method was: getStrVsBlock(ItemStack, Block)
	 */
	@Override
    public float func_150893_a(ItemStack itemUsed, Block blockTarget)
    {
		if (blockTarget == Blocks.web){
			return 15.0F;
		}else{
			Material material = blockTarget.getMaterial();
			return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
		}
    }
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase targ1, EntityLivingBase targ2){
		item.damageItem(2, targ2);
		targ1.setFire(100);
		targ1.motionY = 1.5;
		return true;
	}
	
	
	
	
}
