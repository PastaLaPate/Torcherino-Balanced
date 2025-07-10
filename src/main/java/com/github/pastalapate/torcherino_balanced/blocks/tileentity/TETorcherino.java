package com.github.pastalapate.torcherino_balanced.blocks.tileentity;

import net.minecraft.client.renderer.texture.Tickable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Nameable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TETorcherino extends BlockEntity implements Nameable, Tickable {
    public TETorcherino(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }


    @Override
    public void tick() {

    }

    @Override
    public Component getName() {
        return Component.literal("torcherino_tileentity");
    }

    @Override
    public boolean hasCustomName() {
        return Nameable.super.hasCustomName();
    }

    @Override
    public Component getDisplayName() {
        return Nameable.super.getDisplayName();
    }

    @Override
    public @Nullable Component getCustomName() {
        return Nameable.super.getCustomName();
    }

}
