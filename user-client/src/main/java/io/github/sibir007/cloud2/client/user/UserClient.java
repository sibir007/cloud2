package io.github.sibir007.cloud2.client.user;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserClient extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //        stage = fxmlLoder("fxml/stage").load();
        FXMLLoader loader = new FXMLLoader(UserClient.class.getResource("fxml/mainView.fxml"));
        Parent root = loader.load();
//        root = fxmlLoder("fxml/mainViewRoot").load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private FXMLLoader fxmlLoder(String s) {
        return new FXMLLoader(Application.class.getResource(s + ".fxml"));
    }
}
