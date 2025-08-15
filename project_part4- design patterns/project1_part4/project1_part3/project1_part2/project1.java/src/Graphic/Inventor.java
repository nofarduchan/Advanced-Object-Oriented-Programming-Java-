package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class Inventor extends My_Agency {
    public Inventor() { }
    public void showInventor(Vector<Vehicle> arr, JFrame frame)
    {
        if(frameInventor!=null)
        {
            frameInventor.dispose();
        }
        frameInventor = new JFrame("Current inventory report");
        frameInventor.setLayout(new BoxLayout(frameInventor.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Inventory of vehicles at the dealership: ");
        panel.add(label);
        frameInventor.add(panel);
        JPanel panel1 = new JPanel(new GridLayout((arr.size()/5) , (arr.size()/3) + 1));
        JFrame frame2 = new JFrame();
        frame2.setLayout(new BorderLayout());
        JPanel panel2 = new JPanel();
        JTextArea text = new JTextArea();
        JButton button_menu = new JButton("main menu");
        JPanel panel3 = new JPanel();
        panel3.add(button_menu);


        JLabel[] label1 = new JLabel[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            label1[i] = new JLabel(arr.get(i).getImage());
            panel1.add(label1[i]);
        }

        for(int i=0; i<arr.size(); i++) {
            label1[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (frame2.isVisible())
                    {
                        frame2.dispose();
                    }
                    error_message(frame2);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (frame2.isVisible())
                    {
                        frame2.dispose();
                    }
                    error_message(frame2);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (frame2.isVisible())
                    {
                        frame2.dispose();
                    }
                    error_message(frame2);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    for (int i = 0; i < arr.size(); i++) {
                        if (e.getSource() == label1[i]) {
                            text.setText(arr.get(i).toString());
                            text.setWrapStyleWord(true);
                            panel2.add(text);
                            frame2.add(panel2, BorderLayout.CENTER);
                            frame2.pack();
                            frame2.setSize(200, 250);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.setVisible(true);
                            break;
                        }
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    for (int i = 0; i < arr.size(); i++) {
                        if (e.getSource() == label1[i]) {
                            frame2.dispose();
                            break;
                        }
                    }
                }
            });
        }

        button_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.requestFocus();
            }
        });

        frameInventor.add(panel1);
        frameInventor.add(panel3);

        frameInventor.pack();
        frameInventor.setLocationRelativeTo(null);
        frameInventor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
