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
import java.util.ArrayList;

public class Welcome
{

    public static Scene welcomeBox(Stage stage, CinemaSystem cinemaSystem, User user, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        stage.setWidth(600);
        stage.setHeight(400);

        Text text = new Text(80, 45, "");
        text.setFont(Font.font("Verdana", 18));
        text.setFill(Color.BLACK);

        Text text2 = new Text(70, 65, "");
        text2.setFont(Font.font("Verdana", 18));
        text2.setFill(Color.BLACK);

        Button button2 = null;
        Button button3 = null;
        Button button4 = null;

        if(user.getIsAdmin() && user.getIsClubMember())
        {
            text.setText("Welcome " + user.getUsername() + " (Admin - Club Member)!\n");
            text2.setText("You can either select film below or do edits.\n");

            button2 = new Button("Add Film");
            button2.setLayoutX(100);
            button2.setLayoutY(125);
            button2.setFont(Font.font("Verdana", 14));

            button3 = new Button("Remove Film");
            button3.setLayoutX(200);
            button3.setLayoutY(125);
            button3.setFont(Font.font("Verdana", 14));

            button4 = new Button("Edit Users");
            button4.setLayoutX(325);
            button4.setLayoutY(125);
            button4.setFont(Font.font("Verdana", 14));

        }

        else if(user.getIsAdmin())
        {
            text.setText("Welcome " + user.getUsername() + " (Admin)!\n");
            text2.setText("You can either select film below or do edits.\n");

            button2 = new Button("Add Film");
            button2.setLayoutX(100);
            button2.setLayoutY(125);
            button2.setFont(Font.font("Verdana", 14));

            button3 = new Button("Remove Film");
            button3.setLayoutX(200);
            button3.setLayoutY(125);
            button3.setFont(Font.font("Verdana", 14));

            button4 = new Button("Edit Users");
            button4.setLayoutX(325);
            button4.setLayoutY(125);
            button4.setFont(Font.font("Verdana", 14));

        }

        else if(user.getIsClubMember())
        {
            text.setText("Welcome " + user.getUsername() + " (Club Member)!\n");
            text2.setText("Select a film then click OK to continue");

        }

        else
        {
            text.setText("Welcome " + user.getUsername() + "!\n");
            text2.setText("Select a film then click OK to continue");
        }

        Button button = new Button("OK");
        button.setLayoutX(450);
        button.setLayoutY(85);
        button.setFont(Font.font("Verdana", 14));

        Button button5 = new Button("LOG OUT");
        button5.setLayoutX(410);
        button5.setLayoutY(165);
        button5.setFont(Font.font("Verdana", 14));

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setLayoutX(70);
        choiceBox.setLayoutY(85);
        choiceBox.setMinSize(370, 22);

        ArrayList<Film> movies = cinemaSystem.getDatabase().getFilms();

        if(movies.size() != 0)
            for(Film film : movies)
                choiceBox.getItems().add(film.getFilmName());

        if(movies.size() != 0)
            choiceBox.setValue(movies.get(0).getFilmName());



        if(button2 != null)
        {
            root.getChildren().addAll(text, text2, button, button2, button3, button4, button5, choiceBox);
        }

        else
        {
            root.getChildren().addAll(text, text2, button, button5, choiceBox);
        }


        button.setOnAction(e ->
            {
                String filmChoice = choiceBox.getValue();
                Film film = cinemaSystem.obtainFilm(filmChoice);

                if(film != null)
                {
                    try
                    {
                        stage.setScene(FilmWindow.filmWindowBox(stage, cinemaSystem, film, user, bufferedWriter));
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }

            }
        );



        if(button2 != null)
        {
            button2.setOnAction(e ->
                {
                    try {
                        stage.setScene(AddFilmWindow.addFilmBox(stage, cinemaSystem, user, choiceBox, bufferedWriter));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            );


            button3.setOnAction(e ->
            {
                try {
                    stage.setScene(RemoveFilmWindow.removeFilmBox(stage, cinemaSystem, user, choiceBox, bufferedWriter));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });


            button4.setOnAction(e ->
            {
                try {
                    stage.setScene(EditUsersWindow.editUsersBox(stage, cinemaSystem, user, bufferedWriter));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }


        button5.setOnAction(e ->
                {

                    try {
                        stage.setScene(Login.loginBox(stage, cinemaSystem, bufferedWriter));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        );

        return scene;
    }
}
