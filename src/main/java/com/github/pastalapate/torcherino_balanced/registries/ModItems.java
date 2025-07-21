package com.github.pastalapate.torcherino_balanced.registries;

import com.github.pastalapate.torcherino_balanced.items.AnimatedBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.github.pastalapate.torcherino_balanced.BalancedTorcherino.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> TORCHERINO_ITEM =
            ITEMS.register("torcherino",
                    () -> new AnimatedBlockItem(ModBlocks.TORCHERINO.get(),
                            new Item.Properties()));
    public static final DeferredItem<BlockItem> DEAD_COW_ITEM = ITEMS.register("dead_cow", () -> new BlockItem(ModBlocks.DEAD_COW.get(), new Item.Properties().setNoRepair().stacksTo(64)));
}
