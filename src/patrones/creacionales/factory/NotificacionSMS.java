package patrones.creacionales.factory;

// Producto concreto que representa una notificación enviada por mensaje de texto corto (SMS)
public class NotificacionSMS implements Notificacion {

    // Implementación obligatoria del método enviar definido en la interfaz base
    @Override
    public void enviar(String mensaje, String destinatario) {
        // Simulamos la conexión con una API de operadora telefónica (ej. Twilio)
        System.out.println("-> Conectando a la pasarela de telefonía móvil...");
        // Imprimimos la simulación del envío del mensaje como texto plano a un número de teléfono
        System.out.println("-> Enviando SMS al numero [" + destinatario + "]: " + mensaje);
    }
}
