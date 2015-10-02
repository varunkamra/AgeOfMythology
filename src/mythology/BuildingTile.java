package mythology;

import javax.swing.JLabel;

public class BuildingTile {
	private String buildingType;
	private JLabel label;
	private int foodCost = 0;
	private int favorCost = 0;
	private int woodCost = 0;
	private int goldCost = 0;

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public int getFoodCost() {
		return foodCost;
	}

	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}

	public int getFavorCost() {
		return favorCost;
	}

	public void setFavorCost(int favorCost) {
		this.favorCost = favorCost;
	}

	public int getWoodCost() {
		return woodCost;
	}

	public void setWoodCost(int woodCost) {
		this.woodCost = woodCost;
	}

	public int getGoldCost() {
		return goldCost;
	}

	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}
}
