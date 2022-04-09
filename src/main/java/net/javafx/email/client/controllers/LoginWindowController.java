package net.javafx.email.client.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.javafx.email.client.constants.Controllers;
import net.javafx.email.client.factory.ViewFactory;
import net.javafx.email.client.manager.EmailManager;

public class LoginWindowController extends BaseController {

    public Button loginButton;
    public TextField textField;
    public PasswordField passwordField;

    public LoginWindowController(Controllers name, EmailManager emailManager, ViewFactory viewFactory) {
        super(name, emailManager, viewFactory);
    }

    public void loginAction(ActionEvent actionEvent) {
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        boolean loginOK = true;
        if (loginOK) {
            getViewFactory().showMainWindow();
            getViewFactory().closeStage(stage);

        }
    }
}
