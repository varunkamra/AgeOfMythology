package mythology;

public abstract class Observer {
	protected ArtificialIntelligence aiPlayer1;
	protected ArtificialIntelligence aiPlayer2;
	protected ActionCard actionCard;

	public abstract void update();
}
