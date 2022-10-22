package io.github.sibir007.cloud2.client.user.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.MalformedURLException;
import java.net.URL;

public class Cloud {

    private final ObjectProperty<URL> urlProperty = new ObjectPropertyBase<URL>() {
        @Override
        public Object getBean() {
            return Cloud.this;
        }
        @Override
        public String getName() {
            return "url";
        }
    };
    private final ObservableList<CloudAccount> cloudAccounts = FXCollections.observableArrayList();

    public Cloud(String protocol, String host, int port, String file) throws MalformedURLException {
        URL url = new URL(protocol, host, port, file);
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

    public boolean addCloudAccount(String login, String password) {
        return cloudAccounts.add(new CloudAccount(this, login, password));
    }

    public CloudAccount removeCloudAccount(int index) {
        return cloudAccounts.remove(index);
    }

    public boolean removeCloudAccount(CloudAccount cloudAccount) {
        return cloudAccounts.remove(cloudAccount);
    }

    public CloudAccount getCloudAccount(int index) {
        return cloudAccounts.get(index);
    }

    public String getProtocol() {
        return urlProperty.getValue().getProtocol();
    }

    public String getHost() {
        return urlProperty.getValue().getHost();
    }

    public int getPort(){
        return urlProperty.getValue().getPort();
    }
}
