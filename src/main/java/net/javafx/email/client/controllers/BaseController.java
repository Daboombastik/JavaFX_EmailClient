package net.javafx.email.client.controllers;

import net.javafx.email.client.constants.Controllers;
import net.javafx.email.client.factory.ViewFactory;
import net.javafx.email.client.manager.EmailManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public abstract class BaseController {

    private Controllers name;
    private EmailManager emailManager;
    private ViewFactory viewFactory;

    public BaseController(Controllers name, EmailManager emailManager, ViewFactory viewFactory) {
        this.name = name;
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
    }

    public BaseController() {
    }

    public URL getControllerURL(Controllers controller) throws MalformedURLException {
        //TODO implement URL for default controller in case if error
        return switch (controller) {
            case LoginWindow -> Paths.get("src/main/resources/net/javafx/email/client/views/login_window.fxml").toUri().toURL();
            case MainWindow -> Paths.get("src/main/resources/net/javafx/email/client/views/main_window.fxml").toUri().toURL();
            case OptionWindow -> Paths.get("src/main/resources/net/javafx/email/client/views/options_window.fxml").toUri().toURL();
            default -> null;
        };
    }

    public EmailManager getEmailManager() {
        return emailManager;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public Controllers getName() {
        return name;
    }

}
