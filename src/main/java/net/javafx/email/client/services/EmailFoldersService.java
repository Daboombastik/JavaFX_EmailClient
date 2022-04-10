package net.javafx.email.client.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import net.javafx.email.client.models.EmailTreeItem;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;
import java.util.Arrays;

public class EmailFoldersService extends Service<Void> {

    private final Store store;
    private final EmailTreeItem<String> folder;

    public EmailFoldersService(Store store, EmailTreeItem<String> folder) {
        this.store = store;
        this.folder = folder;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() throws Exception {
                fetchFolders();
                return null;
            }
        };
    }

    private void fetchFolders() throws MessagingException {
        Folder[] defaultFolder = this.store.getDefaultFolder().list();
        Arrays.stream(defaultFolder).sequential()
                .map(f -> new EmailTreeItem<String>(f.getName()))
                .forEach(f -> this.folder.getChildren().add(f));
    }
}
