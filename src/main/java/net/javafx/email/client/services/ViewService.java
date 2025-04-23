package net.javafx.email.client.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import net.javafx.email.client.constants.View;
import net.javafx.email.client.constants.Font;
import net.javafx.email.client.constants.Theme;
import net.javafx.email.client.controllers.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

@Getter
@Setter
public class ViewService {

    private final EmailService emailService;
    private FXMLLoader loader;
    private Theme theme = Theme.DEFAULT;
    private Font font = Font.MEDIUM;
    private final ArrayList<Stage> activeStages;
    private final ControllerFactory controllerFactory;

    public ViewService(EmailService emailService) {
        this.emailService = emailService;
        this.controllerFactory = new ControllerFactory(this, emailService);
        this.loader = new FXMLLoader();
        this.activeStages = new ArrayList<>();
    }

    /**
     * Important: We could use
     * this.loader = new FXMLLoader(this.getUrl(view));
     * this.loader.setController(controller);
     * to set the controller directly into the loader, but it will cause RuntimeError
     * because JavaFX already have the tag 'fx:controller' in fxml config file
     */
    public void show(View view) {
        try {
            this.loader.setLocation(this.getUrl(view));
            this.loader.setControllerFactory(controllerClass -> {
                System.out.println("Current view controller: " + controllerClass.getName());
                return controllerFactory.createController(controllerClass);
            });
            Parent root = this.loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            activeStages.add(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                scene.getStylesheets().add(this.getUrl(this.font).toExternalForm());
                scene.getStylesheets().add(this.getUrl(this.theme).toExternalForm());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
    }


    public URL getUrl(View view) throws MalformedURLException {
        return Paths.get(view.path).toUri().toURL();
    }

    public URL getUrl(Font font) throws MalformedURLException {
        return Paths.get(font.path).toUri().toURL();
    }

    public URL getUrl(Theme theme) throws MalformedURLException {
        return Paths.get(theme.path).toUri().toURL();
    }
}