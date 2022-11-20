package io.github.sibir007.cloud2.client.user.controllers;

import io.github.sibir007.cloud2.client.user.dependencyinjection.DependencyInjection;
import io.github.sibir007.cloud2.client.user.model.Cloud;
import io.github.sibir007.cloud2.client.user.model.CloudAccount;
import io.github.sibir007.cloud2.client.user.model.CloudsSystem;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

import static javafx.scene.control.ButtonType.OK;

public class ManageCloudsViewController {
    private static Logger logger = LogManager.getLogger();
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

    private Stage addCloudWindow;
    private Stage editCloudWindow;
    private EditCloudWindowController editCloudWindowController;

    @FXML
    private Alert dellCloudConformationAlert;


    private final CloudsSystem model;

    public ManageCloudsViewController(CloudsSystem cloudsSystem) {
        model = cloudsSystem;


    }

    public void initialize() {
        initCloudsTable();
        initCloudView();
        initButtons();
        initAddCloudWindow();
        initDellCloudConformationAlert();
        initEditCloudWindow();
    }

    private void initEditCloudWindow() {
        FXMLLoader loader = DependencyInjection.getLoader("/fxml/manageCloudsView/editCloudWindow.fxml");
        try {
            editCloudWindow = (Stage) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        editCloudWindowController = loader.getController();
        editCloudWindow.initModality(Modality.APPLICATION_MODAL);

    }


    private void initDellCloudConformationAlert() {
        dellCloudConformationAlert = new Alert(Alert.AlertType.CONFIRMATION, "a you shou, delete cloud?", OK, ButtonType.CANCEL);
        dellCloudConformationAlert.initModality(Modality.APPLICATION_MODAL);
    }

    private void initAddCloudWindow() {
        addCloudWindow = (Stage) DependencyInjection.load("/fxml/manageCloudsView/addCloudWindow.fxml");
//        addCloudWindow.initModality(Modality.APPLICATION_MODAL);
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
        this.cloudsTable.getItems().addListener(new ListChangeListener<Cloud>() {
            @Override
            public void onChanged(Change<? extends Cloud> c) {
                if (c.next() & c.wasAdded()) {
                    List<? extends Cloud> clouds = c.getAddedSubList();
                    clouds.forEach(cloud -> {
                        ManageCloudsViewController.this.cloudsTable.getSelectionModel().select(cloud);
                    });

                }
            }
        });

    }

    private void initCloudView() {
        cloudView.disableProperty().bind(
                cloudsTable.getSelectionModel().selectedItemProperty().isNull()
        );

        cloudsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldVal, newVal) -> {
                    if (newVal != null) {
                        hostLabel.setText(newVal.getHost());
                        portLabel.setText(String.valueOf(newVal.getPort()));
                        protocolLabel.setText(newVal.getProtocol());
                        cloudAccountsTable.setItems(newVal.getCloudAccounts());
                    } else {
                        hostLabel.setText("");
                        portLabel.setText("");
                        protocolLabel.setText("");
                        cloudAccountsTable.setItems(null);
                    }
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

    public void addCLoudButtonAction(ActionEvent actionEvent) {
        logger.trace(Thread.currentThread().getName());
        addCloudWindow.show();
        logger.trace(Thread.currentThread().getName());

    }

    public void editCloudButtonAction(ActionEvent actionEvent) {
        Cloud cloud = cloudsTable.getSelectionModel().getSelectedItem();
        editCloudWindowController.setCurrentCloud(cloud);
        editCloudWindow.show();
    }

    public void dellCloudButtonAction(ActionEvent actionEvent) {
//        dellCloudConformationAlert.
        dellCloudConformationAlert
                .showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> {
                    Cloud cloud = cloudsTable.getSelectionModel().getSelectedItem();
                    model.removeCloud(cloud);
                });
    }


    public void addAccountButtonAction(ActionEvent actionEvent) {
    }

    public void dellAccountButtonAction(ActionEvent actionEvent) {
    }

    public void editAccountButtonAction(ActionEvent actionEvent) {
    }
}
