package net.elmalteada.testmod.datagen;

import net.elmalteada.testmod.block.ModBlocks;
import net.elmalteada.testmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class ReglasDeLaHerencia extends BlockLootSubProvider {
    public ReglasDeLaHerencia(Object provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), (HolderLookup.Provider) provider);
    }


    @Override
    protected void generate() {
        //Aqui se crea una regla cuando DQ_BLOCK se rompa, soltara DQ_ITEM
        this.add(ModBlocks.DQ_BLOCK.get(),
                (block) -> createSingleItemTable(ModItems.DQ_ITEM.get()));
    }
}

