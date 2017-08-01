package com.app;

import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by denys on 8/1/2017.
 */
public class NotificationServiceImpl implements  NotificationService {

    @Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "")
    @Override
    public void makeNotification() throws Exception {
        System.out.println("makeNotification()");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("account@gmail.com","");
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("denys.prokopiuk@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, InternetAddress.parse("denis4321@ukr.net")[0]);
        message.setSubject("Test Notification");
        message.setText("Hello from JavaMail");
        Transport.send(message);
    }
}
