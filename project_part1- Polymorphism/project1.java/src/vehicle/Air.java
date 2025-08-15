package vehicle;

public abstract class Air extends Vehicle {
    private String use;
    public Air(String model, int distance, int maxSpeed, int numPass, String use) {
        /**
         * Constructor of the Air class inheriting from Vehicle class
         */
        super(model, distance, maxSpeed, numPass);
        this.use = use;
    }
    public void setUse(String use) {
        /**
         * A function that receives a string and accordingly updates
         * what the use of the vehicle is and does not return anything
         */
        this.use = use;
    }
    public String getUse() {
        /**
         * A function that receives nothing and returns what the use of the vehicle is
         */
        return use;
    }
    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return super.toString() + "\nUse: " + getUse();
    }
    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Air))
            return false;
        Air air = (Air) obj;
        if(super.equals(obj))
            return getUse().equals(air.getUse());
       return false;
    }
}
