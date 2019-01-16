package clevernucleus.adiectamateria.util.gui;

import clevernucleus.adiectamateria.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class GuiButtonBook extends GuiButton {
	
	private final ResourceLocation background = new ResourceLocation(Util.MODID, "textures/gui/book.png");
	
	private boolean isNext;
	private int buttonWidth = 24;
	private int buttonHeight = 14;
	private int varX = 232;
	private int varY = 0;
	public int placeX;
	public int placeY;
	
	public GuiButtonBook(int par0, int par1, int par2, boolean par3) {
		super(par0, 24, 14, "");
		this.isNext = par3;
		this.placeX = par1;
		this.placeY = par2;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float par) {
		if(visible) {
			
			mc.renderEngine.bindTexture(background);
			
			if(isNext == true) {
				if (mouseX >= placeX && mouseX <= placeX + buttonWidth && mouseY >= placeY && mouseY <= placeY + buttonHeight) {
	                hovered = true;
	            } else {
	                hovered = false;
	            }
				
	            if (hovered) {
	                varY = 14;
	            } else {
	                varY = 0;
	            }
			} else {
				
				varX = 208;
				
				if (mouseX >= placeX && mouseX <= placeX + buttonWidth && mouseY >= placeY && mouseY <= placeY + buttonHeight) {
	                hovered = true;
	            } else {
	                hovered = false;
	            }
				
	            if (hovered) {
	                varY = 14;
	            } else {
	                varY = 0;
	            }
			}
			drawTexturedModalRect(placeX, placeY, varX, varY, buttonWidth, buttonHeight);
	    }
	}
}
