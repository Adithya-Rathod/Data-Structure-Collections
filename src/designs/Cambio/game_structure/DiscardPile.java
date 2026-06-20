package designs.Cambio.game_structure;

import designs.Cambio.data_layer.Card;
import designs.Cambio.exceptionHandler.CambioException;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
    private List<Card> pile;
    DiscardPile(){
        this.pile = new ArrayList<>();
    }

    public Card peekTop() throws CambioException {
        if(pile.isEmpty()){
            throw new CambioException(CambioException.ExceptionsReason.EMPTY_DECK , "\nThe discard pile has no cards to peek from");
        }
        return pile.getLast();
    }
    public void discard(Card card){
        pile.add(card);
    }
    public boolean isEmpty(){return this.pile.isEmpty();}
    public int size(){return this.pile.size();}
}
