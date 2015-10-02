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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ActionCardDialog extends JDialog {
	public ActionCardDialog actionCards;
	private ImageManipulator manipulate;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private Player player;
	private boolean flag1 = false;
	private boolean flag2 = false;
	private boolean flag3 = false;
	private boolean flag4 = false;
	private boolean flag5 = false;
	private boolean flag6 = false;
	private boolean flag7 = false;
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
	private ArrayList<ActionCardType> cards = new ArrayList<ActionCardType>();
	private int maxCardsAllowed = 0;
	private BuildingTileDialog buildingDialog;

	public ActionCardDialog(Player player, PlayerBoard playerBoard, BuildingTileDialog buildingDialog) {
		setTitle("Permanent action cards");
		this.buildingDialog = buildingDialog;
		this.player = player;
		maxCardsAllowed = this.player.getAge().equals("Archaic") ? 4
				: (this.player.getAge().equals("Classical") ? 5
						: (this.player.getAge().equals("Heroic") ? 6
								: (this.player.getAge().equals("Mythic") ? 7 : 0)));
		this.playerBoard = playerBoard;
		manipulate = new ImageManipulator();
		actionCards = this;
		setSize(1200, 305);
		setPanel(new JPanel());
		getPanel().setBackground(Color.black);
		setLayout(new BorderLayout());
		getPanel().setLayout(new GridBagLayout());
		setContentPane(getPanel());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 0, 5);

		image1 = new BufferedImage(player.getActioncardsPermanent().get(0).getImage().getWidth(),
				player.getActioncardsPermanent().get(0).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image1.createGraphics().drawImage(player.getActioncardsPermanent().get(0).getImage(), 0, 0, null);
		label1 = new JLabel(new ImageIcon(image1));
		getPanel().add(label1, constraints);

		image2 = new BufferedImage(player.getActioncardsPermanent().get(1).getImage().getWidth(),
				player.getActioncardsPermanent().get(1).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image2.createGraphics().drawImage(player.getActioncardsPermanent().get(1).getImage(), 0, 0, null);
		label2 = new JLabel(new ImageIcon(image2));
		constraints.gridx = 1;
		constraints.gridy = 0;
		getPanel().add(label2, constraints);

		image3 = new BufferedImage(player.getActioncardsPermanent().get(2).getImage().getWidth(),
				player.getActioncardsPermanent().get(2).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image3.createGraphics().drawImage(player.getActioncardsPermanent().get(2).getImage(), 0, 0, null);
		label3 = new JLabel(new ImageIcon(image3));
		constraints.gridx = 2;
		constraints.gridy = 0;
		getPanel().add(label3, constraints);

		image4 = new BufferedImage(player.getActioncardsPermanent().get(3).getImage().getWidth(),
				player.getActioncardsPermanent().get(3).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image4.createGraphics().drawImage(player.getActioncardsPermanent().get(3).getImage(), 0, 0, null);
		label4 = new JLabel(new ImageIcon(image4));
		constraints.gridx = 3;
		constraints.gridy = 0;
		getPanel().add(label4, constraints);

		image5 = new BufferedImage(player.getActioncardsPermanent().get(4).getImage().getWidth(),
				player.getActioncardsPermanent().get(4).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image5.createGraphics().drawImage(player.getActioncardsPermanent().get(4).getImage(), 0, 0, null);
		label5 = new JLabel(new ImageIcon(image5));
		constraints.gridx = 4;
		constraints.gridy = 0;
		getPanel().add(label5, constraints);

		image6 = new BufferedImage(player.getActioncardsPermanent().get(5).getImage().getWidth(),
				player.getActioncardsPermanent().get(5).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image6.createGraphics().drawImage(player.getActioncardsPermanent().get(5).getImage(), 0, 0, null);
		label6 = new JLabel(new ImageIcon(image6));
		constraints.gridx = 5;
		constraints.gridy = 0;
		getPanel().add(label6, constraints);

		image7 = new BufferedImage(player.getActioncardsPermanent().get(6).getImage().getWidth(),
				player.getActioncardsPermanent().get(6).getImage().getHeight(), BufferedImage.TYPE_INT_RGB);
		image7.createGraphics().drawImage(player.getActioncardsPermanent().get(6).getImage(), 0, 0, null);
		label7 = new JLabel(new ImageIcon(image7));
		constraints.gridx = 6;
		constraints.gridy = 0;
		getPanel().add(label7, constraints);

		button = new JButton("Done");

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(2, 0, 0, 0);
		constraints.ipadx = 1100;
		constraints.ipady = 0;
		constraints.gridwidth = 7;
		getPanel().add(button, constraints);
		setVisible(true);
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
				if (!flag1) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label1, actionCards);

						cards.add(player.getActioncardsPermanent().get(0));
					}
					flag1 = true;
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
				if (!flag2) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label2, actionCards);
						cards.add(player.getActioncardsPermanent().get(1));
					}
					flag2 = true;
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
				if (!flag3) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label3, actionCards);
						cards.add(player.getActioncardsPermanent().get(2));
					}
					flag3 = true;
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
				if (!flag4) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label4, actionCards);
						cards.add(player.getActioncardsPermanent().get(3));
					}
					flag4 = true;
				}
			}

		});
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
				if (!flag5) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label5, actionCards);
						cards.add(player.getActioncardsPermanent().get(4));
					}
					flag5 = true;
				}

			}
		});
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
				if (!flag6) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label6, actionCards);
						cards.add(player.getActioncardsPermanent().get(5));
					}
					flag6 = true;
				}
			}
		});
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
				if (!flag7) {
					counter++;
					if (counter <= maxCardsAllowed) {
						manipulate.drawCross(label7, actionCards);
						cards.add(player.getActioncardsPermanent().get(6));
					}
					flag7 = true;
				}
			}
		});
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
				if (counter < maxCardsAllowed) {
					assignRandomActionCards(maxCardsAllowed - counter);
				}
				playerhand = new PlayerHandDialog(player, playerBoard, cards, buildingDialog);
				actionCards.dispose();
				playerBoard.aiPlayer1.assignCards();
				playerBoard.aiPlayer2.assignCards();
			}
		});
	}

	private void assignRandomActionCards(int numberOfCards) {
		Random random = new Random();
		List<ActionCardType> randomCards = new ArrayList<ActionCardType>();
		randomCards.addAll(player.getActioncardsRandom());
		int index = 0;
		for (int i = 0; i < numberOfCards; i++) {
			index = random.nextInt(randomCards.size());
			cards.add(randomCards.get(index));
			randomCards.remove(index);
		}
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
