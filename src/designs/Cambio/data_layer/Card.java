package designs.Cambio.data_layer;

public class Card {
    private final Rank rank;
    private final Suite suite;

    public Card(Suite suite, Rank rank){
        this.suite = suite;
        this.rank = rank;
    }

    public Suite getSuite(){return this.suite;}
    public Rank getRank(){return this.rank;}

    @Override
    public String toString(){
        return rank + " of " + suite;
    }
}
