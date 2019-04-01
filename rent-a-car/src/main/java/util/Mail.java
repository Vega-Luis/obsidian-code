package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
  private final String HOST = "localhost";
  private Properties properties = System.getProperties();
  private MimeMessage message;

  Mail(String to, String from, String subject, String body) throws AddressException,
  MessagingException {
    properties.setProperty("mail.smtp.host", HOST);
    Session session = Session.getDefaultInstance(properties);
    message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(subject);
    message.setText(body);
  }
  
  public boolean sendMail(MimeMessage message) {
    try {
      Transport.send(message);
      return true;
   } catch (MessagingException mex) {
      return false;
   } 
  }
}
