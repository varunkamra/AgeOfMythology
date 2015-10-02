package mythology;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NextAgeOdin extends NextAgeCard {
	private Random random = new Random();
	private List<String> options = Arrays.asList("Yes", "No");

	public NextAgeOdin(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
	}

	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			int reply = JOptionPane.showConfirmDialog(null,
					"Cost to play god power is 1 favor cubes. Continue?",
					"Pay 1 favor", JOptionPane.YES_NO_OPTION);

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
					setTurn(player);
					return;
				}
			} else if (player.getFavor() < 1) {
				JOptionPane
						.showMessageDialog(null,
								"You don't have sufficient resources to play god power!");
				setTurn(player);
				return;
			}
			PlayerHandDialog.cardsAllowed = 4;
		} else {
			int index = random.nextInt(options.size());
			if (options.get(index).equals("No")) {
				index = random.nextInt(options.size());
				if (options.get(index).equals("Yes")) {
					super.play();
					return;
				} else {
					setTurn(player);
					return;
				}
			} else if (player.getFavor() < 1) {
				setTurn(player);
				return;
			}
			if (player.getPlayerType().equals(
					aiPlayer1.getPlayer().getPlayerType())) {
				aiPlayer1.odin = true;
			} else {
				aiPlayer2.odin = true;
			}
		}
		player.setFavor(player.getFavor() - 1);
		imageManipulator.redrawImage(playerBoard, player);
		if (player.getPlayerRole().equals("Human")) {
			int reply = JOptionPane.showConfirmDialog(null,
					"Do you want to perform the action specified on the card?",
					"Perform Action", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				super.play();
				return;
			} else {
				setTurn(player);
				return;
			}
		} else {
			int index = random.nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
			} else {
				setTurn(player);
				return;
			}
		}
	}

}
