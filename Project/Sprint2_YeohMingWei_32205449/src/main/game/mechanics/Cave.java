package game.mechanics;

import java.util.ArrayList;

public class Cave extends Tile {
    private int goToTileIndex ;

    public Cave(int newId, String newName, int tileId) {
        super(newId, newName);
        goToTileIndex = tileId ;
        System.out.println(tileId);
    }

    public int getGoToTileIndex() {
        return goToTileIndex;
    }
}