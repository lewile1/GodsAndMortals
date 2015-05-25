package com.redcrisisgaming.godsandmortals.item;

import com.redcrisisgaming.godsandmortals.util.LogHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
			Vec3 look = player.getLookVec();
			MovingObjectPosition coord = player.rayTrace(300, 1);
			if(coord != null && coord.typeOfHit == MovingObjectType.BLOCK){
				EntityLightningBolt lb = new EntityLightningBolt(world, look.xCoord, look.yCoord, look.zCoord);
				lb.setPosition(coord.blockX, coord.blockY, coord.blockZ);
				world.setBlock(blockX, blockY, blockZ, Blocks.bedrock);
				world.spawnEntityInWorld(lb);
			}
			return true;
		}
	}
}
