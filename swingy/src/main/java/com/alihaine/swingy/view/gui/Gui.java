package com.alihaine.swingy.view.gui;

import com.alihaine.swingy.view.ViewMode;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.xml.soap.Text;
import java.awt.*;

public class Gui extends ViewMode {

    private final JFrame mainWindow = new JFrame();
    private final JPanel mainPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JPanel textPanel = new JPanel();

    public Gui() {
        this.InitWin();
    }

    public void InitWin() {
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        inputPanel.add(new JButton("test"));

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        JLabel textLabel = new JLabel();
        textLabel.setText("salut cava");
        textPanel.add(textLabel);
        textLabel.setText("moom vaca cava");
        //textPanel.add(new JLabel());
        textPanel.add(new TextArea());
        textPanel.setBackground(Color.blue);


        mainWindow.add(inputPanel, BorderLayout.SOUTH);
        mainWindow.add(scrollPane, BorderLayout.CENTER);
        mainWindow.add(textPanel, BorderLayout.EAST);
        mainWindow.setVisible(true);

    }

    @Override
    public void DisplayToPosition(int x, int y, JLabel jLabel) {
        jLabel.setBounds(x, y, 64, 64);
        jLabel.setBorder(new LineBorder(Color.white, 1));
        this.mainPanel.add(jLabel);
        this.mainPanel.setComponentZOrder(jLabel, 0);
        this.mainWindow.repaint();
    }

    @Override
    public void DisplayMap(int mapSize) {
        mainPanel.setPreferredSize(new Dimension(mapSize*64, mapSize*64)); // Larger than frame
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                this.DisplayToPosition(x * 64, y * 64, new JLabel(Images.images.getImageIconFromPath("ground")));
            }
        }
    }
}
