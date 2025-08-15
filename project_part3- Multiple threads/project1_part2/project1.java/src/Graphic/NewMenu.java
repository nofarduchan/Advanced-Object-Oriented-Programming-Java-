package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.util.Vector;


public class NewMenu extends My_Agency{
    public NewMenu() {}
    public void showMenu(Vector< Vehicle > arr, Vector< ImageIcon > imageArr, JFrame frame)
    {
        if(frameMenu!= null)
            clearFrame(frameMenu);
        Menu(arr, imageArr, frame);
    }

}
