package com.github.pastalapate.torcherino_balanced.blocks;

import com.github.pastalapate.torcherino_balanced.blocks.tileentity.TETorcherino;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static com.github.pastalapate.torcherino_balanced.registries.ModBlockEntities.TETorcherino_Entity;

public class TorcherinoBlock extends Block implements EntityBlock {
    public TorcherinoBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TETorcherino(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == TETorcherino_Entity ? (BlockEntityTicker<T>) TETorcherino::tick : null;
    }
}
