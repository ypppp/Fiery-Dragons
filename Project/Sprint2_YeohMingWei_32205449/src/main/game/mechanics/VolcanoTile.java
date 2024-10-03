package game.mechanics;

public class VolcanoTile extends Tile {

    private final boolean isCave ;

    public VolcanoTile(Integer newId, String newName, boolean b) {
        super(newId, newName);
        isCave = b ;
    }

    public boolean isCave() {
        return isCave ;
    }
}
