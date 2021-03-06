package net.javafx.email.client.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.constants.Font;
import net.javafx.email.client.constants.Theme;
import net.javafx.email.client.controllers.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import static net.javafx.email.client.constants.Controller.*;

public class ViewService {

    private final EmailService emailService;
    private FXMLLoader loader;
    private Theme theme = Theme.DEFAULT;
    private Font font = Font.MEDIUM;
    private final ArrayList<Stage> activeStages;

    public ViewService(EmailService emailService) {
        this.emailService = emailService;
        this.activeStages = new ArrayList<>();
    }

    public void show(Controller name) {
        BaseController controller = null;
        switch (name){
            case LoginWindow -> controller = new LoginWindowController(LoginWindow, emailService, this);
            case MainWindow -> controller = new MainWindowController(MainWindow, emailService, this);
            case OptionWindow -> controller = new OptionsWindowController(OptionWindow, emailService, this);
        }
        showStage(controller);
    }
//
//    public void showLoginWindow() {
//        BaseController controller = new LoginWindowController(LoginWindow, emailManager, this);
//    }
//
//    public void showMainWindow() {
//        BaseController controller = new MainWindowController(MainWindow, emailManager, this);
//        showStage(controller);
//    }
//
//    public void showOptionWindow() {
//        BaseController controller = new OptionsWindowController(OptionWindow, emailManager, this);
//        showStage(controller);
//    }

    private void showStage(BaseController controller) {
        Parent root;
        Scene scene;
        Stage stage;
        try {
            this.loader = new FXMLLoader(Controller.getViewURL(controller.getName()));
            this.loader.setController(controller);
            root = this.loader.load();
            scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public void updateStyles() {
        this.activeStages.forEach(stage -> {
            Scene scene = stage.getScene();
            try {
                scene.getStylesheets().clear();
                scene.getStylesheets().add(Font.getCssUrl(this.font).toExternalForm());
                scene.getStylesheets().add(Theme.getCssUrl(this.theme).toExternalForm());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }
//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginWindowController.class.getResource("login_window.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

    public Theme getTheme() {
        return theme;
    }

    public Font getFont() {
        return font;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}
