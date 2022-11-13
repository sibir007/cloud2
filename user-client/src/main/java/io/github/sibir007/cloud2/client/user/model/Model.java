package io.github.sibir007.cloud2.client.user.model;

import java.net.MalformedURLException;

public class Model {
    private static CloudsSystem model;
    public static CloudsSystem getModel() throws MalformedURLException {
        if (model == null){
            model = new CloudsSystem();
            initModel();
        }
        return model;
    }

//    private static CloudsSystem initModel() throws MalformedURLException {
//        CloudsSystem cloudsSystem = new CloudsSystem();
//        initCloudsSystem(cloudsSystem);
//        return cloudsSystem;
//    }

    private static void initModel() throws MalformedURLException {
        Cloud cloud = model.addCloud("yandex.ru");
        cloud.addCloudAccount("dima", "password", "dslfsfjdkfj");
        cloud.addCloudAccount("vova", "password", "eijweiwier");
        cloud.addCloudAccount("sasha", "password", "lsdjfls");
        cloud = model.addCloud("google");
        cloud.addCloudAccount("sdfsdf", "password", "232j24l");
        cloud.addCloudAccount("33333", "password", "2222222");
        cloud.addCloudAccount("1111", "password", "44545454");
        cloud = model.addCloud("sibiriakoff2006");
        cloud.addCloudAccount("^^^^^^^", "password", "sdkljf3434");
        cloud.addCloudAccount("-------", "password", "2333k3k3k3k");
        cloud.addCloudAccount("@@@@@@@", "password", "111111111");
        cloud = model.addCloud("sibir007.io");
        cloud.addCloudAccount("0-0-0-0-0", "password", "sdjf@sjdlfk");
        cloud.addCloudAccount("1_1_1_1", "password", "dskfj@434343");
        cloud.addCloudAccount("@@@@-@@@@@", "password", "sdjflskdj6666");
    }

    //TODO implement method
    public static void saveModel(){

    }

//    private static void implementnitCloudsSystem()
}
