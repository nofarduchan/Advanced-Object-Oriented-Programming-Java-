package vehicle;

public abstract class Marine extends Vehicle{
    private boolean sailingDirection;
    private String flag;
    public Marine(String model, int distance, int maxSpeed, int numPass, boolean sailingDirection, String flag) {
        /**
         * Constructor of the Marine class inheriting from Vehicle class
         */
        super(model, distance, maxSpeed, numPass);
        this.sailingDirection = sailingDirection;
        this.flag = flag;

    }
    public void setSailingDirection (boolean sailingDirection) {
        /**
         * A function that receives a boolean value and accordingly updates
         * if the sailing with wind direction or not and does not return anything
         */
        this.sailingDirection = sailingDirection;
    }
    public boolean getSailingDirection() {
        /**
         * A function that receives nothing and returns if the sailing with wind direction or not
         */
        return sailingDirection; }
    public void setFlag(String flag) {
        /**
         * A function that receives a string and accordingly updates
         * what the flag is and does not return anything
         */
        this.flag= flag; }
    public String getFlag() {
        /**
         * A function that receives nothing and returns what the flag of the vehicle is
         */
        return flag; }
    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        if(getSailingDirection())
            return super.toString() + "\nUnder the flag of: " + getFlag() + "\nSail with the wind!";
        else
            return super.toString() + "\nUnder the flag of: " + getFlag() + "\nDoesn't sail with the wind!";
    }
    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Marine))
            return false;
        Marine marine = (Marine) obj;
        if (super.equals(obj))
        {
            if (getFlag().equals(marine.getFlag()))
                return  marine.getSailingDirection() == getSailingDirection();
        }
        return false;
    }
}
