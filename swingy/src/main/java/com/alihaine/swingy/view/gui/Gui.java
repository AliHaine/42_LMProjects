package com.alihaine.swingy.view.gui;

import com.alihaine.swingy.view.ViewMode;

import javax.swing.*;
import java.awt.*;

public class Gui extends ViewMode {

    private final JFrame mainWindow = new JFrame();
    private final JPanel mainPanel = new JPanel();

    public Gui() {
        this.InitWin();
    }

    public void InitWin() {
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        mainWindow.add(scrollPane);
        mainWindow.setVisible(true);

    }

    public void DisplayImageToFrame(int x, int y, JLabel jLabel) {
        jLabel.setBounds(x, y, 64, 64);
        this.mainPanel.add(jLabel);
        this.mainWindow.revalidate();
        this.mainWindow.repaint();
    }

    @Override
    public void DisplayMap(int mapSize) {
        mainPanel.setPreferredSize(new Dimension(mapSize*64, mapSize*64)); // Larger than frame
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                this.DisplayImageToFrame(x * 64, y * 64, new JLabel(Images.images.getImageIconFromPath("/a2.jpg")));
            }
        }
    }
}
