package io.github.sibir007.cloud2.client.user.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CloudsSystem {
    private final ObservableList<Cloud> clouds = FXCollections.observableArrayList();
    private Cloud currentCloud;

    {
//        currentCloud
    }

    public ObservableList<Cloud> getClouds() {
        return clouds;
    }

    public Cloud addCloud(String host){
        Cloud cloud = Cloud.createFtpCloud(host);
        clouds.add(cloud);
        return cloud;
    }
    public boolean removeCloud(Cloud cloud){
        return clouds.remove(cloud);
    }

}
