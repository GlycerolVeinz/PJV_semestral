package goblinoverflow.gui.panels;

import goblinoverflow.gui.panels.buttons.EntityButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BottomButtonPanel extends JPanel
{
    final int buttonsCount = 4;
    private ArrayList<EntityButton> buttons = new ArrayList<>();

    public BottomButtonPanel(Color color, GamePanel gamePanel)
    {
        this.setLayout(new GridLayout(1, buttonsCount));
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(color);

        EntityButton humanButton = new EntityButton("add Human", this, gamePanel);
        EntityButton zombieButton = new EntityButton("add Zombie", this, gamePanel);
        EntityButton skellyButton = new EntityButton("add Skelly", this, gamePanel);
        EntityButton wolfButton = new EntityButton("add Wolf", this, gamePanel);

        humanButton.setName("human");
        zombieButton.setName("zombie");
        skellyButton.setName("skeleton");
        wolfButton.setName("wolf");

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
