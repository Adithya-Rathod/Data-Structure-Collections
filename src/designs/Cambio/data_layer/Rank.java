package designs.Cambio.data_layer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    JOKER(0),
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6 ),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    Rank(int denomination){this.denomination = denomination;}
    private final int denomination;
    public int getDenomination(){return this.denomination;}
    public static List<Rank> getAllRanks(){
        return Arrays.stream(Rank.values())
                .collect(Collectors.toList());
    }
}