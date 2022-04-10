package net.javafx.email.client.services;

import javafx.scene.control.TreeItem;
import net.javafx.email.client.models.EmailAccount;
import net.javafx.email.client.models.EmailTreeItem;

public class EmailService {

    private final EmailTreeItem<String> rootFolder = new EmailTreeItem<>("Root Folder");

    public void addEmailAccount(EmailAccount account) {
        EmailTreeItem<String> newAccountItem = new EmailTreeItem<>(account.getAddress());
        EmailFoldersService foldersService = new EmailFoldersService(account.getStore(), newAccountItem);
        newAccountItem.setExpanded(true);
        foldersService.start();
        foldersService.setOnSucceeded(event -> {
            this.rootFolder.getChildren().add(newAccountItem);
        });
    }

    public EmailTreeItem<String> getRootFolder() {
        return rootFolder;
    }
}
