package sdet_selenium_Day_04;

public class PatientServiceImpl implements PatientService{
	
	Patient[] patients = new Patient[10];
	private int count = 0;
	
	@Override
	public void registerPatient(Patient patient) {
		if(count < patients.length) {
			patients[count] = patient;
			count++;
			System.out.println("Patient registered with name: " + patient.getName());
		}
		else {
			System.out.println("Registration is full.");
		}
		
	}
	@Override
	public void patientDetails(int id) {
		for (int i = 0; i < count; i++) {
            if (patients[i].getID() == id) {
                Patient p = patients[i];
                System.out.println("ID: " + p.getID());
                System.out.println("Name: " + p.getName());
                System.out.println("Age: " + p.getAge());
                System.out.println("Illness: " + p.getIllness());
                System.out.println();
                break;
            }
        }
	}
}
