package game.scenes;

import game.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainMenu {

    public static Scene changeScene(Stage s, Text text) {
        text.setFont(Font.font(64));

        Button openPlayerMenu = new Button("Play") ;
        openPlayerMenu.setOnAction(e -> s.setScene(PlayerSelectionMenu.changeScene(s)));

        VBox layout = new VBox(10) ;
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20)) ;
        layout.getChildren().addAll(text, openPlayerMenu) ;

        return new Scene(layout, 1280, 720);
    }

}
