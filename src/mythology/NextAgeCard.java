package mythology;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NextAgeCard extends ActionCard {

	public NextAgeCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		if (player.getAge().equals("Archaic")
				&& player.getWood() >= actionCard.getClassicalAgeCost()
				&& player.getFood() >= actionCard.getClassicalAgeCost()
				&& player.getFavor() >= actionCard.getClassicalAgeCost()
				&& player.getGold() >= actionCard.getClassicalAgeCost()) {
			player.setAge("Classical");
			player.setFood(player.getFood() - actionCard.getClassicalAgeCost());
			player.setWood(player.getWood() - actionCard.getClassicalAgeCost());
			player.setFavor(player.getFavor()
					- actionCard.getClassicalAgeCost());
			player.setGold(player.getGold() - actionCard.getClassicalAgeCost());
			imageManipulator.redrawImage(playerBoard, player);
			if (player.getPlayerRole().equals("Human")) {
				messageSuccess();
			} else {
				setTurn(player);
				return;
			}

		} else if (player.getAge().equals("Classical")
				&& player.getWood() >= actionCard.getHeroicAgeCost()
				&& player.getFood() >= actionCard.getHeroicAgeCost()
				&& player.getFavor() >= actionCard.getHeroicAgeCost()
				&& player.getGold() >= actionCard.getHeroicAgeCost()) {
			player.setAge("Heroic");
			player.setFood(player.getFood() - actionCard.getHeroicAgeCost());
			player.setWood(player.getWood() - actionCard.getHeroicAgeCost());
			player.setFavor(player.getFavor() - actionCard.getHeroicAgeCost());
			player.setGold(player.getGold() - actionCard.getHeroicAgeCost());
			imageManipulator.redrawImage(playerBoard, player);
			if (player.getPlayerRole().equals("Human")) {
				messageSuccess();
			} else {
				setTurn(player);
				return;
			}
		} else if (player.getAge().equals("Heroic")
				&& player.getWood() >= actionCard.getMythicAgeCost()
				&& player.getFood() >= actionCard.getMythicAgeCost()
				&& player.getFavor() >= actionCard.getMythicAgeCost()
				&& player.getGold() >= actionCard.getMythicAgeCost()) {
			player.setAge("Mythic");
			player.setFood(player.getFood() - actionCard.getMythicAgeCost());
			player.setWood(player.getWood() - actionCard.getMythicAgeCost());
			player.setFavor(player.getFavor() - actionCard.getMythicAgeCost());
			player.setGold(player.getGold() - actionCard.getMythicAgeCost());
			imageManipulator.redrawImage(playerBoard, player);
			if (player.getPlayerRole().equals("Human")) {
				messageSuccess();
			} else {
				setTurn(player);
				return;
			}
		} else {
			if (player.getPlayerRole().equals("Human")) {
				messageFailure();
			}

		}
		if (player.getPlayerRole().equals("Human")) {
			setTurn(player);
			return;
		} else {
			setTurn(player);
			return;
		}
	}

	private void messageFailure() {
		JOptionPane.showMessageDialog(null,
				"You don't have sufficient resources!");
	}

	private void messageSuccess() {
		JOptionPane.showMessageDialog(null,
				"You have advanced to the next age!");
	}

}
