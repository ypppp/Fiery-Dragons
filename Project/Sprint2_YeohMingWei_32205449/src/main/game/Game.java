package game ;

import game.mechanics.*;
import game.mechanics.dragons.*;
import game.scenes.Board;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

/**
 * The game class manages all object that is related to the game.
 * The objects will be the player, volcano cards, dragon cards.
 */
public class Game {

    private Stage stage ;
    private static Game game ;
    private static Player[] player  ;
    protected String name ;
    protected static boolean startGame ;
    private static ArrayList<VolcanoCard> volcanoCards ;
    private static ArrayList<VolcanoCard> volcanoCardsCave ;
    private static ArrayList<VolcanoTile> volcanoTiles ;
    public static ArrayList<Cave> caves ;
    private ArrayList<DragonCard> dragonCards ;

    private static int pickDragonCardIndex ;
    private static PlayerTurn currentTurn;
    public static int currentTurnNumber;

    /**
     * The constructor of the Game class.
     */
    public Game() {
        name = "Fiery Dragon" ;
        startGame = false ;
        player = new Player[4] ;
        volcanoCards = new ArrayList<>() ;
        volcanoCardsCave = new ArrayList<>() ;
        dragonCards = new ArrayList<>() ;

        currentTurnNumber = 0 ;
    }



    public static Game getInstance() {
        if (game == null) {
            game = new Game() ;
        }
        return game ;
    }

    public void startGame(ArrayList<String> options) {
        addDragonCard() ;
        addVolcanoCard() ;

        for (String n : options) {
            System.out.println("Dragon: " + n);
        }
        startGame = true ;
        volcanoTiles = new ArrayList<>() ;
        caves = new ArrayList<>() ;

        for (int i = 0 ; i < 4 ; i++) {
            player[i] = new Player(i, options.get(i)) ;
            caves.add(new Cave(player[i].getId(), player[i].getDragonName(), (i * 6 + 1))) ;
        }

        for (int i = 0 ; i < volcanoCards.size() ; i++) {
            for(int j = 0 ; j <= 2 ; j++) {
                VolcanoCard vc = volcanoCards.get(i) ;
                volcanoTiles.add(new VolcanoTile(volcanoTiles.size(), vc.getDragon(j).getShortName(), vc.getIsCave())) ;
            }
            for(int j = 0 ; j <= 2 ; j++) {
                VolcanoCard vc = volcanoCardsCave.get(i) ;
                volcanoTiles.add(new VolcanoTile(volcanoTiles.size(), vc.getDragon(j).getShortName(), vc.getIsCave())) ;
            }
        }


        for (VolcanoTile t : volcanoTiles) {
            System.out.format("id: %d, name: %s%n", t.getId(), t.getName());
        }
        currentTurn = new PlayerTurn(player[currentTurnNumber]);
        pickDragonCardIndex = -1 ;

    }

    public void reset() {
        volcanoCards.clear() ;
        volcanoCardsCave.clear() ;
        volcanoTiles.clear() ;
        dragonCards.clear() ;
        caves.clear() ;

        player = new Player[4] ;

        startGame = false ;
        currentTurnNumber = 0 ;
    }

    public void nextTurn() {
        // Advance to the next player's turn
        currentTurnNumber = ((currentTurnNumber + 1) % player.length) ;
        currentTurn.changePlayerTurn(player[currentTurnNumber]);

        for (DragonCard dc : dragonCards) {
            dc.reset() ;
        }
        Board.updatePlayerTurn();
        currentTurn.getTurnTimer().resetTimer();
    }


    public int getCurrentTurnNumber() {
        return currentTurnNumber;
    }

    public void addDragonCard() {

        Dragon[] dragons = new Dragon[] { new Salamander(), new Spider(), new Bat(), new BabyDragon() } ;

        for (int i = 0 ; i <= 11 ; i++) {
            dragonCards.add(new DragonCard(dragonCards.size(), dragons[i % 4], (i / 4) + 1)) ;
        }

        for (int j = 1 ; j <= 4 ; j ++) {
            dragonCards.add(new DragonCard(dragonCards.size(), new PirateDragon(), j % 2 + 1)) ;
        }

        dragonCards.add(new DragonCard(dragonCards.size(), new Racoon(), 1));

        Collections.shuffle(dragonCards) ;
        for (DragonCard d : dragonCards) {
            System.out.format("id: %d, card: %s, steps: %d%n", d.getId(), d.getDragon(), d.getSteps()) ;
        }
    }

    public void addVolcanoCard() {
        Dragon[][] dragons = new Dragon[][] {
                { new BabyDragon(), new Bat(), new Spider() },              // Cave
                { new Salamander(), new Spider(), new Bat() },              // Cave
                { new Spider(), new Salamander(), new BabyDragon() },       // Cave
                { new Bat(), new Spider(), new BabyDragon() },              // Cave
                { new Spider(),new Bat(), new Salamander() },               // Non-Cave
                { new BabyDragon(), new Salamander(), new Bat() },          // Non-Cave
                { new Bat(), new BabyDragon(), new Salamander() },          // Non-Cave
                { new Salamander(), new BabyDragon(), new Spider() }        // Non-Cave
        } ;

        for (int i = 0 ; i <= 3 ; i++) {
            int j = i + 4 ;     // To get the index for non-cave in dragons array
            volcanoCardsCave.add(new VolcanoCard(dragons[i][0], dragons[i][1], dragons[i][2], true)) ;
            volcanoCards.add(new VolcanoCard(dragons[j][0], dragons[j][1], dragons[j][2], false)) ;
        }
        Collections.shuffle(volcanoCardsCave) ;
        Collections.shuffle(volcanoCards) ;
    }

    public static ArrayList<VolcanoTile> getVolcanoTiles() {
        return volcanoTiles;
    }

    public static Player[] getPlayer() {
        return player;
    }

    public DragonCard getDragonCard(int i) {
        return dragonCards.get(i) ;
    }

    public ArrayList<DragonCard> getWholeDragonCard() {
        return dragonCards ;
    }

    public void setDragonCardIndex(int i) {
        pickDragonCardIndex = i ;
    }

    public String getName(){
        return name ;
    }

    public void setStage(Stage stage) {
        this.stage = stage ;
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage ;
    }
}
