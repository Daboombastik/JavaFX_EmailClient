package net.javafx.email.client.models;

import javafx.scene.control.TreeItem;

//this is a custom class
public class EmailTreeItem<String> extends TreeItem<String> {

    private String name;

    public EmailTreeItem(String name) {
        super(name);
        this.name = name;
    }
}
