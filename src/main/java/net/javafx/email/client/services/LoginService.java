package net.javafx.email.client.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import net.javafx.email.client.constants.LoginResult;
import net.javafx.email.client.models.EmailAccount;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class LoginService extends Service<LoginResult> {

    private final EmailAccount emailAccount;
    private final EmailService emailService;

    public LoginService(EmailAccount emailAccount, EmailService emailService) {
        this.emailAccount = emailAccount;
        this.emailService = emailService;
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
            e.printStackTrace();
            return LoginResult.FAILED_BY_CREDENTIALS;
        } catch (MessagingException e) {
            e.printStackTrace();
            return LoginResult.FAILED_BY_NETWORK;
        }
        return LoginResult.SUCCESS;
    }

    public void send() {
        Session session = Session.getInstance(this.emailAccount.getProperties(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailAccount.getAddress(), emailAccount.getPassword());
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(System.getenv("EMAIL_SENDER")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(System.getenv("EMAIL_RECIPIENT")));
            message.setSubject("Testing Subject");
            message.setText("""
                    Dear Mail Crawler,

                    No spam to my email, please!""");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
