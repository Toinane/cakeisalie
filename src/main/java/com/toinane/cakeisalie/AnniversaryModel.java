package com.toinane.cakeisalie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class AnniversaryModel extends ModelBase
{
  //fields
    ModelRenderer cake;
    ModelRenderer fire1;
    ModelRenderer fire2;
    ModelRenderer fire3;
    ModelRenderer fire4;
  
  public AnniversaryModel()
  {
    textureWidth = 56;
    textureHeight = 22;
    
      cake = new ModelRenderer(this, 0, 0);
      cake.addBox(0F, 0F, 0F, 14, 8, 14);
      cake.setRotationPoint(-7F, 16F, -7F);
      cake.setTextureSize(56, 22);
      cake.mirror = true;
      setRotation(cake, 0F, 0F, 0F);
      fire1 = new ModelRenderer(this, 0, 0);
      fire1.addBox(0F, 0F, 0F, 2, 4, 2);
      fire1.setRotationPoint(4F, 12F, 4F);
      fire1.setTextureSize(56, 22);
      fire1.mirror = true;
      setRotation(fire1, 0F, 0F, 0F);
      fire2 = new ModelRenderer(this, 0, 0);
      fire2.addBox(0F, 0F, 0F, 2, 4, 2);
      fire2.setRotationPoint(4F, 12F, -6F);
      fire2.setTextureSize(56, 22);
      fire2.mirror = true;
      setRotation(fire2, 0F, 0F, 0F);
      fire3 = new ModelRenderer(this, 0, 0);
      fire3.addBox(0F, 0F, 0F, 2, 4, 2);
      fire3.setRotationPoint(-6F, 12F, 4F);
      fire3.setTextureSize(56, 22);
      fire3.mirror = true;
      setRotation(fire3, 0F, 0F, 0F);
      fire4 = new ModelRenderer(this, 0, 0);
      fire4.addBox(0F, 0F, 0F, 2, 4, 2);
      fire4.setRotationPoint(-6F, 12F, -6F);
      fire4.setTextureSize(56, 22);
      fire4.mirror = true;
      setRotation(fire4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    cake.render(f5);
    fire1.render(f5);
    fire2.render(f5);
    fire3.render(f5);
    fire4.render(f5);
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
