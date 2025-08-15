package vehicle;

import javax.swing.*;

public class Electric_Bicycle extends All_Bicycle implements Motorized, Vehicles_Interface{
    private int fuelConsumption;
    private int engineLife;
    public Electric_Bicycle(String model, int maxSpeed, int numPass, String wayType, int engineLife, ImageIcon im) {
        super(model, maxSpeed, numPass, wayType);
        this.fuelConsumption = 20;
        this.engineLife = engineLife;
        this.image=im;
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
        return "Electric bicycle: " + super.toString() + ", " + "\nAverage fuel consumption: " + getFuelConsumption()
                + ", " + "\nAverage life of the engine: " + getEngineLife() + "\n";
    }

    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Electric_Bicycle))
            return false;
        Electric_Bicycle electricBicycle = (Electric_Bicycle) obj;
        if (super.equals(obj)) {
            return electricBicycle.getFuelConsumption() == getFuelConsumption()
                    && electricBicycle.getEngineLife() == getEngineLife();
        }
        return false;
    }


}
