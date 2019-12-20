package clevernucleus.adiectamateria.common.item;

import com.google.common.collect.Multimap;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockDoublePlant.EnumPlantType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGrafter extends Item implements IHasModel {
	private final float speed = Item.ToolMaterial.WOOD.getAttackDamage() + 1.0F;
	
	public ItemGrafter(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setMaxStackSize(1);
		this.setMaxDamage(64);
		this.setCreativeTab(CreativeTabs.TOOLS);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		ItemStack var0 = par0.getHeldItem(par3);
		ItemStack var1 = ItemStack.EMPTY;
		EnumActionResult var2 = EnumActionResult.FAIL;
		
		if(par1.getBlockState(par2).getBlock() == Blocks.TALLGRASS || (par1.getBlockState(par2).getBlock() instanceof BlockDoublePlant && par1.getBlockState(par2) == Blocks.DOUBLE_PLANT.getActualState(par1.getBlockState(par2), par1, par2).withProperty(BlockDoublePlant.VARIANT, EnumPlantType.GRASS))) {
			var1 = new ItemStack(ItemInit.RICE);
			var2 = EnumActionResult.SUCCESS;
		} else if(par1.getBlockState(par2).getBlock() == Blocks.VINE) {
			var1 = new ItemStack(ItemInit.FLAX);
			var2 = EnumActionResult.SUCCESS;
		}
		
		EntityItem var4 = new EntityItem(par1, par2.getX(), par2.getY(), par2.getZ(), var1);
		
		if(var2 == EnumActionResult.SUCCESS) {
			if(!par1.isRemote) {
				par1.setBlockToAir(par2);
				
				if(itemRand.nextInt(100) < 20) {
					par1.spawnEntity(var4);
				}
				
				if(!par0.capabilities.isCreativeMode) {
		            var0.damageItem(1, par0);
		        }
			}
			
			par1.playSound(par0, par2, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}
		
		return var2;
	}
	
	@Override
    public boolean itemInteractionForEntity(ItemStack par0, net.minecraft.entity.player.EntityPlayer par1, EntityLivingBase par2, net.minecraft.util.EnumHand par3) {
        if(par1.world.isRemote) {
            return false;
        }
        
        if(par2 instanceof EntityChicken && par2.getHealth() > (par2.getMaxHealth() / 2)) {
        	par2.attackEntityFrom(DamageSource.GENERIC, 4.0F);
        	par2.entityDropItem(new ItemStack(Items.FEATHER, itemRand.nextInt(5) + itemRand.nextInt(4) + itemRand.nextInt(3) + 1), 1);
        	par0.damageItem(1, par1);
        	
        	return true;
        }
        
        return false;
    }
	
	@Override
	public boolean isFull3D() {
		return true;
	}
	
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        
        if(equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 0.0D, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)(this.speed - 4.0F), 0));
        }
        
        return multimap;
    }
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
