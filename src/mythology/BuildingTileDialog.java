package mythology;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BuildingTileDialog extends JDialog {
	private BuildingTile tile1;
	private BuildingTile tile2;
	private BuildingTile tile3;
	private BuildingTile tile4;
	private BuildingTile tile5;
	private BuildingTile tile6;
	private BuildingTile tile7;
	private BuildingTile tile8;
	private BuildingTile tile9;
	private BuildingTile tile10;
	private BuildingTile tile11;
	private BuildingTile tile12;
	private BuildingTile tile13;
	private BuildingTile tile14;
	private HashMap<String, BuildingTile> buildingTiles = new HashMap<String, BuildingTile>();

	public BuildingTileDialog(PlayerBoard playerBoard) {

		setTitle("Building tiles");
		setSize(688, 235);
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		setLayout(new GridBagLayout());
		this.setContentPane(panel);
		Path path = Paths.get("").resolve("Images/Armory.jpg").toAbsolutePath();
		GridBagConstraints constraints = new GridBagConstraints();

		tile1 = new BuildingTile();
		tile1.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile1.setBuildingType("Armory");
		tile1.setWoodCost(3);
		tile1.setGoldCost(2);
		panel.add(tile1.getLabel());
		getBuildingTiles().put("Armory", tile1);

		path = Paths.get("").resolve("Images/GoldMint.jpg").toAbsolutePath();
		tile2 = new BuildingTile();
		tile2.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile2.setBuildingType("Gold Mint");
		tile2.setWoodCost(2);
		tile2.setFoodCost(3);
		panel.add(tile2.getLabel());
		getBuildingTiles().put("Gold Mint", tile2);

		path = Paths.get("").resolve("Images/Storehouse.jpg").toAbsolutePath();
		tile3 = new BuildingTile();
		tile3.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile3.setBuildingType("Storehouse");
		panel.add(tile3.getLabel());
		tile3.setWoodCost(2);
		tile3.setFoodCost(2);
		tile3.setFavorCost(2);
		tile3.setGoldCost(2);
		getBuildingTiles().put("Storehouse", tile3);

		path = Paths.get("").resolve("Images/GreatTemple.jpg").toAbsolutePath();
		tile4 = new BuildingTile();
		tile4.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile4.setBuildingType("Great Temple");
		tile4.setWoodCost(4);
		tile4.setFoodCost(4);
		tile4.setFavorCost(4);
		tile4.setGoldCost(4);
		panel.add(tile4.getLabel());
		getBuildingTiles().put("Great Temple", tile4);

		path = Paths.get("").resolve("Images/House.jpg").toAbsolutePath();
		tile5 = new BuildingTile();
		tile5.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile5.setBuildingType("House");
		tile5.setWoodCost(2);
		tile5.setFoodCost(2);
		panel.add(tile5.getLabel());
		getBuildingTiles().put("House", tile5);

		path = Paths.get("").resolve("Images/Market.jpg").toAbsolutePath();
		tile6 = new BuildingTile();
		tile6.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile6.setBuildingType("Market");
		tile6.setGoldCost(3);
		tile6.setFavorCost(2);
		panel.add(tile6.getLabel());
		getBuildingTiles().put("Market", tile6);

		path = Paths.get("").resolve("Images/WoodWork.jpg").toAbsolutePath();
		tile7 = new BuildingTile();
		tile7.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile7.setBuildingType("Wood Workshop");
		tile7.setGoldCost(3);
		tile7.setFoodCost(2);
		panel.add(tile7.getLabel());
		getBuildingTiles().put("Wood Workshop", tile7);

		constraints.gridx = 0;
		constraints.gridx = 1;

		path = Paths.get("").resolve("Images/Granary.jpg").toAbsolutePath();
		tile8 = new BuildingTile();
		tile8.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile8.setBuildingType("Granary");
		tile8.setGoldCost(3);
		tile8.setWoodCost(2);
		panel.add(tile8.getLabel());
		getBuildingTiles().put("Granary", tile8);

		path = Paths.get("").resolve("Images/SiegeWork.jpg").toAbsolutePath();
		tile9 = new BuildingTile();
		tile9.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile9.setBuildingType("Siege Engine Workshop");
		tile9.setGoldCost(2);
		tile9.setWoodCost(3);
		panel.add(tile9.getLabel());
		getBuildingTiles().put("Siege Engine Workshop", tile9);

		path = Paths.get("").resolve("Images/Quarry.jpg").toAbsolutePath();
		tile10 = new BuildingTile();
		tile10.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile10.setBuildingType("Quarry");
		tile10.setGoldCost(1);
		tile10.setFoodCost(4);
		panel.add(tile10.getLabel());
		getBuildingTiles().put("Quarry", tile10);

		path = Paths.get("").resolve("Images/Tower.jpg").toAbsolutePath();
		tile11 = new BuildingTile();
		tile11.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile11.setBuildingType("Tower");
		tile11.setWoodCost(3);
		tile11.setGoldCost(3);
		panel.add(tile11.getLabel());
		getBuildingTiles().put("Tower", tile11);

		path = Paths.get("").resolve("Images/Wall.jpg").toAbsolutePath();
		tile12 = new BuildingTile();
		tile12.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile12.setBuildingType("Wall");
		tile12.setWoodCost(3);
		tile12.setGoldCost(3);
		panel.add(tile12.getLabel());
		getBuildingTiles().put("Wall", tile12);

		path = Paths.get("").resolve("Images/Wonder.jpg").toAbsolutePath();
		tile13 = new BuildingTile();
		tile13.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile13.setBuildingType("The Wonder");
		tile13.setWoodCost(10);
		tile13.setFoodCost(10);
		tile13.setFavorCost(10);
		tile13.setGoldCost(10);
		panel.add(tile13.getLabel());
		getBuildingTiles().put("The Wonder", tile13);

		path = Paths.get("").resolve("Images/Monument.jpg").toAbsolutePath();
		tile14 = new BuildingTile();
		tile14.setLabel(new JLabel(new ImageIcon(path.toString())));
		tile14.setBuildingType("Monument");
		tile14.setGoldCost(2);
		tile14.setFoodCost(3);
		panel.add(tile14.getLabel());
		getBuildingTiles().put("Monument", tile14);

		this.setVisible(false);
		this.toBack();
	}

	public HashMap<String, BuildingTile> getBuildingTiles() {
		return buildingTiles;
	}

}
