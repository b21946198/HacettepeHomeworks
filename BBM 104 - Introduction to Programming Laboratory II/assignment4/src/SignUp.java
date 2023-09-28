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

public class SignUp
{
    public static Scene signUpBox(Stage stage, CinemaSystem cinemaSystem, BufferedWriter bufferedWriter) throws IOException
    {

        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        Text text = new Text(55, 45, "Welcome to the HUCS Cinema Reservation System!\n");
        text.setFont(Font.font("Verdana", 18));
        text.setFill(Color.BLACK);

        Text text2 = new Text(86, 65, "Fill the form below to create a new account.\n");
        text2.setFont(Font.font("Verdana", 18));
        text2.setFill(Color.BLACK);

        Text text3 = new Text(57, 85, "You can go to Login page by clicking LOGIN Button.");
        text3.setFont(Font.font("Verdana", 18));
        text3.setFill(Color.BLACK);

        Text text4 = new Text(150, 150, "Username:");
        text4.setFont(Font.font("Verdana", 18));
        text4.setFill(Color.BLACK);

        Text text5 = new Text(150, 190, "Password:");
        text5.setFont(Font.font("Verdana", 18));
        text5.setFill(Color.BLACK);

        Text text6 = new Text(150, 230, "Password:");
        text6.setFont(Font.font("Verdana", 18));
        text6.setFill(Color.BLACK);

        TextField usernameInput = new TextField();
        usernameInput.setLayoutX(260);
        usernameInput.setLayoutY(131);
        usernameInput.setFont(Font.font("Verdana", 14));

        PasswordField usernameInput2 = new PasswordField();
        usernameInput2.setLayoutX(260);
        usernameInput2.setLayoutY(171);
        usernameInput2.setFont(Font.font("Verdana", 14));

        PasswordField usernameInput3 = new PasswordField();
        usernameInput3.setLayoutX(260);
        usernameInput3.setLayoutY(211);
        usernameInput3.setFont(Font.font("Verdana", 14));

        Button button1 = new Button("LOGIN");
        button1.setLayoutX(150);
        button1.setLayoutY(270);
        button1.setMinSize(75, 25);
        button1.setFont(Font.font("Verdana", 14));


        Button button2 = new Button("SIGN UP");
        button2.setLayoutX(340);
        button2.setLayoutY(270);
        button2.setMinSize(75, 25);
        button2.setFont(Font.font("Verdana", 14));

        Text temp = new Text(120, 330, "");
        temp.setFont(Font.font("Verdana", 18));
        temp.setFill(Color.BLACK);

        root.getChildren().addAll(text, text2, text3, text4, text5, text6, usernameInput, usernameInput2, usernameInput3, button1, button2, temp);


        button1.setOnAction(e ->
                {
                    try {
                        stage.setScene(Login.loginBox(stage, cinemaSystem, bufferedWriter));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
        );

        button2.setOnAction(e ->
                {
                    String userInput = usernameInput.getText();
                    String passwordInput = usernameInput2.getText();
                    String passwordCorrection = usernameInput3.getText();

                    String musicFile = "./assets/effects/error.mp3";
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);

                    boolean flag = false;

                    for(User usr1 : cinemaSystem.getDatabase().getUsers())
                    {
                        if(userInput.equals(usr1.getUsername()))
                        {
                            flag = true;
                            break;
                        }
                    }
                    
                    if(flag)
                    {
                        mediaPlayer.play();
                        temp.setText("ERROR: This username already exists!");

                        usernameInput.clear();
                        usernameInput2.clear();
                        usernameInput3.clear();
                    }

                    else if(userInput.equals(""))
                    {
                        mediaPlayer.play();
                        temp.setText("ERROR: Username cannot be empty!");

                    }

                    else if(passwordInput.equals(""))
                    {
                        mediaPlayer.play();
                        temp.setText("ERROR: Password cannot be empty!");

                    }

                    else if(!passwordInput.equals(passwordCorrection))
                    {
                        mediaPlayer.play();
                        temp.setText("ERROR: Passwords do not match!");

                        usernameInput.clear();
                        usernameInput2.clear();
                        usernameInput3.clear();
                    }

                    else
                    {
                        cinemaSystem.addUser(userInput, passwordInput);
                        temp.setText("SUCCESS: You have successfully registered with your new credentials!");
                        try {
                            bufferedWriter.write("user\t" + userInput + "\t" + Constants.hashPassword(passwordInput) + "\t" + "false\tfalse\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        usernameInput.clear();
                        usernameInput2.clear();
                        usernameInput3.clear();
                    }
                }
        );

        return scene;
    }
}
