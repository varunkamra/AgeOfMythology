package mythology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * AI abstract class.
 * 
 * @author varun
 *
 */

abstract class ArtificialIntelligence {
	protected Player player;
	protected ResourceDialog resource;

	public void setResource(ResourceDialog resource) {
		this.resource = resource;
	}

	protected PlayerBoard playerBoard;
	protected List<ActionCardType> actionCards;
	protected List<ActionCardType> permanentCards;
	protected List<ActionCardType> randomCards;
	private BuildingTileDialog buildingDialog;
	int index = 0;
	boolean flag = false;
	private int cardsPlayed = 0;
	public boolean odin = false;

	public void setBuildingDialog(BuildingTileDialog buildingDialog) {
		this.buildingDialog = buildingDialog;
	}

	public ArtificialIntelligence(PlayerBoard playerBoard, Player player) {
		this.player = player;
		this.playerBoard = playerBoard;
	}

	public abstract void terrianFirstFit(ArrayList<TerrianTile> terrianTiles,
			Object dialog);

	public Player getPlayer() {
		return player;
	}

	public void assignCards() {
		actionCards = new ArrayList<ActionCardType>();
		permanentCards = new ArrayList<ActionCardType>();
		randomCards = new ArrayList<ActionCardType>();
		int numberOfPermanentCards = 0;
		permanentCards.addAll(player.getActioncardsPermanent());
		randomCards.addAll(player.getActioncardsRandom());
		int maxCardsAllowed = player.getAge().equals("Archaic") ? 4 : (player
				.getAge().equals("Classical") ? 5 : (player.getAge().equals(
				"Heroic") ? 6 : (player.getAge().equals("Mythic") ? 7 : 0)));

		Random random = new Random();
		int index = 0;
		numberOfPermanentCards = random.nextInt(maxCardsAllowed);
		for (int i = 0; i <= numberOfPermanentCards; i++) {
			index = random.nextInt(permanentCards.size());
			actionCards.add(permanentCards.get(index));
			permanentCards.remove(index);
		}

		if (numberOfPermanentCards + 1 < maxCardsAllowed) {
			for (int i = 0; i < maxCardsAllowed - (numberOfPermanentCards + 1); i++) {
				index = random.nextInt(randomCards.size());
				actionCards.add(randomCards.get(index));
				randomCards.remove(index);
			}
		}
		flag = false;
	}

	public void playCard() {
		if (flag) {
			actionCards.remove(actionCards.get(index));
		}
		index = new Random().nextInt(actionCards.size());
		System.out.println(actionCards.get(index).getCardType()
				+ " "
				+ (actionCards.get(index).getGod() == null ? "" : actionCards
						.get(index).getGod()) + " " + player.getPlayerType());
		ActionCard actionCard = getCard(actionCards.get(index));
		actionCard.setPlayer(player);
		new Observer1(playerBoard.aiPlayer1, playerBoard.aiPlayer2, actionCard);
		new Observer2(playerBoard.aiPlayer1, playerBoard.aiPlayer2, actionCard);
		actionCard.play();
		flag = true;
		cardsPlayed++;
		if (cardsPlayed == 3 && odin) {
			this.playCard();
			cardsPlayed = 0;

		} else if (cardsPlayed == 3) {
			cardsPlayed = 0;
		}

		// permanentCards = new ArrayList<ActionCardType>();
		// permanentCards.addAll(player.getActioncardsPermanent());
		// randomCards = new ArrayList<ActionCardType>();
		// randomCards.addAll(player.getActioncardsRandom());
		// ActionCardType actionCardX = permanentCards.get(6);
		// if (buildingDialog != null && resource != null) {
		// if (actionCardX.getCardType().equals("Attack")
		// && !AttackCard.onGoingBattle) {
		// ActionCard actionCard = new AttackCard(resource, playerBoard,
		// buildingDialog, actionCardX);
		// actionCard.setPlayer(player);
		// actionCard.play();
		// }
		// }
		// actionCardX = permanentCards.get(6);
		// if (buildingDialog != null && resource != null) {
		// if (actionCardX.getCardType().equals("Attack")
		// && !AttackCard.onGoingBattle) {
		// ActionCard actionCard = new AttackCard(resource, playerBoard,
		// buildingDialog, actionCardX);
		// actionCard.setPlayer(player);
		// actionCard.play();
		// }
		// }
		//
		// ActionCardType actionCardX = randomCards.get(9);
		// if (buildingDialog != null && resource != null) {
		// if (actionCardX.getCardType().equals("Recruit")
		// && actionCardX.getGod().equals("Apollo")) {
		// ActionCard actionCard = new RecruitApollo(resource,
		// playerBoard, buildingDialog, actionCardX);
		//
		// actionCard.setPlayer(player);
		// actionCard.play();
		// }
		// }
	}

	private ActionCard getCard(ActionCardType actionCard) {
		if (actionCard.getCardType().equals("Explore")
				&& actionCard.getGod() == null) {
			return new ExploreCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod() == null) {
			return new GatherCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod().equals("Skadi")) {
			return new GatherSkadi(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod().equals("Hades")) {
			return new GatherHades(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod().equals("Thor")) {
			return new GatherThor(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Dionysus")) {
			return new GatherDionysus(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Ra")) {
			return new GatherRa(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Gather")
				&& actionCard.getGod() != null
				&& (actionCard.getGod().equals("Freyia") || actionCard.getGod()
						.equals("Poseidon"))) {
			return new GatherFreyiaPoseidon(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Build")
				&& actionCard.getGod() == null) {
			return new BuildCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Build")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Hera")) {
			return new BuildHera(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Build")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Horus")) {
			return new BuildHorus(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Build")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Njord")) {
			return new BuildNjord(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Recruit")
				&& actionCard.getGod() == null) {
			return new RecruitCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Recruit")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Anubis")) {
			return new RecruitAnubis(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Recruit")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Hel")) {
			return new RecruitHel(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Recruit")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Apollo")) {
			return new RecruitApollo(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Trade")
				&& actionCard.getGod() == null) {
			return new TradeCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Trade")
				&& (actionCard.getGod().equals("Hermes") || actionCard.getGod()
						.equals("Forseti"))) {
			return new TradeHermesForseti(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Next Age")
				&& actionCard.getGod() == null) {
			return new NextAgeCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Attack")) {
			return new AttackCard(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Next Age")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Haphaestos")) {
			return new NextAgeHaphaestos(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Next Age")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Hathor")) {
			return new NextAgeHathor(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Next Age")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Zeus")) {
			return new NextAgeZeus(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Next Age")
				&& actionCard.getGod() != null
				&& actionCard.getGod().equals("Odin")) {
			return new NextAgeOdin(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		} else if (actionCard.getCardType().equals("Explore")
				&& actionCard.getGod() != null) {
			return new ExploreGod(playerBoard.resources, playerBoard,
					buildingDialog, actionCard);
		}
		return null;
	}
}
