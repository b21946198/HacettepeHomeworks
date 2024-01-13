import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application
{
    static CinemaSystem cinemaSystem;
    static BufferedWriter bufferedWriter;
    public static void main(String[] args) throws IOException
    {
        Constants.prepareConstants("./assets/data/properties.dat");                                             // read necessary data from properties file
        ArrayList<ArrayList<String>> data = Initiator.initializeDatabase("./assets/data/backup.dat");           // and then initialize them
        cinemaSystem = new CinemaSystem(new Database(data));                                                              // create a CinemaSystem
        launch(args);                                                                                                     // run the GUI
        bufferedWriter.close();
    }


    @Override
    public void start(Stage stage) throws IOException
    {
        bufferedWriter = new BufferedWriter(new FileWriter("./assets/data/backup.dat", true));
        stage.setTitle(Constants.TITLE);
        File file = new File("./assets/icons/logo.png");                                                        // set the logo
        Image icon = new Image(file.toURI().toString());
        stage.getIcons().add(icon);
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setScene(Login.loginBox(stage, cinemaSystem, bufferedWriter));
        stage.show();
    }
}
