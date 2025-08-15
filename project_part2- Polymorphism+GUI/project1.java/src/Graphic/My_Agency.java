package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class My_Agency {
    private int temp1 = -1;
    protected ImageIcon image_choise;

    public My_Agency(){ }
    public void Building(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr)
    {
        /**
         * A function that receives an array of vehicles and an array of the images that represent them
         * and builds a menu of buttons that displays the vehicles that can be added to the dealership.
         */
        JFrame frame = new JFrame("Car Agency");
        GridLayout myGridLayout = new GridLayout(7,1);
        frame.setLayout(myGridLayout);

        JButton button_Jeep = new JButton(("Jeep"));
        JButton button_Frigate = new JButton(("Frigate"));
        JButton button_SpyGlider = new JButton(("Spy Glider"));
        JButton button_GameGlider = new JButton(("Game Glider"));
        JButton button_Amphibious = new JButton(("Amphibious"));
        JButton button_Bicycle = new JButton(("Bicycle"));
        JButton button_CruiseShip = new JButton(("Cruise Ship"));

        frame.add(button_Jeep);
        frame.add(button_Frigate);
        frame.add(button_SpyGlider);
        frame.add(button_GameGlider);
        frame.add(button_Amphibious);
        frame.add(button_Bicycle );
        frame.add(button_CruiseShip);

        button_Jeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Jeep_Agency obj = new Jeep_Agency();
                obj.Build_jeep(arr, imageArr);
            }
        });

        button_Frigate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Frigate_Agency obj = new Frigate_Agency();
                obj.Build_Frigate(arr, imageArr);
            }
        });

        button_SpyGlider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SpyGlider_Agency obj = new SpyGlider_Agency();
                obj.Build_SpyGlider(arr, imageArr);
            }
        });

        button_GameGlider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GameGlider_Agency obj = new GameGlider_Agency();
                obj.Build_GameGlider(arr, imageArr);
            }
        });

        button_Amphibious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Amphibious_Agency obj = new Amphibious_Agency();
                obj.Build_Amphibious(arr, imageArr);
            }
        });

        button_Bicycle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Bicycle_Agency obj = new Bicycle_Agency();
                obj.Build_Bicycle(arr, imageArr);
            }
        });

        button_CruiseShip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CruiseShip_Agency obj = new CruiseShip_Agency();
                obj.Build_CruiseShip(arr, imageArr);
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        frame.pack();
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void Menu(ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr)
    {
        /**
         * A function that receives an array of vehicles and an array of images representing them and builds
         * a menu of buttons that displays the vehicles in the agency and the actions that can be performed on them.
         */
        temp1 = -1;
        JFrame frame = new JFrame("Car Agency");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel1 = new JPanel(new GridLayout((imageArr.size()/5) , (imageArr.size()/3)+ 1));

        JButton[] button = new JButton[imageArr.size()];
        for(int i=0; i<imageArr.size(); i++) {
            button[i] = new JButton(imageArr.get(i));
            button[i].setToolTipText(arr.get(i).toString());
            panel1.add(button[i]);
        }

        for(int i=0; i<imageArr.size(); i++) {
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < imageArr.size(); i++) {
                        if (e.getSource() == button[i]) {
                            temp1 = i;
                            break;
                        }
                    }
                }
            });
        }

        JPanel panel2 = new JPanel(new GridLayout());
        JButton button_newCar = new JButton("new car");
        JButton button_buying = new JButton("buy car");
        JButton button_test = new JButton("test drive");
        JButton button_resetDistance = new JButton("reset distance");
        JButton button_changeFlag = new JButton("change flag");
        JButton button_exit = new JButton("exit");
        JButton button_changeDistance = new JButton("change distance");

        panel2.add(button_newCar);
        panel2.add(button_buying);
        panel2.add(button_test);
        panel2.add(button_resetDistance);
        panel2.add(button_changeFlag);
        panel2.add(button_exit);

        frame.add(panel1);
        frame.add(panel2);

        button_newCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Building(arr, imageArr);
            }
        });

        button_buying.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                boolean counter = false;
                if(delete(arr, imageArr, temp1)){
                    counter = true;
                }

                JFrame frame1 = new JFrame ();
                frame1.setLayout(new BorderLayout());
                JPanel panel1 = new JPanel();
                if(counter)
                {
                    if(arr.size() != 0)
                    {
                        JLabel label1 = new JLabel("The purchase was made successfully:)");
                        panel1.add(label1);
                    }
                    else
                    {
                        JLabel label1 = new JLabel("The agency is empty");
                        panel1.add(label1);
                    }

                }
                else
                {
                    if(arr.size() == 0)
                    {
                        JLabel label1 = new JLabel("The agency is empty");
                        panel1.add(label1);
                    }
                    else
                    {
                        JLabel label1 = new JLabel("No vehicle selected:(");
                        panel1.add(label1);
                    }
                }
                frame1.add(panel1, BorderLayout.CENTER);
                JPanel panel2 = new JPanel();
                JButton button_menu = new JButton ("main menu");
                panel2.add(button_menu);
                frame1.add(panel2, BorderLayout.SOUTH);

                button_menu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        Menu(arr, imageArr);
                    }
                });

                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });

        button_test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if(temp1 == -1)
                {
                    JFrame frame2 = new JFrame();
                    if (arr.size() == 0)
                    {
                        JOptionPane.showMessageDialog(frame2, "The agency is empty",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(frame2, "No vehicle selected:(",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    }
                    frame2.pack();
                    frame2.setLocationRelativeTo(null);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setVisible(true);
                    frame2.dispose();
                    Menu(arr, imageArr);
                    return;
                }
                JFrame frame1 = new JFrame();
                frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
                JPanel panel3 = new JPanel(new GridLayout(3, 1));
                JLabel label0 = new JLabel(" distance of the vehicle: ");
                JTextField inDistance = new JTextField();
                button_changeDistance.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int distance = Integer.parseInt(inDistance.getText());
                        } catch (NumberFormatException s) {
                            error_message(frame1);
                            Menu(arr, imageArr);
                        }
                        int distance = Integer.parseInt(inDistance.getText());
                        arr.get(temp1).setDistanceMove(distance);
                        frame1.dispose();
                        Menu(arr, imageArr);
                    }
                });
                panel3.add(label0);
                panel3.add(inDistance);
                panel3.add(button_changeDistance);
                frame1.add(panel3);

                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });

        button_resetDistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                for (int i=0; i<arr.size(); i++)
                {
                    arr.get(i).setDistanceMove(-arr.get(i).getDistance());
                }
                JFrame frame1 = new JFrame ();
                frame1.setLayout(new BorderLayout());
                JPanel panel1 = new JPanel();
                if(arr.size() == 0)
                {
                    JLabel label1 = new JLabel("The agency is empty");
                    panel1.add(label1);
                }
                else {
                    JLabel label1 = new JLabel("The distance was changed successfully:)");
                    panel1.add(label1);

                }
                frame1.add(panel1, BorderLayout.CENTER);
                JPanel panel2 = new JPanel();
                JButton button_menu = new JButton ("main menu");
                panel2.add(button_menu);
                frame1.add(panel2, BorderLayout.SOUTH);
                button_menu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        Menu(arr, imageArr);
                    }
                });

                frame1.pack();
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);
            }
        });

        button_changeFlag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Flags flags = new Flags();
                flags.createFlags(arr, imageArr);
            }
        });

        button_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void error_message(JFrame frame1)
    {
        /**
         * A function that receives the frame that is open
         * with the user and closes it and opens an error message accordingly.
         */
        frame1.dispose();
        JFrame frame2 = new JFrame();
        JOptionPane.showMessageDialog(frame2, "You missed a field / Incorrect input",
                "WARNING", JOptionPane.WARNING_MESSAGE);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        frame2.dispose();
    }

    public static ImageIcon small_image_button(JPanel panel, JButton button, ImageIcon image)
    {
        /**
         * A function that receives an image, a button and a panel and returns an image smaller than the original.
         * Add the small image to the button and the button to the panel.
         */
        Image image1 = image.getImage().getScaledInstance( 100, 100, Image.SCALE_SMOOTH);
        ImageIcon smallImage1 = new ImageIcon(image1);
        button.setIcon(smallImage1);
        panel.add(button);
        return smallImage1;
    }

    public void add_image(JButton button_add)
    {
        /**
         * A function that accepts a button and adds an image
         * to the button that the user chooses himself
         */
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        ImageIcon imageIcon = new ImageIcon(file.getPath());
        Image image3 = imageIcon.getImage().getScaledInstance( 100, 100, Image.SCALE_SMOOTH);
        ImageIcon smallImage3 = new ImageIcon(image3);
        button_add.setIcon(smallImage3);
        image_choise = smallImage3;
    }

    public static boolean delete (ArrayList<Vehicle> arr, ArrayList<ImageIcon> imageArr, int index)
    {
        /**
         * A function that receives an array of vehicles, an array of the images representing them and an index
         * with which it deletes the elements from the array that are in this position and returns a boolean value
         * if the deletion was performed.
         */
        if (index < 0)
            return false;

        for (int i = 0; i < imageArr.size(); i++) {
            if(i == index)
            {
                arr.set(i, arr.get(arr.size()-1));
                arr.set(arr.size()-1, null);
                imageArr.set(i, imageArr.get(imageArr.size()-1));
                imageArr.set(imageArr.size()-1, null);
                arr.remove(arr.size()-1);
                imageArr.remove(imageArr.size()-1);
                return true;
            }
        }
        return false;
    }

}
