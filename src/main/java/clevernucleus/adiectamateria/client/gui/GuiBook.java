package clevernucleus.adiectamateria.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clevernucleus.adiectamateria.client.content.LangKeys;
import clevernucleus.adiectamateria.client.content.Page;
import clevernucleus.adiectamateria.client.content.Topic;
import clevernucleus.adiectamateria.common.item.ItemUnit;
import clevernucleus.adiectamateria.common.util.CycleTimer;
import clevernucleus.adiectamateria.common.util.ObjectHolder;
import clevernucleus.adiectamateria.common.util.interfaces.IConstants;
import clevernucleus.adiectamateria.common.util.recipes.Smelting;
import clevernucleus.adiectamateria.common.util.recipes.Transmuting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.config.HoverChecker;

public class GuiBook extends GuiScreen {
	public final ResourceLocation texture = new ResourceLocation(IConstants.MODID, "textures/gui/book.png");
	
	private List<GuiButtonImage> buttonArray = new ArrayList<GuiButtonImage>();
	private List<Topic> topics = new ArrayList<Topic>();
	private GuiButtonImage buttonPrev, buttonNext;
	
	private CycleTimer timer = new CycleTimer(Transmuting.getExceptions());
	
	private Topic currentTopic;
	
	private Topic introduction;
	private Topic melty_flint;
	private Topic smelting;
	private Topic crafting;
	private Topic world_crafting;
	private Topic relics;
	private Topic plants;
	
	private byte currentPageId = 0;
	
	public GuiBook() {
		introduction = new Topic("introduction", 0, new ItemStack(ItemUnit.BOOK)).add(topics);
		melty_flint = new Topic("melty_flint", 1, new ItemStack(ItemUnit.MELTY_FLINT)).add(topics);
		smelting = new Topic("smelting", 2, new ItemStack(Blocks.FURNACE)).add(topics);
		crafting = new Topic("crafting", 3, new ItemStack(Blocks.CRAFTING_TABLE)).add(topics);
		world_crafting = new Topic("world_crafting", 4, new ItemStack(Blocks.GRASS)).add(topics);
		relics = new Topic("relics", 5, new ItemStack(Items.TOTEM_OF_UNDYING)).add(topics);
		plants = new Topic("plants", 6, new ItemStack(Items.BEETROOT_SEEDS)).add(topics);
		
		currentTopic = introduction;
		
		init();
	}
	
	@Override
	public void drawScreen(int par0, int par1, float par2) {
		timer.incrementTime();
		
		drawDefaultBackground();
		
		mc.renderEngine.bindTexture(texture);
		
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		
		this.drawTexturedModalRect((width / 2) - 128, (height / 2) - 100, 0, 0, 256, 200);
		this.drawTexturedModalRect((width / 2) + 101, (height / 2) - 81 + (currentTopic.getId() * 13), 0, 200, 23, 13);
		
		for(GuiButton var : buttonArray) {
			if(var.id == currentTopic.getId()) {
				var.enabled = false;
			} else {
				var.enabled = true;
				var.drawButton(mc, par0, par1, par2);
			}
		}
		
		if(currentTopic.getPages().size() > 1) {
			if(currentTopic.getPages().get(currentPageId) != currentTopic.getPages().get((byte) (currentTopic.getPages().size() - 1))) {
				buttonNext.drawButton(mc, par0, par1, par2);
				buttonNext.enabled = true;
			} else {
				buttonNext.enabled = false;
			}
			
			if(currentTopic.getPages().get(currentPageId) != currentTopic.getPages().get((byte) 0)) {
				buttonPrev.drawButton(mc, par0, par1, par2);
				buttonPrev.enabled = true;
			} else {
				buttonPrev.enabled = false;
			}
		}
		
		RenderHelper.enableGUIStandardItemLighting();
		
		GlStateManager.pushMatrix();
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		
		for(Topic var : topics) {
			mc.getRenderItem().renderItemAndEffectIntoGUI(var.getDisplayStack(), 2 * ((width / 2) + 121 - (var == currentTopic ? 13 : 0)), 2 * ((height / 2) - 80 + (var.getId() * 13)));
		}
		
		GlStateManager.popMatrix();
		
		try {
			currentTopic.getPages().get(currentPageId).drawPage(par0, par1, par2);
		} catch(NullPointerException parE) {}
		
		drawToolTips(par0, par1);
	}
	
