module user.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;

    opens io.github.sibir007.cloud2.client.user.controllers to javafx.fxml;
    exports io.github.sibir007.cloud2.client.user;
}