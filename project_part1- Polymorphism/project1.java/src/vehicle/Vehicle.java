package vehicle;

public abstract class Vehicle {
    private String model;
    private int distance;
    private int maxSpeed;
    private int numPass;
    public Vehicle(String model, int distance, int maxSpeed, int numPass)
    {
        this.model = model;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
        this.numPass = numPass;
    }
    public String getModel() {
        /**
         * A function that receives nothing and returns what the model of the vehicle is
         */
        return model; }
    public int getDistance() {
        /**
         * A function that receives nothing and returns what the distance of the vehicle is
         */
        return distance; }
    public int getMaxSpeed() {
        return maxSpeed; }
    public int getNumPass() {
        /**
         * A function that receives nothing and returns what the max number of passengers of the vehicle is
         */
        return numPass; }
    public void setDistanceMove (int distance) {
        /**
         * A function that receives an integer and accordingly updates
         * the distance of the vehicle and does not return anything
         */
        this.distance+= distance; }
    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return "\nModel: " + getModel() + "\nTraveled: " + getDistance() + "\nMax speed: " + getMaxSpeed()
                + "\nMax number of passengers: " + getNumPass();
    }
    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Vehicle))
            return false;
        Vehicle vehicle = (Vehicle) obj;
        if (getModel().equals(vehicle.getModel()))
        {
            return vehicle.getDistance() == getDistance() && vehicle.getMaxSpeed() == getMaxSpeed()
                    && vehicle.getNumPass() == getNumPass();
        }
        else
            return false;
    }

}
