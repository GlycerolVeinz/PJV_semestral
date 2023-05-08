package goblinoverflow.gui;

import goblinoverflow.gui.panels.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    public Interface(String title){
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
