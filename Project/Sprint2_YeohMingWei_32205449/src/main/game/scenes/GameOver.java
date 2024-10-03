package game.scenes;

import game.Game;
import game.mechanics.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver {
    private static Text winText ;

    public static Scene changeScene(Player player) {
        Game game = Game.getInstance() ;
        winText = new Text("Player " + (player.getId() + 1) + " has won!") ;
        winText.setFont(Font.font(32));

        Button mainMenuButton = new Button("Main Menu") ;
        mainMenuButton.setOnAction(e -> game.setScene(MainMenu.changeScene(game.getStage(), new Text(game.getName()))));

        VBox layout = new VBox(10) ;
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20)) ;
        layout.getChildren().addAll(winText, mainMenuButton) ;

        game.reset() ;

        return new Scene(layout, 1280, 720);
    }
}
