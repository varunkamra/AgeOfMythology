package mythology;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Boundary class which is mainly concerned with UI.
 * 
 * @author varun
 *
 */

public class ImageManipulator {

	int x = 20;
	int y1 = 20;
	int side = 20;
	int space = 10;
	int y2 = y1 + side + space;
	int y3 = y2 + side + space;
	int y4 = y3 + side + space;
	int y5 = y4 + side + space;
	int y6 = y5 + side + space + 20;

	int xStr = 671;
	int yStr = 40;

	public void repaint(BuildingTile buildingTile, PlayerBoard playerBoard,
			Player player, int place) {
		Graphics graphics;
		Graphics2D g;
		if (player.getPlayerType().equals("Greek")) {
			graphics = playerBoard.getGreekImage().getGraphics();
			g = (Graphics2D) graphics;
		} else if (player.getPlayerType().equals("Egyptian")) {
			graphics = playerBoard.getEgyptianImage().getGraphics();
			g = (Graphics2D) graphics;
		} else {
			graphics = playerBoard.getNorseImage().getGraphics();
			g = (Graphics2D) graphics;
		}
		placeBuildingTile(buildingTile, g, place);
		playerBoard.getContentPane().repaint();
		playerBoard.repaint();

	}

	private void placeBuildingTile(BuildingTile buildingTile, Graphics2D g,
			int place) {
		if (place == 0) {
			drawImage(buildingTile.getLabel(), g, 452, 405, 559, 500);
		} else if (place == 1) {
			drawImage(buildingTile.getLabel(), g, 559, 405, 671, 500);
		} else if (place == 2) {
			drawImage(buildingTile.getLabel(), g, 671, 405, 782, 500);
		} else if (place == 3) {
			drawImage(buildingTile.getLabel(), g, 782, 405, 885, 500);
		} else if (place == 4) {
			drawImage(buildingTile.getLabel(), g, 452, 500, 559, 600);
		} else if (place == 5) {
			drawImage(buildingTile.getLabel(), g, 559, 500, 671, 600);
		} else if (place == 6) {
			drawImage(buildingTile.getLabel(), g, 671, 500, 782, 600);
		} else if (place == 7) {
			drawImage(buildingTile.getLabel(), g, 782, 500, 885, 600);
		} else if (place == 8) {
			drawImage(buildingTile.getLabel(), g, 452, 600, 560, 700);
		} else if (place == 9) {
			drawImage(buildingTile.getLabel(), g, 560, 600, 672, 700);
		} else if (place == 10) {
			drawImage(buildingTile.getLabel(), g, 672, 600, 783, 700);
		} else if (place == 11) {
			drawImage(buildingTile.getLabel(), g, 783, 600, 886, 700);
		} else if (place == 12) {
			drawImage(buildingTile.getLabel(), g, 452, 700, 561, 791);
		} else if (place == 13) {
			drawImage(buildingTile.getLabel(), g, 559, 700, 673, 791);
		} else if (place == 14) {
			drawImage(buildingTile.getLabel(), g, 671, 700, 784, 791);
		} else if (place == 15) {
			drawImage(buildingTile.getLabel(), g, 782, 700, 887, 791);
		}
	}

	public boolean repaint(TerrianTile tile, PlayerBoard playerBoard,
			Player player) {
		boolean resourceTilePlaced = false;

		if (player.getPlayerType().equals("Greek")) {
			Graphics graphics = playerBoard.getGreekImage().getGraphics();
			Graphics2D g = (Graphics2D) graphics;
			resourceTilePlaced = placeResourceTileForGreek(tile,
					tile.getTerrianType(), playerBoard, player, g);
		}
		if (player.getPlayerType().equals("Egyptian")) {
			Graphics graphics = playerBoard.getEgyptianImage().getGraphics();
			Graphics2D g = (Graphics2D) graphics;
			resourceTilePlaced = placeResourceTileForEgyptian(tile,
					tile.getTerrianType(), playerBoard, player, g);
		}

		if (player.getPlayerType().equals("Norse")) {
			Graphics graphics = playerBoard.getNorseImage().getGraphics();
			Graphics2D g = (Graphics2D) graphics;
			resourceTilePlaced = placeResourceTileForNorse(tile,
					tile.getTerrianType(), playerBoard, player, g);
		}
		playerBoard.getContentPane().repaint();
		playerBoard.repaint();
		return resourceTilePlaced;
	}

