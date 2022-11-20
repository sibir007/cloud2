package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCloudAccountWindowController {
    @FXML
    private TextField emailTextField;
    @FXML
    private Stage addCloudAccountWindow;
    @FXML
    private Label hostLabel;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    private final CloudsSystem model;
    public AddCloudAccountWindowController(CloudsSystem cloudsSystem){
        model = cloudsSystem;
    }
    public void initialize(){
    }

    public void addCLoudAccountButtonAction(ActionEvent actionEvent) {
        model.addFtpCloud(hostLabel.getText());
        hostLabel.setText("");
        hostLabel.getScene().getWindow().hide();


    }

    public void chancelButtonAction(ActionEvent actionEvent) {
        hostLabel.getScene().getWindow().hide();
    }


}
