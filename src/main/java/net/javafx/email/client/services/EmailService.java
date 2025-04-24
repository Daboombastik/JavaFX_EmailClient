package net.javafx.email.client.services;

import lombok.Getter;
import net.javafx.email.client.models.EmailAccount;
import net.javafx.email.client.models.EmailTreeItem;

@Getter
public class EmailService {

    private final EmailTreeItem<String> rootFolder = new EmailTreeItem<>("Root Folder");

    public void addEmailAccount(EmailAccount account) {
        EmailTreeItem<String> newAccountItem = new EmailTreeItem<>(account.getAddress());
        EmailFoldersService foldersService = new EmailFoldersService(account.getStore(), newAccountItem);
        newAccountItem.setExpanded(true);
        foldersService.start();
        foldersService.setOnSucceeded(event -> this.rootFolder.getChildren().add(newAccountItem));
    }


//    public void send() {
//        Session session = Session.getInstance(this.emailAccount.getProperties(),
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(emailAccount.getAddress(), emailAccount.getPassword());
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(System.getenv("EMAIL_SENDER")));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(System.getenv("EMAIL_RECIPIENT")));
//            message.setSubject("Testing Subject");
//            message.setText("""
//                    Dear Mail Crawler,
//
//                    No spam to my email, please!""");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }
}