package mythology;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GatherRa extends GatherCard {

	public GatherRa(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	boolean playGodPower = true;

	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			int reply = JOptionPane.showConfirmDialog(null,
					"Cost to play god power is 2 favor cubes. Continue?",
					"Pay 2 favor", JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.NO_OPTION) {
				playGodPower = false;
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
			} else if (player.getFavor() < 2) {
				JOptionPane
						.showMessageDialog(null,
								"You don't have sufficient resources to play god power!");
				return;
			}

			player.setFavor(player.getFavor() - 2);
			imageManipulator.redrawImage(playerBoard, player);
			extraFood = 2;
			super.play();
		} else {
			int index = 0;
			Random random = new Random();
			List<String> playCard = Arrays.asList("Yes", "No");
			index = random.nextInt(playCard.size());
			if (playCard.get(index).equals("No")) {
				playGodPower = false;
				index = random.nextInt(playCard.size());
				if (playCard.get(index).equals("Yes")) {
					super.play();
					return;
				} else {
					setTurn(player);
					return;
				}
			} else if (player.getFavor() < 2) {
				setTurn(player);
				return;
			}
			player.setFavor(player.getFavor() - 2);
			imageManipulator.redrawImage(playerBoard, player);
			super.play();
		}
	}

	@Override
	protected String getTerrianOrResourceTypeForAI() {
		List<String> options;
		if (playGodPower) {
			extraFood = 2;
			return "Food";

		} else {
			options = Arrays.asList("Fertile", "Forest", "Desert", "Hills",
					"Swamp", "Mountains", "Wood", "Food", "Favor", "Gold");
			Random random = new Random();
			int index;
			index = random.nextInt(options.size());
			return options.get(index);
		}
	}

	@Override
	protected void initializeRadioButtons() {
		rButton1 = new JRadioButton("Fertile");
		rButton2 = new JRadioButton("Forest");
		rButton3 = new JRadioButton("Desert");
		rButton4 = new JRadioButton("Hills");
		rButton5 = new JRadioButton("Swamp");
		rButton6 = new JRadioButton("Mountain");
		rButton7 = new JRadioButton("Wood");
		rButton8 = new JRadioButton("Food");
		rButton9 = new JRadioButton("Gold");
		rButton10 = new JRadioButton("Favor");

		if (playGodPower) {
			rButton1.setEnabled(false);
			rButton2.setEnabled(false);
			rButton3.setEnabled(false);
			rButton4.setEnabled(false);
			rButton5.setEnabled(false);
			rButton6.setEnabled(false);
			rButton7.setEnabled(false);
			rButton9.setEnabled(false);
			rButton10.setEnabled(false);
		}
	}

}
