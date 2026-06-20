package designs.Cambio.game_structure.deck_builder;

import designs.Cambio.data_layer.Rank;
import designs.Cambio.data_layer.Suite;

import java.util.List;

public class DeckParams {
    private final int numberOfJokersToInclude;
    private final List<Suite> suites;
    private final List<Rank> ranks;

    private DeckParams(Builder builder){
        this.numberOfJokersToInclude = builder.numberOfJokersToInclude;
        this.suites = builder.suites;
        this.ranks = builder.ranks;
    }
    //immutable getters here
    public List<Suite> getSuites() {
        return suites;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public int getNumberOfJokersToInclude() {
        return numberOfJokersToInclude;
    }

    public static class Builder{
        private int numberOfJokersToInclude =0;
        private List<Suite> suites;
        private List<Rank> ranks;

        public Builder(){}
        //building setters here

        public Builder setNumberOfJokersToInclude(int numberOfJokersToInclude) {
            this.numberOfJokersToInclude = numberOfJokersToInclude;
            return this;
        }

        public Builder setRanks(List<Rank> ranks) {
            this.ranks = ranks;
            return this;
        }

        public Builder setSuites(List<Suite> suites) {
            this.suites = suites;
            return this;
        }

        public DeckParams build(){
            if(suites == null || ranks == null){
                throw new RuntimeException("Missing requirements to build deck");
            }
            return new DeckParams(this);
        }
    }
}
