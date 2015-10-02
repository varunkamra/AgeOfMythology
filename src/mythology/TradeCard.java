package mythology;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TradeCard extends ActionCard {
	public TradeCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private JLabel playerlabel1;
	private JLabel playerlabel2;
	private JLabel playerlabel3;
	private JLabel playerlabel4;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel playerResources;
	private JLabel bankResources;
	private DefaultListModel<Integer> playerlistmodel1;
	private DefaultListModel<Integer> playerlistmodel2;
	private DefaultListModel<Integer> playerlistmodel3;
	private DefaultListModel<Integer> playerlistmodel4;
	private DefaultListModel<Integer> listmodel1;
	private DefaultListModel<Integer> listmodel2;
	private DefaultListModel<Integer> listmodel3;
	private DefaultListModel<Integer> listmodel4;
	private JList<Integer> playerlist1;
	private JList<Integer> playerlist2;
	private JList<Integer> playerlist3;
	private JList<Integer> playerlist4;
	private JList<Integer> list1;
	private JList<Integer> list2;
	private JList<Integer> list3;
	private JList<Integer> list4;
	private JScrollPane playerPane1;
	private JScrollPane playerPane2;
	private JScrollPane playerPane3;
	private JScrollPane playerPane4;
	private JScrollPane pane1;
	private JScrollPane pane2;
	private JScrollPane pane3;
	private JScrollPane pane4;
	private int total = 0;
	private TradeCard trade;
	private List<Integer> resourcesList = new ArrayList<>();
	private int index = 0;
	private boolean flag = false;
	private JButton button;

	@Override
	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			setTitle("Trade");
			trade = this;
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setSize(500, 500);
			JPanel panel = new JPanel();
			for (int i = 0; i < 4; i++) {
				resourcesList.add(i + 1);
			}
			panel.setLayout(new GridBagLayout());
			playerResources = new JLabel("Player's resources");
			bankResources = new JLabel("Bank resources");
			playerlistmodel1 = new DefaultListModel<Integer>();
			playerlistmodel2 = new DefaultListModel<Integer>();
			playerlistmodel3 = new DefaultListModel<Integer>();
			playerlistmodel4 = new DefaultListModel<Integer>();
			listmodel1 = new DefaultListModel<Integer>();
			listmodel2 = new DefaultListModel<Integer>();
			listmodel3 = new DefaultListModel<Integer>();
			listmodel4 = new DefaultListModel<Integer>();

			playerlabel1 = new JLabel("Food");
			playerlist1 = new JList<Integer>();
			playerlabel2 = new JLabel("Favor");
			playerlist2 = new JList<Integer>();
			playerlabel3 = new JLabel("Wood");
			playerlist3 = new JList<Integer>();
			playerlabel4 = new JLabel("Gold");
			playerlist4 = new JList<Integer>();
			label1 = new JLabel("Food");
			list1 = new JList<Integer>();
			label2 = new JLabel("Favor");
			list2 = new JList<Integer>();
			label3 = new JLabel("Wood");
			list3 = new JList<Integer>();
			label4 = new JLabel("Gold");
			list4 = new JList<Integer>();

			updateJList();
			playerPane1 = new JScrollPane(playerlist1);
			playerPane1.setPreferredSize(new Dimension(20, 60));
			playerPane2 = new JScrollPane(playerlist2);
			playerPane2.setPreferredSize(new Dimension(20, 60));
			playerPane3 = new JScrollPane(playerlist3);
			playerPane3.setPreferredSize(new Dimension(20, 60));
			playerPane4 = new JScrollPane(playerlist4);
			playerPane4.setPreferredSize(new Dimension(20, 60));

			pane1 = new JScrollPane(list1);
			pane1.setPreferredSize(new Dimension(20, 60));
			pane2 = new JScrollPane(list2);
			pane2.setPreferredSize(new Dimension(20, 60));
			pane3 = new JScrollPane(list3);
			pane3.setPreferredSize(new Dimension(20, 60));
			pane4 = new JScrollPane(list4);
			pane4.setPreferredSize(new Dimension(20, 60));

			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = 0;
			constraints.gridy = 0;

			constraints.insets = new Insets(0, 0, 20, 0);

			panel.add(playerResources, constraints);
			constraints.gridx = 0;
			constraints.gridy = 1;
			constraints.ipadx = 40;
			constraints.insets = new Insets(0, 0, 5, 0);
			panel.add(playerlabel1, constraints);
			constraints.gridx = 1;
			constraints.gridy = 1;

			panel.add(playerlabel2, constraints);
			constraints.gridx = 2;
			constraints.gridy = 1;

			panel.add(playerlabel3, constraints);
			constraints.gridx = 3;
			constraints.gridy = 1;

			panel.add(playerlabel4, constraints);

			constraints.gridx = 0;
			constraints.gridy = 2;
			panel.add(playerPane1, constraints);
			constraints.gridx = 1;
			constraints.gridy = 2;
			panel.add(playerPane2, constraints);
			constraints.gridx = 2;
			constraints.gridy = 2;
			panel.add(playerPane3, constraints);
			constraints.gridx = 3;
			constraints.gridy = 2;
			panel.add(playerPane4, constraints);

			constraints.gridx = 0;
			constraints.gridy = 3;
			constraints.insets = new Insets(40, 0, 20, 0);
			panel.add(bankResources, constraints);

			constraints.gridx = 0;
			constraints.gridy = 4;
			constraints.insets = new Insets(0, 0, 5, 0);
			panel.add(label1, constraints);
			constraints.gridx = 1;
			constraints.gridy = 4;
			panel.add(label2, constraints);
			constraints.gridx = 2;
			constraints.gridy = 4;
			panel.add(label3, constraints);
			constraints.gridx = 3;
			constraints.gridy = 4;
			panel.add(label4, constraints);

			constraints.gridx = 0;
			constraints.gridy = 5;
			panel.add(pane1, constraints);
			constraints.gridx = 1;
			constraints.gridy = 5;
			panel.add(pane2, constraints);
			constraints.gridx = 2;
			constraints.gridy = 5;
			panel.add(pane3, constraints);
			constraints.gridx = 3;
			constraints.gridy = 5;
			panel.add(pane4, constraints);

			button = new JButton("Trade");
			constraints.gridwidth = 4;
			constraints.gridx = 0;
			constraints.gridy = 6;
			constraints.insets = new Insets(20, 0, 0, 0);
			panel.add(button, constraints);
			this.setContentPane(panel);

			this.setVisible(true);
			listener();
		} else {
			List<String> tradeOptions = Arrays.asList("Food", "Favor", "Wood",
					"Gold");
			int index = new Random().nextInt(tradeOptions.size());
			if (tradeOptions.get(index).equals("Food") && player.getFood() > 0) {
				if (actionCard.getGod() == null) {
					payCost();
				}

				if (player.getFood() >= 1) {
					int index1 = new Random().nextInt(player.getFood());
					tradeWith(index1 + 1, tradeOptions.get(index));
					player.setFood(player.getFood() - (index1 + 1));
				}
			} else if (tradeOptions.get(index).equals("Favor")
					&& player.getFavor() > 0) {
				if (actionCard.getGod() == null) {
					payCost();
				}

				if (player.getFavor() >= 1) {
					int index1 = new Random().nextInt(player.getFavor());
					tradeWith(index1 + 1, tradeOptions.get(index));
					player.setFavor(player.getFavor() - (index1 + 1));
				}
			} else if (tradeOptions.get(index).equals("Wood")
					&& player.getWood() > 0) {
				if (actionCard.getGod() == null) {
					payCost();
				}

				if (player.getWood() >= 1) {
					int index1 = new Random().nextInt(player.getWood());
					tradeWith(index1 + 1, tradeOptions.get(index));
					player.setWood(player.getWood() - (index1 + 1));
				}
			} else if (player.getGold() > 0) {
				if (actionCard.getGod() == null) {
					payCost();
				}

				if (player.getGold() >= 1) {
					int index1 = new Random().nextInt(player.getGold());
					tradeWith(index1 + 1, tradeOptions.get(index));
					player.setGold(player.getGold() - (index1 + 1));
				}
			}
			imageManipulator.redrawImage(playerBoard, player);
			setTurn(player);

		}
	}

	private void tradeWith(int value, String trade) {
		boolean flag2 = false;
		boolean flag3 = false;
		Random random = new Random();
		int index1 = random.nextInt(value);
		int index2 = 0;
		int index3 = 0;
		int total = 0;
		int index4 = 0;
		if (index1 != (value - 1)) {
			index2 = random.nextInt(value - (index1 + 1));
			flag2 = true;
			total = index1 + index2 + 2;
			if (total < value) {
				index3 = value - total == 0 ? 0 : value - total;
				total = total + index3;
				flag3 = true;
			}
		} else {
			total = index1 + 1;
		}
		if (trade.equals("Food")) {

			if (playerBoard.favorBank >= index1 + 1) {
				player.setFavor(player.getFavor() + index1 + 1);
				playerBoard.favorBank = playerBoard.favorBank - (index1 + 1);
			}
			if (flag2 && playerBoard.woodBank >= index2 + 1) {
				player.setWood(player.getWood() + index2 + 1);
				playerBoard.woodBank = playerBoard.woodBank - (index2 + 1);
			}
			if (flag3 && playerBoard.goldBank >= index3) {
				player.setGold(player.getGold() + index3);
				playerBoard.goldBank = playerBoard.goldBank - index3;
			}
		} else if (trade.equals("Favor")) {
			if (playerBoard.foodBank >= index1 + 1) {
				player.setFood(player.getFood() + index1 + 1);
				playerBoard.foodBank = playerBoard.foodBank - (index1 + 1);
			}
			if (flag2 && playerBoard.woodBank >= index2 + 1) {
				player.setWood(player.getWood() + index2 + 1);
				playerBoard.woodBank = playerBoard.woodBank - (index2 + 1);
			}
			if (flag3 && playerBoard.goldBank >= index3) {
				player.setGold(player.getGold() + index3);
				playerBoard.goldBank = playerBoard.goldBank - index3;
			}
		} else if (trade.equals("Wood")) {
			if (playerBoard.foodBank >= index1 + 1) {
				player.setFood(player.getFood() + index1 + 1);
				playerBoard.foodBank = playerBoard.foodBank - (index1 + 1);
			}
			if (flag2 && playerBoard.favorBank >= index2 + 1) {
				player.setFavor(player.getFavor() + index2 + 1);
				playerBoard.favorBank = playerBoard.favorBank - (index2 + 1);
			}
			if (flag3 && playerBoard.goldBank >= index3) {
				player.setGold(player.getGold() + index3);
				playerBoard.goldBank = playerBoard.goldBank - index3;
			}
		} else {
			if (playerBoard.foodBank >= index1 + 1) {
				player.setFood(player.getFood() + index1 + 1);
				playerBoard.foodBank = playerBoard.foodBank - (index1 + 1);
			}
			if (flag2 && playerBoard.favorBank >= index2 + 1) {
				player.setFavor(player.getFavor() + index2 + 1);
				playerBoard.favorBank = playerBoard.favorBank - (index2 + 1);
			}
			if (flag3 && playerBoard.woodBank >= index3) {
				player.setWood(player.getWood() + index3);
				playerBoard.woodBank = playerBoard.woodBank - index3;
			}
		}

	}

	private void payCost() {
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		Random random = new Random();
		int index1 = random.nextInt(2);

		if (player.getFood() >= 2) {
			player.setFood(player.getFood() - 2);
			playerBoard.foodBank = playerBoard.foodBank + 2;
			return;
		}
		if (player.getFavor() >= 2) {
			player.setFavor(player.getFavor() - 2);
			playerBoard.favorBank = playerBoard.favorBank + 2;
			return;
		}
		if (player.getWood() >= 2) {
			player.setWood(player.getWood() - 2);
			playerBoard.woodBank = playerBoard.woodBank + 2;
			return;
		}
		if (player.getGold() >= 2) {
			player.setGold(player.getGold() - 2);
			playerBoard.woodBank = playerBoard.woodBank + 2;
			return;
		}
		if (player.getFood() >= 1) {
			player.setFood(player.getFood() - 1);
			playerBoard.foodBank = playerBoard.foodBank + 1;
			total += 1;
		}
		if (player.getFavor() >= 1 && total < 2) {
			player.setFavor(player.getFavor() - 1);
			playerBoard.favorBank = playerBoard.favorBank + 1;
			total += 1;
		}
		if (player.getWood() >= 1 && total < 2) {
			player.setWood(player.getWood() - 1);
			playerBoard.woodBank = playerBoard.woodBank + 1;
			total += 1;
		}
		if (player.getGold() >= 1 && total < 2) {
			player.setGold(player.getGold() - 1);
			playerBoard.woodBank = playerBoard.woodBank + 1;
			total += 1;
		}
	}

	private void listener() {
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
				total = 0;
				flag = false;
				if (!playerlist1.isSelectionEmpty()) {
					total = total
							+ (list2.getSelectedValue() == null ? 0 : list2
									.getSelectedValue());
					total = total
							+ (list3.getSelectedValue() == null ? 0 : list3
									.getSelectedValue());
					total = total
							+ (list4.getSelectedValue() == null ? 0 : list4
									.getSelectedValue());

					if (playerlist1.getSelectedValue() != total) {
						message();
					} else {
						player.setFood(player.getFood()
								- playerlist1.getSelectedValue());
						player.setFavor(player.getFavor()
								+ (list2.getSelectedValue() == null ? 0 : list2
										.getSelectedValue()));
						player.setWood(player.getWood()
								+ (list3.getSelectedValue() == null ? 0 : list3
										.getSelectedValue()));
						player.setGold(player.getGold()
								+ (list4.getSelectedValue() == null ? 0 : list4
										.getSelectedValue()));

						playerBoard.favorBank = playerBoard.favorBank
								- (list2.getSelectedValue() == null ? 0 : list2
										.getSelectedValue());
						playerBoard.woodBank = playerBoard.woodBank
								- (list3.getSelectedValue() == null ? 0 : list3
										.getSelectedValue());
						playerBoard.goldBank = playerBoard.goldBank
								- (list4.getSelectedValue() == null ? 0 : list4
										.getSelectedValue());
						playerBoard.foodBank = playerBoard.foodBank
								+ playerlist1.getSelectedValue();
						if (actionCard.getGod() == null) {
							for (int i = 0; i < 16; i++) {
								if (player.getBuildingTiles()[i] != null
										&& player.getBuildingTiles()[i]
												.getBuildingType().equals(
														"Market")) {
									flag = true;
								}
							}
						}
						if (!flag && actionCard.getGod() == null) {
							payCost();
						}

						imageManipulator.redrawImage(playerBoard, player);
						trade.dispose();
					}

				}
				if (!playerlist2.isSelectionEmpty()) {
					total = total
							+ (list1.getSelectedValue() == null ? 0 : list1
									.getSelectedValue());
					total = total
							+ (list3.getSelectedValue() == null ? 0 : list3
									.getSelectedValue());
					total = total
							+ (list4.getSelectedValue() == null ? 0 : list4
									.getSelectedValue());
					if (playerlist2.getSelectedValue() != total) {
						message();
					} else {
						player.setFavor(player.getFavor()
								- playerlist2.getSelectedValue());
						player.setFood(player.getFood()
								+ (list1.getSelectedValue() == null ? 0 : list1
										.getSelectedValue()));
						player.setWood(player.getWood()
								+ (list3.getSelectedValue() == null ? 0 : list3
										.getSelectedValue()));
						player.setGold(player.getGold()
								+ (list4.getSelectedValue() == null ? 0 : list4
										.getSelectedValue()));

						playerBoard.foodBank = playerBoard.foodBank
								- (list1.getSelectedValue() == null ? 0 : list1
										.getSelectedValue());
						playerBoard.woodBank = playerBoard.woodBank
								- (list3.getSelectedValue() == null ? 0 : list3
										.getSelectedValue());
						playerBoard.goldBank = playerBoard.goldBank
								- (list4.getSelectedValue() == null ? 0 : list4
										.getSelectedValue());
						playerBoard.favorBank = playerBoard.favorBank
								+ playerlist2.getSelectedValue();
						for (int i = 0; i < 16; i++) {
							if (player.getBuildingTiles()[i] != null
									&& player.getBuildingTiles()[i]
											.getBuildingType().equals("Market")) {
								flag = true;
							}
						}
						if (!flag && actionCard.getGod() == null) {
							payCost();
						}

						imageManipulator.redrawImage(playerBoard, player);
						trade.dispose();
					}

				}
				if (!playerlist3.isSelectionEmpty()) {
					total = total
							+ (list1.getSelectedValue() == null ? 0 : list1
									.getSelectedValue());
					total = total
							+ (list2.getSelectedValue() == null ? 0 : list2
									.getSelectedValue());
					total = total
							+ (list4.getSelectedValue() == null ? 0 : list4
									.getSelectedValue());
					if (playerlist3.getSelectedValue() != total) {
						message();
					} else {
						player.setWood(player.getWood()
								- playerlist3.getSelectedValue());
						player.setFood(player.getFood()
								+ (list1.getSelectedValue() == null ? 0 : list1
										.getSelectedValue()));
						player.setFavor(player.getFavor()
								+ (list2.getSelectedValue() == null ? 0 : list2
										.getSelectedValue()));
						player.setGold(player.getGold()
								+ (list4.getSelectedValue() == null ? 0 : list4
										.getSelectedValue()));

						playerBoard.foodBank = playerBoard.foodBank
								- (list1.getSelectedValue() == null ? 0 : list1
										.getSelectedValue());
						playerBoard.favorBank = playerBoard.favorBank
								- (list2.getSelectedValue() == null ? 0 : list2
										.getSelectedValue());
						playerBoard.goldBank = playerBoard.goldBank
								- (list4.getSelectedValue() == null ? 0 : list4
										.getSelectedValue());
						playerBoard.woodBank = playerBoard.woodBank
								+ playerlist3.getSelectedValue();
						for (int i = 0; i < 16; i++) {
							if (player.getBuildingTiles()[i] != null
									&& player.getBuildingTiles()[i]
											.getBuildingType().equals("Market")) {
								flag = true;
							}
						}
						if (!flag && actionCard.getGod() == null) {
							payCost();
						}

						imageManipulator.redrawImage(playerBoard, player);
						trade.dispose();
					}

				}
				if (!playerlist4.isSelectionEmpty()) {
					total = total
							+ (list1.getSelectedValue() == null ? 0 : list1
									.getSelectedValue());
					total = total
							+ (list2.getSelectedValue() == null ? 0 : list2
									.getSelectedValue());
					total = total
							+ (list3.getSelectedValue() == null ? 0 : list3
									.getSelectedValue());
					if (playerlist4.getSelectedValue() != total) {
						message();
					} else {
						player.setGold(player.getGold()
								- playerlist4.getSelectedValue());
						player.setFood(player.getFood()
								+ (list1.getSelectedValue() == null ? 0 : list1
										.getSelectedValue()));
						player.setFavor(player.getFavor()
								+ (list2.getSelectedValue() == null ? 0 : list2
										.getSelectedValue()));
						player.setWood(player.getWood()
								+ (list3.getSelectedValue() == null ? 0 : list3
										.getSelectedValue()));

						playerBoard.foodBank = playerBoard.foodBank
								- (list1.getSelectedValue() == null ? 0 : list1
										.getSelectedValue());
						playerBoard.favorBank = playerBoard.favorBank
								- (list2.getSelectedValue() == null ? 0 : list2
										.getSelectedValue());
						playerBoard.woodBank = playerBoard.woodBank
								- (list3.getSelectedValue() == null ? 0 : list3
										.getSelectedValue());
						playerBoard.goldBank = playerBoard.goldBank
								+ playerlist4.getSelectedValue();
						for (int i = 0; i < 16; i++) {
							if (player.getBuildingTiles()[i] != null
									&& player.getBuildingTiles()[i]
											.getBuildingType().equals("Market")) {
								flag = true;
							}
						}
						if (!flag && actionCard.getGod() == null) {
							payCost();
						}

						imageManipulator.redrawImage(playerBoard, player);
						trade.dispose();
					}
				}
				setTurn(player);
			}

			private void payCost() {
				Random randomizer = new Random();
				int cost = 0;
				while (cost != 2) {
					index = randomizer.nextInt(resourcesList.size());
					if (resourcesList.get(index) == 1) {
						if (player.getFood() >= 1) {
							player.setFood(player.getFood() - 1);
							cost++;
							playerBoard.foodBank = playerBoard.foodBank + 1;
						}
					} else if (resourcesList.get(index) == 2) {
						if (player.getFavor() >= 1) {
							player.setFavor(player.getFavor() - 1);
							cost++;
							playerBoard.favorBank = playerBoard.favorBank + 1;
						}
					} else if (resourcesList.get(index) == 3) {
						if (player.getWood() >= 1) {
							player.setWood(player.getWood() - 1);
							cost++;
							playerBoard.woodBank = playerBoard.woodBank + 1;
						}
					} else if (resourcesList.get(index) == 4) {
						if (player.getGold() >= 1) {
							player.setGold(player.getGold() - 1);
							cost++;
							playerBoard.goldBank = playerBoard.goldBank + 1;
						}
					}
				}

			}
		});
	}

	private void updateJList() {
		for (int i = 1; i <= player.getFood(); i++) {
			playerlistmodel1.addElement(i);
		}
		for (int i = 1; i <= player.getFavor(); i++) {
			playerlistmodel2.addElement(i);
		}
		for (int i = 1; i <= player.getWood(); i++) {
			playerlistmodel3.addElement(i);
		}
		for (int i = 1; i <= player.getGold(); i++) {
			playerlistmodel4.addElement(i);
		}

		for (int i = 1; i <= playerBoard.foodBank; i++) {
			listmodel1.addElement(i);
		}
		for (int i = 1; i <= playerBoard.favorBank; i++) {
			listmodel2.addElement(i);
		}
		for (int i = 1; i <= playerBoard.woodBank; i++) {
			listmodel3.addElement(i);
		}
		for (int i = 1; i <= playerBoard.goldBank; i++) {
			listmodel4.addElement(i);
		}
		list1.setModel(listmodel1);
		list2.setModel(listmodel2);
		list3.setModel(listmodel3);
		list4.setModel(listmodel4);
		playerlist1.setModel(playerlistmodel1);
		playerlist2.setModel(playerlistmodel2);
		playerlist3.setModel(playerlistmodel3);
		playerlist4.setModel(playerlistmodel4);
	}

	private void message() {
		JOptionPane
				.showMessageDialog(null, "Select equal number of resources!");
	}
}
