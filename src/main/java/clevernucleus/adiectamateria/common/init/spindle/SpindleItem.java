package clevernucleus.adiectamateria.common.init.spindle;

import java.util.Collection;

import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpindleItem extends Item {
	private static final String STATE = "State";
	private static final Collection<Block> EFFECTIVE_ON = Util.set(var -> {
		var.add(Blocks.WHITE_WOOL);
		var.add(Blocks.ORANGE_WOOL);
		var.add(Blocks.MAGENTA_WOOL);
		var.add(Blocks.LIGHT_BLUE_WOOL);
		var.add(Blocks.YELLOW_WOOL);
		var.add(Blocks.LIME_WOOL);
		var.add(Blocks.PINK_WOOL);
		var.add(Blocks.GRAY_WOOL);
		var.add(Blocks.LIGHT_GRAY_WOOL);
		var.add(Blocks.CYAN_WOOL);
		var.add(Blocks.PURPLE_WOOL);
		var.add(Blocks.BLUE_WOOL);
		var.add(Blocks.BROWN_WOOL);
		var.add(Blocks.GREEN_WOOL);
		var.add(Blocks.RED_WOOL);
		var.add(Blocks.BLACK_WOOL);
	});
	
	public SpindleItem(Properties par0) {
		super(par0.defaultMaxDamage(25));
	}
	
	public void setFull(ItemStack par0, final boolean par1) {
		if(!par0.hasTag()) {
			par0.setTag(new CompoundNBT());
		}
		
		par0.getTag().putBoolean(STATE, par1);
	}
	
	public boolean isFull(ItemStack par0) {
		if(!par0.hasTag()) return false;
		if(!par0.getTag().contains(STATE)) return false;
		
		return par0.getTag().getBoolean(STATE);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext par0) {
		World var0 = par0.getWorld();
		BlockPos var1 = par0.getPos();
		ItemStack var2 = par0.getItem();
		Block var3 = var0.getBlockState(var1).getBlock();
		
		if(!this.isFull(var2) && EFFECTIVE_ON.contains(var3)) {
			if(!var0.isRemote) {
				PlayerEntity var4 = par0.getPlayer();
				
				if(var4 == null) return ActionResultType.PASS;
				
				this.setFull(var2, true);
				var0.setBlockState(var1, Blocks.AIR.getDefaultState(), 11);
				par0.getItem().damageItem(1, var4, var -> {
					var.sendBreakAnimation(par0.getHand());
				});
				
				var0.playSound((PlayerEntity)null, var1, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.PASS;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World par0, PlayerEntity par1, Hand par2) {
		ItemStack var0 = par1.getHeldItem(par2);
		
		if(par0.isRemote) return ActionResult.resultPass(var0);
		if(!par1.isCrouching()) return ActionResult.resultPass(var0);
		if(this.isFull(var0)) {
			this.setFull(var0, false);
			
			ItemEntity var1 = new ItemEntity(par0, par1.getPosX(), par1.getPosY(), par1.getPosZ(), new ItemStack(Items.STRING, 4));
			
			par0.addEntity(var1);
			
			return ActionResult.resultSuccess(var0);
		}
		
		return ActionResult.resultPass(var0);
	}
}
