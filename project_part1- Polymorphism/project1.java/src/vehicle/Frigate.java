package vehicle;

public class Frigate extends Marine implements Motorized{
    private int fuelConsumption;
    private int engineLife;
    public Frigate(String model, int maxSpeed, int numPass, boolean sailingDirection) {
        /**
         * Constructor of the Frigate class inheriting from Marine class
         */
        super(model, 0, maxSpeed, numPass, sailingDirection, "Israel");
        this.fuelConsumption = 500;
        this.engineLife = 4;
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
        return  fuelConsumption; }
    public void setEngineLife(int engineLife) {
        /**
         * A function that receives an integer and accordingly updates
         * what the average engine life is and does not return anything
         */
        this.engineLife = engineLife; }
    public int getEngineLife() {
        /**
         * A function that receives nothing and returns what the average engine life
         * of the vehicle is
         */
        return engineLife; }

    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return "Frigate: " + super.toString() + "\nAverage fuel consumption: " + getFuelConsumption()
                + "\nAverage life of the engine: " + getEngineLife();
    }
    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Frigate))
            return false;
        Frigate frigate = (Frigate) obj;
        if (super.equals(obj))
        {
            return frigate.getFuelConsumption() == getFuelConsumption()
                    && frigate.getEngineLife() == getEngineLife();
        }
        return false;
    }
}
