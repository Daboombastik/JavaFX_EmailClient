package net.javafx.email.client.services;

import net.javafx.email.client.constants.LoginResult;
import net.javafx.email.client.manager.EmailManager;
import net.javafx.email.client.models.EmailAccount;

public class LoginService {

    EmailAccount emailAccount;
    EmailManager emailManager;

    public LoginService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    public LoginResult login(){

        return null;
    }
}
