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

public class AddHallWindow
{
    public static Scene addHallWindowBox(Stage stage, CinemaSystem cinemaSystem, Film film, User user, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        stage.setWidth(700);
        stage.setHeight(430);


        String info = film.getFilmName() + " (" + film.getDuration() + " minutes)";

        Text text = new Text(140, 75, info);
        text.setFont(Font.font("Verdana", 22));
        text.setFill(Color.BLACK);

        Text text2 = new Text(170, 125, "Row:");
        text2.setFont(Font.font("Verdana", 22));
        text2.setFill(Color.BLACK);

        Text text3 = new Text(170, 175, "Column:");
        text3.setFont(Font.font("Verdana", 22));
        text3.setFill(Color.BLACK);


        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        ChoiceBox<Integer> choiceBox2 = new ChoiceBox<>();

        for(int i = 3; i <= 10; i++)
        {
            choiceBox.getItems().add(i);
            choiceBox2.getItems().add(i);
        }

        choiceBox.setValue(choiceBox.getItems().get(0));
        choiceBox2.setValue(choiceBox.getItems().get(0));

        choiceBox.setLayoutX(330);
        choiceBox.setLayoutY(105);

        choiceBox2.setLayoutX(330);
        choiceBox2.setLayoutY(155);


        Text text4 = new Text(170, 225, "Name:");
        text4.setFont(Font.font("Verdana", 22));
        text4.setFill(Color.BLACK);


        Text text5 = new Text(170, 275, "Price:");
        text5.setFont(Font.font("Verdana", 22));
        text5.setFill(Color.BLACK);


        TextField textField = new TextField();
        textField.setLayoutX(265);
        textField.setLayoutY(204);
        textField.setFont(Font.font("Verdana", 14));

        TextField textField2 = new TextField();
        textField2.setLayoutX(265);
        textField2.setLayoutY(260);
        textField2.setFont(Font.font("Verdana", 14));

        Button backButton = new Button("<| BACK");
        Button okButton = new Button("OK");

        backButton.setLayoutX(170);
        backButton.setLayoutY(315);
        backButton.setFont(Font.font("Verdana", 14));

        okButton.setLayoutX(410);
        okButton.setLayoutY(315);
        okButton.setFont(Font.font("Verdana", 14));



        Text temp = new Text(170, 375, "");
        temp.setFont(Font.font("Verdana", 18));
        temp.setFill(Color.BLACK);



        root.getChildren().addAll(text, text2, text3, choiceBox, choiceBox2, text4, text5, textField, textField2, backButton, okButton, temp);


        okButton.setOnAction(e ->
        {
            String musicFile = "./assets/effects/error.mp3";
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);

            int price;
            String hallName = textField.getText();
            String tempPrice = textField2.getText();

            if(hallName.equals(""))
            {
                mediaPlayer.play();
                temp.setText("ERROR: Hall name could not be empty!");
                temp.setFont(Font.font("Verdana", 18));
                temp.setFill(Color.BLACK);
            }

            else if(tempPrice.equals(""))
            {
                mediaPlayer.play();
                temp.setText("ERROR: Price could not be empty!");
                temp.setFont(Font.font("Verdana", 18));
                temp.setFill(Color.BLACK);
            }

            else if(!isNumeric(tempPrice))
            {
                mediaPlayer.play();
                temp.setText("ERROR: Price has to be a positive integer!");
                temp.setFont(Font.font("Verdana", 18));
                temp.setFill(Color.BLACK);
            }

            else if(hallCheck(hallName, cinemaSystem))
            {
                mediaPlayer.play();
                temp.setText("ERROR: This Hall name already exists!");
                temp.setFont(Font.font("Verdana", 18));
                temp.setFill(Color.BLACK);
            }

            else
            {
                int rows = choiceBox.getValue();
                int columns = choiceBox2.getValue();

                price = Integer.parseInt(tempPrice);
                Hall hall = new Hall(film.getFilmName(), hallName, price, rows, columns);
                cinemaSystem.getDatabase().getHalls().add(hall);
                film.addHallToFilm(hall);

                try {
                    bufferedWriter.write("hall\t" + hall.getFilmName() + "\t" + hall.getHallName() + "\t" + hall.getPricePerSeat() +
                            "\t" + hall.getNumberOfRows() + "\t" + hall.getNumberOfColumns() + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                temp.setText("SUCCESS: Hall successfully created");
                textField.clear();
                textField2.clear();

            }

        });


        backButton.setOnAction(e ->
        {
            try {
                stage.setScene(FilmWindow.filmWindowBox(stage, cinemaSystem, film, user, bufferedWriter));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        return scene;
    }


    public static boolean hallCheck(String hallName, CinemaSystem cinemaSystem)
    {
        for(Hall hall : cinemaSystem.getDatabase().getHalls())
            if(hallName.equals(hall.getHallName()))
                return true;

        return false;
    }


    public static boolean isNumeric(String str)                                                         // check whether given string is numeric
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