	public boolean repaint(TerrianTile tile, String type,
			PlayerBoard playerBoard, Player player) {
		boolean resourceTilePlaced = false;

		if (player.getPlayerType().equals("Greek")) {
			Graphics graphics = playerBoard.getGreekImage().getGraphics();
			Graphics2D g = (Graphics2D) graphics;
			resourceTilePlaced = placeResourceTileForGreek(tile, type,
					playerBoard, player, g);
		}
		if (player.getPlayerType().equals("Egyptian")) {
			Graphics graphics = playerBoard.getEgyptianImage().getGraphics();
			Graphics2D g = (Graphics2D) graphics;
			resourceTilePlaced = placeResourceTileForEgyptian(tile, type,
					playerBoard, player, g);
		}

		if (player.getPlayerType().equals("Norse")) {
			Graphics graphics = playerBoard.getNorseImage().getGraphics();
			Graphics2D g = (Graphics2D) graphics;
			resourceTilePlaced = placeResourceTileForNorse(tile, type,
					playerBoard, player, g);
		}
		playerBoard.getContentPane().repaint();
		playerBoard.repaint();
		return resourceTilePlaced;
	}

	private boolean placeResourceTileForGreek(TerrianTile tile, String type,
			PlayerBoard playerBoard, Player player, Graphics2D g) {
		boolean tilePlaced = false;
		Boolean[][] terrianMatrix = player.getTilePlacementMatrix();
		TerrianTile[][] terrianTiles = player.getTerrianTiles();
		if (type.equals("Desert")) {
			if (terrianMatrix[3][0] == null || !terrianMatrix[3][0]) {
				terrianMatrix[3][0] = true;
				drawImage(tile.getLabel(), g, 9, 700, 114, 792);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}
		if (type.equals("Fertile")) {
			if (terrianMatrix[0][0] == null || !terrianMatrix[0][0]) {
				terrianMatrix[0][0] = true;
				drawImage(tile.getLabel(), g, 9, 405, 114, 500);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[0][1] == null || !terrianMatrix[0][1]) {
				terrianMatrix[0][1] = true;
				drawImage(tile.getLabel(), g, 114, 405, 226, 500);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[1][2] == null || !terrianMatrix[1][2]) {
				terrianMatrix[1][2] = true;
				drawImage(tile.getLabel(), g, 227, 500, 338, 600);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}
		if (type.equals("Forest")) {
			if (terrianMatrix[0][2] == null || !terrianMatrix[0][2]) {
				terrianMatrix[0][2] = true;
				drawImage(tile.getLabel(), g, 227, 405, 338, 500);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[1][3] == null || !terrianMatrix[1][3]) {
				terrianMatrix[1][3] = true;
				drawImage(tile.getLabel(), g, 338, 500, 441, 600);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}

		if (type.equals("Hills")) {
			if (terrianMatrix[1][0] == null || !terrianMatrix[1][0]) {
				terrianMatrix[1][0] = true;
				drawImage(tile.getLabel(), g, 9, 500, 114, 600);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][0] == null || !terrianMatrix[2][0]) {
				terrianMatrix[2][0] = true;
				drawImage(tile.getLabel(), g, 9, 600, 114, 700);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][1] == null || !terrianMatrix[2][1]) {
				terrianMatrix[2][1] = true;
				drawImage(tile.getLabel(), g, 114, 600, 226, 700);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][2] == null || !terrianMatrix[2][2]) {
				terrianMatrix[2][2] = true;
				drawImage(tile.getLabel(), g, 226, 600, 338, 700);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][3] == null || !terrianMatrix[2][3]) {
				terrianMatrix[2][3] = true;
				drawImage(tile.getLabel(), g, 338, 600, 441, 700);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][1] == null || !terrianMatrix[3][1]) {
				terrianMatrix[3][1] = true;
				drawImage(tile.getLabel(), g, 114, 700, 226, 793);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][2] == null || !terrianMatrix[3][2]) {
				terrianMatrix[3][2] = true;
				drawImage(tile.getLabel(), g, 226, 700, 338, 793);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][3] == null || !terrianMatrix[3][3]) {
				terrianMatrix[3][3] = true;
				drawImage(tile.getLabel(), g, 338, 700, 441, 792);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}
		if (type.equals("Mountains")) {
			if (terrianMatrix[1][1] == null || !terrianMatrix[1][1]) {
				terrianMatrix[1][1] = true;
				drawImage(tile.getLabel(), g, 114, 500, 226, 600);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}
		if (type.equals("Swamp")) {
			if (terrianMatrix[0][3] == null || !terrianMatrix[0][3]) {
				terrianMatrix[0][3] = true;
				drawImage(tile.getLabel(), g, 338, 405, 441, 500);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}
		return false;
	}

	private void drawImage(JLabel label, Graphics2D g, int x1, int y1, int x2,
			int y2) {
		ImageIcon imageicon = (ImageIcon) label.getIcon();
		g.drawImage(imageicon.getImage(), x1, y1, x2, y2, 0, 0, imageicon
				.getImage().getWidth(null), imageicon.getImage()
				.getHeight(null), null);
	}

	private boolean placeResourceTileForEgyptian(TerrianTile tile, String type,
			PlayerBoard playerBoard, Player player, Graphics2D g) {
		boolean tilePlaced = false;
		Boolean[][] terrianMatrix = player.getTilePlacementMatrix();
		TerrianTile[][] terrianTiles = player.getTerrianTiles();

		if (type.equals("Hills")) {
			if (terrianMatrix[3][1] == null || !terrianMatrix[3][1]) {
				terrianMatrix[3][1] = true;
				drawImage(tile.getLabel(), g, 110, 696, 224, 792);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

			if (terrianMatrix[3][3] == null || !terrianMatrix[3][3]) {
				terrianMatrix[3][3] = true;
				drawImage(tile.getLabel(), g, 337, 696, 444, 792);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Fertile")) {
			if (terrianMatrix[1][2] == null || !terrianMatrix[1][2]) {
				terrianMatrix[1][2] = true;
				drawImage(tile.getLabel(), g, 225, 495, 336, 595);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[1][3] == null || !terrianMatrix[1][3]) {
				terrianMatrix[1][3] = true;
				drawImage(tile.getLabel(), g, 336, 495, 445, 595);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][2] == null || !terrianMatrix[2][2]) {
				terrianMatrix[2][2] = true;
				drawImage(tile.getLabel(), g, 225, 595, 336, 696);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][3] == null || !terrianMatrix[2][3]) {
				terrianMatrix[2][3] = true;
				drawImage(tile.getLabel(), g, 336, 595, 445, 695);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][2] == null || !terrianMatrix[3][2]) {
				terrianMatrix[3][2] = true;
				drawImage(tile.getLabel(), g, 225, 695, 336, 792);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}
		if (type.equals("Forest")) {
			if (terrianMatrix[1][0] == null || !terrianMatrix[1][0]) {
				terrianMatrix[1][0] = true;
				drawImage(tile.getLabel(), g, 7, 496, 112, 595);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Desert")) {
			if (terrianMatrix[0][0] == null || !terrianMatrix[0][0]) {
				terrianMatrix[0][0] = true;
				drawImage(tile.getLabel(), g, 7, 404, 112, 495);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[0][1] == null || !terrianMatrix[0][1]) {
				terrianMatrix[0][1] = true;
				drawImage(tile.getLabel(), g, 113, 404, 225, 495);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[1][1] == null || !terrianMatrix[1][1]) {
				terrianMatrix[1][1] = true;
				drawImage(tile.getLabel(), g, 113, 495, 225, 595);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

			if (terrianMatrix[2][0] == null || !terrianMatrix[2][0]) {
				terrianMatrix[2][0] = true;
				drawImage(tile.getLabel(), g, 7, 596, 113, 695);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][1] == null || !terrianMatrix[2][1]) {
				terrianMatrix[2][1] = true;
				drawImage(tile.getLabel(), g, 113, 596, 225, 695);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

			if (terrianMatrix[3][0] == null || !terrianMatrix[3][0]) {
				terrianMatrix[3][0] = true;
				drawImage(tile.getLabel(), g, 7, 696, 113, 792);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Swamp")) {
			if (terrianMatrix[0][2] == null || !terrianMatrix[0][2]) {
				terrianMatrix[0][2] = true;
				drawImage(tile.getLabel(), g, 225, 404, 336, 495);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

			if (terrianMatrix[0][3] == null || !terrianMatrix[0][3]) {
				terrianMatrix[0][3] = true;
				drawImage(tile.getLabel(), g, 336, 404, 443, 495);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}
		return false;
	}

	private boolean placeResourceTileForNorse(TerrianTile tile, String type,
			PlayerBoard playerBoard, Player player, Graphics2D g) {
		boolean tilePlaced = false;
		Boolean[][] terrianMatrix = player.getTilePlacementMatrix();
		TerrianTile[][] terrianTiles = player.getTerrianTiles();

		if (type.equals("Hills")) {
			if (terrianMatrix[2][0] == null || !terrianMatrix[2][0]) {
				terrianMatrix[2][0] = true;
				drawImage(tile.getLabel(), g, 12, 598, 114, 698);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

			if (terrianMatrix[1][2] == null || !terrianMatrix[1][2]) {
				terrianMatrix[1][2] = true;
				drawImage(tile.getLabel(), g, 227, 499, 338, 598);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

			if (terrianMatrix[2][3] == null || !terrianMatrix[2][3]) {
				terrianMatrix[2][3] = true;
				drawImage(tile.getLabel(), g, 338, 598, 445, 698);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Fertile")) {
			if (terrianMatrix[0][0] == null || !terrianMatrix[0][0]) {
				terrianMatrix[0][0] = true;
				drawImage(tile.getLabel(), g, 12, 404, 115, 498);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[1][0] == null || !terrianMatrix[1][0]) {
				terrianMatrix[1][0] = true;
				drawImage(tile.getLabel(), g, 12, 498, 115, 598);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][3] == null || !terrianMatrix[3][3]) {
				terrianMatrix[3][3] = true;
				drawImage(tile.getLabel(), g, 338, 698, 445, 790);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Forest")) {
			if (terrianMatrix[1][1] == null || !terrianMatrix[1][1]) {
				terrianMatrix[1][1] = true;
				drawImage(tile.getLabel(), g, 116, 498, 227, 598);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[2][2] == null || !terrianMatrix[2][2]) {
				terrianMatrix[2][2] = true;
				drawImage(tile.getLabel(), g, 227, 598, 338, 698);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][1] == null || !terrianMatrix[3][1]) {
				terrianMatrix[3][1] = true;
				drawImage(tile.getLabel(), g, 116, 698, 227, 790);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[3][2] == null || !terrianMatrix[3][2]) {
				terrianMatrix[3][2] = true;
				drawImage(tile.getLabel(), g, 227, 698, 338, 790);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Desert")) {
			if (terrianMatrix[3][0] == null || !terrianMatrix[3][0]) {
				terrianMatrix[3][0] = true;
				drawImage(tile.getLabel(), g, 12, 698, 115, 790);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[3][0] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}

		if (type.equals("Mountains")) {
			if (terrianMatrix[0][1] == null || !terrianMatrix[0][1]) {
				terrianMatrix[0][1] = true;
				drawImage(tile.getLabel(), g, 114, 405, 227, 498);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[0][2] == null || !terrianMatrix[0][2]) {
				terrianMatrix[0][2] = true;
				drawImage(tile.getLabel(), g, 227, 405, 338, 498);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][2] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[0][3] == null || !terrianMatrix[0][3]) {
				terrianMatrix[0][3] = true;
				drawImage(tile.getLabel(), g, 338, 405, 444, 498);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[0][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
			if (terrianMatrix[1][3] == null || !terrianMatrix[1][3]) {
				terrianMatrix[1][3] = true;
				drawImage(tile.getLabel(), g, 338, 498, 444, 598);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[1][3] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}
		}

		if (type.equals("Swamp")) {
			if (terrianMatrix[2][1] == null || !terrianMatrix[2][1]) {
				terrianMatrix[2][1] = true;
				drawImage(tile.getLabel(), g, 114, 598, 227, 698);
				tilePlaced = true;
				player.setTilePlacementMatrix(terrianMatrix);
				terrianTiles[2][1] = tile;
				player.setTerrianTiles(terrianTiles);
				return tilePlaced;
			}

		}
		return false;

	}

	public void initializeResourcesOnPlayerBoard(PlayerBoard playerBoard) {
		Graphics graphics = playerBoard.getGreekImage().getGraphics();
		Graphics2D g = (Graphics2D) graphics;

		drawResourcesForPlayer(g);
		g.setColor(Color.red);
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("Archaic", x, y6);
		if (playerBoard.getHumanPlayer().getPlayerType().equals("Greek")) {
			drawMilitaryUnits(playerBoard.getHumanPlayer(), g);
		} else {
			drawMilitaryUnits(playerBoard.aiPlayer1.getPlayer().getPlayerType()
					.equals("Greek") ? playerBoard.aiPlayer1.getPlayer()
					: playerBoard.aiPlayer2.getPlayer(), g);
		}

		graphics = playerBoard.getEgyptianImage().getGraphics();
		g = (Graphics2D) graphics;

		drawResourcesForPlayer(g);
		g.setColor(Color.red);
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("Archaic", x, y6);
		if (playerBoard.getHumanPlayer().getPlayerType().equals("Egyptian")) {
			drawMilitaryUnits(playerBoard.getHumanPlayer(), g);
		} else {
			drawMilitaryUnits(playerBoard.aiPlayer1.getPlayer().getPlayerType()
					.equals("Egyptian") ? playerBoard.aiPlayer1.getPlayer()
					: playerBoard.aiPlayer2.getPlayer(), g);
		}

		graphics = playerBoard.getNorseImage().getGraphics();
		g = (Graphics2D) graphics;

		drawResourcesForPlayer(g);
		g.setColor(Color.red);
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("Archaic", x, y6);
		if (playerBoard.getHumanPlayer().getPlayerType().equals("Norse")) {
			drawMilitaryUnits(playerBoard.getHumanPlayer(), g);
		} else {
			drawMilitaryUnits(playerBoard.aiPlayer1.getPlayer().getPlayerType()
					.equals("Norse") ? playerBoard.aiPlayer1.getPlayer()
					: playerBoard.aiPlayer2.getPlayer(), g);
		}

		playerBoard.getContentPane().repaint();
		playerBoard.repaint();

	}

	public void updateResources(Graphics2D g, Color color, int resourcesLeft,
			int y) {
		int x = 20;
		for (int i = 0; i < resourcesLeft; i++) {
			g.setColor(color);
			g.drawRect(x, y, side, side);
			g.fillRect(x, y, side, side);
			x = x + side + 5;
		}
	}

	private void drawResourcesForPlayer(Graphics2D g) {
		drawResources(x, y1, side, side, Color.green, g);
		drawResources(x, y2, side, side, Color.blue, g);
		drawResources(x, y3, side, side, new Color(205, 133, 63), g);
		drawResources(x, y4, side, side, Color.yellow, g);
	}

	private void drawResources(int x, int y, int width, int height,
			Color color, Graphics2D g) {
		for (int i = 0; i < 5; i++) {
			g.setColor(color);
			g.drawRect(x, y, width, height);
			g.fillRect(x, y, width, height);
			x = x + width + 5;
		}
	}

	public void placeVictoryCubes(BufferedImage image, JDialog victoryCard,
			Player player, PlayerBoard playerBoard, int counter,
			int verticalCount) {
		Graphics graphics = image.getGraphics();
		Graphics2D g = (Graphics2D) graphics;

		int spaceX = (side + 5) * counter;

		int spaceY = 0;
		spaceY = (side + 5) * verticalCount;

		g.setColor(Color.RED);
		g.drawRect(20 + spaceX, 70 + spaceY, side, side);
		g.fillRect(20 + spaceX, 70 + spaceY, side, side);
		victoryCard.getContentPane().repaint();
		victoryCard.repaint();
		playerBoard.getContentPane().repaint();
		playerBoard.repaint();
	}

	public void redrawImage(PlayerBoard playerBoard, Player player) {
		BufferedImage image = null;
		Path path;
		try {
			if (player.getPlayerType().equals("Greek")) {
				path = Paths.get("").resolve("Images/GreekBoard9x7.jpg");
				image = ImageIO.read(new File(path.toString()));
			} else if (player.getPlayerType().equals("Egyptian")) {
				path = Paths.get("").resolve("Images/EgyptBoard9x7.jpg");
				image = ImageIO.read(new File(path.toString()));
			} else {
				path = Paths.get("").resolve("Images/NorseBoard9x7.jpg");
				image = ImageIO.read(new File(path.toString()));
			}
		} catch (Exception e) {

		}
		Graphics graphics = image.getGraphics();
		Graphics2D g = (Graphics2D) graphics;
		TerrianTile[][] terrianTiles = player.getTerrianTiles();
		Boolean[][] terrianMatrix = player.getTilePlacementMatrix();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (terrianTiles[i][j] != null) {
					terrianMatrix[i][j] = false;
					if (player.getPlayerType().equals("Greek")) {
						placeResourceTileForGreek(terrianTiles[i][j],
								terrianTiles[i][j].getTerrianType(),
								playerBoard, player, g);
					} else if (player.getPlayerType().equals("Egyptian")) {
						placeResourceTileForEgyptian(terrianTiles[i][j],
								terrianTiles[i][j].getTerrianType(),
								playerBoard, player, g);
					} else {
						placeResourceTileForNorse(terrianTiles[i][j],
								terrianTiles[i][j].getTerrianType(),
								playerBoard, player, g);
					}

				}
			}
		}
		for (int i = 0; i < 16; i++) {
			if (player.getBuildingTiles()[i] != null) {
				placeBuildingTile(player.getBuildingTiles()[i], g, i);
			}
		}
		updateResources(g, Color.green, player.getFood(), y1);
		updateResources(g, Color.blue, player.getFavor(), y2);
		updateResources(g, new Color(205, 133, 63), player.getWood(), y3);
		updateResources(g, Color.yellow, player.getGold(), y4);
		updateResources(g, Color.red, player.getVictory_cubes(), y5);
		g.setFont(new Font("default", Font.BOLD, 16));
		g.setColor(Color.red);
		if (player.getAge() != null) {
			g.drawString(player.getAge(), x, y6);
		}
		drawMilitaryUnits(player, g);

		if (player.getPlayerType().equals("Greek")) {
			playerBoard.getLabelGreek().setIcon(new ImageIcon(image));
			playerBoard.setGreekImage(image);
		} else if (player.getPlayerType().equals("Egyptian")) {
			playerBoard.getLabelEgyptian().setIcon(new ImageIcon(image));
			playerBoard.setEgyptianImage(image);
		} else {
			playerBoard.getLabelNorse().setIcon(new ImageIcon(image));
			playerBoard.setNorseImage(image);
		}
		playerBoard.getContentPane().repaint();
		playerBoard.repaint();
	}

	private void drawMilitaryUnits(Player player, Graphics2D g) {
		g.setColor(Color.yellow);

		yStr = 40;
		for (int i = 0; i < player.militaryUnits.size(); i++) {
			g.drawString(player.militaryUnits.get(i), xStr, yStr);
			yStr = yStr + 20;
		}
	}

	public void drawCross(JLabel label, Object dialog) {
		ImageIcon icon = (ImageIcon) label.getIcon();
		Graphics graphics = icon.getImage().getGraphics();
		Graphics2D g = (Graphics2D) graphics;
		g.setStroke(new BasicStroke(5));
		g.setColor(Color.red);

		g.drawLine(25, 50, 140, 160);
		g.drawLine(140, 50, 25, 160);
		if (dialog instanceof ActionCardDialog) {
			((ActionCardDialog) dialog).getContentPane().repaint();
			((ActionCardDialog) dialog).getPanel().repaint();
		} else {
			((PlayerHandDialog) dialog).getContentPane().repaint();
			((PlayerHandDialog) dialog).getPanel().repaint();
		}

	}

	public void writeString(PlayerBoard playerBoard, Player player,
			String string) {
		Graphics graphics;
		Graphics2D g;
		if (player.getPlayerType().equals("Greek")) {
			graphics = playerBoard.getGreekImage().getGraphics();
			g = (Graphics2D) graphics;
		} else if (player.getPlayerType().equals("Egyptian")) {
			graphics = playerBoard.getEgyptianImage().getGraphics();
			g = (Graphics2D) graphics;
		} else {
			graphics = playerBoard.getNorseImage().getGraphics();
			g = (Graphics2D) graphics;
		}
		g.drawString(string, xStr, yStr);
		playerBoard.getContentPane().repaint();
		playerBoard.repaint();
		yStr = yStr + 20;
	}
}
