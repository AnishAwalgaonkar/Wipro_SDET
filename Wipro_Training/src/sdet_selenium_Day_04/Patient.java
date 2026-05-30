package sdet_selenium_Day_04;

public class Patient {
	private int ID;
	private String name;
	private int age;
	private String illness;
	
	public Patient(int ID, String name, int age, String illness) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.illness = illness;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
}
