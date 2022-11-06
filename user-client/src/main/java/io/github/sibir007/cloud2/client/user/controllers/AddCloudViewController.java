package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCloudViewController {
    @FXML
    private TextField hostTextField;
    @FXML
    private TextField portTextField;
    @FXML
    private TextField protocolTextField;
    private CloudsSystem model;
    
    public AddCloudViewController(CloudsSystem cloudsSystem){
        model = cloudsSystem;
    }


    public void addCLoudButtonAction(ActionEvent actionEvent) {
    }

    public void chancelButtonAction(ActionEvent actionEvent) {
        hostTextField.getScene().getWindow().hide();
    }
}
