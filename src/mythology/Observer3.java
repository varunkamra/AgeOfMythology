package mythology;

public class Observer3 extends Observer {

	public Observer3(ArtificialIntelligence aiPlayer1,
			ArtificialIntelligence aiPlayer2, ActionCard actionCard) {
		this.aiPlayer1 = aiPlayer1;
		this.aiPlayer2 = aiPlayer2;
		this.actionCard = actionCard;
		this.actionCard.attach(this);
	}

	@Override
	public void update() {
		if (actionCard.getPlayerTurn() == 3) {
			// actionCard.spoil();
		}
	}

}
