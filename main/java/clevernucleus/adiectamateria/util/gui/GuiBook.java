package clevernucleus.adiectamateria.util.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class GuiBook extends GuiScreen {
	
	private GuiButtonBook button0;
	private GuiButtonBook button1;
	private GuiButtonBook button2;
	private GuiButtonBook button3;
	private GuiButtonBook button4;
	private GuiButtonBook button5;
	private GuiButtonBook button6;
	private GuiButtonBook button7;
	
	private GuiButtonItem button_0;
	private GuiButtonItem button_1;
	private GuiButtonItem button_2;
	private GuiButtonItem button_3;
	private GuiButtonItem button_4;
	private GuiButtonItem button_5;
	private GuiButtonItem button_6;
	private GuiButtonItem button_7;
	private GuiButtonItem button_8;
	
	private final ResourceLocation background = new ResourceLocation(Util.MODID, "textures/gui/book.png");
	private final ResourceLocation title = new ResourceLocation(Util.MODID, "textures/gui/book_title.png");
	private final ResourceLocation overlay = new ResourceLocation(Util.MODID, "textures/gui/book_overlay.png");
	
	public List<ItemStack> WOOL = new ArrayList<ItemStack>();
	public List<ItemStack> STAINED_GLASS = new ArrayList<ItemStack>();
	public List<ItemStack> STAINED_HARDENED_CLAY = new ArrayList<ItemStack>();
	public List<ItemStack> CONCRETE_POWDER = new ArrayList<ItemStack>();
	public List<ItemStack> CONCRETE = new ArrayList<ItemStack>();
	public List<ItemStack> TERRACOTTA = new ArrayList<ItemStack>();
	public List<ItemStack> LOG = new ArrayList<ItemStack>();
	public List<ItemStack> PLANK = new ArrayList<ItemStack>();
	public List<ItemStack> SAPLING = new ArrayList<ItemStack>();
	
	public ItemStack[] colourWool = new ItemStack[] {new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(Blocks.WOOL, 1, 1), new ItemStack(Blocks.WOOL, 1, 2), new ItemStack(Blocks.WOOL, 1, 3), new ItemStack(Blocks.WOOL, 1, 4), new ItemStack(Blocks.WOOL, 1, 5), new ItemStack(Blocks.WOOL, 1, 6), new ItemStack(Blocks.WOOL, 1, 7), new ItemStack(Blocks.WOOL, 1, 8), new ItemStack(Blocks.WOOL, 1, 9), new ItemStack(Blocks.WOOL, 1, 10), new ItemStack(Blocks.WOOL, 1, 11), new ItemStack(Blocks.WOOL, 1, 12), new ItemStack(Blocks.WOOL, 1, 13), new ItemStack(Blocks.WOOL, 1, 14), new ItemStack(Blocks.WOOL, 1, 15)};
	public ItemStack[] colourStainedGlass = new ItemStack[] {new ItemStack(Blocks.STAINED_GLASS, 1, 0), new ItemStack(Blocks.STAINED_GLASS, 1, 1), new ItemStack(Blocks.STAINED_GLASS, 1, 2), new ItemStack(Blocks.STAINED_GLASS, 1, 3), new ItemStack(Blocks.STAINED_GLASS, 1, 4), new ItemStack(Blocks.STAINED_GLASS, 1, 5), new ItemStack(Blocks.STAINED_GLASS, 1, 6), new ItemStack(Blocks.STAINED_GLASS, 1, 7), new ItemStack(Blocks.STAINED_GLASS, 1, 8), new ItemStack(Blocks.STAINED_GLASS, 1, 9), new ItemStack(Blocks.STAINED_GLASS, 1, 10), new ItemStack(Blocks.STAINED_GLASS, 1, 11), new ItemStack(Blocks.STAINED_GLASS, 1, 12), new ItemStack(Blocks.STAINED_GLASS, 1, 13), new ItemStack(Blocks.STAINED_GLASS, 1, 14), new ItemStack(Blocks.STAINED_GLASS, 1, 15)};
	public ItemStack[] colourStainedHardenedClay = new ItemStack[] {new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 0), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 1), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 2), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 3), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 4), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 5), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 6), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 7), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 8), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 9), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 10), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 11), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 12), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 13), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 14), new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 15)};
	public ItemStack[] colourConcretePowder = new ItemStack[] {new ItemStack(Blocks.CONCRETE_POWDER, 1, 0), new ItemStack(Blocks.CONCRETE_POWDER, 1, 1), new ItemStack(Blocks.CONCRETE_POWDER, 1, 2), new ItemStack(Blocks.CONCRETE_POWDER, 1, 3), new ItemStack(Blocks.CONCRETE_POWDER, 1, 4), new ItemStack(Blocks.CONCRETE_POWDER, 1, 5), new ItemStack(Blocks.CONCRETE_POWDER, 1, 6), new ItemStack(Blocks.CONCRETE_POWDER, 1, 7), new ItemStack(Blocks.CONCRETE_POWDER, 1, 8), new ItemStack(Blocks.CONCRETE_POWDER, 1, 9), new ItemStack(Blocks.CONCRETE_POWDER, 1, 10), new ItemStack(Blocks.CONCRETE_POWDER, 1, 11), new ItemStack(Blocks.CONCRETE_POWDER, 1, 12), new ItemStack(Blocks.CONCRETE_POWDER, 1, 13), new ItemStack(Blocks.CONCRETE_POWDER, 1, 14), new ItemStack(Blocks.CONCRETE_POWDER, 1, 15)};
	public ItemStack[] colourConcrete = new ItemStack[] {new ItemStack(Blocks.CONCRETE, 1, 0), new ItemStack(Blocks.CONCRETE, 1, 1), new ItemStack(Blocks.CONCRETE, 1, 2), new ItemStack(Blocks.CONCRETE, 1, 3), new ItemStack(Blocks.CONCRETE, 1, 4), new ItemStack(Blocks.CONCRETE, 1, 5), new ItemStack(Blocks.CONCRETE, 1, 6), new ItemStack(Blocks.CONCRETE, 1, 7), new ItemStack(Blocks.CONCRETE, 1, 8), new ItemStack(Blocks.CONCRETE, 1, 9), new ItemStack(Blocks.CONCRETE, 1, 10), new ItemStack(Blocks.CONCRETE, 1, 11), new ItemStack(Blocks.CONCRETE, 1, 12), new ItemStack(Blocks.CONCRETE, 1, 13), new ItemStack(Blocks.CONCRETE, 1, 14), new ItemStack(Blocks.CONCRETE, 1, 15)};
	public ItemStack[] colourTerracotta = new ItemStack[] {new ItemStack(Blocks.WHITE_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.ORANGE_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.YELLOW_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.LIME_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.PINK_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.GRAY_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.SILVER_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.CYAN_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.PURPLE_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.BLUE_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.BROWN_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.GREEN_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.RED_GLAZED_TERRACOTTA, 1, 0), new ItemStack(Blocks.BLACK_GLAZED_TERRACOTTA, 1, 0)};
	public ItemStack[] colourLog = new ItemStack[] {new ItemStack(Blocks.LOG, 1, 0), new ItemStack(Blocks.LOG, 1, 1), new ItemStack(Blocks.LOG, 1, 2), new ItemStack(Blocks.LOG, 1, 3), new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(Blocks.LOG2, 1, 1)};
	public ItemStack[] colourPlank = new ItemStack[] {new ItemStack(Blocks.PLANKS, 1, 0), new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(Blocks.PLANKS, 1, 2), new ItemStack(Blocks.PLANKS, 1, 3), new ItemStack(Blocks.PLANKS, 1, 4), new ItemStack(Blocks.PLANKS, 1, 5)};
	public ItemStack[] colourSapling = new ItemStack[] {new ItemStack(Blocks.SAPLING, 1, 0), new ItemStack(Blocks.SAPLING, 1, 1), new ItemStack(Blocks.SAPLING, 1, 2), new ItemStack(Blocks.SAPLING, 1, 3), new ItemStack(Blocks.SAPLING, 1, 4), new ItemStack(Blocks.SAPLING, 1, 5)};
	
	public int cycleWoolColourIn = 0;
	public int cycleWoolColourOut = 1;
	public int cycleStainedGlassColourIn = 0;
	public int cycleStainedGlassColourOut = 1;
	public int cycleStainedHardenedClayColourIn = 0;
	public int cycleStainedHardenedClayColourOut = 1;
	public int cycleConcretePowderColourIn = 0;
	public int cycleConcretePowderColourOut = 1;
	public int cycleConcreteColourIn = 0;
	public int cycleConcreteColourOut = 1;
	public int cycleTerracottaColourIn = 0;
	public int cycleTerracottaColourOut = 1;
	public int cycleLogColourIn = 0;
	public int cycleLogColourOut = 1;
	public int cyclePlankColourIn = 0;
	public int cyclePlankColourOut = 1;
	public int cycleSaplingColourIn = 0;
	public int cycleSaplingColourOut = 1;
	
	private int varX = 190;
	private int varY = 256;
	
	private boolean page0 = true;
	private boolean page1 = false;
	private boolean page2 = false;
	private boolean page3 = false;
	private boolean page4 = false;
	private boolean page5 = false;
	private boolean page6 = false;
	
	public CycleTimer timerWoolIn;
	public CycleTimer timerWoolOut;
	public CycleTimer timerStainedGlassIn;
	public CycleTimer timerStainedGlassOut;
	public CycleTimer timerStainedHardenedClayIn;
	public CycleTimer timerStainedHardenedClayOut;
	public CycleTimer timerConcretePowderIn;
	public CycleTimer timerConcretePowderOut;
	public CycleTimer timerConcreteIn;
	public CycleTimer timerConcreteOut;
	public CycleTimer timerTerracottaIn;
	public CycleTimer timerTerracottaOut;
	public CycleTimer timerLogIn;
	public CycleTimer timerLogOut;
	public CycleTimer timerPlankIn;
	public CycleTimer timerPlankOut;
	public CycleTimer timerSaplingIn;
	public CycleTimer timerSaplingOut;
	
	private int centreX;
	private int centreY;
	private int mouseX;
	private int mouseY;
	private double scale = 1.5;
	
	/**
	 * Draws objects onto the screen.
	 */
	@Override
	public void drawScreen(int par0, int par1, float par2) {
		
		int getCentreX = (width / 2) - (varX / 2);
		int getCentreY = (height / 2) - (varY / 2);
		int textX = 10;
		
		centreX = getCentreX;
		centreY = getCentreY;
		mouseX = par0;
		mouseY = par1;
		
		Minecraft.getMinecraft().renderEngine.bindTexture(background);
		drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
		
		displayPage(0, page0);
		displayPage(1, page1);
		displayPage(2, page2);
		displayPage(3, page3);
		displayPage(4, page4);
		displayPage(5, page5);
		displayPage(6, page6);
	}
	
	/**
	 * Gets an itemstack from a list of world crafting itemstacks.
	 * @param par0 the item's / block's case ID (useful for loops).
	 * @return an itemstack.
	 */
	public ItemStack renderObject(int par0) {
		switch(par0) {
		case 0: return new ItemStack(Objects.ITEM_ALTERA_DUST, 1, 0);
		case 1: return new ItemStack(Blocks.DIRT, 1, 0);
		case 2: return new ItemStack(Blocks.GRASS, 1, 0);
		case 3: return new ItemStack(Blocks.STONE, 1, 0);
		case 4: return new ItemStack(Blocks.COBBLESTONE, 1, 0);
		case 5: return new ItemStack(Blocks.SAND, 1, 0);
		case 6: return new ItemStack(Blocks.GLASS, 1, 0);
		case 7: return new ItemStack(Blocks.OBSIDIAN, 1, 0);
		case 8: return new ItemStack(Items.LAVA_BUCKET, 1, 0);
		case 9: return new ItemStack(Blocks.PUMPKIN, 1, 0);
		case 10: return new ItemStack(Blocks.MELON_BLOCK, 1, 0);
		case 11: return new ItemStack(Blocks.SAND, 1, 1);
		case 12: return new ItemStack(Blocks.NETHERRACK, 1, 0);
		case 13: return new ItemStack(Blocks.SOUL_SAND, 1, 0);
		case 14: return new ItemStack(Blocks.END_STONE, 1, 0);
		case 15: return new ItemStack(Blocks.CLAY, 1, 0);
		case 16: return new ItemStack(Objects.BLOCK_CERAMIC, 1, 0);
		case 17: return new ItemStack(Blocks.GRAVEL, 1, 0);
		case 18: return new ItemStack(Items.FLINT, 1, 0);
		case 19: return new ItemStack(Objects.BLOCK_RICE, 1, 0);
		case 20: return new ItemStack(Objects.BLOCK_PAPER_WALL, 1, 0);
		case 21: return new ItemStack(Blocks.TALLGRASS, 1, 1);
		case 22: return new ItemStack(Objects.ITEM_RICE_SEEDS, 1, 0);
		case 23: return new ItemStack(Blocks.LEAVES, 1, 0);
		case 24: return new ItemStack(Items.APPLE, 1, 0);
		case 25: return new ItemStack(Blocks.ICE, 1, 0);
		case 26: return new ItemStack(Items.WATER_BUCKET, 1, 0);
		case 27: return new ItemStack(Blocks.BOOKSHELF, 1, 0);
		case 28: return new ItemStack(Objects.ITEM_BOOK, 1, 0);
		}
		return new ItemStack(Items.APPLE, 1, 0);
	}
	
	/**
	 * Gets the x coordinates.
	 * @param par0 the ID.
	 * @return the screen x coordinate.
	 */
	public int getObjectX(int par0) {
		switch(par0) {
		case 0: return 50;
		case 1: return 8;
		case 2: return 88;
		}
		return par0;
	}
	
	/**
	 * Gets the y coordinates.
	 * @param par0 the ID.
	 * @return the screen y coordinate.
	 */
	public int getObjectY(int par0) {
		switch(par0) {
		case 0: return 10;
		case 1: return 40;
		case 2: return 70;
		case 3: return 100;
		case 4: return 130;
		}
		return par0;
	}
	
	/**
	 * Determines whether to display the page or not.
	 * @param par0 the page number / ID; i.e. the front page is 0.
	 * @param par1 whether the page should be displayed.
	 * @return true to display the page.
	 */
	public boolean displayPage(int par0, boolean par1) {
		if(par0 == 0 && par1 == true) {
			
			button0.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(title);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line0, centreX + 10, centreY + 75, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line1, centreX + 10, centreY + 85, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line2, centreX + 10, centreY + 95, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line3, centreX + 10, centreY + 110, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line4, centreX + 10, centreY + 120, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line5, centreX + 10, centreY + 130, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line6, centreX + 10, centreY + 140, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line7, centreX + 10, centreY + 150, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line8, centreX + 10, centreY + 160, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line9, centreX + 10, centreY + 175, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line10, centreX + 10, centreY + 185, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line11, centreX + 10, centreY + 195, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line12, centreX + 10, centreY + 205, 0x404040);
			Minecraft.getMinecraft().fontRenderer.drawString(Util.line13, centreX + 10, centreY + 215, 0x404040);
		}
		
		if(par0 == 1 && par1 == true) {
			
			Minecraft.getMinecraft().renderEngine.bindTexture(overlay);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			
			button1.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button2.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centreX, centreY, 0);
			GlStateManager.scale(scale, scale, scale);
			
			RenderHelper.enableGUIStandardItemLighting();
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(1), getObjectX(1), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(2), getObjectX(2), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(1), getObjectX(2), getObjectY(1));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(2), getObjectX(1), getObjectY(1));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(3), getObjectX(1), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(4), getObjectX(2), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(3), getObjectX(2), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(4), getObjectX(1), getObjectY(3));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(5), getObjectX(1), getObjectY(4));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(6), getObjectX(2), getObjectY(4));
			
			GlStateManager.popMatrix();
			
			drawToolTip(1, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(2, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(1, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			drawToolTip(2, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(3, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(4, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(3, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip(4, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(5, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
			drawToolTip(6, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
		}
		
		if(par0 == 2 && par1 == true) {
			
			Minecraft.getMinecraft().renderEngine.bindTexture(overlay);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			
			button3.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button4.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centreX, centreY, 0);
			GlStateManager.scale(scale, scale, scale);
			
			RenderHelper.enableGUIStandardItemLighting();
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(5), getObjectX(2), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(6), getObjectX(1), getObjectY(0));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(7), getObjectX(1), getObjectY(1));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(8), getObjectX(2), getObjectY(1));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(9), getObjectX(1), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(10), getObjectX(2), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(9), getObjectX(2), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(10), getObjectX(1), getObjectY(3));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(11), getObjectX(1), getObjectY(4));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(12), getObjectX(2), getObjectY(4));
			
			GlStateManager.popMatrix();
			
			drawToolTip(5, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(6, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(7, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			drawToolTip("Lava", mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(9, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(10, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(9, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip(10, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(11, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
			drawToolTip(12, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
		}
		
		if(par0 == 3 && par1 == true) {
			
			Minecraft.getMinecraft().renderEngine.bindTexture(overlay);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			
			button3.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button4.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centreX, centreY, 0);
			GlStateManager.scale(scale, scale, scale);
			
			RenderHelper.enableGUIStandardItemLighting();
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(12), getObjectX(1), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(13), getObjectX(2), getObjectY(0));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(13), getObjectX(1), getObjectY(1));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(14), getObjectX(2), getObjectY(1));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(14), getObjectX(1), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(11), getObjectX(2), getObjectY(2));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(15), getObjectX(1), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(16), getObjectX(2), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(15), getObjectX(2), getObjectY(4));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(16), getObjectX(1), getObjectY(4));
			
			GlStateManager.popMatrix();
			
			drawToolTip(12, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(13, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(13, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			drawToolTip(14, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(14, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(11, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(15, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip(16, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip(15, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
			drawToolTip(16, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
		}
		
		if(par0 == 4 && par1 == true) {
			
			for(ItemStack var : colourWool) {
				WOOL.add(var);
			}
			
			timerWoolIn = new CycleTimer(cycleWoolColourIn);
			timerWoolOut = new CycleTimer(cycleWoolColourOut);
			
			timerWoolIn.onDraw();
			timerWoolOut.onDraw();
			
			ItemStack woolIn = timerWoolIn.getCycledItem(WOOL);
			ItemStack woolOut = timerWoolOut.getCycledItem(WOOL);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(overlay);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			
			button3.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button4.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_0.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centreX, centreY, 0);
			GlStateManager.scale(scale, scale, scale);
			
			RenderHelper.enableGUIStandardItemLighting();
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(17), getObjectX(1), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(18), getObjectX(2), getObjectY(0));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(19), getObjectX(1), getObjectY(1));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(20), getObjectX(2), getObjectY(1));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(21), getObjectX(1), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(22), getObjectX(2), getObjectY(2));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(23), getObjectX(1), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(24), getObjectX(2), getObjectY(3));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(woolIn, getObjectX(1), getObjectY(4));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(woolOut, getObjectX(2), getObjectY(4));
			
			GlStateManager.popMatrix();
			
			drawToolTip(17, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(18, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(19, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			drawToolTip(20, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(21, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(22, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(23, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip(24, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(woolIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
			drawToolTip(woolOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
		}
		
		if(par0 == 5 && par1 == true) {
			for(ItemStack var : colourStainedGlass) {
				STAINED_GLASS.add(var);
			}
			
			for(ItemStack var : colourStainedHardenedClay) {
				STAINED_HARDENED_CLAY.add(var);
			}
			
			for(ItemStack var : colourConcretePowder) {
				CONCRETE_POWDER.add(var);
			}
			
			for(ItemStack var : colourConcrete) {
				CONCRETE.add(var);
			}
			
			for(ItemStack var : colourTerracotta) {
				TERRACOTTA.add(var);
			}
			
			timerStainedGlassIn = new CycleTimer(cycleStainedGlassColourIn);
			timerStainedGlassOut = new CycleTimer(cycleStainedGlassColourOut);
			timerStainedHardenedClayIn = new CycleTimer(cycleStainedHardenedClayColourIn);
			timerStainedHardenedClayOut = new CycleTimer(cycleStainedHardenedClayColourOut);
			timerConcretePowderIn = new CycleTimer(cycleConcretePowderColourIn);
			timerConcretePowderOut = new CycleTimer(cycleConcretePowderColourOut);
			timerConcreteIn = new CycleTimer(cycleConcreteColourIn);
			timerConcreteOut = new CycleTimer(cycleConcreteColourOut);
			timerTerracottaIn = new CycleTimer(cycleTerracottaColourIn);
			timerTerracottaOut = new CycleTimer(cycleTerracottaColourOut);
			
			timerStainedGlassIn.onDraw();
			timerStainedGlassOut.onDraw();
			timerStainedHardenedClayIn.onDraw();
			timerStainedHardenedClayOut.onDraw();
			timerConcretePowderIn.onDraw();
			timerConcretePowderOut.onDraw();
			timerConcreteIn.onDraw();
			timerConcreteOut.onDraw();
			timerTerracottaIn.onDraw();
			timerTerracottaOut.onDraw();
			
			ItemStack StainedGlassIn = timerStainedGlassIn.getCycledItem(STAINED_GLASS);
			ItemStack StainedGlassOut = timerStainedGlassOut.getCycledItem(STAINED_GLASS);
			ItemStack StainedHardenedClayIn = timerStainedHardenedClayIn.getCycledItem(STAINED_HARDENED_CLAY);
			ItemStack StainedHardenedClayOut = timerStainedHardenedClayOut.getCycledItem(STAINED_HARDENED_CLAY);
			ItemStack ConcretePowderIn = timerConcretePowderIn.getCycledItem(CONCRETE_POWDER);
			ItemStack ConcretePowderOut = timerConcretePowderOut.getCycledItem(CONCRETE_POWDER);
			ItemStack ConcreteIn = timerConcreteIn.getCycledItem(CONCRETE);
			ItemStack ConcreteOut = timerConcreteOut.getCycledItem(CONCRETE);
			ItemStack TerracottaIn = timerTerracottaIn.getCycledItem(TERRACOTTA);
			ItemStack TerracottaOut = timerTerracottaOut.getCycledItem(TERRACOTTA);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(overlay);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			
			button5.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button6.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			button_1.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_2.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_3.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_4.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_5.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centreX, centreY, 0);
			GlStateManager.scale(scale, scale, scale);
			
			RenderHelper.enableGUIStandardItemLighting();
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(StainedGlassIn, getObjectX(1), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(StainedGlassOut, getObjectX(2), getObjectY(0));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(StainedHardenedClayIn, getObjectX(1), getObjectY(1));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(StainedHardenedClayOut, getObjectX(2), getObjectY(1));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(ConcretePowderIn, getObjectX(1), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(ConcretePowderOut, getObjectX(2), getObjectY(2));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(ConcreteIn, getObjectX(1), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(ConcreteOut, getObjectX(2), getObjectY(3));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(TerracottaIn, getObjectX(1), getObjectY(4));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(TerracottaOut, getObjectX(2), getObjectY(4));
			
			GlStateManager.popMatrix();
			
			drawToolTip(StainedGlassIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(StainedGlassOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(StainedHardenedClayIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			drawToolTip(StainedHardenedClayOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(ConcretePowderIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(ConcretePowderOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(ConcreteIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip(ConcreteOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(TerracottaIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
			drawToolTip(TerracottaOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
		}
		
		if(par0 == 6 && par1 == true) {
			for(ItemStack var : colourLog) {
				LOG.add(var);
			}
			
			for(ItemStack var : colourPlank) {
				PLANK.add(var);
			}
			
			for(ItemStack var : colourSapling) {
				SAPLING.add(var);
			}
			
			timerLogIn = new CycleTimer(cycleLogColourIn);
			timerLogOut = new CycleTimer(cycleLogColourOut);
			timerPlankIn = new CycleTimer(cyclePlankColourIn);
			timerPlankOut = new CycleTimer(cyclePlankColourOut);
			timerSaplingIn = new CycleTimer(cycleSaplingColourIn);
			timerSaplingOut = new CycleTimer(cycleSaplingColourOut);
			
			timerLogIn.onDraw();
			timerLogOut.onDraw();
			timerPlankIn.onDraw();
			timerPlankOut.onDraw();
			timerSaplingIn.onDraw();
			timerSaplingOut.onDraw();
			
			ItemStack LogIn = timerLogIn.getCycledItem(LOG);
			ItemStack LogOut = timerLogOut.getCycledItem(LOG);
			ItemStack PlankIn = timerPlankIn.getCycledItem(PLANK);
			ItemStack PlankOut = timerPlankOut.getCycledItem(PLANK);
			ItemStack SaplingIn = timerSaplingIn.getCycledItem(SAPLING);
			ItemStack SaplingOut = timerSaplingOut.getCycledItem(SAPLING);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(overlay);
			drawTexturedModalRect(centreX, centreY, 0, 0, varX, varY);
			
			button7.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			button_6.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_7.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			button_8.drawButton(Minecraft.getMinecraft(), mouseX, mouseY, 0.0F);
			
			GlStateManager.pushMatrix();
			GlStateManager.translate(centreX, centreY, 0);
			GlStateManager.scale(scale, scale, scale);
			
			RenderHelper.enableGUIStandardItemLighting();
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(LogIn, getObjectX(1), getObjectY(0));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(LogOut, getObjectX(2), getObjectY(0));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(PlankIn, getObjectX(1), getObjectY(1));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(PlankOut, getObjectX(2), getObjectY(1));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(SaplingIn, getObjectX(1), getObjectY(2));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(SaplingOut, getObjectX(2), getObjectY(2));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(25), getObjectX(1), getObjectY(3));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(26), getObjectX(2), getObjectY(3));
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(27), getObjectX(1), getObjectY(4));
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(renderObject(28), getObjectX(2), getObjectY(4));
			
			GlStateManager.popMatrix();
			
			drawToolTip(LogIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			drawToolTip(LogOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(0) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(PlankIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			drawToolTip(PlankOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(1) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(SaplingIn, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			drawToolTip(SaplingOut, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(2) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(25, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			drawToolTip("Water", mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(3) * scale), 16 * scale, 16 * scale);
			
			drawToolTip(27, mouseX, mouseY, centreX + (getObjectX(1) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
			drawToolTip(28, mouseX, mouseY, centreX + (getObjectX(2) * scale), centreY + (getObjectY(4) * scale), 16 * scale, 16 * scale);
		}
		return par1;
	}
	
	/**
	 * Draws a tool tip for a displayed itemstack.
	 * @param par0 the itemstack ID; useful for loops.
	 * @param par1 mouseX.
	 * @param par2 mouseY.
	 * @param par3 posX start.
	 * @param par4 posY start.
	 * @param par5 posX end.
	 * @param par6 posY end.
	 */
	public void drawToolTip(int par0, int par1, int par2, double par3, double par4, double par5, double par6) {
		
		List<String> var0 = new ArrayList<String>();
		
		if(par1 >= par3 && par1 <= par3 + par5 && par2 >= par4 && par2 <= par4 + par6) {
			var0.add(renderObject(par0).getDisplayName());
			drawHoveringText(var0, par1, par2);
		}
	}
	
	/**
	 * Draws a tool tip for a displayed itemstack.
	 * @param par0 the itemstack.
	 * @param par1 mouseX.
	 * @param par2 mouseY.
	 * @param par3 posX start.
	 * @param par4 posY start.
	 * @param par5 posX end.
	 * @param par6 posY end.
	 */
	public void drawToolTip(ItemStack par0, int par1, int par2, double par3, double par4, double par5, double par6) {
		
		List<String> var0 = new ArrayList<String>();
		
		if(par1 >= par3 && par1 <= par3 + par5 && par2 >= par4 && par2 <= par4 + par6) {
			var0.add(par0.getDisplayName());
			drawHoveringText(var0, par1, par2);
		}
	}
	
	/**
	 * Draws a tool tip for an area.
	 * @param par0 the tool tip.
	 * @param par1 mouseX.
	 * @param par2 mouseY.
	 * @param par3 posX start.
	 * @param par4 posY start.
	 * @param par5 posX end.
	 * @param par6 posY end.
	 */
	public void drawToolTip(String par0, int par1, int par2, double par3, double par4, double par5, double par6) {
		
		List<String> var0 = new ArrayList<String>();
		
		if(par1 >= par3 && par1 <= par3 + par5 && par2 >= par4 && par2 <= par4 + par6) {
			var0.add(par0);
			drawHoveringText(var0, par1, par2);
		}
	}
	
	/**
	 * Initiates the GUI.
	 */
	@Override
	public void initGui() {
		
		buttonList.clear();
		buttonList.add(button0 = new GuiButtonBook(0, (width / 2) + 40, (height / 2) + 100, true));
		buttonList.add(button1 = new GuiButtonBook(1, (width / 2) - 85, (height / 2) + 100, false));
		buttonList.add(button2 = new GuiButtonBook(2, (width / 2) + 40, (height / 2) + 100, true));
		buttonList.add(button3 = new GuiButtonBook(3, (width / 2) - 85, (height / 2) + 100, false));
		buttonList.add(button4 = new GuiButtonBook(4, (width / 2) + 40, (height / 2) + 100, true));
		buttonList.add(button5 = new GuiButtonBook(5, (width / 2) - 85, (height / 2) + 100, false));
		buttonList.add(button6 = new GuiButtonBook(6, (width / 2) + 40, (height / 2) + 100, true));
		buttonList.add(button7 = new GuiButtonBook(7, (width / 2) - 85, (height / 2) + 100, false));
		buttonList.add(button_0 = new GuiButtonItem(20, (width / 2) - 21, (height / 2) + 61));
		buttonList.add(button_1 = new GuiButtonItem(21, (width / 2) - 21, (height / 2) + 61));
		buttonList.add(button_2 = new GuiButtonItem(22, (width / 2) - 21, (height / 2) + 16));
		buttonList.add(button_3 = new GuiButtonItem(23, (width / 2) - 21, (height / 2) - 29));
		buttonList.add(button_4 = new GuiButtonItem(24, (width / 2) - 21, (height / 2) - 74));
		buttonList.add(button_5 = new GuiButtonItem(25, (width / 2) - 21, (height / 2) - 119));
		buttonList.add(button_6 = new GuiButtonItem(26, (width / 2) - 21, (height / 2) - 119));
		buttonList.add(button_7 = new GuiButtonItem(27, (width / 2) - 21, (height / 2) - 74));
		buttonList.add(button_8 = new GuiButtonItem(28, (width / 2) - 21, (height / 2) - 29));
		super.initGui();
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 0) {
			if(mouseX >= (width / 2) + 40 && mouseX <= (width / 2) + 40 + 24 && mouseY >= (height / 2) + 100 && mouseY <= (height / 2) + 100 + 14) {
				if(page0 == true && page1 == false && page2 == false && page3 == false && page4 == false && page5 == false && page6 == false) {
					page0 = false;
					page1 = true;
					page2 = false;
					page3 = false;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == true && page2 == false && page3 == false && page4 == false && page5 == false && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = true;
					page3 = false;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == true && page3 == false && page4 == false && page5 == false && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = true;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == true && page4 == false && page5 == false && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = false;
					page4 = true;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == false && page4 == true && page5 == false && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = false;
					page4 = false;
					page5 = true;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == false && page4 == false && page5 == true && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = false;
					page4 = false;
					page5 = false;
					page6 = true;
				}
			} else if(mouseX >= (width / 2) - 85 && mouseX <= (width / 2) - 85 + 24 && mouseY >= (height / 2) + 100 && mouseY <= (height / 2) + 100 + 14) {
				if(page0 == false && page1 == true && page2 == false && page3 == false && page4 == false && page5 == false && page6 == false) {
					page0 = true;
					page1 = false;
					page2 = false;
					page3 = false;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == true && page3 == false && page4 == false && page5 == false && page6 == false) {
					page0 = false;
					page1 = true;
					page2 = false;
					page3 = false;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == true && page4 == false && page5 == false && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = true;
					page3 = false;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == false && page4 == true && page5 == false && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = true;
					page4 = false;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == false && page4 == false && page5 == true && page6 == false) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = false;
					page4 = true;
					page5 = false;
					page6 = false;
				} else if(page0 == false && page1 == false && page2 == false && page3 == false && page4 == false && page5 == false && page6 == true) {
					page0 = false;
					page1 = false;
					page2 = false;
					page3 = false;
					page4 = false;
					page5 = true;
					page6 = false;
				}
			} else if(page4 == true) {
				if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) + 61 && mouseY <= (height / 2) + 61 + 14) {
					if(cycleWoolColourIn < 15) {
						cycleWoolColourIn++;
						cycleWoolColourOut++;
					} else if(cycleWoolColourIn == 15) {
						cycleWoolColourIn = 0;
						cycleWoolColourOut = 1;
					}
				}
			} else if(page5 == true) {
				if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) + 61 && mouseY <= (height / 2) + 61 + 14) {
					if(cycleTerracottaColourIn < 15) {
						cycleTerracottaColourIn++;
						cycleTerracottaColourOut++;
					} else if(cycleTerracottaColourIn == 15) {
						cycleTerracottaColourIn = 0;
						cycleTerracottaColourOut = 1;
					}
				} else if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) + 16 && mouseY <= (height / 2) + 16 + 14) {
					if(cycleConcreteColourIn < 15) {
						cycleConcreteColourIn++;
						cycleConcreteColourOut++;
					} else if(cycleConcreteColourIn == 15) {
						cycleConcreteColourIn = 0;
						cycleConcreteColourOut = 1;
					}
				} else if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) - 29 && mouseY <= (height / 2) - 29 + 14) {
					if(cycleConcretePowderColourIn < 15) {
						cycleConcretePowderColourIn++;
						cycleConcretePowderColourOut++;
					} else if(cycleConcretePowderColourIn == 15) {
						cycleConcretePowderColourIn = 0;
						cycleConcretePowderColourOut = 1;
					}
				} else if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) - 74 && mouseY <= (height / 2) - 74 + 14) {
					if(cycleStainedHardenedClayColourIn < 15) {
						cycleStainedHardenedClayColourIn++;
						cycleStainedHardenedClayColourOut++;
					} else if(cycleStainedHardenedClayColourIn == 15) {
						cycleStainedHardenedClayColourIn = 0;
						cycleStainedHardenedClayColourOut = 1;
					}
				} else if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) - 119 && mouseY <= (height / 2) - 119 + 14) {
					if(cycleStainedGlassColourIn < 15) {
						cycleStainedGlassColourIn++;
						cycleStainedGlassColourOut++;
					} else if(cycleStainedGlassColourIn == 15) {
						cycleStainedGlassColourIn = 0;
						cycleStainedGlassColourOut = 1;
					}
				}
			} else if(page6 == true) {
				if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) - 119 && mouseY <= (height / 2) - 119 + 14) {
					if(cycleLogColourIn < 5) {
						cycleLogColourIn++;
						cycleLogColourOut++;
					} else if(cycleLogColourIn == 5) {
						cycleLogColourIn = 0;
						cycleLogColourOut = 1;
					}
				} else if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) - 74 && mouseY <= (height / 2) - 74 + 14) {
					if(cyclePlankColourIn < 5) {
						cyclePlankColourIn++;
						cyclePlankColourOut++;
					} else if(cyclePlankColourIn == 5) {
						cyclePlankColourIn = 0;
						cyclePlankColourOut = 1;
					}
				} else if(mouseX >= (width / 2) - 21 && mouseX <= (width / 2) - 21 + 24 && mouseY >= (height / 2) - 29 && mouseY <= (height / 2) - 29 + 14) {
					if(cycleSaplingColourIn < 5) {
						cycleSaplingColourIn++;
						cycleSaplingColourOut++;
					} else if(cycleSaplingColourIn == 5) {
						cycleSaplingColourIn = 0;
						cycleSaplingColourOut = 1;
					}
				}
			}
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	/**
	 * Client Side Only. Is the game paused when the GUI opens.
	 */
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
