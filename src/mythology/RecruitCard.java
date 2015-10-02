package mythology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class RecruitCard extends ActionCard {
	public RecruitCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	RecruitCard recruitCard;

	@Override
	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			if (player.getPlayerType().equals("Greek")) {

				recruitCard = new RecruitCardGreek(resources, playerBoard,
						buildingDialog, actionCard);
				new Observer1(aiPlayer1, aiPlayer2, recruitCard);
				new Observer2(aiPlayer1, aiPlayer2, recruitCard);
			} else if (player.getPlayerType().equals("Egyptian")) {
				recruitCard = new RecruitCardEgyptian(resources, playerBoard,
						buildingDialog, actionCard);
				new Observer1(aiPlayer1, aiPlayer2, recruitCard);
				new Observer2(aiPlayer1, aiPlayer2, recruitCard);
			} else {
				recruitCard = new RecruitCardNorse(resources, playerBoard,
						buildingDialog, actionCard);
				new Observer1(aiPlayer1, aiPlayer2, recruitCard);
				new Observer2(aiPlayer1, aiPlayer2, recruitCard);
			}
		} else {
			List<String> battleUnits = new ArrayList<String>();
			List<String> options = Arrays.asList("Yes", "No");
			for (String unit : player.battleCards.keySet()) {
				if (unit != null) {
					battleUnits.add(unit);
				}
			}
			for (int i = 0; i < actionCard.getNumber(); i++) {
				int index = 0;
				for (int j = 0; j < battleUnits.size(); j++) {
					index = new Random().nextInt(battleUnits.size());
					BattleCard battleCard = player.battleCards.get(battleUnits
							.get(index));
					if (battleUnits.get(index).endsWith("Hero")
							&& player.getAge().equals("Archaic")) {
						continue;
					}
					if (player.getFood() >= battleCard.getFoodCost()
							&& player.getFavor() >= battleCard.getFavorCost()
							&& player.getWood() >= battleCard.getWoodCost()
							&& player.getGold() >= battleCard.getGoldCost()) {
						player.militaryUnits.add(battleUnits.get(index));
						player.setFood(player.getFood()
								- battleCard.getFoodCost());
						playerBoard.foodBank += battleCard.getFoodCost();
						player.setFavor(player.getFavor()
								- battleCard.getFavorCost());
						playerBoard.favorBank += battleCard.getFavorCost();
						player.setWood(player.getWood()
								- battleCard.getWoodCost());
						playerBoard.woodBank += battleCard.getWoodCost();
						player.setGold(player.getGold()
								- battleCard.getGoldCost());
						playerBoard.goldBank += battleCard.getGoldCost();
						break;
					}
				}
				if (actionCard.getNumber() > 1) {
					index = new Random().nextInt(options.size());
					if (options.get(index).equals("No")) {
						break;
					}
				}
			}
			imageManipulator.redrawImage(playerBoard, player);
			setTurn(player);
		}

	}

}
