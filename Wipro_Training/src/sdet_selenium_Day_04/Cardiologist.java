package sdet_selenium_Day_04;

class Cardiologist extends Doctor {

    public Cardiologist(String name) {
        super(name, "Cardiology");
    }

    @Override
    void diagnose(Patient patient) {
        if (patient.getIllness().contains("heart")) {
            System.out.println("Dr. " + name + " is treating heart disease of " 
                + patient.getName());
        } else {
            System.out.println("Dr. " + name + " suggested patient for a general checkup for " 
                + patient.getName());
        }
    }
}
