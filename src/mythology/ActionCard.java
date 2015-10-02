package mythology;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public abstract class ActionCard extends JDialog {
	protected ResourceDialog resources;
	protected ImageManipulator imageManipulator;
	protected PlayerBoard playerBoard;
	protected Player player;
	protected final Toolkit toolkit = Toolkit.getDefaultToolkit();
	protected final Dimension screenSize = toolkit.getScreenSize();
	protected int x, y;
	private boolean humanPlayed;
	static int spoilCounter = 0;
	List<Observer> observers = new ArrayList<Observer>();
	private boolean ai1Played;
	private int playerTurn;
	private static List<Integer> sequence = new ArrayList<Integer>();

	public void setPlayer(Player player) {
		this.player = player;
	}

	BuildingTileDialog buildingDialog;
	ArtificialIntelligence aiPlayer1;
	ArtificialIntelligence aiPlayer2;
	int numberofCardsPlayed = 0;
	ActionCardType actionCard;

	public ActionCard(ResourceDialog resource, PlayerBoard playerBoard,
			BuildingTileDialog buildingDialog, ActionCardType actionCard) {
		this.playerBoard = playerBoard;
		player = this.playerBoard.getHumanPlayer();
		resources = resource;
		imageManipulator = new ImageManipulator();
		this.buildingDialog = buildingDialog;
		this.actionCard = actionCard;
		aiPlayer1 = playerBoard.aiPlayer1;
		aiPlayer2 = playerBoard.aiPlayer2;
		// observerAI1 = new HumanPlayerObserver(aiPlayer1);
		// observerAI2 = new AIObserver(aiPlayer2);
	}

	public abstract void play();

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public static void spoil(Player player, ArtificialIntelligence aiPlayer1,
			ArtificialIntelligence aiPlayer2, PlayerBoard playerBoard) {
		BuildingTile[] buildings = player.getBuildingTiles();
		int spoil = 5;
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null
					&& buildings[i].getBuildingType().equals("Storehouse")) {
				spoil = 8;
			}
		}
		if (player.getWood() > spoil) {
			player.setWood(spoil);
		}
		if (player.getFavor() > spoil) {
			player.setFavor(spoil);
		}
		if (player.getFood() > spoil) {
			player.setFood(spoil);
		}
		if (player.getGold() > spoil) {
			player.setGold(spoil);
		}
		spoil = 5;
		buildings = aiPlayer1.getPlayer().getBuildingTiles();
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null
					&& buildings[i].getBuildingType().equals("Storehouse")) {
				spoil = 8;
			}
		}
		if (aiPlayer1.getPlayer().getWood() > spoil) {
			aiPlayer1.getPlayer().setWood(spoil);
		}
		if (aiPlayer1.getPlayer().getFavor() > spoil) {
			aiPlayer1.getPlayer().setFavor(spoil);
		}
		if (aiPlayer1.getPlayer().getFood() > spoil) {
			aiPlayer1.getPlayer().setFood(spoil);
		}
		if (aiPlayer1.getPlayer().getGold() > spoil) {
			aiPlayer1.getPlayer().setGold(spoil);
		}
		spoil = 5;
		buildings = aiPlayer1.getPlayer().getBuildingTiles();
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i] != null
					&& buildings[i].getBuildingType().equals("Storehouse")) {
				spoil = 8;
			}
		}
		if (aiPlayer2.getPlayer().getWood() > spoil) {
			aiPlayer2.getPlayer().setWood(spoil);
		}
		if (aiPlayer2.getPlayer().getFavor() > spoil) {
			aiPlayer2.getPlayer().setFavor(spoil);
		}
		if (aiPlayer2.getPlayer().getFood() > spoil) {
			aiPlayer2.getPlayer().setFood(spoil);
		}
		if (aiPlayer2.getPlayer().getGold() > spoil) {
			aiPlayer2.getPlayer().setGold(spoil);
		}
		ImageManipulator imageManipulator = new ImageManipulator();
		imageManipulator.redrawImage(playerBoard, player);
		imageManipulator.redrawImage(playerBoard, aiPlayer1.getPlayer());
		imageManipulator.redrawImage(playerBoard, aiPlayer2.getPlayer());
	}

	public boolean isHumanPlayed() {
		return humanPlayed;
	}

	public void setHumanPlayed(boolean humanPlayed) {
		this.humanPlayed = humanPlayed;
		// observerAI1.update(humanPlayed, this);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public boolean isAiPlayed() {
		return ai1Played;
	}

	public void setAi1Played(boolean aiPlayed) {
		this.ai1Played = aiPlayed;
		// observerAI2.update(aiPlayed, this);
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
		notifyObservers();
	}

	public void setTurn(Player player) {
		if (player.getPlayerType().equals(
				playerBoard.getHumanPlayer().getPlayerType())
				&& player.getPlayerRole().equals("Human")
				&& checkSequence(1, null)) {
			setPlayerTurn(1);
		} else if (player.getPlayerType().equals(
				aiPlayer1.getPlayer().getPlayerType())
				&& checkSequence(2, aiPlayer1)) {
			setPlayerTurn(2);
		} else if (player.getPlayerType().equals(
				aiPlayer2.getPlayer().getPlayerType())
				&& checkSequence(3, aiPlayer2)) {
			setPlayerTurn(3);
		}

	}

	private boolean checkSequence(int i, ArtificialIntelligence ai) {
		if (sequence.size() == 0) {
			sequence.add(i);
			return true;
		} else if (sequence.get(sequence.size() - 1) == 1 && i == 1
				&& PlayerHandDialog.cardsAllowed == 4) {
			sequence.add(i);
			PlayerHandDialog.cardsAllowed = 3;
			return true;
		} else if (sequence.get(sequence.size() - 1) == 3 && i == 1) {
			sequence.add(i);
			return true;
		} else if (sequence.get(sequence.size() - 1) == 2 && i == 2
				&& ai != null && ai.odin) {
			sequence.add(i);
			ai.odin = false;
			return true;
		} else if (sequence.get(sequence.size() - 1) == 3 && i == 3
				&& ai != null && ai.odin) {
			sequence.add(i);
			ai.odin = false;
			return true;
		} else if (sequence.get(sequence.size() - 1) == 2 && i == 3) {
			sequence.add(i);
			return true;
		} else if (sequence.get(sequence.size() - 1) == 1 && i == 2) {
			sequence.add(i);
			return true;
		}
		return false;
	}
}
