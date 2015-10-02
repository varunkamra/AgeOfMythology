package mythology;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ExploreCard extends ActionCard {
	public ExploreCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<TerrianTile> tempTerrianTiles = new ArrayList<TerrianTile>();
	public ArrayList<TerrianTile> terrianTiles = new ArrayList<TerrianTile>();
	private ExploreCard exploreCard = null;
	protected int numberOfTilesToDraw = 0;
	protected int numberOfTilesToTake = 1;
	private int count = 0;
	protected boolean otherPlayersPlay = true;
	private List<TerrianTile> terrianTilesDisplayed = new ArrayList<TerrianTile>();

	@Override
	public void play() {
		numberOfTilesToDraw = actionCard.getNumber();
		if (player.getPlayerRole().equals("Human")) {
			setTitle("Explore");
			tempTerrianTiles = resources.createListOfTerrianTiles();
			randomize(numberOfTilesToDraw);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			exploreCard = this;
			JPanel panel = new JPanel();
			panel.setBackground(Color.black);

			setLayout(new GridBagLayout());
			this.setContentPane(panel);
			for (int i = 0; i < terrianTiles.size(); i++) {
				panel.add(terrianTiles.get(i).getLabel());
				terrianTilesDisplayed.add(terrianTiles.get(i));

			}
			this.setVisible(true);
			pack();
			listener();
		} else if (player.getPlayerRole().equals("AI")) {
			boolean flag = false;
			Random random = new Random();
			int index;
			tempTerrianTiles = resources.createListOfTerrianTiles();
			randomize(numberOfTilesToDraw);
			count = 0;
			for (int i = 0; i < terrianTiles.size(); i++) {
				if (terrianTiles.get(i).getFavor() == 2
						|| terrianTiles.get(i).getFood() == 2
						|| terrianTiles.get(i).getGold() == 2
						|| terrianTiles.get(i).getWood() == 2) {
					if (aiPlayer1.player.getPlayerType().equals(
							player.getPlayerType())) {
						if (imageManipulator.repaint(terrianTiles.get(i),
								playerBoard, aiPlayer1.player)) {
							count++;
							flag = true;
							terrianTiles.remove(i);
							if (count == numberOfTilesToTake) {
								break;
							}
						}
					} else if (aiPlayer2.player.getPlayerType().equals(
							player.getPlayerType())) {
						if (imageManipulator.repaint(terrianTiles.get(i),
								playerBoard, aiPlayer2.player)) {
							count++;
							flag = true;
							terrianTiles.remove(i);
							if (count == numberOfTilesToTake) {
								break;
							}
						}
					}
				}
			}
			if (!flag) {
				for (int i = 0; i < terrianTiles.size(); i++) {
					if (terrianTiles.get(i).getFavor() == 1
							|| terrianTiles.get(i).getFood() == 1
							|| terrianTiles.get(i).getGold() == 1
							|| terrianTiles.get(i).getWood() == 1) {
						if (aiPlayer1.player.getPlayerType().equals(
								player.getPlayerType())) {
							if (imageManipulator.repaint(terrianTiles.get(i),
									playerBoard, aiPlayer1.player)) {
								flag = true;
								terrianTiles.remove(i);
								count++;
								if (count == numberOfTilesToTake) {
									break;
								}
							}
						} else if (aiPlayer2.player.getPlayerType().equals(
								player.getPlayerType())) {
							if (imageManipulator.repaint(terrianTiles.get(i),
									playerBoard, aiPlayer2.player)) {
								flag = true;
								terrianTiles.remove(i);
								count++;
								if (count == numberOfTilesToTake) {
									break;
								}
							}
						}
					}
				}
			}
			if (otherPlayersPlay
					&& aiPlayer1.getPlayer().getPlayerType()
							.equals(player.getPlayerType())) {
				index = random.nextInt(terrianTiles.size());
				imageManipulator.repaint(terrianTiles.get(index), playerBoard,
						aiPlayer2.getPlayer());
				terrianTiles.remove(index);
				dialogBox();
				listener1();
			} else if (otherPlayersPlay
					&& aiPlayer2.getPlayer().getPlayerType()
							.equals(player.getPlayerType())) {
				index = random.nextInt(terrianTiles.size());
				imageManipulator.repaint(terrianTiles.get(index), playerBoard,
						aiPlayer1.getPlayer());
				terrianTiles.remove(index);
				dialogBox();
				listener1();
			} else {
				setTurn(player);
				return;
			}
		}
	}

	private void dialogBox() {
		setTitle("Explore");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		exploreCard = this;
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);

		setLayout(new GridBagLayout());
		this.setContentPane(panel);
		for (int i = 0; i < terrianTiles.size(); i++) {
			panel.add(terrianTiles.get(i).getLabel());
		}
		this.setVisible(true);
		pack();
	}

	private void randomize(int numberOfTilesToDraw) {
		Random randomizer = new Random();
		for (int i = 0; i < numberOfTilesToDraw; i++) {
			int index = 0;
			index = randomizer.nextInt(tempTerrianTiles.size());
			terrianTiles.add(tempTerrianTiles.get(index));
			tempTerrianTiles.remove(index);
		}

	}

	private void listener() {
		count = 0;
		for (int i = 0; i < terrianTiles.size(); i++) {

			terrianTiles.get(i).getLabel()
					.addMouseListener(new MouseListener() {

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
							TerrianTile tile = null;
							tile = getTerrianTile(((JLabel) e.getSource()));
							if (imageManipulator.repaint(tile, playerBoard,
									player)) {
								exploreCard.getContentPane().remove(
										tile.getLabel());
								exploreCard.getContentPane().revalidate();
								exploreCard.getContentPane().repaint();
								exploreCard.repaint();
								terrianTiles.remove(tile);
								count++;
								if (otherPlayersPlay
										&& count == numberOfTilesToTake) {
									playerBoard.aiPlayer2.terrianFirstFit(
											terrianTiles, exploreCard);
									playerBoard.aiPlayer1.terrianFirstFit(
											terrianTiles, exploreCard);
								}

								if (count == numberOfTilesToTake) {
									exploreCard.dispose();
									setTurn(player);
								}

							} else {
								if (otherPlayersPlay) {
									playerBoard.aiPlayer2.terrianFirstFit(
											terrianTiles, exploreCard);
									playerBoard.aiPlayer1.terrianFirstFit(
											terrianTiles, exploreCard);
								}
								exploreCard.dispose();
								setTurn(player);
							}
						}
					});
		}
	}

	private void listener1() {
		for (int i = 0; i < terrianTiles.size(); i++) {
			terrianTilesDisplayed.add(terrianTiles.get(i));
			terrianTiles.get(i).getLabel()
					.addMouseListener(new MouseListener() {

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
							TerrianTile tile = null;
							tile = getTerrianTile(((JLabel) e.getSource()));
							if (imageManipulator.repaint(tile, playerBoard,
									playerBoard.getHumanPlayer())) {
								exploreCard.getContentPane().remove(
										tile.getLabel());
								exploreCard.getContentPane().revalidate();
								exploreCard.getContentPane().repaint();
								exploreCard.repaint();
								terrianTiles.remove(tile);
								exploreCard.dispose();
								setTurn(player);
							} else {
								exploreCard.dispose();
								setTurn(player);
							}

						}
					});
		}
	}

	private TerrianTile getTerrianTile(JLabel label) {
		for (int i = 0; i < terrianTilesDisplayed.size(); i++) {
			if (terrianTilesDisplayed.get(i).getLabel().getName()
					.equals(label.getName())) {
				return terrianTilesDisplayed.get(i);
			}
		}
		return null;
	}
}
