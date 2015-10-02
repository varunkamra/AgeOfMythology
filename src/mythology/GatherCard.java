package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GatherCard extends ActionCard {

	public GatherCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
	}

	protected JRadioButton rButton1;
	protected JRadioButton rButton2;
	protected JRadioButton rButton3;
	protected JRadioButton rButton4;
	protected JRadioButton rButton5;
	protected JRadioButton rButton6;
	protected JRadioButton rButton7;
	protected JRadioButton rButton8;
	protected JRadioButton rButton9;
	protected JRadioButton rButton10;
	private JButton button;
	private ButtonGroup buttonGroup;
	private GatherCard gatherCard = null;

	protected boolean othersGather = true;
	protected int extraFood = 0;
	protected int gainGold = 0;
	protected int gainFood = 0;

	@Override
	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			setTitle("Gather");
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setSize(300, 450);
			x = (screenSize.width - this.getWidth()) / 2;
			y = (screenSize.height - this.getHeight()) / 2;
			setLocation(x, y);
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());

			initializeRadioButtons();
			button = new JButton("Gather");
			buttonGroup = new ButtonGroup();
			gatherCard = this;

			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;
			constraints.ipady = 5;
			constraints.anchor = GridBagConstraints.LINE_START;
			JLabel label = new JLabel("Select a resource type or terrian type");
			panel.add(label, constraints);

			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.ipady = 10;
			panel.add(rButton1, constraints);
			buttonGroup.add(rButton1);
			constraints.gridx = 0;
			constraints.gridy = 2;
			constraints.ipady = 5;
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
			constraints.insets = new Insets(10, 0, 0, 0);
			constraints.anchor = GridBagConstraints.CENTER;
			panel.add(button, constraints);

			this.setContentPane(panel);

			this.setVisible(true);
			listeners();
		} else if (player.getPlayerRole().equals("AI")) {
			String type = getTerrianOrResourceTypeForAI();
			aiPlay(type);

		}
	}

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

	}

	protected String getTerrianOrResourceTypeForAI() {
		List<String> options;
		options = Arrays.asList("Fertile", "Forest", "Desert", "Hills",
				"Swamp", "Mountains", "Wood", "Food", "Favor", "Gold");
		Random random = new Random();
		int index;
		index = random.nextInt(options.size());
		return options.get(index);
	}

	private void aiPlay(String type) {
		if (player.getPlayerType()
				.equals(aiPlayer1.getPlayer().getPlayerType())) {
			if (type.equals("Fertile") || type.equals("Forest")
					|| type.equals("Desert") || type.equals("Hills")
					|| type.equals("Mountains") || type.equals("Swamp")) {
				modifyAllResources(aiPlayer1.getPlayer(), type);
				addExtraForBuildings(player);
				gainGold();
				gainFood();
				extraFoodPerTile();
				if (othersGather) {
					modifyAllResources(aiPlayer2.getPlayer(), type);
					// player = playerBoard.getHumanPlayer();
					JOptionPane.showMessageDialog(null, "Gather " + type + "!");
					modifyAllResources(playerBoard.getHumanPlayer(), type);
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);
				} else {
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);
				}
			} else {
				modifySingleResource(aiPlayer1.getPlayer(), type);
				addExtraForBuildings(player);
				gainGold();
				gainFood();
				extraFoodPerTile();
				if (othersGather) {
					modifySingleResource(aiPlayer2.getPlayer(), type);
					// player = playerBoard.getHumanPlayer();
					JOptionPane.showMessageDialog(null, "Gather " + type + "!");
					modifySingleResource(playerBoard.getHumanPlayer(), type);
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);
				} else {
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);

				}
			}

		} else if (player.getPlayerType().equals(
				aiPlayer2.getPlayer().getPlayerType())) {
			if (type.equals("Fertile") || type.equals("Forest")
					|| type.equals("Desert") || type.equals("Hills")
					|| type.equals("Mountain") || type.equals("Swamp")) {
				modifyAllResources(aiPlayer2.getPlayer(), type);
				addExtraForBuildings(player);
				gainGold();
				gainFood();
				extraFoodPerTile();
				if (othersGather) {
					modifyAllResources(aiPlayer1.getPlayer(), type);
					// player = playerBoard.getHumanPlayer();
					JOptionPane.showMessageDialog(null, "Gather " + type + "!");
					modifyAllResources(playerBoard.getHumanPlayer(), type);
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);

				} else {
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);
				}
			} else {
				modifySingleResource(aiPlayer2.getPlayer(), type);
				addExtraForBuildings(player);
				gainGold();
				gainFood();
				extraFoodPerTile();
				if (othersGather) {
					modifySingleResource(aiPlayer1.getPlayer(), type);
					// player = playerBoard.getHumanPlayer();
					JOptionPane.showMessageDialog(null, "Gather " + type + "!");
					modifySingleResource(playerBoard.getHumanPlayer(), type);
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);
				} else {
					imageManipulator.redrawImage(playerBoard,
							playerBoard.getHumanPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer1.getPlayer());
					imageManipulator.redrawImage(playerBoard,
							aiPlayer2.getPlayer());
					setTurn(player);
				}
			}

		}

	}

	private void gainGold() {
		player.setGold(player.getGold() + gainGold);

	}

	private void gainFood() {
		player.setFood(player.getFood() + gainFood);
	}

	public void listeners() {
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
				if (rButton1.isSelected()) {
					modifyAllResources(player, "Fertile");
					if (othersGather) {
						modifyAllResources(aiPlayer1.getPlayer(), "Fertile");
						modifyAllResources(aiPlayer2.getPlayer(), "Fertile");
					}
				}
				if (rButton2.isSelected()) {
					modifyAllResources(player, "Forest");
					if (othersGather) {
						modifyAllResources(aiPlayer1.getPlayer(), "Forest");
						modifyAllResources(aiPlayer2.getPlayer(), "Forest");
					}
				}
				if (rButton3.isSelected()) {
					modifyAllResources(player, "Desert");
					if (othersGather) {
						modifyAllResources(aiPlayer1.getPlayer(), "Desert");
						modifyAllResources(aiPlayer2.getPlayer(), "Desert");
					}
				}
				if (rButton4.isSelected()) {
					modifyAllResources(player, "Hills");
					if (othersGather) {
						modifyAllResources(aiPlayer1.getPlayer(), "Hills");
						modifyAllResources(aiPlayer2.getPlayer(), "Hills");
					}
				}
				if (rButton5.isSelected()) {
					modifyAllResources(player, "Swamp");
					if (othersGather) {
						modifyAllResources(aiPlayer1.getPlayer(), "Swamp");
						modifyAllResources(aiPlayer2.getPlayer(), "Swamp");
					}
				}
				if (rButton6.isSelected()) {
					modifyAllResources(player, "Mountains");
					if (othersGather) {
						modifyAllResources(aiPlayer1.getPlayer(), "Mountains");
						modifyAllResources(aiPlayer2.getPlayer(), "Mountains");
					}
				}
				if (rButton7.isSelected()) {
					modifySingleResource(player, "Wood");
					if (othersGather) {
						modifySingleResource(aiPlayer1.getPlayer(), "Wood");
						modifySingleResource(aiPlayer2.getPlayer(), "Wood");
					}
				}
				if (rButton8.isSelected()) {
					modifySingleResource(player, "Food");
					extraFoodPerTile();
					if (othersGather) {
						modifySingleResource(aiPlayer1.getPlayer(), "Food");
						modifySingleResource(aiPlayer2.getPlayer(), "Food");
					}
				}
				if (rButton9.isSelected()) {
					modifySingleResource(player, "Gold");
					if (othersGather) {
						modifySingleResource(aiPlayer1.getPlayer(), "Gold");
						modifySingleResource(aiPlayer2.getPlayer(), "Gold");
					}
				}
				if (rButton10.isSelected()) {
					modifySingleResource(player, "Favor");
					if (othersGather) {
						modifySingleResource(aiPlayer1.getPlayer(), "Favor");
						modifySingleResource(aiPlayer2.getPlayer(), "Favor");
					}
				}
				addExtraForBuildings(player);
				gainGold();
				gainFood();
				imageManipulator.redrawImage(playerBoard, player);
				imageManipulator.redrawImage(playerBoard, aiPlayer1.getPlayer());
				imageManipulator.redrawImage(playerBoard, aiPlayer2.getPlayer());
				gatherCard.dispose();
				setTurn(player);

			}

		});
	}

	protected void addExtraForBuildings(Player player) {
		BuildingTile[] buildingTiles = player.getBuildingTiles();

		for (int i = 0; i < buildingTiles.length; i++) {
			if (buildingTiles[i] != null
					&& buildingTiles[i].getBuildingType().equals("Granary")) {
				player.setFood(player.getFood() + 2);
			}
			if (buildingTiles[i] != null
					&& buildingTiles[i].getBuildingType().equals("Gold Mint")) {
				player.setGold(player.getGold() + 2);
			}
			if (buildingTiles[i] != null
					&& buildingTiles[i].getBuildingType().equals(
							"Wood Workshop")) {
				player.setWood(player.getWood() + 2);
			}
			if (buildingTiles[i] != null
					&& buildingTiles[i].getBuildingType().equals("Monument")) {
				player.setFavor(player.getFavor() + 2);
			}
		}
	}

	private void modifyAllResources(Player player, String terrianType) {
		TerrianTile[][] terrianTiles = player.getTerrianTiles();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (terrianTiles[i][j] != null
						&& terrianTiles[i][j].getTerrianType().equals(
								terrianType)) {
					player.setFavor(player.getFavor()
							+ terrianTiles[i][j].getFavor());
					player.setFood(player.getFood()
							+ terrianTiles[i][j].getFood());
					player.setGold(player.getGold()
							+ terrianTiles[i][j].getGold());
					player.setWood(player.getWood()
							+ terrianTiles[i][j].getWood());
				}
			}
		}
	}

	private void modifySingleResource(Player player, String resourceType) {
		TerrianTile[][] terrianTiles = player.getTerrianTiles();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (terrianTiles[i][j] != null) {
					if (resourceType.equals("Wood")) {
						player.setWood(player.getWood()
								+ terrianTiles[i][j].getWood());
					} else if (resourceType.equals("Food")) {
						player.setFood(player.getFood()
								+ terrianTiles[i][j].getFood());
					} else if (resourceType.equals("Favor")) {
						player.setFavor(player.getFavor()
								+ terrianTiles[i][j].getFavor());
					} else if (resourceType.equals("Gold")) {
						player.setGold(player.getGold()
								+ terrianTiles[i][j].getGold());
					}

				}
			}
		}
	}

	private void extraFoodPerTile() {
		TerrianTile[][] terrianTiles = player.getTerrianTiles();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (terrianTiles[i][j] != null) {
					player.setFood(player.getFood()
							+ (terrianTiles[i][j].getFood() == 0 ? 0
									: extraFood));

				}
			}
		}
	}
}
