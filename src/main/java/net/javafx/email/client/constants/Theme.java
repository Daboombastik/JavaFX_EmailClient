package net.javafx.email.client.constants;

public enum Theme {
    LIGHT("src/main/resources/net/javafx/email/client/css/themeLight.css"),
    DARK("src/main/resources/net/javafx/email/client/css/themeDark.css"),
    DEFAULT("src/main/resources/net/javafx/email/client/css/themeDefault.css");

    public final String path;

    Theme(String path) {
        this.path = path;
    }
}