package clevernucleus.adiectamateria.common.init.endercrate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

@SuppressWarnings("unchecked")
public class EnderCrateTileEntity extends TileEntity {
	private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
	private final String key = "contents";
	
	public EnderCrateTileEntity() {
		super(Registry.ENDER_CRATE_TILE_ENTITY);
	}
	
	@Override
    public void read(CompoundNBT par0) {
        CompoundNBT var0 = par0.getCompound(key);
        
        handler.ifPresent(var -> ((INBTSerializable<CompoundNBT>)var).deserializeNBT(var0));
        
        super.read(par0);
    }
	
    @Override
    public CompoundNBT write(CompoundNBT par0) {
        handler.ifPresent(var -> {
            CompoundNBT var0 = ((INBTSerializable<CompoundNBT>)var).serializeNBT();
            
            par0.put(key, var0);
        });
        
        return super.write(par0);
    }
    
    private IItemHandler createHandler() {
        return new ItemStackHandler(AdiectaMateria.SIZE) {
        	
            @Override
            protected void onContentsChanged(int par0) {
                markDirty();
            }
        };
    }
    
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> par0, @Nullable Direction par1) {
        if(par0 == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	return handler.cast();
        }
        
        return super.getCapability(par0, par1);
    }
}
