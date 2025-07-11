package com.github.pastalapate.torcherino_balanced.registries;

import com.github.pastalapate.torcherino_balanced.blocks.tileentity.TETorcherino;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static com.github.pastalapate.torcherino_balanced.BalancedTorcherino.MODID;
import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);
    public static final Supplier<BlockEntityType<TETorcherino>> TETorcherino_Entity = BLOCK_ENTITY_TYPES.register(
            "torcherino_te",
            () -> BlockEntityType.Builder.of(
                    TETorcherino::new,
                    ModBlocks.TORCHERINO.get()

            ).build(null)
    );

    public static final BlockCapability<IEnergyStorage, @Nullable Direction> TORCHERINO_CAPABILITY = BlockCapability.create(
            ResourceLocation.fromNamespaceAndPath(MODID, "energy_torcherino"),
            IEnergyStorage.class,
            Direction.class
    );

}
