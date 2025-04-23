module net.javafx.email.emailclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;
    requires java.mail;

    requires static lombok;

    opens net.javafx.email.client to javafx.fxml;
    opens net.javafx.email.client.constants to javafx.fxml, lombok;
    opens net.javafx.email.client.controllers to javafx.fxml, lombok;
    opens net.javafx.email.client.services to java.mail;

    exports net.javafx.email.client;
    exports net.javafx.email.client.constants;
    exports net.javafx.email.client.controllers;
    exports net.javafx.email.client.models;
    exports net.javafx.email.client.services;
}