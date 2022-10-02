package io.github.sibir007.cloud2.client.user;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserClient extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        stage = fxmlLoder("fxml/stage").load();
        root = fxmlLoder("fxml/root").load();
        Scene scene = new Scene(root);

    }

    private FXMLLoader fxmlLoder(String s) {
        return new FXMLLoader(Application.class.getResource(s + ".fxml"));
    }
}
