package com.alihaine.swingy.view.gui;

import com.alihaine.swingy.controller.GameLoop;
import com.alihaine.swingy.controller.hero.Hero;
import com.alihaine.swingy.view.ViewMode;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Gui extends ViewMode implements ActionListener {

    private final JFrame mainWindow = new JFrame();
    private final JPanel mainPanel = new JPanel();
    private final JPanel inputPanel = new JPanel();
    private final JPanel textPanel = new JPanel();

    public Gui() {
        this.InitWin();
    }

    public void InitWin() {
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.BLACK);

        this.InitMainPanel();
        this.InitInputPanel();
        this.InitTextPanel();

        mainWindow.setVisible(true);
    }

    private void InitMainPanel() {
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainWindow.add(scrollPane);
    }

    private void InitInputPanel() {
        List<JButton> buttons = Arrays.asList(new JButton("Up"), new JButton("Down"), new JButton("Left"), new JButton("Right"), new JButton("Keep"), new JButton("Leave"), new JButton("Fight"), new JButton("Run"), new JButton("Exit"));

        buttons.forEach(button -> {
            button.addActionListener(this);
            inputPanel.add(button);
        });
        mainWindow.add(inputPanel, BorderLayout.SOUTH);
    }

    private void InitTextPanel() {
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        JLabel textLabel1 = new JLabel();
        textLabel1.setForeground(Color.WHITE);
        JLabel textLabel2 = new JLabel();
        textLabel2.setForeground(Color.WHITE);
        textLabel1.setBorder(new LineBorder(Color.white, 1));
        textLabel2.setBorder(new LineBorder(Color.white, 1));
        textPanel.add(textLabel1);
        textPanel.add(textLabel2);
        textPanel.setBackground(Color.darkGray);
        mainWindow.add(textPanel, BorderLayout.EAST);
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
        mainPanel.setPreferredSize(new Dimension(mapSize*64, mapSize*64));
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                this.DisplayToPosition(x * 64, y * 64, new JLabel(Images.images.getImageIconFromPath("ground")));
            }
        }
    }

    @Override
    public void DisplayPlayerInfos(Hero hero) {
        JLabel label = (JLabel) textPanel.getComponent(0);
        label.setText(String.format("<HTML>Hero name %s, with the champ %s<BR>Level: %d with %d exp<BR>Stats: Attack: %d | Defense: %d | HP: %d</HTML>", hero.getName(), hero.getChamp(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefense(), hero.getHitPoint()));
    }

    @Override
    public boolean IsOutOfTheMap(int x, int y) {
        int mapSize = GameLoop.gameLoop.getCurrentMap().getCurrentMapSize();
        if (x < 0 || y < 0 || x / 64 >= mapSize || y / 64 >= mapSize)
            return true;
        return false;
    }

    public void DisplayFight(List<String> logs) {
        StringBuilder logsToDisplay = new StringBuilder("<HTML>");
        for (String line : logs)
            logsToDisplay.append(line + "<BR>");
        logsToDisplay.append("</HTML>");
        JLabel label = (JLabel) textPanel.getComponent(1);
        label.setText(logsToDisplay.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x, y, stats;
        JLabel heroImage = GameLoop.gameLoop.getCurrentHero().getImage();
        x = heroImage.getX();
        y = heroImage.getY();
        stats = GameLoop.gameLoop.stats;
        if (e.getActionCommand().equals("Up") && stats == 0)
            y -= 64;
        else if (e.getActionCommand().equals("Down") && stats == 0)
            y += 64;
        else if (e.getActionCommand().equals("Right") && stats == 0)
            x += 64;
        else if (e.getActionCommand().equals("Left") && stats == 0)
            x -= 64;
        else if (e.getActionCommand().equals("Exit"))
            System.exit(0);
        else if (e.getActionCommand().equals("Keep") && stats == 3)
            GameLoop.gameLoop.KeepArtifact();
        else if (e.getActionCommand().equals("Leave") && stats == 3)
            GameLoop.gameLoop.LeaveArtifact();
        else if (e.getActionCommand().equals("Fight") && stats == 1)
            GameLoop.gameLoop.LaunchFight();
        else if (e.getActionCommand().equals("Run") && stats == 1)
            GameLoop.gameLoop.TryToRun();

        if (this.IsOutOfTheMap(x, y))
            GameLoop.gameLoop.PlayerWinMap();
        else {
            this.DisplayToPosition(x, y, heroImage);
            GameLoop.gameLoop.PlayerMoveTrigger();
        }
    }
}
