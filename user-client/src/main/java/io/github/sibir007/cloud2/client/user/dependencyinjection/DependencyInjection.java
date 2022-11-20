package io.github.sibir007.cloud2.client.user.dependencyinjection;

//import io.github.sibir007.cloud2.client.user.controllers.AddCloudViewController;
import io.github.sibir007.cloud2.client.user.controllers.AddCloudWindowController;
import io.github.sibir007.cloud2.client.user.controllers.EditCloudWindowController;
import io.github.sibir007.cloud2.client.user.controllers.ManageCloudsViewController;
//import io.github.sibir007.cloud2.client.user.controllers.ManageCloudsTableViewController;
import io.github.sibir007.cloud2.client.user.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class DependencyInjection {
    private static final ResourceBundle bundle = null;
    private static final Map<Class<?>, Callable<?>> injectionMethods = new HashMap<>();


    public static Object load(String location){
        try {
            return getLoader(location).load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static FXMLLoader getLoader(String location){
        URL url = DependencyInjection.class.getResource(location);
        return new FXMLLoader(
                url,
                bundle,
                new JavaFXBuilderFactory(),
                controllerClass -> {
                    try {
                        return constructController(controllerClass);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
    
    private static Object constructController(Class<?> controllerClass) throws Exception {
        if (injectionMethods.containsKey(controllerClass)) {
            return injectionMethods.get(controllerClass).call();
        }else {
            return controllerClass.getConstructor().newInstance();
        }
    }


    public static void addInjectionMethod(Class<?> controllerClass, Callable<?> method){
        injectionMethods.put(controllerClass, method);
    }

    public static void removeInjectionMethod(Class<?> controllerClass){
        injectionMethods.remove(controllerClass);
    }

    static {
        addInjectionMethod(ManageCloudsViewController.class, () -> new ManageCloudsViewController(Model.getModel()));
//        injectionMethods.put();
//        addInjectionMethod(AddCloudViewController.class, () -> new AddCloudViewController(Model.getModel()));
        addInjectionMethod(AddCloudWindowController.class, () -> new AddCloudWindowController(Model.getModel()));
        addInjectionMethod(EditCloudWindowController.class, () -> new EditCloudWindowController(Model.getModel()));
    }

}
