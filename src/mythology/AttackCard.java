package mythology;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class AttackCard extends ActionCard {

	public AttackCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		onGoingBattle = true;
	}

	private JButton button;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private String attackOn;
	private List<String> player1Units = new ArrayList<String>();
	private List<String> player2Units = new ArrayList<String>();
	private JDialog selectPlayerToAttack = new JDialog();
	private Player aiPlayer;
	private int numberOfDice1 = 0;
	private int numberOfDice2 = 0;
	private AttackCard attackCard;
	private JPanel panel;
	private Set<String> uniqueMilitaryUnits;
	private JButton button1;
	private int labelCount = 0;
	private String attackingUnit;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private String defendingUnit;
	private List<String> player1UnitsDead = new ArrayList<String>();
	private List<String> player2UnitsDead = new ArrayList<String>();
	private BattleCard attacker;
	private BattleCard defender;
	private int sixesRolled1 = 0;
	private int sixesRolled2 = 0;
	private int total1 = 0;
	private int total2 = 0;
	private int diceRolled1 = 0;
	private int diceRolled2 = 0;
	private boolean dead1 = false;
	private boolean dead2 = false;
	private JLabel label;
	private Random dice = new Random();
	private int counter = 0;
	private String attackingArea;
	private String selectedTile;
	private int numberOfUnits = 0;
	private JDialog dialog;
	private List<String> buildingList = new ArrayList<String>();
	protected int extraUnits = 0;
	protected String playerRole = "";
	protected int extraDice = 0;
	public static boolean onGoingBattle;
	private Player playerAsParementer;
	private Player playerWon;
	private boolean flag = false;

	@Override
	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			selectPlayerAndUnitsToAttack();
		} else {
			List<String> playerTypes;
			List<String> attackAreas = Arrays.asList("Holding Area",
					"Production Area", "City Area");
			if (player.getPlayerType().equals("Greek")) {
				playerTypes = Arrays.asList("Egyptian", "Norse");
			} else if (player.getPlayerType().equals("Egyptian")) {
				playerTypes = Arrays.asList("Greek", "Norse");
			} else {
				playerTypes = Arrays.asList("Egyptian", "Norse");
			}

			int index = 0;
			String opponent;
			String attackArea;
			index = new Random().nextInt(playerTypes.size());
			opponent = playerTypes.get(index);
			index = new Random().nextInt(attackAreas.size());
			attackArea = attackAreas.get(index);
			if (opponent.equals(playerBoard.getHumanPlayer().getPlayerType())) {
				JOptionPane.showMessageDialog(null, player.getPlayerType()
						+ " is attacking your " + attackArea);
				player2Units = selectAIPlayerUnits(player);
				aiPlayer = player;
				displayUnitsSelection(playerBoard.getHumanPlayer());
			} else {
				if (aiPlayer1.getPlayer().getPlayerType().equals(opponent)) {
					aiPlayer = aiPlayer1.getPlayer();
				} else {
					aiPlayer = aiPlayer2.getPlayer();
				}
				player1Units = selectAIPlayerUnits(player);
				player2Units = selectAIPlayerUnits(aiPlayer);
				numberOfUnits = player1Units.size();
				for (int i = 0; i < actionCard.getNumber(); i++) {
					attack(player);
				}
				playerAsParementer = player;
				Player playerLost;
				if (flag) {
					if (playerWon.getPlayerType().equals(player)) {
						playerLost = aiPlayer;
					} else {
						playerLost = player;
					}
				} else {
					playerWon = player;
					playerLost = aiPlayer;
				}
				playerWon.setVictory_cubes(playerWon.getVictory_cubes()
						+ VCDialog.lastbattle);
				VCDialog.lastbattle = 0;
				imageManipulator.redrawImage(playerBoard, playerWon);
				JOptionPane.showMessageDialog(
						null,
						player.getPlayerType()
								+ " player won the battle against "
								+ aiPlayer.getPlayerType() + " player!");
				if (attackArea.equals("Holding Area")) {
					int total = 0;
					List<String> resources = Arrays.asList("Food", "Favor",
							"Wood", "Gold");
					int count = 0;
					int limit = 20;
					while (total != 5) {
						index = new Random().nextInt(resources.size());
						if (resources.get(index).equals("Food")) {
							total += 1;
							playerLost.setFood(playerLost.getFood() - 1);
							playerWon.setFood(playerWon.getFood() + 1);
						}
						if (resources.get(index).equals("Favor")) {
							total += 1;
							playerLost.setFavor(playerLost.getFavor() - 1);
							playerWon.setFavor(playerWon.getFavor() + 1);
						}
						if (resources.get(index).equals("Wood")) {
							total += 1;
							playerLost.setWood(playerLost.getWood() - 1);
							playerWon.setWood(playerWon.getWood() + 1);
						}
						if (resources.get(index).equals("Gold")) {
							total += 1;
							playerLost.setGold(playerLost.getGold() - 1);
							playerWon.setGold(playerWon.getGold() + 1);
						}
						count++;
						if (count > limit) {
							break;
						}
					}
					imageManipulator.redrawImage(playerBoard, playerLost);
					imageManipulator.redrawImage(playerBoard, playerWon);
				} else if (attackArea.equals("City Area")) {
					BuildingTile[] buildings = playerLost.getBuildingTiles();
					for (int i = 0; i < buildings.length; i++) {
						if (buildings[i] != null) {
							buildings[i] = null;
							break;
						}
					}
					playerLost.setBuildingTiles(buildings);
					imageManipulator.redrawImage(playerBoard, playerLost);
					imageManipulator.redrawImage(playerBoard, playerWon);
				} else {
					TerrianTile[][] terrianTiles = playerLost.getTerrianTiles();
					boolean flag = false;
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (terrianTiles[i][j] != null) {
								imageManipulator.repaint(terrianTiles[i][j],
										playerBoard, playerWon);
								terrianTiles[i][j] = null;
								flag = true;
								break;
							}
						}
						if (flag) {
							break;
						}
					}
					aiPlayer.setTerrianTiles(terrianTiles);
					imageManipulator.redrawImage(playerBoard, playerLost);
					imageManipulator.redrawImage(playerBoard, playerWon);
				}
				setTurn(player);
			}
		}
		if (playerAsParementer != null
				&& playerAsParementer.getPlayerRole().equals("AI")) {
			onGoingBattle = false;
			return;
		}
	}

	private void displayDialog(Player player) {
		JLabel label;
		int i = 0;
		attackCard = this;
		panel = new JPanel();
		panel.setBackground(Color.black);
		setContentPane(panel);
		setLayout(new BorderLayout());
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 0, 5);
		uniqueMilitaryUnits = new HashSet<String>(player1Units);
		for (String unit : uniqueMilitaryUnits) {
			constraints.gridx = i;
			constraints.gridy = 0;
			label = new JLabel();
			labelCount++;
			label = player.battleCards.get(unit).getBattleCard();
			label.setToolTipText(unit);
			panel.add(label, constraints);
			label.addMouseListener(new MouseListener() {

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
					attackingUnit = ((JLabel) e.getComponent())
							.getToolTipText();
				}
			});
			i++;
		}
		button1 = new JButton("Play");
		setSize(labelCount * 200, 300);
		x = (screenSize.width - this.getWidth()) / 2;
		y = (screenSize.height - this.getHeight()) / 2;
		setLocation(x, y);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridwidth = 11;
		panel.add(button1, constraints);
		setVisible(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		listener(player);
	}

	private void listener(Player player) {
		button1.addMouseListener(new MouseListener() {

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
				attackCard.dispose();
				attack(player);
				playerAsParementer = player;

			}
		});
	}

	private void attack(Player player) {
		dead1 = false;
		dead2 = false;
		sixesRolled1 = 0;
		sixesRolled2 = 0;
		total1 = 0;
		total2 = 0;
		if (counter < numberOfUnits - 1) {
			if (player2Units.size() == 0) {
				playerWon = player;
				flag = true;
				if (player.getPlayerRole().equals("Human")) {
					JOptionPane
							.showMessageDialog(
									null,
									aiPlayer.getPlayerType()
											+ " player has no units left, you have won the battle!!");
					if (this.player.getPlayerRole().equals("Human")) {
						takeOrDestroyResources();
					} else {
						onGoingBattle = false;
					}
					return;
				} else {
					return;
				}
			}
			int index = new Random().nextInt(player2Units.size());
			defendingUnit = player2Units.get(index);

			if (player.getPlayerRole().equals("AI")) {
				if (player1Units.size() == 0) {
					playerWon = aiPlayer;
					flag = true;
					return;
				}
				attackingUnit = player1Units.get(new Random()
						.nextInt(player1Units.size()));

			}
			attacker = player.battleCards.get(attackingUnit);
			defender = aiPlayer.battleCards.get(defendingUnit);
			numberOfDice1 = attacker.getNumberOfDice()
					+ (this.player.getPlayerRole().equals("Human")
							&& actionCard.getGod() != null
							&& actionCard.getGod().equals("Bragi") ? extraDice
							: 0);
			numberOfDice2 = defender.getNumberOfDice();
			for (int j = 0; j < defender.getUnitType().size(); j++) {
				if (attacker.getExtraDice().get(defender.getUnitType().get(j)) != null) {
					numberOfDice1 = numberOfDice1
							+ attacker.getExtraDice().get(
									defender.getUnitType().get(j));
				}
			}
			for (int j = 0; j < attacker.getUnitType().size(); j++) {
				if (defender.getExtraDice().get(attacker.getUnitType().get(j)) != null) {
					numberOfDice2 = numberOfDice2
							+ defender.getExtraDice().get(
									attacker.getUnitType().get(j));
				}
			}
			while (true) {
				total1 = 0;
				total2 = 0;
				sixesRolled1 = 0;
				sixesRolled2 = 0;
				while (numberOfDice1 != total1) {
					diceRolled1 = dice.nextInt(6);
					if (diceRolled1 == 5) {
						sixesRolled1++;
					}
					total1++;
				}
				while (numberOfDice2 != total2) {
					diceRolled2 = dice.nextInt(6);
					if (diceRolled2 == 5) {
						sixesRolled2++;
					}
					total2++;
				}
				if (sixesRolled1 > sixesRolled2) {
					player2UnitsDead.add(defendingUnit);
					player2Units.remove(defendingUnit);
					dead2 = true;
					break;
				} else if (sixesRolled2 > sixesRolled1) {
					player1UnitsDead.add(attackingUnit);
					player1Units.remove(attackingUnit);
					dead1 = true;
					break;
				}
			}

			if (dead1) {
				if (!player1Units.contains(attackingUnit)
						&& player.getPlayerRole().equals("Human")) {
					for (int k = 0; k < attackCard.getContentPane()
							.getComponentCount() - 1; k++) {
						if (((JLabel) attackCard.getContentPane().getComponent(
								k)).getToolTipText().equals(attackingUnit)) {
							label = (JLabel) attackCard.getContentPane()
									.getComponent(k);
							attackCard.getContentPane().remove(label);
							attackCard.getContentPane().revalidate();
							attackCard.repaint();
							labelCount--;
							setSize(labelCount * 200, 300);
							x = (screenSize.width - this.getWidth()) / 2;
							y = (screenSize.height - this.getHeight()) / 2;
							this.setLocation(x, y);
						}
					}
				}
				player.militaryUnits.remove(attackingUnit);
				imageManipulator.redrawImage(playerBoard, player);
				if (player.getPlayerRole().equals("Human")) {
					JOptionPane.showMessageDialog(null,
							"Your unit lost this battle round!");
				}
			} else {
				aiPlayer.militaryUnits.remove(defendingUnit);
				imageManipulator.redrawImage(playerBoard, aiPlayer);
				if (player.getPlayerRole().equals("Human")) {
					JOptionPane.showMessageDialog(null,
							"Your unit won this battle round!");
				}
			}
			if (player.getPlayerRole().equals("Human")) {
				this.setVisible(true);
			}
			counter++;
		} else {
			imageManipulator.redrawImage(playerBoard, aiPlayer);
			if (player.getPlayerRole().equals("Human")) {
				JOptionPane.showMessageDialog(null, aiPlayer.getPlayerType()
						+ " player has retreated, you have won the battle!!");
				player.setVictory_cubes(player.getVictory_cubes()
						+ VCDialog.lastbattle);
				VCDialog.lastbattle = 0;
				imageManipulator.redrawImage(playerBoard, player);
				if (this.player.getPlayerRole().equals("Human")) {
					takeOrDestroyResources();
				} else {
					onGoingBattle = false;
					setTurn(this.player);
				}
			} else {
				setTurn(this.player);
				return;
			}

		}
	}

	private void selectPlayer2Units() {
		Random randomizer = new Random();
		int index;
		if (aiPlayer1.getPlayer().getPlayerType().equals(attackOn)) {
			aiPlayer = aiPlayer1.getPlayer();
			for (int i = 0; i < actionCard.getNumber(); i++) {
				if (aiPlayer.militaryUnits.size() == 0
						&& player2Units.size() == 0) {
					JOptionPane
							.showMessageDialog(
									null,
									aiPlayer.getPlayerType()
											+ " player has no units left, you have won the battle!!");
					takeOrDestroyResources();
					onGoingBattle = false;
					return;
				}
				if (aiPlayer.militaryUnits.size() == 0) {
					break;
				}
				index = randomizer.nextInt(aiPlayer.militaryUnits.size());
				player2Units.add(aiPlayer.militaryUnits.get(index));
				aiPlayer.militaryUnits.remove(index);

			}
			aiPlayer.militaryUnits.addAll(player2Units);
		} else if (aiPlayer2.getPlayer().getPlayerType().equals(attackOn)) {
			aiPlayer = aiPlayer2.getPlayer();

			for (int i = 0; i < actionCard.getNumber(); i++) {
				index = randomizer.nextInt(aiPlayer.militaryUnits.size());
				player2Units.add(aiPlayer.militaryUnits.get(index));
				aiPlayer.militaryUnits.remove(index);
				if (aiPlayer.militaryUnits.size() == 0) {
					break;
				}
			}
			aiPlayer.militaryUnits.addAll(player2Units);
		}

	}

	private List<String> selectAIPlayerUnits(Player player) {
		List<String> playerUnits = new ArrayList<String>();
		Random randomizer = new Random();
		int index;
		for (int i = 0; i < actionCard.getNumber()
				+ (this.player.getPlayerRole().equals(playerRole) ? extraUnits
						: 0); i++) {
			if (player.militaryUnits.size() == 0 && playerUnits.size() == 0) {
				return new ArrayList<String>();
			} else if (player.militaryUnits.size() == 0) {
				break;
			}
			index = randomizer.nextInt(player.militaryUnits.size());
			playerUnits.add(player.militaryUnits.get(index));
			player.militaryUnits.remove(index);
			if (player.militaryUnits.size() == 0) {
				break;
			}
		}
		player.militaryUnits.addAll(playerUnits);
		return playerUnits;
	}

	private void selectPlayerAndUnitsToAttack() {
		selectPlayerToAttack.setTitle("Attack");
		button = new JButton("Attack");
		radio1 = new JRadioButton("Greek");
		radio2 = new JRadioButton("Egyptian");
		radio3 = new JRadioButton("Norse");
		selectPlayerToAttack.setLocationRelativeTo(null);
		selectPlayerToAttack.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		if (player.getPlayerType().equals("Greek")) {
			radio1.setEnabled(false);
		} else if (player.getPlayerType().equals("Egyptian")) {
			radio2.setEnabled(false);
		} else {
			radio3.setEnabled(false);
		}

		selectPlayerToAttack.setSize(200, 300);
		x = (screenSize.width - selectPlayerToAttack.getWidth()) / 2;
		y = (screenSize.height - selectPlayerToAttack.getHeight()) / 2;
		selectPlayerToAttack.setLocation(x, y);
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.ipadx = 10;
		buttonGroup.add(radio1);
		panel.add(radio1, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.ipadx = 0;
		constraints.insets = new Insets(20, 0, 0, 0);
		buttonGroup.add(radio2);
		panel.add(radio2, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.ipadx = 0;
		constraints.insets = new Insets(20, 0, 0, 0);
		buttonGroup.add(radio3);
		panel.add(radio3, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.ipadx = 0;
		constraints.insets = new Insets(20, 0, 0, 0);
		panel.add(button, constraints);
		selectPlayerToAttack.setContentPane(panel);
		selectPlayerToAttack.setVisible(true);

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
				if (radio1.isSelected()) {
					attackOn = "Greek";
				} else if (radio2.isSelected()) {
					attackOn = "Egyptian";
				} else {
					attackOn = "Norse";
				}

				String[] areas = { "City Area", "Production Area",
						"Holding Area" };
				attackingArea = (String) JOptionPane.showInputDialog(
						selectPlayerToAttack, "Selcect an area to attack",
						"Attack Area", JOptionPane.QUESTION_MESSAGE, null,
						areas, areas[0]);
				displayUnitsSelection(player);
				selectPlayerToAttack.dispose();
				selectPlayer2Units();

			}
		});
	}

	private void displayUnitsSelection(Player player) {
		dialog = new JDialog();
		dialog.setTitle("Unit Selection");
		JPanel panel = new JPanel();
		dialog.setSize(300, 500);
		x = (screenSize.width - dialog.getWidth()) / 2;
		y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
		panel.setLayout(new GridBagLayout());
		JCheckBox checkbox;
		dialog.setContentPane(panel);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = constraints.LINE_START;
		JLabel label = new JLabel("Select a maximum of "
				+ actionCard.getNumber() + " units");
		constraints.insets = new Insets(10, 0, 10, 0);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(label, constraints);
		constraints.insets = new Insets(0, 0, 5, 0);
		int count = 0;
		for (int i = 0; i < player.militaryUnits.size(); i++) {
			checkbox = new JCheckBox(player.militaryUnits.get(i));
			count++;
			constraints.gridx = 0;
			constraints.gridy = count;
			panel.add(checkbox, constraints);
			checkbox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (((JCheckBox) e.getSource()).isSelected()) {
						player1Units.add(((JCheckBox) e.getSource()).getText());
						numberOfUnits++;
					}
					if (!((JCheckBox) e.getSource()).isSelected()) {
						player1Units.remove(((JCheckBox) e.getSource())
								.getText());
						numberOfUnits--;
					}
				}
			});
		}

		JButton button = new JButton("Attack");
		constraints.gridx = 0;
		constraints.gridy = count + 1;
		constraints.anchor = constraints.CENTER;
		constraints.insets = new Insets(15, 0, 0, 0);
		panel.add(button, constraints);

		dialog.setVisible(true);
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
				int total = actionCard.getNumber()
						+ (playerRole.equals("Human") ? extraUnits : 0);
				if (numberOfUnits > total) {
					player1Units.clear();
					JOptionPane.showMessageDialog(null,
							"You can not attack with more than " + total
									+ " units!");
				} else {
					dialog.dispose();
					displayDialog(player);
				}

			}

		});

	}

	private void takeOrDestroyResources() {
		if (attackingArea.equals("Production Area")) {
			final JDialog dialog = new JDialog();
			JPanel panel = new JPanel();
			dialog.setSize(250, 500);
			dialog.setContentPane(panel);
			x = (screenSize.width - dialog.getWidth()) / 2;
			y = (screenSize.height - dialog.getHeight()) / 2;
			dialog.setLocation(x, y);
			panel.setLayout(new GridBagLayout());
			TerrianTile[][] terrianTiles = aiPlayer.getTerrianTiles();
			JRadioButton radio;
			ButtonGroup buttonGroup = new ButtonGroup();
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.anchor = GridBagConstraints.LINE_START;
			int count = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (terrianTiles[i][j] != null) {
						radio = new JRadioButton();
						radio.setText(terrianTiles[i][j].getTerrianType()
								+ " "
								+ (terrianTiles[i][j].getFavor() != 0 ? terrianTiles[i][j]
										.getFavor() + " favor"
										: (terrianTiles[i][j].getFood() != 0 ? terrianTiles[i][j]
												.getFood() + " food"
												: (terrianTiles[i][j].getWood() != 0 ? terrianTiles[i][j]
														.getWood() + " wood"
														: terrianTiles[i][j]
																.getGold()
																+ " gold"))));
						constraints.gridy = count;
						buttonGroup.add(radio);
						panel.add(radio, constraints);
						count++;
						radio.addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent e) {

								if (e.getStateChange() == ItemEvent.SELECTED) {
									selectedTile = ((JRadioButton) e.getItem())
											.getText();
								}

							}
						});

					}
				}
			}
			constraints.gridy = count;
			constraints.anchor = GridBagConstraints.CENTER;
			constraints.insets = new Insets(15, 0, 0, 0);
			JButton button = new JButton("Steal Production Tile");
			panel.add(button, constraints);
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
					String[] split = selectedTile.split(" ");
					TerrianTile terrianTile = null;
					TerrianTile[][] terrianTiles = aiPlayer.getTerrianTiles();
					boolean flag = false;
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (terrianTiles[i][j] != null
									&& terrianTiles[i][j].getTerrianType()
											.equals(split[0])) {
								if (split[2].equals("food")
										&& terrianTiles[i][j].getFood() == Integer
												.parseInt(split[1])) {
									terrianTile = terrianTiles[i][j];
									terrianTiles[i][j] = null;
									aiPlayer.setTerrianTiles(terrianTiles);
									flag = true;
									break;
								} else if (split[2].equals("wood")
										&& terrianTiles[i][j].getWood() == Integer
												.parseInt(split[1])) {
									terrianTile = terrianTiles[i][j];
									terrianTiles[i][j] = null;
									aiPlayer.setTerrianTiles(terrianTiles);
									flag = true;
									break;
								} else if (split[2].equals("favor")
										&& terrianTiles[i][j].getFavor() == Integer
												.parseInt(split[1])) {
									terrianTile = terrianTiles[i][j];
									terrianTiles[i][j] = null;
									aiPlayer.setTerrianTiles(terrianTiles);
									flag = true;
									break;
								} else if (split[2].equals("gold")
										&& terrianTiles[i][j].getGold() == Integer
												.parseInt(split[1])) {
									terrianTile = terrianTiles[i][j];
									terrianTiles[i][j] = null;
									aiPlayer.setTerrianTiles(terrianTiles);
									flag = true;
									break;
								}
							}
						}
						if (flag) {
							break;
						}
					}
					imageManipulator.repaint(terrianTile, playerBoard, player);
					imageManipulator.redrawImage(playerBoard, aiPlayer);
					dialog.dispose();
					setTurn(player);
					onGoingBattle = false;
				}
			});
			dialog.setVisible(true);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		} else if (attackingArea.equals("Holding Area")
				&& (aiPlayer.getFavor() + aiPlayer.getFood()
						+ aiPlayer.getWood() + aiPlayer.getGold()) >= 5) {
			final JDialog dialog = new JDialog();
			JPanel panel = new JPanel();
			dialog.setSize(250, 350);
			dialog.setContentPane(panel);
			x = (screenSize.width - dialog.getWidth()) / 2;
			y = (screenSize.height - dialog.getHeight()) / 2;
			dialog.setLocation(x, y);
			panel.setLayout(new GridBagLayout());
			DefaultComboBoxModel<Integer> model1 = new DefaultComboBoxModel<Integer>();
			DefaultComboBoxModel<Integer> model2 = new DefaultComboBoxModel<Integer>();
			DefaultComboBoxModel<Integer> model3 = new DefaultComboBoxModel<Integer>();
			DefaultComboBoxModel<Integer> model4 = new DefaultComboBoxModel<Integer>();
			model1.addElement(0);
			for (int i = 0; i < aiPlayer.getFood(); i++) {
				model1.addElement(i + 1);
			}
			model2.addElement(0);
			for (int i = 0; i < aiPlayer.getFavor(); i++) {
				model2.addElement(i + 1);
			}
			model3.addElement(0);
			for (int i = 0; i < aiPlayer.getWood(); i++) {
				model3.addElement(i + 1);
			}
			model4.addElement(0);
			for (int i = 0; i < aiPlayer.getGold(); i++) {
				model4.addElement(i + 1);
			}

			final JComboBox<Integer> food = new JComboBox<>();
			food.setModel(model1);
			final JComboBox<Integer> favor = new JComboBox<>();
			favor.setModel(model2);
			final JComboBox<Integer> wood = new JComboBox<>();
			wood.setModel(model3);
			final JComboBox<Integer> gold = new JComboBox<>();
			gold.setModel(model4);
			JLabel label1 = new JLabel("Food : ");
			JLabel label2 = new JLabel("Favor : ");
			JLabel label3 = new JLabel("Wood : ");
			JLabel label4 = new JLabel("Gold : ");
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.anchor = constraints.LINE_START;
			constraints.insets = new Insets(10, 0, 0, 0);
			constraints.gridx = 0;
			constraints.gridy = 0;
			panel.add(label1, constraints);
			constraints.gridx = 1;
			constraints.gridy = 0;
			panel.add(food, constraints);

			constraints.gridx = 0;
			constraints.gridy = 1;
			panel.add(label2, constraints);
			constraints.gridx = 1;
			constraints.gridy = 1;
			panel.add(favor, constraints);

			constraints.gridx = 0;
			constraints.gridy = 2;
			panel.add(label3, constraints);
			constraints.gridx = 1;
			constraints.gridy = 2;
			panel.add(wood, constraints);

			constraints.gridx = 0;
			constraints.gridy = 3;
			panel.add(label4, constraints);
			constraints.gridx = 1;
			constraints.gridy = 3;
			panel.add(gold, constraints);

			constraints.anchor = constraints.CENTER;
			constraints.insets = new Insets(20, 0, 0, 0);
			constraints.gridy = 4;
			JButton button = new JButton("Steal Resources");
			panel.add(button, constraints);
			dialog.setVisible(true);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
					int total = 0;
					if ((Integer) food.getSelectedItem() != 0) {
						total = total + (Integer) food.getSelectedItem();
					}
					if ((Integer) favor.getSelectedItem() != 0) {
						total = total + (Integer) favor.getSelectedItem();
					}
					if ((Integer) wood.getSelectedItem() != 0) {
						total = total + (Integer) wood.getSelectedItem();
					}
					if ((Integer) gold.getSelectedItem() != 0) {
						total = total + (Integer) gold.getSelectedItem();
					}
					if (total > 5 || total < 5) {
						JOptionPane.showMessageDialog(null,
								"Select only five resource cubes!");
						food.setSelectedItem(0);
						favor.setSelectedItem(0);
						wood.setSelectedItem(0);
						gold.setSelectedItem(0);
					}
					if (total == 5) {
						player.setFood(player.getFood()
								+ (Integer) food.getSelectedItem());
						aiPlayer.setFood(aiPlayer.getFood()
								- (Integer) food.getSelectedItem());
						player.setFavor(player.getFavor()
								+ (Integer) favor.getSelectedItem());
						aiPlayer.setFavor(aiPlayer.getFavor()
								- (Integer) favor.getSelectedItem());
						player.setWood(player.getWood()
								+ (Integer) wood.getSelectedItem());
						aiPlayer.setWood(aiPlayer.getWood()
								- (Integer) wood.getSelectedItem());
						player.setGold(player.getGold()
								+ (Integer) gold.getSelectedItem());
						aiPlayer.setGold(aiPlayer.getGold()
								- (Integer) gold.getSelectedItem());
						imageManipulator.redrawImage(playerBoard, aiPlayer);
						imageManipulator.redrawImage(playerBoard, player);
						dialog.dispose();
						setTurn(player);
						onGoingBattle = false;
					}
				}
			});

		} else if (attackingArea.equals("City Area")) {
			final JDialog dialog = new JDialog();
			JPanel panel = new JPanel();
			dialog.setSize(250, 350);
			dialog.setContentPane(panel);
			x = (screenSize.width - dialog.getWidth()) / 2;
			y = (screenSize.height - dialog.getHeight()) / 2;
			dialog.setLocation(x, y);
			panel.setLayout(new GridBagLayout());
			JLabel label = new JLabel("Select building(s) to destoy");
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.anchor = GridBagConstraints.LINE_START;
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.insets = new Insets(10, 0, 10, 0);
			int count = 0;
			panel.add(label, constraints);
			constraints.insets = new Insets(5, 0, 0, 0);
			BuildingTile[] buildings = aiPlayer.getBuildingTiles();
			JCheckBox checkBox;

			for (int i = 0; i < buildings.length; i++) {
				if (buildings[i] != null) {
					checkBox = new JCheckBox(buildings[i].getBuildingType());
					count++;
					constraints.gridx = 0;
					constraints.gridy = count;
					panel.add(checkBox, constraints);
					checkBox.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (((JCheckBox) e.getSource()).isSelected()) {
								buildingList.add(((JCheckBox) e.getSource())
										.getText());
							}
							if (!((JCheckBox) e.getSource()).isSelected()) {
								buildingList.remove(((JCheckBox) e.getSource())
										.getText());
							}
						}
					});
				}
			}
			JButton button = new JButton("Eliminate Building");
			constraints.anchor = GridBagConstraints.CENTER;
			constraints.insets = new Insets(10, 0, 0, 0);
			constraints.gridx = 0;
			constraints.gridy = count + 1;
			panel.add(button, constraints);
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
					boolean flag = false;
					BuildingTile[] buildingsAttacker = player
							.getBuildingTiles();
					for (int i = 0; i < buildingsAttacker.length; i++) {
						if (buildingsAttacker[i] != null
								&& buildingsAttacker[i].getBuildingType()
										.equals("Siege Engine Workshop")) {
							flag = true;
						}
					}
					BuildingTile[] buildingsDefender = aiPlayer
							.getBuildingTiles();
					if (flag && buildingList.size() > 2) {
						JOptionPane.showMessageDialog(null,
								"You can only destroy 2 buildings!");
					} else if (!flag && buildingList.size() > 1) {
						JOptionPane.showMessageDialog(null,
								"You can only destroy 1 building!");
					} else {
						dialog.dispose();
						for (int i = 0; i < buildingList.size(); i++) {
							for (int j = 0; j < buildingsDefender.length; j++) {
								if (buildingsDefender[j] != null
										&& buildingsDefender[j]
												.getBuildingType().equals(
														buildingList.get(i))) {
									buildingsDefender[j] = null;
								}
							}
						}
						aiPlayer.setBuildingTiles(buildingsDefender);
						imageManipulator.redrawImage(playerBoard, aiPlayer);
					}
					onGoingBattle = false;
					setTurn(player);
					return;
				}
			});
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else {
			onGoingBattle = false;
		}

	}
}
