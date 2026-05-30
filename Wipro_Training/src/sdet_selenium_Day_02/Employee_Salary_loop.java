package sdet_selenium_Day_02;

public class Employee_Salary_loop {

	public static void main(String[] args) {
		
		int[] emp = {5000, 4000, 4500, 5500, 6000};
		
		for(int i=0; i<emp.length; i++) {
			System.out.println("\nEmployee: " + i);
			
			int salary = emp[i];
			
			System.out.println("Salary is: " + salary);
			
			double inc = salary * 0.10;
			
			double updated_salary = salary + inc;
			
			System.out.println("Increment Amount: " + inc);
            System.out.println("New Updated Salary: " + updated_salary);
		}

	}

}
