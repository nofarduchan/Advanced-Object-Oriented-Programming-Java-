package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Decorator_color extends Decorator{
    private Color color = Color.red;
    private BufferedImage image_buf;
    private Image image1;

    public Decorator_color(Vehicle decoratoeVehicle) {
        super(decoratoeVehicle);
        image1 = vehicle2.getImage().getImage();
        BufferedImage bufferedImage = ChangeToBufferedImage(image1);

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage framedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = framedImage.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.drawImage(bufferedImage, 1, 1, null);
        g2d.dispose();
        image_buf = framedImage;
        image1 = image_buf;
        vehicle2.seImage(new ImageIcon(image1));
    }
    private BufferedImage ChangeToBufferedImage(Image image1) {
        if (image1 instanceof BufferedImage) {
            return (BufferedImage) image1;
        }

        BufferedImage bufferedImage = new BufferedImage(
                image1.getWidth(null),
                image1.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image1, 0, 0,  null);
        g2d.dispose();

        return bufferedImage;
    }
    public Vehicle getVehicle1() {
        return vehicle2;
    }

}
