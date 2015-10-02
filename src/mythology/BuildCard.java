package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class BuildCard extends ActionCard {
	public BuildCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private JRadioButton rButton1;
	private JRadioButton rButton2;
	private JRadioButton rButton3;
	private JRadioButton rButton4;
	private JRadioButton rButton5;
	private JRadioButton rButton6;
	private JRadioButton rButton7;
	private JRadioButton rButton8;
	private JRadioButton rButton9;
	private JRadioButton rButton10;
	private JRadioButton rButton11;
	private JRadioButton rButton12;
	private JRadioButton rButton13;
	private JRadioButton rButton14;
	private JButton button;
	private ButtonGroup buttonGroup;
	private BuildCard buildCard = null;
	private BuildingTile[] buildingTiles = null;
	public static int buildingCreated = 0;
	private int previousCount = 0;
	protected HashMap<String, BuildingTile> buildings = buildingDialog
			.getBuildingTiles();

	@Override
	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			setTitle("Build");
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setSize(300, 550);
			x = (screenSize.width - this.getWidth()) / 2;
			y = (screenSize.height - this.getHeight()) / 2;
			setLocation(x, y);
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			buildCard = this;
			buildingTiles = player.getBuildingTiles();
			rButton1 = new JRadioButton("House");
			rButton2 = new JRadioButton("Wall");
			rButton3 = new JRadioButton("Tower");
			rButton4 = new JRadioButton("Market");
			rButton5 = new JRadioButton("Storehouse");
			rButton6 = new JRadioButton("Armory");
			rButton7 = new JRadioButton("Quarry");
			rButton8 = new JRadioButton("Monument");
			rButton9 = new JRadioButton("Granary");
			rButton10 = new JRadioButton("Wood Workshop");
			rButton11 = new JRadioButton("Gold Mint");
			rButton12 = new JRadioButton("Siege Engine Workshop");
			rButton13 = new JRadioButton("Great Temple");
			rButton14 = new JRadioButton("The Wonder");
			button = new JButton("Build");
			buttonGroup = new ButtonGroup();

			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.ipady = 5;
			constraints.anchor = GridBagConstraints.LINE_START;
			constraints.insets = new Insets(10, 0, 10, 0);
			JLabel label = new JLabel("Select building(s) to create");
			panel.add(label, constraints);

			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.ipady = 5;
			constraints.insets = new Insets(0, 0, 0, 0);
			panel.add(rButton1, constraints);
			buttonGroup.add(rButton1);
			constraints.gridx = 0;
			constraints.gridy = 2;
			panel.add(rButton2, constraints);
			buttonGroup.add(rButton2);
			constraints.gridx = 0;
			constraints.gridy = 3;
			panel.add(rButton3, constraints);
			buttonGroup.add(rButton3);
			constraints.gridx = 0;
			constraints.gridy = 4;

			panel.add(rButton4, constraints);
			buttonGroup.add(rButton4);
			constraints.gridx = 0;
			constraints.gridy = 5;
			panel.add(rButton5, constraints);
			buttonGroup.add(rButton5);
			constraints.gridx = 0;
			constraints.gridy = 6;
			panel.add(rButton6, constraints);
			buttonGroup.add(rButton6);

			constraints.gridx = 0;
			constraints.gridy = 7;
			panel.add(rButton7, constraints);
			buttonGroup.add(rButton7);
			constraints.gridx = 0;
			constraints.gridy = 8;
			panel.add(rButton8, constraints);
			buttonGroup.add(rButton8);
			constraints.gridx = 0;
			constraints.gridy = 9;
			panel.add(rButton9, constraints);
			buttonGroup.add(rButton9);
			constraints.gridx = 0;
			constraints.gridy = 10;
			panel.add(rButton10, constraints);
			buttonGroup.add(rButton10);
			constraints.gridx = 0;
			constraints.gridy = 11;
			panel.add(rButton11, constraints);
			buttonGroup.add(rButton11);
			constraints.gridx = 0;
			constraints.gridy = 12;
			panel.add(rButton12, constraints);
			buttonGroup.add(rButton12);
			constraints.gridx = 0;
			constraints.gridy = 13;
			panel.add(rButton13, constraints);
			buttonGroup.add(rButton13);
			constraints.gridx = 0;
			constraints.gridy = 14;
			panel.add(rButton14, constraints);
			buttonGroup.add(rButton14);
			constraints.gridx = 0;
			constraints.gridy = 15;
			constraints.anchor = GridBagConstraints.CENTER;
			constraints.insets = new Insets(10, 0, 10, 0);
			panel.add(button, constraints);

			this.setContentPane(panel);

			this.setVisible(true);
			listener();
		} else {
			Random random = new Random();
			int index = 0;
			List<String> buildingsList = new ArrayList<String>(Arrays.asList(
					"House", "Wall", "Tower", "Market", "Storehouse", "Armory",
					"Quarry", "Monument", "Granary", "Wood Workshop",
					"Gold Mint", "Siege Engine Workshop", "Great Temple",
					"The Wonder"));
			List<String> options = Arrays.asList("Yes", "No");
			boolean flag = false;
			BuildingTile tile = null;
			for (int i = 0; i < actionCard.getNumber(); i++) {
				flag = false;
				tile = new BuildingTile();
				for (int j = 0; j < buildingsList.size(); j++) {
					index = random.nextInt(buildingsList.size());
					tile = buildings.get(buildingsList.get(index));
					if (player.getWood() >= tile.getWoodCost()
							&& player.getFood() >= tile.getFoodCost()
							&& player.getGold() >= tile.getGoldCost()
							&& player.getFavor() >= tile.getFavorCost()) {
						if (checkUniqueness(buildingsList.get(index))) {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					BuildingTile[] buildingTiles = player.getBuildingTiles();
					for (int j = 0; j < 4; j++) {
						if (buildingTiles[j] == null) {
							buildingTiles[j] = tile;
							player.setFood(player.getFood()
									- tile.getFoodCost());
							player.setFavor(player.getFavor()
									- tile.getFavorCost());
							player.setWood(player.getWood()
									- tile.getWoodCost());
							player.setGold(player.getGold()
									- tile.getGoldCost());
							imageManipulator.repaint(tile, playerBoard, player,
									j);
							imageManipulator.redrawImage(playerBoard, player);
							if (!buildingsList.get(index).equals("House")) {
								buildingsList.remove(buildingsList.get(index));
							}
							updatePlayer(buildingsList.get(index));
							break;
						}
					}
				}
				index = new Random().nextInt(options.size());
				if (options.get(index).equals("No")) {
					break;

				}
			}
			setTurn(player);
		}

	}

	public void listener() {
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				BuildingTile tile;
				previousCount = buildingCreated;
				if (buildingCreated == actionCard.getNumber()) {
					messageFailure();
					buildCard.dispose();
					return;
				} else {
					if (rButton1.isSelected()) {
						tile = buildings.get("House");
						if (player.getFood() >= tile.getFoodCost()
								&& player.getWood() >= tile.getWoodCost()) {
							for (int i = 0; i < buildingTiles.length; i++) {
								if (buildingTiles[i] == null
										&& player.housesBuilt <= 9) {
									buildingTiles[i] = tile;
									imageManipulator.repaint(tile, playerBoard,
											player, i);
									player.setBuildingTiles(buildingTiles);
									player.housesBuilt++;
									player.setFood(player.getFood()
											- tile.getFoodCost());
									player.setWood(player.getWood()
											- tile.getWoodCost());
									imageManipulator.redrawImage(playerBoard,
											player);
									if (player.housesBuilt == 10) {
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
									}

									buildingCreated++;
									if (buildingCreated < actionCard
											.getNumber()) {
										buildMore();
									}
									break;
								} else if (player.housesBuilt == 10) {
									messageBuilding();
								}
							}

						} else {
							message();
						}
					} else if (rButton2.isSelected()) {
						if (!player.wall) {
							tile = buildings.get("Wall");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getWood() >= tile.getWoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setWood(player.getWood()
												- tile.getWoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.wall = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}

					} else if (rButton3.isSelected()) {
						if (!player.tower) {
							tile = buildings.get("Tower");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getWood() >= tile.getWoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setWood(player.getWood()
												- tile.getWoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.tower = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton4.isSelected()) {
						if (!player.market) {
							tile = buildings.get("Market");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getFavor() >= tile.getFavorCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = buildingDialog
												.getBuildingTiles().get(
														"Market");
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setFavor(player.getFavor()
												- tile.getFavorCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.market = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton5.isSelected()) {
						if (!player.storehouse) {
							tile = buildings.get("Storehouse");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getFavor() >= tile.getFavorCost()
									&& player.getFood() >= tile.getFoodCost()
									&& player.getWood() >= tile.getWoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(
												buildingDialog
														.getBuildingTiles()
														.get("Storehouse"),
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setFood(player.getFood()
												- tile.getFoodCost());
										player.setWood(player.getWood()
												- tile.getWoodCost());
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setFavor(player.getFavor()
												- tile.getFavorCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.storehouse = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton6.isSelected()) {
						if (!player.armory) {
							tile = buildings.get("Armory");
							if (player.getWood() >= tile.getWoodCost()
									&& player.getGold() >= tile.getGoldCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setWood(player.getWood()
												- tile.getWoodCost());
										player.setGold(player.getGold()
												- tile.getGoldCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.armory = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton7.isSelected()) {
						if (!player.quarry) {
							tile = buildings.get("Quarry");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getFood() >= tile.getFoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setFood(player.getFood()
												- tile.getFoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.quarry = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton8.isSelected()) {
						if (!player.monument) {
							tile = buildings.get("Monument");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getFood() >= tile.getFoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setFood(player.getFood()
												- tile.getFoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.monument = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton9.isSelected()) {
						if (!player.granary) {
							tile = buildings.get("Granary");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getWood() >= tile.getWoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setWood(player.getWood()
												- tile.getWoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.granary = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton10.isSelected()) {
						if (!player.woodWorkshop) {
							tile = buildings.get("Wood Workshop");
							if (player.getGold() >= tile.getGoldCost()
									&& player.getFood() >= tile.getFoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setFood(player.getFood()
												- tile.getFoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.woodWorkshop = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton11.isSelected()) {
						if (!player.goldMint) {
							tile = buildings.get("Gold Mint");
							if (player.getWood() >= tile.getWoodCost()
									&& player.getFood() >= tile.getFoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setWood(player.getWood()
												- tile.getWoodCost());
										player.setFood(player.getFood()
												- tile.getFoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.goldMint = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton12.isSelected()) {
						if (!player.siegeWorkshop) {
							tile = buildings.get("Siege Engine Workshop");
							if (player.getWood() >= tile.getWoodCost()
									&& player.getGold() >= tile.getGoldCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setWood(player.getWood()
												- tile.getWoodCost());
										player.setGold(player.getGold()
												- tile.getGoldCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.siegeWorkshop = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton13.isSelected()) {
						if (!player.greatTemple) {
							tile = buildings.get("Great Temple");
							if (player.getWood() >= tile.getWoodCost()
									&& player.getGold() >= tile.getGoldCost()
									&& player.getFavor() >= tile.getFavorCost()
									&& player.getFood() >= tile.getFoodCost()) {
								for (int i = 0; i < buildingTiles.length; i++) {
									if (buildingTiles[i] == null) {
										buildingTiles[i] = tile;
										imageManipulator.repaint(tile,
												playerBoard, player, i);
										player.setBuildingTiles(buildingTiles);
										player.setWood(player.getWood()
												- tile.getWoodCost());
										player.setGold(player.getGold()
												- tile.getGoldCost());
										player.setFavor(player.getFavor()
												- tile.getFavorCost());
										player.setFood(player.getFood()
												- tile.getFoodCost());
										imageManipulator.redrawImage(
												playerBoard, player);
										buildingDialog.remove(tile.getLabel());
										buildingDialog.revalidate();
										buildingDialog.repaint();
										player.greatTemple = true;
										buildingCreated++;
										if (buildingCreated < actionCard
												.getNumber()) {
											buildMore();
										}
										break;
									}
								}

							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					} else if (rButton14.isSelected()) {
						if (!player.wonder) {
							tile = buildings.get("The Wonder");
							if (player.getWood() >= tile.getWoodCost()
									&& player.getGold() >= tile.getGoldCost()
									&& player.getFavor() >= tile.getFavorCost()
									&& player.getFood() >= tile.getFoodCost()) {
								if (player.getAge().equals("Mythic")) {
									for (int i = 0; i < buildingTiles.length; i++) {
										if (buildingTiles[i] == null) {
											buildingTiles[i] = tile;
											imageManipulator.repaint(tile,
													playerBoard, player, i);
											player.setBuildingTiles(buildingTiles);
											player.setWood(player.getWood()
													- tile.getWoodCost());
											player.setGold(player.getGold()
													- tile.getGoldCost());
											player.setFavor(player.getFavor()
													- tile.getFavorCost());
											player.setFood(player.getFood()
													- tile.getFoodCost());
											imageManipulator.redrawImage(
													playerBoard, player);
											buildingDialog.remove(tile
													.getLabel());
											buildingDialog.revalidate();
											buildingDialog.repaint();
											buildCard.dispose();
											JOptionPane.showMessageDialog(null,
													"You won the game!!");
											System.exit(0);
											player.wonder = true;
											buildingCreated++;
											if (buildingCreated < actionCard
													.getNumber()) {
												buildMore();
											}
											break;
										}
									}
								} else {
									JOptionPane
											.showMessageDialog(null,
													"You need to be in mythic age to build the wonder!");
								}
							} else {
								message();
							}
						} else {
							messageBuilding();
						}
					}
					if (buildingCreated - previousCount == 1) {
						player.setBuildingTiles(buildingTiles);
					}
					if (buildingCreated == actionCard.getNumber()) {
						buildCard.dispose();
					}
				}
				setTurn(player);
			}

		});
	}

	private void message() {
		JOptionPane.showMessageDialog(null,
				"You don't have sufficient resources!");
		setTurn(player);
		buildCard.dispose();
	}

	private void messageBuilding() {
		JOptionPane.showMessageDialog(null,
				"You can't build any more buildings of this type!");
	}

	private void messageFailure() {
		JOptionPane.showMessageDialog(null,
				"You can't build more than one building in a single turn!");
	}

	private void buildMore() {
		int reply = JOptionPane.showConfirmDialog(null,
				"Do you want to build more buildings?", "Build",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.NO_OPTION) {
			buildCard.dispose();
		}
	}

	private void updatePlayer(String building) {
		if (building.equals("House")) {
			player.housesBuilt += 1;
		} else if (building.equals("Wall")) {
			player.wall = true;
		} else if (building.equals("Tower")) {
			player.tower = true;
		} else if (building.equals("Market")) {
			player.market = true;
		} else if (building.equals("Storehouse")) {
			player.storehouse = true;
		} else if (building.equals("Armory")) {
			player.armory = true;
		} else if (building.equals("Quarry")) {
			player.quarry = true;
		} else if (building.equals("Monument")) {
			player.monument = true;
		} else if (building.equals("Granary")) {
			player.granary = true;
		} else if (building.equals("Wood Workshop")) {
			player.woodWorkshop = true;
		} else if (building.equals("Gold Mint")) {
			player.goldMint = true;
		} else if (building.equals("Siege Engine Workshop")) {
			player.siegeWorkshop = true;
		} else if (building.equals("Great Temple")) {
			player.greatTemple = true;
		} else if (building.equals("The Wonder")) {
			player.wonder = true;
		}
	}

	private boolean checkUniqueness(String building) {
		if (building.equals("House") && player.housesBuilt == 10) {
			return false;
		} else if (building.equals("Wall") && player.wall) {
			return false;
		} else if (building.equals("Tower") && player.tower) {
			return false;
		} else if (building.equals("Market") && player.market) {
			return false;
		} else if (building.equals("Storehouse") && player.storehouse) {
			return false;
		} else if (building.equals("Armory") && player.armory) {
			return false;
		} else if (building.equals("Quarry") && player.quarry) {
			return false;
		} else if (building.equals("Monument") && player.monument) {
			return false;
		} else if (building.equals("Granary") && player.granary) {
			return false;
		} else if (building.equals("Wood Workshop") && player.woodWorkshop) {
			return false;
		} else if (building.equals("Gold Mint") && player.goldMint) {
			return false;
		} else if (building.equals("Siege Engine Workshop")
				&& player.siegeWorkshop) {
			return false;
		} else if (building.equals("Great Temple") && player.greatTemple) {
			return false;
		} else if (building.equals("The Wonder") && player.wonder) {
			return false;
		}
		return true;
	}
}
