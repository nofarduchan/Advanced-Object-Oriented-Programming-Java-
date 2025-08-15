package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.util.Vector;

public class Originator extends My_Agency {
    private Vector<Vehicle> memento_arr;
    public void setMemento_arr(Vector<Vehicle> memento_arr)
    {
        this.memento_arr = memento_arr;
    }
    public Vector<Vehicle> getMemento_arr(){ return memento_arr; }
    public Memento createMemento() { return new Memento(memento_arr);}
    public void setMemento(Memento memento)
    {
        memento_arr = memento.getMemento_arr();
    }
}
