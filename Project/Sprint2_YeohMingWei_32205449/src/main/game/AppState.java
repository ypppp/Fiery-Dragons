package game;

import java.io.Serializable;

public class AppState implements Serializable {

    private static final long serialVersionUID = 1L;

    private Game game ;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
