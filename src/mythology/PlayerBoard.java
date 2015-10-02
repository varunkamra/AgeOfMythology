package mythology;

/** The main class.
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PlayerBoard extends JFrame {
	private BufferedImage greekImage = null;
	private BufferedImage egyptianImage = null;
	private BufferedImage norseImage = null;
	private JPanel contentPane;
	private JLabel labelGreek;
	private JLabel labelEgyptian;
	private JLabel labelNorse;
	private Player greek;
	private Player egyptian;
	private Player norse;
	private ImageManipulator imageManipulator;
	public ArtificialIntelligence aiPlayer1;
	public ArtificialIntelligence aiPlayer2;
	public ResourceDialog resources;
	final String player;
	private Player humanPlayer;
	public VCDialog victoryCards;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private BuildingTileDialog dialog;
	public int foodBank = 25;
	public int favorBank = 25;
	public int goldBank = 25;
	public int woodBank = 25;
	public int victoryCubes = 30;
	public PlayerBoard board;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PlayerBoard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public PlayerBoard() {
		board = this;
		imageManipulator = new ImageManipulator();
		String[] players = { "Greek", "Egyptian", "Norse" };
		player = (String) JOptionPane.showInputDialog(this, "Selcect the type of culture", "Player Type",
				JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
		if (player == null) {
			System.exit(0);
		}

		// Dialog for building tiles and resource tiles
		dialog = new BuildingTileDialog(this);
		resources = new ResourceDialog(this);

		initilizePlayers(player);

		// Player board
		setTitle("Age of Mythology");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		try {
			setGreekImage(ImageIO.read(new File(Paths.get("").resolve("Images/GreekBoard9x7.jpg").toString())));
			greek.setPlayerBoardImage(
					ImageIO.read(new File(Paths.get("").resolve("Images/GreekBoard9x7.jpg").toString())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Greek", null, scrollPane, null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridBagLayout());
		scrollPane.setViewportView(panel_2);
		panel_2.setBackground(Color.black);

		setLabelGreek(new JLabel(""));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		getLabelGreek().setIcon(new ImageIcon(getGreekImage()));
		panel_2.add(getLabelGreek(), constraints);

		button1 = new JButton("Victory Cards Dialog");
		button4 = new JButton("Enter Cheat Code");

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 0;
		constraints.ipadx = 300;
		constraints.anchor = GridBagConstraints.LINE_START;
		panel_2.add(button1, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.ipadx = 320;
		constraints.anchor = GridBagConstraints.LINE_END;
		panel_2.add(button4, constraints);
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Egyptian", null, scrollPane_1, null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridBagLayout());
		scrollPane_1.setViewportView(panel_1);
		panel_1.setBackground(Color.black);

		try {
			setEgyptianImage(ImageIO.read(new File(Paths.get("").resolve("Images/EgyptBoard9x7.jpg").toString())));
			egyptian.setPlayerBoardImage(
					ImageIO.read(new File(Paths.get("").resolve("Images/EgyptBoard9x7.jpg").toString())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setLabelEgyptian(new JLabel(""));

		getLabelEgyptian().setIcon(new ImageIcon(getEgyptianImage()));

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		panel_1.add(getLabelEgyptian(), constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.ipadx = 300;
		button2 = new JButton("Victory Cards Dialog");
		panel_1.add(button2, constraints);

		button5 = new JButton("Enter Cheat Code");
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.ipadx = 320;
		panel_1.add(button5, constraints);

		try {
			setNorseImage(ImageIO.read(new File(Paths.get("").resolve("Images/NorseBoard9x7.jpg").toString())));
			norse.setPlayerBoardImage(
					ImageIO.read(new File(Paths.get("").resolve("Images/NorseBoard9x7.jpg").toString())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Norse", null, scrollPane_2, null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.BLACK);
		scrollPane_2.setViewportView(panel);

		setLabelNorse(new JLabel(""));
		getLabelNorse().setIcon(new ImageIcon(getNorseImage()));
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		panel.add(getLabelNorse(), constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.ipadx = 300;
		button3 = new JButton("Victory Cards Dialog");
		panel.add(button3, constraints);

		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.ipadx = 320;
		button6 = new JButton("Enter Cheat Code");
		panel.add(button6, constraints);

		// Decide which tab needs to be displayed
		if (player.equals("Egyptian")) {
			tabbedPane.setSelectedIndex(1);
		} else if (player.equals("Norse")) {
			tabbedPane.setSelectedIndex(2);
		}

		// Draws resource cubes on the screen
		imageManipulator.initializeResourcesOnPlayerBoard(this);
		addActionListenersOnButtons();

		pack();
		this.setVisible(true);
		dialog.setVisible(true);
		resources.setVisible(true);
	}

	private void addActionListenersOnButtons() {
		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				victoryCards.setVisible(true);
			}
		};
		ActionListener b = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cheat = (String) JOptionPane.showInputDialog(null, "Enter cheat code:");
				if (cheat.equals("robinhood")) {
					humanPlayer.setWood(25);
					humanPlayer.setFood(25);
					humanPlayer.setFavor(25);
					humanPlayer.setGold(25);
					imageManipulator.redrawImage(board, humanPlayer);
				}

			}

		};
		button1.addActionListener(a);
		button2.addActionListener(a);
		button3.addActionListener(a);
		button4.addActionListener(b);
		button5.addActionListener(b);
		button6.addActionListener(b);
	}

	private void initilizePlayers(String player) {
		greek = new Player("Greek");

		egyptian = new Player("Egyptian");

		norse = new Player("Norse");

		if (player.equals("Greek")) {
			victoryCards = new VCDialog(greek, this, dialog);
			greek.setPlayerRole("Human");
			greek.setAge("Archaic");
			humanPlayer = greek;
			egyptian.setPlayerRole("AI");
			norse.setPlayerRole("AI");
			aiPlayer1 = new ArtificialIntelligenceEgyptian(this, egyptian);
			aiPlayer1.getPlayer().setAge("Archaic");
			aiPlayer2 = new ArtificialIntelligenceNorse(this, norse);
			aiPlayer2.getPlayer().setAge("Archaic");
			resources.setPlayer(greek);
		} else if (player.equals("Egyptian")) {
			victoryCards = new VCDialog(egyptian, this, dialog);
			greek.setPlayerRole("AI");
			egyptian.setPlayerRole("Human");
			egyptian.setAge("Archaic");
			humanPlayer = egyptian;
			norse.setPlayerRole("AI");
			aiPlayer1 = new ArtificialIntelligenceNorse(this, norse);
			aiPlayer1.getPlayer().setAge("Archaic");
			aiPlayer2 = new ArtificialIntelligenceGreek(this, greek);
			aiPlayer2.getPlayer().setAge("Archaic");
			resources.setPlayer(egyptian);
		} else {
			victoryCards = new VCDialog(norse, this, dialog);
			greek.setPlayerRole("AI");
			egyptian.setPlayerRole("AI");
			norse.setAge("Archaic");
			norse.setPlayerRole("Human");
			humanPlayer = norse;
			aiPlayer1 = new ArtificialIntelligenceGreek(this, greek);
			aiPlayer1.getPlayer().setAge("Archaic");
			aiPlayer2 = new ArtificialIntelligenceEgyptian(this, egyptian);
			aiPlayer2.getPlayer().setAge("Archaic");
			resources.setPlayer(norse);
		}
		aiPlayer1.setResource(resources);
		aiPlayer2.setResource(resources);
		aiPlayer1.setBuildingDialog(dialog);
		aiPlayer2.setBuildingDialog(dialog);

	}

	public BufferedImage getNorseImage() {
		return norseImage;
	}

	public void setNorseImage(BufferedImage norse) {
		this.norseImage = norse;
	}

	public BufferedImage getGreekImage() {
		return greekImage;
	}

	public void setGreekImage(BufferedImage greekImage) {
		this.greekImage = greekImage;
	}

	public BufferedImage getEgyptianImage() {
		return egyptianImage;
	}

	public void setEgyptianImage(BufferedImage egyptianImage) {
		this.egyptianImage = egyptianImage;
	}

	public Player getHumanPlayer() {
		return humanPlayer;
	}

	public void setHumanPlayer(Player humanPlayer) {
		this.humanPlayer = humanPlayer;
	}

	public JLabel getLabelGreek() {
		return labelGreek;
	}

	public void setLabelGreek(JLabel labelGreek) {
		this.labelGreek = labelGreek;
	}

	public JLabel getLabelEgyptian() {
		return labelEgyptian;
	}

	public void setLabelEgyptian(JLabel labelEgyptian) {
		this.labelEgyptian = labelEgyptian;
	}

	public JLabel getLabelNorse() {
		return labelNorse;
	}

	public void setLabelNorse(JLabel labelNorse) {
		this.labelNorse = labelNorse;
	}
}
