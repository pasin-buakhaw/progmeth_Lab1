package logic;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		for(UnitCard a_card : list){
			if(a_card.equals(card)){return true;}
		}
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {

		for(UnitDeck a_deck : list){
			if(a_deck.equals(deck)){return true;}
		}
		return false;

	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {

		for (UnitDeck deck : deckList) {

			if (deck.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) {

		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		InputStream inputStream = CardUtil.class.getClassLoader().getResourceAsStream(filename);

		if (inputStream == null) {
			System.out.println("Cannot find file!");
			return null;
		}

		Scanner myReader = new Scanner(inputStream);

		// TODO: Fill Code below
		try {
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] dataArray = line.split(",");
				ArrayList<String> cardData = new ArrayList<String>(Arrays.asList(dataArray));
				String name = cardData.get(0);
				int bloodCost = Integer.parseInt(cardData.get(1));
				int power = Integer.parseInt(cardData.get(2));
				int health = Integer.parseInt(cardData.get(3));
				String flavorText = cardData.get(4);

				UnitCard newCard = new UnitCard(name, bloodCost, power, health, flavorText);

				cardsFromFile.add(newCard);
			}
		} catch (Exception e) {

			System.out.println("File contains string with incorrect format!");
			return null;
		} finally {

			myReader.close();
		}

		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
