package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RecruitCardEgyptian extends RecruitCard {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel units;
	private JLabel number;
	private JLabel cost;
	private JLabel cost1;
	private JLabel cost2;
	private JLabel cost3;
	private JLabel cost4;
	private JLabel cost5;
	private JLabel cost6;
	private JLabel cost7;
	private JLabel cost8;
	private JLabel cost9;
	private JLabel cost10;
	private JLabel cost11;
	private JLabel cost12;
	private JComboBox<Integer> combo1;
	private JComboBox<Integer> combo2;
	private JComboBox<Integer> combo3;
	private JComboBox<Integer> combo4;
	private JComboBox<Integer> combo5;
	private JComboBox<Integer> combo6;
	private JComboBox<Integer> combo7;
	private JComboBox<Integer> combo8;
	private JComboBox<Integer> combo9;
	private JComboBox<Integer> combo10;
	private JComboBox<Integer> combo11;
	private JComboBox<Integer> combo12;
	private DefaultComboBoxModel<Integer> model1 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model2 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model3 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model4 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model5 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model6 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model7 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model8 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model9 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model10 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model11 = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Integer> model12 = new DefaultComboBoxModel<>();
	private int wood = 0;
	private int favor = 0;
	private int food = 0;
	private int gold = 0;
	private int unitsSelected = 0;
	RecruitCardEgyptian recruit;

	private JButton button;

	public RecruitCardEgyptian(ResourceDialog resource,
			PlayerBoard playerBoard, BuildingTileDialog buildingDialog,
			ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		setTitle("Recruit");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		recruit = this;
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		units = new JLabel("Units");
		number = new JLabel("Number of units");
		cost = new JLabel("Cost per unit");

		label1 = new JLabel("Wadjet");
		combo1 = new JComboBox<Integer>();
		cost1 = new JLabel("Food=2 Favor=2");
		combo1.setSize(40, 10);

		label2 = new JLabel("Phoenix");
		combo2 = new JComboBox<Integer>();
		combo2.setSize(40, 10);
		cost2 = new JLabel("Wood=2 Favor=2");

		label3 = new JLabel("Spearman");
		combo3 = new JComboBox<Integer>();
		cost3 = new JLabel("Food=1 Wood=1");

		label4 = new JLabel("Mummy");
		combo4 = new JComboBox<Integer>();
		cost4 = new JLabel("Gold=3 Favor=2");

		label5 = new JLabel("Elephant");
		combo5 = new JComboBox<Integer>();
		cost5 = new JLabel("Food=2 Gold=1");

		label6 = new JLabel("Priest");
		combo6 = new JComboBox<Integer>();
		cost6 = new JLabel("Food=2 Gold=4");

		label7 = new JLabel("Chariot Archer");
		combo7 = new JComboBox<Integer>();
		cost7 = new JLabel("Gold=1 Wood=1");

		label8 = new JLabel("Son Of Osiris");
		combo8 = new JComboBox<Integer>();
		cost8 = new JLabel("Gold=4 Favor=4");

		label9 = new JLabel("Anubite");
		combo9 = new JComboBox<Integer>();
		cost9 = new JLabel("Gold=3 Favor=1");

		label10 = new JLabel("Sphinx");
		combo10 = new JComboBox<Integer>();
		cost10 = new JLabel("Gold=2 Favor=2");

		label11 = new JLabel("Scorpian-Man");
		combo11 = new JComboBox<Integer>();
		cost11 = new JLabel("Food=5 Gold=2");

		label12 = new JLabel("Pharaoh");
		combo12 = new JComboBox<Integer>();
		cost12 = new JLabel("Food=3 Gold=3");
		initializeUnits();
		button = new JButton("Recruit");
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(units, constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(number, constraints);

		constraints.gridx = 2;
		constraints.gridy = 0;
		panel.add(cost, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(15, 40, 0, 0);
		constraints.weightx = 0.5;
		constraints.anchor = constraints.LINE_START;
		panel.add(label1, constraints);

		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(combo1, constraints);

		constraints.gridx = 2;
		constraints.gridy = 1;
		panel.add(cost1, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.insets = new Insets(5, 40, 0, 0);
		panel.add(label2, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		panel.add(combo2, constraints);
		constraints.gridx = 2;
		constraints.gridy = 2;
		panel.add(cost2, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(label3, constraints);
		constraints.gridx = 1;
		constraints.gridy = 3;
		panel.add(combo3, constraints);
		constraints.gridx = 2;
		constraints.gridy = 3;
		panel.add(cost3, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		panel.add(label4, constraints);
		constraints.gridx = 1;
		constraints.gridy = 4;
		panel.add(combo4, constraints);
		constraints.gridx = 2;
		constraints.gridy = 4;
		panel.add(cost4, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(label5, constraints);
		constraints.gridx = 1;
		constraints.gridy = 5;
		panel.add(combo5, constraints);
		constraints.gridx = 2;
		constraints.gridy = 5;
		panel.add(cost5, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		panel.add(label6, constraints);
		constraints.gridx = 1;
		constraints.gridy = 6;
		panel.add(combo6, constraints);
		constraints.gridx = 2;
		constraints.gridy = 6;
		panel.add(cost6, constraints);

		constraints.gridx = 0;
		constraints.gridy = 7;
		panel.add(label7, constraints);
		constraints.gridx = 1;
		constraints.gridy = 7;
		panel.add(combo7, constraints);
		constraints.gridx = 2;
		constraints.gridy = 7;
		panel.add(cost7, constraints);

		constraints.gridx = 0;
		constraints.gridy = 8;
		panel.add(label8, constraints);
		constraints.gridx = 1;
		constraints.gridy = 8;
		panel.add(combo8, constraints);
		constraints.gridx = 2;
		constraints.gridy = 8;
		panel.add(cost8, constraints);

		constraints.gridx = 0;
		constraints.gridy = 9;
		panel.add(label9, constraints);
		constraints.gridx = 1;
		constraints.gridy = 9;
		panel.add(combo9, constraints);
		constraints.gridx = 2;
		constraints.gridy = 9;
		panel.add(cost9, constraints);

		constraints.gridx = 0;
		constraints.gridy = 10;
		panel.add(label10, constraints);
		constraints.gridx = 1;
		constraints.gridy = 10;
		panel.add(combo10, constraints);
		constraints.gridx = 2;
		constraints.gridy = 10;
		panel.add(cost10, constraints);

		constraints.gridx = 0;
		constraints.gridy = 11;
		panel.add(label11, constraints);
		constraints.gridx = 1;
		constraints.gridy = 11;
		panel.add(combo11, constraints);
		constraints.gridx = 2;
		constraints.gridy = 11;
		panel.add(cost11, constraints);

		constraints.gridx = 0;
		constraints.gridy = 12;
		panel.add(label12, constraints);
		constraints.gridx = 1;
		constraints.gridy = 12;
		panel.add(combo12, constraints);
		constraints.gridx = 2;
		constraints.gridy = 12;
		panel.add(cost12, constraints);

		constraints.gridx = 0;
		constraints.gridy = 13;
		constraints.gridwidth = 3;
		constraints.anchor = constraints.CENTER;

		panel.add(button, constraints);
		listeners();
		this.setContentPane(panel);

		this.setVisible(true);

	}

	private void initializeUnits() {
		for (int i = 0; i <= 5; i++) {
			model1.addElement(i);
		}
		for (int i = 0; i <= 6; i++) {
			model2.addElement(i);
		}
		for (int i = 0; i <= 3; i++) {
			model3.addElement(i);
		}
		for (int i = 0; i <= 5; i++) {
			model4.addElement(i);
		}
		for (int i = 0; i <= 3; i++) {
			model5.addElement(i);
		}
		for (int i = 0; i <= 4; i++) {
			model6.addElement(i);
		}
		for (int i = 0; i <= 3; i++) {
			model7.addElement(i);
		}
		for (int i = 0; i <= 8; i++) {
			model8.addElement(i);
		}
		for (int i = 0; i <= 5; i++) {
			model9.addElement(i);
		}
		for (int i = 0; i <= 5; i++) {
			model10.addElement(i);
		}
		for (int i = 0; i <= 5; i++) {
			model11.addElement(i);
		}
		for (int i = 0; i <= 6; i++) {
			model12.addElement(i);
		}
		combo1.setModel(model1);
		combo2.setModel(model2);
		combo3.setModel(model3);
		combo4.setModel(model4);
		combo5.setModel(model5);
		combo6.setModel(model6);
		combo7.setModel(model7);
		combo8.setModel(model8);
		combo9.setModel(model9);
		combo10.setModel(model10);
		combo11.setModel(model11);
		combo12.setModel(model12);

	}

	private void listeners() {
		combo1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wood = wood + (Integer) combo1.getSelectedItem() * 3;
				favor = favor + (Integer) combo1.getSelectedItem();
				if (player.getWood() >= wood && player.getFavor() >= favor) {
					button.setEnabled(true);
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
				unitsSelected = 0;
				food = 0;
				wood = 0;
				favor = 0;
				gold = 0;
				if (combo1.getSelectedIndex() != -1
						&& combo1.getSelectedIndex() != 0) {
					food = food + ((Integer) combo1.getSelectedItem() * 2);
					favor = favor + ((Integer) combo1.getSelectedItem() * 2);
					unitsSelected = unitsSelected
							+ (Integer) combo1.getSelectedItem();
				}
				if (combo2.getSelectedIndex() != -1
						&& combo2.getSelectedIndex() != 0) {
					wood = wood + ((Integer) combo2.getSelectedItem() * 2);
					favor = favor + ((Integer) combo2.getSelectedItem() * 2);
					unitsSelected = unitsSelected
							+ (Integer) combo2.getSelectedItem();
				}
				if (combo3.getSelectedIndex() != -1
						&& combo3.getSelectedIndex() != 0) {
					food = food + ((Integer) combo3.getSelectedItem());
					wood = wood + ((Integer) combo3.getSelectedItem());
					unitsSelected = unitsSelected
							+ (Integer) combo3.getSelectedItem();
				}
				if (combo4.getSelectedIndex() != -1
						&& combo4.getSelectedIndex() != 0) {

					gold = gold + ((Integer) combo4.getSelectedItem() * 3);
					favor = favor + ((Integer) combo4.getSelectedItem() * 2);
					unitsSelected = unitsSelected
							+ (Integer) combo4.getSelectedItem();

				}
				if (combo5.getSelectedIndex() != -1
						&& combo5.getSelectedIndex() != 0) {
					food = food + ((Integer) combo5.getSelectedItem() * 2);
					gold = gold + ((Integer) combo5.getSelectedItem());
					unitsSelected = unitsSelected
							+ (Integer) combo5.getSelectedItem();
				}
				if (combo6.getSelectedIndex() != -1
						&& combo6.getSelectedIndex() != 0) {
					if (player.getAge().equals("Classical")) {
						food = food + ((Integer) combo6.getSelectedItem() * 2);
						gold = gold + ((Integer) combo6.getSelectedItem() * 4);
						unitsSelected = unitsSelected
								+ (Integer) combo6.getSelectedItem();
					} else {
						JOptionPane
								.showMessageDialog(null,
										"You need to be in Classical age to recruit Classical Egyptian Hero");
						return;
					}
				}
				if (combo7.getSelectedIndex() != -1
						&& combo7.getSelectedIndex() != 0) {

					gold = gold + ((Integer) combo7.getSelectedItem());
					wood = wood + ((Integer) combo7.getSelectedItem());
					unitsSelected = unitsSelected
							+ (Integer) combo7.getSelectedItem();

				}
				if (combo8.getSelectedIndex() != -1
						&& combo8.getSelectedIndex() != 0) {
					if (player.getAge().equals("Mythic")) {
						gold = gold + ((Integer) combo8.getSelectedItem() * 4);
						favor = favor
								+ ((Integer) combo8.getSelectedItem() * 4);
						unitsSelected = unitsSelected
								+ (Integer) combo8.getSelectedItem();
					} else {
						JOptionPane
								.showMessageDialog(null,
										"You need to be in Mythic age to recruit Mythic Egyptian Hero");
						return;
					}
				}
				if (combo9.getSelectedIndex() != -1
						&& combo9.getSelectedIndex() != 0) {

					gold = gold + ((Integer) combo9.getSelectedItem() * 3);
					favor = favor + ((Integer) combo9.getSelectedItem());
					unitsSelected = unitsSelected
							+ (Integer) combo9.getSelectedItem();

				}
				if (combo10.getSelectedIndex() != -1
						&& combo10.getSelectedIndex() != 0) {
					gold = gold + ((Integer) combo10.getSelectedItem() * 2);
					favor = favor + ((Integer) combo10.getSelectedItem() * 2);
					unitsSelected = unitsSelected
							+ (Integer) combo10.getSelectedItem();
				}
				if (combo11.getSelectedIndex() != -1
						&& combo11.getSelectedIndex() != 0) {
					food = food + ((Integer) combo11.getSelectedItem() * 5);
					gold = gold + ((Integer) combo11.getSelectedItem() * 2);
					unitsSelected = unitsSelected
							+ (Integer) combo11.getSelectedItem();
				}
				if (combo12.getSelectedIndex() != -1
						&& combo12.getSelectedIndex() != 0) {
					if (player.getAge().equals("Heroic")) {
						food = food + ((Integer) combo12.getSelectedItem() * 3);
						gold = gold + ((Integer) combo12.getSelectedItem() * 3);
						unitsSelected = unitsSelected
								+ (Integer) combo12.getSelectedItem();
					} else {
						JOptionPane
								.showMessageDialog(null,
										"You need to be in Heroic age to recruit Heroic Egyptian Hero");
						return;
					}
				}
				if (unitsSelected <= actionCard.getNumber()) {
					if (player.getFood() >= food && player.getFavor() >= favor
							&& player.getWood() >= wood
							&& player.getGold() >= gold) {
						JOptionPane.showMessageDialog(null, "Units recruited!");
						player.setFood(player.getFood() - food);
						player.setFavor(player.getFavor() - favor);
						player.setWood(player.getWood() - wood);
						player.setGold(player.getGold() - gold);
						printOnBoard();
						imageManipulator.redrawImage(playerBoard, player);
						recruit.dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"Not sufficient resources to recruit!");
					}
					setTurn(player);
				} else {
					JOptionPane.showMessageDialog(null,
							"Can't recruit more than 2 units!");
					combo1.setSelectedItem(0);
					combo2.setSelectedItem(0);
					combo3.setSelectedItem(0);
					combo4.setSelectedItem(0);
					combo5.setSelectedItem(0);
					combo6.setSelectedItem(0);
					combo7.setSelectedItem(0);
					combo8.setSelectedItem(0);
					combo9.setSelectedItem(0);
					combo10.setSelectedItem(0);
					combo11.setSelectedItem(0);
					combo12.setSelectedItem(0);
				}
			}

			private void printOnBoard() {
				if (combo1.getSelectedIndex() != -1
						&& combo1.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo1.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label1.getText());
						player.militaryUnits.add(label1.getText());
					}
				}
				if (combo2.getSelectedIndex() != -1
						&& combo2.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo2.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label2.getText());
						player.militaryUnits.add(label2.getText());
					}
				}
				if (combo3.getSelectedIndex() != -1
						&& combo3.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo3.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label3.getText());
						player.militaryUnits.add(label3.getText());
					}
				}
				if (combo4.getSelectedIndex() != -1
						&& combo4.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo4.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label4.getText());
						player.militaryUnits.add(label4.getText());
					}
				}
				if (combo5.getSelectedIndex() != -1
						&& combo5.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo5.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label5.getText());
						player.militaryUnits.add(label5.getText());
					}
				}
				if (combo6.getSelectedIndex() != -1
						&& combo6.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo6.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label6.getText());
						player.militaryUnits.add(label6.getText());
					}
				}
				if (combo7.getSelectedIndex() != -1
						&& combo7.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo7.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label7.getText());
						player.militaryUnits.add(label7.getText());
					}
				}
				if (combo8.getSelectedIndex() != -1
						&& combo8.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo8.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label8.getText());
						player.militaryUnits.add(label8.getText());
					}
				}
				if (combo9.getSelectedIndex() != -1
						&& combo9.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo9.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label9.getText());
						player.militaryUnits.add(label9.getText());
					}
				}
				if (combo10.getSelectedIndex() != -1
						&& combo10.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo10.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label10.getText());
						player.militaryUnits.add(label10.getText());
					}
				}
				if (combo11.getSelectedIndex() != -1
						&& combo11.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo11.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label11.getText());
						player.militaryUnits.add(label11.getText());
					}
				}
				if (combo12.getSelectedIndex() != -1
						&& combo12.getSelectedIndex() != 0) {
					for (int i = 0; i < (Integer) combo12.getSelectedIndex(); i++) {
						// imageManipulator.writeString(playerBoard, player,
						// label12.getText());
						player.militaryUnits.add(label12.getText());
					}
				}
			}
		});
	}
}
