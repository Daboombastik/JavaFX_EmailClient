package net.javafx.email.client.controllers;

import javafx.scene.Node;
import javafx.stage.Stage;
import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

public abstract class BaseController {

    private Controller name;
    private EmailService emailService;
    private ViewService viewService;

    public BaseController(Controller name, EmailService emailService, ViewService viewService) {
        this.name = name;
        this.emailService = emailService;
        this.viewService = viewService;
    }

    public BaseController() {
    }

    public void closeWindow(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        getViewFactory().closeStage(stage);
    }

    public void showWindow(Controller controller) {
        getViewFactory().show(controller);
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public ViewService getViewFactory() {
        return viewService;
    }

    public Controller getName() {
        return name;
    }

}
