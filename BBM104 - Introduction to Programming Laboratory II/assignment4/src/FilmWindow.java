import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FilmWindow
{
    public static Scene filmWindowBox(Stage stage, CinemaSystem cinemaSystem, Film film, User user, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        stage.setWidth(850);
        stage.setHeight(600);

        String info = film.getFilmName() + " (" + film.getDuration() + " minutes)";

        Text text = new Text(200, 75, info);
        text.setFont(Font.font("Verdana", 22));
        text.setFill(Color.BLACK);

        Button playStopButton = new Button("|>");
        Button backButton = new Button("<<");
        Button forwardButton = new Button(">>");
        Button backToBeginningButton = new Button("|<<");
        Button BACKToSceneButton = new Button("<|BACK");
        Button addHallButton = null;
        Button removeHallButton = null;
        ChoiceBox<String> filmHalls = new ChoiceBox<>();
        Button OKButton = new Button("OK");

        Slider volumeSlider = new Slider();

        String filmUrl = "./assets/trailers/" + film.getRelativePath();

        Media media = new Media(new File(filmUrl).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setLayoutX(50);
        mediaView.setLayoutY(100);

        mediaView.setFitWidth(700);
        mediaView.setFitHeight(650);

        volumeSlider.setValue(mediaPlayer.getVolume() * 60);

        playStopButton.setLayoutX(767);
        playStopButton.setLayoutY(150);
        playStopButton.setFont(Font.font("Verdana", 14));

        backButton.setLayoutX(767);
        backButton.setLayoutY(190);
        backButton.setFont(Font.font("Verdana", 14));

        forwardButton.setLayoutX(767);
        forwardButton.setLayoutY(230);
        forwardButton.setFont(Font.font("Verdana", 14));

        backToBeginningButton.setLayoutX(767);
        backToBeginningButton.setLayoutY(270);
        backToBeginningButton.setFont(Font.font("Verdana", 14));

        BACKToSceneButton.setLayoutX(190);
        BACKToSceneButton.setLayoutY(515);
        BACKToSceneButton.setFont(Font.font("Verdana", 14));


        filmHalls.setLayoutX(485);
        filmHalls.setLayoutY(516);

        OKButton.setLayoutX(645);
        OKButton.setLayoutY(515);
        OKButton.setFont(Font.font("Verdana", 14));

        volumeSlider.setLayoutX(787);
        volumeSlider.setLayoutY(320);
        volumeSlider.setOrientation(Orientation.VERTICAL);

        for(int i = 0; i < film.getFilmsHalls().size(); i++)
        {
            filmHalls.getItems().add(film.getFilmsHalls().get(i).getHallName());
        }

        if(filmHalls.getItems().size() != 0)
        {
            filmHalls.setValue(filmHalls.getItems().get(0));
        }


        if(user.getIsAdmin())
        {
            addHallButton = new Button("Add Hall");
            addHallButton.setLayoutX(280);
            addHallButton.setLayoutY(515);
            addHallButton.setFont(Font.font("Verdana", 14));

            removeHallButton = new Button("Remove Hall");
            removeHallButton.setLayoutX(370);
            removeHallButton.setLayoutY(515);
            removeHallButton.setFont(Font.font("Verdana", 14));
        }


        if(user.getIsAdmin())
        {
            root.getChildren().addAll(text, playStopButton, backButton, forwardButton, backToBeginningButton, BACKToSceneButton, addHallButton, removeHallButton,
                    filmHalls, OKButton, mediaView, volumeSlider);
        }

        else
        {
            filmHalls.setLayoutX(290);
            filmHalls.setLayoutY(515);
            OKButton.setLayoutX(455);
            OKButton.setLayoutY(515);
            root.getChildren().addAll(text, playStopButton, backButton, forwardButton, backToBeginningButton, BACKToSceneButton,
                    filmHalls, OKButton, mediaView, volumeSlider);
        }

        if(user.getIsAdmin())
        {
            assert addHallButton != null;
            addHallButton.setOnAction(e ->
            {
                mediaPlayer.stop();
                try {
                    stage.setScene(AddHallWindow.addHallWindowBox(stage, cinemaSystem, film, user, bufferedWriter));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });
        }


        if(user.getIsAdmin())
        {
            assert removeHallButton != null;
            removeHallButton.setOnAction(e ->
            {
                mediaPlayer.stop();
                try {
                    stage.setScene(RemoveHallWindow.removeHallWindowBox(stage, cinemaSystem, film, user, filmHalls, bufferedWriter));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }


        playStopButton.setOnAction(e ->
            {

                if(playStopButton.getText().equals("|>"))
                {
                    playStopButton.setText("||");
                    mediaPlayer.play();
                }

                else
                {
                    playStopButton.setText("|>");
                    mediaPlayer.pause();
                }
            }
        );


        backButton.setOnAction(e ->
            {
                mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(-5)));

            }
        );


        forwardButton.setOnAction(e ->
            {
                mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(5)));
            }
        );


        backToBeginningButton.setOnAction(e ->
            {
                mediaPlayer.stop();
                mediaPlayer.play();
            }
        );


        OKButton.setOnAction(e ->
        {
            mediaPlayer.stop();
            String temp = filmHalls.getValue();
            Hall hall = cinemaSystem.obtainHall(temp, film);

            if(hall != null)
            {
                try {
                    stage.setScene(HallWindow.hallWindowBox(stage, cinemaSystem, film, user, hall, bufferedWriter));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });


        volumeSlider.valueProperty().addListener(new InvalidationListener()
        {
            @Override
            public void invalidated(Observable observable)
            {
                mediaPlayer.setVolume(volumeSlider.getValue() / 100);
            }
        });


        BACKToSceneButton.setOnAction(e ->
        {
            mediaPlayer.stop();
            try {
                stage.setScene(Welcome.welcomeBox(stage, cinemaSystem, user, bufferedWriter));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        return scene;
    }
}
