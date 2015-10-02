package mythology;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.imgscalr.Scalr;

public class Player {
	private int food = 5;
	private int wood = 5;
	private int favor = 5;
	private int gold = 5;
	private int victory_cubes = 0;
	private String playerType = "";
	private String playerRole = "";
	private Boolean[][] tilePlacementMatrix = new Boolean[4][4];
	private TerrianTile[][] terrianTiles = new TerrianTile[4][4];
	private BufferedImage playerBoardImage;
	private String age = null;
	private BuildingTile[] buildingTiles = new BuildingTile[16];
	public int housesBuilt = 0;
	public boolean wall = false;
	public boolean tower = false;
	public boolean market = false;
	public boolean storehouse = false;
	public boolean armory = false;
	public boolean quarry = false;
	public boolean monument = false;
	public boolean granary = false;
	public boolean woodWorkshop = false;
	public boolean goldMint = false;
	public boolean siegeWorkshop = false;
	public boolean greatTemple = false;
	public boolean wonder = false;
	public List<String> militaryUnits = new ArrayList<String>();
	public HashMap<String, BattleCard> battleCards = new HashMap<String, BattleCard>();
	private List<ActionCardType> actioncardsPermanent = new ArrayList<ActionCardType>();
	private List<ActionCardType> actioncardsRandom = new ArrayList<ActionCardType>();;
	private Path path;

	public Player(String playerType) {
		setPlayerType(playerType);
		initializePermanentActionCards();
		initializeMilitaryUnitsAndRandomCards(playerType);
	}

	private void initializeMilitaryUnitsAndRandomCards(String playerType) {

		if (playerType.equals("Greek")) {
			militaryUnits.add("Toxotes");
			militaryUnits.add("Toxotes");
			militaryUnits.add("Hoplite");
			militaryUnits.add("Hoplite");
			militaryUnits.add("Hippokon");
			militaryUnits.add("Hippokon");
			initializeRandomActionCardGreek();
		} else if (playerType.equals("Egyptian")) {
			militaryUnits.add("Spearman");
			militaryUnits.add("Spearman");
			militaryUnits.add("Elephant");
			militaryUnits.add("Elephant");
			militaryUnits.add("Chariot Archer");
			militaryUnits.add("Chariot Archer");
			initializeRandomActionCardEgyptian();
		} else {
			militaryUnits.add("Jarl");
			militaryUnits.add("Jarl");
			militaryUnits.add("Huskarl");
			militaryUnits.add("Huskarl");
			militaryUnits.add("Throwing Axeman");
			militaryUnits.add("Throwing Axeman");
			initializeRandomActionCardNorse();
		}
		initializeBattleAndActionCards(playerType);

	}

