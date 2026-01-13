package logic;

import java.util.ArrayList;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck ;
    private String deckName;


    public UnitDeck( String deckName) {
        this.setDeckName(deckName);
        this.cardsInDeck = new ArrayList<CardCounter>();

    }

    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public void setDeckName(String deckName) {
        if(deckName.isBlank()){
            this.deckName = "Untitled Deck";
        }else {
            this.deckName = deckName;
        }
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public String getDeckName() {
        return deckName;
    }
    public void addCard(UnitCard newCard, int count) {

        if (count <= 0) {
            return;
        }
        for (CardCounter counter : cardsInDeck) {

            if (counter.getCard().equals(newCard)) {

                counter.setCount(counter.getCount() + count);
                return;
            }
        }
        CardCounter newCounter = new CardCounter(newCard, count);
        cardsInDeck.add(newCounter);
    }

    public void removeCard(UnitCard toRemove, int count) {

        if (count <= 0) return;


        for (int i = 0; i < cardsInDeck.size(); i++) {
            CardCounter counter = cardsInDeck.get(i);
            if (counter.getCard().equals(toRemove)) {

                int newCount = counter.getCount() - count;
                counter.setCount(newCount);


                if (counter.getCount() <= 0) {
                    cardsInDeck.remove(i);
                }
                return;
            }
        }
    }
    public int cardCount() {
        int total = 0;
        for (CardCounter counter : cardsInDeck) {
            total += counter.getCount();
        }
        return total;
    }
    public boolean existsInDeck(UnitCard card) {
        for (CardCounter counter : cardsInDeck) {
            if (counter.getCard().equals(card) && counter.getCount() >= 1) {
                return true;
            }
        }
        return false;
    }
    public boolean equals(UnitDeck other) {
        return this.deckName.equals(other.getDeckName());
    }
}


