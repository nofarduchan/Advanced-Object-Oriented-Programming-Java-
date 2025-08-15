package vehicle;

import javax.swing.*;

public class Amphibious extends Vehicle implements IsLand, IsMarine, Motorized, Vehicles_Interface{
    private Land land;
    private Marine marine;
    private int fuelConsumption;
    private int engineLife;

    public Amphibious(String model, int maxSpeed, int numPass, int numWheels, boolean sailingDirection,
                      String flag, int fuelConsumption, int engineLife, ImageIcon im) {
        /**
         * Constructor of the Amphibious class inheriting from Land and Marine classes
         * I used a delegation.
         */
        super(model , maxSpeed, numPass);
        land = new Land(model, maxSpeed, numPass, numWheels, "Paved road");
        marine = new Marine(model , maxSpeed, numPass, sailingDirection, flag);
        this.fuelConsumption = fuelConsumption;
        this.engineLife = engineLife;
        this.image=im;
    }

    public int getNumWheels() {
        /**
         * A function that receives nothing and returns what the number of wheels (integer)
         * of the vehicle is
         */
        return land.getNumWheels();
    }
    public String getWayType() {
        /**
         * A function that receives nothing and returns what the way type (string)
         * of the vehicle is
         */
        return land.getWayType();
    }
    public void setSailingDirection (boolean sailingDirection) {
        /**
         * A function that receives a boolean value and accordingly updates
         * if the sailing with wind direction or not and does not return anything
         */
        marine.setSailingDirection(sailingDirection);
    }
    public boolean getSailingDirection() {
        /**
         * A function that receives nothing and returns if the sailing with wind direction or not
         */
        return marine.getSailingDirection(); }
    public void setFlag(String flag) {
        /**
         * A function that receives a string and accordingly updates
         * what the flag is and does not return anything
         */
        marine.setFlag(flag); }
    public String getFlag() {
        /**
         * A function that receives nothing and returns what the flag of the vehicle is
         */
        return marine.getFlag(); }
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
        if(getSailingDirection())
            return "Amphibious: " + super.toString() + ", " + "\nNum of wheels: " + getNumWheels() + ", " + "\nType of way: "
                    + getWayType() + ", "+ "\nUnder the flag of: " + getFlag() + ", "+ "\nSail with the wind!"
                    + ", "+ "\nAverage fuel consumption: " + getFuelConsumption()
                    + ", "+ "\nAverage life of the engine: " + getEngineLife() + "\n";
        else
            return "Amphibious: " + super.toString() + ", " + "\nNum of wheels: " + getNumWheels() + ", " + "\nType of way: "
                    + getWayType() + ", " + "\nUnder the flag of: " + getFlag() + ", " + "\nDoesn't sail with the wind!"
                    + ", " + "\nAverage fuel consumption: " + getFuelConsumption()+ ", "
                    + "\nAverage life of the engine: " + getEngineLife();

    }

    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Amphibious))
            return false;
        Amphibious amphibious = (Amphibious) obj;
        if (super.equals(obj))
        {
            if (getFlag().equals(amphibious.getFlag()) && getWayType().equals(amphibious.getWayType()))
                return  amphibious.getSailingDirection() == getSailingDirection()
                        && amphibious.getNumWheels() == getNumWheels() && amphibious.getFuelConsumption() == getFuelConsumption()
                        && amphibious.getEngineLife() == getEngineLife();
        }
        return false;
    }
}
