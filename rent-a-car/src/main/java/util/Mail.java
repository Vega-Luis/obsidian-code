package util;

import java.io.File;
import java.nio.file.Paths;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Clase para enviar correos electronicos
 * @author Marcosmh0199
 * @version 01/04/2019
 */
public class Mail {
  private final String HOST = "smtp.gmail.com";
  private Properties properties;
  private Session session;
  private String userMail;
  private String password;
  private String from;
  private String subject;
  private String body;

  /**
   * Constructor de la clase
   * @param from correo del emisor
   * @param password contraseña del correo del emisor
   * @param userMail correo destinatario
   * @param subject tema del correo
   * @param body cuerpo del correo
   * @throws AddressException
   * @throws MessagingException
   */
  Mail(String from, String password, String userMail, String subject, String body) throws AddressException,
  MessagingException {
    this.from = from;
    this.password = password;
    this.userMail = userMail;
    this.subject = subject;
    this.body = body;
  }
  
  /**
   * Método para montar el servidor del cual se enviara el correo
   */
  private void setMailServer() {
    properties = System.getProperties();
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", HOST);
    properties.put("mail.smtp.user", from);
    properties.put("mail.smtp.password", password);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    session = Session.getDefaultInstance(properties, new Authenticator() {
      protected PasswordAuthentication  getPasswordAuthentication() {
        return new PasswordAuthentication(from, password);
      }
    });
  }
  
  /**
   * Método para crear el correo
   * @returnm objeto tipo MimeMessage que contiene los datos del correo
   * @throws AddressException
   * @throws MessagingException
   */
  private MimeMessage createMail() throws AddressException, MessagingException {
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
    message.setSubject(subject);
    message.setText(body);
    return message;
  }
  
  private MimeMessage createMail(String url) throws AddressException, MessagingException {
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(userMail));
    message.setSubject(subject);
    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText(body);
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    messageBodyPart = new MimeBodyPart();
    File file = new File(url);
    DataSource source = new FileDataSource(file);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(file.getName());
    multipart.addBodyPart(messageBodyPart);
    message.setContent(multipart);
    return message;
  }
  /**
   * Método para enviar el correo
   * @return
   * @throws MessagingException
   */
  public boolean sendMail() throws MessagingException {
    setMailServer();
    MimeMessage message = createMail();
    Transport.send(message);
    System.out.println("EXITO");
    return true;
  }
  
  public boolean sendMail(String url) throws MessagingException {
    setMailServer();
    MimeMessage message = createMail(url);
    Transport.send(message);
    System.out.println("EXITO");
    return true;
  }
}
