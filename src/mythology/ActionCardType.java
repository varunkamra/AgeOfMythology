package mythology;

import java.awt.image.BufferedImage;

public class ActionCardType {
	private BufferedImage image;
	private String cardType;
	private int number;
	private String god;
	private int classicalAgeCost;
	private int heroicAgeCost;
	private int mythicAgeCost;

	public ActionCardType() {
		cardType = null;
		number = 0;
		god = null;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getGod() {
		return god;
	}

	public void setGod(String god) {
		this.god = god;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getClassicalAgeCost() {
		return classicalAgeCost;
	}

	public void setClassicalAgeCost(int classicalAgeCost) {
		this.classicalAgeCost = classicalAgeCost;
	}

	public int getHeroicAgeCost() {
		return heroicAgeCost;
	}

	public void setHeroicAgeCost(int heroicAgeCost) {
		this.heroicAgeCost = heroicAgeCost;
	}

	public int getMythicAgeCost() {
		return mythicAgeCost;
	}

	public void setMythicAgeCost(int mythicAgeCost) {
		this.mythicAgeCost = mythicAgeCost;
	}
}
