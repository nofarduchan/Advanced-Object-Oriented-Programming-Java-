package vehicle;

public abstract class All_Bicycle extends Land {
    public All_Bicycle(String model, int maxSpeed, int numPass, String wayType) {
        /**
         * Constructor of the Bicycle class inheriting from Land class
         */
        super(model, maxSpeed, numPass, 2, wayType);
    }
    public String toString() {
        /**
         * A function that returns the value given to it in string format.
         * Therefore, any object that this method is applied to will be returned as a string object.
         */
        return super.toString();
    }

    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof All_Bicycle))
            return false;
        All_Bicycle bicycle = (All_Bicycle) obj;
        return super.equals(obj);
    }
}
