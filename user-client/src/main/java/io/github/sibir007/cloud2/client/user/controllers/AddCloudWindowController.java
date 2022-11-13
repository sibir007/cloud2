package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCloudWindowController {
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
    public void initialize(){
        addCloudWindow.setOnShowing(event -> {
            hostTextField.requestFocus();
        });
    }

    public void addCLoudButtonAction(ActionEvent actionEvent) {
        model.addCloud(hostTextField.getText());
        hostTextField.clear();
        hostTextField.getScene().getWindow().hide();


    }

    public void chancelButtonAction(ActionEvent actionEvent) {
        hostTextField.getScene().getWindow().hide();
    }


}
