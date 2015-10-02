package mythology;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NextAgeZeus extends NextAgeCard {
	private Random random = new Random();
	private List<String> options = Arrays.asList("Yes", "No");

	public NextAgeZeus(ResourceDialog resource, PlayerBoard playerBoard,
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
					return;
				}
			} else {
				if (player.getAge().equals("Archaic")) {
					JOptionPane
							.showMessageDialog(null,
									"You have to advance to next age to use this god power!");
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
				}
				if (player.getFavor() < 2) {

					JOptionPane
							.showMessageDialog(null,
									"You don't have sufficient resources to play god power!");
					setTurn(player);
					return;
				}
			}
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
			} else {
				if (player.getAge().equals("Archaic")) {
					index = random.nextInt(options.size());
					if (options.get(index).equals("Yes")) {
						super.play();
						return;
					} else {
						setTurn(player);
						return;
					}
				}
				if (player.getFavor() < 2) {
					setTurn(player);
					return;
				}
			}
		}
		player.setFavor(player.getFavor() - 2);
		imageManipulator.redrawImage(playerBoard, player);

		if (player.getAge().equals("Classical")) {
			player.militaryUnits.add("Classical Greek Hero");
		} else if (player.getAge().equals("Heroic")) {
			player.militaryUnits.add("Heroic Greek Hero");
		} else {
			player.militaryUnits.add("Mythical Greek Hero");
		}
		if (player.getPlayerRole().equals("Human")) {
			JOptionPane.showMessageDialog(null,
					"You have gained a hero from your current age!");
			int reply = JOptionPane.showConfirmDialog(null,
					"Do you want to perform the action specified on the card?",
					"Perform Action", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				super.play();
			} else {
				setTurn(player);
				return;
			}
		}
		imageManipulator.redrawImage(playerBoard, player);

	}

}
