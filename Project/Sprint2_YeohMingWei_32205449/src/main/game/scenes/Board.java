package game.scenes;

import game.mechanics.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane ;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.shape.Circle ;

import game.Game ;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    static Game game = Game.getInstance() ;
    static Text displayPlayerTurn = new Text();
    static Text timerText = new Text();
    static double resolutionX = 1600 ;
    static double resolutionY = 900 ;

    static double centerX = resolutionX / 2 ;
    static double centerY = resolutionY / 2 ;

    static Pane board;
    static Pane dragonCardPane;
    static Button shuffleButton;
    static Button skipButton;

    private static Pane createBoard() {
        Pane p = new Pane();

        Circle outerCircle = new Circle(centerX, centerY, 340, Color.WHITE);
        Circle innerCircle = new Circle(centerX, centerY, 200, Color.WHITE);

        outerCircle.setStroke(Color.BLACK);
        outerCircle.setStrokeWidth(2);
        innerCircle.setStroke(Color.BLACK);
        innerCircle.setStrokeWidth(2);
        p.getChildren().addAll(outerCircle, innerCircle) ;

        for (int i = 1; i <= 24; i++) {
            int angle = 360 / 24 * i;

            double startX = Math.cos(Math.toRadians(angle)) * outerCircle.getRadius() + centerX ;
            double startY = Math.sin(Math.toRadians(angle)) * outerCircle.getRadius() + centerY;

            double endX = Math.cos(Math.toRadians(angle)) * innerCircle.getRadius() + centerX;
            double endY = Math.sin(Math.toRadians(angle)) * innerCircle.getRadius() + centerY;
            Line line = new Line(startX, startY, endX, endY);

            shuffleButton = new Button("Shuffle Cards");
            skipButton = new Button("Skip next player turn");

            updatePlayerTurn() ;
            p.getChildren().add(line) ;
        }

        timerText.setLayoutX(20);
        timerText.setLayoutY(80);
        timerText.setFont(new Font(20));
        timerText.setText("");
        p.getChildren().add(timerText);

        return p;
    }

    private static Pane addSkillButtons(){
        Pane p = new Pane() ;
        shuffleButton.setLayoutX(centerX - 500);
        shuffleButton.setLayoutY(centerY + 250);
        skipButton.setLayoutX(centerX - 500);
        skipButton.setLayoutY(centerY + 350);

        shuffleButton.setOnAction(e -> handleShuffleButtonClick(shuffleButton));
        skipButton.setOnAction(e -> handleSkipButtonClick(skipButton));

        p.getChildren().addAll(shuffleButton, skipButton) ;
        return p;
    }

    private static void handleShuffleButtonClick(Button shuffleButton) {
        Player currentPlayer = Game.getPlayer()[Game.currentTurnNumber];
        if (!currentPlayer.hasShuffled()) {
            board.getChildren().remove(dragonCardPane);
            Collections.shuffle(Game.getInstance().getWholeDragonCard());
            currentPlayer.useShuffle();
            board.getChildren().add(addDragonCard());
            Game.getInstance().nextTurn();
            Board.updatePlayerTurn();
            System.out.println(currentPlayer.getId()+1 + " has shuffled the deck!");
        } else {
            System.out.println(currentPlayer.getId()+1 + " has already used their shuffle.");
        }
    }

    private static void handleSkipButtonClick(Button skipButton) {
        Player currentPlayer = Game.getPlayer()[Game.currentTurnNumber];
        if (!currentPlayer.hasSkipped()) {
            currentPlayer.useSkipped();
            Game.getInstance().nextTurn();
            Board.updatePlayerTurn();
            Game.getInstance().nextTurn();
            Board.updatePlayerTurn();
            System.out.println(currentPlayer.getId()+1 + " has used skip turn!");
        } else {
            System.out.println(currentPlayer.getId()+1 + " has already used skip turn!");
        }

    }

    public static void updatePlayerTurn() {
        displayPlayerTurn.setY(45);
        displayPlayerTurn.setX(20);
        displayPlayerTurn.setFont(new Font(30));
        displayPlayerTurn.setText("Player's " + (game.getCurrentTurnNumber() + 1) + " TURN");

        shuffleButton.setVisible(!Game.getPlayer()[Game.currentTurnNumber].hasShuffled());
        skipButton.setVisible(!Game.getPlayer()[Game.currentTurnNumber].hasSkipped());
    }

    public static void updateTimerText(int remainingDuration) {
        timerText.setText("Time left: " + remainingDuration + " seconds");
    }

    private static Pane addPlayerTurn() {
        Pane p = new Pane() ;
        p.getChildren().add(displayPlayerTurn) ;
        return p ;
    }

    private static Pane addTiles() {
        ArrayList<VolcanoTile> tiles = game.getVolcanoTiles() ;
        Pane p = new Pane() ;

        for (int i = 1; i <= 24; i++) {
            double angle = 360.0 / 24 * i - 7.5;

            double x = Math.cos(Math.toRadians(angle)) * 240 + centerX ;
            double y = Math.sin(Math.toRadians(angle)) * 240 + centerY ;

            VolcanoTile t = tiles.get(i - 1) ;
            t.addTokenPlacement(Math.cos(Math.toRadians(angle)) * 275 + centerX, Math.sin(Math.toRadians(angle)) * 275 + centerY);
            Text text ;
            if (t.isCave()) {
                text = new Text(x, y, t.getName() + "*") ;
            } else {
                text = new Text(x, y, t.getName()) ;
            }

            p.getChildren().add(text) ;
        }
        return p ;
    }

    private static Pane addCave() {
        Pane p = new Pane() ;
        Player[] player = game.getPlayer() ;

        for (int i = 0; i <= 3; i++) {
            double angle = 90.0 * i + 22.5;

            double x = Math.cos(Math.toRadians(angle)) * 400 + centerX ;
            double y = Math.sin(Math.toRadians(angle)) * 400 + centerY ;

            Circle c = new Circle(x, y, 60, Color.WHITE);
            Cave cave = Game.caves.get(i) ;
            cave.addTokenPlacement(x, y) ;
            Text t = new Text() ;

            switch(player[i].getDragonName()) {
                case "Salamander":
                    t.setText("Salamander") ;
                    break ;
                case "Spider":
                    t.setText("Spider") ;
                    break ;
                case "Bat":
                    t.setText("Bat") ;
                    break ;
                case "Baby Dragon":
                    t.setText("Baby Dragon") ;
                    break ;
                default:
                    break ;
            }

            c.setStroke(Color.BLACK);
            c.setStrokeWidth(2);
            t.setX(x) ;
            t.setY(y) ;
            t.setTextAlignment(TextAlignment.CENTER);

            Text playerText = new Text(x, y + 40, "Player " + (i + 1)) ;
            playerText.setTextAlignment(TextAlignment.CENTER);
            p.getChildren().addAll(c, t, playerText) ;
        }
        return p ;
    }

    private static Pane addDragonCard() {
        Pane p = new Pane() ;
        for (int i = 0 ; i <= 4 ; i ++) {
            for (int j = 0 ; j <= 3 ; j ++) {
                if (i<4) {
                    int index = i * 4 + j;
                    DragonCard dc = Game.getInstance().getDragonCard(index);
                    dc.setX(centerX - 100 + (i * 60));
                    dc.setY(centerY - 100 + (j * 60));
                    System.out.println(i);
                    System.out.println(j);

                    Group group = dc.displayDragonCard();


                    p.getChildren().add(group);
                }
                else if (j == 0){
                    int index = i * 4 + j;
                    DragonCard dc = Game.getInstance().getDragonCard(index);
                    dc.setX(centerX - 100 + (i * 60));
                    dc.setY(centerY - 100 + (j * 60));
                    System.out.println(i);
                    System.out.println(j);

                    Group group = dc.displayDragonCard();

                    p.getChildren().add(group);

                }
            }
        }

        return p ;
    }

    private static Pane addToken() {
        Pane p = new Pane() ;
        for (int i = 0 ; i <= 3 ; i++) {
            Cave cave = Game.caves.get(i) ;
            Token token = Game.getPlayer()[i].getToken() ;
            token.updateLocation(cave.getX(), cave.getY()) ;

            p.getChildren().add(token.displayToken()) ;
        }
        return p ;
    }
    public static Scene changeScene(Stage s) {

        board = createBoard();
        board.getChildren().addAll(addPlayerTurn(), addTiles(), addCave(), addToken(), addDragonCard(),  addSkillButtons()) ;
        return new Scene(board, resolutionX , resolutionY) ;
    }
}
