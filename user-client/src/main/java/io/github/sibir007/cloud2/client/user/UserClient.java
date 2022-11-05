package io.github.sibir007.cloud2.client.user;

import io.github.sibir007.cloud2.client.user.dependencyinjection.DependencyInjection;
import io.github.sibir007.cloud2.client.user.model.Cloud;
import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import io.github.sibir007.cloud2.client.user.model.Model;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;

public class UserClient extends Application {
    private static Logger logger = LogManager.getLogger();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = DependencyInjection.load("/fxml/mainView.fxml");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        logger.debug("debug logger");
        logger.error("error logger");
        logger.fatal("fatal logger");
        logger.warn("warn logger");
        logger.info("info logger");
        logger.trace("trace logger");

    }

}
