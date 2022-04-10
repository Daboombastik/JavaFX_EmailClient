package net.javafx.email.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;
import net.javafx.email.client.constants.Controller;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
    public TreeView<String> emailsTreeView;
    public TableView<?> emailsTableView;
    public WebView emailWebView;

    public MainWindowController(Controller name, EmailService emailService, ViewService viewService) {
        super(name, emailService, viewService);
    }

    public void optionsAction(ActionEvent actionEvent) {
        showWindow(Controller.OptionWindow);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpEmailsTreeView();
    }

    private void setUpEmailsTreeView() {
        this.emailsTreeView.setRoot(getEmailService().getRootFolder());
        this.emailsTreeView.setShowRoot(false);
    }
}
