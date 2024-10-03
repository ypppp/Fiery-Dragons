package game.mechanics;

import java.util.ArrayList;

public abstract class Tile {
    private int id ;
    private String name ;
    private final Double[] tokenPlacement ;
    private boolean isToken ;

    public Tile(Integer newId, String newName) {
        id = newId ;
        name = newName ;
        isToken = false ;
        tokenPlacement = new Double[2] ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTokenPlacement(double x, double y) {
        tokenPlacement[0] = x ;
        tokenPlacement[1] = y ;
    }

    public Double[] getTokenPlacement() {
        return tokenPlacement;
    }


    public void isTokenToggle() {
        isToken = !isToken ;
    }

    public boolean isToken() {
        return isToken ;
    }

    public double getX() {
        return tokenPlacement[0] ;
    }

    public double getY() {
        return tokenPlacement[1] ;
    }
}
