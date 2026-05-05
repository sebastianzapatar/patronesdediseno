package patrones.creacionales.factory;

// Producto concreto que representa una notificación enviada por correo electrónico
public class NotificacionEmail implements Notificacion {
    
    // Implementación obligatoria del método enviar definido en la interfaz
    @Override
    public void enviar(String mensaje, String destinatario) {
        // Simulamos la conexión con un servidor SMTP
        System.out.println("-> Conectando al servidor SMTP para Email...");
        // Imprimimos la simulación del envío del mensaje utilizando formato HTML
        System.out.println("-> Enviando Email a [" + destinatario + "]: <html><body>" + mensaje + "</body></html>");
    }
}
