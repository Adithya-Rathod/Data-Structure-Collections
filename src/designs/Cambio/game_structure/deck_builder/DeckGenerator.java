package designs.Cambio.game_structure.deck_builder;

import designs.Cambio.data_layer.Card;
import designs.Cambio.data_layer.Rank;
import designs.Cambio.data_layer.Suite;

import java.util.ArrayList;
import java.util.List;

public class DeckGenerator {
    //Generator below
    public static List<Card> generateDeckFromParams(DeckParams deckParams){
        List<Card> deck= new ArrayList<>();
        for(Suite s : deckParams.getSuites()){
            for(Rank r: deckParams.getRanks()){
                deck.add(new Card(s, r));
            }
        }
        includeJoker(deckParams.getNumberOfJokersToInclude(), deck);
        return deck;
    }
    private static void includeJoker(int k, List<Card> deck){
        for(int i=0; i< k ;i++){
            deck.add(new Card(Suite.NONE, Rank.JOKER));
        }
    }
}
