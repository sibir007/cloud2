package io.github.sibir007.cloud2.client.user.model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.MalformedURLException;
import java.net.URL;

public class Cloud {

    private final Property<URL> urlProperty = new SimpleObjectProperty<>();
    private final ObservableList<CloudAccount> cloudAccounts = FXCollections.observableArrayList();

    public Cloud(String protocol, String host, int port) throws MalformedURLException {
        URL url = new URL(protocol, host, port, "/");
        this.urlProperty.setValue(url);
    }

    public URL getUrlProperty() {
        return urlProperty.getValue();
    }

    public Property<URL> urlPropertyProperty() {
        return urlProperty;
    }

    public void setUrlProperty(URL urlProperty) {
        this.urlProperty.setValue(urlProperty);
    }

    public ObservableList<CloudAccount> getCloudAccounts() {
        return cloudAccounts;
    }

    public boolean addCloudAccount(String login, String password){
        return cloudAccounts.add(new CloudAccount(this, login, password));
    }

    public CloudAccount getCloudAccount(int index){
        return cloudAccounts.get(index);
    }
}
