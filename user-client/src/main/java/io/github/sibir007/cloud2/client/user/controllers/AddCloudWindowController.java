package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddCloudWindowController {
    private static Logger logger = LogManager.getLogger();

    @FXML
    private Stage addCloudWindow;
    @FXML
    private TextField hostTextField;
    @FXML
    private TextField portTextField;
    @FXML
    private TextField protocolTextField;
    private final CloudsSystem model;
    public AddCloudWindowController(CloudsSystem cloudsSystem){
        model = cloudsSystem;
    }


    public void addCLoudButtonAction(ActionEvent actionEvent) {
        logger.trace(Thread.currentThread().getName());
        model.addFtpCloud(hostTextField.getText());
        hostTextField.clear();
        hostTextField.getScene().getWindow().hide();
    }

    public void chancelButtonAction(ActionEvent actionEvent) {
        hostTextField.getScene().getWindow().hide();
    }


    public void onShowing(WindowEvent windowEvent) {
        hostTextField.requestFocus();
    }
}
