package patrones.creacionales.factory;

// Clase abstracta "Creador" (Creator) central en el patrón Factory Method
public abstract class CreadorNotificaciones {

    // El "Factory Method" puro: abstracto para forzar a las subclases a implementarlo
    // Su trabajo es instanciar y retornar un objeto de la interfaz Notificacion
    public abstract Notificacion crearNotificacion();

    // Método de negocio (operación principal) que utiliza el objeto creado por la fábrica
    // Este código base no sabe qué clase concreta está usando, solo confía en la interfaz
    public void procesarYEnviar(String mensaje, String destinatario) {
        // 1. Invoca al método de fábrica para obtener el producto correcto (Email, SMS, etc.)
        Notificacion notificacion = crearNotificacion();
        
        // 2. Ejecuta lógica general de pre-procesamiento de negocio (opcional)
        System.out.println(">> [SISTEMA] Preparando metadatos para el envío...");
        
        // 3. Usa el objeto instanciado de manera polimórfica para cumplir la misión
        notificacion.enviar(mensaje, destinatario);
    }
}
