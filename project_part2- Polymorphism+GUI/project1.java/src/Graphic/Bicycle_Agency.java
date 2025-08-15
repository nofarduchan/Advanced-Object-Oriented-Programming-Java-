package Graphic;

import vehicle.Bicycle;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Bicycle_Agency extends My_Agency {
    public Bicycle_Agency () {};
    public void Build_Bicycle(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr) {
        /**
         * A function that receives the array of vehicles and the array of images representing them,
         * and builds the vehicles using inputs from the user
         */
        JFrame frame1 = new JFrame("Data entry - Bicycle");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel0 = new JPanel(new GridLayout(1, 2));
        JPanel panel1 = new JPanel(new GridLayout(8,2));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 2));

        JButton button_Bicycle1 = new JButton();
        ImageIcon image_Bicycle1 = new ImageIcon(this.getClass().getResource("image_Bicycle1.jpg"));
        ImageIcon smallImage1 = small_image_button(panel0, button_Bicycle1, image_Bicycle1);

        JButton button_Bicycle2 = new JButton();
        ImageIcon image_Bicycle2 = new ImageIcon(this.getClass().getResource("image_Bicycle2.jpg"));
        ImageIcon smallImage2 = small_image_button(panel0, button_Bicycle2, image_Bicycle2);

        JButton button_add = new JButton("another picture");
        button_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add_image(button_add);
            }
        });
        panel0.add(button_add);

        JLabel newModel = new JLabel(" model: ");
        JTextField inModel = new JTextField();
        panel1.add(newModel);
        panel1.add(inModel);

        JLabel newSpeed = new JLabel(" max speed: ");
        JTextField inSpeed = new JTextField();
        panel1.add(newSpeed);
        panel1.add(inSpeed);

        JLabel newNumPass = new JLabel(" passengers' num: ");
        JTextField inNumPass = new JTextField();
        panel1.add(newNumPass);
        panel1.add(inNumPass);

        JLabel newWayType = new JLabel(" type of way: ");
        JTextField inWayType = new JTextField();
        panel1.add(newWayType);
        panel1.add(inWayType);

        JButton button_newCar = new JButton(("new car"));
        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enter_details(arr, imageArr, frame1, inModel, inSpeed, inNumPass,inWayType);
                Building(arr, imageArr);
            }
        });
        panel3.add(button_newCar);

        JButton button_next = new JButton(("next"));
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Enter_details(arr, imageArr, frame1, inModel, inSpeed, inNumPass,inWayType))
                    Menu(arr, imageArr);
                else
                    Building(arr, imageArr);
            }
        });
        panel3.add(button_next);

        button_Bicycle1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choise = smallImage1;
            }
        });
        button_Bicycle2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choise = smallImage2;
            }
        });

        frame1.getContentPane().add(panel0);
        frame1.getContentPane().add(panel1);
        frame1.getContentPane().add(panel2);
        frame1.getContentPane().add(panel3);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setSize(screenSize.width, screenSize.height);

        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

    }
    public boolean Enter_details(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr,
                              JFrame frame1, JTextField inModel, JTextField inSpeed,
                              JTextField inNumPass,JTextField inWayType)
    {
        /**
         * A function that receives the inputs that the user entered to build vehicles and the two arrays
         * and returns with a boolean value if the construction was done and the vehicle and its image entered
         * the arrays
         */
        if(inModel.getText().isEmpty() || inSpeed.getText().isEmpty()
                || inNumPass.getText().isEmpty() || inWayType.getText().isEmpty()
                || image_choise == null)
        {
            error_message(frame1);
            return false;
        }

        try {
            int speed = Integer.parseInt(inSpeed.getText());
            int numPass = Integer.parseInt(inNumPass.getText());
        }
        catch (NumberFormatException e) {
            error_message(frame1);
            return false;
        }

        String model = inModel.getText();
        int speed = Integer.parseInt(inSpeed.getText());
        int numPass = Integer.parseInt(inNumPass.getText());
        String wayType = inWayType.getText();
        arr.add(new Bicycle(model, speed , numPass,wayType));
        imageArr.add(image_choise);
        frame1.dispose();
        return true;
    }
}
