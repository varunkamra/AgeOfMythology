package mythology;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GatherThor extends GatherCard {
	public GatherThor(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		super(resource, playerBoard, buildingDialog, actionCard);
		// TODO Auto-generated constructor stub
	}

	private String unit;
	private JRadioButton rButton;;
	private Player temp = null;

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
			}
			String[] players = new String[2];
			if (player.getPlayerType().equals("Greek")) {
				players[0] = "Egyptian";
				players[1] = "Norse";
			} else if (player.getPlayerType().equals("Egyptian")) {
				players[0] = "Greek";
				players[1] = "Norse";
			} else if (player.getPlayerType().equals("Norse")) {
				players[0] = "Greek";
				players[1] = "Egyptian";
			}
			player.setFavor(player.getFavor() - 1);
			imageManipulator.redrawImage(playerBoard, player);
			String playerType = (String) JOptionPane.showInputDialog(this,
					"Selcect the type of culture", "Player Type",
					JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
			dialog(playerType);
		} else {
			int index = 0;
			boolean flag = false;
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
			List<String> opponent = null;
			if (player.getPlayerType().equals("Greek")) {
				opponent = Arrays.asList("Egyptian", "Norse");
			} else if (player.getPlayerType().equals("Egyptian")) {
				opponent = Arrays.asList("Greek", "Norse");
			} else if (player.getPlayerType().equals("Norse")) {
				opponent = Arrays.asList("Greek", "Egyptian");
			}
			index = new Random().nextInt(opponent.size());
			if (aiPlayer1.getPlayer().getPlayerType()
					.equals(opponent.get(index))) {
				temp = aiPlayer1.getPlayer();
			} else if (aiPlayer2.getPlayer().getPlayerType()
					.equals(opponent.get(index))) {
				temp = aiPlayer2.getPlayer();
			} else {
				temp = playerBoard.getHumanPlayer();
			}
			List<String> unitType;
			for (int i = 0; i < temp.militaryUnits.size(); i++) {
				unitType = temp.battleCards.get(temp.militaryUnits.get(i))
						.getUnitType();
				for (String type : unitType) {
					if (type.equals("Myth")) {
						temp.militaryUnits.remove(temp.militaryUnits.get(i));
						if (temp.getPlayerRole().equals("Human")) {
							JOptionPane
									.showMessageDialog(
											null,
											player.getPlayerType()
													+ " player has eliminated one of your battle unit!");
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											player.getPlayerType()
													+ " player has eliminated Egyptian player's battle unit!");
						}
						imageManipulator.redrawImage(playerBoard, temp);
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			super.play();

		}

	}

	private void dialog(String playerType) {
		final JDialog dialog = new JDialog();
		JPanel panel = new JPanel();
		dialog.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		ButtonGroup buttonGroup = new ButtonGroup();
		dialog.setSize(300, 300);
		x = (screenSize.width - dialog.getWidth()) / 2;
		y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);
		int count = 0;
		if (aiPlayer1.getPlayer().getPlayerType().equals(playerType)) {
			temp = aiPlayer1.getPlayer();
		} else {
			temp = aiPlayer2.getPlayer();
		}
		List<String> unitType;
		JLabel label = new JLabel();
		label.setText("Select the battle unit to destroy");
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridx = 0;
		constraint.gridy = 0;
		panel.add(label, constraint);
		for (int i = 0; i < temp.militaryUnits.size(); i++) {
			unitType = temp.battleCards.get(temp.militaryUnits.get(i))
					.getUnitType();
			for (int j = 0; j < unitType.size(); j++) {
				if (unitType.get(j).equals("Myth")) {
					rButton = new JRadioButton();
					rButton.setText(temp.militaryUnits.get(i));
					buttonGroup.add(rButton);
					count++;
					constraint.gridx = 0;
					constraint.gridy = count;
					constraint.insets = new Insets(10, 0, 0, 0);
					panel.add(rButton, constraint);

					rButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							unit = rButton.getText();
						}
					});
					break;
				}
			}
		}
		JButton button = new JButton("Eliminate unit");
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
				temp.militaryUnits.remove(unit);
				imageManipulator.redrawImage(playerBoard, temp);
				JOptionPane.showMessageDialog(null, temp.getPlayerType()
						+ " player's battle unit eliminated!");
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
			}
		});
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		if (count != 0) {
			dialog.setVisible(true);
		} else {
			dialog.dispose();
			JOptionPane.showMessageDialog(null,
					"The opponent does not have any myth type battle units.");
			int reply = JOptionPane.showConfirmDialog(null,
					"Do you want to perform the action specified on the card?",
					"Perform Action", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				super.play();
				return;
			} else {
				return;
			}

		}
	}

	private void superPlay() {
		super.play();
	}
}
