package io.github.sibir007.cloud2.client.user.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MainViewController {
    @FXML
    private Node cloudsView;
    @FXML
    private Node manageSystevView;
    @FXML
    private Parent mainView;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private StackPane views;



    public void onMouseEntered(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
        System.out.println(mainView.getStyle());
        mainView.setStyle("-fx-background-color: #0000ff");
    }

    public void onMouseExited(MouseEvent mouseEvent) {
//        System.out.println(mouseEvent);
//        root.ge
    }

    public void selectManageSystem(ActionEvent actionEvent) {
        cloudsView.setVisible(false);
        manageSystevView.setVisible(true);
    }

    public void selectClouds(ActionEvent actionEvent) {
        cloudsView.setVisible(true);
        manageSystevView.setVisible(false);
    }

    @FXML
    private void initialize() {
        cloudsView.setVisible(false);
    }


}
