package net.javafx.email.client.models;

import net.javafx.email.client.interfaces.Resource;

public enum View implements Resource {
    MainView("/net/javafx/email/client/views/main_view.fxml"),
    LoginView("/net/javafx/email/client/views/login_view.fxml"),
    OptionsView("/net/javafx/email/client/views/options_view.fxml");

    public final String path;

    View(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return this.path;
    }
}