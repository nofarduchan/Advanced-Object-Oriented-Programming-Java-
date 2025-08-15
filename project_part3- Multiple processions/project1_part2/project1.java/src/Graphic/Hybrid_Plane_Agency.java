package Graphic;

import vehicle.Hybrid_Plane;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Hybrid_Plane_Agency extends My_Agency{
    private boolean sailingDirection;
    public Hybrid_Plane_Agency () {}
    public void Build_HybridPlane(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, JFrame frame) {
        /**
         * A function that receives the array of vehicles and the array of images representing them,
         * and builds the vehicles using inputs from the user
         */
        JFrame frame1 = new JFrame("Data entry - Hybrid Plane");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel0 = new JPanel(new GridLayout(1, 2));
        JPanel panel1 = new JPanel(new GridLayout(8,2));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 2));

        JButton button_HybridPlane1 = new JButton();
        ImageIcon image_HybridPlane1 = new ImageIcon(this.getClass().getResource("image_hybridplane1.jpg"));
        ImageIcon smallImage1 = small_image_button(panel0, button_HybridPlane1, image_HybridPlane1);

        JButton button_HybridPlane2 = new JButton();
        ImageIcon image_HybridPlane2 = new ImageIcon(this.getClass().getResource("image_hybridplane2.jpg"));
        ImageIcon smallImage2 = small_image_button(panel0, button_HybridPlane2, image_HybridPlane2);

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

        JLabel newNumWheels = new JLabel(" wheels' num: ");
        JTextField inNumWheels = new JTextField();
        panel1.add(newNumWheels);
        panel1.add(inNumWheels);

        JLabel newFlag = new JLabel(" flag: ");
        JTextField inFlag = new JTextField();
        panel1.add(newFlag);
        panel1.add(inFlag);

        JLabel newFuelConsumption = new JLabel(" fuel consumption: ");
        JTextField inFuelConsumption = new JTextField();
        panel1.add(newFuelConsumption);
        panel1.add(inFuelConsumption);

        JLabel newEngineLife = new JLabel(" engine life: ");
        JTextField inEngineLife = new JTextField();
        panel1.add(newEngineLife);
        panel1.add(inEngineLife);

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
                Enter_details(arr, imageArr, frame1, inModel, inSpeed, inNumPass, inNumWheels, inFlag,
                        inFuelConsumption, inEngineLife, button_yes, button_no);
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
                if(Enter_details(arr, imageArr, frame1, inModel, inSpeed, inNumPass, inNumWheels, inFlag,
                        inFuelConsumption, inEngineLife, button_yes, button_no))
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
        panel3.add(button_next);

        button_HybridPlane1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                image_choice = smallImage1;
            }
        });
        button_HybridPlane2.addActionListener(new ActionListener() {
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
                                 JTextField inNumPass, JTextField inNumWheels, JTextField inFlag,
                                 JTextField inFuelConsumption, JTextField inEngineLife,
                                 JRadioButton yes, JRadioButton no)
    {
        /**
         * A function that receives the inputs that the user entered to build vehicles and the two arrays
         * and returns with a boolean value if the construction was done and the vehicle and its image entered
         * the arrays
         */
        if(inModel.getText().isEmpty() || inFuelConsumption.getText().isEmpty()
                || inSpeed.getText().isEmpty() || inNumPass.getText().isEmpty()
                || inNumWheels.getText().isEmpty()|| inFlag.getText().isEmpty()
                || inEngineLife.getText().isEmpty()
                || image_choice == null|| (!yes.isSelected() && !no.isSelected()))
        {
            error_message(frame1);
            return false;
        }

        String model = inModel.getText();
        try {
            int speed = Integer.parseInt(inSpeed.getText());
            int numPass = Integer.parseInt(inNumPass.getText());
            int numWheels = Integer.parseInt(inNumWheels.getText());
            String flag = inFlag.getText();
            int fuelConsumption = Integer.parseInt(inFuelConsumption.getText());
            int engineLife = Integer.parseInt(inEngineLife.getText());
            arr.add(new Hybrid_Plane(model, speed , numPass, numWheels,
                    sailingDirection, flag, fuelConsumption, engineLife));
            imageArr.add(image_choice);
            frame1.dispose();

        } catch (NumberFormatException e) {
            error_message(frame1);
            return false;
        }
        return true;
    }
}
