package io.github.sibir007.cloud2.client.user.util;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFactory {
    private SceneFactory(){}
    public static Scene sceneFactory(Parent parent){
        return new Scene(parent);
    }
//    FXCollections
}
