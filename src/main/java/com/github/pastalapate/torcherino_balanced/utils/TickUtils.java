package com.github.pastalapate.torcherino_balanced.utils;

import com.github.pastalapate.torcherino_balanced.BalancedTorcherino;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class TickUtils {
    public static boolean tick(Level level, BlockPos pos, int tickNumber, int randomTicks) { // Returns if ticked or not
        BlockState blockState = level.getBlockState(pos);
        Block block = blockState.getBlock();
        // Implement blacklist here
        if (level instanceof ServerLevel && blockState.isRandomlyTicking() &&
        level.getRandom().nextInt(Math.clamp(4096 / (tickNumber * 4L), 1, 4096)) < randomTicks) {
            blockState.randomTick((ServerLevel) level, pos, level.getRandom());
        }
        if(!(block instanceof EntityBlock entityBlock)) {
            //BalancedTorcherino.LOGGER.info("No entity block for {} at {}", block.getName(), pos.toShortString());
            return false;
        }
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity != null) {
            //noinspection unchecked
            BlockEntityTicker<BlockEntity> ticker = (BlockEntityTicker<BlockEntity>) entityBlock.getTicker(level, blockState, blockEntity.getType());
            if (blockEntity.isRemoved() || ticker == null) return false;
            for (int tickIndex = 0; tickIndex < tickNumber; tickIndex++) {
                if (blockEntity.isRemoved()) return true;
                ticker.tick(level, pos, blockState, blockEntity);
            }
        }

        return true;
    }
}
