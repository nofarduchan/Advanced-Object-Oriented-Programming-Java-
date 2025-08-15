package Graphic;

import vehicle.GameGlider;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GameGlider_Agency extends My_Agency {
    public GameGlider_Agency () {};
    public void Build_GameGlider(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr) {
        /**
         * A function that receives the array of vehicles and the array of images representing them,
         * and builds the vehicles using inputs from the user
         */
        JFrame frame1 = new JFrame("Data entry - GameGlider");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel0 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 2));

        JButton button_GameGlider1 = new JButton();
        ImageIcon image_GameGlider1 = new ImageIcon(this.getClass().getResource("image_gameGlider1.jpg"));
        ImageIcon smallImage1 = small_image_button(panel0, button_GameGlider1, image_GameGlider1);

        JButton button_GameGlider2 = new JButton();
        ImageIcon image_GameGlider2 = new ImageIcon(this.getClass().getResource("image_gameGlider2.jpg"));
        ImageIcon smallImage2 = small_image_button(panel0, button_GameGlider2, image_GameGlider2);

        JButton button_add = new JButton("another picture");
        button_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add_image(button_add);
            }
        });
        panel0.add(button_add);

        JButton button_newCar = new JButton(("new car"));
        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enter_details(arr, imageArr, frame1);
                Building(arr, imageArr);
            }
        });
        panel3.add(button_newCar);

        JButton button_next = new JButton(("next"));
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Enter_details(arr, imageArr, frame1))
                    Menu(arr, imageArr);
                else
                    Building(arr, imageArr);
            }
        });

        button_GameGlider1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choise = smallImage1;
            }
        });
        button_GameGlider2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choise = smallImage2;
            }
        });

        panel3.add(button_next);

        frame1.getContentPane().add(panel0);
        frame1.getContentPane().add(panel3);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setSize(screenSize.width, screenSize.height);

        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

    }
    public boolean Enter_details(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr,
                              JFrame frame1)
    {
        /**
         * A function that receives the inputs that the user entered to build vehicles and the two arrays
         * and returns with a boolean value if the construction was done and the vehicle and its image entered
         * the arrays
         */
        if(image_choise == null)
        {
            error_message(frame1);
            return false;
        }

        arr.add(new GameGlider());
        imageArr.add(image_choise);
        frame1.dispose();
        return true;
    }
}