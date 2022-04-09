module net.javafx.email.emailclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires eu.hansolo.tilesfx;
//    requires lombok;

    opens net.javafx.email.client to javafx.fxml;
    opens net.javafx.email.client.controllers to javafx.fxml, lombok;
//    opens net.javafx.email.client.controllers to lombok;
    exports net.javafx.email.client;
    exports net.javafx.email.client.controllers;
    exports net.javafx.email.client.manager;
    exports net.javafx.email.client.factory;
    exports net.javafx.email.client.constants;
    opens net.javafx.email.client.constants to javafx.fxml, lombok;
}