package net.javafx.email.client.models;

import net.javafx.email.client.interfaces.Resource;

public enum Theme implements Resource {
    LIGHT("/net/javafx/email/client/css/themeLight.css"),
    DARK("/net/javafx/email/client/css/themeDark.css"),
    DEFAULT("/net/javafx/email/client/css/themeDefault.css");

    public final String path;

    Theme(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return this.path;
    }
}