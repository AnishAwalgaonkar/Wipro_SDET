package sdet_selenium_Day_03;

public class Car {
    private boolean isEngineOn;
    private double speed;
    private double fuelLevel;

    public Car(double initialFuel) {
        this.isEngineOn = false;
        this.speed = 0.0;
        this.fuelLevel = initialFuel;
    }

    public boolean isEngineOn() { 
    	return isEngineOn; 
    }
    public void setEngineOn(boolean engineOn) { 
    	this.isEngineOn = engineOn; 
    }
    public double getSpeed() { 
    	return speed; 
    }
    public void setSpeed(double speed) { 
    	if (speed >= 0) this.speed = speed; 
    }
    public double getFuelLevel() { 
    	return fuelLevel; 
    }
    public void setFuelLevel(double fuelLevel) { 
    	if (fuelLevel >= 0 && fuelLevel <= 100) this.fuelLevel = fuelLevel; 
    }

    public static void main(String[] args) {
        Car myCar = new Car(75.5);

        myCar.setEngineOn(true);
        myCar.setSpeed(60.0);

        System.out.println("Car Status: ");
        System.out.println("Engine started: " + myCar.isEngineOn());
        System.out.println("Current speed: " + myCar.getSpeed() + " km/h");
        System.out.println("Fuel level: " + myCar.getFuelLevel() + "%");
    }
}

