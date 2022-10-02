package io.github.sibir007.cloud2.client.user.controllers;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

public class MainViewRootController {
    public Parent root;

    public void onMouseEntered(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
        System.out.println(root.getStyle());
        root.setStyle("-fx-background-color: #0000ff");
    }

    public void onMouseExited(MouseEvent mouseEvent) {
//        System.out.println(mouseEvent);
//        root.ge
    }

    public void selectManageSystem(ActionEvent actionEvent) {
    }

    public void selectClouds(ActionEvent actionEvent) {
    }
}
