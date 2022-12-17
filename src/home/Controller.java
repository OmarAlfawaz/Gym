package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

public class Controller implements Initializable {
    public TextField passWord;
    public Label nameUp;
    public TextField username;
    @FXML
    private VBox pnItems;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Button btnSignin;

    @FXML
    private Button btnSignup;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;



    private double x, y;
    Main main = new Main();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                //pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #02030A");
            pnlCustomer.toFront();
            pnlCustomer.setVisible(true);
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #02030A");
            pnlMenus.toFront();
            pnlMenus.setVisible(true);
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if (actionEvent.getSource() == btnOrders) {
            pnlOrders.setStyle("-fx-background-color : #02030A");
            pnlOrders.toFront();
            pnlOrders.setVisible(true);
        }
        if (actionEvent.getSource() == btnSignout) {
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            stage.close();

        }
        if (actionEvent.getSource() == btnSignin) {
            Stage stage = (Stage) btnSignin.getScene().getWindow();
            //we will create a loop to check the API
            System.out.println(username.getText());
            if (username.getText().equals("") || passWord.getText().equals("")) {
                //this.LabelSignIn.setText("Please fill in all the fields");
            } else {
                String name = username.getText();
                String password = passWord.getText();
                String type = "";
                String path = "https://us-central1-swe206-221.cloudfunctions.net/app/SignIn?teamKey=51135203&username="
                        + URLEncoder.encode(name, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8");
                URL url = new URL(path);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                int status = con.getResponseCode();
                BufferedReader response = new BufferedReader(new InputStreamReader((con.getInputStream())));
                System.out.println(status);
                type = response.readLine();
                System.out.println(type);
                if (status == 200) {
                    if (type.equals("trainee")) {
                        Parent root = FXMLLoader.load(getClass().getResource("Main Screen.fxml"));
                        stage.close();
                        //After we close the stage we go to main
                        Main main = new Main();
                        main.login();
                    } else if (type.equals("trainer")) {
                        Parent root = FXMLLoader.load(getClass().getResource("Main Screen.fxml"));
                        stage.close();

                        //After we close the stage we go to main
                        main.login();
                    }
                } else {
                    // this.LabelSignIn.setText("Wrong name or password");
                }

            }
        }if (actionEvent.getSource() == btnSignup) {
            main.Signup();
        }
    }

    /*void SignUpUserClick (MouseEvent event) throws IOException, URISyntaxException, InterruptedException {
        if (UsernameContent2.getText().equals("") || PasswordContent2.getText().equals("")
                || (!TraineeSelect.isSelected() && !TrainerSelect.isSelected())) {
            this.LabelSignUp.setText("Please fill in all the fields");
        } else {
            String username = UsernameContent2.getText();
            String password = PasswordContent2.getText();
            String type = "";
            if (TraineeSelect.isSelected()) {
                type = "trainee";
            } else if (TrainerSelect.isSelected()) {
                type = "trainer";
            }
            var uri = new URI("https://us-central1-swe206-221.cloudfunctions.net/app/SignUp?teamKey=40495102");
            var message = """
                        {
                            "username": "%s",
                            "password": "%s",
                            "type": "%s"}
                        """;
            message = String.format(message, username, password, type);

            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(message))
                    .header("Content-type", "application/json").build();
            var response = client.send(request, HttpResponse.BodyHandlers.discarding());
            if (response.statusCode() == 201) {
                Parent root = FXMLLoader.load(getClass().getResource("Main Screen.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                this.LabelSignUp.setText("Username already exists");
            }
        }
    }


}
            else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Invalid Username/passWord");
                    alert.showAndWait();
                    }*/

}

