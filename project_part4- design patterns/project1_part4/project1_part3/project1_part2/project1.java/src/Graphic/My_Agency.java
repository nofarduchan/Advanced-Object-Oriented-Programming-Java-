package Graphic;
/**
 * yenkel jauie 324523075
 * nofar duchan 322599424
 */

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class My_Agency {

    protected Vehicle vehicle;
    protected static ImageIcon vehicle_image;
    protected ImageIcon image_choice;
    protected static JFrame frameInventor;
    protected static JFrame frameMenu;
    protected static JFrame frame;
    private boolean sign = false;
    private static int arrTest[] = new int[3];
    protected Vector<Vehicle> vecInProgress = new Vector<Vehicle>();
    protected static Vector<JButton>  button = new Vector<JButton>();
    protected static ExecutorService executor = Executors.newFixedThreadPool(7);
    protected static Vector<Vehicle> arr = new Vector<Vehicle>();

    public My_Agency() {
    }
    public void Building()
    {
        /**
         * A function that receives an array of vehicles and an array of the images that represent them
         * and builds a menu of buttons that displays the vehicles that can be added to the dealership.
         */
        frame = new JFrame("Car Agency");
        GridLayout myGridLayout = new GridLayout(3, 1);
        frame.setLayout(myGridLayout);

        JButton button_Land = new JButton(("Land"));
        JButton button_Air = new JButton(("Air"));
        JButton button_Marine = new JButton(("Marine"));

        frame.add(button_Land);
        frame.add(button_Air);
        frame.add(button_Marine);

        button_Land.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory vehicleType = FactoryProducer.getType("Land");
                JFrame newFrame = new JFrame("Land Vehicles");
                GridLayout myGridLayout = new GridLayout(5, 1);
                newFrame.setLayout(myGridLayout);

                JButton button_Jeep = new JButton(("Jeep"));
                JButton button_Amphibious = new JButton(("Amphibious"));
                JButton button_Bicycle = new JButton(("Regular bicycle"));
                JButton button_ElectricBicycle = new JButton(("Electric bicycle"));
                JButton button_HybridPlane = new JButton(("Hybrid Plane"));

                newFrame.add(button_Jeep);
                newFrame.add(button_Amphibious);
                newFrame.add(button_Bicycle);
                newFrame.add(button_ElectricBicycle);
                newFrame.add(button_HybridPlane);

                button_Jeep.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Jeep_Agency obj = new Jeep_Agency();
                        obj.Build_jeep(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });
                button_Amphibious.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Amphibious_Agency obj = new Amphibious_Agency();
                        obj.Build_Amphibious(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_Bicycle.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Regular_Bicycle_Agency obj = new Regular_Bicycle_Agency();
                        obj.Build_Bicycle(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_ElectricBicycle.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Electric_Bicycle_Agency obj = new Electric_Bicycle_Agency();
                        obj.Build_Bicycle(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_HybridPlane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Hybrid_Plane_Agency obj = new Hybrid_Plane_Agency();
                        obj.Build_HybridPlane(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                newFrame.setSize(screenSize.width, screenSize.height);

                newFrame.pack();
                newFrame.setSize(200, 300);
                newFrame.setLocationRelativeTo(null);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
            }
        });

        button_Air.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory vehicleType = FactoryProducer.getType("Air");
                JFrame newFrame = new JFrame("Air Vehicles");
                GridLayout myGridLayout = new GridLayout(3, 1);
                newFrame.setLayout(myGridLayout);

                JButton button_SpyGlider = new JButton(("Spy Glider"));
                JButton button_GameGlider = new JButton(("Game Glider"));
                JButton button_HybridPlane = new JButton(("Hybrid Plane"));

                newFrame.add(button_SpyGlider);
                newFrame.add(button_GameGlider);
                newFrame.add(button_HybridPlane);

                button_SpyGlider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SpyGlider_Agency obj = new SpyGlider_Agency();
                        obj.Build_SpyGlider(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_GameGlider.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameGlider_Agency obj = new GameGlider_Agency();
                        obj.Build_GameGlider(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_HybridPlane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Hybrid_Plane_Agency obj = new Hybrid_Plane_Agency();
                        obj.Build_HybridPlane(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                newFrame.pack();
                newFrame.setSize(200, 300);
                newFrame.setLocationRelativeTo(null);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
            }
        });

        button_Marine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFactory vehicleType = FactoryProducer.getType("Marine");
                JFrame newFrame = new JFrame("Marine Vehicles");
                GridLayout myGridLayout = new GridLayout(4, 1);
                newFrame.setLayout(myGridLayout);

                JButton button_Frigate = new JButton(("Frigate"));
                JButton button_Amphibious = new JButton(("Amphibious"));
                JButton button_CruiseShip = new JButton(("Cruise Ship"));
                JButton button_HybridPlane = new JButton(("Hybrid Plane"));

                newFrame.add(button_Frigate);
                newFrame.add(button_Amphibious);
                newFrame.add(button_CruiseShip);
                newFrame.add(button_HybridPlane);

                button_Frigate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Frigate_Agency obj = new Frigate_Agency();
                        obj.Build_Frigate(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_Amphibious.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Amphibious_Agency obj = new Amphibious_Agency();
                        obj.Build_Amphibious(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_CruiseShip.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CruiseShip_Agency obj = new CruiseShip_Agency();
                        obj.Build_CruiseShip(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                button_HybridPlane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Hybrid_Plane_Agency obj = new Hybrid_Plane_Agency();
                        obj.Build_HybridPlane(arr, frame, vehicleType);
                        newFrame.dispose();
                    }
                });

                newFrame.pack();
                newFrame.setSize(200, 300);
                newFrame.setLocationRelativeTo(null);
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setVisible(true);
            }
        });

        frame.pack();
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    protected static void addNewCar(Vector<Vehicle> arr, JFrame frame, JFrame frame1) {
        if (frameInventor != null) {
            if (frameInventor.isVisible()) {
                Inventor inventor = new Inventor();
                inventor.showInventor(arr, frame);
                frameInventor.setVisible(true);
            }
        }

        JFrame frameWaiting = new JFrame();
        frameWaiting.setLayout(new BorderLayout());
        JPanel panelWaiting = new JPanel();
        JLabel labelWaiting = new JLabel("Updating database...Please wait");
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
                    Thread.sleep((long) (Math.random() * (8000 - 3000 + 1) + 3000));
                    frameWaiting.dispose();
                    frame1.setVisible(false);
                } catch (InterruptedException a) {
                    a.printStackTrace();
                }
            }
        });
        waitThread.start();
    }

    protected void clearFrame(JFrame frameC) {
        /**
         * A function that clears the frame it received as a parameter
         */
        Component[] components = frameC.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                frameC.remove(component);
            }
        }
        frameC.revalidate();
    }

    protected void add_image(JButton button_add) {
        /**
         * A function that accepts a button and adds an image
         * to the button that the user chooses himself
         */
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image image3 = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon smallImage3 = new ImageIcon(image3);
        button_add.setIcon(smallImage3);
        image_choice = smallImage3;
    }

    protected static void error_message(JFrame frame1) {
        /**
         * A function that receives the frame that is open
         * with the user and closes it and opens an error message accordingly.
         */
        JFrame frame2 = new JFrame();
        JOptionPane.showMessageDialog(frame2, "You missed a field / Incorrect input",
                "WARNING", JOptionPane.WARNING_MESSAGE);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setVisible(true);
        frame2.dispose();
    }

    protected static ImageIcon small_image_button(JPanel panel, JButton button, ImageIcon image) {
        /**
         * A function that receives an image, a button and a panel and returns an image smaller than the original.
         * Add the small image to the button and the button to the panel.
         */
        Image image1 = image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon smallImage1 = new ImageIcon(image1);
        button.setIcon(smallImage1);
        panel.add(button);
        return smallImage1;
    }

}
