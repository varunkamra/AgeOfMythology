package mythology;

import javax.swing.JLabel;

public class TerrianTile {
	private JLabel label;
	private String TerrianType;
	private int wood = 0;
	private int gold = 0;
	private int favor = 0;
	private int food = 0;

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public String getTerrianType() {
		return TerrianType;
	}

	public void setTerrianType(String terrianType) {
		TerrianType = terrianType;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getFavor() {
		return favor;
	}

	public void setFavor(int favor) {
		this.favor = favor;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
}
