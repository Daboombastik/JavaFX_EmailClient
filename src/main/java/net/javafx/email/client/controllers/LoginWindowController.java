package net.javafx.email.client.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.models.EmailAccount;
import net.javafx.email.client.services.LoginService;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

public class LoginWindowController extends BaseController {

    public AnchorPane baseNode;
    public Button loginButton;
    public TextField emailField;
    public PasswordField passwordField;
    public Label message;

    public LoginWindowController(Controller name, EmailService emailService, ViewService viewService) {
        super(name, emailService, viewService);
    }

    public void loginAction(ActionEvent actionEvent) {

        if (fieldsAreValid()) {
//            EmailAccount emailAccount = new EmailAccount(emailField.getText(), passwordField.getText());
            EmailAccount emailAccount = new EmailAccount(System.getenv("EMAIL_ADDRESS"), System.getenv("EMAIL_PASSWORD"));
            LoginService loginService = new LoginService(emailAccount, getEmailService());
            loginService.start();
            loginService.setOnSucceeded(event -> {
                switch (loginService.getValue()) {
                    case SUCCESS -> {
                        message.setText("login successful for : " + emailAccount.getAddress());
                        getEmailService().addEmailAccount(emailAccount);
                        showWindow(Controller.MainWindow);
                        closeWindow(this.baseNode);
                    }
                    case FAILED_BY_CREDENTIALS -> {
                        message.setText("invalid credentials!");
                    }
                    case FAILED_BY_UNEXPECTED_ERROR -> {
                        message.setText("unexpected error!");
                    }
                    default -> {return;}
                }
            });
        }
    }

    private boolean fieldsAreValid() {
        if (emailField.getText().isEmpty()) {
            message.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()) {
            message.setText("Please fill password");
            return false;
        }
        return true;
    }
}
