package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import BST.BSTAvl;

public class Database {
	
	public final static String PATH_PERSON="./data/personGenerator.txt";
	
	private BSTAvl<Person,Integer> dataBase;
	
	public Database() {
		dataBase = new BSTAvl<Person,Integer>();
	}
	
	public void generateDataBase()  {
		FileReader x;
		try {
			x = new FileReader(PATH_PERSON);
			BufferedReader br = new BufferedReader(x);
		
		while((br.readLine()!= null)){
			String[] sr = br.readLine().split(" ");
			dataBase.add(new Person(sr[0],sr[1],(long)Integer.parseInt(sr[2]),sr[3].charAt(0),sr[4],(double)Integer.parseInt(sr[5]),sr[6]),Integer.parseInt(sr[2]) );
		}
		
		br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public BSTAvl<Person, Integer> getDataBase() {
		return dataBase;
	}
}
