import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;

public class RemoveFilmWindow
{
    public static Scene removeFilmBox(Stage stage, CinemaSystem cinemaSystem, User user, ChoiceBox<String> choiceBox, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);


        Text text = new Text(25, 45, "Select the film that you desire to remove and then click OK");
        text.setFont(Font.font("Verdana", 18));
        text.setFill(Color.BLACK);

        Button backButton = new Button("<| BACK");
        Button okButton = new Button("OK");


        backButton.setLayoutX(170);
        backButton.setLayoutY(125);
        backButton.setFont(Font.font("Verdana", 14));

        okButton.setLayoutX(265);
        okButton.setLayoutY(125);
        okButton.setFont(Font.font("Verdana", 14));


        root.getChildren().addAll(text, backButton, okButton, choiceBox);


        backButton.setOnAction(e ->
        {
            try {
                stage.setScene(Welcome.welcomeBox(stage, cinemaSystem, user, bufferedWriter));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        okButton.setOnAction(e ->
        {
            String filmChoice = choiceBox.getValue();
            Film film = cinemaSystem.obtainFilm(filmChoice);
            cinemaSystem.getDatabase().getFilms().remove(film);
            if(cinemaSystem.getDatabase().getFilms().size() != 0)
                choiceBox.setValue(cinemaSystem.getDatabase().getFilms().get(0).getFilmName());

            choiceBox.getItems().remove(filmChoice);

        });

        return scene;
    }
}
