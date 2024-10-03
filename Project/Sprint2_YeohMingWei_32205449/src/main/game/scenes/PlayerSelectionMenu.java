package game.scenes;

import game.Game;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PlayerSelectionMenu {

    private static ArrayList<String> selectedOptions = new ArrayList<>();
    private static Text errorText ;

    public static Scene changeScene(Stage s) {

        VBox vbox = new VBox(10) ;

        String[] players = {"Player 1", "Player 2", "Player 3", "Player 4"};
        ChoiceBox[] choiceBoxes = new ChoiceBox[4] ;
        errorText = new Text("") ;

        for (int i = 0 ; i < 4 ; i++) {
            ChoiceBox cb = new ChoiceBox();
            HBox hbox = new HBox(20);

            cb.getItems().addAll("Spider", "Bat", "Salamander", "Baby Dragon");
            cb.setOnAction(e -> cb.getValue());
            hbox.getChildren().addAll(new Text(players[i]), cb);
            vbox.getChildren().add(hbox);
            choiceBoxes[i] = cb ;
        }

        Button start = new Button("Start!") ;;
        start.setOnAction(e -> handleSelection(s, choiceBoxes, vbox)) ;
        vbox.getChildren().addAll(start, errorText) ;

        return new Scene(vbox, 1280, 720);
    }

    private static void handleSelection(Stage s, ChoiceBox[] choiceBoxes, VBox vb) {
        boolean check = false ;
        // Display the selected options for each player
        for (int i = 0; i < choiceBoxes.length; i++) {
            String value = (String) choiceBoxes[i].getValue();
            if (selectedOptions.contains(value)) {
                // Handle duplicate selection (e.g., display an error message)
                System.out.println("Error: " +  choiceBoxes[i] + " is already selected by another player!");
                showError() ;
                selectedOptions.removeAll(selectedOptions) ;
                check = true ;
                break ;
            } else {
                // Add the selected option to the set of selected options
                selectedOptions.add(value);
            }
        }

        if (!check) {
            removeError() ;
            Game.getInstance().startGame(selectedOptions) ;
            selectedOptions.removeAll(selectedOptions) ;
            s.setScene(Board.changeScene(s)) ;
        }

    }

    private static void showError() {
        errorText.setText("Error") ;
    }

    private static void removeError() {
        errorText.setText("") ;
    }
}
