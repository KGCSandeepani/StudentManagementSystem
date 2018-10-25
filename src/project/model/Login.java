/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

/**
 *
 * @author 
 */
public class Login {
    private String passwordId;
    private String userName;
    private String password;

    public Login() {
    }

    public Login(String passwordId, String userName, String password) {
        this.passwordId = passwordId;
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordId() {
        return passwordId;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
