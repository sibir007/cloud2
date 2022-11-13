package io.github.sibir007.cloud2.client.user.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.MalformedURLException;
import java.net.URL;

public class Cloud {
    public static Cloud createFtpCloud(String host) {
        return new Cloud("ftp", host, 21, "/");
    }

    private final ObjectProperty<URL> urlProperty = new ObjectPropertyBase<>() {
        @Override
        public Object getBean() {
            return Cloud.this;
        }

        @Override
        public String getName() {
            return "url";
        }

        @Override
        protected void invalidated() {
        }
    };
    private final ObservableList<CloudAccount> cloudAccounts = FXCollections.observableArrayList();

    //TODO обработать исключение
    public Cloud(String protocol, String host, int port, String file) {
        URL url = null;
        try {
            url = new URL(protocol, host, port, file);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        this.urlProperty.setValue(url);
    }

    public URL getUrlProperty() {
        return urlProperty.getValue();
    }

    public void setUrlProperty(URL urlProperty) {
        this.urlProperty.setValue(urlProperty);
    }

    public Property<URL> urlPropertyProperty() {
        return urlProperty;
    }


    public ObservableList<CloudAccount> getCloudAccounts() {
        return cloudAccounts;
    }

    public boolean addCloudAccount(String login, String password, String email) {
        return cloudAccounts.add(new CloudAccount(this, login, password, email));
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

    public int getPort() {
        return urlProperty.getValue().getPort();
    }
}
