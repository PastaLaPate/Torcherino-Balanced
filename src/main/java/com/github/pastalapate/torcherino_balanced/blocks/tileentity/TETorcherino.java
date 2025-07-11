package com.github.pastalapate.torcherino_balanced.blocks.tileentity;

import com.github.pastalapate.torcherino_balanced.registries.ModBlockEntities;
import com.github.pastalapate.torcherino_balanced.utils.TickUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TETorcherino extends BlockEntity implements IEnergyStorage, GeoBlockEntity {

    public int speed = 20;

    private int energy;
    private int randomTicks = 3;
    private Iterable<BlockPos> area;

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private int rangeX = 3;
    private int rangeY = 3;
    private int rangeZ = 3;

    public TETorcherino(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TETorcherino_Entity.get(), pos, blockState);
        this.area = BlockPos.betweenClosed(pos.getX() - rangeX, pos.getY() - rangeY, pos.getZ() - rangeZ,
                pos.getX() + rangeX, pos.getY() + rangeY, pos.getZ() + rangeZ);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.speed = tag.getInt("speed");
        this.area = BlockPos.betweenClosed(worldPosition.getX() - rangeX, worldPosition.getY() - rangeY, worldPosition.getZ() - rangeZ,
                worldPosition.getX() + rangeX, worldPosition.getY() + rangeY, worldPosition.getZ() + rangeZ);
        if (level != null) {
            this.randomTicks = level.getGameRules().getInt(GameRules.RULE_RANDOMTICKING);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("speed", this.speed);
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, TETorcherino tileEntity) {
        if (tileEntity.area != null) {
            tileEntity.area.forEach((tickedBlockPos) -> {
                if (level.getBlockEntity(tickedBlockPos) instanceof TETorcherino) {
                    return;
                }
                if (tileEntity.energy > tileEntity.speed * 2 && TickUtils.tick(level, tickedBlockPos, tileEntity.speed, tileEntity.randomTicks)) {
                    tileEntity.energy -= tileEntity.speed * 2;
                }
            });
        }
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
        return 100_000;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    @Override
    public void setLevel(@NotNull Level level) {
        super.setLevel(level);
        this.randomTicks = level.getGameRules().getInt(GameRules.RULE_RANDOMTICKING);
    }

    public @Nullable IEnergyStorage getEnergyStorage(@Nullable Direction side) {
        return this;
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (t instanceof TETorcherino) {
            TETorcherino.tick(level, blockPos, blockState, (TETorcherino) t);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
