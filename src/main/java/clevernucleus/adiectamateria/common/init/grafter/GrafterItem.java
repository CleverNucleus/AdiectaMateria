package clevernucleus.adiectamateria.common.init.grafter;

import java.util.Arrays;
import java.util.Collection;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrafterItem extends TieredItem {
	private static final Collection<Block> EFFECTIVE_ON = Arrays.asList(Blocks.GRASS, Blocks.TALL_GRASS);
	private static final IItemProvider[] DROPS = new IItemProvider[] {Registry.RICE, Registry.PLANT_FIBRE};
	private final Multimap<Attribute, AttributeModifier> attributes;
	
	public GrafterItem(Properties par0) {
		super(ItemTier.GOLD, par0);
		
		Builder<Attribute, AttributeModifier> var0 = ImmutableMultimap.builder();
		
		var0.put(Attributes.field_233823_f_, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 0.0D, AttributeModifier.Operation.ADDITION));
		var0.put(Attributes.field_233825_h_, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3.0D, AttributeModifier.Operation.ADDITION));
	    
		this.attributes = var0.build();
	}
	
	private void cutBlock(World par0, BlockPos par1) {
		par0.setBlockState(par1, Blocks.AIR.getDefaultState(), 11);
		
		if(random.nextInt(100) < 30) {
			ItemEntity var0 = new ItemEntity(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(DROPS[random.nextInt(DROPS.length)].asItem(), 1));
			
			par0.addEntity(var0);
		}
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext par0) {
		World var0 = par0.getWorld();
		BlockPos var1 = par0.getPos();
		Block var2 = var0.getBlockState(var1).getBlock();
		
		if(EFFECTIVE_ON.contains(var2)) {
			if(!var0.isRemote) {
				PlayerEntity var3 = par0.getPlayer();
				
				if(var3 == null) return ActionResultType.PASS;
				
				this.cutBlock(var0, var1);
				
				par0.getItem().damageItem(1, var3, var -> {
					var.sendBreakAnimation(par0.getHand());
				});
				
				var0.playSound((PlayerEntity)null, var1, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.PASS;
	}
	
	@Override
	public boolean hitEntity(ItemStack par0, LivingEntity par1, LivingEntity par2) {
		par0.damageItem(1, par2, var -> {
			var.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		
		return true;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType par0, ItemStack par1) {
		return par0 == EquipmentSlotType.MAINHAND ? this.attributes : super.getAttributeModifiers(par0, par1);
	}
}
