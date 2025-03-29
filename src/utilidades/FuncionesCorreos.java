package utilidades;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FuncionesCorreos {
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        /**
         * Código que nos facilita Eladio para enviar el correo desde java.
         * @author: Flor Canillo
         */
        String remitente = "florcanillopardo@gmail.com";
        String clave = "xulk rmhy kpaa kbom";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception me) {
            me.printStackTrace();
        }
    }

    public static String correoEnviar(String correoUsuarioDestinatario) {
        /**
         * Aquí especifico el destinatario, asunto y cuerpo del correo.
         * Llamo a la función enviarConGMail para que se mande el correo.
         * @param codigo en esta variable se almacena lo que hace la función Contrasenia.
         * @param destinatario es el destinatario del correo, en este caso he utilizado mi correo personal.
         * @param asunto es el asunto del correo.
         * @param cuerpo es el cuerpo del correo.
         * @return devuelve el código de verificación.
         * @author: Flor Canillo
         */
        String codigo = Contrasenia();
        String destinatario = correoUsuarioDestinatario; // Destinatario del mensaje
        String asunto = "[Eggplant Starter] Código de verificación.";
        String cuerpo = "<h1>Este es el código</h1>" + codigo;
        enviarConGMail(destinatario, asunto, cuerpo);
        return codigo;
    }

    public static String Contrasenia() {
        /**
         * Aquí genero el un código aleatorio entre 1000 y 9999.
         * @param codigoFinal paso el código a un string.
         * @param codigoVerificacion genero el número aleatorio.
         * @return devuelve el código de verificación pasado a string.
         * @author: Flor Canillo
         */
        int codigoVerificacion = (int) (Math.random() * 9000) + 1000;
        String codigoFinal = Integer.toString(codigoVerificacion);
        return codigoFinal;
    }
}
