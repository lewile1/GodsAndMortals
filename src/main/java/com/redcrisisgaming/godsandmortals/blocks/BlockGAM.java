package com.redcrisisgaming.godsandmortals.blocks;

import com.redcrisisgaming.godsandmortals.creativetab.CreativeTabGAM;
import com.redcrisisgaming.godsandmortals.init.ModItems;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.block.ITileEntityProvider;

public class BlockGAM extends Block implements ITileEntityProvider{

	public static final CreativeTabs GAM_TAB = new CreativeTabGAM(Reference.MOD_ID.toLowerCase()+ ":blocks", ModItems.chisel);
	
	public BlockGAM(Material material) {
		super(material);
		this.setCreativeTab(this.GAM_TAB);
		this.setHardness(5.6F);
	}
	
	public BlockGAM(){
		this(Material.rock);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int type) {
		return null;
	}
}
