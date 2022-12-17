package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }
    public void login() throws IOException {
        //-----------
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        primaryStage.setScene(new Scene(root));

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //
    }
    public void Signup () throws IOException {
        //-----------
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Sign.fxml"));
        primaryStage.setScene(new Scene(root));

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });


        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //
    }
    public void Train () throws IOException {
        //-----------
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("HomeT.fxml"));
        primaryStage.setScene(new Scene(root));

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });


        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        //
    }




    public static void main(String[] args) {

        launch(args);
    }
}
