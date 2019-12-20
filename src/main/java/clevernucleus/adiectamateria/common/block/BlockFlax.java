package clevernucleus.adiectamateria.common.block;

import java.util.Random;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.item.ItemCreativeTab;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockReed;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlax extends BlockBush implements IGrowable, IHasModel {
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
    private static final AxisAlignedBB[] BOUNDS = new AxisAlignedBB[] {new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.125D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.25D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.375D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.625D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.75D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.875D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D)};
    
	public BlockFlax(String par0) {
		super(Material.PLANTS);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setSoundType(SoundType.PLANT);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
	  return null;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState par0, IBlockAccess par1, BlockPos par2) {
        return BOUNDS[((Integer)par0.getValue(this.getAgeProperty())).intValue()];
    }
	
	protected PropertyInteger getAgeProperty() {
        return AGE;
    }
	
	public int getMaxAge() {
        return 7;
    }
	
	public boolean isMaxAge(IBlockState par0) {
        return ((Integer)par0.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
	
	public IBlockState withAge(int par0) {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(par0));
    }
	
	protected int getAge(IBlockState par0) {
        return ((Integer)par0.getValue(this.getAgeProperty())).intValue();
    }
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	protected boolean canSustainBush(IBlockState par0) {
        return par0.getBlock() == Blocks.FARMLAND || par0 == this.getStateFromMeta(7);
    }
	
	protected static float getGrowthChance(Block par0, World par1, BlockPos par2) {
        float var0 = 1.0F;
        
        BlockPos var1 = par2.down();
        
        for(int varA = -1; varA <= 1; ++varA) {
            for(int varB = -1; varB <= 1; ++varB) {
                float var2 = 0.0F;
                
                IBlockState var3 = par1.getBlockState(var1.add(varA, 0, varB));
                
                if(var3.getBlock().canSustainPlant(var3, par1, var1.add(varA, 0, varB), net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)par0)) {
                	var2 = 1.0F;
                    
                    if(var3.getBlock().isFertile(par1, var1.add(varA, 0, varB))) {
                    	var2 = 3.0F;
                    }
                }
                
                if(varA != 0 || varB != 0) {
                	var2 /= 4.0F;
                }
                
                var0 += var2;
            }
        }
        
        BlockPos var2 = par2.north();
        BlockPos var3 = par2.south();
        BlockPos var4 = par2.west();
        BlockPos var5 = par2.east();
        
        boolean var6 = par0 == par1.getBlockState(var4).getBlock() || par0 == par1.getBlockState(var5).getBlock();
        boolean var7 = par0 == par1.getBlockState(var2).getBlock() || par0 == par1.getBlockState(var3).getBlock();
        
        if(var6 && var7) {
        	var0 /= 2.0F;
        } else {
            boolean flag2 = par0 == par1.getBlockState(var4.north()).getBlock() || par0 == par1.getBlockState(var5.north()).getBlock() || par0 == par1.getBlockState(var5.south()).getBlock() || par0 == par1.getBlockState(var4.south()).getBlock();
            
            if(flag2) {
            	var0 /= 2.0F;
            }
        }
        
        return var0;
    }
	
	@Override
	public void updateTick(World par0, BlockPos par1, IBlockState par2, Random par3) {
        super.updateTick(par0, par1, par2, par3);
        
        if(!par0.isAreaLoaded(par1, 1)) return;
        if(par0.getLightFromNeighbors(par1.up()) >= 9) {
            int var0 = this.getAge(par2);
            
            if(var0 < this.getMaxAge()) {
                float f = getGrowthChance(this, par0, par1);
                
                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(par0, par1, par2, par3.nextInt((int)(25.0F / f) + 1) == 0)) {
                	par0.setBlockState(par1, this.withAge(var0 + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(par0, par1, par2, par0.getBlockState(par1));
                }
            } else if(var0 == this.getMaxAge() && par0.isAirBlock(par1.up())) {
            	if(par0.getBlockState(par1.down()).getBlock() == this) {
            		if(this.getAge(par0.getBlockState(par1.down())) == this.getMaxAge()) {
            			if(par0.getBlockState(par1.down(2)).getBlock() == this) {
            				if(this.getAge(par0.getBlockState(par1.down(2))) == this.getMaxAge()) {
            					return;
            				}
            			} else if(par0.getBlockState(par1.down(2)).getBlock() == Blocks.FARMLAND) {
            				par0.setBlockState(par1.up(), this.getDefaultState());
            			}
            		}
            	} else if(par0.getBlockState(par1.down()).getBlock() == Blocks.FARMLAND) {
            		par0.setBlockState(par1.up(), this.getDefaultState());
            	}
            }
        }
    }
	
	@Override
	public Item getItemDropped(IBlockState par0, Random par1, int par2) {
		return ItemInit.FLAX;
	}
	
	@Override
	public boolean canBlockStay(World par0, BlockPos par1, IBlockState par2) {
        IBlockState var0 = par0.getBlockState(par1.down());
        
        return (par0.getLight(par1) >= 8 || par0.canSeeSky(par1)) && (var0.getBlock().canSustainPlant(var0, par0, par1.down(), net.minecraft.util.EnumFacing.UP, this) || var0.getBlock() == this);
    }
	
	@Override
	public boolean canGrow(World par0, BlockPos par1, IBlockState par2, boolean par3) {
		return !this.isMaxAge(par2);
	}
	
	@Override
	public boolean canUseBonemeal(World par0, Random par1, BlockPos par2, IBlockState par3) {
		return false;
	}
	
	@Override
	public void grow(World par0, Random par1, BlockPos par2, IBlockState par3) {
		this.grow(par0, par1, par2, par3);
	}
	
	@Override
	public IBlockState getStateFromMeta(int par0) {
        return this.withAge(par0);
    }
	
	@Override
    public int getMetaFromState(IBlockState par0) {
        return this.getAge(par0);
    }
    
	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }
}
