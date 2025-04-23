package net.javafx.email.client.constants;

public enum View {
    MainView("src/main/resources/net/javafx/email/client/views/main_view.fxml"),
    LoginView("src/main/resources/net/javafx/email/client/views/login_view.fxml"),
    OptionsView("src/main/resources/net/javafx/email/client/views/options_view.fxml");

    public final String path;

    View(String path) {
        this.path = path;
    }
}