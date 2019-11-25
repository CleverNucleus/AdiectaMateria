package clevernucleus.adiectamateria.common.item;

import com.google.common.collect.Multimap;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRiceGrafter extends Item implements IHasModel {
	private final float speed = Item.ToolMaterial.WOOD.getAttackDamage() + 1.0F;
	
	public ItemRiceGrafter(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setMaxStackSize(1);
		this.setMaxDamage(256);
		this.setCreativeTab(CreativeTabs.TOOLS);
		
		ItemUnit.ITEMS.add(this);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		ItemStack var0 = par0.getHeldItem(par3);
		EntityItem var1 = new EntityItem(par1, par2.getX(), par2.getY(), par2.getZ(), new ItemStack(ItemUnit.RICE));
		
		if(par1.getBlockState(par2).getBlock() == Blocks.TALLGRASS) {
			if(!par1.isRemote) {
				par1.setBlockToAir(par2);
				
				if(itemRand.nextInt(100) < 20) {
					par1.spawnEntity(var1);
				}
			}
			
			if(!par0.capabilities.isCreativeMode) {
	            var0.damageItem(1, par0);
	        }
			
			par1.playSound(par0, par2, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			
			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
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
