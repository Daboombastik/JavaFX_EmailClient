package net.javafx.email.client;

import javafx.stage.Stage;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.manager.EmailManager;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        ViewService viewService = new ViewService(new EmailManager());
        viewService.showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}