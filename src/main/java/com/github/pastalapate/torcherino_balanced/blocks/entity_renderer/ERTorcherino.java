package com.github.pastalapate.torcherino_balanced.blocks.entity_renderer;

import com.github.pastalapate.torcherino_balanced.BalancedTorcherino;
import com.github.pastalapate.torcherino_balanced.blocks.tileentity.TETorcherino;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ERTorcherino extends GeoBlockRenderer<TETorcherino> {

    public ERTorcherino(BlockEntityRendererProvider.Context context) {
        super(new DefaultedBlockGeoModel<>(ResourceLocation.fromNamespaceAndPath(BalancedTorcherino.MODID, "torcherino")));
    }
}
