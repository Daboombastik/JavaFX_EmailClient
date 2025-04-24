package net.javafx.email.client.models;

import lombok.Getter;
import lombok.Setter;

import javax.mail.Store;
import java.util.Properties;

@Getter
@Setter
public class EmailAccount {

    private final String address;
    private final String password;
    private Properties properties;
    private Store store;

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();
        properties.put("incomingHost", "imap.gmail.com");
        properties.put("outgoingHost", "smtp.gmail.com");

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.transport.protocol", "smtps");
    }

    @Override
    public String toString() {
        return "EmailAccount{" +
                "address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", properties=" + properties +
                ", store=" + store +
                '}';
    }
}