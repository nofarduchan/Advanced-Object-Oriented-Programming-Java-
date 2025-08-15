package vehicle;

public class Bicycle extends Land implements NonMotorized{
    private String powerSource;
    private char energyScore;
    public Bicycle(String model, int maxSpeed, int numPass, String wayType) {
        /**
         * Constructor of the Bicycle class inheriting from Land class
         */
        super(model, maxSpeed, numPass, 2, wayType);
        this.powerSource = "Manual";
        this.energyScore = 'A';
    }
    public void setPowerSource(String powerSource) {
        /**
         * A function that receives a string and accordingly updates
         * what the power source is and does not return anything
         */
        this.powerSource = powerSource; }
    public String getPowerSource() {
        /**
         * A function that receives nothing and returns what the power source
         * of the vehicle is
         */
        return  powerSource; }
    public void setEnergyScore(char energyScore) {
        /**
         * A function that receives a string and accordingly updates
         * what the energy score is and does not return anything
         */
        this.energyScore = energyScore; }
    public char getEnergyScore() {
        /**
         * A function that receives nothing and returns what the energy score
         * of the vehicle is
         */
        return energyScore; }

    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return "Bicycle: " + super.toString() + ", " + "\nPower source: "
                + getPowerSource() + ", " + "\nEnergy score: " + getEnergyScore() + "\n";
    }

    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Bicycle))
            return false;
        Bicycle bicycle = (Bicycle) obj;
        if (super.equals(obj)) {
            if (getPowerSource().equals(bicycle.getPowerSource())){
                return bicycle.getEnergyScore() == getEnergyScore();
            }
        }
        return false;
    }

}
