package vehicle;

public class Land extends Vehicle {
    private int numWheels;
    private String wayType;
    public Land(String model, int maxSpeed, int numPass, int numWheels, String wayType) {
        /**
         * Constructor of the Land class inheriting from Vehicle class
         */
        super(model, maxSpeed, numPass);
        this.numWheels = numWheels;
        this.wayType = wayType;
    }
    public int getNumWheels() {
        /**
         * A function that receives nothing and returns what the number of wheels (integer)
         * of the vehicle is
         */
        return numWheels; }
    public String getWayType() {
        /**
         * A function that receives nothing and returns what the way type (string)
         * of the vehicle is
         */
        return wayType; }
    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return super.toString() + ", " + "\nNum of wheels: " + getNumWheels() + ", " + "\nType of way: "
                + getWayType();
    }
    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Land))
            return false;
        Land land = (Land) obj;
        if (super.equals(obj)) {
            if (getWayType().equals(land.getWayType())) {
                return land.getNumWheels() == getNumWheels();
            }
        }
        return false;
    }
}
