package com.redcrisisgaming.library;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ProjectileBaseGAM extends EntityArrow implements IEntityAdditionalSpawnData{
	public ProjectileBaseGAM (World world){
		super(world);
	}
	
	public ProjectileBaseGAM (World world, double coordX, double coordY, double coordZ) {
		super(world);
		this.setPosition(coordX, coordY, coordZ);
	}
	
	public ProjectileBaseGAM (World world, EntityPlayer player, float speed, float accuracy, ItemStack stack){
		this(world);
		
		this.shootingEntity = player;
		
		canBePickedUp = 1;
		

        // stuff from the arrow
        this.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI);
        this.motionZ = +MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI);
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed, accuracy);
        
        returnStack = stack;
	}
}
