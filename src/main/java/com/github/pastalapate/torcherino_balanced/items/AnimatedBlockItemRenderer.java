package com.github.pastalapate.torcherino_balanced.items;

import com.github.pastalapate.torcherino_balanced.BalancedTorcherino;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedBlockItemRenderer extends GeoItemRenderer<AnimatedBlockItem> {
    public AnimatedBlockItemRenderer() {
        super(new DefaultedBlockGeoModel<>(ResourceLocation.fromNamespaceAndPath(BalancedTorcherino.MODID, "torcherino")));
    }
}