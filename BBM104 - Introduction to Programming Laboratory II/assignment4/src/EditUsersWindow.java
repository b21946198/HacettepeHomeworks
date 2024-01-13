import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EditUsersWindow
{
    public static Scene editUsersBox(Stage stage, CinemaSystem cinemaSystem, User user, BufferedWriter bufferedWriter) throws IOException
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ORANGE);

        stage.setHeight(470);

        TableView<User> userTable = new TableView<>();
        userTable.setLayoutX(40);
        userTable.setLayoutY(30);
        userTable.setPrefSize(520, 300);

        TableColumn<User, String> nameColumn = new TableColumn<>("Username");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, Boolean> clubMemberColumn = new TableColumn<>("Club Member");
        clubMemberColumn.setMinWidth(110);
        clubMemberColumn.setCellValueFactory(new PropertyValueFactory<>("isClubMember"));

        TableColumn<User, Boolean> adminColumn = new TableColumn<>("Admin");
        adminColumn.setMinWidth(50);
        adminColumn.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));


        userTable.setItems(getUser(cinemaSystem, user));
        userTable.getColumns().addAll(nameColumn, clubMemberColumn, adminColumn);


        Button backButton = new Button("<|Back");
        backButton.setLayoutX(40);
        backButton.setLayoutY(375);
        backButton.setMinSize(75, 25);
        backButton.setFont(Font.font("Verdana", 14));


        Button clubMemberButton = new Button("Promote/Demote Club Member");
        clubMemberButton.setLayoutX(125);
        clubMemberButton.setLayoutY(375);
        clubMemberButton.setMinSize(75, 25);
        clubMemberButton.setFont(Font.font("Verdana", 14));


        Button adminButton = new Button("Promote/Demote Admin");
        adminButton.setLayoutX(375);
        adminButton.setLayoutY(375);
        adminButton.setMinSize(75, 25);
        adminButton.setFont(Font.font("Verdana", 14));

        ArrayList<User> tempList = new ArrayList<>();

        for(User tempUser : cinemaSystem.getDatabase().getUsers())
        {
            if(tempUser.getUsername().equals(user.getUsername()))
                continue;

            tempList.add(tempUser);
        }

        root.getChildren().addAll(userTable, backButton, clubMemberButton, adminButton);


        backButton.setOnAction(e ->
        {
            try {
                stage.setScene(Welcome.welcomeBox(stage, cinemaSystem, user, bufferedWriter));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        clubMemberButton.setOnAction(e ->
        {
            User selectedItem = userTable.getSelectionModel().getSelectedItem();

            int idx = 0;

            for(; idx < tempList.size(); idx++)
            {
                if(selectedItem == tempList.get(idx))
                    break;
            }

            if(selectedItem.getIsClubMember())
            {
                selectedItem.setIsClubMember(false);
                userTable.getItems().set(idx, selectedItem);
            }

            else
            {
                selectedItem.setIsClubMember(true);
                userTable.getItems().set(idx, selectedItem);
            }

        });


        adminButton.setOnAction(e ->
        {
            User selectedItem = userTable.getSelectionModel().getSelectedItem();

            int idx = 0;

            for(; idx < tempList.size(); idx++)
            {
                if(selectedItem == tempList.get(idx))
                    break;
            }

            if(selectedItem.getIsAdmin())
            {
                selectedItem.setIsAdmin(false);
                userTable.getItems().set(idx, selectedItem);
            }

            else
            {
                selectedItem.setIsAdmin(true);
                userTable.getItems().set(idx, selectedItem);
            }

        });

        return scene;
    }


    public static ObservableList<User> getUser(CinemaSystem cinemaSystem, User user)
    {
        ObservableList<User> users = FXCollections.observableArrayList();

        for(User tempUser : cinemaSystem.getDatabase().getUsers())
        {
            if(tempUser.getUsername().equals(user.getUsername()))
                continue;

            users.add(tempUser);
        }

        return users;
    }
}
