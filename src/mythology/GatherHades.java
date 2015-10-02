package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GatherHades extends GatherCard {
	public GatherHades(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private String unit;
	private JRadioButton rButton;;
	private JDialog dialog;

	public void play() {
		if (player.getPlayerRole().equals("Human")) {
			int reply = JOptionPane.showConfirmDialog(null,
					"Cost to play god power is 1 favor cubes. Continue?",
					"Pay 1 favor", JOptionPane.YES_NO_OPTION);

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
			} else if (player.getFavor() < 1) {
				JOptionPane
						.showMessageDialog(null,
								"You don't have sufficient resources to play god power!");
				return;
			}
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			dialog();
		} else {
			int index = 0;
			Random random = new Random();
			List<String> options = Arrays.asList("Yes", "No");
			index = random.nextInt(options.size());
			if (options.get(index).equals("No")) {
				index = new Random().nextInt(options.size());
				if (options.get(index).equals("Yes")) {
					super.play();
					return;
				} else {
					setTurn(player);
					return;
				}
			} else if (player.getFavor() < 1) {
				setTurn(player);
				return;
			}
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			index = random.nextInt(player.militaryUnits.size());
			if (player.militaryUnits.get(index) != null) {
				player.militaryUnits.remove(index);
				imageManipulator.redrawImage(playerBoard, player);
			}
			boolean flag2 = false;
			boolean flag3 = false;
			boolean flag4 = false;
			int index1 = random.nextInt(7);
			int index2 = 0;
			int index3 = 0;
			int total = 0;
			int index4 = 0;
			if (index1 != 6) {
				index2 = random.nextInt(7 - (index1 + 1));
				flag2 = true;
				total = index1 + index2 + 2;
				if (total != 7) {
					index3 = random.nextInt(7 - index1 - index2 - 2);
					flag3 = true;
					total = total + index3 + 1;
					if (total < 7) {
						index4 = 7 - total == 0 ? 0 : 7 - total;
						total = total + index4;
						flag4 = true;
					}
				}
			} else {
				total = index1 + 1;
			}
			player.setFood(player.getFood() + index1 + 1);
			playerBoard.foodBank -= index1 + 1;
			if (flag2) {
				player.setFavor(player.getFavor() + index2 + 1);
				playerBoard.favorBank -= index2 + 1;
			}
			if (flag3) {
				player.setWood(player.getWood() + index3 + 1);
				playerBoard.woodBank -= index3 + 1;
			}
			if (flag4) {
				player.setGold(player.getGold() + index4);
				playerBoard.goldBank -= index4;
			}
			imageManipulator.redrawImage(playerBoard, player);
			index = random.nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
			} else {
				setTurn(player);
				return;
			}

		}

	}

	private void dialog() {
		Set<String> uniqueMilitaryUnits = new HashSet<String>(
				player.militaryUnits);
		dialog = new JDialog();
		JPanel panel = new JPanel();
		dialog.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		ButtonGroup buttonGroup = new ButtonGroup();
		dialog.setSize(300, 300);
		x = (screenSize.width - dialog.getWidth()) / 2;
		y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
		int count = 0;

		JLabel label = new JLabel();
		label.setText("Select the battle unit to destroy");
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridx = 0;
		constraint.gridy = 0;
		panel.add(label, constraint);
		for (String battleUnit : uniqueMilitaryUnits) {
			rButton = new JRadioButton();
			rButton.setText(battleUnit);
			buttonGroup.add(rButton);
			count++;
			constraint.gridx = 0;
			constraint.gridy = count;
			constraint.insets = new Insets(10, 0, 0, 0);
			panel.add(rButton, constraint);

			rButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					unit = ((JRadioButton) e.getSource()).getText();
				}
			});
		}
		JButton button = new JButton("Destroy unit");
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.gridx = 0;
		constraint.gridy = count + 1;
		panel.add(button, constraint);
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
				player.militaryUnits.remove(unit);
				imageManipulator.redrawImage(playerBoard, player);
				JOptionPane.showMessageDialog(null, "Battle unit eliminated!");
				dialog.dispose();
				selectResources();
			}
		});
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		if (count != 0) {
			dialog.setVisible(true);
		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(null,
					"The opponent does not have any myth type battle units.");
			super.play();
		}
	}

	private void selectResources() {
		final JDialog selectResources = new JDialog();
		JPanel panel = new JPanel();
		selectResources.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		selectResources.setSize(400, 400);
		x = (screenSize.width - selectResources.getWidth()) / 2;
		y = (screenSize.height - selectResources.getHeight()) / 2;
		selectResources.setLocation(x, y);
		JLabel label1 = new JLabel("Food");
		final JComboBox<Integer> combo1 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> model1 = new DefaultComboBoxModel<Integer>();

		JLabel label2 = new JLabel("Favor");
		final JComboBox<Integer> combo2 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> model2 = new DefaultComboBoxModel<Integer>();

		JLabel label3 = new JLabel("Wood");
		final JComboBox<Integer> combo3 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> model3 = new DefaultComboBoxModel<Integer>();

		JLabel label4 = new JLabel("Gold");
		final JComboBox<Integer> combo4 = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> model4 = new DefaultComboBoxModel<Integer>();

		for (int i = 0; i <= playerBoard.foodBank; i++) {
			model1.addElement(i);
		}
		for (int i = 0; i <= playerBoard.favorBank; i++) {
			model2.addElement(i);
		}
		for (int i = 0; i <= playerBoard.woodBank; i++) {
			model3.addElement(i);
		}
		for (int i = 0; i <= playerBoard.goldBank; i++) {
			model4.addElement(i);
		}
		combo1.setModel(model1);
		combo2.setModel(model2);
		combo3.setModel(model3);
		combo4.setModel(model4);

		JLabel label = new JLabel("Select a total of 7 resources of any type");
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.anchor = GridBagConstraints.LINE_START;
		panel.add(label, constraint);

		constraint.gridx = 0;
		constraint.gridy = 1;
		constraint.insets = new Insets(10, 0, 0, 15);
		panel.add(label1, constraint);

		constraint.gridx = 1;
		constraint.gridy = 1;
		constraint.ipadx = 20;
		panel.add(combo1, constraint);

		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.ipadx = 0;
		panel.add(label2, constraint);

		constraint.gridx = 1;
		constraint.gridy = 2;
		constraint.ipadx = 20;
		panel.add(combo2, constraint);

		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.ipadx = 0;
		panel.add(label3, constraint);

		constraint.gridx = 1;
		constraint.gridy = 3;
		constraint.ipadx = 20;
		panel.add(combo3, constraint);

		constraint.gridx = 0;
		constraint.gridy = 4;
		constraint.ipadx = 0;
		panel.add(label4, constraint);

		constraint.gridx = 1;
		constraint.gridy = 4;
		constraint.ipadx = 20;
		panel.add(combo4, constraint);

		constraint.gridx = 0;
		constraint.gridy = 5;
		constraint.anchor = GridBagConstraints.CENTER;
		JButton button = new JButton("Trade");
		panel.add(button, constraint);
		selectResources.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectResources.setVisible(true);
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
				int total = 0;
				if ((Integer) combo1.getSelectedItem() != 0) {
					total = total + (Integer) combo1.getSelectedItem();
				}
				if ((Integer) combo2.getSelectedItem() != 0) {
					total = total + (Integer) combo2.getSelectedItem();
				}
				if ((Integer) combo3.getSelectedItem() != 0) {
					total = total + (Integer) combo3.getSelectedItem();
				}
				if ((Integer) combo4.getSelectedItem() != 0) {
					total = total + (Integer) combo4.getSelectedItem();
				}
				if (total != 7) {
					JOptionPane.showMessageDialog(null,
							"Only 7 resources can be gained!");
					combo1.setSelectedIndex(0);
					combo2.setSelectedIndex(0);
					combo3.setSelectedIndex(0);
					combo4.setSelectedIndex(0);
				} else {
					player.setFood(player.getFood()
							+ (Integer) combo1.getSelectedItem());
					player.setFavor(player.getFavor()
							+ (Integer) combo2.getSelectedItem());
					player.setWood(player.getWood()
							+ (Integer) combo3.getSelectedItem());
					player.setGold(player.getGold()
							+ (Integer) combo4.getSelectedItem());
					imageManipulator.redrawImage(playerBoard, player);
					selectResources.dispose();
					int reply = JOptionPane
							.showConfirmDialog(
									null,
									"Do you want to perform the action specified on the card?",
									"Perform Action", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						superPlay();
						return;
					} else {
						setTurn(player);
						return;
					}
				}
			}
		});

	}

	private void superPlay() {
		super.play();
	}

}
