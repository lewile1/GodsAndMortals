package com.redcrisisgaming.godsandmortals.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.redcrisisgaming.library.ProjectileBaseGAM;

public class EntityBolt extends ProjectileBaseGAM{
	
	public int roll;
	
	public EntityBolt(World world) {
		super(world);
	}
	
	public EntityBolt(World world, double coordX, double coordY, double coordZ){
		super(world, coordX, coordY, coordZ);
	}
	
	public EntityBolt(World world, EntityPlayer player, float speed, float accuracy, ItemStack stack){
		super(world, player, speed, accuracy, stack);
		
		float pitch = Math.max(-90f, player.rotationPitch - 20f);
		
		// same as in the others, but with pitch upped
        this.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, pitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F;
        this.posY -= 0.10000000149011612D;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI);
        this.motionZ = +MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI);
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed, accuracy);
	}
	
	@Override
	public void onUpdate(){
		if(this.ticksInGround == 0){
			roll = (roll + 20) % 360;
		}
		super.onUpdate();
	}

}
