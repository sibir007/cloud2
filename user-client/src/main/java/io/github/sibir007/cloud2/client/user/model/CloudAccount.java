package io.github.sibir007.cloud2.client.user.model;

public class CloudAccount {
    private Cloud cloud;
    private String login;
    private String password;
    private String email;

    CloudAccount(Cloud cloud, String login, String password, String email){
        this.cloud = cloud;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
