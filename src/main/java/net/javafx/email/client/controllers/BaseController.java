package net.javafx.email.client.controllers;

import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.manager.EmailManager;

public abstract class BaseController {

    private Controller name;
    private EmailManager emailManager;
    private ViewService viewService;

    public BaseController(Controller name, EmailManager emailManager, ViewService viewService) {
        this.name = name;
        this.emailManager = emailManager;
        this.viewService = viewService;
    }

    public BaseController() {
    }

    public EmailManager getEmailManager() {
        return emailManager;
    }

    public ViewService getViewFactory() {
        return viewService;
    }

    public Controller getName() {
        return name;
    }

}
