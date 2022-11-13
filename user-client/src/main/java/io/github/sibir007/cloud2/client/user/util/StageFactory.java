package io.github.sibir007.cloud2.client.user.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageFactory {
    private StageFactory(){

    }
    public static Stage stageFactory(Scene scene){
        Stage stage = new Stage();
        stage.setScene(scene);
        return stage;
    }
}
