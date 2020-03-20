package clevernucleus.adiectamateria.client.content;

import net.minecraft.client.resources.I18n;

public class Page {
	private byte id;
	private Topic topic;
	
	public Page(Topic par0, int par1) {
		this.id = (byte) par1;
		this.topic = par0;
		
		par0.addPage(this);
	}
	
	public byte getId() {
		return id;
	}
	
	public String getText() {
		return LangKeys.PAGE + topic.getName() + "." + id + ".";
	}
	
	public void drawPage(int par0, int par1, float par2) {}
}
