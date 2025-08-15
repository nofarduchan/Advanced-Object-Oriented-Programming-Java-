package Graphic;

import vehicle.Amphibious;
import vehicle.Marine;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Flags extends My_Agency {
    public Flags (){}

    public boolean createFlags(Vector<Vehicle> arr, Vector<ImageIcon> imageArr, JFrame frame) {
        /**
         * A function that receives the array of vehicles and the array of images that represent them,
         * builds a menu containing flags buttons with which you will change the flags of the naval vehicles
         * and return a boolean value accordingly
         */
        JFrame frame1 = new JFrame("Flags");
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel(new GridLayout(1, 7));

        JButton button_Israel = new JButton();
        ImageIcon image_israel = new ImageIcon(this.getClass().getResource("israel.png"));
        small_image_button(panel, button_Israel, image_israel);


        JButton button_Usa = new JButton();
        ImageIcon image_usa = new ImageIcon(this.getClass().getResource("usa.jpg"));
        small_image_button(panel, button_Usa, image_usa);

        JButton button_Germany = new JButton();
        ImageIcon image_germany = new ImageIcon(this.getClass().getResource("germany.png"));
        small_image_button(panel, button_Germany, image_germany);

        JButton button_Italy = new JButton();
        ImageIcon image_italy = new ImageIcon(this.getClass().getResource("italy.png"));
        small_image_button(panel, button_Italy, image_italy);

        JButton button_Greece = new JButton();
        ImageIcon image_greece = new ImageIcon(this.getClass().getResource("greece.png"));
        small_image_button(panel, button_Greece, image_greece);

        JButton button_Somalia = new JButton();
        ImageIcon image_somalia = new ImageIcon(this.getClass().getResource("somalia.jpg"));
        small_image_button(panel, button_Somalia, image_somalia);

        JButton button_Pirates = new JButton();
        ImageIcon image_pirates = new ImageIcon(this.getClass().getResource("pirates.png"));
        small_image_button(panel, button_Pirates, image_pirates);

        frame1.add(panel);

        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);

        button_Israel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("Israel");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("Israel");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });

        button_Usa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("USA");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("USA");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();

                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });

        button_Germany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("Germany");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("Germany");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });

        button_Italy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("Italy");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("Italy");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });

        button_Greece.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("Greece");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("Greece");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });

        button_Somalia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("Somalia");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("Somalia");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });

        button_Pirates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) instanceof Marine) {
                        ((Marine) arr.get(i)).setFlag("Pirates");
                    } else if (arr.get(i) instanceof Amphibious) {
                        ((Amphibious) arr.get(i)).setFlag("Pirates");
                    }
                }

                JFrame frameWaiting = waiting(arr, imageArr, frame);
                Thread waitThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            clearFrame(frameMenu);
                            Menu(arr, imageArr, frame);
                            Thread.sleep( (long) (Math.random() * (8000 - 3000 + 1) + 3000));
                            frameWaiting.dispose();
                        }
                        catch (InterruptedException a) {
                            a.printStackTrace();
                        }
                    }
                });
                waitThread.start();
                frame1.dispose();
            }
        });
        return true;
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
        frameWaiting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWaiting.setVisible(true);
        return frameWaiting;
    }
}

