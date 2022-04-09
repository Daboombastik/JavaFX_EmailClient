package net.javafx.email.client.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;
import net.javafx.email.client.constants.Controllers;
import net.javafx.email.client.factory.ViewFactory;
import net.javafx.email.client.manager.EmailManager;

public class MainWindowController extends BaseController {
    public TreeView<?> emailsTreeView;
    public TableView<?> emailsTableView;
    public WebView emailWebView;

    public MainWindowController(Controllers name, EmailManager emailManager, ViewFactory viewFactory) {
        super(name, emailManager, viewFactory);
    }

    public void optionsAction(ActionEvent actionEvent) {
        getViewFactory().showOptionWindow();
    }

}
