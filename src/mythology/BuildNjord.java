package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class BuildNjord extends BuildCard {
	public BuildNjord(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private String building;
	private JRadioButton rButton;;
	private Player temp = null;

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
			String[] players = new String[2];
			if (player.getPlayerType().equals("Greek")) {
				players[0] = "Egyptian";
				players[1] = "Norse";
			} else if (player.getPlayerType().equals("Egyptian")) {
				players[0] = "Greek";
				players[1] = "Norse";
			} else if (player.getPlayerType().equals("Norse")) {
				players[0] = "Greek";
				players[1] = "Egyptian";
			}
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			String playerType = (String) JOptionPane.showInputDialog(this,
					"Selcect player for eliminating building", "Player Type",
					JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
			dialog(playerType);
		} else {
			int index = 0;
			Random random = new Random();
			List<String> options = Arrays.asList("Yes", "No");
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
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			List<String> opponent = null;
			if (player.getPlayerType().equals("Greek")) {
				opponent = Arrays.asList("Egyptian", "Norse");
			} else if (player.getPlayerType().equals("Egyptian")) {
				opponent = Arrays.asList("Greek", "Norse");
			} else if (player.getPlayerType().equals("Norse")) {
				opponent = Arrays.asList("Greek", "Egyptian");
			}
			index = new Random().nextInt(opponent.size());
			if (aiPlayer1.getPlayer().getPlayerType()
					.equals(opponent.get(index))) {
				temp = aiPlayer1.getPlayer();
			} else if (aiPlayer2.getPlayer().getPlayerType()
					.equals(opponent.get(index))) {
				temp = aiPlayer2.getPlayer();
			} else {
				temp = playerBoard.getHumanPlayer();
			}
			List<String> uniqueBuilding = getUniqueBuildings(temp);
			index = new Random().nextInt(uniqueBuilding.size());
			BuildingTile[] buildings = temp.getBuildingTiles();
			for (int i = 0; i < buildings.length; i++) {
				if (buildings[i] != null
						&& buildings[i].getBuildingType().equals(
								uniqueBuilding.get(index))) {
					updatePlayer(uniqueBuilding.get(index), temp);
					if (temp.getPlayerRole().equals("Human")) {
						buildingDialog.getContentPane().add(
								buildings[i].getLabel());
						buildingDialog.revalidate();
						buildingDialog.repaint();
					}
					buildings[i] = null;
					break;
				}
			}
			imageManipulator.redrawImage(playerBoard, temp);
			if (temp.getPlayerRole().equals("Human")) {
				JOptionPane.showMessageDialog(null, temp.getPlayerType()
						+ " player's building eliminated!");
			}
			index = random.nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
			} else {
				setTurn(player);
				return;
			}
		}

	}

	private List<String> getUniqueBuildings(Player player) {
		BuildingTile[] buildings = player.getBuildingTiles();
		boolean flags = false;
		List<String> buildingUnique = new ArrayList<String>();
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null
					&& buildings[i].getBuildingType().equals("House")) {
				if (!flags) {
					flags = true;
					buildingUnique.add(buildings[i].getBuildingType());
				} else {
					continue;
				}
			} else if (buildings[i] != null) {
				buildingUnique.add(buildings[i].getBuildingType());
			}
		}
		return buildingUnique;
	}

	private void dialog(String playerType) {
		final JDialog dialog = new JDialog();
		JPanel panel = new JPanel();
		dialog.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		ButtonGroup buttonGroup = new ButtonGroup();
		dialog.setSize(300, 300);
		x = (screenSize.width - dialog.getWidth()) / 2;
		y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
		int count = 0;
		if (aiPlayer1.getPlayer().getPlayerType().equals(playerType)) {
			temp = aiPlayer1.getPlayer();
		} else {
			temp = aiPlayer2.getPlayer();
		}
		JLabel label = new JLabel();
		label.setText("Select the building to destroy");
		List<String> uniqueBuildings = getUniqueBuildings(temp);
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridx = 0;
		constraint.gridy = 0;
		panel.add(label, constraint);
		for (int i = 0; i < uniqueBuildings.size(); i++) {
			rButton = new JRadioButton();
			rButton.setText(uniqueBuildings.get(i));
			buttonGroup.add(rButton);
			count++;
			constraint.gridx = 0;
			constraint.gridy = count;
			constraint.insets = new Insets(10, 0, 0, 0);
			panel.add(rButton, constraint);

			rButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					building = rButton.getText();
				}
			});
		}
		JButton button = new JButton("Eliminate building");
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.gridx = 0;
		constraint.gridy = count + 1;
		panel.add(button, constraint);
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				BuildingTile[] buildings = temp.getBuildingTiles();
				for (int i = 0; i < buildings.length; i++) {
					if (buildings[i] != null
							&& buildings[i].getBuildingType().equals(building)) {
						updatePlayer(building, temp);
						buildings[i] = null;
						break;
					}
				}
				imageManipulator.redrawImage(playerBoard, temp);
				JOptionPane.showMessageDialog(null, temp.getPlayerType()
						+ " player's building eliminated!");
				dialog.dispose();
				int reply = JOptionPane
						.showConfirmDialog(
								null,
								"Do you want to perform the action specified on the card?",
								"Perform Action", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					superPlay();
					return;
				} else {
					setTurn(player);
					return;
				}
			}
		});
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);

	}

	private void superPlay() {
		super.play();
	}

	private void updatePlayer(String building, Player player) {
		if (building.equals("House")) {
			player.housesBuilt -= 1;
		} else if (building.equals("Wall")) {
			player.wall = false;
		} else if (building.equals("Tower")) {
			player.tower = false;
		} else if (building.equals("Market")) {
			player.market = false;
		} else if (building.equals("Storehouse")) {
			player.storehouse = false;
		} else if (building.equals("Armory")) {
			player.armory = false;
		} else if (building.equals("Quarry")) {
			player.quarry = false;
		} else if (building.equals("Monument")) {
			player.monument = false;
		} else if (building.equals("Granary")) {
			player.granary = false;
		} else if (building.equals("Wood Workshop")) {
			player.woodWorkshop = false;
		} else if (building.equals("Gold Mint")) {
			player.goldMint = false;
		} else if (building.equals("Siege Engine Workshop")) {
			player.siegeWorkshop = false;
		} else if (building.equals("Great Temple")) {
			player.greatTemple = false;
		} else if (building.equals("The Wonder")) {
			player.wonder = false;
		}
	}
}
