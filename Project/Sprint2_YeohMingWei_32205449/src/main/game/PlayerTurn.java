package game;

import game.mechanics.Player;
import game.scenes.Board;
import game.scenes.TurnTimer;

public class PlayerTurn {

    private Player player;
    private TurnTimer turnTimer;
    private static final int TURN_DURATION = 10; // 10 seconds

    public PlayerTurn(Player player) {
        this.player = player;
        this.turnTimer = new TurnTimer(TURN_DURATION); // Start the timer automatically
    }

    public void endTurn() {
        Game game = Game.getInstance();
        game.nextTurn();
    }

    public Player getPlayer() {
        return player;
    }

    public void changePlayerTurn(Player player) {
        this.player = player ;
    }

    public TurnTimer getTurnTimer() {
        return turnTimer;
    }
}
