package com.github.pastalapate.torcherino_balanced.registries;

import com.github.pastalapate.torcherino_balanced.blocks.TorcherinoBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.github.pastalapate.torcherino_balanced.BalancedTorcherino.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> TORCHERINO = BLOCKS.register("torcherino", () -> new TorcherinoBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.STONE)));
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ModItems.ITEMS.registerSimpleBlockItem("example_block", TORCHERINO);

}
