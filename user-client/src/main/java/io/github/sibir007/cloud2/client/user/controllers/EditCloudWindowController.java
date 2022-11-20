package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.Cloud;
import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EditCloudWindowController {
    @FXML
    private Stage editCloudWindow;
    @FXML
    private TextField protocolTextField;
    @FXML
    private TextField hostTextField;
    @FXML
    private TextField portTextField;
    @FXML
    private TextField fileTextField;

    private CloudsSystem model;
    private Cloud currentCloud;

    public EditCloudWindowController(CloudsSystem cloudsSystem) {
        model = cloudsSystem;
    }


    public void editCLoudButtonAction(ActionEvent actionEvent) {
        model.editCloud(currentCloud,
                protocolTextField.getText(),
                hostTextField.getText(),
                Integer.parseInt(portTextField.getText()),
                fileTextField.getText()
        );
        clearTextFields();
        editCloudWindow.hide();
    }

    public void chancelButtonAction(ActionEvent actionEvent) {
        clearTextFields();
        editCloudWindow.hide();
    }

    protected void setCurrentCloud(Cloud cloud) {
        currentCloud = cloud;
        fillTextFieldsCloudValues();
    }

    private void fillTextFieldsCloudValues() {
        protocolTextField.setText(currentCloud.getProtocol());
        hostTextField.setText(currentCloud.getHost());
        portTextField.setText(String.valueOf(currentCloud.getPort()));
        fileTextField.setText(currentCloud.getFile());

    }
    private void clearTextFields() {
        protocolTextField.setText("");
        hostTextField.setText("");
        portTextField.setText("");
        fileTextField.setText("");

    }


}
