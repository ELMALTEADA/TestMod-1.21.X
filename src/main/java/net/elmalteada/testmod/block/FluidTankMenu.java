package net.elmalteada.testmod.block;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class FluidTankMenu extends AbstractContainerMenu {
    public final FluidTankBlockEntity blockEntity;

    public FluidTankMenu(int id, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(id, playerInventory, (FluidTankBlockEntity) playerInventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public FluidTankMenu(int id, Inventory playerInventory, FluidTankBlockEntity blockEntity) {
        super(ModMenus.FLUID_TANK_MENU.get(), id);
        this.blockEntity = blockEntity;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
