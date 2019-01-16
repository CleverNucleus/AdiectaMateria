package clevernucleus.adiectamateria.objects;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class ItemInfiniteLiquidWater extends Item implements IModel {
	
	public static String var0;
	private Block var1;
	public static Item var2;
	
	public ItemInfiniteLiquidWater(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.maxStackSize = 1;
        this.var0 = par1;
        this.var2 = this;
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		
		Objects.ITEMS.add(this);
	}
	   
    /**
     * Adds a tool tip display message to the item.
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par0, @Nullable World par1, List<String> par2, ITooltipFlag par3) {
    	par2.add(var0);
        super.addInformation(par0, par1, par2, par3);
    }
	
	/**
	 * Fired when right-clicked - not to be confused with onItemUse().
	 */
	public ActionResult<ItemStack> onItemRightClick(World par0, EntityPlayer par1, EnumHand par2) {
        boolean var1 = this.var1 == Blocks.AIR;
        
        ItemStack var2 = par1.getHeldItem(par2);
        RayTraceResult var3 = this.rayTrace(par0, par1, var1);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(par1, par0, var2, var3);
        
        if(ret != null) return ret;
        
        if(var3 == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, var2);
        } else if(var3.typeOfHit != RayTraceResult.Type.BLOCK) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, var2);
        } else {
            BlockPos var4 = var3.getBlockPos();
            
            if(!par0.isBlockModifiable(par1, var4)) {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, var2);
            } else if(var1) {
                if(!par1.canPlayerEdit(var4.offset(var3.sideHit), var3.sideHit, var2)) {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, var2);
                } else {
                    IBlockState lim0 = par0.getBlockState(var4);
                    Material lim1 = lim0.getMaterial();
                    
                    if(lim1 == Material.WATER && ((Integer)lim0.getValue(BlockLiquid.LEVEL)).intValue() == 0) {
                        par0.setBlockState(var4, Blocks.AIR.getDefaultState(), 11);
                        par1.addStat(StatList.getObjectUseStats(this));
                        par1.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                        
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.fillBucket(var2, par1, Objects.ITEM_INFINITE_WATER));
                    } else if(lim1 == Material.WATER && ((Integer)lim0.getValue(BlockLiquid.LEVEL)).intValue() == 0) {
                        par1.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                        par0.setBlockState(var4, Blocks.AIR.getDefaultState(), 11);
                        par1.addStat(StatList.getObjectUseStats(this));
                        
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.fillBucket(var2, par1, Objects.ITEM_INFINITE_WATER));
                    } else {
                        return new ActionResult<ItemStack>(EnumActionResult.FAIL, var2);
                    }
                }
            } else {
                boolean var5 = par0.getBlockState(var4).getBlock().isReplaceable(par0, var4);
                
                BlockPos var6 = var5 && var3.sideHit == EnumFacing.UP ? var4 : var4.offset(var3.sideHit);
                
                if(!par1.canPlayerEdit(var6, var3.sideHit, var2)) {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, var2);
                } else if(this.tryPlaceContainedLiquid(par1, par0, var6)) {
                    if(par1 instanceof EntityPlayerMP) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)par1, var6, var2);
                    }
                    
                    par1.addStat(StatList.getObjectUseStats(this));
                    
                    return !par1.capabilities.isCreativeMode ? new ActionResult(EnumActionResult.SUCCESS, new ItemStack(Objects.ITEM_INFINITE_WATER)) : new ActionResult(EnumActionResult.SUCCESS, var2);
                } else {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, var2);
                }
            }
        }
    }
	
	/**
	 * Determines what fluid item to add to inventory, and what to do when the player is in creative mode.
	 */
    private ItemStack fillBucket(ItemStack par0, EntityPlayer par1, Item par2) {
        if(par1.capabilities.isCreativeMode) {
            return par0;
        } else {
            par0.shrink(1);
            
            if(par0.isEmpty()) {
                return new ItemStack(par2);
            } else {
                if(!par1.inventory.addItemStackToInventory(new ItemStack(par2))) {
                    par1.dropItem(new ItemStack(par2), false);
                }
                return par0;
            }
        }
    }
    
    /**
     * Attempts to place a fluid in the world, and determines what fluid to place.
     */
    public boolean tryPlaceContainedLiquid(@Nullable EntityPlayer par0, World par1, BlockPos par2) {
        if(this.var1 == Blocks.AIR) {
            return false;
        } else {
            IBlockState var7 = par1.getBlockState(par2);
            Material var8 = var7.getMaterial();
            
            boolean var9 = !var8.isSolid();
            boolean var10 = var7.getBlock().isReplaceable(par1, par2);
            
            if(!par1.isAirBlock(par2) && !var9 && !var10) {
                return false;
            } else {
                if(par1.provider.doesWaterVaporize() && this.var1 == Blocks.FLOWING_WATER) {
                    int l = par2.getX();
                    int i = par2.getY();
                    int j = par2.getZ();
                    
                    par1.playSound(par0, par2, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (par1.rand.nextFloat() - par1.rand.nextFloat()) * 0.8F);
                    
                    for(int var = 0; var < 8; ++var) {
                        par1.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                } else {
                    if(!par1.isRemote && (var9 || var10) && !var8.isLiquid()) {
                        par1.destroyBlock(par2, true);
                    }
                    
                    SoundEvent var11 = Blocks.FLOWING_WATER != null ? SoundEvents.ITEM_BUCKET_EMPTY : SoundEvents.ITEM_BUCKET_EMPTY;
                    
                    par1.playSound(par0, par2, var11, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    par1.setBlockState(par2, Blocks.FLOWING_WATER.getDefaultState(), 11);
                }
                return true;
            }
        }
    }
    
    /**
     * Compatibility provider to inventories that use fluids/buckets; e.g. the Transposer from Thermal Foundation.
     */
    @Nonnull
	@Override
	public ICapabilityProvider initCapabilities(ItemStack par0, NBTTagCompound par1) {
		return new ICapabilityProvider() {
			private final IFluidHandlerItem var12 = new InfiniteFluidHandler(par0);
			
			@Override
			public boolean hasCapability(@Nonnull Capability<?> par0, @Nullable EnumFacing par1) {
				return par0 == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY;
			}
			
			@Override
			public <T> T getCapability(@Nonnull Capability<T> par0, @Nullable EnumFacing par1) {
				if(par0 == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY) {
					return CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY.cast(var12);
				} else {
					return null;
				}
			}
		};
	}
	
    /**
     * @name AdiectaMateria
     * @author CleverNucleus
     * @license Apache 2.0
     * 
     * Subclass that handles fluids and allows interactions between inventories.
     */
    
    private static class InfiniteFluidHandler implements IFluidHandlerItem {
		private final ItemStack var13;
		
		InfiniteFluidHandler(ItemStack stack) {
			var13 = stack;
		}
		
		private final FluidTankProperties var14 = new FluidTankProperties(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME), Fluid.BUCKET_VOLUME);
		
		@Override
		public IFluidTankProperties[] getTankProperties() {
			return new IFluidTankProperties[] {var14};
		}
		
		@Override
		public int fill(FluidStack par0, boolean par1) {
			return 0;
		}
		
		@Nullable
		@Override
		public FluidStack drain(FluidStack par0, boolean par1) {
			if(par0.getFluid() == FluidRegistry.WATER) {
				return par0.copy();
			} else {
				return null;
			}
		}
		
		@Nullable
		@Override
		public FluidStack drain(int par0, boolean par1) {
			return new FluidStack(FluidRegistry.WATER, Math.min(par0, Fluid.BUCKET_VOLUME));
		}
		
		@Nonnull
		@Override
		public ItemStack getContainer() {
			return var13;
		}
	}
    
    /**
     * Registers the item model to be displayed in the inventory.
     */
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
