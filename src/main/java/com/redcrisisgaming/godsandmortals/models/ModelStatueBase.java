// Date: 5/29/2015 19:49:14
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package com.redcrisisgaming.godsandmortals.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStatueBase extends ModelBase
{
  //fields
    ModelRenderer Structure;
    ModelRenderer base;
    ModelRenderer base2;
    ModelRenderer base3;
  
  public ModelStatueBase()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Structure = new ModelRenderer(this, 0, 0);
      Structure.addBox(-2.5F, 0F, 0F, 5, 24, 3);
      Structure.setRotationPoint(0F, 0F, 0F);
      Structure.setTextureSize(64, 32);
      Structure.mirror = true;
      setRotation(Structure, 0F, 0F, 0F);
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 16, 1, 16);
      base.setRotationPoint(-8F, 23F, -8F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 0, 0);
      base2.addBox(0F, 0F, 0F, 14, 1, 14);
      base2.setRotationPoint(-7F, 22F, -7F);
      base2.setTextureSize(64, 32);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      base3 = new ModelRenderer(this, 0, 0);
      base3.addBox(0F, 0F, 0F, 12, 1, 12);
      base3.setRotationPoint(-6F, 21F, -6F);
      base3.setTextureSize(64, 32);
      base3.mirror = true;
      setRotation(base3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Structure.render(f5);
    base.render(f5);
    base2.render(f5);
    base3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}