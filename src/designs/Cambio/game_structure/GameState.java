package designs.Cambio.game_structure;

import java.util.List;

// this is the game state( a pojo) on which the game engine acts
public class GameState {
    private  List<Player> players;
    private DiscardPile discardPile;
    private DrawPile drawPile;
    private boolean CambioCalled;
    private int turnIndex;

    GameState(List<Player> players, DrawPile drawPile, DiscardPile discardPile){
        this.players = players;
        this.discardPile = discardPile;
        this.drawPile = drawPile;
        this.CambioCalled = false;
        this.turnIndex = 0;
    }

    public List<Player> getPlayers(){return this.players;}
    public Player getCurrentPlayer(){return this.players.get(this.turnIndex);}
    public void moveToNextPlayer(){this.turnIndex = (this.turnIndex + 1) % players.size();}
    public boolean isCambioCalled(){return this.CambioCalled;}
    public DiscardPile getDiscardPile(){return this.discardPile;}
    public DrawPile getDrawPile(){return this.drawPile;}
    public int getTurn(){return this.turnIndex;}
}
