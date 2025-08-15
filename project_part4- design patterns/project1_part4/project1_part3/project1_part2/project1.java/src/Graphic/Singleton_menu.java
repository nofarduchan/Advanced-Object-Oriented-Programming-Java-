package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Singleton_menu extends My_Agency {
    private static Singleton_menu singleton_menu= null;
    private Originator originator = new Originator();
    private Caretaker caretaker = new Caretaker();
    private static Memento memento = new Memento(arr);
    private static int ourTotalDistance;

    private Singleton_menu() {}

    public static Singleton_menu getMenu()
    {
        if (singleton_menu == null)
            singleton_menu = new Singleton_menu();
        return singleton_menu;
    }

    public void Menu() {
        /**
         * A function that receives an array of vehicles and an array of images representing them and builds
         * a menu of buttons that displays the vehicles in the agency and the actions that can be performed on them.
         */
        vehicle = null;
        vehicle_image = null;
        JPanel panel1 = new JPanel(new GridLayout((arr.size() / 5), (arr.size() / 3) + 1));

        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, new Decorator_color(arr.get(i)).getVehicle1());
            button.add(new JButton(arr.get(i).getImage()));
            button.get(i).setToolTipText(arr.get(i).toString());
            panel1.add(button.get(i));
        }
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        if(arr.size() > 0)
        {
            ourTotalDistance = arr.get(0).getTotal_distance();
            JButton button_toStringDistance = new JButton("total distance:  " + ourTotalDistance);
            panel3.add(button_toStringDistance);
        }
        else
        {
            JButton button_toStringDistance = new JButton("total distance:  " + ourTotalDistance);
            panel3.add(button_toStringDistance);
        }

        for (int i = 0; i < arr.size(); i++) {
            button.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < arr.size(); i++) {
                        if (e.getSource() == button.get(i)) {
                            vehicle = arr.get(i);
                            vehicle_image = arr.get(i).getImage();
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
        JButton button_savingState = new JButton("saving state");
        JButton button_loadingState = new JButton("loading state");
        JButton button_currentInventoryReport = new JButton("current inventory report");

        panel2.add(button_newCar);
        panel2.add(button_buying);
        panel2.add(button_test);
        panel2.add(button_resetDistance);
        panel2.add(button_changeFlag);
        panel2.add(button_currentInventoryReport);
        panel2.add(button_savingState);
        panel2.add(button_loadingState);
        panel2.add(button_exit);

        if (frameMenu!= null)
        {
            frameMenu.add(panel1);
            frameMenu.add(panel2);
            frameMenu.add(panel3);
        }
//        frameMenu.add(panel1);
//        frameMenu.add(panel2);

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
                        buy(arr, vehicle , vehicle_image, frame);
                    }
                });
                buyingThread.start();
            }
        });

        button_test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        testing(arr, frame);
                    }
                });
            }
        });

        button_resetDistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if(!vecInProgress.contains(vehicle))
                        arr.get(i).setDistanceMove(0);
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
                clearFrame(frameMenu);
                for (int j=0; j<arr.size(); j++)
                {
//                    arr.set(j, new Decorator_color(arr.get(j)).getVehicle1());
                    button.set(j, new JButton(arr.get(j).getImage()));
                }
                Singleton_menu.getMenu().Menu();
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
                        inventor.showInventor(arr, frame);
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
                            for (int j=0; j<arr.size(); j++)
                            {
                                arr.set(j, new Decorator_color(arr.get(j)).getVehicle1());
                                button.set(j, new JButton(arr.get(j).getImage()));
                            }
                            Singleton_menu.getMenu().Menu();
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
                flags.createFlags(arr, frame);
                if (frameInventor != null) {
                    if (frameInventor.isVisible()) {
                        Inventor inventor = new Inventor();
                        inventor.showInventor(arr, frame);
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
                inventor.showInventor(arr, frame);
                frameInventor.setVisible(true);
            }
        });

        button_savingState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Vehicle> copy_arr= new Vector<>();
                for(int i=0; i< arr.size(); i++)
                {
                    Vehicle car = (arr.get(i)).clone();
                    copy_arr.add(car);
                }
                originator.setMemento_arr(copy_arr);
                memento = originator.createMemento();
                caretaker.addMemento(memento);
            }
        });

        button_loadingState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(caretaker.getVector().size() != 0)
                {
                    memento = caretaker.getMemento();
                    originator.setMemento(memento);
                    arr = originator.getMemento_arr();
                    clearFrame(frameMenu);
                    for (int j=0; j<arr.size(); j++)
                    {
                        arr.set(j, new Decorator_color(arr.get(j)).getVehicle1());
                        button.set(j, new JButton(arr.get(j).getImage()));
                    }
                    singleton_menu.Menu();
                }
            }
        });

        if(frameMenu!=null)
        {
            frameMenu.pack();
            frameMenu.setLocationRelativeTo(null);
            frameMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameMenu.setVisible(true);
        }
    }

    private String toStringDistance() {
            return arr.get(0).toStringDistance();
    }

    private static boolean delete(Vector<Vehicle> arr, ImageIcon vehicle_image, Vehicle vehicle) {
        /**
         * A function that receives an array of vehicles, an array of the images representing them and an index
         * with which it deletes the elements from the array that are in this position and returns a boolean value
         * if the deletion was performed.
         */

        if (vehicle == null)
            return false;

        else
        {
            for (int i = 0; i < arr.size(); i++)
            {
                if(vehicle == arr.get(i))
                {
                    arr.set(i, arr.get(arr.size() - 1));
                    arr.set(arr.size() - 1, null);
                    arr.remove(arr.size() - 1);
                    for (int j=0; j<arr.size(); j++)
                    {
                        arr.set(j, new Decorator_color(arr.get(j)).getVehicle1());
                        button.set(j, new JButton(arr.get(j).getImage()));
                    }
                    return true;

                }
            }
        }
        return false;
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
            if(frame1!=null)
                frame1.dispose();
            vecInProgress.remove(vehicle);
            vehicle.notifyAll();
            vehicle.setState("inventory");
            clearFrame(frameMenu);
            Singleton_menu.getMenu().Menu();
        }
    }

    public void testing(Vector<Vehicle> arr, JFrame frame)
    {
        Object lock = new Object();
        Vehicle vehicle1 = vehicle;
        clearFrame(frameMenu);
        Singleton_menu.getMenu().Menu();
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
        ifInProgress(vehicle1);
        vecInProgress.add(vehicle1);
        vehicle1.setState("testing");
        clearFrame(frameMenu);
        Singleton_menu.getMenu().Menu();
        JFrame frame1 = new JFrame();
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel3 = new JPanel(new GridLayout(3, 1));
        JLabel label0 = new JLabel(" distance of the vehicle: ");
        JTextField inDistance = new JTextField();
        JButton button_changeDistance = new JButton("change distance");
        button_changeDistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int distance = Integer.parseInt(inDistance.getText());
                    if(arr.indexOf(vehicle1)>0 || arr.indexOf(vehicle1) < arr.size())
                    {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("BEGIN");
                                if (frameInventor != null) {
                                    if (frameInventor.isVisible()) {
                                        Inventor inventor = new Inventor();
                                        inventor.showInventor(arr, frame);
                                        frameInventor.setVisible(true);
                                    }
                                }
                                waitThreadOver(distance, vehicle1, frame1);
                                synchronized (lock)
                                {
                                    lock.notify();
                                }
                                System.out.println("FINISH");
                                arr.get(arr.indexOf(vehicle1)).setDistanceMove(distance);
                                vehicle1.setTotal_distance(distance);
                                clearFrame(frameMenu);
                                Singleton_menu.getMenu().Menu();
                            }
                        });
                        thread.start();
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

        synchronized (lock)
        {
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
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
    protected void buy(Vector<Vehicle> arr, Vehicle vehicle1, ImageIcon vehicle_image1 ,JFrame frame)
    {
        if (vehicle1 != null) {
            ifInProgress(vehicle1);
            vehicle1.setState("buying");
            clearFrame(frameMenu);
            Singleton_menu.getMenu().Menu();
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
            clearFrame(frameMenu);
            Singleton_menu.getMenu().Menu();
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
                            frame2.dispose();
                            JFrame frameWaiting = waiting(arr, frame);
                            Thread waitThread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        if (frameInventor != null) {
                                            if (frameInventor.isVisible()) {
                                                Inventor inventor = new Inventor();
                                                inventor.showInventor(arr, frame);
                                                frameInventor.setVisible(true);
                                            }
                                        }
                                        Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                                        delete(arr, vehicle_image1, vehicle1);
                                        clearFrame(frameMenu);
                                        Singleton_menu.getMenu().Menu();
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
                    vecInProgress.remove(vehicle1);
                    waitThreadOver(0, vehicle1, frame2);
                    vehicle1.setState("inventory");
                    clearFrame(frameMenu);
                    Singleton_menu.getMenu().Menu();
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
    public static JFrame waiting(Vector<Vehicle> arr, JFrame frame)
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
