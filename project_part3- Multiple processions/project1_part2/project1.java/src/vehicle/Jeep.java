package vehicle;

public class Jeep extends Land implements Motorized, Commercial {
    private int fuelConsumption;
    private int engineLife;
    private String licenseType;

    public Jeep(String model, int maxSpeed, int fuelConsumption, int engineLife) {
        /**
         * Constructor of the Jeep class inheriting from Land class
         */
        super(model, maxSpeed, 5, 4, "dirt");
        this.licenseType = "MINI";
        this.fuelConsumption = fuelConsumption;
        this.engineLife = engineLife;
    }

    public void setLicenseType(String licenseType) {
        /**
         * A function that receives a string and accordingly updates
         * what the licenseType is and does not return anything
         */
        this.licenseType = licenseType;
    }

    public String getLicenseType() {
        /**
         * A function that receives nothing and returns what the license type
         * of the vehicle is
         */
        return licenseType;
    }

    public void setFuelConsumption(int fuelConsumption) {
        /**
         * A function that receives an integer and accordingly updates
         * what the average fuel consumption is and does not return anything
         */
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption() {
        /**
         * A function that receives nothing and returns what the average fuel consumption
         * of the vehicle is
         */
        return fuelConsumption;
    }

    public void setEngineLife(int engineLife) {
        /**
         * A function that receives an integer and accordingly updates
         * what the average engine life is and does not return anything
         */
        this.engineLife = engineLife;
    }

    public int getEngineLife() {
        /**
         * A function that receives nothing and returns what the average engine life
         * of the vehicle is
         */
        return engineLife;
    }

    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return "Jeep: " + super.toString() + ", " + "\nAverage fuel consumption: " + getFuelConsumption()
                + ", " + "\nAverage life of the engine: " + getEngineLife() + ", " + "\nLicense type: " + getLicenseType() + "\n";
    }

    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Jeep))
            return false;
        Jeep jeep = (Jeep) obj;
        if (super.equals(obj))
        {
            if (getLicenseType().equals(jeep.getLicenseType()))
            {
                return jeep.getFuelConsumption() == getFuelConsumption() && jeep.getEngineLife() == getEngineLife();
            }
        }
        return false;
    }

}


