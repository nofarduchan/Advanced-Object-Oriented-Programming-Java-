package Graphic;

import vehicle.Vehicle;

import javax.swing.*;

public interface AbstractFactory {
    Vehicle getVehicle (String vehicleType, String model, int speed, int numPass, int numWheels, String flag,
                        int fuelConsumption, int engineLife, boolean sailingDirection, String wayType,
                        String powerSource, ImageIcon imageIcon);
}
