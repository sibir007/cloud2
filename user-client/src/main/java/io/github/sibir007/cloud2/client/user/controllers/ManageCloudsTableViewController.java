package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.Cloud;
import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class ManageCloudsTableViewController {
    @FXML
    private Button newCloudButton;
    @FXML
    private Button editCloudButton;
    @FXML
    private Button removeCloudButton;
    @FXML
    private VBox manageCloudsView;
    @FXML
    private HBox controls;
    @FXML
    private TableView<Cloud> cloudsTable;

    private CloudsSystem model;

    public ManageCloudsTableViewController(CloudsSystem model){
        this.model = model;
    }



    public void initialize(){
        this.cloudsTable.setItems(model.getClouds());
        TableColumn<Cloud, String> protocolTableColumn = new TableColumn<Cloud, String>("protocol");
        protocolTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cloud, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cloud, String> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getProtocol());
            }
        });
        TableColumn<Cloud, String> hostTableColumn = new TableColumn<Cloud, String>("host");
        hostTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cloud, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cloud, String> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getHost());
            }
        });
        TableColumn<Cloud, String> portTableColumn = new TableColumn<>("port");
        portTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Cloud, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Cloud, String> param) {
                return new ReadOnlyObjectWrapper<>(String.valueOf(param.getValue().getPort()));
            }
        });
        this.cloudsTable.getColumns().addAll(protocolTableColumn, hostTableColumn, portTableColumn);
    }
}
