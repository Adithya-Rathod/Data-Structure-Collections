package designs.Cambio.game_structure;

public class Player {
    private final String name;
    private Hand hand;
    private boolean hasCalledCambio;
    private boolean active;
    Player(String name){
        this.name = name;
        this.hasCalledCambio = false;
        this.active = true;
    }
    public void assignHand(Hand hand) { this.hand = hand;}
    public boolean hasCalledCambio() {
        return this.hasCalledCambio;
    }
    public Hand getHand(){return this.hand;}
    public String getName(){return this.name;}
    public boolean isActive(){return this.active;}
    public void callCambio(){this.hasCalledCambio = true;}
    public void eliminate(){this.active = false;}
}
