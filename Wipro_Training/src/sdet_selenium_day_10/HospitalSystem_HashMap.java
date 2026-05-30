package sdet_selenium_day_10;
import java.util.*;

class Patient1 {
    int id;
    String name;

    public Patient1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
public class HospitalSystem_HashMap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Patient1> map = new HashMap<>();
		
		while(true) {
			 System.out.println("1. Add Patient");
	         System.out.println("2. Update Patient");
	         System.out.println("3. Get Patient");
	         System.out.println("4. Remove Patient");
	         System.out.println("5. List All Patients");
	         System.out.println("6. Check Patient Exists");
	         System.out.println("7. Count Patients");
	         System.out.println("8. Clear System");
	         System.out.println("9. Exit");
	         
	         System.out.print("Enter choice: ");
	         int choice = sc.nextInt();
	         
	         switch(choice) {
	         	case 1:
	         		System.out.print("Enter ID: ");
	         		int id = sc.nextInt();
	         		sc.nextLine();
	        	 
	         		if(map.containsKey(id)){
	         			System.out.println("Patient exists.");
	         		}
	        	 
	         		System.out.print("Enter name: ");
	         		String name = sc.nextLine();
	        	 
	         		map.put(id, (new Patient1(id, name)));
	         		System.out.println("Patient registered.");
	         		break;
	        	 
	         		case 2:
	                    System.out.print("Enter ID to update: ");
	                    id = sc.nextInt();
	                    sc.nextLine();

	                    if (!map.containsKey(id)) {
	                        System.out.println("Patient not found");
	                        break;
	                    }

	                    System.out.print("Enter new name: ");
	                    name = sc.nextLine();

	                    map.put(id, new Patient1(id, name));
	                    System.out.println("Updated");
	                    break;

	                case 3:
	                    System.out.print("Enter ID: ");
	                    id = sc.nextInt();

	                    System.out.println(map.getOrDefault(id, null));
	                    break;

	                case 4:
	                    System.out.print("Enter ID: ");
	                    id = sc.nextInt();

	                    map.remove(id);
	                    System.out.println("Removed (if existed)");
	                    break;

	                case 5:
	                    map.values().forEach(System.out::println);
	                    break;

	                case 6:
	                    System.out.print("Enter ID: ");
	                    id = sc.nextInt();

	                    System.out.println(map.containsKey(id) ? "Exists" : "Not Found");
	                    break;

	                case 7:
	                    System.out.println("Total Patients: " + map.size());
	                    break;

	                case 8:
	                    map.clear();
	                    System.out.println("System Cleared");
	                    break;

	                case 9:
	                    sc.close();
	                    return;
	        		 
	         }
		}
	}
}
