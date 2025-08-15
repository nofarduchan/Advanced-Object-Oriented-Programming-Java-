package Graphic;

import vehicle.*;

import javax.swing.*;

public class Factory_Marine implements AbstractFactory{
    @Override
    public Vehicle getVehicle(String vehicleType, String model, int speed, int numPass, int numWheels, String flag,
                              int fuelConsumption, int engineLife, boolean sailingDirection, String wayType,
                              String powerSource, ImageIcon imageIcon) {
        if(vehicleType.equals("Frigate"))
        {
            return new Frigate(model, speed, numPass, sailingDirection, imageIcon);
        }
        if(vehicleType.equals("Amphibious"))
        {
            return new Amphibious(model, speed, numPass, numWheels,sailingDirection, flag, fuelConsumption, engineLife, imageIcon);
        }
        if(vehicleType.equals("Cruise_Ship"))
        {
            return new Cruise_Ship(model, speed, numPass, flag, fuelConsumption, engineLife, imageIcon);
        }
        if (vehicleType.equals("Hybrid_Plane"))
        {
            return new Hybrid_Plane(model, speed, numPass, numWheels,sailingDirection, flag, fuelConsumption, engineLife, imageIcon);
        }
        return null;
    }
}
