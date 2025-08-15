package Graphic;

import vehicle.Game_Glider;
import vehicle.Hybrid_Plane;
import vehicle.Spy_Glider;
import vehicle.Vehicle;

import javax.swing.*;

public class Factory_Air implements AbstractFactory{
    @Override
    public Vehicle getVehicle(String vehicleType, String model, int speed, int numPass, int numWheels, String flag,
                              int fuelConsumption, int engineLife, boolean sailingDirection, String wayType,
                              String powerSource, ImageIcon imageIcon) {
        if(vehicleType.equals("Spy_Glider"))
        {
            return new Spy_Glider(powerSource, imageIcon);
        }
        if(vehicleType.equals("Game_Glider"))
        {
            return new Game_Glider(imageIcon);
        }
        if (vehicleType.equals("Hybrid_Plane"))
        {
            return new Hybrid_Plane(model, speed, numPass, numWheels,sailingDirection, flag, fuelConsumption, engineLife, imageIcon);
        }

        return null;
    }
}
