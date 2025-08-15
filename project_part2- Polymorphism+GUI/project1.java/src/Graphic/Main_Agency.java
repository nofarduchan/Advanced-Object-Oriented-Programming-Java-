/**
 * Nofar Duchan 322599424
 */

package Graphic;
import vehicle.*;

import java.util.ArrayList;
import javax.swing.*;
public class Main_Agency {
    public static void main(String[] args) {
        My_Agency agency = new My_Agency();
        ArrayList<Vehicle> arr = new ArrayList<Vehicle>();
        ArrayList<ImageIcon> imageArr = new ArrayList<ImageIcon>();
        agency.Building(arr, imageArr);
    }
}
