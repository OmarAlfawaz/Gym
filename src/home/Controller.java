package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    @FXML
    public TextField passWord;
    @FXML
    public TextField username2;
    @FXML
    public TextField PassWord2;
    @FXML
    public Button signUpCheck;
    @FXML
    public RadioButton TraineeSelect;
    @FXML
    public RadioButton TrainerSelect;
    @FXML
    public Label nameUp;

    @FXML
    public Text xt;
    @FXML
    public Label stat;
    @FXML
    public TextField username;
    @FXML
    public Button btnSignup;
    public Label LabelSignIn;
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
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlSignout;

    private double x, y;
    String name;

    private String type;


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


    public void handleClicks(ActionEvent actionEvent) throws IOException, URISyntaxException, InterruptedException {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #02030A");
            pnlCustomer.toFront();
            pnlCustomer.setVisible(true);
        }
        if (actionEvent.getSource() == signUpCheck) {
            String to = null;
            if (TraineeSelect.isSelected()) {
                to = "trainee";
            } else if (TrainerSelect.isSelected()) {
                to = "trainer";
            }
            Acoount.Signup(username2.getText(), PassWord2.getText(), to);
            Main main = new Main();
            main.login();
        }
            if (actionEvent.getSource() == btnMenus) {
                pnlMenus.setStyle("-fx-background-color : #02030A");
                pnlMenus.toFront();
                pnlMenus.setVisible(true);
            }
            if (actionEvent.getSource() == btnSignup) {
                Stage stage = (Stage) btnSignup.getScene().getWindow();
                stage.close();
                Main main = new Main();
                main.Signup();


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
                try {
                    Stage stage = (Stage) btnSignin.getScene().getWindow();
                    //we will create a loop to check the API
                    System.out.println(username.getText());
                    if (username.getText().equals("") || passWord.getText().equals("")) {
                        //this.LabelSignIn.setText("Please fill in all the fields");
                    } else {
                        name = username.getText();
                        //nameUp = new Label(name);
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
                                stage.close();
                                //After we close the stage we go to main
                                Main main = new Main();
                                main.login();
                            } else if (type.equals("trainer")) {
                                stage.close();

                                //After we close the stage we go to main
                                Main main = new Main();
                                main.login();
                            }
                        } else {
                            LabelSignIn = new Label("Wrong name or password");
                            //this.LabelSignIn.setText("Wrong name or password");
                            //this.LabelSignIn.setTextFill(Color.TOMATO);
                            LabelSignIn.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
                        }
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
