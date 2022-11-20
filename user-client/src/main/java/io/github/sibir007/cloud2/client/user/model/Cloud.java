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
    public static Cloud editCloud(Cloud oldCloud, String protocol, String host, int port, String file){
        Cloud newCloud = new Cloud(protocol, host, port, file);
        ObservableList<CloudAccount> cloudAccounts = oldCloud.getCloudAccounts();
        newCloud.setCloudAccounts(cloudAccounts);
        return newCloud;
    }

    private final ObjectProperty<URL> url = new ObjectPropertyBase<>() {
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
    private ObservableList<CloudAccount> cloudAccounts = FXCollections.observableArrayList();

    //TODO обработать исключение
    public Cloud(String protocol, String host, int port, String file) {
        setUrl(protocol, host, port, file);
    }
    private URL newUrl(String protocol, String host, int port, String file){
        URL url = null;
        try {
            url = new URL(protocol, host, port, file);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public URL getUrl() {
        return url.getValue();
    }
    public void setUrl(String protocol, String host, int port, String file){
        setUrl(newUrl(protocol, host, port, file));
    }

    public void setUrl(URL url) {
        this.url.setValue(url);
    }

    public Property<URL> urlProperty() {
        return url;
    }



    public ObservableList<CloudAccount> getCloudAccounts() {
        return cloudAccounts;
    }
    public void setCloudAccounts(ObservableList<CloudAccount> cloudAccounts){
        this.cloudAccounts = cloudAccounts;
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
        return url.getValue().getProtocol();
    }

    public String getHost() {
        return url.getValue().getHost();
    }

    public int getPort() {
        return url.getValue().getPort();
    }
    public String getFile(){
        return url.getValue().getFile();
    }

    public void setProtocol(String protocol){
        setUrl(newUrl(protocol, getHost(), getPort(), getFile()));
    }

    public void setHost(String host){
        setUrl(newUrl(getProtocol(), host, getPort(), getFile()));
    }

    public void setPort(int port){
        setUrl(newUrl(getProtocol(), getHost(), port, getFile()));
    }

    public void setFile(String file){
        setUrl(newUrl(getProtocol(), getHost(), getPort(), getFile()));
    }
}
