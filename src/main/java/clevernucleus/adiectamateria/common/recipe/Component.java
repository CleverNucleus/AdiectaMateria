package clevernucleus.adiectamateria.common.recipe;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Component<T extends Comparable<T>, V extends T> {
	private IProperty<T> property;
	private V type;
	private Block block;
	private ItemStack stack;
	
	private boolean hasProperties;
	
	public Component(Block par0) {
		this.block = par0;
		this.stack = ItemStack.EMPTY;
		
		this.hasProperties = false;
	}
	
	public Component(Block par0, int par1, int par2) {
		this.stack = new ItemStack(par0, par1, par2);
		this.block = Blocks.AIR;
		
		this.hasProperties = false;
	}
	
	public Component(Item par0, int par1, int par2) {
		this.stack = new ItemStack(par0, par1, par2);
		this.block = Blocks.AIR;
		
		this.hasProperties = false;
	}
	
	public Component addProperty(IProperty<T> par0, V par1) {
		this.property = par0;
		this.type = par1;
		
		this.hasProperties = true;
		
		return this;
	}
	
	public IProperty<T> getProperty() {
		return property;
	}
	
	public V getType() {
		return type;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public ItemStack getStack() {
		return stack;
	}
	
	public ItemStack getDisplayStack() {
		ItemStack var0 = stack;
		
		if(stack == ItemStack.EMPTY) {
			int var1 = 0;
			
			if(hasProperties) {
				IBlockState var2 = block.getDefaultState().withProperty(property, type);
				
				var1 = block.getMetaFromState(var2);
			} else {
				var1 = 0;
			}
			
			if(block instanceof BlockLiquid) {
				var0 = new ItemStack(block == Blocks.FLOWING_WATER ? Items.WATER_BUCKET : (block == Blocks.FLOWING_LAVA ? Items.LAVA_BUCKET : Items.BUCKET), 1);
			} else {
				var0 = new ItemStack(block, 1, var1);
			}
		}
		
		return var0;
	}
	
	public boolean hasProperties() {
		return hasProperties;
	}
	
	@Override
	public String toString() {
		return (stack == ItemStack.EMPTY ? block.getUnlocalizedName().substring(5) + ":" + property.getName() + ":" + type : stack.getDisplayName() + ":" + stack.getCount() + ":" + stack.getMetadata());
	}
}
