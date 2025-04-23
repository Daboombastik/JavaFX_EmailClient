package net.javafx.email.client;

import javafx.stage.Stage;
import net.javafx.email.client.constants.View;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        ViewService viewService = new ViewService(new EmailService());
        viewService.show(View.LoginView);
    }

    public static void main(String[] args) {
        launch();
    }
}