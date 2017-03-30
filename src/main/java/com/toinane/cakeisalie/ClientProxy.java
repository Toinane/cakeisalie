package com.toinane.cakeisalie;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy{

	 public void registerRenderThings() {
         ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnniversary.class, new RendererAnniversary());
         ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParisBrest.class, new RendererParisBrest());
         ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParisBrest2.class, new RendererParisBrest2());
         ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParisBrest3.class, new RendererParisBrest3());
	 }
}
