import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
import java.util.ArrayList;

public class Login
{
    public static Scene loginBox(Stage stage, CinemaSystem cinemaSystem, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        Text text = new Text(55, 45, "Welcome to the HUCS Cinema Reservation System!\n");
        text.setFont(Font.font("Verdana", 18));
        text.setFill(Color.BLACK);

        Text text2 = new Text(50, 65, "Please enter your credentials below and click LOGIN.\n");
        text2.setFont(Font.font("Verdana", 18));
        text2.setFill(Color.BLACK);

        Text text3 = new Text(37, 85, "You can create a new account by clicking SIGN UP button.");
        text3.setFont(Font.font("Verdana", 18));
        text3.setFill(Color.BLACK);

        Text text4 = new Text(150, 150, "Username:");
        text4.setFont(Font.font("Verdana", 18));
        text4.setFill(Color.BLACK);

        Text text5 = new Text(150, 190, "Password:");
        text5.setFont(Font.font("Verdana", 18));
        text5.setFill(Color.BLACK);

        Button button1 = new Button("SIGN UP");
        button1.setLayoutX(150);
        button1.setLayoutY(230);
        button1.setMinSize(75, 25);
        button1.setFont(Font.font("Verdana", 14));


        Button button2 = new Button("LOGIN");
        button2.setLayoutX(340);
        button2.setLayoutY(230);
        button2.setMinSize(75, 25);
        button2.setFont(Font.font("Verdana", 14));

        TextField usernameInput = new TextField();
        usernameInput.setFont(Font.font("Verdana", 14));
        usernameInput.setLayoutX(260);
        usernameInput.setLayoutY(131);

        PasswordField usernameInput2 = new PasswordField();
        usernameInput2.setLayoutX(260);
        usernameInput2.setLayoutY(171);
        usernameInput2.setFont(Font.font("Verdana", 14));

        Text temp = new Text(120, 290, "");
        temp.setFont(Font.font("Verdana", 18));
        temp.setFill(Color.BLACK);

        root.getChildren().addAll(text, text2, text3, button1, button2, usernameInput, usernameInput2, text4, text5, temp);

        ArrayList<Integer> tempCounter = new ArrayList<>();

        button1.setOnAction(e ->
                {
                    try {
                        stage.setScene(SignUp.signUpBox(stage, cinemaSystem, bufferedWriter));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        );

        button2.setOnAction(e ->
                {
                    int counter = 0;

                    String userInput = usernameInput.getText();
                    String passwordInput = usernameInput2.getText();

                    String musicFile = "./assets/effects/error.mp3";                                        // error sound from .mp3 file
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);

                    boolean flag = false;
                    User user = null;

                    for(User usr1 : cinemaSystem.getDatabase().getUsers())
                    {
                        String uname = usr1.getUsername();
                        String pass = usr1.getPassword();
                        String hashed = Constants.hashPassword(passwordInput);

                        if(userInput.equals(uname) && hashed.equals(pass))
                        {
                            flag = true;
                            user = cinemaSystem.obtainUser(uname);
                            break;
                        }
                    }


                    if(tempCounter.size() == Constants.MAXIMUM_ERROR_WITHOUT_BLOCKED)
                    {
                        temp.setText("ERROR: Please wait for " + Constants.BLOCK_TIME + " seconds to make a new operation!");
                        mediaPlayer.play();
                        tempCounter.clear();
                        usernameInput2.clear();
                    }

                    else if(flag)
                    {
                        try {
                            stage.setScene(Welcome.welcomeBox(stage, cinemaSystem, user, bufferedWriter));                              // logged in
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    else if(userInput.equals(""))
                    {
                        mediaPlayer.play();
                        tempCounter.add(++counter);

                        if(tempCounter.size() == Constants.MAXIMUM_ERROR_WITHOUT_BLOCKED)
                        {
                            temp.setText("ERROR: Please wait for " + Constants.BLOCK_TIME + " seconds to make a new operation!");
                        }

                        else
                        {
                            temp.setText("ERROR: Username cannot be empty!");
                        }

                    }

                    else if(passwordInput.equals(""))
                    {
                        mediaPlayer.play();
                        tempCounter.add(++counter);

                        if(tempCounter.size() == Constants.MAXIMUM_ERROR_WITHOUT_BLOCKED)
                        {
                            temp.setText("ERROR: Please wait for " + Constants.BLOCK_TIME + " seconds to make a new operation!");
                        }

                        else
                        {
                            temp.setText("ERROR: Password cannot be empty!");
                        }
                    }

                    else                                                                                                // get error more than 5 (for ex.) times
                    {
                        mediaPlayer.play();
                        tempCounter.add(++counter);

                        if(tempCounter.size() == Constants.MAXIMUM_ERROR_WITHOUT_BLOCKED)
                        {
                            temp.setText("ERROR: Please wait for " + Constants.BLOCK_TIME + " seconds to make a new operation!");
                            usernameInput2.clear();
                        }

                        else
                        {
                            temp.setText("ERROR: There is no such a credential!");
                            usernameInput2.clear();
                        }

                    }

                }
        );

        return scene;
    }
}
