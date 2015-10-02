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
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RecruitHel extends RecruitCard {
	public RecruitHel(ResourceDialog resource, PlayerBoard playerBoard,
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
			Set<String> battleUnits = player.battleCards.keySet();
			List<String> mortalUnits = new ArrayList<String>();

			for (String unit : battleUnits) {
				if (unit != null
						&& player.battleCards.get(unit).getUnitType()
								.contains("Mortal")) {
					mortalUnits.add(unit);
				}
			}

			boolean flag = false;
			for (int i = 0; i < 2; i++) {
				index = new Random().nextInt(mortalUnits.size());
				player.militaryUnits.add(mortalUnits.get(index));

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
		label.setText("Select the battle units");
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridx = 0;
		constraint.gridy = 0;
		panel.add(label, constraint);
		for (String battleUnit : player.battleCards.keySet()) {
			if (battleUnit != null
					&& player.battleCards.get(battleUnit).getUnitType()
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
						if (((JCheckBox) e.getSource()).isSelected()) {
							unit.add(((JCheckBox) e.getSource()).getText());
						}
						if (!((JCheckBox) e.getSource()).isSelected()) {
							unit.remove(((JCheckBox) e.getSource()).getText());
						}

					}
				});
			}
		}
		JButton button = new JButton("Gain unit");
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
				if (unit.size() <= 2) {
					for (int i = 0; i < unit.size(); i++) {
						player.militaryUnits.add(unit.get(i));
					}
					dialog.dispose();
					imageManipulator.redrawImage(playerBoard, player);
					JOptionPane.showMessageDialog(null, "You have gained "
							+ unit.size() + " units!");

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
							"Cannot gain more than 2 units!");
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
