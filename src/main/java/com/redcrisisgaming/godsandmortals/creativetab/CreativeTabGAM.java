package com.redcrisisgaming.godsandmortals.creativetab;

import com.redcrisisgaming.godsandmortals.init.ModItems;
import com.redcrisisgaming.godsandmortals.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabGAM extends CreativeTabs{
	
	public static Item itemName = new Item();
	
	public CreativeTabGAM(String label) {
		super(label);
		this.itemName = ModItems.chisel;
		// TODO Auto-generated constructor stub
	}

	public CreativeTabGAM(String label, Item itemLabel){
		super(label);
		this.itemName = itemLabel;
	}
	
	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return this.itemName;
	}

}
