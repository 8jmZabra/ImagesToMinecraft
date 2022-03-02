package me.zabra.ImageViewer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imageTocolour {
    public static int[][][] main (File imgD) throws IOException {
        BufferedImage image = ImageIO.read(imgD);
        int width = image.getWidth();
        int height = image.getHeight();


        int pixels[][][] = new int[height][width][3];

        for (int l=0; l<height; l++) {
            for (int w = 0; w < width; w++) {
                Color c = new Color(image.getRGB(w, l));
                pixels[l][w][0] = c.getRed();
                pixels[l][w][1] = c.getGreen();
                pixels[l][w][2] = c.getBlue();
            }
        }
        return pixels;
    }
}
