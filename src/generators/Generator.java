package generators;

import java.util.ArrayList;

public abstract class Generator <T> {
	
	private ArrayList<T> inputs;
	
	public Generator() {
		
		inputs = new ArrayList<T>();
	}	
	

}
