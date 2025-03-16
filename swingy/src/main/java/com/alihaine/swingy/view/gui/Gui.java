package com.alihaine.swingy.view.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Gui {

    public static void InitWin() {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // adding button in JFrame

        // 400 width and 500 height
        frame.setSize(1400, 1600);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);

        URL imageUrl = Gui.class.getResource("/a2.jpg");
        if (imageUrl == null) {
            System.out.println("Image not found");
            return;
        }

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(imageUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(50, 50, myPicture.getWidth(), myPicture.getHeight());

        frame.add(picLabel);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args)
    {
        InitWin();
    }
}
