package clevernucleus.adiectamateria.client.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class Topic {
	private Map<Byte, Page> pages = new HashMap<>();
	private ItemStack displayStack;
	private String name;
	private byte id;
	
	public Topic(String par0, int par1, ItemStack par2) {
		this.name = par0;
		this.id = (byte) par1;
		this.displayStack = par2;
	}
	
	public Topic add(List<Topic> par0) {
		par0.add(id, this);
		
		return this;
	}
	
	public void addPage(Page par0) {
		pages.put(par0.getId(), par0);
	}
	
	public Map<Byte, Page> getPages() {
		return pages;
	}
	
	public ItemStack getDisplayStack() {
		return displayStack;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDisplayName() {
		return I18n.format(LangKeys.TOPIC + name);
	}
	
	public byte getId() {
		return id;
	}
}
