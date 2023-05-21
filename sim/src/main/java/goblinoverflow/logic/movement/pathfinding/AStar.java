package goblinoverflow.logic.movement.pathfinding;

import goblinoverflow.Simulation;
import goblinoverflow.entities.tiles.Tile;

import java.util.ArrayList;

public class AStar {
	private ArrayList<Tile> openList;
	private ArrayList<Tile> closedList;
	private ArrayList<Tile> map;
	private Tile start;
	private Tile end;

	public AStar(ArrayList<Tile> map, Tile start, Tile end) {
		this.openList = new ArrayList<>();
		this.closedList = new ArrayList<>();
		this.map = map;
		this.start = start;
		this.end = end;
	}

	public ArrayList<Tile> findPath() {
//		most of this method was generated by GitHub Copilot
		openList.add(start);
		while (!openList.isEmpty()) {
			Tile current = openList.get(0);
			for (Tile tile : openList) {
				if (tile.getF() < current.getF()) {
					current = tile;
				}
			}
			openList.remove(current);
			closedList.add(current);
			if (current == end) {
				return reconstructPath(current);
			}
			for (Tile neighbor : Simulation.getGameMap().getNeighbours(current)) {
				if (neighbor == null || closedList.contains(neighbor)) {
					continue;
				}
				int tentativeG = current.getG() + 1;
				if (!openList.contains(neighbor) || tentativeG < neighbor.getG()) {
					neighbor.setG(tentativeG);
					neighbor.setH(neighbor.getDistance(end));
					neighbor.setF(neighbor.getG() + neighbor.getH());
					neighbor.setParent(current);
					if (!openList.contains(neighbor)) {
						openList.add(neighbor);
					}
				}
			}
		}

		return null;
	}

	private ArrayList<Tile> reconstructPath(Tile current) {
		ArrayList<Tile> path = new ArrayList<>();
		while (current != null) {
			path.add(current);
			current = current.getParent();
		}
		return path;
	}
}
