package net.elmalteada.testmod.block;

import net.elmalteada.testmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks("testmod");

    public static final DeferredBlock<Block> DQ_BLOCK = registerBlock( "dq_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.0f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    public static final DeferredBlock<Block> DQ_ORE = registerBlock( "dq_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }





    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }

}
