package game.mechanics;

import game.Game;
import game.mechanics.actions.MoveAction;
import game.mechanics.dragons.Dragon;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DragonCard {

    protected int id ;
    protected Dragon dragon ;
    protected int steps ;
    private Double[] location;
    private Circle dragonCardCircle ;
    private Text dragonCardText ;
    private boolean flipped ;

    public DragonCard(int id, Dragon dragon, int steps) {
        this.id = id ;
        this.dragon = dragon ;
        this.steps = steps ;
        this.location = new Double[2];
        this.flipped = false ;
    }

    public int getId() {
        return id;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public String getDragonName() {
        return dragon.getShortName() ;
    }

    public int getSteps() {
        return steps;
    }

    public boolean isFlipped() {
        return flipped ;
    }

    public void setX(double x){
        location[0] = x;
    }

    public void setY(double y){
        location[1] = y;
    }

    public Group displayDragonCard() {
        dragonCardCircle = new Circle(location[0], location[1], 25, Color.WHITE);
        dragonCardText = new Text(steps + "X " + getDragonName()) ;

        dragonCardCircle.setStroke(Color.BLACK);
        dragonCardCircle.setStrokeWidth(2);

        dragonCardText.setFont(new Font(10));
        dragonCardText.setFill(Color.WHITE);
        double textWidth = dragonCardText.getBoundsInLocal().getWidth();
        double textHeight = dragonCardText.getBoundsInLocal().getHeight();
        dragonCardText.setX(dragonCardCircle.getCenterX() - textWidth / 2);
        dragonCardText.setY(dragonCardCircle.getCenterY() + textHeight / 4);
        Group g = new Group(dragonCardCircle, dragonCardText) ;
        g.setOnMouseClicked(e -> {
            Game.getInstance().setDragonCardIndex(id);
            if (dragonCardText.getFill() == Color.WHITE && !flipped) {
                dragonCardText.setFill(Color.BLACK);
                flipped = true ;
                PauseTransition pause = new PauseTransition(Duration.seconds(1)) ;
                pause.setOnFinished(event -> {
                    MoveAction moveAction = new MoveAction();
                    moveAction.execute(Game.getPlayer()[Game.currentTurnNumber], this) ;
                });
                pause.play() ;
            }
        });
        return g ;
    }

    public void playerTurnReset() {
        dragonCardText.setFill(Color.WHITE);
    }

    public void reset() {
        dragonCardText.setFill(Color.WHITE) ;
        flipped = false ;
    }

    @Override
    public String toString() {
        return "DragonCard{" +
                "id=" + id +
                ", dragon='" + getDragonName() + '\'' +
                ", steps=" + steps +
                '}';
    }
}
