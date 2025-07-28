package net.elmalteada.testmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class FluidTankBlockEntity extends BlockEntity implements MenuProvider, TickableBlockEntity {
    private final FluidTank fluidTank = new FluidTank(8000); // 8000 mB = 8 cubos

    public FluidTankBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.FLUID_TANK.get(), pos, state);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        return new FluidTankMenu(id, playerInventory, this);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Tanque de Fluidos");
    }

    public FluidTank getTank() {
        return fluidTank;
    }

    // Métodos para guardar/cargar NBT
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        fluidTank.readFromNBT(tag.getCompound("Tank"));
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Tank", fluidTank.writeToNBT(new CompoundTag()));
    }
}
