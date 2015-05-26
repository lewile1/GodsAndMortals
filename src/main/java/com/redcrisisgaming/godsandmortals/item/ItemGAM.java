package com.redcrisisgaming.godsandmortals.item;

import com.google.common.collect.Multimap;
import com.redcrisisgaming.godsandmortals.creativetab.CreativeTabGAM;
import com.redcrisisgaming.godsandmortals.reference.Reference;
import com.redcrisisgaming.godsandmortals.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGAM extends Item{
	
	private float attackDamage;
	protected float efficiencyOnProperMaterial = 4.0F;
	private EnumAction toolAction = null;
	private ToolMaterial toolMaterial = Item.ToolMaterial.WOOD;
	protected static String itemType = "other";
	
	public static final CreativeTabs GAM_TAB = new CreativeTabGAM(Reference.MOD_ID.toLowerCase()+ ":items");
	
	public ItemGAM(String toolType){
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(this.GAM_TAB);
		setItemProps(toolType, Item.ToolMaterial.WOOD);
	}
	
	
	public ItemGAM(String toolType, ToolMaterial material){
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(this.GAM_TAB);
		setItemProps(toolType, material);
	}
	
	private void setItemProps(String toolType, ToolMaterial material){
		toolMaterial = material;
		itemType = toolType;
		switch(toolType){
		case "itemSword":
			this.setMaxDamage(material.getMaxUses());
			this.attackDamage = 4.0F + material.getDamageVsEntity();
			this.toolAction = EnumAction.block;
			break;
		case "itemHoe":
			break;
		case "itemSpade":
			break;
		case "itemPick":
			break;
		default:
			this.toolAction = EnumAction.bow;
			break;
		}
	}
	
	////////////////////// START COPIED CODE
    
    public boolean hitEntity(ItemStack item, EntityLivingBase target1, EntityLivingBase target2)
    {
        item.damageItem(1, target2);
        return true;
    }
	
    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
    {
        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
        {
            p_150894_1_.damageItem(2, p_150894_7_);
        }

        return true;
    }

    
    /** 
     * Returns True is the item is renderer in full 3D when hold.
    */
   @SideOnly(Side.CLIENT)
   public boolean isFull3D()
   {
       return true;
   }

   /**
    * returns the action that specifies what animation to play when the items is being used
    */
   public EnumAction getItemUseAction(ItemStack p_77661_1_)
   {
       return toolAction;
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getMaxItemUseDuration(ItemStack p_77626_1_)
   {
       return 72000;
   }

   /**
    * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
    */
   public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
   {
       p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
       return p_77659_1_;
   }

   public boolean func_150897_b(Block p_150897_1_)
   {
       return p_150897_1_ == Blocks.web;
   }

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability()
   {
       return this.toolMaterial.getEnchantability();
   }

   /**
    * Return the name for this tool's material.
    */
   public String getToolMaterialName()
   {
       return this.toolMaterial.toString();
   }

   /**
    * Return whether this item is repairable in an anvil.
    */
   public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
   {
       ItemStack mat = this.toolMaterial.getRepairItemStack();
       if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, p_82789_2_, false)) return true;
       return super.getIsRepairable(p_82789_1_, p_82789_2_);
   }

   /**
    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
    */
   public Multimap getItemAttributeModifiers()
   {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.attackDamage, 0));
        return multimap;
   }
    
    /////////////////////////// END COPIED CODE
    
    
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
