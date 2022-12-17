package home;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Acoount {


    public static void Signup(String username2, String PassWord2, String type) throws URISyntaxException, IOException, InterruptedException {
        if (username2.equals("") || PassWord2.equals("")
                || type.equals("")) {
            //this.LabelSignUp.setText("Please fill in all the fields");
        } else {
            String username = username2;
            String password = PassWord2;
            var uri = new URI("https://us-central1-swe206-221.cloudfunctions.net/app/SignUp?teamKey=51135203");
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
            System.out.println(username2);
            System.out.println(response.statusCode());
        }
    }
}
