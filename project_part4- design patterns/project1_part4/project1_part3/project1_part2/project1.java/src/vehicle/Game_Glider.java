package vehicle;

import javax.swing.*;

public class Game_Glider extends Air implements NonMotorized, Vehicles_Interface{
    private String powerSource;
    private char energyScore;
    private String use;
    public Game_Glider(ImageIcon im) {
        /**
         * Constructor of the GameGlider class inheriting from Air class
         */
        super("toy", 10, 0, "civil");
        this.powerSource = "manual";
        this.energyScore = 'A';
        this.image=im;
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
        return "Game Glider: " + super.toString() + ", " + "\nPower source: " + getPowerSource()
                + ", " + "\nEnergy score: " + getEnergyScore() + "\n";
    }
    public boolean equals(Object obj) {
        /**
         * A function that checks if the objects have the same values
         * and returns a boolean value accordingly.
         */
        if (!(obj instanceof Game_Glider))
            return false;
        Game_Glider gameGlider = (Game_Glider) obj;
        if(super.equals(obj))
        {
            if (getPowerSource().equals(gameGlider.getPowerSource()))
                return gameGlider.getEnergyScore() == getEnergyScore();
        }
        return false;
    }
}
