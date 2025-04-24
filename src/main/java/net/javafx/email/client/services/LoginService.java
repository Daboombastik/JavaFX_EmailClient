package net.javafx.email.client.services;

import javax.mail.*;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import net.javafx.email.client.models.LoginResult;
import net.javafx.email.client.models.EmailAccount;
import lombok.extern.java.Log;
import net.javafx.email.client.utils.LogUtils;

@Log
public class LoginService extends Service<LoginResult> {

    private final EmailAccount emailAccount;

    public LoginService(EmailAccount emailAccount) {
        this.emailAccount = emailAccount;
    }

    @Override
    protected Task<LoginResult> createTask() {
        return new Task<LoginResult>() {
            @Override
            protected LoginResult call() throws Exception {
                return LoginService.this.login();
            }
        };
    }

    private LoginResult login() {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        LoginService.this.emailAccount.getAddress(),
                        LoginService.this.emailAccount.getPassword());
            }
        };
        try {
            Session session = Session.getInstance(this.emailAccount.getProperties(), authenticator);
            Store store = session.getStore();
            store.connect(
                    this.emailAccount.getProperties().getProperty("incomingHost"),
                    this.emailAccount.getAddress(),
                    this.emailAccount.getPassword());

            this.emailAccount.setStore(store);

        } catch (AuthenticationFailedException e) {
            LogUtils.logException(log, e, "User=" + this.emailAccount.getAddress());
            return LoginResult.FAILED_BY_CREDENTIALS;
        } catch (MessagingException e) {
            LogUtils.logException(log, e, "User=" + this.emailAccount.getAddress());
            return LoginResult.FAILED_BY_NETWORK;
        }
        return LoginResult.SUCCESS;
    }
}