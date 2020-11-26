package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import BST.BSTAvl;

public class Database {
	
	public static final String PICTURE_LINK = "https://thispersondoesnotexist.com/image";

	public static final String GEN_PATH = "data/generation_data/";
	
	public static final int MAX_PEOPLECAP = 1000000000;
	
	
	


	public final static String PATH_PERSON = "./data/personGenerator.txt";

	private BSTAvl<Person, String> nameDataBase;
	private BSTAvl<Person, Long> codeDataBase;
	private BSTAvl<Person, String> lastNameDataBase;
	
	

	public Database() {
		nameDataBase = new BSTAvl<Person, String>();
		codeDataBase = new BSTAvl<Person, Long>();
		lastNameDataBase = new BSTAvl<Person, String>();
		
		
	}
/*
	public void generateDataBase() {
		FileReader x;
		try {
			x = new FileReader(PATH_PERSON);
			BufferedReader br = new BufferedReader(x);

			while ((br.readLine() != null)) {
				String[] sr = br.readLine().split(" ");
				dataBase.add(new Person(sr[0], sr[1], (long) Integer.parseInt(sr[2]), sr[3].charAt(0), sr[4],
						(double) Integer.parseInt(sr[5]), sr[6]), Integer.parseInt(sr[2]));
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
	*/
	
	public Person addPerson(String name, String lastName, long code, char sex, LocalDate birthDate, double height,
			String nationality) {
		Person p = new Person(name, lastName,code,sex,birthDate,height,nationality);
		nameDataBase.add(p, name);
		lastNameDataBase.add(p, lastName);
		codeDataBase.add(p, code);
		return p;
	}


}
