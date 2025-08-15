package Graphic;

import vehicle.Vehicle;

import java.awt.*;

public class Decorator extends Vehicle {
    protected Vehicle vehicle2;

    public Decorator(Vehicle decoratoeVehicle) {
        super("1", 1, 1);
        this.vehicle2 = decoratoeVehicle;
    }
}
