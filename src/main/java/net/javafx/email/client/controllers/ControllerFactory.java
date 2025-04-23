package net.javafx.email.client.controllers;
import net.javafx.email.client.services.ViewService;
import net.javafx.email.client.services.EmailService;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ControllerFactory {

    private final Map<Class<?>, Supplier<BaseController>> controllerSuppliers = new HashMap<>();

    public ControllerFactory(ViewService viewService, EmailService emailService) {
        controllerSuppliers.put(LoginWindowController.class,
                () -> new LoginWindowController(viewService, emailService));
        controllerSuppliers.put(MainWindowController.class,
                () -> new MainWindowController(viewService, emailService));
        controllerSuppliers.put(OptionsWindowController.class,
                () -> new OptionsWindowController(viewService, emailService));
    }

    public BaseController createController(Class<?> clazz) {
        Supplier<BaseController> supplier = controllerSuppliers.get(clazz);
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown controller class: " + clazz);
        }
        return supplier.get();
    }
}