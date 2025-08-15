package Graphic;

import vehicle.Jeep;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Jeep_Agency extends My_Agency {
    public Jeep_Agency () {};
    public void Build_jeep(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr) {
        /**
         * A function that receives the array of vehicles and the array of images representing them,
         * and builds the vehicles using inputs from the user
         */
        JFrame frame1 = new JFrame("Data entry - jeep");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel0 = new JPanel(new GridLayout(1, 2));
        JPanel panel1 = new JPanel(new GridLayout(8,2));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));

        JButton button_jeep1 = new JButton();
        ImageIcon image_jeep1 = new ImageIcon(this.getClass().getResource("image_jeep1.jpg"));
        ImageIcon smallImage1 = small_image_button(panel0, button_jeep1, image_jeep1);

        JButton button_jeep2 = new JButton();
        ImageIcon image_jeep2 = new ImageIcon(this.getClass().getResource("image_jeep2.jpg"));
        ImageIcon smallImage2 = small_image_button(panel0, button_jeep2, image_jeep2);

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

        JLabel newSpeed = new JLabel(" speed: ");
        JTextField inSpeed = new JTextField();
        panel1.add(newSpeed);
        panel1.add(inSpeed);

        JLabel newFuelConsumption = new JLabel(" fuel consumption: ");
        JTextField inFuelConsumption = new JTextField();
        panel1.add(newFuelConsumption);
        panel1.add(inFuelConsumption);

        JLabel newEngineLife = new JLabel(" engine life: ");
        JTextField inEngineLife = new JTextField();
        panel1.add(newEngineLife);
        panel1.add(inEngineLife);

        JButton button_newCar = new JButton(("new car"));
        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enter_details(arr, imageArr, frame1, inModel, inSpeed, inFuelConsumption, inEngineLife);
                Building(arr, imageArr);
            }
        });

        panel2.add(button_newCar);
        JButton button_next = new JButton(("next"));
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Enter_details(arr, imageArr, frame1, inModel, inSpeed, inFuelConsumption, inEngineLife))
                    Menu(arr, imageArr);
                else
                    Building(arr, imageArr);
            }
        });
        panel2.add(button_next);

        button_jeep1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choise = smallImage1;
            }
        });
        button_jeep2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choise = smallImage2;
            }
        });

        frame1.getContentPane().add(panel0);
        frame1.getContentPane().add(panel1);
        frame1.getContentPane().add(panel2);

        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    public boolean Enter_details(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr,
                              JFrame frame1, JTextField inModel, JTextField inSpeed,
                                 JTextField inFuelConsumption, JTextField inEngineLife)
    {
        /**
         * A function that receives the inputs that the user entered to build vehicles and the two arrays
         * and returns with a boolean value if the construction was done and the vehicle and its image entered
         * the arrays
         */
        if(inModel.getText().isEmpty() || inSpeed.getText().isEmpty() || inFuelConsumption.getText().isEmpty()
                || inEngineLife.getText().isEmpty() || image_choise == null)
        {
           error_message(frame1);
            return false;
        }

        try {
            int speed = Integer.parseInt(inSpeed.getText());
            int fuelConsumption = Integer.parseInt(inFuelConsumption.getText());
            int engineLife = Integer.parseInt(inEngineLife.getText());

        } catch (NumberFormatException e) {
            error_message(frame1);
            return false;
        }

        String model = inModel.getText();
        int speed = Integer.parseInt(inSpeed.getText());
        int fuelConsumption = Integer.parseInt(inFuelConsumption.getText());
        int engineLife = Integer.parseInt(inEngineLife.getText());
        arr.add(new Jeep(model, speed, fuelConsumption, engineLife));
        imageArr.add(image_choise);
        frame1.dispose();
        return true;
    }
}



