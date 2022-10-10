package io.github.sibir007.cloud2.client.user.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.MalformedURLException;


public class CloudsSystem {
    private final ObservableList<Cloud> clouds = FXCollections.observableArrayList();

    public void addCloud(String protocol, String host, int port) throws MalformedURLException {
        Cloud cloud = new Cloud(protocol, host, port);
        this.clouds.add(cloud);
    }

    public ObservableList<Cloud> getClouds() {
        return clouds;
    }


}
