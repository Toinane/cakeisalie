package com.toinane.cakeisalie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ParisBrestModel3 extends ModelBase
{
  //fields
    ModelRenderer bottomcake2;
    ModelRenderer middlecake3;
    ModelRenderer topcake1;
  
  public ParisBrestModel3()
  {
    textureWidth = 44;
    textureHeight = 28;
    
      bottomcake2 = new ModelRenderer(this, 0, 0);
      bottomcake2.addBox(0F, 0F, 0F, 14, 1, 4);
      bottomcake2.setRotationPoint(-7F, 23F, 3F);
      bottomcake2.setTextureSize(44, 28);
      bottomcake2.mirror = true;
      setRotation(bottomcake2, 0F, 0F, 0F);
      middlecake3 = new ModelRenderer(this, 0, 12);
      middlecake3.addBox(0F, 0F, 0F, 16, 3, 6);
      middlecake3.setRotationPoint(-8F, 20F, 2F);
      middlecake3.setTextureSize(44, 28);
      middlecake3.mirror = true;
      setRotation(middlecake3, 0F, 0F, 0F);
      topcake1 = new ModelRenderer(this, 0, 0);
      topcake1.addBox(0F, 0F, 0F, 14, 1, 4);
      topcake1.setRotationPoint(-7F, 19F, 3F);
      topcake1.setTextureSize(44, 28);
      topcake1.mirror = true;
      setRotation(topcake1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    bottomcake2.render(f5);
    middlecake3.render(f5);
    topcake1.render(f5);
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
