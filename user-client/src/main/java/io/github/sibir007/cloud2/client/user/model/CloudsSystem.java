package io.github.sibir007.cloud2.client.user.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.MalformedURLException;


public class CloudsSystem {
    private final ObservableList<Cloud> clouds = FXCollections.observableArrayList();
    private Cloud currentCloud;

    {
//        currentCloud
    }

    public ObservableList<Cloud> getClouds() {
        return clouds;
    }

    public Cloud getCloud(int index){
        return clouds.get(index);
    }

    public void setCloud(int index, Cloud cloud){
        clouds.set(index, cloud);
    }

    public boolean addCloud(Cloud cloud){
        return clouds.add(cloud);
    }

    public Cloud addCloud(String protocol, String host, int port, String file) throws MalformedURLException {
        Cloud cloud = new Cloud(protocol, host, port, file);
        clouds.add(cloud);
        return cloud;
    }
    public boolean removeCloud(Cloud cloud){
        return clouds.remove(cloud);
    }

    public Cloud removeCloud(int index){
        return clouds.remove(index);
    }

    public void selectCloud(int index){
        currentCloud = getCloud(index);
    }

//    public void setClouds(Cloud cloud){
//        this.clouds.add(cloud);
//    }
//    public void setClouds(int index, Cloud cloud){
//        this.clouds.set(index, cloud);
//    }
//
//    public ObservableList<Cloud> getClouds() {
//        return clouds;
//    }
//
//    public Cloud getCloudsProperties(int index) {
//        return clouds.get(index);
//    }

}
