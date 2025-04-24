package net.javafx.email.client.models;

import net.javafx.email.client.interfaces.Resource;

public enum Font implements Resource {
    SMALL("/net/javafx/email/client/css/fontSmall.css"),
    MEDIUM("/net/javafx/email/client/css/fontMedium.css"),
    BIG("/net/javafx/email/client/css/fontBig.css"),
    DEFAULT("/net/javafx/email/client/css/default.css");

    public final String path;

    Font(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return this.path;
    }
}