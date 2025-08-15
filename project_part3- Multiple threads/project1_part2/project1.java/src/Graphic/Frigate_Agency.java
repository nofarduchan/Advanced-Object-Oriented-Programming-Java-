package Graphic;


import vehicle.Frigate;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Frigate_Agency extends My_Agency {
    private boolean sailingDirection;
    public Frigate_Agency () {};
    public void Build_Frigate(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, JFrame frame) {
        /**
         * A function that receives the array of vehicles and the array of images representing them,
         * and builds the vehicles using inputs from the user
         */
        JFrame frame1 = new JFrame("Data entry - Frigate");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel0 = new JPanel(new GridLayout(1, 2));
        JPanel panel1 = new JPanel(new GridLayout(7,2));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 2));

        JButton button_Frigate1 = new JButton();
        ImageIcon image_Frigate1 = new ImageIcon(this.getClass().getResource("image_frigate1.jpg"));
        ImageIcon smallImage1 = small_image_button(panel0, button_Frigate1, image_Frigate1);

        JButton button_Frigate2 = new JButton();
        ImageIcon image_Frigate2 = new ImageIcon(this.getClass().getResource("image_frigate2.jpg"));
        ImageIcon smallImage2 = small_image_button(panel0, button_Frigate2, image_Frigate2);

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

        JLabel inSailingDirection = new JLabel(" sail with the wind?: ");
        JRadioButton button_yes = new JRadioButton("yes");
        JRadioButton button_no = new JRadioButton("no");
        panel1.add(inSailingDirection);
        panel2.add(button_yes);
        panel2.add(button_no);

        JButton button_newCar = new JButton(("new car"));
        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enter_details(arr, imageArr, frame1, inModel, inSpeed, inNumPass, button_yes, button_no);
                if(frameMenu!=null)
                {
                    if (frameMenu.isVisible())
                    {
                        clearFrame(frameMenu);
                        Menu(arr, imageArr, frame);
                    }
                }
                addNewCar(arr, imageArr, frame, frame1);
            }
        });
        panel3.add(button_newCar);

        JButton button_next = new JButton(("next"));
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Enter_details(arr, imageArr, frame1, inModel, inSpeed, inNumPass, button_yes, button_no))
                {
                    if (frameMenu!=null)
                    {
                        frameMenu.dispose();
                    }
                    frameMenu = new JFrame("my menu");
                    frameMenu.setLayout(new BoxLayout(frameMenu.getContentPane(), BoxLayout.PAGE_AXIS));
                    Menu(arr, imageArr, frame);

                    JFrame frameWaiting= new JFrame();
                    frameWaiting.setLayout(new BorderLayout());
                    JPanel panelWaiting = new JPanel();
                    JLabel labelWaiting= new JLabel("Updating database...Please wait");
                    panelWaiting.add(labelWaiting);
                    frameWaiting.add(panelWaiting);

                    frameWaiting.pack();
                    frameWaiting.setLocationRelativeTo(null);
                    frameWaiting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameWaiting.setVisible(true);

                    Thread waitThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                                frameWaiting.dispose();
                                clearFrame(frameMenu);
                                Menu(arr, imageArr, frame);
                                frame1.setVisible(false);
                                if(frameInventor!=null)
                                {
                                    if(frameInventor.isVisible())
                                    {
                                        Inventor inventor = new Inventor();
                                        inventor.showInventor(arr, imageArr, frame);
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

        button_Frigate1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choice = smallImage1;
            }
        });
        button_Frigate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choice = smallImage2;
            }
        });
        button_yes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sailingDirection = true;
            }
        });
        button_no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sailingDirection = false;
            }
        });

        panel3.add(button_next);

        frame1.getContentPane().add(panel0);
        frame1.getContentPane().add(panel1);
        frame1.getContentPane().add(panel2);
        frame1.getContentPane().add(panel3);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setSize(screenSize.width, screenSize.height);

        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);
    }
    public boolean Enter_details(Vector<Vehicle> arr, Vector<ImageIcon> imageArr,
                                 JFrame frame1, JTextField inModel, JTextField inSpeed,
                                 JTextField inNumPass, JRadioButton yes, JRadioButton no)
    {
        /**
         * A function that receives the inputs that the user entered to build vehicles and the two arrays
         * and returns with a boolean value if the construction was done and the vehicle and its image entered
         * the arrays
         */
        if(inModel.getText().isEmpty()
                || inSpeed.getText().isEmpty() || inNumPass.getText().isEmpty()
                || image_choice == null || (!yes.isSelected() && !no.isSelected()))
        {
            error_message(frame1);
            return false;
        }

        try {
            String model = inModel.getText();
            int speed = Integer.parseInt(inSpeed.getText());
            int numPass = Integer.parseInt(inNumPass.getText());
            arr.add(new Frigate(model, speed , numPass, sailingDirection));
            imageArr.add(image_choice);
            frame1.dispose();

        } catch (NumberFormatException e) {
            error_message(frame1);
            return false;
        }

        return true;
    }
}
