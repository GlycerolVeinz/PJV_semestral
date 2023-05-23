package goblinoverflow.gui.panels;

import goblinoverflow.entities.creatures.CreatureType;
import goblinoverflow.gui.panels.buttons.EntityButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BottomButtonPanel extends JPanel
{
    final static int BUTTONS_COUNT = 4;
    private ArrayList<EntityButton> buttons = new ArrayList<>();

    public BottomButtonPanel(Color color, GamePanel gamePanel)
    {
        this.setLayout(new GridLayout(1, BUTTONS_COUNT));
        this.setPreferredSize(new Dimension(100, 50));
        this.setBackground(color);

        EntityButton humanButton = new EntityButton("add Human", this, gamePanel);
        EntityButton zombieButton = new EntityButton("add Zombie", this, gamePanel);
        EntityButton skellyButton = new EntityButton("add Skelly", this, gamePanel);
        EntityButton wolfButton = new EntityButton("add Wolf", this, gamePanel);

        humanButton.setCreatureType(CreatureType.HUMAN);
        zombieButton.setCreatureType(CreatureType.ZOMBIE);
        skellyButton.setCreatureType(CreatureType.SKELETON);
        wolfButton.setCreatureType(CreatureType.WOLF);

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
