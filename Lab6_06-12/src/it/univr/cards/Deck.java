package it.univr.cards;

import java.util.SortedSet;
import java.util.TreeSet;

public class Deck {
    private SortedSet<Card> deck = new TreeSet<Card>();

    /**
     * Costruisce un mazzo di size carte, tutte diverse, il cui valore è da min in su.
     */
    public Deck(int size, Value min) {
        boolean aggiunto;
        for (int i = 0; i < size; i++) {
            do {
                aggiunto = deck.add(new Card(min));
            } while (!aggiunto);
        }
    }

    /**
     * Restituisce una stringa che descrive le carte in questo mazzo, costruita come la loro stampa in sequenza crescente per valore, separate da virgola, con parentesi quadre agli estremi.
     */
    public String toString() {
        String stringDeck = "[";
        for (Card card : deck) {
            if (!(card.equals(deck.last())))
                stringDeck += (card + ", ");
            else
                stringDeck += card;
        }
        return stringDeck + "]";
    }

    /**
     * Restituisce la carta più alta di questo mazzo (senza rimuoverla).
     */
    public Card best() {
        return deck.last();
    }

    /**
     * Rimuove la carta più alta di questo mazzo.
     */
    public void removeBest() {
        deck.remove(best());
    }
}