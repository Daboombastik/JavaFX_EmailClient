package net.javafx.email.client.constants;

public enum Font {
    SMALL("src/main/resources/net/javafx/email/client/css/fontSmall.css"),
    MEDIUM("src/main/resources/net/javafx/email/client/css/fontMedium.css"),
    BIG("src/main/resources/net/javafx/email/client/css/fontBig.css"),
    DEFAULT("src/main/resources/net/javafx/email/client/css/default.css");

    public final String path;

    Font(String path) {
        this.path = path;
    }
}