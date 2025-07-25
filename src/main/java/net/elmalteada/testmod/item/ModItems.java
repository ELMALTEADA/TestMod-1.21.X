package net.elmalteada.testmod.item;

import net.elmalteada.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> DQ_ITEM = ITEMS.register("dq_item",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DQ_BLOCK_ITEM = ITEMS.register("dq_block_item",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
