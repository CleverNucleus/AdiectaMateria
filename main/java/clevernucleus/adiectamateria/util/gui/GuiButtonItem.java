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
public class GuiButtonItem extends GuiButton {
	
	private final ResourceLocation background = new ResourceLocation(Util.MODID, "textures/gui/book.png");
	
	private int buttonWidth = 24;
	private int buttonHeight = 14;
	private int varX = 232;
	private int varY = 28;
	public int placeX;
	public int placeY;
	
	public GuiButtonItem(int par0, int par1, int par2) {
		super(par0, 24, 14, "");
		this.placeX = par1;
		this.placeY = par2;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float par) {
		if(visible) {
			
		mc.renderEngine.bindTexture(background);
			
			if (mouseX >= placeX && mouseX <= placeX + buttonWidth && mouseY >= placeY && mouseY <= placeY + buttonHeight) {
	            hovered = true;
	        } else {
	            hovered = false;
	        }
				
	        if (hovered) {
	            varX = 208;
	        } else {
	            varX = 232;
	        }
			
			drawTexturedModalRect(placeX, placeY, varX, varY, buttonWidth, buttonHeight);
	    }
	}
}
