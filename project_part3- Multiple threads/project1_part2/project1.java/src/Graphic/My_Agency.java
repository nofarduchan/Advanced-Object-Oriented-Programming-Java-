package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;

public class My_Agency {

    private Vehicle vehicle;
    private ImageIcon vehicle_image;
    protected ImageIcon image_choice;
    protected static JFrame frameInventor;
    protected static JFrame frameMenu;
    private boolean sign = false;
    private static int arrTest[] = new int[3];
    private Vector<Vehicle> vecInProgress = new Vector<Vehicle>();
    private Vector<JButton>  button = new Vector<JButton>();


    public My_Agency() {
    }

    public void Building(Vector<Vehicle> arr, Vector<ImageIcon> imageArr) {
        /**
         * A function that receives an array of vehicles and an array of the images that represent them
         * and builds a menu of buttons that displays the vehicles that can be added to the dealership.
         */
        JFrame frame = new JFrame("Car Agency");
        GridLayout myGridLayout = new GridLayout(9, 1);
        frame.setLayout(myGridLayout);

        JButton button_Jeep = new JButton(("Jeep"));
        JButton button_Frigate = new JButton(("Frigate"));
        JButton button_SpyGlider = new JButton(("Spy Glider"));
        JButton button_GameGlider = new JButton(("Game Glider"));
        JButton button_Amphibious = new JButton(("Amphibious"));
        JButton button_Bicycle = new JButton(("Regular bicycle"));
        JButton button_CruiseShip = new JButton(("Cruise Ship"));
        JButton button_ElectricBicycle = new JButton(("Electric bicycle"));
        JButton button_HybridPlane = new JButton(("Hybrid Plane"));

        frame.add(button_Jeep);
        frame.add(button_Frigate);
        frame.add(button_SpyGlider);
        frame.add(button_GameGlider);
        frame.add(button_Amphibious);
        frame.add(button_Bicycle);
        frame.add(button_CruiseShip);
        frame.add(button_ElectricBicycle);
        frame.add(button_HybridPlane);

        button_Jeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jeep_Agency obj = new Jeep_Agency();
                obj.Build_jeep(arr, imageArr, frame);
            }
        });

        button_Frigate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frigate_Agency obj = new Frigate_Agency();
                obj.Build_Frigate(arr, imageArr, frame);
            }
        });

        button_SpyGlider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpyGlider_Agency obj = new SpyGlider_Agency();
                obj.Build_SpyGlider(arr, imageArr, frame);
            }
        });

        button_GameGlider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameGlider_Agency obj = new GameGlider_Agency();
                obj.Build_GameGlider(arr, imageArr, frame);
            }
        });

        button_Amphibious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Amphibious_Agency obj = new Amphibious_Agency();
                obj.Build_Amphibious(arr, imageArr, frame);
            }
        });

        button_Bicycle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regular_Bicycle_Agency obj = new Regular_Bicycle_Agency();
                obj.Build_Bicycle(arr, imageArr, frame);
            }
        });

        button_CruiseShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CruiseShip_Agency obj = new CruiseShip_Agency();
                obj.Build_CruiseShip(arr, imageArr, frame);
            }
        });

        button_ElectricBicycle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Electric_Bicycle_Agency obj = new Electric_Bicycle_Agency();
                obj.Build_Bicycle(arr, imageArr, frame);
            }
        });

        button_HybridPlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hybrid_Plane_Agency obj = new Hybrid_Plane_Agency();
                obj.Build_HybridPlane(arr, imageArr, frame);
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void Menu(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, JFrame frame) {
        /**
         * A function that receives an array of vehicles and an array of images representing them and builds
         * a menu of buttons that displays the vehicles in the agency and the actions that can be performed on them.
         */
        vehicle = null;
        vehicle_image = null;
        JPanel panel1 = new JPanel(new GridLayout((imageArr.size() / 5), (imageArr.size() / 3) + 1));
        for (int i = 0; i < imageArr.size(); i++) {
            button.add(new JButton(imageArr.get(i)));
            button.get(i).setToolTipText(arr.get(i).toString());
            panel1.add(button.get(i));
        }

        for (int i = 0; i < imageArr.size(); i++) {
            button.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < imageArr.size(); i++) {
                        if (e.getSource() == button.get(i)) {
                            vehicle = arr.get(i);
                            vehicle_image = imageArr.get(i);
                            break;
                        }
                    }
                }
            });
        }

        JPanel panel2 = new JPanel(new GridLayout(3, 3));
        JButton button_newCar = new JButton("new car");
        JButton button_buying = new JButton("buy car");
        JButton button_test = new JButton("test drive");
        JButton button_resetDistance = new JButton("reset distance");
        JButton button_changeFlag = new JButton("change flag");
        JButton button_exit = new JButton("exit");
        JButton button_changeDistance = new JButton("change distance");
        JButton button_currentInventoryReport = new JButton("current inventory report");

        panel2.add(button_newCar);
        panel2.add(button_buying);
        panel2.add(button_test);
        panel2.add(button_resetDistance);
        panel2.add(button_changeFlag);
        panel2.add(button_currentInventoryReport);
        panel2.add(button_exit);

        frameMenu.add(panel1);
        frameMenu.add(panel2);

        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.isVisible())
                {
                    frame.requestFocus();
                }
                else
                    frame.setVisible(true);
            }
        });

        button_buying.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread buyingThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        buy(arr, imageArr, vehicle,vehicle_image, frame);
                    }
                });
                buyingThread.start();
            }
        });

        button_test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicle1 = vehicle;
                ImageIcon vehicle_image1 = vehicle_image;
                Thread threadTest = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (vehicle1 == null) {
                            JFrame frame2 = new JFrame();
                            if (arr.size() == 0) {
                                JOptionPane.showMessageDialog(frame2, "The agency is empty",
                                        "WARNING", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(frame2, "No vehicle selected:(",
                                        "WARNING", JOptionPane.WARNING_MESSAGE);
                            }
                            frame2.pack();
                            frame2.setLocationRelativeTo(null);
                            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame2.setVisible(true);
                            frame2.dispose();
                            return;
                        }

                        if(!ifInTestDrive(vehicle1) )
                        {
                             if(inTheVector(vehicle1, arr, imageArr))
                                 ifInProgress(vehicle1);
                            JFrame frame1 = new JFrame();
                            frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
                            JPanel panel3 = new JPanel(new GridLayout(3, 1));
                            JLabel label0 = new JLabel(" distance of the vehicle: ");
                            JTextField inDistance = new JTextField();
                            enterToArr(vehicle1);
                            vecInProgress.add(vehicle1);
                            button_changeDistance.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        int distance = Integer.parseInt(inDistance.getText());
                                        if(imageArr.indexOf(vehicle_image1)>0 || imageArr.indexOf(vehicle_image1) < imageArr.size())
                                        {
                                            arr.get(imageArr.indexOf(vehicle_image1)).setDistanceMove(distance);
                                            Thread threadDistance = new Thread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    NewMenu newMenu = new NewMenu();
                                                    newMenu.showMenu(arr, imageArr, frame);
                                                    if (frameInventor != null) {
                                                        if (frameInventor.isVisible()) {
                                                            Inventor inventor = new Inventor();
                                                            inventor.showInventor(arr, imageArr, frame);
                                                            frameInventor.setVisible(true);
                                                        }
                                                    }
                                                    waitThreadOver(distance, vehicle1, frame1);
                                                }
                                            });
                                            threadDistance.start();
                                        }
                                    } catch (NumberFormatException s) {
                                        System.out.println("error");
                                        error_message(frame1);
                                        frame1.dispose();
                                    }
                                }
                            });
                            panel3.add(label0);
                            panel3.add(inDistance);
                            panel3.add(button_changeDistance);
                            frame1.add(panel3);

                            frame1.pack();
                            frame1.setLocationRelativeTo(null);
                            frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                            frame1.setVisible(true);
                        }
                        else
                            error_message();
                    }
                });
                threadTest.start();
            }
        });

        button_resetDistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if(!vecInProgress.contains(vehicle))
                        arr.get(i).setDistanceMove(-arr.get(i).getDistance());
                }
                JFrame frame1 = new JFrame();
                frame1.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                if (arr.size() == 0) {
                    JLabel label1 = new JLabel("The agency is empty");
                    panel.add(label1);
                } else {
                    JLabel label1 = new JLabel("The distance was changed successfully:)");
                    panel.add(label1);
                }
                NewMenu newMenu = new NewMenu();
                newMenu.showMenu(arr, imageArr, frame);
                frame1.add(panel, BorderLayout.CENTER);
                JPanel panel0 = new JPanel();
                JButton button_menu = new JButton("main menu");
                panel0.add(button_menu);
                frame1.add(panel0, BorderLayout.SOUTH);
                button_menu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                    }
                });
                if (frameInventor != null) {
                    if (frameInventor.isVisible()) {
                        Inventor inventor = new Inventor();
                        inventor.showInventor(arr, imageArr, frame);
                        frameInventor.setVisible(true);
                    }
                }

                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep((long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                            frame1.setVisible(true);
                        } catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
            }
        });

        button_changeFlag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flags flags = new Flags();
                flags.createFlags(arr, imageArr, frame);
                if (frameInventor != null) {
                    if (frameInventor.isVisible()) {
                        Inventor inventor = new Inventor();
                        inventor.showInventor(arr, imageArr, frame);
                        frameInventor.setVisible(true);
                    }
                }
            }
        });

        button_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                if(frameInventor!=null)
                {
                    if (frameInventor.isVisible()) {
                        frameInventor.dispose();
                    }
                }
                if(vecInProgress.size()==0)
                    System.exit(0);
            }
        });

        button_currentInventoryReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventor inventor = new Inventor();
                inventor.showInventor(arr, imageArr, frame);
                frameInventor.setVisible(true);
            }
        });

        frameMenu.pack();
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMenu.setVisible(true);
    }

    private static void error_message() {
        /**
         * A function that receives the frame that is open
         * with the user and closes it and opens an error message accordingly.
         */
        JFrame frame2 = new JFrame();
        JOptionPane.showMessageDialog(frame2, "It is not possible to do a test drive",
                "WARNING", JOptionPane.WARNING_MESSAGE);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setVisible(true);
        frame2.dispose();
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

    private static boolean delete(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, ImageIcon vehicle_image, Vehicle vehicle) {
        /**
         * A function that receives an array of vehicles, an array of the images representing them and an index
         * with which it deletes the elements from the array that are in this position and returns a boolean value
         * if the deletion was performed.
         */

        if (vehicle == null)
            return false;

        else
        {
            for (int i = 0; i < imageArr.size(); i++)
            {
                if(vehicle == arr.get(i) && vehicle_image == imageArr.get(i))
                {
                    arr.set(i, arr.get(arr.size() - 1));
                    arr.set(arr.size() - 1, null);
                    imageArr.set(i, imageArr.get(imageArr.size() - 1));
                    imageArr.set(imageArr.size() - 1, null);
                    arr.remove(arr.size() - 1);
                    imageArr.remove(imageArr.size() - 1);
                    return true;

                }
            }
        }
        return false;
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

    protected static void addNewCar(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, JFrame frame, JFrame frame1) {
        if (frameInventor != null) {
            if (frameInventor.isVisible()) {
                Inventor inventor = new Inventor();
                inventor.showInventor(arr, imageArr, frame);
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

    private void waitThreadOver(int distance, Vehicle vehicle, JFrame frame1) {
        /**
         * A function blocks access to vehicles that are on a test drive,
         * at the end releases the procedures waiting to be executed
         */
        synchronized (vehicle) {
            try {
                Thread.sleep(distance * 100);

            } catch (InterruptedException x) {
                x.printStackTrace();
            }
            System.out.println("over");
            frame1.dispose();
            if (vehicle instanceof Air) {
                arrTest[0] = 0;
            }
            if (vehicle instanceof Marine) {
                arrTest[1] = 0;
            }
            if (vehicle instanceof Land) {
                arrTest[2] = 0;
            }
            vecInProgress.remove(vehicle);
            vehicle.notifyAll();
        }
    }

    private boolean ifInTestDrive(Vehicle vehicle) {
        /**
         * A function that accepts vehicles and returns
         * a boolean value if the vehicle is in the array
         */
        if (vehicle instanceof Air) {
            if(arrTest[0]==1)
                return true;
        }
        if (vehicle instanceof Marine) {
            if(arrTest[1]==1)
                return true;
        }
        if (vehicle instanceof Land) {
            if(arrTest[2]==1)
                return true;
        }
        return false;
    }

    private void enterToArr(Vehicle vehicle)
    {
        /**
         * A function that receives a vehicle that wants to perform
         * a test drive on it and enters it into the array
         */
        if (vehicle instanceof Air) {
            arrTest[0] = 1;
        }
        if (vehicle instanceof Marine) {
            arrTest[1] = 1;
        }
        if (vehicle instanceof Land) {
            arrTest[2] = 1;
        }
    }

    private void ifInProgress(Vehicle vehicle)
    {
        /**
         * A function that accepts a vehicle that wants to test drive or
         * buy a car and is in the middle of another process, so it makes it wait.
         */
        synchronized (vehicle)
        {
            while (vecInProgress.contains(vehicle))
            {
                try {
                    vehicle.wait();
                } catch (InterruptedException x) {
                    x.printStackTrace();
                }
            }
        }
    }
    private boolean inTheVector(Vehicle vehicle, Vector<Vehicle> arr, Vector<ImageIcon> imageArr)
    {
        if(vecInProgress.contains(vehicle))
            return true;
        else
            return false;
    }

    private void buy(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, Vehicle vehicle1, ImageIcon vehicle_image1 ,JFrame frame)
    {
        if (vehicle1 != null) {
            ifInProgress(vehicle1);
            vecInProgress.add(vehicle1);
            try {
                Thread.sleep((long) (Math.random() * (10000 - 5000 + 1) + 5000));
            }
            catch (InterruptedException z) {
                z.printStackTrace();
            }
            JFrame frame2 = new JFrame();
            frame2.setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.PAGE_AXIS));
            JPanel panell1 = new JPanel();
            JPanel panell2 = new JPanel(new GridLayout(1, 2));
            JLabel text = new JLabel("Are you sure you want to buy?");
            JRadioButton button_yes = new JRadioButton("yes");
            JRadioButton button_no = new JRadioButton("no");
            panell1.add(text);
            panell2.add(button_yes);
            panell2.add(button_no);
            frame2.add(panell1);
            frame2.add(panell2);

            button_yes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Thread pressYes = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sign = true;
                            frame2.dispose();
                            System.out.println(sign);
                            delete(arr, imageArr, vehicle_image1, vehicle1);
                            JFrame frameWaiting = waiting(arr, imageArr, frame);

                            Thread waitThread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        NewMenu newMenu = new NewMenu();
                                        newMenu.showMenu(arr, imageArr, frame);
                                        if (frameInventor != null) {
                                            if (frameInventor.isVisible()) {
                                                Inventor inventor = new Inventor();
                                                inventor.showInventor(arr, imageArr, frame);
                                                frameInventor.setVisible(true);
                                            }
                                        }
                                        Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                                        frameWaiting.dispose();
                                        JFrame frame1 = new JFrame();
                                        frame1.setLayout(new BorderLayout());
                                        JPanel panel = new JPanel();
                                        if (arr.size() != 0) {
                                            JLabel label1 = new JLabel("The purchase was made successfully:)");
                                            panel.add(label1);
                                        } else {
                                            JLabel label1 = new JLabel("Now- the agency is empty");
                                            panel.add(label1);
                                        }

                                        frame1.add(panel, BorderLayout.CENTER);
                                        JPanel panel0 = new JPanel();
                                        JButton button_menu = new JButton("main menu");
                                        panel0.add(button_menu);
                                        frame1.add(panel0, BorderLayout.SOUTH);
                                        button_menu.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                frame1.dispose();
                                            }
                                        });
                                        frame1.pack();
                                        frame1.setLocationRelativeTo(null);
                                        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    }
                                    catch (InterruptedException a) {
                                        a.printStackTrace();
                                    }
                                }
                            });
                            waitThread.start();
                        }
                    });
                    pressYes.start();
                }
            });
            button_no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sign = false;
                    vecInProgress.remove(vehicle1);
