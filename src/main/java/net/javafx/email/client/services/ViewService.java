package net.javafx.email.client.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import net.javafx.email.client.interfaces.Resource;
import net.javafx.email.client.models.View;
import net.javafx.email.client.models.Font;
import net.javafx.email.client.models.Theme;
import net.javafx.email.client.controllers.*;
import net.javafx.email.client.utils.LogUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@Getter
@Setter
@Log
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
            this.loader.setLocation(this.getUrlFor(view));
            this.loader.setControllerFactory(controllerFactory::createController);
            Parent root = this.loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            activeStages.add(stage);
        } catch (IOException e) {
            LogUtils.logException(log, e, "Failed to load view for controller: " + this.loader.getController().getClass().getSimpleName());
        }
    }

    public void close(Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public void update() {
        this.activeStages.forEach(stage -> {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(this.getUrlFor(this.font).toExternalForm());
            scene.getStylesheets().add(this.getUrlFor(this.theme).toExternalForm());
        });
    }

    public URL getUrlFor(Resource resource) {
        URL url = getClass().getResource(resource.getPath());
        if (url == null) {
            throw new IllegalArgumentException("Resource not found: " + resource.getPath());
        }
        return url;
    }
}