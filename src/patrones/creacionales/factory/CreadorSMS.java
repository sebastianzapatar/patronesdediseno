package patrones.creacionales.factory;

// Subclase creadora concreta enfocada en fabricar notificaciones tipo SMS
public class CreadorSMS extends CreadorNotificaciones {

    // Sobrescribe el Factory Method de la superclase
    @Override
    public Notificacion crearNotificacion() {
        // Inicializa y devuelve la instancia del producto concreto NotificacionSMS
        // Toda la lógica de creación para SMS se aísla en esta clase
        return new NotificacionSMS();
    }
}
