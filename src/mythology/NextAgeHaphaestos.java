package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class NextAgeHaphaestos extends NextAgeCard {
	private String selectedTile;
	private String playerType;
	private Player tempPlayer;
	private Random random = new Random();
	private List<String> options = Arrays.asList("Yes", "No");

	public NextAgeHaphaestos(ResourceDialog resource, PlayerBoard playerBoard,
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
					setTurn(player);
					return;
				}
			} else if (player.getFavor() < 2) {
				JOptionPane
						.showMessageDialog(null,
								"You don't have sufficient resources to play god power!");
				return;
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
			} else if (player.getFavor() < 2) {
				setTurn(player);
				return;
			}
		}
		player.setFavor(player.getFavor() - 2);
		imageManipulator.redrawImage(playerBoard, player);
		if (player.getPlayerRole().equals("Human")) {
			String[] areas = { "Greek", "Egyptian", "Norse" };
			playerType = (String) JOptionPane.showInputDialog(this,
					"Select a player type to eliminate production tile",
					"Eliminate Production Tile", JOptionPane.QUESTION_MESSAGE,
					null, areas, areas[0]);
			super.dispose();
			if (playerType.equals(player.getPlayerType())) {
				tempPlayer = player;
			} else if (playerType.equals(aiPlayer1.player.getPlayerType())) {
				tempPlayer = aiPlayer1.player;
			} else {
				tempPlayer = aiPlayer1.player;
			}
			if (tempPlayer != null) {
				dialogBox(tempPlayer);
			} else {
				return;
			}
		} else {
			List<String> arrayList = Arrays
					.asList("Greek", "Egyptian", "Norse");
			String playerType;
			TerrianTile[][] terrianTiles = null;

			boolean flag = false;
			boolean inLoop = false;
			playerType = arrayList.get(random.nextInt(arrayList.size()));
			if (playerType.equals(player.getPlayerType())) {
				int x = 0;
				int y = 0;
				x = random.nextInt(4);
				y = random.nextInt(4);
				if (player.getTerrianTiles()[x][y] != null) {
					terrianTiles = player.getTerrianTiles();
					terrianTiles[x][y] = null;
					player.setTerrianTiles(terrianTiles);
				}
				flag = true;
				tempPlayer = player;
			}
			if (playerType.equals(aiPlayer1.player.getPlayerType()) && !flag) {
				tempPlayer = aiPlayer1.player;
				terrianTiles = aiPlayer1.player.getTerrianTiles();
			}
			if (playerType.equals(aiPlayer2.player.getPlayerType()) && !flag) {
				tempPlayer = aiPlayer2.player;
				terrianTiles = aiPlayer2.player.getTerrianTiles();
			}
			if (playerType.equals(playerBoard.getHumanPlayer().getPlayerType())) {
				tempPlayer = playerBoard.getHumanPlayer();
				terrianTiles = playerBoard.getHumanPlayer().getTerrianTiles();
			}
			if (!flag) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (terrianTiles[i][j] != null
								&& (terrianTiles[i][j].getFavor() == 2
										|| terrianTiles[i][j].getFood() == 2
										|| terrianTiles[i][j].getGold() == 2 || terrianTiles[i][j]
										.getWood() == 2)) {
							terrianTiles[i][j] = null;
							tempPlayer.setTerrianTiles(terrianTiles);
							if (tempPlayer.getPlayerRole().equals("Human")) {
								JOptionPane
										.showMessageDialog(null,
												"Greek player has eliminated one production tile!");
							} else {
								JOptionPane.showMessageDialog(null,
										"Greek player has eliminated one production tile of "
												+ tempPlayer.getPlayerType()
												+ "!");
							}
							inLoop = true;
							break;
						}
					}
					if (inLoop) {
						break;
					}
				}
			}
			if (!flag && !inLoop) {
				boolean eliminated = false;
				while (!eliminated) {
					x = random.nextInt(4);
					y = random.nextInt(4);
					if (tempPlayer.getTerrianTiles()[x][y] != null) {
						terrianTiles = tempPlayer.getTerrianTiles();
						terrianTiles[x][y] = null;
						tempPlayer.setTerrianTiles(terrianTiles);
						eliminated = true;
					}
				}
			}
			imageManipulator.redrawImage(playerBoard, tempPlayer);
			int index = random.nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
			} else {
				setTurn(player);
				return;
			}
		}
	}

	private void dialogBox(final Player player) {
		final JDialog dialog = new JDialog();
		JPanel panel = new JPanel();
		dialog.setSize(250, 500);
		x = (screenSize.width - dialog.getWidth()) / 2;
		y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
		dialog.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		TerrianTile[][] terrianTiles = player.getTerrianTiles();
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
		JButton button = new JButton("Eliminate Production Tile");
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
				TerrianTile[][] terrianTiles = player.getTerrianTiles();
				boolean flag = false;
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (terrianTiles[i][j] != null
								&& terrianTiles[i][j].getTerrianType().equals(
										split[0])) {
							if (split[2].equals("food")
									&& terrianTiles[i][j].getFood() == Integer
											.parseInt(split[1])) {
								terrianTiles[i][j] = null;
								player.setTerrianTiles(terrianTiles);
								flag = true;
								break;
							} else if (split[2].equals("wood")
									&& terrianTiles[i][j].getWood() == Integer
											.parseInt(split[1])) {
								terrianTiles[i][j] = null;
								player.setTerrianTiles(terrianTiles);
								flag = true;
								break;
							} else if (split[2].equals("favor")
									&& terrianTiles[i][j].getFavor() == Integer
											.parseInt(split[1])) {
								terrianTiles[i][j] = null;
								player.setTerrianTiles(terrianTiles);
								flag = true;
								break;
							} else if (split[2].equals("gold")
									&& terrianTiles[i][j].getGold() == Integer
											.parseInt(split[1])) {
								terrianTiles[i][j] = null;
								player.setTerrianTiles(terrianTiles);
								flag = true;
								break;
							}
						}
					}
					if (flag) {
						break;
					}
				}
				imageManipulator.redrawImage(playerBoard, player);
				dialog.dispose();
				int reply = JOptionPane
						.showConfirmDialog(
								null,
								"Do you want to perform the action specified on the card?",
								"Perform Action", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					playCard();
					return;
				} else
					setTurn(player);
				return;
			}
		});
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	private void playCard() {
		super.play();
	}
}
