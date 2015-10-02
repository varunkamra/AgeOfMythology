package mythology;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerHandDialog extends JDialog {
	public PlayerHandDialog playersHand;
	private ImageManipulator manipulate;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private Player player;
	private boolean flag = true;
	private int counter = 0;
	private JButton button;
	private PlayerBoard playerBoard;
	private BufferedImage image1 = null;
	private BufferedImage image2 = null;
	private BufferedImage image3 = null;
	private BufferedImage image4 = null;
	private BufferedImage image5 = null;
	private BufferedImage image6 = null;
	private BufferedImage image7 = null;
	private JPanel panel = null;
	private ActionCard actionCard = null;
	private ArrayList<ActionCardType> cards = null;
	private int index;
	private BuildingTileDialog buildingDialog;
	private int cardPlay = 0;
	private List<Integer> cardsPlayed = new ArrayList<>();
	public static int cardsAllowed = 3;

	public PlayerHandDialog(Player player, PlayerBoard playerBoard,
			ArrayList<ActionCardType> selectedCards,
			BuildingTileDialog buildingDialog) {
		setTitle("Player's hand cards");
		this.buildingDialog = buildingDialog;
		this.player = player;
		this.playerBoard = playerBoard;
		cards = selectedCards;
		manipulate = new ImageManipulator();
		playersHand = this;
		// setSize(1200, 305);
		setPanel(new JPanel());
		getPanel().setBackground(Color.black);
		setLayout(new BorderLayout());

		getPanel().setLayout(new GridBagLayout());
		setContentPane(getPanel());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 0, 5);

		image1 = new BufferedImage(selectedCards.get(0).getImage().getWidth(),
				selectedCards.get(0).getImage().getHeight(),
				BufferedImage.TYPE_INT_RGB);
		image1.createGraphics().drawImage(selectedCards.get(0).getImage(), 0,
				0, null);

		label1 = new JLabel(new ImageIcon(image1));
		getPanel().add(label1, constraints);

		image2 = new BufferedImage(selectedCards.get(1).getImage().getWidth(),
				selectedCards.get(1).getImage().getHeight(),
				BufferedImage.TYPE_INT_RGB);
		image2.createGraphics().drawImage(selectedCards.get(1).getImage(), 0,
				0, null);

		label2 = new JLabel(new ImageIcon(image2));
		constraints.gridx = 1;
		constraints.gridy = 0;
		getPanel().add(label2, constraints);

		image3 = new BufferedImage(selectedCards.get(2).getImage().getWidth(),
				selectedCards.get(2).getImage().getHeight(),
				BufferedImage.TYPE_INT_RGB);
		image3.createGraphics().drawImage(selectedCards.get(2).getImage(), 0,
				0, null);

		label3 = new JLabel(new ImageIcon(image3));
		constraints.gridx = 2;
		constraints.gridy = 0;
		getPanel().add(label3, constraints);

		image4 = new BufferedImage(selectedCards.get(3).getImage().getWidth(),
				selectedCards.get(3).getImage().getHeight(),
				BufferedImage.TYPE_INT_RGB);
		image4.createGraphics().drawImage(selectedCards.get(3).getImage(), 0,
				0, null);

		label4 = new JLabel(new ImageIcon(image4));
		constraints.gridx = 3;
		constraints.gridy = 0;
		getPanel().add(label4, constraints);

		if (this.player.getAge().equals("Classical")
				|| this.player.getAge().equals("Heroic")) {
			image5 = new BufferedImage(selectedCards.get(4).getImage()
					.getWidth(), selectedCards.get(4).getImage().getHeight(),
					BufferedImage.TYPE_INT_RGB);
			image5.createGraphics().drawImage(selectedCards.get(4).getImage(),
					0, 0, null);

			label5 = new JLabel(new ImageIcon(image5));
			constraints.gridx = 4;
			constraints.gridy = 0;
			getPanel().add(label5, constraints);
		}
		if (this.player.getAge().equals("Heroic")
				|| this.player.getAge().equals("Mythic")) {
			image6 = new BufferedImage(selectedCards.get(5).getImage()
					.getWidth(), selectedCards.get(5).getImage().getHeight(),
					BufferedImage.TYPE_INT_RGB);
			image6.createGraphics().drawImage(selectedCards.get(5).getImage(),
					0, 0, null);

			label6 = new JLabel(new ImageIcon(image6));
			constraints.gridx = 5;
			constraints.gridy = 0;
			getPanel().add(label6, constraints);
		}
		if (player.getAge().equals("Mythic")) {
			image7 = new BufferedImage(selectedCards.get(6).getImage()
					.getWidth(), selectedCards.get(6).getImage().getHeight(),
					BufferedImage.TYPE_INT_RGB);
			image7.createGraphics().drawImage(selectedCards.get(6).getImage(),
					0, 0, null);

			label7 = new JLabel(new ImageIcon(image7));
			constraints.gridx = 6;
			constraints.gridy = 0;
			getPanel().add(label7, constraints);
		}
		button = new JButton("Play");

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(2, 0, 0, 0);
		constraints.gridwidth = 7;
		getPanel().add(button, constraints);
		setVisible(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		listeners();
		pack();

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
				if (flag) {
					cardPlay++;
					index = 0;
					if (cardPlay <= cardsAllowed) {
						manipulate.drawCross(label1, playersHand);
					}
					flag = false;
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
				if (flag) {
					cardPlay++;
					index = 1;
					if (cardPlay <= cardsAllowed) {
						manipulate.drawCross(label2, playersHand);
					}
					flag = false;
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
				if (flag) {
					cardPlay++;
					index = 2;
					if (cardPlay <= cardsAllowed) {
						manipulate.drawCross(label3, playersHand);
					}
					flag = false;
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
				if (flag) {
					cardPlay++;
					index = 3;
					if (cardPlay <= cardsAllowed) {
						manipulate.drawCross(label4, playersHand);
					}
					flag = false;
				}
			}

		});
		if (label5 != null) {
			label5.addMouseListener(new MouseListener() {

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
					if (flag) {
						cardPlay++;
						index = 4;
						if (cardPlay <= cardsAllowed) {
							manipulate.drawCross(label5, playersHand);
						}
						flag = false;
					}

				}
			});
		}
		if (label6 != null) {
			label6.addMouseListener(new MouseListener() {

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
					if (flag) {
						cardPlay++;
						index = 5;
						if (cardPlay <= cardsAllowed) {
							manipulate.drawCross(label6, playersHand);
						}
						flag = false;
					}
				}
			});
		}
		if (label7 != null) {
			label7.addMouseListener(new MouseListener() {

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
					if (flag) {
						cardPlay++;
						index = 6;
						if (cardPlay <= cardsAllowed) {
							manipulate.drawCross(label7, playersHand);
						}
						flag = false;
					}
				}
			});
		}
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
				if (cardPlay <= cardsAllowed && !cardsPlayed.contains(index)) {
					actionCard = actionCardPlayed(cards, index, buildingDialog);
					cardsPlayed.add(index);
				}
				if (actionCard != null) {
					if (cardPlay <= 3) {
						new Observer1(playerBoard.aiPlayer1,
								playerBoard.aiPlayer2, actionCard);
						new Observer2(playerBoard.aiPlayer1,
								playerBoard.aiPlayer2, actionCard);
					}
					actionCard.play();
					flag = true;
					actionCard = null;
				} else {
					playersHand.dispose();
				}
			}
		});

	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	private ActionCard actionCardPlayed(
			ArrayList<ActionCardType> selectedCards, int index,
			BuildingTileDialog buildingDialog) {

		if (selectedCards.get(index).getCardType().equals("Explore")
				&& selectedCards.get(index).getGod() == null) {
			return new ExploreCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod() == null) {
			return new GatherCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod().equals("Skadi")) {
			return new GatherSkadi(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod().equals("Hades")) {
			return new GatherHades(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod().equals("Thor")) {
			return new GatherThor(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Dionysus")) {
			return new GatherDionysus(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Ra")) {
			return new GatherRa(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Gather")
				&& selectedCards.get(index).getGod() != null
				&& (selectedCards.get(index).getGod().equals("Freyia") || selectedCards
						.get(index).getGod().equals("Poseidon"))) {
			return new GatherFreyiaPoseidon(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Build")
				&& selectedCards.get(index).getGod() == null) {
			return new BuildCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Build")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Hera")) {
			return new BuildHera(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Build")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Horus")) {
			return new BuildHorus(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Build")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Njord")) {
			return new BuildNjord(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Recruit")
				&& selectedCards.get(index).getGod() == null) {
			return new RecruitCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Recruit")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Anubis")) {
			return new RecruitAnubis(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Recruit")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Hel")) {
			return new RecruitHel(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Recruit")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Apollo")) {
			return new RecruitApollo(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Trade")
				&& selectedCards.get(index).getGod() == null) {
			return new TradeCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Trade")
				&& (selectedCards.get(index).getGod().equals("Hermes") || selectedCards
						.get(index).getGod().equals("Forseti"))) {
			return new TradeHermesForseti(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Next Age")
				&& selectedCards.get(index).getGod() == null) {
			return new NextAgeCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Attack")
				&& selectedCards.get(index).getGod() == null) {
			return new AttackCard(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Attack")
				&& (selectedCards.get(index).getGod().equals("Sekhmet") || selectedCards
						.get(index).getGod().equals("Ares"))) {
			return new AttackAresSekhmet(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Attack")
				&& selectedCards.get(index).getGod().equals("Bragi")) {
			return new AttackBragi(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Next Age")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Haphaestos")) {
			return new NextAgeHaphaestos(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Next Age")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Hathor")) {
			return new NextAgeHathor(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Next Age")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Zeus")) {
			return new NextAgeZeus(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Next Age")
				&& selectedCards.get(index).getGod() != null
				&& selectedCards.get(index).getGod().equals("Odin")) {
			return new NextAgeOdin(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		} else if (selectedCards.get(index).getCardType().equals("Explore")
				&& selectedCards.get(index).getGod() != null) {
			return new ExploreGod(playerBoard.resources, playerBoard,
					buildingDialog, selectedCards.get(index));
		}
		return null;
	}
}
