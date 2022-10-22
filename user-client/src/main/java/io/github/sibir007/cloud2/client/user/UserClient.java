package io.github.sibir007.cloud2.client.user;

import io.github.sibir007.cloud2.client.user.dependencyinjection.DependencyInjection;
import io.github.sibir007.cloud2.client.user.model.Cloud;
import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import io.github.sibir007.cloud2.client.user.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.MalformedURLException;

public class UserClient extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = DependencyInjection.load("/fxml/mainView.fxml");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        initModel();
        stage.show();

    }

    private void initModel() throws MalformedURLException {
        CloudsSystem cloudsSystem = Model.getModel();
        Cloud cloud = cloudsSystem.addCloud("http", "yandex.ru", 80,"index.html");
        cloud.addCloudAccount("dima", "password");
        cloud.addCloudAccount("vova", "password");
        cloud.addCloudAccount("sasha", "password");
        cloud = cloudsSystem.addCloud("http", "google", 80, "index.html");
        cloud.addCloudAccount("dima", "password");
        cloud.addCloudAccount("vova", "password");
        cloud.addCloudAccount("sasha", "password");
        cloud = cloudsSystem.addCloud("http", "yandex.ru", 80, "index.html");
        cloud.addCloudAccount("dima", "password");
        cloud.addCloudAccount("vova", "password");
        cloud.addCloudAccount("sasha", "password");
        cloud = cloudsSystem.addCloud("http", "yandex.ru", 80, "index.html");
        cloud.addCloudAccount("dima", "password");
        cloud.addCloudAccount("vova", "password");
        cloud.addCloudAccount("sasha", "password");
    }



}
