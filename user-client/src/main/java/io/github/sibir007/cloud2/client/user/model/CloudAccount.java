package io.github.sibir007.cloud2.client.user.model;

class CloudAccount {
    private Cloud cloud;
    private String login;
    private String password;

    CloudAccount(Cloud cloud, String login, String password){
        this.cloud = cloud;
        this.login = login;
        this.password = password;
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
}
