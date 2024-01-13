import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class HallWindow
{
    public static Scene hallWindowBox(Stage stage, CinemaSystem cinemaSystem, Film film, User user, Hall hall, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        stage.setWidth(700);
        stage.setHeight(820);

        Text text = new Text(120, 75, film.getFilmName() + " (" + film.getDuration() + " Minutes) Hall: " + hall.getHallName());
        text.setFont(Font.font("Verdana", 22));
        text.setFill(Color.BLACK);

        Button backButton = new Button("<| BACK");
        backButton.setLayoutX(100);
        backButton.setLayoutY(720);
        backButton.setFont(Font.font("Verdana", 14));


        TilePane tilePane = new TilePane();
        tilePane.setLayoutX(100);
        tilePane.setLayoutY(100);

        tilePane.setPrefRows(hall.getNumberOfRows());
        tilePane.setPrefColumns(hall.getNumberOfColumns());

        for(int i = 0; i < hall.getNumberOfColumns(); i++)
        {
            for(int j = 0; j < hall.getNumberOfRows(); j++)
            {
                tilePane.getChildren().add(createBoxes());
            }
        }

        Text temp = new Text(240, 740, "");
        temp.setFont(Font.font("Verdana", 20));
        temp.setFill(Color.BLACK);

        Text temp2 = new Text(100, 780, "");
        temp2.setFont(Font.font("Verdana", 20));
        temp2.setFill(Color.BLACK);


        File file = new File("./assets/icons/reserved_seat.png");
        Image emptySeatImage = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(emptySeatImage);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        imageView.setSmooth(true);
        imageView.setCache(true);

        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        for(User tempUser : cinemaSystem.getDatabase().getUsers())
        {
            choiceBox.getItems().add(tempUser.getUsername());
        }


        if(user.getIsAdmin())
        {
            choiceBox.setValue(cinemaSystem.getDatabase().getUsers().get(0).getUsername());
            choiceBox.setLayoutX(460);
            choiceBox.setLayoutY(720);

            tilePane.setOnMouseEntered(e ->
            {
                temp.setText("Not bought yet!");
                temp2.setText("");
            });

            tilePane.setOnMouseExited(e ->
            {
                temp.setText("");
                temp2.setText("");
            });

            tilePane.setOnMouseClicked(e ->
            {
                String name = choiceBox.getValue();

                int price;

                if(cinemaSystem.obtainUser(name).getIsClubMember())
                {
                    price = hall.getPricePerSeat();
                    price -= hall.getPricePerSeat() * Constants.DISCOUNT_PERCENTAGE / 100;
                }
                else
                {
                    price = hall.getPricePerSeat();
                }

                temp2.setText("Seat at 4-4 is bought for " + name + " for " + price + " TL successfully!");

                try {
                    bufferedWriter.write("seat\t" + film.getFilmName() + "\t" + hall.getHallName() + "\t" + "4\t4\t" + name + "\t" + price + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });

            root.getChildren().addAll(text, backButton, tilePane, temp, choiceBox, temp2);
        }


        else
        {

            tilePane.setOnMouseEntered(e ->
            {
                temp.setText("Not bought yet!");
                temp2.setText("");
            });

            tilePane.setOnMouseExited(e ->
            {
                temp.setText("");
                temp2.setText("");
            });

            tilePane.setOnMouseClicked(e ->
            {
                String name = user.getUsername();

                int price;

                if(cinemaSystem.obtainUser(name).getIsClubMember())
                {
                    price = hall.getPricePerSeat();
                    price -= hall.getPricePerSeat() * Constants.DISCOUNT_PERCENTAGE / 100;
                }
                else
                {
                    price = hall.getPricePerSeat();
                }

                temp2.setText("Seat at 4-4 is bought for " + name + " for " + price + " TL successfully!");

                try {
                    bufferedWriter.write("seat\t" + film.getFilmName() + "\t" + hall.getHallName() + "\t" + "4\t4\t" + name + "\t" + price + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });


            root.getChildren().addAll(text, backButton, tilePane, temp, temp2);
        }


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


    public static VBox createBoxes()
    {
        File file = new File("./assets/icons/empty_seat.png");
        Image emptySeatImage = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(emptySeatImage);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        imageView.setSmooth(true);
        imageView.setCache(true);


        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);

        return pageBox;
    }
}
