package net.javafx.email.client.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.manager.EmailManager;

public class LoginWindowController extends BaseController {

    public Button loginButton;
    public TextField textField;
    public PasswordField passwordField;

    public LoginWindowController(Controller name, EmailManager emailManager, ViewService viewService) {
        super(name, emailManager, viewService);
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
