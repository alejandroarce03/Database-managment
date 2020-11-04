package model;

public class Person {
	
	public final static char MALE='M';
	public final static char FEMALE='F';
	
	
	private String name,lastName;
	private long code;
	private char sex;
	private String birthDate;
	private double height;
	private String nationality;
	
	
	public Person(String name, String lastName, long code, char sex, String birthDate, double height,
			String nationality) {
		this.name = name;
		this.lastName = lastName;
		this.code = code;
		this.sex = sex;
		this.birthDate = birthDate;
		this.height = height;
		this.nationality = nationality;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public long getCode() {
		return code;
	}


	public void setCode(long code) {
		this.code = code;
	}


	public char getSex() {
		return sex;
	}


	public void setSex(char sex) {
		this.sex = sex;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	
	
	
	
}
