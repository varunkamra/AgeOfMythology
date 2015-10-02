package mythology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;

public class BattleCard {
	private JLabel battleCard;
	private int numberOfDice = 0;
	private HashMap<String, Integer> extraDice;
	private List<String> unitType;
	private String unitClass;
	private int foodCost = 0;
	private int favorCost = 0;
	private int woodCost = 0;
	private int goldCost = 0;

	public BattleCard() {
		setUnitType(new ArrayList<String>());
		setBattleCard(new JLabel());
		setExtraDice(new HashMap<String, Integer>());
	}

	public JLabel getBattleCard() {
		return battleCard;
	}

	public void setBattleCard(JLabel battleCard) {
		this.battleCard = battleCard;
	}

	public int getNumberOfDice() {
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	public HashMap<String, Integer> getExtraDice() {
		return extraDice;
	}

	public void setExtraDice(HashMap<String, Integer> extraDice) {
		this.extraDice = extraDice;
	}

	public String getUnitClass() {
		return unitClass;
	}

	public void setUnitClass(String unitClass) {
		this.unitClass = unitClass;
	}

	public List<String> getUnitType() {
		return unitType;
	}

	public void setUnitType(List<String> unitType) {
		this.unitType = unitType;
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
