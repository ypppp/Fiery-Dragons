package game.mechanics;

import game.mechanics.dragons.Dragon ;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import game.Game ;

import java.util.ArrayList;

public class Token {

    protected int tokenId ;
    private String tokenShortName ;
    private int tokenTileIndex ;
    private Dragon dragon ;
    private Double[] location ;
    private boolean atCave ;

    private Text dragonText ;
    private Circle tokenCircle ;
    
    public Token(int id, Dragon dragon) {
        this.tokenId = id ;
        this.dragon = dragon ;
        this.dragonText = new Text(dragon.getShortName()) ;
        tokenShortName = dragon.getShortName() ;
        tokenTileIndex = -1 ;
        atCave = true ;
        location = new Double[2] ;
        tokenCircle = new Circle(20, Color.WHITE) ;
        tokenCircle.setStroke(Color.BLACK);
        tokenCircle.setStrokeWidth(2);
    }

    public void updateLocation(double x, double y) {


        location[0] = x;
        location[1] = y ;

        tokenCircle.setLayoutX(x) ;
        tokenCircle.setLayoutY(y) ;

        dragonText.setX(x) ;
        dragonText.setY(y) ;
        dragonText.setTextAlignment(TextAlignment.CENTER) ;
    }

    public void setTokenTileIndex(int i) {
        tokenTileIndex = i ;
        System.out.println(i);
        Double[] tokenPlacement = Game.getVolcanoTiles().get(i).getTokenPlacement() ;

        updateLocation(tokenPlacement[0], tokenPlacement[1]);
    }

    public void moveCaveToVolcanoTile(int index) {
        setTokenTileIndex(index) ;
        atCaveToggle() ;
    }

    public void moveVolcanoTile(int old_index, int new_index, ArrayList<VolcanoTile> tiles) {
        setTokenTileIndex(new_index) ;
        tiles.get(old_index).isTokenToggle() ;
        tiles.get(getTokenTileIndex()).isTokenToggle() ;

    }

    public int getTokenTileIndex(){
        return tokenTileIndex ;
    }

    public boolean isAtCave() {
        return atCave ;
    }

    public void atCaveToggle() {
        atCave = !atCave ;
    }

    public Group displayToken() {
        Group g = new Group() ;
        g.getChildren().addAll(tokenCircle, dragonText) ;
        return g ;
    }


    public int getId() {
        return tokenId ;
    }

    public String getTokenShortName() {
        return tokenShortName;
    }

    public Double[] getLocation() {
        return location;
    }
}
