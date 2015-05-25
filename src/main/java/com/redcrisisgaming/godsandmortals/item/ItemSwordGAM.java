package com.redcrisisgaming.godsandmortals.item;

import java.util.Set;

import com.redcrisisgaming.godsandmortals.creativetab.CreativeTabGAM;
import com.redcrisisgaming.godsandmortals.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSwordGAM extends ItemTool{

	public static ToolMaterial GODIUM = EnumHelper.addToolMaterial("Godium", 3, 1561, 8.0F, 22.0F, 22);
	public static ToolMaterial ZEUSIUM = EnumHelper.addToolMaterial("Zeusium", 3, 1561, 8.0F, 22.0F, 22);
	private static float damageVsEntity;
	private static Set field_150914_c;
	public static final CreativeTabs GAM_TAB = new CreativeTabGAM(Reference.MOD_ID.toLowerCase()+ ":items");
	
	
	public ItemSwordGAM(ToolMaterial material) {
		super(22.0F, GODIUM, field_150914_c);
		this.setCreativeTab(this.GAM_TAB);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
	
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack){
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
}
