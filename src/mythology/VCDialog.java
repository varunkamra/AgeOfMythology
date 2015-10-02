package mythology;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.imgscalr.Scalr;

@SuppressWarnings("serial")
public class VCDialog extends JDialog {
	public JDialog victoryCards;
	private ImageManipulator imageManipulator;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private Player player;
	private JButton button;
	private PlayerBoard playerBoard;
	private BufferedImage image1 = null;
	private BufferedImage image2 = null;
	private BufferedImage image3 = null;
	private BufferedImage image4 = null;
	private boolean flag = false;
	private int counter1 = 0;
	private int counter2 = 0;
	private int counter3 = 0;
	private int counter4 = 0;
	private int verticalMultiplier1 = 0;
	private int verticalMultiplier2 = 0;
	private int verticalMultiplier3 = 0;
	private int verticalMultiplier4 = 0;
	public static int wonder = 0;
	public static int lastbattle = 0;
	public static int largestArmy = 0;
	public static int mostBuildings = 0;
	private BuildingTileDialog buildingDialog;
	private ActionCardDialog actionCardDialog;
	private int turnNumber = 0;
	private int totalTurns = 25 / 3;

	public VCDialog(Player player, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog) {
		setTitle("Victory cards");
		this.buildingDialog = buildingDialog;
		this.player = player;
		this.playerBoard = playerBoard;
		imageManipulator = new ImageManipulator();
		victoryCards = this;
		setSize(900, 375);
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);

		setLayout(new GridBagLayout());
		setContentPane(panel);

		Path path = Paths.get("").resolve("Images/The wonder.jpg")
				.toAbsolutePath();

		try {
			image1 = Scalr.resize(ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 200, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

		label1 = new JLabel(new ImageIcon(image1));
		panel.add(label1);

		path = Paths.get("").resolve("Images/The most buildings.jpg")
				.toAbsolutePath();
		try {
			image2 = Scalr.resize(ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 200, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

		label2 = new JLabel(new ImageIcon(image2));
		panel.add(label2);

		path = Paths.get("").resolve("Images/The Largest Army.jpg")
				.toAbsolutePath();

		try {
			image3 = Scalr.resize(ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 200, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

		label3 = new JLabel(new ImageIcon(image3));
		panel.add(label3);

		path = Paths.get("").resolve("Images/Won the last battle.jpg")
				.toAbsolutePath();

		try {
			image4 = Scalr.resize(ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 200, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		label4 = new JLabel(new ImageIcon(image4));
		panel.add(label4);

		button = new JButton("Play");

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;

		panel.add(button, constraints);
		setVisible(false);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		listeners();

	}

	private void listeners() {
		label1.addMouseListener(new MouseListener() {

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
				if (turnNumber == totalTurns) {
					distributeVictoryPointCubesAndEndGame();
				}
				if (!flag) {
					imageManipulator.placeVictoryCubes(image1, victoryCards,
							player, playerBoard, counter1, verticalMultiplier1);
					flag = true;
					wonder++;
					counter1++;
					if (counter1 % 7 == 0) {
						verticalMultiplier1++;
						counter1 = 0;
					}
					placeVictoryCubesAI();
				}

			}
		});
		label2.addMouseListener(new MouseListener() {

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
				if (turnNumber == totalTurns) {
					distributeVictoryPointCubesAndEndGame();
				}
				if (!flag) {
					imageManipulator.placeVictoryCubes(image2, victoryCards,
							player, playerBoard, counter2, verticalMultiplier2);
					flag = true;
					mostBuildings++;
					counter2++;
					if (counter2 % 7 == 0) {
						verticalMultiplier2++;
						counter2 = 0;
					}
					placeVictoryCubesAI();
				}
			}
		});
		label3.addMouseListener(new MouseListener() {

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
				if (turnNumber == totalTurns) {
					distributeVictoryPointCubesAndEndGame();
				}
				if (!flag) {
					imageManipulator.placeVictoryCubes(image3, victoryCards,
							player, playerBoard, counter3, verticalMultiplier3);
					flag = true;
					largestArmy++;
					counter3++;
					if (counter3 % 7 == 0) {
						verticalMultiplier3++;
						counter3 = 0;
					}
					placeVictoryCubesAI();
				}

			}
		});
		label4.addMouseListener(new MouseListener() {

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
				if (turnNumber == totalTurns) {
					distributeVictoryPointCubesAndEndGame();
				}
				if (!flag) {
					imageManipulator.placeVictoryCubes(image4, victoryCards,
							player, playerBoard, counter4, verticalMultiplier4);
					flag = true;
					lastbattle++;
					counter4++;
					if (counter4 % 7 == 0) {
						verticalMultiplier4++;
						counter4 = 0;
					}
					placeVictoryCubesAI();
				}

			}

		});
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
				flag = false;
				turnNumber++;
				actionCardDialog = new ActionCardDialog(player, playerBoard,
						buildingDialog);
				ActionCard.spoil(playerBoard.getHumanPlayer(),
						playerBoard.aiPlayer1, playerBoard.aiPlayer2,
						playerBoard);
				victoryCards.setVisible(false);
				BuildCard.buildingCreated = 0;
				PlayerHandDialog.cardsAllowed = 3;

			}
		});
	}

