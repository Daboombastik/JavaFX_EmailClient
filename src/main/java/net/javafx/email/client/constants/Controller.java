package net.javafx.email.client.constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public enum Controller {
    MainWindow,
    LoginWindow,
    OptionWindow;

    public static URL getViewURL(Controller controller) throws MalformedURLException {
        return switch (controller) {
            case LoginWindow -> Paths.get("src/main/resources/net/javafx/email/client/views/login_window.fxml").toUri().toURL();
            case MainWindow -> Paths.get("src/main/resources/net/javafx/email/client/views/main_window.fxml").toUri().toURL();
            case OptionWindow -> Paths.get("src/main/resources/net/javafx/email/client/views/options_window.fxml").toUri().toURL();
            default -> null;
        };
    }
}
