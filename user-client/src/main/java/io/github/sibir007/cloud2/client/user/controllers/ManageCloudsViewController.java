package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.model.Cloud;
import io.github.sibir007.cloud2.client.user.model.CloudAccount;
import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ManageCloudsViewController {
    //manageCloudsTableView
    @FXML
    private VBox manageCloudsTableView;
    @FXML
    private Button addCloudButton;
    @FXML
    private Button editCloudButton;
    @FXML
    private Button dellCloudButton;
    @FXML
    private Button addAccountButton;
    @FXML
    private Button dellAccountButton;
    @FXML
    private Button editAccountButton;
    @FXML
    private TableView<Cloud> cloudsTable;

    //manageCloudView
    @FXML
    private VBox cloudView;
    @FXML
    private Label hostLabel;
    @FXML
    private Label portLabel;
    @FXML
    private Label protocolLabel;
    @FXML
    private TableView<CloudAccount> cloudAccountsTable;




    private final CloudsSystem model;

    public ManageCloudsViewController(CloudsSystem cloudsSystem) {
        model = cloudsSystem;
    }

    public void initialize() {
        initCloudsTable();
        initCloudView();
        initButtons();
    }

    private void initButtons() {
        editCloudButton.disableProperty().bind(
                cloudsTable.getSelectionModel().selectedItemProperty().isNull());
        dellCloudButton.disableProperty().bind(
                cloudsTable.getSelectionModel().selectedItemProperty().isNull()
        );
        addAccountButton.disableProperty().bind(
                cloudView.disableProperty()
        );
        dellAccountButton.disableProperty().bind(
                cloudAccountsTable.getSelectionModel().selectedItemProperty().isNull()
        );
        editAccountButton.disableProperty().bind(
                cloudAccountsTable.getSelectionModel().selectedItemProperty().isNull()
        );


    }


    private void initCloudsTable() {
        this.cloudsTable.setItems(model.getClouds());
        TableColumn<Cloud, String> protocolTableColumn = new TableColumn<>("protocol");
        protocolTableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getProtocol()));
        TableColumn<Cloud, String> hostTableColumn = new TableColumn<>("host");
        hostTableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getHost()));
        TableColumn<Cloud, String> portTableColumn = new TableColumn<>("port");
        portTableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(String.valueOf(param.getValue().getPort())));
        this.cloudsTable.getColumns().addAll(protocolTableColumn, hostTableColumn, portTableColumn);

    }

    private void initCloudView() {
        cloudView.disableProperty().bind(
                cloudsTable.getSelectionModel().selectedItemProperty().isNull()
        );

        cloudsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldVal, newVal) -> {
                    hostLabel.setText(newVal.getHost());
                    portLabel.setText(String.valueOf(newVal.getPort()));
                    protocolLabel.setText(newVal.getProtocol());
                    cloudAccountsTable.setItems(newVal.getCloudAccounts());
                }
        );
        TableColumn<CloudAccount, String> loginTableColumn = new TableColumn<>("login");
        TableColumn<CloudAccount, String> passwordTableColumn = new TableColumn<>("pass");
        TableColumn<CloudAccount, String> emailTableColumn = new TableColumn<>("email");
        loginTableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getLogin()));
        passwordTableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPassword()));
        emailTableColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getEmail()));
        cloudAccountsTable.getColumns().addAll(loginTableColumn, passwordTableColumn, emailTableColumn);
    }

}
