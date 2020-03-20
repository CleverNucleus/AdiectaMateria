package clevernucleus.adiectamateria.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.client.content.LangKeys;
import clevernucleus.adiectamateria.client.content.Page;
import clevernucleus.adiectamateria.client.content.Topic;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.recipe.Component;
import clevernucleus.adiectamateria.common.recipe.Crafting;
import clevernucleus.adiectamateria.common.recipe.CycleTimer;
import clevernucleus.adiectamateria.common.recipe.Recipe;
import clevernucleus.adiectamateria.common.recipe.Smelting;
import clevernucleus.adiectamateria.common.recipe.Transmuting;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.config.HoverChecker;
import net.minecraftforge.fml.common.Loader;

public class GuiBook extends GuiScreen {
	public final ResourceLocation texture = new ResourceLocation(Util.MODID, "textures/gui/book.png");
	
	private CycleTimer timer = new CycleTimer();
	
	private List<GuiButtonImage> buttonArray = new ArrayList<GuiButtonImage>();
	private List<Topic> topics = new ArrayList<Topic>();
	private GuiButtonImage buttonPrev, buttonNext;
	
	private Topic currentTopic;
	
	private Topic introduction;
	private Topic melty_flint;
	private Topic smelting;
	private Topic crafting;
	private Topic world_crafting;
	private Topic plants;
	
	private byte currentPageId = 0;
	
	public GuiBook() {
		introduction = new Topic("introduction", 0, new ItemStack(ItemInit.BOOK)).add(topics);
		melty_flint = new Topic("melty_flint", 1, new ItemStack(ItemInit.MELTY_FLINT)).add(topics);
		smelting = new Topic("smelting", 2, new ItemStack(Blocks.FURNACE)).add(topics);
		crafting = new Topic("crafting", 3, new ItemStack(Blocks.CRAFTING_TABLE)).add(topics);
		world_crafting = new Topic("world_crafting", 4, new ItemStack(Blocks.GRASS)).add(topics);
		plants = new Topic("plants", 5, new ItemStack(Items.BEETROOT_SEEDS)).add(topics);
		
		currentTopic = introduction;
		
		init();
	}
	
