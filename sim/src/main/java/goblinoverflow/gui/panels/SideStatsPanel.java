package goblinoverflow.gui.panels;

import goblinoverflow.entities.creatures.Creature;

import javax.swing.*;
import java.awt.*;

/**
 * Panel class that displays statistics about the simulation (number of creatures)
 */
public class SideStatsPanel extends JPanel {
	private final JLabel goblinCount;
	private final JLabel humanCount;
	private final JLabel wolfCount;
	private final JLabel zombieCount;
	private final JLabel skeletonCount;

	/**
	 * SideStatsPanel constructor.
	 * Creates panel and adds labels to it (text with stats).
	 *
	 * @param color - background-color of the panel
	 */
	public SideStatsPanel(Color color) {
		this.setPreferredSize(new Dimension(150, 100));
		this.setBackground(color);

		JLabel goblinCount = new JLabel("Goblin count: " + Creature.getGoblinCount());
		this.goblinCount = goblinCount;
		goblinCount.setForeground(Color.WHITE);
		this.add(goblinCount);

		JLabel humanCount = new JLabel("Human count: " + Creature.getHumanCount());
		this.humanCount = humanCount;
		humanCount.setForeground(Color.WHITE);
		this.add(humanCount);

		JLabel wolfCount = new JLabel("Wolf count: " + Creature.getWolfCount());
		this.wolfCount = wolfCount;
		wolfCount.setForeground(Color.WHITE);
		this.add(wolfCount);

		JLabel zombieCount = new JLabel("Zombie count: " + Creature.getZombieCount());
		this.zombieCount = zombieCount;
		zombieCount.setForeground(Color.WHITE);
		this.add(zombieCount);

		JLabel skeletonCount = new JLabel("Orc count: " + Creature.getSkeletonCount());
		this.skeletonCount = skeletonCount;
		skeletonCount.setForeground(Color.WHITE);
		this.add(skeletonCount);
	}

	public JLabel getGoblinCount() {
		return goblinCount;
	}
	public JLabel getHumanCount() {
		return humanCount;
	}
	public JLabel getWolfCount() {
		return wolfCount;
	}
	public JLabel getZombieCount() {
		return zombieCount;
	}
	public JLabel getSkeletonCount() {
		return skeletonCount;
	}

	/**
	 * Updates the text of the labels with current stats.
	 */
	public void updateCounts(){
		getGoblinCount().setText("Goblin count: " + Creature.getGoblinCount());
		getHumanCount().setText("Human count: " + Creature.getHumanCount());
		getWolfCount().setText("Wolf count: " + Creature.getWolfCount());
		getZombieCount().setText("Zombie count: " + Creature.getZombieCount());
		getSkeletonCount().setText("Skeleton count: " + Creature.getSkeletonCount());
	}
}
