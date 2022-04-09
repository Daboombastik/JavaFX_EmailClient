package net.javafx.email.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.javafx.email.client.controllers.LoginWindowController;
import net.javafx.email.client.factory.ViewFactory;
import net.javafx.email.client.manager.EmailManager;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}