	private void initializeRandomActionCardEgyptian() {

		ActionCardType temp;
		// temp = new ActionCardType();
		// path =
		// Paths.get("").resolve("Images/Random Attack Isis Egyptian.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setGod("Isis");
		// temp.setNumber(7);
		// temp.setCardType("Attack");
		// getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("")
				.resolve("Images/Random Attack Sekhmet Egyptian.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Sekhmet");
		temp.setNumber(6);
		temp.setCardType("Attack");
		getActioncardsRandom().add(temp);

		// temp = new ActionCardType();
		// path =
		// Paths.get("").resolve("Images/Random Attack Thoth Egyptian.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setGod("Thoth");
		// temp.setNumber(6);
		// temp.setCardType("Attack");
		// getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Build Horus Egyptian.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Horus");
		temp.setCardType("Build");
		temp.setNumber(3);
		getActioncardsRandom().add(temp);

		// temp = new ActionCardType();
		// path = Paths.get("")
		// .resolve("Images/Random Build Nephthys Egyptian.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setNumber(3);
		// temp.setGod("Nephthys");
		// temp.setCardType("Build");
		// getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Explore Ptah Egyptian.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Ptah");
		temp.setCardType("Explore");
		temp.setNumber(5);
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Ra Egyptian.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Ra");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("")
				.resolve("Images/Random Next Age Hathor Egyptian.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Hathor");
		temp.setClassicalAgeCost(3);
		temp.setHeroicAgeCost(4);
		temp.setMythicAgeCost(5);
		temp.setCardType("Next Age");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("")
				.resolve("Images/Random Recruit Anubis Egyptian.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setNumber(4);
		temp.setGod("Anubis");
		temp.setCardType("Recruit");
		getActioncardsRandom().add(temp);

		// temp = new ActionCardType();
		// path =
		// Paths.get("").resolve("Images/Random Recruit Bast Egyptian.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setGod("Bast");
		// temp.setNumber(6);
		// temp.setCardType("Recruit");
		// getActioncardsRandom().add(temp);
		//
		// temp = new ActionCardType();
		// path = Paths.get("")
		// .resolve("Images/Random Recruit Osiris Egyptian.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setNumber(4);
		// temp.setGod("Osiris");
		// temp.setCardType("Recruit");
		// getActioncardsRandom().add(temp);

	}

	private void initializeRandomActionCardNorse() {
		ActionCardType temp;
		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Attack Bragi Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Bragi");
		temp.setNumber(6);
		temp.setCardType("Attack");
		getActioncardsRandom().add(temp);

		// temp = new ActionCardType();
		// path =
		// Paths.get("").resolve("Images/Random Attack Heimdall Norse.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setGod("Heimdall");
		// temp.setNumber(4);
		// temp.setCardType("Attack");
		// getActioncardsRandom().add(temp);
		//
		// temp = new ActionCardType();
		// path = Paths.get("").resolve("Images/Random Attack Tyr Norse.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setGod("Tyr");
		// temp.setNumber(6);
		// temp.setCardType("Attack");
		// getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Build Njord Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Njord");
		temp.setNumber(4);
		temp.setCardType("Build");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Explore Baldr Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Baldr");
		temp.setCardType("Explore");
		temp.setNumber(3);
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Freyia Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Freyia");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Skadi Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Skadi");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Thor Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Thor");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Next Age Odin Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Odin");
		temp.setClassicalAgeCost(3);
		temp.setHeroicAgeCost(4);
		temp.setMythicAgeCost(5);
		temp.setCardType("Next Age");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Recruit Hel Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Hel");
		temp.setNumber(4);
		temp.setCardType("Recruit");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Trade Forseti Norse.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Forseti");
		temp.setCardType("Trade");
		getActioncardsRandom().add(temp);

