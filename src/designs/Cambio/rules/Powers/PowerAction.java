package designs.Cambio.rules.Powers;

import designs.Cambio.game_structure.GameState;
import designs.Cambio.game_structure.Player;

import java.util.Optional;

public interface PowerAction {
    void apply(GameState GameState, Player actor, Optional<Player> target);
}
