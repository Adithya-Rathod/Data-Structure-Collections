package designs.Cambio;

import designs.Cambio.game_structure.GameState;

public class GameEngine {
    private GameState gameState;
    private GameEngine gameEngine = null;
    GameEngine(){}
    public GameEngine getInstance(){
        if (gameEngine == null){
            gameEngine = new GameEngine();
        }
        return gameEngine;
    }

    public GameState startOfGame(GameState gameState) {
        return null;
    }
}
