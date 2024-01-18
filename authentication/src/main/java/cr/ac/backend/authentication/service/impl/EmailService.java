package cr.ac.backend.authentication.service.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;
@Service
public class EmailService {

    private JavaMailSender emailSender;




    public Date sendForgotPasswordEmail(String to, String token) {
        emailSender= new JavaMailSender() {
            @Override
            public void send(SimpleMailMessage simpleMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMessages) throws MailException {

            }

            @Override
            public MimeMessage createMimeMessage() {
                return null;
            }

            @Override
            public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
                return null;
            }

            @Override
            public void send(MimeMessage mimeMessage) throws MailException {

            }

            @Override
            public void send(MimeMessage... mimeMessages) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

            }
        } ;

        MimeMessage message = emailSender.createMimeMessage();
        String html = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Recuperación de Contraseña</title>" +
                "<meta charset=\"utf-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<style type=\"text/css\">" +
                "body {" +
                "font-family: Arial, sans-serif;" +
                "font-size: 16px;" +
                "line-height: 1.5;" +
                "margin: 0;" +
                "padding: 0;" +
                "background-color: #f2f2f2;" +
                "color: #333;" +
                "}" +
                ".container {" +
                "width: 100%;" +
                "max-width: 600px;" +
                "margin: 0 auto;" +
                "padding: 20px;" +
                "background-color: #fff;" +
                "box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);" +
                "}" +
                "h1 {" +
                "font-size: 24px;" +
                "margin-bottom: 20px;" +
                "color: #333;" +
                "text-align: center;" +
                "}" +
                "p {" +
                "margin-bottom: 10px;" +
                "color: #333;" +
                "}" +
                ".button__container {" +
                "text-align: center;" +
                "}" +
                ".button {" +
                "display: inline-block;" +
                "padding: 10px 20px;" +
                "background-color: #f44336;" +
                "color: #fff;" +
                "margin: 0 auto;" +
                "text-decoration: none;" +
                "text-align: center;" +
                "border-radius: 4px;" +
                "margin-bottom: 20px;" +
                "}" +
                ".button:hover {" +
                "background-color: #e53935;" +
                "}" +
                ".footer {" +
                "background-color: #333;" +
                "color: #fff;" +
                "padding: 20px;" +
                "margin-top: 40px;" +
                "font-size: 14px;" +
                "text-align: center;" +
                "}" +
                ".footer__texto {" +
                "margin: 0;" +
                "color: #fff;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "" +
                "<div class=\"container\">" +
                "<h1>Recuperación de Contraseña</h1>" +
                "<p>Hola,</p>" +
                "<p>Hemos recibido una solicitud de recuperación de contraseña para tu cuenta. Si no has realizado esta solicitud, puedes ignorar este correo electrónico.</p>" +
                "<p>Si deseas continuar con la recuperación de contraseña, haz clic en el botón a continuación:</p>" +
                "<div class=\"button__container\">" +
                "<a href=\"http://localhost:9395/forgot-password/email?token=" + token + "\" class=\"button\">Recuperar Contraseña</a>" +
                "</div>" +
                "<p>Este enlace caducará en 24 horas.</p>" +
                "<p>Gracias,</p>" +
                "<p>El equipo de soporte</p>" +
                "</div>" +
                "" +
                "<div class=\"footer\">" +
                "<p class=\"footer__texto\">Este correo electrónico es generado automáticamente. Por favor, no respondas a este mensaje.</p>" +
                "</div>" +
                "" +
                "</body>" +
                "</html>";
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("Recuperación de contraseña");
            helper.setText(html, true);
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
