package model;

import java.io.Serializable;

public class AccountUser implements Serializable {

    private String userAccount;
    private String userPassword;
    private String address;

    public AccountUser() {
    }

    public AccountUser(String userAccount, String userPassword, String address) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.address = address;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
