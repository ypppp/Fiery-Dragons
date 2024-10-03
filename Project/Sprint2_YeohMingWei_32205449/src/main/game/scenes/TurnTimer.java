package game.scenes;

import game.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class TurnTimer {
    private Timeline timeline;
    private int duration; // in seconds
    private int remainingDuration;
    private Runnable onTimeUp;

    public TurnTimer(int duration) {
        this.duration = duration;
        this.remainingDuration = duration;

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            System.out.println(remainingDuration);
            Board.updateTimerText(remainingDuration);
            if (remainingDuration > 0) {
                remainingDuration-- ;

            } else {
                Game.getInstance().nextTurn();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        startTimer(); // starts the timer when a new instance is created
    }


    private void startTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        remainingDuration = duration ;
        timeline.play();
    }

    public void resetTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        startTimer();
    }
}