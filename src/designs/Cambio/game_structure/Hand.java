package designs.Cambio.game_structure;

import designs.Cambio.data_layer.Card;
import designs.Cambio.exceptionHandler.CambioException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Card> cards;
    Hand(List<Card> inititalCard) throws CambioException {
       if(inititalCard.size() != 4){
           throw new CambioException(CambioException.ExceptionsReason.ILLEGAL_HAND, "\nThe size of hand to begin with is 4!");
       }
       this.cards = new ArrayList<>(inititalCard); // need to do this or else it will store as reference to initialCard;
    }

    // so that the outside Hand no one knows that its a list of Cards (Encapsulation)
    public Card getCard(int index) {
        return cards.get(index);
    }
    public void setCard(int index , Card card){
        cards.set(index, card);
    }
    public int size(){
        return cards.size();
    }
    public List<Card> getAllCards(){
        return Collections.unmodifiableList(cards);
    }
}
