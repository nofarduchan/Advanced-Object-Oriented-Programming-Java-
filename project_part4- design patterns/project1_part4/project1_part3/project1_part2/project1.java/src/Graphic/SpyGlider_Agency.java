package Graphic;


import vehicle.Spy_Glider;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SpyGlider_Agency extends My_Agency {
    public SpyGlider_Agency () {}
    public void Build_SpyGlider(Vector<Vehicle> arr, JFrame frame, AbstractFactory vehicleType) {
        /**
         * A function that receives the array of vehicles and the array of images representing them,
         * and builds the vehicles using inputs from the user
         */
        JFrame frame1 = new JFrame("Data entry - Spy Glider");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel0 = new JPanel(new GridLayout(1, 2));
        JPanel panel1 = new JPanel(new GridLayout(3, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 2));

        JButton button_SpyGlider1 = new JButton();
        ImageIcon image_SpyGlider1 = new ImageIcon(this.getClass().getResource("image_spyGlider1.jpg"));
        ImageIcon smallImage1 = small_image_button(panel0, button_SpyGlider1, image_SpyGlider1);

        JButton button_SpyGlider2 = new JButton();
        ImageIcon image_SpyGlider2 = new ImageIcon(this.getClass().getResource("image_spyGlider2.jpg"));
        ImageIcon smallImage2 = small_image_button(panel0, button_SpyGlider2, image_SpyGlider2);

        JButton button_add = new JButton("another picture");
        button_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add_image(button_add);
            }
        });
        panel0.add(button_add);

        JLabel newPowerSource = new JLabel(" power source: ");
        JTextField inPowerSource = new JTextField();
        panel1.add(newPowerSource);
        panel1.add(inPowerSource);

        JButton button_newCar = new JButton(("new car"));
        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enter_details(arr, frame1, inPowerSource, vehicleType);
                if(frameMenu!=null)
                {
                    if (frameMenu.isVisible())
                    {
                        clearFrame(frameMenu);
                        for (int j=0; j<arr.size(); j++)
                        {
                            arr.set(j, new Decorator_color(arr.get(j)).getVehicle1());
                            button.set(j, new JButton(arr.get(j).getImage()));
                        }
                        Singleton_menu singleton_menu = Singleton_menu.getMenu();
                        singleton_menu.Menu();
                    }
                }
                addNewCar(arr, frame, frame1);
            }
        });
        panel3.add(button_newCar);

        JButton button_next = new JButton(("next"));
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Enter_details(arr, frame1, inPowerSource, vehicleType))
                {
                    if (frameMenu!=null)
                    {
                        frameMenu.dispose();
                    }
                    frameMenu = new JFrame("my menu");
                    frameMenu.setLayout(new BoxLayout(frameMenu.getContentPane(), BoxLayout.PAGE_AXIS));
                    Singleton_menu singleton_menu = Singleton_menu.getMenu();
                    singleton_menu.Menu();

                    JFrame frameWaiting= new JFrame();
                    frameWaiting.setLayout(new BorderLayout());
                    JPanel panelWaiting = new JPanel();
                    JLabel labelWaiting= new JLabel("Updating database...Please wait");
                    panelWaiting.add(labelWaiting);
                    frameWaiting.add(panelWaiting);

                    frameWaiting.pack();
                    frameWaiting.setLocationRelativeTo(null);
                    frameWaiting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frameWaiting.setVisible(true);

                    Thread waitThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                                frameWaiting.dispose();
                                clearFrame(frameMenu);
                                for (int j=0; j<arr.size(); j++)
                                {
                                    arr.set(j, new Decorator_color(arr.get(j)).getVehicle1());
                                    button.set(j, new JButton(arr.get(j).getImage()));
                                }
                                Singleton_menu singleton_menu = Singleton_menu.getMenu();
                                singleton_menu.Menu();
                                frame1.setVisible(false);
                                if(frameInventor!=null)
                                {
                                    if(frameInventor.isVisible())
                                    {
                                        Inventor inventor = new Inventor();
                                        inventor.showInventor(arr, frame);
                                        frameInventor.setVisible(true);
                                    }
                                }
                            }
                            catch (InterruptedException a) {
                                a.printStackTrace();
                            }
                        }
                    });
                    waitThread.start();
                }
            }
        });

        button_SpyGlider1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choice = smallImage1;
            }
        });
        button_SpyGlider2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choice = smallImage2;
            }
        });

        panel3.add(button_next);

        frame1.getContentPane().add(panel0);
        frame1.getContentPane().add(panel1);
        frame1.getContentPane().add(panel3);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setSize(screenSize.width, screenSize.height);

        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);
    }
    public boolean Enter_details(Vector<Vehicle> arr,
                                 JFrame frame1, JTextField inPowerSource, AbstractFactory vehicleType)
    {
        /**
         * A function that receives the inputs that the user entered to build vehicles and the two arrays
         * and returns with a boolean value if the construction was done and the vehicle and its image entered
         * the arrays
         */
        if(inPowerSource.getText().isEmpty() || image_choice == null)
        {
            error_message(frame1);
            return false;
        }

        String powerSource = inPowerSource.getText();
        Vehicle Spy_Glider = vehicleType.getVehicle("Spy_Glider", "", 0, 0,
                0, "", 0, 0, false,
                "", powerSource, image_choice);
        arr.add(Spy_Glider);
        frame1.dispose();
        return true;
    }
}
