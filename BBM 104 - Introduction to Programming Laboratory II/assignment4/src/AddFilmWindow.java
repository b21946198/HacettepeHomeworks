import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class AddFilmWindow
{
    public static Scene addFilmBox(Stage stage, CinemaSystem cinemaSystem, User user, ChoiceBox<String> choiceBox, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);


        Text text = new Text(25, 45, "Please give name, relative path of the trailer and duration of the film.");
        text.setFont(Font.font("Verdana", 18));
        text.setFill(Color.BLACK);

        Text text2 = new Text(160, 115, "Name:");
        text2.setFont(Font.font("Verdana", 19));
        text2.setFill(Color.BLACK);

        Text text3 = new Text(160, 150, "Trailer (Path):");
        text3.setFont(Font.font("Verdana", 19));
        text3.setFill(Color.BLACK);

        Text text4 = new Text(160, 185, "Duration (m):");
        text4.setFont(Font.font("Verdana", 19));
        text4.setFill(Color.BLACK);

        TextField textField = new TextField();
        textField.setLayoutX(320);
        textField.setLayoutY(87);
        textField.setFont(Font.font("Verdana", 14));

        TextField textField2 = new TextField();
        textField2.setLayoutX(320);
        textField2.setLayoutY(127);
        textField2.setFont(Font.font("Verdana", 14));

        TextField textField3 = new TextField();
        textField3.setLayoutX(320);
        textField3.setLayoutY(167);
        textField3.setFont(Font.font("Verdana", 14));


        Button backButton = new Button("<| BACK");
        Button okButton = new Button("OK");

        backButton.setLayoutX(170);
        backButton.setLayoutY(225);
        backButton.setFont(Font.font("Verdana", 14));

        okButton.setLayoutX(465);
        okButton.setLayoutY(225);
        okButton.setFont(Font.font("Verdana", 14));

        Text temp = new Text(170, 300, "");
        temp.setFont(Font.font("Verdana", 18));
        temp.setFill(Color.BLACK);

        root.getChildren().addAll(text, backButton, okButton, text2, text3, text4, textField, textField2, textField3, temp);


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
            String name = textField.getText();
            String path = textField2.getText();
            int duration;
            String couldBeMinutes = textField3.getText();

            String wholePath = "./assets/trailers/" + path;

            String musicFile = "./assets/effects/error.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);

            File file = new File(wholePath);

            if(name.equals(""))
            {
                mediaPlayer.play();
                temp.setText("ERROR: Film name could not be empty!");

            }

            else if(path.equals(""))
            {
                mediaPlayer.play();
                temp.setText("ERROR: Trailer path could not be empty!");
            }

            else if(!isNumeric(couldBeMinutes))
            {
                mediaPlayer.play();
                temp.setText("ERROR: Duration has to be a positive integer!");
            }

            else if(!file.exists())
            {
                mediaPlayer.play();
                temp.setText("ERROR: There is no such a trailer!");
            }

            else
            {
                duration = Integer.parseInt(couldBeMinutes);

                try {
                    bufferedWriter.write("film\t" + name + "\t" + path + "\t" + duration + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Film film = new Film(name, path, duration);
                cinemaSystem.getDatabase().getFilms().add(film);
                choiceBox.getItems().add(film.getFilmName());
                temp.setText("SUCCESS: Film added successfully");
                textField.clear();
                textField2.clear();
                textField3.clear();

            }

        });

        return scene;
    }


    public static boolean isNumeric(String str)                             // check given string is positive numeric or not
    {
        try
        {
            Integer.parseInt(str);

            return Integer.parseInt(str) > 0;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
