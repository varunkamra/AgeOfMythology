package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RecruitAnubis extends RecruitCard {
	public RecruitAnubis(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private List<String> unit = new ArrayList<String>();
	private JCheckBox checkBox;;
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
				setTurn(player);
				return;
			}
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			dialog();
		} else {
			int index = 0;
			List<String> options = Arrays.asList("Yes", "No");
			index = new Random().nextInt(options.size());
			if (options.get(index).equals("No")) {
				index = new Random().nextInt(options.size());
				if (options.get(index).equals("Yes")) {
					super.play();
					return;
				} else {
					setTurn(player);
					return;
				}
			}
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < player.militaryUnits.size(); j++) {
					if (player.battleCards.get(player.militaryUnits.get(j))
							.getUnitType().contains("Mortal")) {
						player.militaryUnits
								.remove(player.militaryUnits.get(j));
						player.militaryUnits.add("Mummy");
						break;
					}
				}
				index = new Random().nextInt(options.size());
				if (options.get(index).equals("No")) {
					break;
				}
			}
			index = new Random().nextInt(options.size());
			if (options.get(index).equals("Yes")) {
				super.play();
				return;
			} else {
				setTurn(player);
				return;
			}

		}

	}

	private void dialog() {
		dialog = new JDialog();
		JPanel panel = new JPanel();
		dialog.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
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
		for (String battleUnit : player.militaryUnits) {
			if (player.battleCards.get(battleUnit).getUnitType()
					.contains("Mortal")) {
				checkBox = new JCheckBox();
				checkBox.setText(battleUnit);
				count++;
				constraint.gridx = 0;
				constraint.gridy = count;
				constraint.insets = new Insets(10, 0, 0, 0);
				panel.add(checkBox, constraint);

				checkBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						unit.add(((JCheckBox) e.getSource()).getText());
					}
				});
			}
		}
		JButton button = new JButton("Trade unit");
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
				if (unit.size() <= 3) {
					for (int i = 0; i < unit.size(); i++) {
						player.militaryUnits.remove(unit.get(i));
						player.militaryUnits.add("Mummy");
					}
					imageManipulator.redrawImage(playerBoard, player);
					JOptionPane.showMessageDialog(null,
							"You have traded units for " + unit.size()
									+ " mummies!");
					dialog.dispose();
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

				} else {
					JOptionPane.showMessageDialog(null,
							"Cannot trade more than 3 units!");
				}
			}
		});
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	private void superPlay() {
		super.play();
	}

}
