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
		super(par0.defaultDurability(25));
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
	public ActionResultType useOn(ItemUseContext par0) {
		World var0 = par0.getLevel();
		BlockPos var1 = par0.getClickedPos();
		ItemStack var2 = par0.getItemInHand();
		Block var3 = var0.getBlockState(var1).getBlock();
		
		if(!this.isFull(var2) && EFFECTIVE_ON.contains(var3)) {
			if(!var0.isClientSide) {
				PlayerEntity var4 = par0.getPlayer();
				
				if(var4 == null) return ActionResultType.PASS;
				
				this.setFull(var2, true);
				var0.setBlock(var1, Blocks.AIR.defaultBlockState(), 11);
				var2.hurtAndBreak(1, var4, var -> {
					var.broadcastBreakEvent(par0.getHand());
				});
				
				var0.playSound((PlayerEntity)null, var1, SoundEvents.WOOL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.PASS;
	}
	
	@Override
	public ActionResult<ItemStack> use(World par0, PlayerEntity par1, Hand par2) {
		ItemStack var0 = par1.getItemInHand(par2);
		
		if(par0.isClientSide) return ActionResult.pass(var0);
		if(!par1.isCrouching()) return ActionResult.pass(var0);
		if(this.isFull(var0)) {
			this.setFull(var0, false);
			
			ItemEntity var1 = new ItemEntity(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(Items.STRING, 4));
			
			par0.addFreshEntity(var1);
			
			return ActionResult.success(var0);
		}
		
		return ActionResult.pass(var0);
	}
}
