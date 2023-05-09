package goblinoverflow.gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BottomButtonPanel extends JPanel
{
    final int buttonsCount = 8;

    public BottomButtonPanel(Color color)
    {
        this.setLayout(new GridLayout(1, buttonsCount));
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(color);

        JButton humanButton = new JButton("add Human");
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(humanButton);
        JButton zombieButton = new JButton("add Zombie");
        buttons.add(zombieButton);
        JButton skellyButton = new JButton("add Skelly");
        buttons.add(skellyButton);
        JButton wolfButton = new JButton("add Wolf");
        buttons.add(wolfButton);

        for (JButton button : buttons) {
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
            this.add(button);
        }

    }
}
