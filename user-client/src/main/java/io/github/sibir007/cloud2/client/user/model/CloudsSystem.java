package io.github.sibir007.cloud2.client.user.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CloudsSystem {
    private final ObservableList<Cloud> clouds = FXCollections.observableArrayList();

    public void setClouds(Cloud cloud){
        this.clouds.add(cloud);
    }
    public void setClouds(int index, Cloud cloud){
        this.clouds.add(index, cloud);
    }

    public ObservableList<Cloud> getClouds() {
        return clouds;
    }

    public Cloud getCloudsProperties(int index) {
        return clouds.get(index);
    }

}