	@Override
	public void drawScreen(int par0, int par1, float par2) {
		timer.tick();
		
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
				currentPageId = 0;
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
	private Page craft0, craft1, craft2, craft3, craft4, craft5, craft6, craft7;
	private Page world0, world1, world2;
	private Page plant0, plant1;
	
	private int craft = (Loader.isModLoaded(Util.MODID_AE2) ? 8 : 7), world = 3;
	
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
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.MELTY_FLINT), (width / 2) + 19, (height / 2) + 17);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(Blocks.BOOKSHELF), (width / 2) + 49, (height / 2) + 17);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.BOOK), (width / 2) + 79, (height / 2) + 17);
				
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
					var3.add(ItemInit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemInit.MELTY_FLINT)));
					
					drawHoveringText(var3, par0, par1);
				} else if(var1.checkHover(par0, par1)) {
					var3.add(ItemInit.BOOK.getItemStackDisplayName(new ItemStack(ItemInit.BOOK)));
					
					drawHoveringText(var3, par0, par1);
				} else if(var2.checkHover(par0, par1)) {
					var3.add(TextFormatting.GOLD + "" + TextFormatting.ITALIC + mc.gameSettings.keyBindUseItem.getDisplayName() + TextFormatting.RESET + " " + Blocks.BOOKSHELF.getLocalizedName());
					
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
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.MELTY_FLINT), (width / 2) + 79, (height / 2) + 47);
				
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
					var3.add(ItemInit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemInit.MELTY_FLINT)));
					
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
				drawSmeltingPage(0, 10);
				
				mc.fontRenderer.drawString(smelting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				
				describeSmeltingPage(par0, par1, 0, 10, par2);
			}
		};
		
		craft0 = new Page(crafting, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(0, 4);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("1 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("1 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 0, 4, par2);
			}
		};
		
		craft1 = new Page(crafting, 1) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(4, 8);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("2 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("2 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 4, 8, par2);
			}
		};
		
		craft2 = new Page(crafting, 2) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(8, 12);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("3 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("3 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 8, 12, par2);
			}
		};
		
		craft3 = new Page(crafting, 3) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(12, 16);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("4 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("4 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 12, 16, par2);
			}
		};
		
		craft4 = new Page(crafting, 4) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(16, 20);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("5 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("5 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 16, 20, par2);
			}
		};
		
		craft5 = new Page(crafting, 5) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(20, 24);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("6 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("6 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 20, 24, par2);
			}
		};
		
		craft6 = new Page(crafting, 6) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawCraftingPage(24, 28);
				
				mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("7 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("7 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeCraftingPage(par0, par1, 24, 28, par2);
			}
		};
		
		if(Loader.isModLoaded(Util.MODID_AE2)) {
			craft7 = new Page(crafting, 7) {
				
				@Override
				public void drawPage(int par0, int par1, float par2) {
					drawCraftingPage(28, 32);
					
					mc.fontRenderer.drawString(crafting.getDisplayName(), (width / 2) - 101, (height / 2) - 78, 0x1D1D1D);
					mc.fontRenderer.drawString("8 / " + craft, (width / 2) - (mc.fontRenderer.getStringWidth("8 / " + craft) / 2), (height / 2) + 78, 0x1D1D1D);
					
					describeCraftingPage(par0, par1, 28, 32, par2);
				}
			};
		}
		
		world0 = new Page(world_crafting, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawTransmutingPage(0, 10);
				
				mc.fontRenderer.drawString(world_crafting.getDisplayName(), (width / 2) - 94, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("1 / " + world, (width / 2) - (mc.fontRenderer.getStringWidth("1 / " + world) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeTransmutingPage(par0, par1, 0, 10, par2);
			}
		};
		
		world1 = new Page(world_crafting, 1) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawTransmutingPage(10, 20);
				
				mc.fontRenderer.drawString(world_crafting.getDisplayName(), (width / 2) - 94, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("2 / " + world, (width / 2) - (mc.fontRenderer.getStringWidth("2 / " + world) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeTransmutingPage(par0, par1, 10, 20, par2);
			}
		};
		
		world2 = new Page(world_crafting, 2) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				drawTransmutingPage(20, 30);
				
				mc.fontRenderer.drawString(world_crafting.getDisplayName(), (width / 2) - 94, (height / 2) - 78, 0x1D1D1D);
				mc.fontRenderer.drawString("3 / " + world, (width / 2) - (mc.fontRenderer.getStringWidth("3 / " + world) / 2), (height / 2) + 78, 0x1D1D1D);
				
				describeTransmutingPage(par0, par1, 20, 30, par2);
			}
		};
		
		plant0 = new Page(plants, 0) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) + 47, (height / 2) - 25, 38, 200, 20, 20);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.GRAFTER), (width / 2) + 49, (height / 2) - 23);
				
				GlStateManager.pushMatrix();
				GlStateManager.scale(0.8F, 0.8F, 0.8F);
				
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 0), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) - 55)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 1), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) - 55)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(mc.gameSettings.keyBindUseItem.getDisplayName() + I18n.format(this.getText() + 2), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) + 10)), 130, 0x1D1D1D);
				
				GlStateManager.popMatrix();
				
				mc.fontRenderer.drawString(plants.getDisplayName(), (width / 2) - 80, (height / 2) - 78, 0x1D1D1D);
				
				HoverChecker var0 = new HoverChecker((height / 2) - 23, (height / 2) - 7, (width / 2) + 49, (width / 2) + 65, 0);
				
				List<String> var1 = new ArrayList<String>();
				
				if(var0.checkHover(par0, par1)) {
					var1.add(new ItemStack(ItemInit.GRAFTER).getDisplayName());
					
					drawHoveringText(var1, par0, par1);
				}
			}
		};
		
		plant1 = new Page(plants, 1) {
			
			@Override
			public void drawPage(int par0, int par1, float par2) {
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) + 20, (height / 2) + 50, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 50, (height / 2) + 50, 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) + 80, (height / 2) + 50, 38, 200, 20, 20);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.RICE), (width / 2) + 22, (height / 2) + 52);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.FLAX), (width / 2) + 52, (height / 2) + 52);
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(Items.BONE), (width / 2) + 82, (height / 2) + 52);
				
				GlStateManager.pushMatrix();
				GlStateManager.scale(0.8F, 0.8F, 0.8F);
				
				mc.fontRenderer.drawSplitString(mc.gameSettings.keyBindUseItem.getDisplayName() + I18n.format(this.getText() + 0), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) - 55)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 1), (int)(1.25F * ((width / 2) - 112)), (int)(1.25F * ((height / 2) + 20)), 135, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 2), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) - 55)), 130, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 3), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) - 10)), 130, 0x1D1D1D);
				mc.fontRenderer.drawSplitString(I18n.format(this.getText() + 4), (int)(1.25F * ((width / 2) + 12)), (int)(1.25F * ((height / 2) + 20)), 130, 0x1D1D1D);
				
				GlStateManager.popMatrix();
				
				mc.fontRenderer.drawString(plants.getDisplayName(), (width / 2) - 80, (height / 2) - 78, 0x1D1D1D);
				
				HoverChecker var0 = new HoverChecker((height / 2) + 52, (height / 2) + 68, (width / 2) + 22, (width / 2) + 38, 0);
				HoverChecker var1 = new HoverChecker((height / 2) + 52, (height / 2) + 68, (width / 2) + 52, (width / 2) + 68, 0);
				HoverChecker var2 = new HoverChecker((height / 2) + 52, (height / 2) + 68, (width / 2) + 82, (width / 2) + 98, 0);
				
				List<String> var3 = new ArrayList<String>();
				
				if(var0.checkHover(par0, par1)) {
					var3.add(new ItemStack(ItemInit.RICE).getDisplayName());
					
					drawHoveringText(var3, par0, par1);
				} else if(var1.checkHover(par0, par1)) {
					var3.add(new ItemStack(ItemInit.FLAX).getDisplayName());
					
					drawHoveringText(var3, par0, par1);
				} else if(var2.checkHover(par0, par1)) {
					var3.add(new ItemStack(Items.BONE).getDisplayName());
					
					drawHoveringText(var3, par0, par1);
				}
			}
		};
	}
	
	private void drawSmeltingPage(int par0, int par1) {
		for(ItemStack[] var : Smelting.getList()) {
			int index = Smelting.getList().indexOf(var);
			
			if(index >= par0 && index < par1) {
				int perc = index % 10;
				int var2 = (perc < 5) ? perc : (perc - 5);
				int var3 = (perc < 5) ? 0 : 120;
				
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) - 100 + var3, (height / 2) - 55 + (var2 * 24), 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) - 40 + var3, (height / 2) - 55 + (var2 * 24), 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) - 70 + var3, (height / 2) - 55 + (var2 * 24), 37, 220, 21, 20);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(var[0], (width / 2) - 98 + var3, (height / 2) - 53 + (var2 * 24));
				mc.getRenderItem().renderItemAndEffectIntoGUI(var[1], (width / 2) - 38 + var3, (height / 2) - 53 + (var2 * 24));
				
				mc.getRenderItem().renderItemOverlayIntoGUI(fontRenderer, var[1], (width / 2) - 38 + var3, (height / 2) - 53 + (var2 * 24), "" + (var[1].getCount() > 1 ? var[1].getCount() : ""));
			}
		}
	}
	
	private void drawTransmutingPage(int par0, int par1) {
		for(List<Component[]> var : Transmuting.LIST) {
			int index = Transmuting.LIST.indexOf(var);
			
			if(index >= par0 && index < par1) {
				Component[] component = timer.getCycledComponents(var);
				ItemStack var0 = component[0].getDisplayStack();
				ItemStack var1 = component[1].getDisplayStack();
				
				int perc = index % 10;
				int var2 = (perc < 5) ? perc : (perc - 5);
				int var3 = (perc < 5) ? 0 : 120;
				
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) - 100 + var3, (height / 2) - 55 + (var2 * 24), 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) - 40 + var3, (height / 2) - 55 + (var2 * 24), 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) - 70 + var3, (height / 2) - 55 + (var2 * 24), 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) - 77 + var3, (height / 2) - 49 + (var2 * 24), 53, 243, 5, 9);
				drawTexturedModalRect((width / 2) - 47 + var3, (height / 2) - 49 + (var2 * 24), 53, 243, 5, 9);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(ItemInit.MELTY_FLINT), (width / 2) - 98 + var3, (height / 2) - 53 + (var2 * 24));
				mc.getRenderItem().renderItemAndEffectIntoGUI(var1, (width / 2) - 38 + var3, (height / 2) - 53 + (var2 * 24));
				mc.getRenderItem().renderItemAndEffectIntoGUI(var0, (width / 2) - 68 + var3, (height / 2) - 53 + (var2 * 24));
				
				mc.getRenderItem().renderItemOverlayIntoGUI(fontRenderer, var1, (width / 2) - 38 + var3, (height / 2) - 53 + (var2 * 24), "" + (var1.getCount() > 1 ? var1.getCount() : ""));
			}
		}
	}
	
	private void drawCraftingPage(int par0, int par1) {
		for(List<Recipe> var : Crafting.getList()) {
			int index = Crafting.getList().indexOf(var);
			
			if(index >= par0 && index < par1) {
				Recipe recipe = timer.getCycledRecipe(var);
				
				int perc = index % 4;
				int var2 = (perc < 2) ? perc : (perc - 2);
				int var3 = (perc < 2) ? 0 : 120;
				
				mc.renderEngine.bindTexture(texture);
				
				drawTexturedModalRect((width / 2) - 105 + var3, (height / 2) - 55 + (var2 * 64), 58, 200, 52, 52);
				drawTexturedModalRect((width / 2) - 35 + var3, (height / 2) - 39 + (var2 * 64), 38, 200, 20, 20);
				drawTexturedModalRect((width / 2) - 47 + var3, (height / 2) - 36 + (var2 * 64), 50, 240, 8, 15);
				
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[0], (width / 2) - 33 + var3, (height / 2) - 37 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[1], (width / 2) - 104 + var3, (height / 2) - 54 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[2], (width / 2) - 87 + var3, (height / 2) - 54 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[3], (width / 2) - 70 + var3, (height / 2) - 54 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[4], (width / 2) - 104 + var3, (height / 2) - 37 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[5], (width / 2) - 87 + var3, (height / 2) - 37 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[6], (width / 2) - 70 + var3, (height / 2) - 37 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[7], (width / 2) - 104 + var3, (height / 2) - 20 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[8], (width / 2) - 87 + var3, (height / 2) - 20 + (var2 * 64));
				mc.getRenderItem().renderItemAndEffectIntoGUI(recipe.getDisplayRecipe()[9], (width / 2) - 70 + var3, (height / 2) - 20 + (var2 * 64));
				
				mc.getRenderItem().renderItemOverlayIntoGUI(fontRenderer, recipe.getDisplayRecipe()[0], (width / 2) - 33 + var3, (height / 2) - 37 + (var2 * 64), (recipe.getDisplayRecipe()[0].getCount() > 1 ? recipe.getDisplayRecipe()[0].getCount() : "") + "");
			}
		}
	}
	
	/**
	 * 
	 * @param par0 mouseX
	 * @param par1 mouseY
	 * @param par2 min
	 * @param par3 max
	 * @param par4 partial ticks
	 */
	private void describeSmeltingPage(int par0, int par1, int par2, int par3, float par4) {
		for(ItemStack[] var : Smelting.getList()) {
			int index = Smelting.getList().indexOf(var);
			
			if(index >= par2 && index < par3) {
				int perc = index % 10;
				int var2 = (perc < 5) ? perc : (perc - 5);
				int var3 = (perc < 5) ? 0 : 120;
				
				HoverChecker var4 = new HoverChecker((height / 2) - 53 + (var2 * 24), (height / 2) - 53 + 16 + (var2 * 24), (width / 2) - 98 + var3, (width / 2) - 98 + 16 + var3, 0);
				HoverChecker var5 = new HoverChecker((height / 2) - 53 + (var2 * 24), (height / 2) - 53 + 16 + (var2 * 24), (width / 2) - 38 + var3, (width / 2) - 38 + 16 + var3, 0);
				HoverChecker var6 = new HoverChecker((height / 2) - 53 + (var2 * 24), (height / 2) - 53 + 16 + (var2 * 24), (width / 2) - 68 + var3, (width / 2) - 68 + 16 + var3, 0);
				
				List<String> var7 = new ArrayList<String>();
				
				if(var4.checkHover(par0, par1)) {
					var7.add(var[0].getDisplayName());
					
					drawHoveringText(var7, par0, par1);
				} else if(var5.checkHover(par0, par1)) {
					var7.add(var[1].getDisplayName());
					
					drawHoveringText(var7, par0, par1);
				} else if(var6.checkHover(par0, par1)) {
					var7.add(I18n.format(LangKeys.ACTION + LangKeys.SMELT));
					
					drawHoveringText(var7, par0, par1);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param par0 mouseX
	 * @param par1 mouseY
	 * @param par2 min
	 * @param par3 max
	 * @param par4 partial ticks
	 */
	private void describeTransmutingPage(int par0, int par1, int par2, int par3, float par4) {
		for(List<Component[]> var : Transmuting.LIST) {
			int index = Transmuting.LIST.indexOf(var);
			
			if(index >= par2 && index < par3) {
				Component[] component = timer.getCycledComponents(var);
				ItemStack var0 = component[0].getDisplayStack();
				ItemStack var1 = component[1].getDisplayStack();
				
				int perc = index % 10;
				int var2 = (perc < 5) ? perc : (perc - 5);
				int var3 = (perc < 5) ? 0 : 120;
				
				HoverChecker var4 = new HoverChecker((height / 2) - 53 + (var2 * 24), (height / 2) - 53 + 16 + (var2 * 24), (width / 2) - 98 + var3, (width / 2) - 98 + 16 + var3, 0);
				HoverChecker var5 = new HoverChecker((height / 2) - 53 + (var2 * 24), (height / 2) - 53 + 16 + (var2 * 24), (width / 2) - 38 + var3, (width / 2) - 38 + 16 + var3, 0);
				HoverChecker var6 = new HoverChecker((height / 2) - 53 + (var2 * 24), (height / 2) - 53 + 16 + (var2 * 24), (width / 2) - 68 + var3, (width / 2) - 68 + 16 + var3, 0);
				
				List<String> var7 = new ArrayList<String>();
				
				if(var4.checkHover(par0, par1)) {
					var7.add(ItemInit.MELTY_FLINT.getItemStackDisplayName(new ItemStack(ItemInit.MELTY_FLINT)));
					
					drawHoveringText(var7, par0, par1);
				} else if(var5.checkHover(par0, par1)) {
					var7.add(var1.getDisplayName());
					
					drawHoveringText(var7, par0, par1);
				} else if(var6.checkHover(par0, par1)) {
					var7.add(TextFormatting.GOLD + "" + TextFormatting.ITALIC + mc.gameSettings.keyBindUseItem.getDisplayName() + TextFormatting.RESET + " " + var0.getDisplayName());
					
					drawHoveringText(var7, par0, par1);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param par0 mouseX
	 * @param par1 mouseY
	 * @param par2 min
	 * @param par3 max
	 * @param par4 partial ticks
	 */
	private void describeCraftingPage(int par0, int par1, int par2, int par3, float par4) {
		for(List<Recipe> var : Crafting.getList()) {
			int index = Crafting.getList().indexOf(var);
			
			if(index >= par2 && index < par3) {
				Recipe recipe = timer.getCycledRecipe(var);
				
				int perc = index % 4;
				int var2 = (perc < 2) ? perc : (perc - 2);
				int var3 = (perc < 2) ? 0 : 120;
				
				HoverChecker var4 = new HoverChecker((height / 2) - 37 + (var2 * 64), (height / 2) - 21 + (var2 * 64), (width / 2) - 33 + var3, (width / 2) - 17 + var3, 0);
				HoverChecker var5 = new HoverChecker((height / 2) - 54 + (var2 * 64), (height / 2) - 38 + (var2 * 64), (width / 2) - 104 + var3, (width / 2) - 88 + var3, 0);
				HoverChecker var6 = new HoverChecker((height / 2) - 54 + (var2 * 64), (height / 2) - 38 + (var2 * 64), (width / 2) - 87 + var3, (width / 2) - 71 + var3, 0);
				HoverChecker var7 = new HoverChecker((height / 2) - 54 + (var2 * 64), (height / 2) - 38 + (var2 * 64), (width / 2) - 70 + var3, (width / 2) - 54 + var3, 0);
				HoverChecker var8 = new HoverChecker((height / 2) - 37 + (var2 * 64), (height / 2) - 21 + (var2 * 64), (width / 2) - 104 + var3, (width / 2) - 88 + var3, 0);
				HoverChecker var9 = new HoverChecker((height / 2) - 37 + (var2 * 64), (height / 2) - 21 + (var2 * 64), (width / 2) - 87 + var3, (width / 2) - 71 + var3, 0);
				HoverChecker var10 = new HoverChecker((height / 2) - 37 + (var2 * 64), (height / 2) - 21 + (var2 * 64), (width / 2) - 70 + var3, (width / 2) - 54 + var3, 0);
				HoverChecker var11 = new HoverChecker((height / 2) - 20 + (var2 * 64), (height / 2) - 4 + (var2 * 64), (width / 2) - 104 + var3, (width / 2) - 88 + var3, 0);
				HoverChecker var12 = new HoverChecker((height / 2) - 20 + (var2 * 64), (height / 2) - 4 + (var2 * 64), (width / 2) - 87 + var3, (width / 2) - 71 + var3, 0);
				HoverChecker var13 = new HoverChecker((height / 2) - 20 + (var2 * 64), (height / 2) - 4 + (var2 * 64), (width / 2) - 70 + var3, (width / 2) - 54 + var3, 0);
				HoverChecker var15 = new HoverChecker((height / 2) - 36 + (var2 * 64), (height / 2) - 21 + (var2 * 64), (width / 2) - 47 + var3, (width / 2) - 39 + var3, 0);
				
				
				List<String> var14 = new ArrayList<String>();
				
				if(var4.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[0] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[0].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var5.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[1] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[1].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var6.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[2] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[2].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var7.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[3] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[3].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var8.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[4] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[4].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var9.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[5] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[5].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var10.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[6] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[6].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var11.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[7] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[7].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var12.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[8] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[8].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var13.checkHover(par0, par1)) {
					if(recipe.getDisplayRecipe()[9] != ItemStack.EMPTY) {
						var14.add(recipe.getDisplayRecipe()[9].getDisplayName());
					}
					
					drawHoveringText(var14, par0, par1);
				} else if(var15.checkHover(par0, par1)) {
					var14.add(I18n.format(LangKeys.ACTION + recipe.getRecipeType().getKey()));
					
					drawHoveringText(var14, par0, par1);
				}
			}
		}
	}
}
