package designs.Cambio.game_structure.deck_builder;

import designs.Cambio.data_layer.Card;
import designs.Cambio.data_layer.Rank;
import designs.Cambio.data_layer.Suite;
import java.util.Arrays;
import java.util.List;


public class DeckFactory {

    public List<Card> createCambioDeck() {
       DeckParams deckParams = new DeckParams.Builder()
               .setNumberOfJokersToInclude(2)
               .setRanks(Arrays.asList(Rank.ACE, Rank.TWO, Rank.THREE, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING))
               .setSuites(Arrays.asList(Suite.HEARTS, Suite.DIAMONDS, Suite.CLUBS, Suite.SPADES))
               .build();

       return DeckGenerator.generateDeckFromParams(deckParams);
   }

}
