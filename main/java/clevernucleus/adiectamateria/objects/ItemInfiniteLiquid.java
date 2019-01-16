package clevernucleus.adiectamateria.objects;

import java.util.List;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemInfiniteLiquid extends Item {
	
	private String var0;
	private String var1;
	
	public ItemInfiniteLiquid(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.setMaxStackSize(1);
		this.var0 = par1;
		this.var1 = par0;
		
		Objects.ITEMS.add(this);
	}

	
    /**
     * Adds a custom line of information to the mouse over description.
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par0, EntityPlayer par1, List par2, boolean par3) {
        par2.add(var0);
    }
    
    /**
     * Return an item rarity from EnumRarity based on what item is being filtered.
     */
    public EnumRarity getRarity(ItemStack par0) {
        return EnumRarity.epic;
    }
    
    /**
     * Calls the fluid to be placed on the ground and places it.
     */
    public ItemStack onItemRightClick(ItemStack par0, World par1, EntityPlayer par2) {
    	
        boolean lim0 = (var1 == Util.ITEM_INFINITE_WATER ? Blocks.flowing_water : Blocks.flowing_lava) == Blocks.air;
        MovingObjectPosition lim1 = this.getMovingObjectPositionFromPlayer(par1, par2, lim0);
        
        if(lim1 == null) {
            return par0;
        } else {
            FillBucketEvent lim2 = new FillBucketEvent(par2, par0, par1, lim1);
            if(MinecraftForge.EVENT_BUS.post(lim2)) {
                return par0;
            }
            
            if(lim2.getResult() == Event.Result.ALLOW) {
                if(par2.capabilities.isCreativeMode) {
                    return par0;
                }
                
                if(--par0.stackSize <= 0) {
                    return lim2.result;
                }
                
                if(!par2.inventory.addItemStackToInventory(lim2.result)) {
                    par2.dropPlayerItemWithRandomChoice(lim2.result, false);
                }
                return par0;
            }
            
            if(lim1.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            	
                int var3 = lim1.blockX;
                int var4 = lim1.blockY;
                int var5 = lim1.blockZ;

                if(!par1.canMineBlock(par2, var3, var4, var5)) {
                    return par0;
                }
                
                if(lim0) {
                    if(!par2.canPlayerEdit(var3, var4, var5, lim1.sideHit, par0)) {
                        return par0;
                    }
                    
                    Material lim3 = par1.getBlock(var3, var4, var5).getMaterial();
                    int var6 = par1.getBlockMetadata(var3, var4, var5);

                    if(lim3 == (var1 == Util.ITEM_INFINITE_WATER ? Material.water : Material.lava) && var6 == 0) {
                        par1.setBlockToAir(var3, var4, var5);
                        return this.func_150910_a(par0, par2, this);
                    }
                    
                    if(lim3 == (var1 == Util.ITEM_INFINITE_WATER ? Material.water : Material.lava) && var6 == 0) {
                        par1.setBlockToAir(var3, var4, var5);
                        return this.func_150910_a(par0, par2, this);
                    }
                } else {
                    if((var1 == Util.ITEM_INFINITE_WATER ? Blocks.flowing_water : Blocks.flowing_lava) == Blocks.air) {
                        return new ItemStack(this);
                    }
                    
                    if(lim1.sideHit == 0) {
                        --var4;
                    }
                    
                    if(lim1.sideHit == 1) {
                        ++var4;
                    }
                    
                    if(lim1.sideHit == 2) {
                        --var5;
                    }
                    
                    if(lim1.sideHit == 3) {
                        ++var5;
                    }
                    
                    if(lim1.sideHit == 4) {
                        --var3;
                    }
                    
                    if(lim1.sideHit == 5) {
                        ++var3;
                    }
                    
                    if(!par2.canPlayerEdit(var3, var4, var5, lim1.sideHit, par0)) {
                        return par0;
                    }
                    
                    if(this.tryPlaceContainedLiquid(par1, var3, var4, var5) && !par2.capabilities.isCreativeMode) {
                        return new ItemStack(this);
                    }
                }
            }

            return par0;
        }
    }
    
    private ItemStack func_150910_a(ItemStack par0, EntityPlayer par1, Item par2) {
        if(par1.capabilities.isCreativeMode) {
            return par0;
        } else if(--par0.stackSize <= 0) {
            return new ItemStack(par2);
        } else {
            if(!par1.inventory.addItemStackToInventory(new ItemStack(par2))) {
                par1.dropPlayerItemWithRandomChoice(new ItemStack(par2, 1, 0), false);
            }
            return par0;
        }
    }
    
    /**
     * Attempts to place the liquid contained inside the bucket.
     */
    public boolean tryPlaceContainedLiquid(World par0, int par1, int par2, int par3) {
        if((var1 == Util.ITEM_INFINITE_WATER ? Blocks.flowing_water : Blocks.flowing_lava) == Blocks.air) {
            return false;
        } else {
            Material lim4 = par0.getBlock(par1, par2, par3).getMaterial();
            boolean lim0 = !lim4.isSolid();
            
            if(!par0.isAirBlock(par1, par2, par3) && !lim0) {
                return false;
            } else {
                if(par0.provider.isHellWorld && (var1 == Util.ITEM_INFINITE_WATER ? Blocks.flowing_water : Blocks.flowing_lava) == Blocks.flowing_water) {
                    par0.playSoundEffect((double)((float)par1 + 0.5F), (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), "random.fizz", 0.5F, 2.6F + (par0.rand.nextFloat() - par0.rand.nextFloat()) * 0.8F);
                    
                    for(int var = 0; var < 8; ++var) {
                        par0.spawnParticle("largesmoke", (double)par1 + Math.random(), (double)par2 + Math.random(), (double)par3 + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                } else {
                    if(!par0.isRemote && lim0 && !lim4.isLiquid()) {
                        par0.func_147480_a(par1, par2, par3, true);
                    }
                    par0.setBlock(par1, par2, par3, (var1 == Util.ITEM_INFINITE_WATER ? Blocks.flowing_water : Blocks.flowing_lava), 0, 3);
                }
                return true;
            }
        }
    }
}
