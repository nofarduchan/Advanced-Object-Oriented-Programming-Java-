package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.util.Vector;

public class Memento extends My_Agency {
    private Vector<Vehicle> memento_arr;
    public Memento(Vector<Vehicle> memento_arr)
    {
        this.memento_arr = clone_arr(memento_arr);
    }
    public Vector<Vehicle> getMemento_arr()
    {
        return memento_arr;
    }
    public Vector<Vehicle> clone_arr(Vector<Vehicle> memento_arr)
    {
        this.memento_arr = new Vector<>();
        this.memento_arr.addAll(memento_arr);
        return this.memento_arr;
    }
}

