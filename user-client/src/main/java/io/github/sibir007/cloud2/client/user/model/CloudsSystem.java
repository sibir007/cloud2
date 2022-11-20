package io.github.sibir007.cloud2.client.user.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CloudsSystem {
    private static Logger logger = LogManager.getLogger();
    private final ObservableList<Cloud> clouds = FXCollections.observableArrayList();


    public ObservableList<Cloud> getClouds() {
        return clouds;
    }

    public Cloud addFtpCloud(String host) {
        Cloud cloud = Cloud.createFtpCloud(host);
        clouds.add(cloud);
        return cloud;
    }
    public boolean addCloud(Cloud cloud){
        return clouds.add(cloud);
    }


    public Cloud editCloud(Cloud oldCloud, String protocol, String host, int port, String file) {
        Cloud editedCLoud = Cloud.editCloud(oldCloud, protocol, host, port, file);
        removeCloud(oldCloud);
        clouds.add(editedCLoud);
        return editedCLoud;
    }

    ;

    public boolean removeCloud(Cloud cloud) {
        return clouds.remove(cloud);
    }

}
