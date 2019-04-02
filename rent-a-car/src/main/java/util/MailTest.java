package util;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class MailTest {

  public static void main(String[] args) throws AddressException, MessagingException {
    Mail mail = new Mail("SuCorreo", "SuPassword","marcosmh13@hotmail.es", "Test", "Hello World!");
    mail.sendMail();

  }

}
