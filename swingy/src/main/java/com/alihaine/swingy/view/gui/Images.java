package com.alihaine.swingy.view.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Images {

    private final HashMap<String, ImageIcon> imagesList = new HashMap<>();
    public static final Images images = new Images();

    private Images() {
        final List<String> imagesPath = Arrays.asList("ground", "fizz");

        for (String imagePath : imagesPath) {
            final ImageIcon imageIcon = this.LoadImage("/" + imagePath + ".jpg");
            if (imageIcon == null) {
                System.out.println("Impossible to load the image " + imagePath);
                System.exit(2);
            }
            this.imagesList.put(imagePath, imageIcon);
        }

    }

    private ImageIcon LoadImage(String imagePath) {
        URL imageUrl = Gui.class.getResource(imagePath);
        if (imageUrl == null) {
            System.out.println("Image not found");
            return null;
        }

        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(imageUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ImageIcon(myPicture);
    }

    public ImageIcon getImageIconFromPath(String imagePath) {
        return this.imagesList.get(imagePath);
    }

}
