package io.github.sibir007.cloud2.client.user;

import io.github.sibir007.cloud2.client.user.dependencyinjection.DependencyInjection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserClient extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = DependencyInjection.load("/fxml/mainView.fxml");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private FXMLLoader fxmlLoder(String s) {
        return new FXMLLoader(Application.class.getResource(s + ".fxml"));
    }
}
