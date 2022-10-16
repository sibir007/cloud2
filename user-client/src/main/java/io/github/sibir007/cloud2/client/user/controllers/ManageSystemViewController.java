package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ManageSystemViewController {
    public HBox view;
    @FXML
    private HBox ManageSystem;
    @FXML
    private TableView cloudsTable;

    private CloudsSystem model;

    public ManageSystemViewController(CloudsSystem model){
        this.model = model;
    }

    @FXML
    private void initialize(){

    }

}
