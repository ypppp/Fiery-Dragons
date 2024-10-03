package game ;

import javafx.application.Application ;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

import game.scenes.MainMenu;

/**
 * The main class to start the application.
 */
public class Main extends Application {
    public static Stage stage ;
    @Override
    public void start(Stage stage) throws IOException {
        Game game = Game.getInstance() ;
        game.setStage(stage) ;
        String gameName = game.getName() ;

        stage.setTitle(gameName) ;
        stage.setScene(MainMenu.changeScene(stage, new Text(gameName))) ;
        stage.show() ;

    }

    // Launch the application.
    public static void main(String[] args) {
        launch();
    }
}
