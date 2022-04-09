package net.javafx.email.client.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.javafx.email.client.constants.Fonts;
import net.javafx.email.client.constants.Themes;
import net.javafx.email.client.controllers.*;
import net.javafx.email.client.manager.EmailManager;

import java.io.IOException;

import static net.javafx.email.client.constants.Controllers.*;

public class ViewFactory {

    private EmailManager emailManager;
    private FXMLLoader loader;
    private Themes theme = Themes.DEFAULT;
    private Fonts font = Fonts.MEDIUM;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow() throws IOException {
        BaseController controller = new LoginWindowController(LoginWindow, emailManager, this);
        showStage(controller);
    }

    public void showMainWindow() {
        BaseController controller = new MainWindowController(MainWindow, emailManager, this);
        showStage(controller);
    }

    public void showOptionWindow() {
        BaseController controller = new OptionsWindowController(OptionWindow, emailManager, this);
        showStage(controller);
    }

    private void showStage(BaseController controller) {
        Parent root;
        Scene scene;
        Stage stage;
        try {
            this.loader = new FXMLLoader(controller.getControllerURL(controller.getName()));
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
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginWindowController.class.getResource("login_window.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

    public Themes getTheme() {
        return theme;
    }

    public Fonts getFont() {
        return font;
    }

    public void setTheme(Themes theme) {
        this.theme = theme;
    }

    public void setFont(Fonts font) {
        this.font = font;
    }
}
