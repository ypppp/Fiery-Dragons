package game.mechanics;

import game.mechanics.dragons.Dragon;

import java.util.ArrayList;

public class VolcanoCard {
    private ArrayList<Dragon> dragon ;
    private boolean isCave = false ;

    public VolcanoCard(Dragon d1, Dragon d2, Dragon d3, boolean b) {
        dragon = new ArrayList<>() ;
        dragon.add(d1) ;
        dragon.add(d2) ;
        dragon.add(d3) ;
        isCave = b ;
    }

    public Dragon getDragon(int n) {
        return dragon.get(n);
    }

    public boolean getIsCave() {
        return isCave ;
    }
}
