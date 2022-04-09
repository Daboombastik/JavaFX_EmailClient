package net.javafx.email.client.constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public enum Font {
    SMALL, MEDIUM, BIG;

    public static URL getUrl(Font font) throws MalformedURLException {
        return switch (font) {
            case SMALL -> Paths.get("src/main/resources/net/javafx/email/client/css/fontSmall.css").toUri().toURL();
            case MEDIUM -> Paths.get("src/main/resources/net/javafx/email/client/css/fontMedium.css").toUri().toURL();
            case BIG -> Paths.get("src/main/resources/net/javafx/email/client/css/fontBig.css").toUri().toURL();
            default -> Paths.get("src/main/resources/net/javafx/email/client/css/default.css").toUri().toURL();
        };
    }
}
