/**
 * Nofar Duchan 322599424
 */

package Graphic;
import vehicle.*;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
public class Main_Agency {
    public static void main(String[] args) {
        My_Agency agency = new My_Agency();
        Vector<Vehicle> arr = new Vector<Vehicle>();
        Vector<ImageIcon> imageArr = new Vector<ImageIcon>();
        agency.Building(arr, imageArr);
    }
}
