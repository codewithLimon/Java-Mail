package org.example;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        String email_to;
        System.out.println("Email: ");
        email_to=sc.nextLine();

        Email_Verifer emailVerifer=new Email_Verifer();


        if(emailVerifer.check_mail(email_to).equals("valid")){
            String email = "your mail";
            String password = "your password";
            String to = email_to;
            String subject = "Nothing";
            String message = "Greetings from wayout!";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "*");


            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            });

            try {
                Message mimeMessage = new MimeMessage(session);
                mimeMessage.setFrom(new InternetAddress(email));
                mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(message);

                Transport.send(mimeMessage);

                System.out.println("Email sent successfully!");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}