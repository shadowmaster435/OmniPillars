package shadowmaster435.omnipillars.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import shadowmaster435.omnipillars.Omnipillars;

@Environment(EnvType.CLIENT)
public class OmnipillarsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Omnipillars.QUARTZ, RenderLayer.getCutout());

    }
}
