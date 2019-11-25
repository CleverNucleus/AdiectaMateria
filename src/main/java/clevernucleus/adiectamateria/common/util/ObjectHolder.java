package clevernucleus.adiectamateria.common.util;

public class ObjectHolder {
	private Object[] objects;
	
	public ObjectHolder(Object ... par0) {
		this.objects = par0;
	}
	
	public Object getObject(int par0) {
		return objects[par0];
	}
	
	@Override
	public String toString() {
		if(objects[0] instanceof net.minecraft.block.state.IBlockState && objects[1] instanceof net.minecraft.block.state.IBlockState) {
			return "ObjHolder[" + (net.minecraft.block.state.IBlockState)objects[0] + ", " + (net.minecraft.block.state.IBlockState)objects[1] + "]";
		} else {
			return super.toString();
		}
	}
}
