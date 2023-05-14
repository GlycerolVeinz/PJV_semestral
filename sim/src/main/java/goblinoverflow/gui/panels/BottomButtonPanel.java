package goblinoverflow.gui.panels;

import goblinoverflow.gui.panels.buttons.EntityButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BottomButtonPanel extends JPanel
{
    final int buttonsCount = 4;
    private ArrayList<EntityButton> buttons = new ArrayList<>();

    public BottomButtonPanel(Color color)
    {
        this.setLayout(new GridLayout(1, buttonsCount));
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(color);

        EntityButton humanButton = new EntityButton("add Human", this);
        EntityButton zombieButton = new EntityButton("add Zombie", this);
        EntityButton skellyButton = new EntityButton("add Skelly", this);
        EntityButton wolfButton = new EntityButton("add Wolf", this);

        buttons.add(humanButton);
        buttons.add(zombieButton);
        buttons.add(wolfButton);
        buttons.add(skellyButton);

        for (JButton button : buttons) {
            this.add(button);
        }
    }

    public ArrayList<EntityButton> getButtons() {
        return buttons;
    }
}
