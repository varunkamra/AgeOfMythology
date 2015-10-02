package mythology;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class BuildHera extends BuildCard {
	public BuildHera(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private List<String> options = Arrays.asList("Yes", "No");
	private int index = 0;
	private Random random = new Random();

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
			options = Arrays.asList("Yes", "No");
			index = random.nextInt(options.size());
			if (options.get(index).equals("No")) {
				index = new Random().nextInt(options.size());
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
		if (player.housesBuilt <= 9) {
			player.housesBuilt += 1;
			BuildingTile tile = buildingDialog.getBuildingTiles().get("House");
			BuildingTile[] buildingTiles = player.getBuildingTiles();
			for (int i = 0; i < buildingTiles.length; i++) {
				if (buildingTiles[i] == null) {
					buildingTiles[i] = tile;
					imageManipulator.repaint(tile, playerBoard, player, i);
					imageManipulator.redrawImage(playerBoard, player);
					break;
				}
			}
		}
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
			index = new Random().nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
				return;
			} else {
				setTurn(player);
				return;
			}
		}

	}
}
