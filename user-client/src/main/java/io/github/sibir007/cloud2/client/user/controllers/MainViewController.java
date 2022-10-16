package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.dependencyinjection.DependencyInjection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainViewController {

    @FXML
    private HBox viewsControls;
    @FXML
    private Pane views;
    private Pane visibleView;

    public void initialize() throws IOException {
        visibleView = addView("/fxml/manageSystemView.fxml");
        visibleView.setVisible(true);
        addView("/fxml/cloudsView.fxml");

    }

    private Pane addView(String location) throws IOException {
        Parent view = DependencyInjection.load(location);
        String buttonText = view.getId();
        Button viewButton =  new Button();
        viewButton.setOnAction(event -> {
            visibleView.setVisible(false);
            //TODO разобраться с типом
            visibleView = (Pane) view;
            visibleView.setVisible(true);
        });
        viewButton.setText(buttonText);
        views.getChildren().add(view);
        viewsControls.getChildren().add(viewButton);
        view.setVisible(false);
        return (Pane) view;
    }


    public void manageMainView(ActionEvent actionEvent) {
    }
}
