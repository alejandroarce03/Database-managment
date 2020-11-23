package Threads;

import javafx.beans.property.DoublePropertyBase;
import model.Database;

public class genPeopleThread {
	
	//Guided, Helped and adapted by Sebastian Jaramillo implementation
	
	private Database db;
	private GenerateController ui;
	private DoublePropertyBase observableNumber;
	
	
	public GeneratePeopleThread(Database db, GenerateController ui, int cant) {
		this.db = db;
		this.ui = ui;
		observableNumber = observInt(cant);
		
	}
	
	
	public static DoublePropertyBase observInt(int e) {
		
		DoublePropertyBase obsInt =  new DoublePropertyBase() {

			@Override
			public Object getBean() {
				// TODO Auto-generated method stub
				return this;
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return ".";
			}
			
		};
		
		obsInt.set(e);
		
		return obsInt;	
		
		
		
	}

}
