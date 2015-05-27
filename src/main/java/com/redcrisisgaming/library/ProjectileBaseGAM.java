package com.redcrisisgaming.library;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ProjectileBaseGAM extends EntityArrow implements IEntityAdditionalSpawnData{
	
	public ItemStack returnStack;
	
	public boolean bounceOnNoDamage = true;
	public boolean defused = false;

	private int field_145791_d;
	private int field_145792_e;
	private int field_145789_f;

	private boolean inGround;
	
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
	
	public ItemStack getEntityItem(){
		return returnStack;
	}
	
	protected double getStuckDepth(){ return 0.5f; }
	
	protected void doLivingHit(EntityLivingBase entityHit){
		if(!this.worldObj.isRemote){
			entityHit.setArrowCountInEntity(entityHit.getArrowCountInEntity() + 1);
		}
	}
	
	@Override
    // this function is the same as the vanilla EntityArrow
    public void onUpdate() {
        // call the entity update routine
        // luckily we can call this directly and take the arrow-code, since we'd have to call super.onUpdate otherwise. Which would not work.
        onEntityUpdate();

        // boioioiooioing
        if (this.arrowShake > 0)
            --this.arrowShake;

        // If we don't have our rotation set correctly, infer it from our motion direction
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
        }

        // we previously hit something. Check if the block is still there.
        Block block = this.worldObj.getBlock(this.field_145791_d, this.field_145792_e, this.field_145789_f);
        if (block.getMaterial() != Material.air)
        {
            block.setBlockBoundsBasedOnState(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f);

            // we are stuck in a block. yay.
            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
                this.inGround = true;
        }

        if (this.inGround)
            updateInGround();
        else
            updateInAir();
    }
	
	@Override
	public void writeSpawnData(ByteBuf data){
		ByteBufUtils.writeItemStack(data, returnStack);
		data.writeFloat(rotationYaw);
		
		//shooting entity
		int id = shootingEntity == null ? this.getEntityId() : shootingEntity.getEntityId();
		
		//motion stuff. This has to be sent separately since MC seems to do hardcoded stuff to arrows with this
		data.writeDouble(this.motionX);
		data.writeDouble(this.motionY);
		data.writeDouble(this.motionZ);
	}
	
	@Override
	public void readSpawnData(ByteBuf data){
		returnStack = ByteBufUtils.readItemStack(data);
		rotationYaw = data.readFloat();
		shootingEntity = worldObj.getEntityByID(data.readInt());
		
		this.motionX = data.readDouble();
		this.motionY = data.readDouble();
		this.motionZ = data.readDouble();
		
		// position offset so it doesn't shoot from the player's eyes
		this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F;
		this.posY -= 0.10000000149011612D;
		this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F;
	}
}
