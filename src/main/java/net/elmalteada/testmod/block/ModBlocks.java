package net.elmalteada.testmod.block;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks("testmod");

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }

}
