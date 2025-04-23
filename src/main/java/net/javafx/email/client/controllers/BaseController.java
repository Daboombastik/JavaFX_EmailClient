package net.javafx.email.client.controllers;

import javafx.scene.Node;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import net.javafx.email.client.constants.View;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

@Getter
@Setter
public abstract class BaseController {

    private View view;
    private ViewService viewService;
    private EmailService emailService;

    public BaseController(){}

    public BaseController(ViewService viewService, EmailService emailService) {
        this.viewService = viewService;
        this.emailService = emailService;
    }

    public void showWindow(View view) {
        getViewService().show(view);
    }

    public void closeWindow(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        getViewService().closeStage(stage);
    }
}