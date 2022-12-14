package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.dependencyinjection.DependencyInjection;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Pane views;
    @FXML
    private VBox manageCloudsTableCloudView;
    @FXML
    private HBox cloudsView;
    @FXML
    private HBox viewsControls;
//    @FXML
//    private ManageCloudsTableViewController manageCloudsTableViewController;
    @FXML
    private CloudsViewController cloudsViewController;

    public void initialize() throws IOException {
        System.out.println(cloudsViewController);
//        manageCloudsTableViewController.initialize();
//        cloudsViewController.initialize();
        initControls();
//        manageCloudsTableCloudView.setVisible(false);
//        cloudsView.setVisible(true);
    }

    private void initControls() {
        ObservableList<Node> nodes = views.getChildren();
        for (Node node: nodes){
            Button button = new Button();
            button.setText(node.getId());
            button.setOnAction(event -> {
                views.getChildren().stream().forEach(node1 -> node1.setVisible(false));
                node.setVisible(true);
            }
            );
            viewsControls.getChildren().add(button);
//            node.getProperties().putIfAbsent("control", node);
        }
        views.getChildren().stream().forEach(node -> node.setVisible(false));
        manageCloudsTableCloudView.setVisible(true);

    }

}
