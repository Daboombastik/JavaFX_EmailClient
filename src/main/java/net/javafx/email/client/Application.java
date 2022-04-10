package net.javafx.email.client;

import javafx.stage.Stage;
import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        ViewService viewService = new ViewService(new EmailService());
        viewService.show(Controller.LoginWindow);
    }

    public static void main(String[] args) {
        launch();
    }
}