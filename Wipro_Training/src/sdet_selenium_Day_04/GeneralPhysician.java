package sdet_selenium_Day_04;

class GeneralPhysician extends Doctor {

    public GeneralPhysician(String name) {
        super(name, "General Medicine");
    }

    @Override
    void diagnose(Patient patient) {
        System.out.println("Dr. " + name + " diagnosed " 
            + patient.getName() + " for " + patient.getIllness());
    }
}