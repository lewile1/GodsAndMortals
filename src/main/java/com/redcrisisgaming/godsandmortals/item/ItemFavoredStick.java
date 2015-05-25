package com.redcrisisgaming.godsandmortals.item;

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
		super();
		this.setUnlocalizedName("favoredStick");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, int sideHit, float px, float py, float pz){
		if(world.isRemote){	return false; }
		else {
			 float f = 1.0F;
			 float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
			 float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
			 double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
			 double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
			 double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
			 Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
			 float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
			 float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
			 float f5 = -MathHelper.cos(-f1 * 0.01745329F);
			 float f6 = MathHelper.sin(-f1 * 0.01745329F);
			 float f7 = f4 * f5;
			 float f8 = f6;
			 float f9 = f3 * f5;
			 double d3 = 5000D;
			 Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
			 MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3d, vec3d1, false);
			Vec3 look = player.getLookVec();
			MovingObjectPosition coord = player.rayTrace(300, 1);
			if(coord != null){
				EntityLightningBolt lb = new EntityLightningBolt(world, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
				LogHelper.info("XYZ of Look: " + coord.blockX + " " + coord.blockY + " " + coord.blockZ);
				lb.setPosition(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
				world.addWeatherEffect(lb);
			}
			return true;
		}
	}
}
