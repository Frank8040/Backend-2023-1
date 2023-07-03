package devaperu.pe.mensaje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarCorreo(String destinatario, String asunto, String contenido, String telefono) {
         String mensajeCompleto = contenido + "\nTeléfono: " + telefono;
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(mensajeCompleto);
        javaMailSender.send(mensaje);
    }
}