	private void drawToolTips(int par0, int par1) {
		for(GuiButton var : buttonArray) {
			HoverChecker var0 = new HoverChecker(var, 0);
			List<String> var1 = new ArrayList<String>();
			
			if(var0.checkHover(par0, par1)) {
				String var2 = topics.get(var.id).getDisplayName();
				
				var1.add(TextFormatting.GRAY + var2);
				
				if(var.enabled) {
					drawHoveringText(var1, par0, par1);
				}
			}
		}
	}
	
	@Override
	public void initGui() {
		buttonList.clear();
		buttonArray.clear();
		
		for(Topic var : topics) {
			buttonArray.add(new GuiButtonImage(var.getId(), (width / 2) + 120, (height / 2) - 81 + (var.getId() * 13), 14, 10, 0, 213, 10, texture));
		}
		
		buttonList.add(buttonPrev = new GuiButtonImage(buttonArray.size(), (width / 2) - 107, (height / 2) + 76, 18, 10, 18, 233, 10, texture));
		buttonList.add(buttonNext = new GuiButtonImage(buttonArray.size() + 1, (width / 2) + 88, (height / 2) + 76, 18, 10, 0, 233, 10, texture));
		
		for(GuiButton var : buttonArray) {
			buttonList.add(var);
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton par0) throws IOException {
		if(buttonArray.contains(par0)) {
			if(par0.id != currentTopic.getId()) {
				currentTopic = topics.get(par0.id);
			}
		}
		
		if(par0 == buttonPrev) {
			currentPageId--;
		} else if(par0 == buttonNext) {
			currentPageId++;
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	private Page intro0;
	private Page melty0;
	private Page smelt0;
	private Page craft0;
	private Page world0, world1, world2;
	private Page relic0;
	private Page plant0;
	
	public void init() {
		intro0 = new Page(introduction, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) + 17, (height / 2) + 15, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 77, (height / 2) + 15, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 47, (height / 2) + 15, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 40, (height / 2) + 21, 53, 243, 5, 9);
				drawTexturedModalRect((width / 2) + 70, (height / 2) + 21, 53, 243, 5, 9);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemUnit.MELTY_FLINT), (width / 2) + 19, (height / 2) + 17);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(Blocks.BOOKSHELF), (width / 2) + 49, (height / 2) + 17);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemUnit.BOOK), (width / 2) + 79, (height / 2) + 17);
				
				mc.fontRenderer.drawString(introduction.getDisplayName(), (width / 2) - 90, (height / 2) - 78, 0x1D1D1D);
				
				GlStateManager.pushMatrix();
				GlStateManager.scale(0.8F, 0.8F, 0.8F);
				
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 0), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) - 55)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 1), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) + 15)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 2), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) - 55)), 135, 0x1D1D1D);
				
				GlStateManager.popMatrix();
				
				HoverChecker var0 = new HoverChecker((height / 2) + 17, (height / 2) + 33, (width / 2) + 19, (width / 2) + 35, 0);
				HoverChecker var1 = new HoverChecker((height / 2) + 17, (height / 2) + 33, (width / 2) + 79, (width / 2) + 95, 0);
				HoverChecker var2 = new HoverChecker((height / 2) + 17, (height / 2) + 33, (width / 2) + 47, (width / 2) + 67, 0);
				List<String> var3 = new ArrayList<String>();
				
				if(var0.checkHover(par0, par1)) {
					var3.add(ItemUnit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemUnit.MELTY_FLINT)));
					
					drawHoveringText(var3, par0, par1);
				} else if(var1.checkHover(par0, par1)) {
					var3.add(ItemUnit.BOOK.getItemStackDisplayName(new ItemStack(ItemUnit.BOOK)));
					
					drawHoveringText(var3, par0, par1);
				} else if(var2.checkHover(par0, par1)) {
					var3.add(mc.gameSettings.keyBindUseItem.getDisplayName() + " " + Blocks.BOOKSHELF.getLocalizedName());
					
					drawHoveringText(var3, par0, par1);
				}
			}
		};
		
		melty0 = new Page(melty_flint, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) + 17, (height / 2) + 45, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 77, (height / 2) + 45, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 47, (height / 2) + 45, 37, 220, 21, 20);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(Items.FLINT), (width / 2) + 19, (height / 2) + 47);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemUnit.MELTY_FLINT), (width / 2) + 79, (height / 2) + 47);
				
				mc.fontRenderer.drawString(melty_flint.getDisplayName(), (width / 2) - 85, (height / 2) - 78, 0x1D1D1D);
				
				GlStateManager.pushMatrix();
				GlStateManager.scale(0.8F, 0.8F, 0.8F);
				
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 0), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) - 55)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 1), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) - 55)), 130, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 2), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) + 24)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 3), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) + 40)), 135, 0x1D1D1D);
				
				GlStateManager.popMatrix();
				
				HoverChecker var0 = new HoverChecker((height / 2) + 47, (height / 2) + 63, (width / 2) + 19, (width / 2) + 35, 0);
				HoverChecker var1 = new HoverChecker((height / 2) + 47, (height / 2) + 63, (width / 2) + 79, (width / 2) + 95, 0);
				HoverChecker var2 = new HoverChecker((height / 2) + 45, (height / 2) + 65, (width / 2) + 47, (width / 2) + 67, 0);
				List<String> var3 = new ArrayList<String>();
				
				if(var0.checkHover(par0, par1)) {
					var3.add(Items.FLINT.getItemStackDisplayName(new ItemStack(Items.FLINT)));
					
					drawHoveringText(var3, par0, par1);
				} else if(var1.checkHover(par0, par1)) {
					var3.add(ItemUnit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemUnit.MELTY_FLINT)));
					
					drawHoveringText(var3, par0, par1);
				} else if(var2.checkHover(par0, par1)) {
					var3.add(I18n.format(LangKeys.ACTION + LangKeys.SMELT));
					
					drawHoveringText(var3, par0, par1);
				}
			}
		};
		
		smelt0 = new Page(smelting, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				for(int var = 0; var < Smelting.getSmeltingList().size(); ++var) {
					if(var < 10) {
						drawSmeltingRecipe(var, 0, 10, Smelting.getSmeltingList().get(var));
					}
				}
				
				for(int var = 0; var < Smelting.getSmeltingList().size(); ++var) {
					if(var < 10) {
						writeSmeltingRecipe(var, 0, 10, Smelting.getSmeltingList().get(var), par0, par1, par2);
					}
				}
				
				mc.fontRenderer.drawString(smelting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
			}
		};
		
		craft0 = new Page(crafting, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
			}
		};
		
		world0 = new Page(world_crafting, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				createTransmutingPage(0, 10, par0, par1, par2);
				
				mc.fontRenderer.drawString(world_crafting.getDisplayName(), (width / 2) - 94, (height / 2) - 78, 0x1D1D1D);
			}
		};
		
		world1 = new Page(world_crafting, 1) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				createTransmutingPage(10, 20, par0, par1, par2);
				
				mc.fontRenderer.drawString(world_crafting.getDisplayName(), (width / 2) - 94, (height / 2) - 78, 0x1D1D1D);
			}
		};
		
		world2 = new Page(world_crafting, 2) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				createTransmutingPage(20, 30, par0, par1, par2);
				
				mc.fontRenderer.drawString(world_crafting.getDisplayName(), (width / 2) - 94, (height / 2) - 78, 0x1D1D1D);
			}
		};
		
		relic0 = new Page(relics, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.fontRenderer.drawString(relics.getDisplayName(), (width / 2) - 83, (height / 2) - 78, 0x1D1D1D);
			}
		};
		
		plant0 = new Page(plants, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.fontRenderer.drawString(plants.getDisplayName(), (width / 2) - 80, (height / 2) - 78, 0x1D1D1D);
			}
		};
	}
	
	private void createTransmutingPage(int min, int max, int par0, int par1, float par2) {
		Map<Block, ObjectHolder> map = new HashMap<>();
		List<ObjectHolder> list = new ArrayList<>();
		
		for(int var = 0; var < Transmuting.getTransmutingList().size(); ++var) {
			Block var2 = fromTransList(var);
			
			if(var2 == Blocks.LOG || var2 == Blocks.LOG2) {
				
			} else {
				map.put(var2, Transmuting.getTransmutingList().get(var));
			}
		}
		
		for(Block var : map.keySet()) {
			list.add(map.get(var));
		}
		
		list.add(new ObjectHolder(Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND), Blocks.SOUL_SAND.getDefaultState()));
		list.add(new ObjectHolder(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK)));
		
		int var0 = 0, var1 = 0;
		
		for(int var = 0; var < list.size(); var++) {
			Block var2 = ((IBlockState)list.get(var).getObject(0)).getBlock();
			
			int var3 = (var0 < 5) ? var0 : (var0 - 5);
			int var4 = (var0 < 5) ? 0 : 120;
			
			ObjectHolder var5 = list.get(var);
			
			if(var >= min && var < max) {
				if(Transmuting.getExceptions().contains(var2)) {
					drawComplexTransmutingRecipe(var3, var4, var2);
				} else {
					drawTransmutingRecipe(var3, var4, var5);
				}
				
				var0++;
			}
		}
		
		for(int var = 0; var < list.size(); var++) {
			Block var2 = ((IBlockState)list.get(var).getObject(0)).getBlock();
			
			int var3 = (var1 < 5) ? var1 : (var1 - 5);
			int var4 = (var1 < 5) ? 0 : 120;
			
			ObjectHolder var5 = list.get(var);
			
			if(var >= min && var < max) {
				if(Transmuting.getExceptions().contains(var2)) {
					writeComplexTransmutingRecipe(var3, var4, var2, par0, par1, par2);
				} else {
					writeTransmutingRecipe(var3, var4, var5, par0, par1, par2);
				}
				
				var1++;
			}
		}
	}
	
	private Block fromTransList(int par0) {
		return ((IBlockState)Transmuting.getTransmutingList().get(par0).getObject(0)).getBlock();
	}
	
	/**
	 * 
	 * @param par0 iterator
	 * @param par1 min 
	 * @param par2 max
	 * @param par3 obj
	 */
	private void drawSmeltingRecipe(int par0, int par1, int par2, ObjectHolder par3) {
		int var0 = par0 < ((par1 + par2) / 2) ? 0 : 120;
		int var1 = (par0 % 10);
		
		mc.renderEngine.bindTexture(texture);
		
		drawTexturedModalRect((width / 2) - 100 + var0, (height / 2) - 55 + (var1 * 24) - var0, 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 40 + var0, (height / 2) - 55 + (var1 * 24) - var0, 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 70 + var0, (height / 2) - 55 + (var1 * 24) - var0, 37, 220, 21, 20);
		
		mc.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)par3.getObject(0), (width / 2) - 98 + var0, (height / 2) - 53 + (var1 * 24) - var0);
		mc.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)par3.getObject(1), (width / 2) - 38 + var0, (height / 2) - 53 + (var1 * 24) - var0);
	}
	
	private void writeSmeltingRecipe(int par0, int par1, int par2, ObjectHolder par3, int par4, int par5, float par6) {
		int var0 = par0 < ((par1 + par2) / 2) ? 0 : 120;
		int var1 = (par0 % 10);
		
		HoverChecker var2 = new HoverChecker((height / 2) - 53 + (var1 * 24) - var0, (height / 2) - 53 + 16 + (var1 * 24) - var0, (width / 2) - 98 + var0, (width / 2) - 98 + 16 + var0, 0);
		HoverChecker var3 = new HoverChecker((height / 2) - 53 + (var1 * 24) - var0, (height / 2) - 53 + 16 + (var1 * 24) - var0, (width / 2) - 38 + var0, (width / 2) - 38 + 16 + var0, 0);
		HoverChecker var4 = new HoverChecker((height / 2) - 53 + (var1 * 24) - var0, (height / 2) - 53 + 16 + (var1 * 24) - var0, (width / 2) - 68 + var0, (width / 2) - 68 + 16 + var0, 0);
		List<String> var5 = new ArrayList<String>();
		
		if(var2.checkHover(par4, par5)) {
			var5.add(ItemUnit.MELTY_FLINT.getItemStackDisplayName((ItemStack)par3.getObject(0)));
			
			drawHoveringText(var5, par4, par5);
		} else if(var3.checkHover(par4, par5)) {
			var5.add(ItemUnit.MELTY_FLINT.getItemStackDisplayName((ItemStack)par3.getObject(1)));
			
			drawHoveringText(var5, par4, par5);
		} else if(var4.checkHover(par4, par5)) {
			var5.add(I18n.format(LangKeys.ACTION + LangKeys.SMELT));
			
			drawHoveringText(var5, par4, par5);
		}
	}
	
	/**
	 * 
	 * @param par0 iterator
	 * @param par1 min 
	 * @param par2 max
	 * @param par3 obj
	 */
	private void drawTransmutingRecipe(int var3, int var4, ObjectHolder var5) {
		mc.renderEngine.bindTexture(texture);
		
		drawTexturedModalRect((width / 2) - 100 + var4, (height / 2) - 55 + (var3 * 24), 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 40 + var4, (height / 2) - 55 + (var3 * 24), 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 70 + var4, (height / 2) - 55 + (var3 * 24), 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 77 + var4, (height / 2) - 49 + (var3 * 24), 53, 243, 5, 9);
		drawTexturedModalRect((width / 2) - 47 + var4, (height / 2) - 49 + (var3 * 24), 53, 243, 5, 9);
		
		mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemUnit.MELTY_FLINT), (width / 2) - 98 + var4, (height / 2) - 53 + (var3 * 24));
		
		if(var5.getObject(1) instanceof IBlockState) {
			mc.getRenderItem().renderItemAndEffectIntoGUI(getOutputDisplayBlock(((IBlockState)var5.getObject(0)).getBlock(), ((IBlockState)var5.getObject(1)).getBlock()), (width / 2) - 38 + var4, (height / 2) - 53 + (var3 * 24));
			mc.getRenderItem().renderItemAndEffectIntoGUI(getInputDisplayBlock(((IBlockState)var5.getObject(0)).getBlock(), ((IBlockState)var5.getObject(1)).getBlock()), (width / 2) - 68 + var4, (height / 2) - 53 + (var3 * 24));
		} else if(var5.getObject(1) instanceof Item) {
			mc.getRenderItem().renderItemAndEffectIntoGUI(getDisplayItem(((IBlockState)var5.getObject(0)).getBlock(), (Item)var5.getObject(1)), (width / 2) - 38 + var4, (height / 2) - 53 + (var3 * 24));
			mc.getRenderItem().renderItemAndEffectIntoGUI(getInputDisplayBlock(((IBlockState)var5.getObject(0)).getBlock(), (Item)var5.getObject(1)), (width / 2) - 68 + var4, (height / 2) - 53 + (var3 * 24));
		}
	}
	
	/**
	 * 
	 * @param par1 posx 
	 * @param par2 posy
	 * @param par3 obj
	 */
	private void drawComplexTransmutingRecipe(int var3, int var4, Block var2) {
		mc.renderEngine.bindTexture(texture);
		
		drawTexturedModalRect((width / 2) - 100 + var4, (height / 2) - 55 + (var3 * 24), 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 40 + var4, (height / 2) - 55 + (var3 * 24), 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 70 + var4, (height / 2) - 55 + (var3 * 24), 38, 200, 20, 20);
		drawTexturedModalRect((width / 2) - 77 + var4, (height / 2) - 49 + (var3 * 24), 53, 243, 5, 9);
		drawTexturedModalRect((width / 2) - 47 + var4, (height / 2) - 49 + (var3 * 24), 53, 243, 5, 9);
		
		mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemUnit.MELTY_FLINT), (width / 2) - 98 + var4, (height / 2) - 53 + (var3 * 24));
		
		mc.getRenderItem().renderItemAndEffectIntoGUI(timer.getStack(var2, 0), (width / 2) - 68 + var4, (height / 2) - 53 + (var3 * 24));
		mc.getRenderItem().renderItemAndEffectIntoGUI(timer.getStack(var2, 1), (width / 2) - 38 + var4, (height / 2) - 53 + (var3 * 24));
	}
	
	private void writeComplexTransmutingRecipe(int var3, int var4, Block var2, int par0, int par1, float par6) {
		HoverChecker var2X = new HoverChecker((height / 2) - 53 + (var3 * 24), (height / 2) - 53 + 16 + (var3 * 24), (width / 2) - 98 + var4, (width / 2) - 98 + 16 + var4, 0);
		HoverChecker var3X = new HoverChecker((height / 2) - 53 + (var3 * 24), (height / 2) - 53 + 16 + (var3 * 24), (width / 2) - 38 + var4, (width / 2) - 38 + 16 + var4, 0);
		HoverChecker var4X = new HoverChecker((height / 2) - 53 + (var3 * 24), (height / 2) - 53 + 16 + (var3 * 24), (width / 2) - 68 + var4, (width / 2) - 68 + 16 + var4, 0);
		List<String> var5X = new ArrayList<String>();
		
		if(var2X.checkHover(par0, par1)) {
			var5X.add(ItemUnit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemUnit.MELTY_FLINT)));
			
			drawHoveringText(var5X, par0, par1);
		} else if(var3X.checkHover(par0, par1)) {
			var5X.add(timer.getStack(var2, 1).getDisplayName());
			
			drawHoveringText(var5X, par0, par1);
		} else if(var4X.checkHover(par0, par1)) {
			var5X.add(TextFormatting.GOLD + "" + TextFormatting.ITALIC + mc.gameSettings.keyBindUseItem.getDisplayName() + TextFormatting.RESET + " " + timer.getStack(var2, 0).getDisplayName());
			
			drawHoveringText(var5X, par0, par1);
		}
	}
	
	private void writeTransmutingRecipe(int var3, int var4, ObjectHolder var5, int par0, int par1, float par6) {
		HoverChecker var2X = new HoverChecker((height / 2) - 53 + (var3 * 24), (height / 2) - 53 + 16 + (var3 * 24), (width / 2) - 98 + var4, (width / 2) - 98 + 16 + var4, 0);
		HoverChecker var3X = new HoverChecker((height / 2) - 53 + (var3 * 24), (height / 2) - 53 + 16 + (var3 * 24), (width / 2) - 38 + var4, (width / 2) - 38 + 16 + var4, 0);
		HoverChecker var4X = new HoverChecker((height / 2) - 53 + (var3 * 24), (height / 2) - 53 + 16 + (var3 * 24), (width / 2) - 68 + var4, (width / 2) - 68 + 16 + var4, 0);
		List<String> var5X = new ArrayList<String>();
		
		if(var2X.checkHover(par0, par1)) {
			var5X.add(ItemUnit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemUnit.MELTY_FLINT)));
			
			drawHoveringText(var5X, par0, par1);
		} else if(var3X.checkHover(par0, par1)) {
			if(var5.getObject(1) instanceof IBlockState) {
				var5X.add(getOutputDisplayBlock(((IBlockState)var5.getObject(0)).getBlock(), ((IBlockState)var5.getObject(1)).getBlock()).getDisplayName());
			} else if(var5.getObject(1) instanceof Item) {
				var5X.add(getDisplayItem(((IBlockState)var5.getObject(0)).getBlock(), (Item)var5.getObject(1)).getDisplayName());
			}
			
			drawHoveringText(var5X, par0, par1);
		} else if(var4X.checkHover(par0, par1)) {
			if(var5.getObject(1) instanceof IBlockState) {
				var5X.add(TextFormatting.GOLD + "" + TextFormatting.ITALIC + mc.gameSettings.keyBindUseItem.getDisplayName() + TextFormatting.RESET + " " + getInputDisplayBlock(((IBlockState)var5.getObject(0)).getBlock(), ((IBlockState)var5.getObject(1)).getBlock()).getDisplayName());
			} else if(var5.getObject(1) instanceof Item) {
				var5X.add(TextFormatting.GOLD + "" + TextFormatting.ITALIC + mc.gameSettings.keyBindUseItem.getDisplayName() + TextFormatting.RESET + " " + getInputDisplayBlock(((IBlockState)var5.getObject(0)).getBlock(), (Item)var5.getObject(1)).getDisplayName());
			}
			
			drawHoveringText(var5X, par0, par1);
		}
	}
	
	/**
	 * 
	 * @param par0 input
	 * @param par1 output
	 * @return
	 */
	private ItemStack getDisplayItem(Block par0, Item par1) {
		ItemStack var0 = new ItemStack(par1);
		
		/** Manual Exceptions */
		
		return var0;
	}
	
	/**
	 * 
	 * @param par0 input
	 * @param par1 output
	 * @return
	 */
	private ItemStack getInputDisplayBlock(Block par0, Block par1) {
		ItemStack var0 = new ItemStack(par0);
		
		/** Manual Exceptions */
		if(par0 == Blocks.SAND && par1 == Blocks.SOUL_SAND) {
			var0 = new ItemStack(Blocks.SAND, 1, 1);
		}
		
		return var0;
	}
	
	/**
	 * 
	 * @param par0 input
	 * @param par1 output
	 * @return
	 */
	private ItemStack getInputDisplayBlock(Block par0, Item par1) {
		ItemStack var0 = new ItemStack(par0);
		
		return var0;
	}
	
	/**
	 * 
	 * @param par0 input
	 * @param par1 output
	 * @return
	 */
	private ItemStack getOutputDisplayBlock(Block par0, Block par1) {
		ItemStack var0 = new ItemStack(par1);
		
		/** Manual Exceptions */
		if(par0 == Blocks.NETHERRACK && par1 == Blocks.SAND) {
			var0 = new ItemStack(Blocks.SAND, 1, 1);
		} else if(par0 == Blocks.ICE && par1 == Blocks.FLOWING_WATER) {
			var0 = new ItemStack(Items.WATER_BUCKET);
		} else if(par0 == Blocks.OBSIDIAN && par1 == Blocks.FLOWING_LAVA) {
			var0 = new ItemStack(Items.LAVA_BUCKET);
		}
		
		return var0;
	}
}
