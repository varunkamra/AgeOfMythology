package mythology;

public class Observer2 extends Observer {

	public Observer2(ArtificialIntelligence aiPlayer1,
			ArtificialIntelligence aiPlayer2, ActionCard actionCard) {
		this.aiPlayer1 = aiPlayer1;
		this.aiPlayer2 = aiPlayer2;
		this.actionCard = actionCard;
		this.actionCard.attach(this);
	}

	@Override
	public void update() {
		if (actionCard.getPlayerTurn() == 2) {
			aiPlayer2.playCard();
		}
	}
}
