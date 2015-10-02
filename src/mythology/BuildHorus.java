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
public class BuildHorus extends BuildCard {

	public BuildHorus(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
	}

	private List<String> options = Arrays.asList("Yes", "No");
	private int index = 0;
	private Random random = new Random();
	private String building;
	private List<String> buildingUnique = new ArrayList<String>();

	public void play() {

		BuildingTile[] buildings = player.getBuildingTiles();
		boolean flag = false;
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null
					&& buildings[i].getBuildingType().equals("House")) {
				if (!flag) {
					flag = true;
					buildingUnique.add(buildings[i].getBuildingType());
				} else {
					continue;
				}
			} else if (buildings[i] != null) {
				buildingUnique.add(buildings[i].getBuildingType());
			}
		}

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
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			dialog();

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
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			if (buildingUnique.size() != 0) {
				index = random.nextInt(buildingUnique.size());
				for (int i = 0; i < buildings.length; i++) {
					if (buildings[i] != null
							&& buildings[i].getBuildingType().equals(
									buildingUnique.get(index))) {
						buildings[i] = null;
						updatePlayer(buildingUnique.get(index));
						imageManipulator.redrawImage(playerBoard, player);
						break;
					}
				}
			}
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

	private void dialog() {
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
		JLabel label = new JLabel();
		label.setText("Select a building to destroy");
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.ipady = 10;
		panel.add(label, constraint);
		JRadioButton rButton;
		for (int i = 0; i < buildingUnique.size(); i++) {
			count++;
			constraint.gridx = 0;
			constraint.gridy = count;

			rButton = new JRadioButton(buildingUnique.get(i));
			panel.add(rButton, constraint);
			buttonGroup.add(rButton);

			rButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					building = ((JRadioButton) e.getSource()).getText();
				}
			});
		}
		JButton button = new JButton("Eliminate building");
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.gridx = 0;
		constraint.gridy = count + 1;
		constraint.ipady = 0;
		constraint.insets = new Insets(10, 0, 0, 0);
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
				BuildingTile[] buildings = player.getBuildingTiles();
				for (int i = 0; i < buildings.length; i++) {
					if (buildings[i] != null
							&& buildings[i].getBuildingType().equals(building)) {
						buildingDialog.getContentPane().add(
								buildings[i].getLabel());
						buildings[i] = null;
						buildingDialog.revalidate();
						buildingDialog.repaint();
						imageManipulator.redrawImage(playerBoard, player);
						updatePlayer(building);
						break;
					}
				}
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

	private void updatePlayer(String building) {
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
