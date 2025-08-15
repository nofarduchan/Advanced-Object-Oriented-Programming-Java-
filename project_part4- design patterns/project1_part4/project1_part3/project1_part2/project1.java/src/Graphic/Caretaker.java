package Graphic;

import java.util.Stack;
import java.util.Vector;

public class Caretaker extends My_Agency {
    private Vector<Memento> vector = new Vector<>();

    public Vector<Memento> getVector() {
        return vector;
    }
    public void addMemento (Memento newMemento)
    {
        if(vector.size() == 3)
        {
            vector.set(0, vector.get(1));
            vector.set(1, vector.get(2));
            vector.set(2, newMemento);
        }
        else
            vector.add(newMemento);
    }
    public Memento getMemento ()
    {
        if(vector.size() == 3)
        {
            Memento memento = vector.get(2);
            vector.remove(2);
            return memento;
        }
        else if (vector.size() == 2) {
            Memento memento = vector.get(1);
            vector.remove(1);
            return memento;
        }
        else if (vector.size() == 1) {
            Memento memento = vector.get(0);
            vector.remove(0);
            return memento;
        }
        else
            return null;
    }
}
