package sdet_selenium_Day_04;

public class Main {
    public static void main(String[] args) {

        PatientService service = new PatientServiceImpl();

        Patient p1 = new Patient(1, "Anish", 23, "cancer");
        Patient p2 = new Patient(2, "Rahul", 45, "heart pain");

        service.registerPatient(p1);
        service.registerPatient(p2);
        
        System.out.println();

        System.out.println("Patient Details: ");
        service.patientDetails(1);
        service.patientDetails(2);

        Doctor doc1 = new GeneralPhysician("Arpit");
        Doctor doc2 = new Cardiologist("Vijay");
        
        System.out.println();

        System.out.println("Diagnosis: ");
        doc1.diagnose(p1);
        doc1.diagnose(p2);
        doc2.diagnose(p1);
        doc2.diagnose(p2);
    }
}
