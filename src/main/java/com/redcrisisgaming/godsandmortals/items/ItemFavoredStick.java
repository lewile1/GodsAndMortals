package com.redcrisisgaming.godsandmortals.items;

import com.redcrisisgaming.godsandmortals.util.LogHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemFavoredStick extends ItemGAM{
	public ItemFavoredStick(){
		super("other");
		this.itemType = "other";
		this.setUnlocalizedName("favoredStick");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, int sideHit, float px, float py, float pz){
		if(world.isRemote){	return false; }
		/*
		 * Lighning strike code.
		 * 
		 * else {
			Vec3 look = player.getLookVec();
			MovingObjectPosition coord = player.rayTrace(300, 1);
			if(coord != null){
				EntityLightningBolt lb = new EntityLightningBolt(world, coord.blockX, coord.blockY, coord.blockZ);
				LogHelper.info("XYZ of Look: " + coord.blockX + " " + coord.blockY + " " + coord.blockZ);
				world.addWeatherEffect(lb);
			} 
		}*/
		
		return true;
	}
	
	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase targ1, EntityLivingBase targ2){
		targ1.motionY = 1;
		return true;
	}
}
