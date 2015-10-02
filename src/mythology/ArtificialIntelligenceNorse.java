package mythology;

import java.util.ArrayList;

import javax.swing.JDialog;

/**
 * AI class for Norse player.
 * 
 * @author varun
 *
 */

public class ArtificialIntelligenceNorse extends ArtificialIntelligence {

	public ArtificialIntelligenceNorse(PlayerBoard playerBoard, Player player) {
		super(playerBoard, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void terrianFirstFit(ArrayList<TerrianTile> terrianTiles,
			Object dialog) {
		Boolean[][] terrianMatrix = getPlayer().getTilePlacementMatrix();
		ImageManipulator manipulate = new ImageManipulator();
		for (int i = 0; i < terrianTiles.size(); i++) {
			if (terrianTiles.get(i).getTerrianType().equals("Desert")) {
				if (terrianMatrix[3][0] == null || !terrianMatrix[3][0]) {
					manipulate.repaint(terrianTiles.get(i), terrianTiles.get(i)
							.getTerrianType(), playerBoard, player);
					((JDialog) dialog).getContentPane().remove(
							terrianTiles.get(i).getLabel());
					((JDialog) dialog).getContentPane().revalidate();
					((JDialog) dialog).getContentPane().repaint();
					((JDialog) dialog).repaint();
					terrianTiles.remove(i);
					break;
				}
			}
			if (terrianTiles.get(i).getTerrianType().equals("Fertile")) {
				if (terrianMatrix[0][0] == null || !terrianMatrix[0][0]
						|| terrianMatrix[1][0] == null || !terrianMatrix[1][0]
						|| terrianMatrix[3][3] == null || !terrianMatrix[3][3]) {
					manipulate.repaint(terrianTiles.get(i), terrianTiles.get(i)
							.getTerrianType(), playerBoard, player);
					((JDialog) dialog).getContentPane().remove(
							terrianTiles.get(i).getLabel());
					((JDialog) dialog).getContentPane().revalidate();
					((JDialog) dialog).getContentPane().repaint();
					((JDialog) dialog).repaint();
					terrianTiles.remove(i);
					break;
				}
			}
			if (terrianTiles.get(i).getTerrianType().equals("Hills")) {
				if (terrianMatrix[2][0] == null || !terrianMatrix[2][0]
						|| terrianMatrix[1][2] == null || !terrianMatrix[1][2]
						|| terrianMatrix[2][3] == null || !terrianMatrix[2][3]) {
					manipulate.repaint(terrianTiles.get(i), terrianTiles.get(i)
							.getTerrianType(), playerBoard, player);
					((JDialog) dialog).getContentPane().remove(
							terrianTiles.get(i).getLabel());
					((JDialog) dialog).getContentPane().revalidate();
					((JDialog) dialog).getContentPane().repaint();
					((JDialog) dialog).repaint();
					terrianTiles.remove(i);
					break;
				}
			}
			if (terrianTiles.get(i).getTerrianType().equals("Forest")) {
				if (terrianMatrix[1][1] == null || !terrianMatrix[1][1]
						|| terrianMatrix[2][2] == null || !terrianMatrix[2][2]
						|| terrianMatrix[3][1] == null || !terrianMatrix[3][1]
						|| terrianMatrix[3][2] == null || !terrianMatrix[3][2]) {
					manipulate.repaint(terrianTiles.get(i), terrianTiles.get(i)
							.getTerrianType(), playerBoard, player);
					((JDialog) dialog).getContentPane().remove(
							terrianTiles.get(i).getLabel());
					((JDialog) dialog).getContentPane().revalidate();
					((JDialog) dialog).getContentPane().repaint();
					((JDialog) dialog).repaint();
					terrianTiles.remove(i);
					break;
				}
			}
			if (terrianTiles.get(i).getTerrianType().equals("Mountains")) {
				if (terrianMatrix[0][1] == null || !terrianMatrix[0][1]
						|| terrianMatrix[0][2] == null || !terrianMatrix[0][2]
						|| terrianMatrix[0][3] == null || !terrianMatrix[0][3]
						|| terrianMatrix[1][3] == null || !terrianMatrix[1][3]) {
					manipulate.repaint(terrianTiles.get(i), terrianTiles.get(i)
							.getTerrianType(), playerBoard, player);
					((JDialog) dialog).getContentPane().remove(
							terrianTiles.get(i).getLabel());
					((JDialog) dialog).getContentPane().revalidate();
					((JDialog) dialog).getContentPane().repaint();
					((JDialog) dialog).repaint();
					terrianTiles.remove(i);
					break;
				}
			}
			if (terrianTiles.get(i).getTerrianType().equals("Swamp")) {
				if (terrianMatrix[2][1] == null || !terrianMatrix[2][1]) {
					manipulate.repaint(terrianTiles.get(i), terrianTiles.get(i)
							.getTerrianType(), playerBoard, player);
					((JDialog) dialog).getContentPane().remove(
							terrianTiles.get(i).getLabel());
					((JDialog) dialog).getContentPane().revalidate();
					((JDialog) dialog).getContentPane().repaint();
					((JDialog) dialog).repaint();
					terrianTiles.remove(i);
					break;
				}
			}
		}
	}
}
