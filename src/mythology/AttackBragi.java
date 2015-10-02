package mythology;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AttackBragi extends AttackCard {
	public AttackBragi(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
	}

	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			int reply = JOptionPane.showConfirmDialog(null,
					"Cost to play god power is 2 favor cubes. Continue?",
					"Pay 2 favor", JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.NO_OPTION) {
				reply = JOptionPane
						.showConfirmDialog(
								null,
								"Do you want to perform the action specified on the card?",
								"Perform Action", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					super.play();
					return;
				} else {
					setHumanPlayed(true);
					return;
				}
			} else if (player.getFavor() < 1) {
				JOptionPane
						.showMessageDialog(null,
								"You don't have sufficient resources to play god power!");
				return;
			}
			player.setFavor(player.getFavor() - 2);
			imageManipulator.redrawImage(playerBoard, player);
			extraDice = 1;
			playerRole = "Human";
			reply = JOptionPane.showConfirmDialog(null,
					"Do you want to perform the action specified on the card?",
					"Perform Action", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				super.play();
				return;
			} else {
				setHumanPlayed(true);
				return;
			}

		} else {
			int index = 0;
			List<String> options = Arrays.asList("Yes", "No");
			index = new Random().nextInt(options.size());
			if (options.get(index).equals("No")) {
				index = new Random().nextInt(options.size());
				if (options.get(index).equals("Yes")) {
					super.play();
					return;
				} else {
					setAi1Played(true);
					return;
				}
			}
			player.setFavor(player.getFavor() - 2);
			imageManipulator.redrawImage(playerBoard, player);
			extraDice = 2;
			playerRole = "AI";
			index = new Random().nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
				return;
			} else {
				setAi1Played(true);
				return;
			}
		}
	}

}
