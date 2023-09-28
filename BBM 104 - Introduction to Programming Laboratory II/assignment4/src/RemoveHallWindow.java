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

public class RemoveHallWindow
{
    public static Scene removeHallWindowBox(Stage stage, CinemaSystem cinemaSystem, Film film, User user, ChoiceBox<String> filmHalls, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        stage.setWidth(600);
        stage.setHeight(400);

        Text text = new Text(40, 75, "Select the hall that you desire to remove\nfrom " + film.getFilmName() + " and then click OK.");
        text.setFont(Font.font("Verdana", 22));
        text.setFill(Color.BLACK);
        
        filmHalls.setLayoutX(225);
        filmHalls.setLayoutY(125);

        Button backButton = new Button("<| BACK");
        Button okButton = new Button("OK");

        backButton.setLayoutX(225);
        backButton.setLayoutY(175);
        backButton.setFont(Font.font("Verdana", 14));

        okButton.setLayoutX(325);
        okButton.setLayoutY(175);
        okButton.setFont(Font.font("Verdana", 14));



        root.getChildren().addAll(text, filmHalls, backButton, okButton);


        backButton.setOnAction(e ->
        {
            try {
                stage.setScene(FilmWindow.filmWindowBox(stage, cinemaSystem, film, user, bufferedWriter));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        okButton.setOnAction(e ->
        {
            String chosenHall = filmHalls.getValue();
            Hall temp = cinemaSystem.obtainHall(chosenHall, film);
            film.getFilmsHalls().remove(temp);
            cinemaSystem.getDatabase().getHalls().remove(temp);
            filmHalls.getItems().remove(chosenHall);

            if(filmHalls.getItems().size() != 0)
            {
                filmHalls.setValue(filmHalls.getItems().get(0));
            }

        });

        return scene;
    }
}