		// temp = new ActionCardType();
		// path = Paths.get("").resolve("Images/Random Trade Loki Norse.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setGod("Loki");
		// temp.setCardType("Trade");
		// getActioncardsRandom().add(temp);

	}

	private void initializeRandomActionCardGreek() {
		ActionCardType temp;
		// temp = new ActionCardType();
		// path = Paths.get("")
		// .resolve("Images/Random Attack Aphrodite Greek.jpg")
		// .toAbsolutePath();
		// try {
		// temp.setImage((Scalr.resize(
		// ImageIO.read(new File(path.toString())),
		// Scalr.Method.BALANCED, 130, 230)));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// temp.setNumber(6);
		// temp.setGod("Aphrodite");
		// temp.setCardType("Attack");
		// getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Attack Ares Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setNumber(8);
		temp.setGod("Ares");
		temp.setCardType("Attack");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Build Hera Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setNumber(3);
		temp.setGod("Hera");
		temp.setCardType("Build");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Explore Artemis Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Artemis");
		temp.setCardType("Explore");
		temp.setNumber(5);
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Dionysus Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Dionysus");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Hades Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		temp.setGod("Hades");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Gather Poseidon Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Poseidon");
		temp.setCardType("Gather");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("")
				.resolve("Images/Random Next Age Haphaestos Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Haphaestos");
		temp.setClassicalAgeCost(3);
		temp.setHeroicAgeCost(4);
		temp.setMythicAgeCost(5);
		temp.setCardType("Next Age");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Next Age Zeus Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Zeus");
		temp.setCardType("Next Age");
		temp.setClassicalAgeCost(3);
		temp.setHeroicAgeCost(4);
		temp.setMythicAgeCost(5);
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Recruit Apollo Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setNumber(4);
		temp.setGod("Apollo");
		temp.setCardType("Recruit");
		getActioncardsRandom().add(temp);

		temp = new ActionCardType();
		path = Paths.get("").resolve("Images/Random Trade Hermes Greek.jpg")
				.toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setGod("Hermes");
		temp.setCardType("Trade");
		getActioncardsRandom().add(temp);
	}

	private void initializePermanentActionCards() {
		ActionCardType temp;
		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Explore " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Explore");
		temp.setNumber(4);
		getActioncardsPermanent().add(temp);

		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Gather " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Gather");
		getActioncardsPermanent().add(temp);

		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Build " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Build");
		temp.setNumber(1);
		getActioncardsPermanent().add(temp);

		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Recruit " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Recruit");
		temp.setNumber(2);
		getActioncardsPermanent().add(temp);

		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Trade " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Trade");
		getActioncardsPermanent().add(temp);

		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Next Age " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Next Age");
		temp.setClassicalAgeCost(4);
		temp.setHeroicAgeCost(5);
		temp.setMythicAgeCost(6);
		getActioncardsPermanent().add(temp);

		temp = new ActionCardType();
		path = Paths
				.get("")
				.resolve(
						"Images/Permanent Attack " + this.getPlayerType()
								+ ".jpg").toAbsolutePath();
		try {
			temp.setImage((Scalr.resize(
					ImageIO.read(new File(path.toString())),
					Scalr.Method.BALANCED, 130, 230)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp.setCardType("Attack");
		temp.setNumber(4);
		getActioncardsPermanent().add(temp);

	}

	private void initializeBattleAndActionCards(String playerType2) {
		BattleCard temp;
		BufferedImage image;
		Path path;
		ActionCardType temp1;
		if (playerType.equals("Greek")) {
			try {
				path = Paths.get("").resolve("Images/Centaur.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Archer", 3);
				temp.getExtraDice().put("Flyer", 3);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Archer");
				temp.getUnitType().add("Cavalry");
				temp.setWoodCost(3);
				temp.setFavorCost(1);
				battleCards.put("Centaur", temp);

				path = Paths.get("").resolve("Images/Cyclops.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Mortal", 4);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant");
				temp.setFoodCost(3);
				temp.setFavorCost(3);
				battleCards.put("Cyclops", temp);

				path = Paths.get("").resolve("Images/Manticore.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Giant-Killer", 4);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Flyer");
				temp.setFoodCost(2);
				temp.setFavorCost(2);
				battleCards.put("Manticore", temp);

				path = Paths.get("").resolve("Images/Classical Greek Hero.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Myth", 4);
				temp.getUnitType().add("Hero");
				temp.setFoodCost(3);
				temp.setGoldCost(3);
				battleCards.put("Classical Greek Hero", temp);

				path = Paths.get("").resolve("Images/Toxotes.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Archer");
				temp.getExtraDice().put("Flyer", 4);
				temp.getExtraDice().put("Warrior", 3);
				temp.setFoodCost(1);
				temp.setWoodCost(1);
				battleCards.put("Toxotes", temp);

				path = Paths.get("").resolve("Images/Heroic Greek Hero.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Hero");
				temp.getExtraDice().put("Myth", 4);
				temp.setFoodCost(3);
				temp.setGoldCost(4);
				battleCards.put("Heroic Greek Hero", temp);

				path = Paths.get("").resolve("Images/Hydra.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant");
				temp.getExtraDice().put("Warrior", 4);
				temp.setGoldCost(2);
				temp.setFavorCost(2);
				battleCards.put("Hydra", temp);

				path = Paths.get("").resolve("Images/Minotaur.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Warrior");
				temp.getExtraDice().put("Cavalry", 4);
				temp.setFoodCost(2);
				temp.setWoodCost(2);
				battleCards.put("Minotaur", temp);

				path = Paths.get("").resolve("Images/Mythical Greek Hero.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Hero");
				temp.setGoldCost(4);
				temp.setFavorCost(4);
				battleCards.put("Mythical Greek Hero", temp);

				path = Paths.get("").resolve("Images/Hippokon.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Cavalry");
				temp.getExtraDice().put("Hero", 4);
				temp.getExtraDice().put("Archer", 4);
				temp.setFoodCost(1);
				temp.setGoldCost(1);
				battleCards.put("Hippokon", temp);

				path = Paths.get("").resolve("Images/Hoplite.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Warrior");
				temp.getExtraDice().put("Cavalry", 3);
				temp.getExtraDice().put("Mortal", 1);
				temp.setFoodCost(1);
				temp.setWoodCost(1);
				battleCards.put("Hoplite", temp);

				path = Paths.get("").resolve("Images/Medusa.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant-Killer");
				temp.getExtraDice().put("Giant", 6);
				temp.setFoodCost(1);
				temp.setFavorCost(3);
				battleCards.put("Medusa", temp);

				temp1 = new ActionCardType();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (playerType.equals("Egyptian")) {
			try {

				path = Paths.get("").resolve("Images/Anubite.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Archer", 4);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Cavalry");
				temp.setGoldCost(3);
				temp.setFavorCost(1);
				battleCards.put("Anubite", temp);

				path = Paths.get("").resolve("Images/Chariot Archer.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Flyer", 3);
				temp.getExtraDice().put("Warrior", 3);
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Archer");
				temp.getUnitType().add("Cavalry");
				temp.setGoldCost(1);
				temp.setWoodCost(1);
				battleCards.put("Chariot Archer", temp);

				path = Paths.get("").resolve("Images/Elephant.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Mortal", 2);
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Giant");
				temp.setFoodCost(2);
				temp.setGoldCost(1);
				battleCards.put("Elephant", temp);

				path = Paths.get("").resolve("Images/Mummy.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.setGoldCost(3);
				temp.setFavorCost(2);
				battleCards.put("Mummy", temp);

				path = Paths.get("").resolve("Images/Pharaoh.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Myth", 4);
				temp.getUnitType().add("Hero");
				temp.setFoodCost(3);
				temp.setGoldCost(3);
				battleCards.put("Pharaoh", temp);

				path = Paths.get("").resolve("Images/Phoenix.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Giant-Killer", 4);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Flyer");
				temp.setWoodCost(2);
				temp.setFavorCost(3);
				battleCards.put("Phoenix", temp);

				path = Paths.get("").resolve("Images/Priest.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(4);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Myth", 5);
				temp.getUnitType().add("Hero");
				temp.setFoodCost(2);
				temp.setGoldCost(4);
				battleCards.put("Priest", temp);

				path = Paths.get("").resolve("Images/Scorpian-Man.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Mortals", 4);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant");
				temp.setFoodCost(4);
				temp.setGoldCost(2);
				battleCards.put("Scorpian-Man", temp);

				path = Paths.get("").resolve("Images/Son of Osiris.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(8);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Myth", 4);
				temp.getUnitType().add("Hero");
				temp.setGoldCost(4);
				temp.setFavorCost(4);
				battleCards.put("Son of Osiris", temp);

				path = Paths.get("").resolve("Images/Spearman.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Cavalry", 3);
				temp.getExtraDice().put("Hero", 4);
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Warrior");
				temp.setFoodCost(1);
				temp.setWoodCost(1);
				battleCards.put("Spearman", temp);

				path = Paths.get("").resolve("Images/Sphinx.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Giants", 6);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant-Killer");
				temp.setGoldCost(2);
				temp.setFavorCost(2);
				battleCards.put("Sphinx", temp);

				path = Paths.get("").resolve("Images/Wadjet.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getExtraDice().put("Cavalry", 4);
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Warrior");
				temp.setFoodCost(2);
				temp.setFavorCost(2);
				battleCards.put("Wadjet", temp);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				path = Paths.get("").resolve("Images/Jarl.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Cavalry");
				temp.getExtraDice().put("Hero", 4);
				temp.getExtraDice().put("Archer", 4);
				temp.setFoodCost(1);
				temp.setGoldCost(1);
				battleCards.put("Jarl", temp);

				path = Paths.get("").resolve("Images/Troll.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Warrior");
				temp.getExtraDice().put("Cavalry", 4);
				temp.setFoodCost(3);
				temp.setWoodCost(2);
				battleCards.put("Troll", temp);

				path = Paths.get("").resolve("Images/Valkyrie.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Cavalry");
				temp.getExtraDice().put("Archer", 4);
				temp.setGoldCost(1);
				temp.setFavorCost(3);
				battleCards.put("Valkyrie", temp);

				path = Paths.get("").resolve("Images/Nidhogg.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(7);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Flyer");
				temp.getExtraDice().put("Giant-Killer", 4);
				temp.setGoldCost(4);
				temp.setFavorCost(1);
				battleCards.put("Nidhogg", temp);

				path = Paths.get("").resolve("Images/Dwarf.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(4);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant-Killer");
				temp.getExtraDice().put("Giant", 7);
				temp.setFoodCost(2);
				temp.setGoldCost(2);
				battleCards.put("Dwarf", temp);

				path = Paths.get("").resolve("Images/Huskarl.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Warrior");
				temp.getExtraDice().put("Cavalry", 4);
				temp.setFoodCost(1);
				temp.setGoldCost(2);
				battleCards.put("Huskarl", temp);

				path = Paths.get("").resolve("Images/Throwing Axeman.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(3);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Mortal");
				temp.getUnitType().add("Archer");
				temp.getExtraDice().put("Warrior", 3);
				temp.getExtraDice().put("Flyer", 4);
				temp.setFoodCost(1);
				temp.setWoodCost(1);
				battleCards.put("Throwing Axeman", temp);

				path = Paths.get("").resolve("Images/Classical Norse Hero.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(5);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Hero");
				temp.getExtraDice().put("Myth", 4);
				temp.setFoodCost(3);
				temp.setGoldCost(3);
				battleCards.put("Classical Norse Hero", temp);

				path = Paths.get("").resolve("Images/Heroic Norse Hero.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(6);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Hero");
				temp.getExtraDice().put("Myth", 4);
				temp.setFoodCost(3);
				temp.setGoldCost(3);
				battleCards.put("Heroic Norse Hero", temp);

				path = Paths.get("").resolve("Images/Mythical Norse Hero.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(8);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Hero");
				temp.getExtraDice().put("Myth", 4);
				temp.setFoodCost(4);
				temp.setFavorCost(4);
				battleCards.put("Mythical Norse Hero", temp);

				path = Paths.get("").resolve("Images/Frost Giant.jpg")
						.toAbsolutePath();
				image = Scalr.resize(ImageIO.read(new File(path.toString())),
						Scalr.Method.BALANCED, 130, 230);
				temp = new BattleCard();
				temp.setNumberOfDice(7);
				temp.setBattleCard(new JLabel(new ImageIcon(image)));
				temp.getUnitType().add("Myth");
				temp.getUnitType().add("Giant");
				temp.getExtraDice().put("Warrior", 2);
				temp.getExtraDice().put("Mortal", 3);
				temp.setFoodCost(4);
				temp.setFavorCost(2);
				battleCards.put("Frost Giant", temp);

			} catch (Exception e) {

			}

		}

	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getFavor() {
		return favor;
	}

	public void setFavor(int favor) {
		this.favor = favor;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public Boolean[][] getTilePlacementMatrix() {
		return tilePlacementMatrix;
	}

	public void setTilePlacementMatrix(Boolean[][] tilePlacementMatrix) {
		this.tilePlacementMatrix = tilePlacementMatrix;
	}

	public int getVictory_cubes() {
		return victory_cubes;
	}

	public void setVictory_cubes(int victory_cubes) {
		this.victory_cubes = victory_cubes;
	}

	public TerrianTile[][] getTerrianTiles() {
		return terrianTiles;
	}

	public void setTerrianTiles(TerrianTile[][] terrianTiles) {
		this.terrianTiles = terrianTiles;
	}

	public BufferedImage getPlayerBoardImage() {
		return playerBoardImage;
	}

	public void setPlayerBoardImage(BufferedImage playerBoardImage) {
		this.playerBoardImage = playerBoardImage;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public BuildingTile[] getBuildingTiles() {
		return buildingTiles;
	}

	public void setBuildingTiles(BuildingTile[] buildingTiles) {
		this.buildingTiles = buildingTiles;
	}

	public List<ActionCardType> getActioncardsPermanent() {
		return actioncardsPermanent;
	}

	public void setActioncardsPermanent(
			List<ActionCardType> actioncardsPermanent) {
		this.actioncardsPermanent = actioncardsPermanent;
	}

	public List<ActionCardType> getActioncardsRandom() {
		return actioncardsRandom;
	}

	public void setActioncardsRandom(List<ActionCardType> actioncardsRandom) {
		this.actioncardsRandom = actioncardsRandom;
	}

}
