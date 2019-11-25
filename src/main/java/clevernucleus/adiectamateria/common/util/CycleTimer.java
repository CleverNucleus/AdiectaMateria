package clevernucleus.adiectamateria.common.util;

import java.util.HashMap;
import java.util.List;

import clevernucleus.adiectamateria.common.util.recipes.Transmuting;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class CycleTimer {
	private long time;
	private final long max = 70;
	private List<Block> list;
	private HashMap<Block, Integer> timings = new HashMap<>();
	
	public CycleTimer(List<Block> par0) {
		this.time = 0;
		this.list = par0;
		
		for(Block var : par0) {
			this.timings.put(var, 0);
		}
	}
	
	public void incrementTime() {
		time++;
		
		if(time == max) {
			time = 0;
			
			for(Block var : list) {
				if(timings.get(var) < (Transmuting.getExceptionMap().get(var).size() - 1)) {
					timings.put(var, timings.get(var) + 1);
				} else {
					timings.put(var, 0);
				}
			}
		}
	}
	
	public ItemStack getStack(Block par1, int par2) {
		int index = (timings.get(par1) + par2) == Transmuting.getExceptionMap().get(par1).size() ? 0 : (timings.get(par1) + par2);
		
		if(par1 == Blocks.LOG) {
			ItemStack[] stacks = new ItemStack[] {new ItemStack(Blocks.LOG, 1, 0), new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(Blocks.LOG, 1, 1), new ItemStack(Blocks.LOG, 1, 2), new ItemStack(Blocks.LOG, 1, 3), new ItemStack(Blocks.LOG2, 1, 0)};
			
			return stacks[index];
		} else if(par1 == Blocks.PLANKS) {
			ItemStack[] stacks = new ItemStack[] {new ItemStack(Blocks.PLANKS, 1, 0), new ItemStack(Blocks.PLANKS, 1, 5), new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(Blocks.PLANKS, 1, 2), new ItemStack(Blocks.PLANKS, 1, 3), new ItemStack(Blocks.PLANKS, 1, 4)};
			
			return stacks[index];
		} else if(par1 == Blocks.SAPLING) {
			ItemStack[] stacks = new ItemStack[] {new ItemStack(Blocks.SAPLING, 1, 0), new ItemStack(Blocks.SAPLING, 1, 5), new ItemStack(Blocks.SAPLING, 1, 1), new ItemStack(Blocks.SAPLING, 1, 2), new ItemStack(Blocks.SAPLING, 1, 3), new ItemStack(Blocks.SAPLING, 1, 4)};
			
			return stacks[index];
		} else {
			return Transmuting.getExceptionMap().get(par1).get(index);
		}
	}
}
