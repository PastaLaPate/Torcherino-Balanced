package com.github.pastalapate.torcherino_balanced.blocks.tileentity;

import com.github.pastalapate.torcherino_balanced.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

public class TETorcherino extends BlockEntity implements IEnergyStorage {

    private int energy;
    public int speed;

    public TETorcherino(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TETorcherino_Entity.get(), pos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.speed = tag.getInt("speed");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("speed", this.speed);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {

    }

    @Override
    public int receiveEnergy(int amount, boolean simulate) {
        int accepted = Math.min(amount, this.getMaxEnergyStored() - this.getEnergyStored());
        if (!simulate) {
            this.energy += accepted;
        }
        return accepted;
    }

    @Override
    public int extractEnergy(int amount, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return this.energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return 10000;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    public @Nullable IEnergyStorage getEnergyStorage(@Nullable Direction side) {
        return this;
    }
}
