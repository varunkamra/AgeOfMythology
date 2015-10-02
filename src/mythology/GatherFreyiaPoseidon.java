package mythology;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GatherFreyiaPoseidon extends GatherCard {

	public GatherFreyiaPoseidon(ResourceDialog resource,
			PlayerBoard playerBoard, BuildingTileDialog buildingDialog,
			ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
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
				return;
			}
		} else {
			int index = 0;
			Random random = new Random();
			List<String> options = Arrays.asList("Yes", "No");
			index = random.nextInt(options.size());
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
		}
		player.setFavor(player.getFavor() - 1);
		imageManipulator.redrawImage(playerBoard, player);
		if (actionCard.getGod().equals("Freyia")) {
			gainGold = 5;
		} else if (actionCard.getGod().equals("Poseidon")) {
			gainFood = 5;
		}
		super.play();
	}

}