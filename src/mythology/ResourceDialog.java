package mythology;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ResourceDialog extends JDialog {

	private TerrianTile tile1;
	private TerrianTile tile2;
	private TerrianTile tile3;
	private TerrianTile tile4;
	private TerrianTile tile5;
	private TerrianTile tile6;
	private TerrianTile tile7;
	private TerrianTile tile8;
	private TerrianTile tile9;
	private TerrianTile tile10;
	private TerrianTile tile11;
	private TerrianTile tile12;
	private TerrianTile tile13;
	private TerrianTile tile14;
	private TerrianTile tile15;
	private TerrianTile tile16;
	private TerrianTile tile17;
	private TerrianTile tile18;
	private int player1Turn = 0;
	private int player2Turn = 0;
	private int player3Turn = 0;
	public ArrayList<TerrianTile> terrianTilesList = new ArrayList<TerrianTile>();
	private Player player;
	Boolean[] buildingUnits = new Boolean[10];
	PlayerBoard playerBoard;
	ImageManipulator imageManipulator;
	ResourceDialog resourceDialog = null;
	public ArrayList<TerrianTile> tempTerrianTiles = new ArrayList<TerrianTile>();
	int counter = 0;
	boolean pass = true;

	public ResourceDialog(PlayerBoard playerBoard) {
		setTitle("Resource tiles");
		imageManipulator = new ImageManipulator();
		this.playerBoard = playerBoard;
		resourceDialog = this;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(878, 235);
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);

		setLayout(new GridBagLayout());
		this.setContentPane(panel);

		tempTerrianTiles = createListOfTerrianTiles();

		randomizeTerrianTiles();

		panel.add(tile1.getLabel());
		terrianTilesList.add(tile1);
		panel.add(tile2.getLabel());
		terrianTilesList.add(tile2);
		panel.add(tile3.getLabel());
		terrianTilesList.add(tile3);
		panel.add(tile4.getLabel());
		terrianTilesList.add(tile4);
		panel.add(tile5.getLabel());
		terrianTilesList.add(tile5);
		panel.add(tile6.getLabel());
		terrianTilesList.add(tile6);
		panel.add(tile7.getLabel());
		terrianTilesList.add(tile7);
		panel.add(tile8.getLabel());
		terrianTilesList.add(tile8);
		panel.add(tile9.getLabel());
		terrianTilesList.add(tile9);
		panel.add(tile10.getLabel());
		terrianTilesList.add(tile10);
		panel.add(tile11.getLabel());
		terrianTilesList.add(tile11);
		panel.add(tile12.getLabel());
		terrianTilesList.add(tile12);
		panel.add(tile13.getLabel());
		terrianTilesList.add(tile13);
		panel.add(tile14.getLabel());
		terrianTilesList.add(tile14);
		panel.add(tile15.getLabel());
		terrianTilesList.add(tile15);
		panel.add(tile16.getLabel());
		terrianTilesList.add(tile16);
		panel.add(tile17.getLabel());
		terrianTilesList.add(tile17);
		panel.add(tile18.getLabel());
		terrianTilesList.add(tile18);

		clickEventListener();

		this.setContentPane(panel);

		this.setVisible(false);

	}

	/**
	 * Fetches the images of 20 terrian tiles in JLabel and adds them into a
	 * list of TerrianTile type
	 */
	public ArrayList<TerrianTile> createListOfTerrianTiles() {
		ArrayList<TerrianTile> terrianTilesList = new ArrayList<>();
		TerrianTile temp;
		Path path = Paths.get("").resolve("Images/Desert1Gold.jpg")
				.toAbsolutePath();

		JLabel label1 = new JLabel(new ImageIcon(path.toString()));
		label1.setName("Desert 1 Gold");
		temp = new TerrianTile();
		temp.setLabel(label1);
		temp.setTerrianType("Desert");
		temp.setGold(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Desert2Favor.jpg")
				.toAbsolutePath();
		JLabel label2 = new JLabel(new ImageIcon(path.toString()));
		label2.setName("Desert 2 Favor");
		temp = new TerrianTile();
		temp.setLabel(label2);
		temp.setTerrianType("Desert");
		temp.setFavor(2);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Fertile1Favor.jpg")
				.toAbsolutePath();
		JLabel label3 = new JLabel(new ImageIcon(path.toString()));
		label3.setName("Fertile 1 Favor");
		temp = new TerrianTile();
		temp.setLabel(label3);
		temp.setTerrianType("Fertile");
		temp.setFavor(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Fertile1Gold.jpg")
				.toAbsolutePath();
		JLabel label4 = new JLabel(new ImageIcon(path.toString()));
		label4.setName("Fertile 1 Gold");
		temp = new TerrianTile();
		temp.setLabel(label4);
		temp.setTerrianType("Fertile");
		temp.setGold(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Fertile1Wood.jpg")
				.toAbsolutePath();
		JLabel label5 = new JLabel(new ImageIcon(path.toString()));
		label5.setName("Fertile 1 Wood");
		temp = new TerrianTile();
		temp.setLabel(label5);
		temp.setTerrianType("Fertile");
		temp.setWood(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Fertile2Food.jpg")
				.toAbsolutePath();
		JLabel label6 = new JLabel(new ImageIcon(path.toString()));
		label6.setName("Fertile 2 Food");
		temp = new TerrianTile();
		temp.setLabel(label6);
		temp.setTerrianType("Fertile");
		temp.setFood(2);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Forest1Favor.jpg")
				.toAbsolutePath();
		JLabel label7 = new JLabel(new ImageIcon(path.toString()));
		label7.setName("Forest 1 Favor");
		temp = new TerrianTile();
		temp.setLabel(label7);
		temp.setTerrianType("Forest");
		temp.setFavor(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Forest1Food.jpg").toAbsolutePath();
		JLabel label8 = new JLabel(new ImageIcon(path.toString()));
		label8.setName("Forest 1 Food");
		temp = new TerrianTile();
		temp.setLabel(label8);
		temp.setTerrianType("Forest");
		temp.setFood(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Forest1Gold.jpg").toAbsolutePath();
		JLabel label9 = new JLabel(new ImageIcon(path.toString()));
		label9.setName("Forest 1 Gold");
		temp = new TerrianTile();
		temp.setLabel(label9);
		temp.setTerrianType("Forest");
		temp.setGold(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Forest2Wood.jpg").toAbsolutePath();
		JLabel label10 = new JLabel(new ImageIcon(path.toString()));
		label10.setName("Forest 2 Wood");
		temp = new TerrianTile();
		temp.setLabel(label10);
		temp.setTerrianType("Forest");
		temp.setWood(2);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Hills1Favor.jpg").toAbsolutePath();
		JLabel label11 = new JLabel(new ImageIcon(path.toString()));
		label11.setName("Hills 1 Favor");
		temp = new TerrianTile();
		temp.setLabel(label11);
		temp.setTerrianType("Hills");
		temp.setFavor(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Hills1Food.jpg").toAbsolutePath();
		JLabel label12 = new JLabel(new ImageIcon(path.toString()));
		label12.setName("Hills 1 Food");
		temp = new TerrianTile();
		temp.setLabel(label12);
		temp.setTerrianType("Hills");
		temp.setFood(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Hills1Wood.jpg").toAbsolutePath();
		JLabel label13 = new JLabel(new ImageIcon(path.toString()));
		label13.setName("Hills 1 Wood");
		temp = new TerrianTile();
		temp.setLabel(label13);
		temp.setTerrianType("Hills");
		temp.setWood(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Hills2GOld.jpg").toAbsolutePath();
		JLabel label14 = new JLabel(new ImageIcon(path.toString()));
		label14.setName("Hills 2 GOld");
		temp = new TerrianTile();
		temp.setLabel(label14);
		temp.setTerrianType("Hills");
		temp.setGold(2);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Mountain1Favor.jpg")
				.toAbsolutePath();
		JLabel label15 = new JLabel(new ImageIcon(path.toString()));
		label15.setName("Mountain 1 Favor");
		temp = new TerrianTile();
		temp.setLabel(label15);
		temp.setTerrianType("Mountains");
		temp.setFavor(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Mountain1Wood.jpg")
				.toAbsolutePath();
		JLabel label16 = new JLabel(new ImageIcon(path.toString()));
		label16.setName("Mountain 1 Wood");
		temp = new TerrianTile();
		temp.setLabel(label16);
		temp.setTerrianType("Mountains");
		temp.setWood(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Mountain2Gold.jpg")
				.toAbsolutePath();
		JLabel label17 = new JLabel(new ImageIcon(path.toString()));
		label17.setName("Mountain 2 Gold");
		temp = new TerrianTile();
		temp.setLabel(label17);
		temp.setTerrianType("Mountains");
		temp.setGold(2);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Swamp1Favor.jpg").toAbsolutePath();
		JLabel label18 = new JLabel(new ImageIcon(path.toString()));
		label18.setName("Swamp 1 Favor");
		temp = new TerrianTile();
		temp.setLabel(label18);
		temp.setTerrianType("Swamp");
		temp.setFavor(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Swamp1Food.jpg").toAbsolutePath();
		JLabel label19 = new JLabel(new ImageIcon(path.toString()));
		label19.setName("Swamp 1 Food");
		temp = new TerrianTile();
		temp.setLabel(label19);
		temp.setTerrianType("Swamp");
		temp.setFood(1);
		terrianTilesList.add(temp);

		path = Paths.get("").resolve("Images/Swamp1Wood.jpg").toAbsolutePath();
		JLabel label20 = new JLabel(new ImageIcon(path.toString()));
		label20.setName("Swamp 1 Wood");
		temp = new TerrianTile();
		temp.setLabel(label20);
		temp.setTerrianType("Swamp");
		temp.setWood(1);
		terrianTilesList.add(temp);
		return terrianTilesList;
	}

	private void randomizeTerrianTiles() {
		Random randomizer = new Random();
		int index = 0;

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile1 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile2 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile3 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile4 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile5 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile6 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile7 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile8 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile9 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile10 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile11 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile12 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile13 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile14 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile15 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile16 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile17 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

		index = randomizer.nextInt(tempTerrianTiles.size());
		tile18 = tempTerrianTiles.get(index);
		tempTerrianTiles.remove(index);

	}

	private void clickEventListener() {
		tile1.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile1, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile1.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile1);
						pass = false;
						message();
					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile2.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile2, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile2.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile2);
						pass = false;
						message();
					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile3.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile3, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile3.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile3);
						pass = false;
						message();
					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = false;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile4.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile4, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile4.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile4);
						pass = false;
						message();
					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile5.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile5, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile5.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile5);
						pass = false;
						message();

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile6.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile6, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile6.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile6);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile7.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile7, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile7.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile7);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile8.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile8, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile8.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile8);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile9.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile9, playerBoard, player)) {
						resourceDialog.getContentPane()
								.remove(tile9.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile9);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}

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
				// TODO Auto-generated method stub

			}
		});
		tile10.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile10, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile10.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile10);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile11.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile11, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile11.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile11);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile12.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile12, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile12.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile12);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile13.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile13, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile13.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile13);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile14.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile14, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile14.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile14);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile15.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile15, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile15.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile15);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile16.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile16, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile16.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile16);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile17.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile17, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile17.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile17);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
		tile18.getLabel().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (player1Turn <= 6) {
					if (imageManipulator.repaint(tile18, playerBoard, player)) {
						resourceDialog.getContentPane().remove(
								tile18.getLabel());
						resourceDialog.getContentPane().revalidate();
						resourceDialog.getContentPane().repaint();
						resourceDialog.repaint();
						terrianTilesList.remove(tile18);
						pass = false;

					}
					counter++;
					if (counter % 2 == 1 || pass) {
						aiPlay();
					}
					pass = true;
					message();
					player1Turn++;
				}
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
				// TODO Auto-generated method stub

			}
		});
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private void aiPlay() {
		if (player2Turn <= 6) {
			setPlayer(playerBoard.aiPlayer1.getPlayer());
			playerBoard.aiPlayer1.terrianFirstFit(terrianTilesList,
					resourceDialog);
			player2Turn++;
		}

		setPlayer(playerBoard.aiPlayer2.getPlayer());
		if (player3Turn <= 6) {

			playerBoard.aiPlayer2.terrianFirstFit(terrianTilesList,
					resourceDialog);
			player3Turn++;
		}
		if (player3Turn <= 6) {
			playerBoard.aiPlayer2.terrianFirstFit(terrianTilesList,
					resourceDialog);
			player3Turn++;
		}
		if (player2Turn <= 6) {
			setPlayer(playerBoard.aiPlayer1.getPlayer());
			playerBoard.aiPlayer1.terrianFirstFit(terrianTilesList,
					resourceDialog);
			player2Turn++;
		}
		setPlayer(playerBoard.getHumanPlayer());

	}

	private void message() {
		if (resourceDialog.getContentPane().getComponentCount() == 0) {
			resourceDialog.dispose();
			resourceDialog.setVisible(false);
			JOptionPane.showMessageDialog(resourceDialog,
					"Game is Ready to Play!", "Ready",
					JOptionPane.INFORMATION_MESSAGE);
			player.getTerrianTiles();
			setPlayer(playerBoard.aiPlayer1.getPlayer());
			player.getTerrianTiles();
			setPlayer(playerBoard.aiPlayer2.getPlayer());
			player.getTerrianTiles();

		}
	}
}
