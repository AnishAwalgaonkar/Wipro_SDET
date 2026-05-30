package sdet_selenium_Day_03;

public class Employee_Salary {
	private double salary;
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public static void main(String[] args) {
		Employee_Salary emp = new Employee_Salary();
		
		emp.setSalary(4500);
		
		System.out.println("The salary is: " + emp.getSalary());
	}

}
