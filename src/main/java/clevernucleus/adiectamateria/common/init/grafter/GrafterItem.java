package clevernucleus.adiectamateria.common.init.grafter;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import clevernucleus.adiectamateria.common.util.Dual;
import clevernucleus.adiectamateria.common.util.RandDistribution;
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
import net.minecraft.item.Items;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrafterItem extends TieredItem {
	
	public static final Multimap<Block, Dual<IItemProvider, Float>> USE_ON = ArrayListMultimap.create();
	private final Multimap<Attribute, AttributeModifier> attributes;
	
	public GrafterItem(Properties par0) {
		super(ItemTier.GOLD, par0);
		
		Builder<Attribute, AttributeModifier> var0 = ImmutableMultimap.builder();
		
		var0.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 0.0D, AttributeModifier.Operation.ADDITION));
		var0.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -3.0D, AttributeModifier.Operation.ADDITION));
		
		this.attributes = var0.build();
	}
	
	private float fromUseOnMultimap(Collection<Dual<IItemProvider, Float>> par0, IItemProvider par1) {
		for(Dual<IItemProvider, Float> var : par0) {
			IItemProvider var0 = var.a();
			float var1 = var.b().floatValue();
			
			if(var0 == par1) return var1;
		}
		
		
		return 0F;
	}
	
	private void cutBlock(World par0, BlockPos par1, Block par2) {
		par0.setBlock(par1, Blocks.AIR.defaultBlockState(), 11);
		
		Collection<Dual<IItemProvider, Float>> var0 = USE_ON.get(par2);
		RandDistribution<IItemProvider> var1 = new RandDistribution<IItemProvider>(Items.AIR);
		
		for(Dual<IItemProvider, Float> var : var0) {
			var1.add(var.a(), var.b().floatValue());
		}
		
		IItemProvider var2 = var1.getDistributedRandom();
		int var3 = Math.round(100F * fromUseOnMultimap(var0, var2));
		
		if(random.nextInt(100) < var3) {
			ItemEntity var4 = new ItemEntity(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(var2, 1));
			
			par0.addFreshEntity(var4);
		}
	}
	
	@Override
	public ActionResultType useOn(ItemUseContext par0) {
		World var0 = par0.getLevel();
		BlockPos var1 = par0.getClickedPos();
		Block var2 = var0.getBlockState(var1).getBlock();
		
		if(USE_ON.containsKey(var2)) {
			if(!var0.isClientSide) {
				PlayerEntity var3 = par0.getPlayer();
				
				if(var3 == null) return ActionResultType.PASS;
				
				this.cutBlock(var0, var1, var2);
				
				par0.getItemInHand().hurtAndBreak(1, var3, var -> {
					var.broadcastBreakEvent(par0.getHand());
				});
				
				var0.playSound((PlayerEntity)null, var1, SoundEvents.GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return ActionResultType.sidedSuccess(var0.isClientSide);
		}
		
		return ActionResultType.PASS;
	}
	
	@Override
	public boolean hurtEnemy(ItemStack par0, LivingEntity par1, LivingEntity par2) {
		par0.hurtAndBreak(1, par2, var -> {
			var.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		});
		
		return true;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType par0, ItemStack par1) {
		return par0 == EquipmentSlotType.MAINHAND ? this.attributes : super.getAttributeModifiers(par0, par1);
	}
}
