package Graphic;

import vehicle.*;

import javax.swing.*;

public class Factory_Land implements AbstractFactory{
    @Override
    public Vehicle getVehicle(String vehicleType, String model, int speed, int numPass, int numWheels, String flag,
                              int fuelConsumption, int engineLife, boolean sailingDirection, String wayType,
                              String powerSource, ImageIcon imageIcon) {
        if(vehicleType.equals("Jeep"))
        {
            return new Jeep(model, speed, fuelConsumption, engineLife, imageIcon);
        }
        if(vehicleType.equals("Amphibious"))
        {
            return new Amphibious(model, speed, numPass, numWheels,sailingDirection, flag, fuelConsumption, engineLife, imageIcon);
        }
        if(vehicleType.equals("Regular_Bicycle"))
        {
            return new Regular_Bicycle(model, speed, numPass, wayType, imageIcon);
        }
        if (vehicleType.equals("Hybrid_Plane"))
        {
            return new Hybrid_Plane(model, speed, numPass, numWheels,sailingDirection, flag, fuelConsumption, engineLife, imageIcon);
        }
        if(vehicleType.equals("Electric_Bicycle"))
        {
            return new Electric_Bicycle(model, speed, numPass, wayType, engineLife, imageIcon);
        }
        return null;
    }
}
