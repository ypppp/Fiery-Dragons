package game.mechanics.actions;

import game.Game;
import game.mechanics.*;
import game.scenes.Board ;
import game.scenes.GameOver;
import game.scenes.MainMenu;

import java.util.ArrayList;
import java.util.Objects;

public class MoveAction {

    public void execute(Player player, DragonCard dragonCard) {
        Token token = player.getToken() ;
        ArrayList<VolcanoTile> tiles = Game.getVolcanoTiles() ;
        Player[] p;
        ArrayList<Player> playerList = new ArrayList<Player>();
        p = Game.getPlayer();
        int distance;
        int distance2 = 50;

        System.out.println(p[0].getToken().getLocation()[0]);

        // If token is at cave
        if (token.isAtCave()) {
            // If the name of the cave is same as the flipped card.
            if (Objects.equals(token.getTokenShortName(), dragonCard.getDragonName())) {
                token.moveCaveToVolcanoTile(tileIndex(Game.caves.get(token.getId()).getGoToTileIndex())); ;
            } else {
                // Go next turn if the dragon car flipped is different.
                Game.getInstance().nextTurn() ;

            }
        } else {
            int previous_index = token.getTokenTileIndex() ;
            System.out.println("Previous index: " + previous_index);
            if (Objects.equals(dragonCard.getDragonName(), "PD")) {
                int new_index = tileIndex(previous_index - dragonCard.getSteps());
                System.out.println("Index: " + new_index);
                if (!checkTile(new_index)) {
                    System.out.println("Index: " + new_index);
                    token.setTokenTileIndex(new_index);
                    tiles.get(previous_index).isTokenToggle();
                    tiles.get(token.getTokenTileIndex()).isTokenToggle();
                }
                Game.getInstance().nextTurn();
                Board.updatePlayerTurn();
            } else if((Objects.equals(dragonCard.getDragonName(), "R"))){
                System.out.println(token.getLocation()[0]);
                System.out.println(token.getLocation()[1]);

                for (int i = 0; i < 4; i++){        // gets the other 3 players except the current players turn
                    if(p[i] != player){
                        playerList.add(p[i]);
                    }
                }

                for (Player play : playerList){     // Loops through the other 3 players and find the minimum distance backwards or forwards rregardless

                    if (play.getToken().getTokenTileIndex() != -1) {

                        distance = token.getTokenTileIndex() - play.getToken().getTokenTileIndex();

                        if (Math.abs(distance) < Math.abs(distance2)) {
                            distance2 = distance;
                        }
                    }


                    System.out.println(distance2);
                }

                if (distance2 != 50) {      // 50 is set as a flag. If it is not overwritten, it means all the other players are still in the cave.

                    for (Player play : playerList) {        // gets the nearest token and swap it with the current player's token
                        if (token.getTokenTileIndex() - play.getToken().getTokenTileIndex() == distance2) {
                            double x1 = play.getToken().getLocation()[0];
                            double y1 = play.getToken().getLocation()[1];
                            int d1 = play.getToken().getTokenTileIndex();
                            double x2 = token.getLocation()[0];
                            double y2 = token.getLocation()[1];
                            int d2 = token.getTokenTileIndex();

                            play.getToken().updateLocation(x2, y2);
                            token.updateLocation(x1, y1);
                            play.getToken().setTokenTileIndex(d2);
                            token.setTokenTileIndex(d1);
                        }
                    }

                }

                System.out.println(playerList);

                Game.getInstance().nextTurn() ;
                Board.updatePlayerTurn() ;
            }
            else {
                if (Objects.equals(tiles.get(previous_index).getName(), dragonCard.getDragonName())) {
                    int new_index = tileIndex(previous_index + dragonCard.getSteps()) ;

                    if (checkWinCondition(player, dragonCard.getSteps())) {
                        System.out.println("Player " + player.getId() + " has won!");
                        Game.getInstance().setScene(GameOver.changeScene(player));
                    }

                    if (!checkTile(new_index)) {
                        token.setTokenTileIndex(new_index) ;
                        tiles.get(previous_index).isTokenToggle() ;
                        tiles.get(token.getTokenTileIndex()).isTokenToggle() ;
                    } else {
                        Game.getInstance().nextTurn() ;
                        Board.updatePlayerTurn() ;
                    }
                } else {
                    Game.getInstance().nextTurn() ;
                    Board.updatePlayerTurn() ;
                }
            }
        }
        System.out.printf("TileIndex: %d, x: %f, y: %f\n", token.getTokenTileIndex(), token.getLocation()[0], token.getLocation()[1]);
    }

    public boolean checkWinCondition(Player player, int steps) {
        Token token = player.getToken();
        int winningTileIndex = Game.caves.get(token.getId()).getGoToTileIndex();
        System.out.println("index: " + winningTileIndex + " token: " + (token.getTokenTileIndex() + steps));
        return (tileIndex(token.getTokenTileIndex() + steps)) == (winningTileIndex + 1);
    }

    public int tileIndex(int n) {
        if (n < 0) { return 24 + n ; }
        if (n > 23) { return n - 24 ; }
        return n ;
    }

    public boolean checkTile(int n) {
        return Game.getVolcanoTiles().get(n).isToken() ;
    }
}
