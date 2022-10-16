package io.github.sibir007.cloud2.client.user.model;

public class Model {
    private static CloudsSystem model;
    public static CloudsSystem getModel(){
        if (model == null){
            model = loadModel();
        }
        return model;
    }

    private static CloudsSystem loadModel() {
        return new CloudsSystem();
    }
    //TODO implement method
    public static void saveModel(){

    }
}