	private void placeVictoryCubesAI() {
		Random random = new Random();
		for (int i = 0; i < 2; i++) {
			int card = random.nextInt(4);
			if (card == 0) {
				imageManipulator.placeVictoryCubes(image1, victoryCards,
						player, playerBoard, counter1, verticalMultiplier1);
				counter1++;
				wonder++;
				if (counter1 % 7 == 0) {
					verticalMultiplier1++;
					counter1 = 0;
				}
			} else if (card == 1) {
				imageManipulator.placeVictoryCubes(image2, victoryCards,
						player, playerBoard, counter2, verticalMultiplier2);
				counter2++;
				mostBuildings++;
				if (counter2 % 7 == 0) {
					verticalMultiplier2++;
					counter2 = 0;
				}
			} else if (card == 2) {
				imageManipulator.placeVictoryCubes(image3, victoryCards,
						player, playerBoard, counter3, verticalMultiplier3);
				counter3++;
				largestArmy++;
				if (counter3 % 7 == 0) {
					verticalMultiplier3++;
					counter3 = 0;
				}
			} else {
				imageManipulator.placeVictoryCubes(image4, victoryCards,
						player, playerBoard, counter4, verticalMultiplier4);
				counter4++;
				lastbattle++;
				if (counter4 % 7 == 0) {
					verticalMultiplier4++;
					counter4 = 0;
				}
			}
		}
	}

	private void distributeVictoryPointCubesAndEndGame() {
		BuildingTile[] buildings = player.getBuildingTiles();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null) {
				count1++;
			}
		}
		buildings = playerBoard.aiPlayer1.getPlayer().getBuildingTiles();
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null) {
				count2++;
			}
		}
		buildings = playerBoard.aiPlayer2.getPlayer().getBuildingTiles();
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null) {
				count3++;
			}
		}
		if (count1 > count2 && count1 > count3) {
			player.setVictory_cubes(player.getVictory_cubes() + mostBuildings);
			mostBuildings = 0;
		}
		if (count2 > count1 && count2 > count3) {
			playerBoard.aiPlayer1.getPlayer().setVictory_cubes(
					playerBoard.aiPlayer1.getPlayer().getVictory_cubes()
							+ mostBuildings);
			mostBuildings = 0;
		}
		if (count3 > count1 && count3 > count2) {
			playerBoard.aiPlayer2.getPlayer().setVictory_cubes(
					playerBoard.aiPlayer2.getPlayer().getVictory_cubes()
							+ mostBuildings);
			mostBuildings = 0;
		}
		count1 = 0;
		count2 = 0;
		count3 = 0;
		for (int i = 0; i < player.militaryUnits.size(); i++) {
			count1++;
		}
		for (int i = 0; i < playerBoard.aiPlayer1.getPlayer().militaryUnits
				.size(); i++) {
			count2++;
		}
		for (int i = 0; i < playerBoard.aiPlayer2.getPlayer().militaryUnits
				.size(); i++) {
			count3++;
		}
		if (count1 > count2 && count1 > count3) {
			player.setVictory_cubes(player.getVictory_cubes() + largestArmy);
			largestArmy = 0;
		}
		if (count2 > count1 && count2 > count3) {
			playerBoard.aiPlayer1.getPlayer().setVictory_cubes(
					playerBoard.aiPlayer1.getPlayer().getVictory_cubes()
							+ largestArmy);
			largestArmy = 0;
		}
		if (count3 > count1 && count3 > count2) {
			playerBoard.aiPlayer2.getPlayer().setVictory_cubes(
					playerBoard.aiPlayer2.getPlayer().getVictory_cubes()
							+ largestArmy);
			largestArmy = 0;
		}
		if (player.getVictory_cubes() > playerBoard.aiPlayer1.getPlayer()
				.getVictory_cubes()
				&& player.getVictory_cubes() > playerBoard.aiPlayer2
						.getPlayer().getVictory_cubes()) {
			JOptionPane.showMessageDialog(null, "You have won the game!");
		}
		if (playerBoard.aiPlayer1.getPlayer().getVictory_cubes() > player
				.getVictory_cubes()
				&& playerBoard.aiPlayer1.getPlayer().getVictory_cubes() > playerBoard.aiPlayer2
						.getPlayer().getVictory_cubes()) {
			JOptionPane.showMessageDialog(null, playerBoard.aiPlayer1
					.getPlayer().getPlayerType() + " has won the game!");
		}
		if (playerBoard.aiPlayer2.getPlayer().getVictory_cubes() > player
				.getVictory_cubes()
				&& playerBoard.aiPlayer2.getPlayer().getVictory_cubes() > playerBoard.aiPlayer1
						.getPlayer().getVictory_cubes()) {
			JOptionPane.showMessageDialog(null, playerBoard.aiPlayer1
					.getPlayer().getPlayerType() + " has won the game!");
		}
		imageManipulator.redrawImage(playerBoard, player);
		imageManipulator.redrawImage(playerBoard,
				playerBoard.aiPlayer1.getPlayer());
		imageManipulator.redrawImage(playerBoard,
				playerBoard.aiPlayer2.getPlayer());
		this.dispose();
	}
}
