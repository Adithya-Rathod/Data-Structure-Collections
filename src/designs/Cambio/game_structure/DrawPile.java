package designs.Cambio.game_structure;

import designs.Cambio.data_layer.Card;
import designs.Cambio.exceptionHandler.CambioException;

import java.util.*;

public class DrawPile {
    private final List<Card> cards;

    // give me a set of cards and i will shuffle it and make the drawpile
    DrawPile(List<Card> givenCards){
        this.cards = givenCards;
        shuffle();
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw() throws CambioException{
        if(cards.isEmpty()){
            throw new CambioException(CambioException.ExceptionsReason.EMPTY_DECK, "\ncannot draw from an empty deck");
        }
        return cards.removeFirst();
    }

    public int getSize(){return this.cards.size();}
 }