//                    frame2.dispose();
                   waitThreadOver(0, vehicle1, frame2);
                }
            });

            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame2.setVisible(true);

        } else {
            JFrame frame1 = new JFrame();
            frame1.setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            if (arr.size() == 0) {
                JLabel label1 = new JLabel("The agency is empty");
                panel.add(label1);
            } else {
                JLabel label1 = new JLabel("No vehicle selected:(");
                panel.add(label1);
            }
            frame1.add(panel, BorderLayout.CENTER);
            JPanel panel0 = new JPanel();
            JButton button_menu = new JButton("main menu");
            panel0.add(button_menu);
            frame1.add(panel0, BorderLayout.SOUTH);
            button_menu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame1.dispose();
                }
            });
            frame1.pack();
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.setVisible(true);

        }
    }
    public static JFrame waiting(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, JFrame frame)
    {
        JFrame frameWaiting= new JFrame();
        frameWaiting.setLayout(new BorderLayout());
        JPanel panelWaiting = new JPanel();
        JLabel labelWaiting= new JLabel("Updating database...Please wait");
        panelWaiting.add(labelWaiting);
        frameWaiting.add(panelWaiting);

        frameWaiting.pack();
        frameWaiting.setLocationRelativeTo(null);
        frameWaiting.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameWaiting.setVisible(true);
        return frameWaiting;
    }
}
