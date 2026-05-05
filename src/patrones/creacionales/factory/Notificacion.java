package patrones.creacionales.factory;

// Interfaz producto que define el comportamiento común de todas las notificaciones
public interface Notificacion {
    // Método abstracto que toda notificación concreta deberá implementar
    // Recibe el texto a enviar y el identificador del destinatario (correo o número)
    void enviar(String mensaje, String destinatario);
}
