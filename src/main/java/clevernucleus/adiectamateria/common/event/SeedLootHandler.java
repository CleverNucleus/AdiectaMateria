package clevernucleus.adiectamateria.common.event;

import clevernucleus.adiectamateria.common.block.BlockInit;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SeedLootHandler {
	private static LootEntry loot = new LootEntryItem(ItemInit.GOLD_BARS, 100, 50, new LootFunction[0], new LootCondition[0], Util.MODID + ":loot_gold_bars");
	
	@SubscribeEvent
	public void onItemUse(PlayerInteractEvent.RightClickBlock par0) {
		EntityPlayer var0 = par0.getEntityPlayer();
		ItemStack var1 = par0.getItemStack();
		BlockPos var2 = par0.getPos();
		World var3 = par0.getWorld();
		IBlockState var4 = var3.getBlockState(var2);
		
		if(var1.getItem() == Items.BONE) {
			if(var4.getBlock() == Blocks.FARMLAND && var3.isAirBlock(var2.up())) {
				var3.setBlockState(var2.up(), BlockInit.DEAD_CROP.getDefaultState());
				
				if(!var0.capabilities.isCreativeMode) {
					var1.shrink(1);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onLootTableLoad(LootTableLoadEvent par0) {
		if(par0.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
			par0.getTable().getPool("main").addEntry(loot);
		}
		
		if(par0.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
			par0.getTable().getPool("main").addEntry(loot);
		}
		
		if(par0.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
			par0.getTable().getPool("main").addEntry(loot);
		}
		
		if(par0.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)) {
			par0.getTable().getPool("main").addEntry(loot);
		}
	}
}
