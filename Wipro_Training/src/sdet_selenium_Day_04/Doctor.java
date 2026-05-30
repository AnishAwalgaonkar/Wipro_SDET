package sdet_selenium_Day_04;

abstract class Doctor {
	public String name;
	public String specialization;

	public Doctor(String name, String specialization) {
		this.name = name;
		this.specialization = specialization;
	}
	
	abstract void diagnose(Patient patient);
	
}
