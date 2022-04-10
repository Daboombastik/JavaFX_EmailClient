package net.javafx.email.client.constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public enum Theme {
    LIGHT, DARK, DEFAULT;

    public static URL getCssUrl(Theme theme) throws MalformedURLException {
        return switch (theme) {
            case LIGHT -> Paths.get("src/main/resources/net/javafx/email/client/css/themeLight.css").toUri().toURL();
            case DARK -> Paths.get("src/main/resources/net/javafx/email/client/css/themeDark.css").toUri().toURL();
            case DEFAULT -> Paths.get("src/main/resources/net/javafx/email/client/css/themeDefault.css").toUri().toURL();
            default -> Paths.get("src/main/resources/net/javafx/email/client/css/default.css").toUri().toURL();
        };
    }
}
